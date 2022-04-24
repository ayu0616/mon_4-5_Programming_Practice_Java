public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(seyHelloTo("Java"));
        System.out.println(seyHelloTo("Java", 5));
    }

    public static String seyHelloTo(String name) {
        return "Hello " + name + "!";
    }

    public static String seyHelloTo(String name, int nExcl) {
        return "Hello " + name + "!".repeat(nExcl);
    }
}
