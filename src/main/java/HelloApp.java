public class HelloApp {
    public static void main(String[] args) {
        // UC7: Accept multiple names using String.join() method or use default "World"
        String names = (args.length == 0) ? "World" : String.join(", ", args);
        System.out.println("Hello, " + names + "!");
    }
}
