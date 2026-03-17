public class HelloApp {
    public static void main(String[] args) {
        // UC4: Accept multiple names as command-line arguments or use default "World"
        String names = (args.length > 0) ? String.join(", ", args) : "World";
        System.out.println("Hello, " + names + "!");
    }
}
