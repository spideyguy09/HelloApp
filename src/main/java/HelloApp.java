public class HelloApp {
    public static void main(String[] args) {
        // UC2: Accept a name from command-line argument and display personalized greeting
        if (args.length > 0) {
            String name = args[0];
            System.out.println("Hello, " + name + "!");
        } else {
            System.out.println("Hello, World!");
        }
    }
}
