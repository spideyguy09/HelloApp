public class HelloApp {
    public static void main(String[] args) {
        // UC6: Accept multiple names using enhanced for loop and substring to remove trailing delimiter
        if (args.length == 0) {
            System.out.println("Hello, World!");
        } else {
            StringBuilder nameBuilder = new StringBuilder();
            for (String name : args) {
                nameBuilder.append(name);
                nameBuilder.append(", ");
            }
            String names = nameBuilder.substring(0, nameBuilder.length() - 2);
            System.out.println("Hello, " + names + "!");
        }
    }
}
