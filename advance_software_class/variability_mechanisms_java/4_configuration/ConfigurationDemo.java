interface SortStrategy {
    void sort(int[] arr);
    String name();
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = tmp;
                }
    }
    @Override public String name() { return "Bubble Sort"; }
}

class SelectionSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx]) minIdx = j;
            int tmp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = tmp;
        }
    }
    @Override public String name() { return "Selection Sort"; }
}

class InsertionSort implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j+1] = arr[j]; j--; }
            arr[j+1] = key;
        }
    }
    @Override public String name() { return "Insertion Sort"; }
}

class Sorter {
    private SortStrategy strategy;

    void configure(SortStrategy strategy) {
        this.strategy = strategy;
        System.out.println("[Config] Strategy set to: " + strategy.name());
    }

    void sort(int[] arr) {
        if (strategy == null) { System.out.println("No strategy configured!"); return; }
        strategy.sort(arr);
    }
}

public class ConfigurationDemo {

    static void printArray(int[] arr) {
        System.out.print("  Array: [");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: CONFIGURATION ===\n");

        Sorter sorter = new Sorter();
        int[] data;

        data = new int[]{64, 34, 25, 12, 22, 11, 90};
        sorter.configure(new BubbleSort());
        System.out.print("Before:"); printArray(data);
        sorter.sort(data);
        System.out.print("After: "); printArray(data);

        System.out.println();

        data = new int[]{64, 34, 25, 12, 22, 11, 90};
        sorter.configure(new SelectionSort());
        System.out.print("Before:"); printArray(data);
        sorter.sort(data);
        System.out.print("After: "); printArray(data);

        System.out.println();

        data = new int[]{64, 34, 25, 12, 22, 11, 90};
        sorter.configure(new InsertionSort());
        System.out.print("Before:"); printArray(data);
        sorter.sort(data);
        System.out.print("After: "); printArray(data);
    }
}
