class InheritanceDemo {

    static void check(int age) throws Exception {

        if (age < 18) {
            throw new Exception("Not eligible");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        try {
            check(15);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }
}
