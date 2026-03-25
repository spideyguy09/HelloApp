public class HelloApp {
    public static void main(String[] args) {
        // UC5: Accept multiple names using enhanced for loop or use default "World"
        if (args.length == 0) {
            System.out.println("Hello, World!");
        } else {
            StringBuilder nameBuilder = new StringBuilder();
            for (String name : args) {
                if (nameBuilder.length() > 0) {
                    nameBuilder.append(", ");
                }
                nameBuilder.append(name);
            }
            System.out.println("Hello, " + nameBuilder.toString() + "!");
        }
    }
}
