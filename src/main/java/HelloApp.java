public class HelloApp {
    public static void main(String[] args) {
        // UC3: Accept a name from command-line argument or use default "World"
        String name = (args.length > 0) ? args[0] : "World";
        System.out.println("Hello, " + name + "!");
    }
}
