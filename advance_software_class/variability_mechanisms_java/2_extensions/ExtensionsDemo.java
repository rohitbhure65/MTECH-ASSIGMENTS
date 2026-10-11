import java.util.*;
import java.util.function.Function;

class TextProcessor {
    private String text;

    private List<Function<String, String>> preProcessors  = new ArrayList<>();
    private List<Function<String, String>> postProcessors = new ArrayList<>();

    TextProcessor(String text) { this.text = text; }

    void addPreProcessor(Function<String, String> ext)  { preProcessors.add(ext); }
    void addPostProcessor(Function<String, String> ext) { postProcessors.add(ext); }

    String process() {
        String result = text;

        System.out.println("[Pre-Processing Extensions]");
        for (Function<String, String> ext : preProcessors) result = ext.apply(result);

        System.out.println("\n[Core Processing]");
        System.out.println("  Processing: \"" + result + "\"");

        System.out.println("\n[Post-Processing Extensions]");
        for (Function<String, String> ext : postProcessors) result = ext.apply(result);

        return result;
    }
}

public class ExtensionsDemo {

    static String trim(String s) {
        String r = s.strip();
        System.out.println("  [Trim]     : \"" + r + "\"");
        return r;
    }

    static String toUpper(String s) {
        String r = s.toUpperCase();
        System.out.println("  [UpperCase] : \"" + r + "\"");
        return r;
    }

    static String exclaim(String s) {
        String r = s + "!!!";
        System.out.println("  [Exclaim]   : \"" + r + "\"");
        return r;
    }

    static String bracket(String s) {
        String r = "[ " + s + " ]";
        System.out.println("  [Bracket]   : \"" + r + "\"");
        return r;
    }

    public static void main(String[] args) {
        System.out.println("=== Variability Mechanism: EXTENSIONS ===\n");

        TextProcessor tp = new TextProcessor("  hello world  ");

        tp.addPreProcessor(ExtensionsDemo::trim);
        tp.addPreProcessor(ExtensionsDemo::toUpper);

        tp.addPostProcessor(ExtensionsDemo::exclaim);
        tp.addPostProcessor(ExtensionsDemo::bracket);

        System.out.println("Input: \"  hello world  \"\n");
        String output = tp.process();
        System.out.println("\nFinal Output: \"" + output + "\"");
    }
}
