# HelloApp Use Cases Documentation

## Use Case Overview

The Hello App evolves step by step from a fixed console message to a modular, persistent, and extensible application.

### UC1: Print a basic greeting in the console.
### UC2: Accept one name via command-line input and greet that user.
### UC3: Support optional argument handling with a default greeting path.
### UC4: Handle multiple command-line names in one execution.
### UC5: Read a single name from standard input.
### UC6: Read and process multiple names from standard input.
### UC7: Store entered names in memory and list them on request.
### UC8: Add removal support for stored names.
### UC9: Extract input-processing logic into dedicated methods.
### UC10: Move name-management responsibilities into a separate class.
### UC11: Persist names to storage and reload them across runs.
### UC12: Render greeting text in banner-style output for enhanced display.

---

## UC1: Display "Hello World" in Console

### Description
Implement the most basic Java application that prints "Hello World" to the console. This use case serves as the foundation for all future enhancements and helps students understand the basic structure of a Java program, including the main method and console output.

### Disadvantages of Previous Use Case
N/A - This is the first use case.

### Preconditions
- Java 17 or higher is installed
- Maven 3.6.0 or higher is installed
- The HelloApp project is created with the standard Maven directory structure

### Main Flow
1. Create the `HelloApp.java` file in `src/main/java/` directory
2. Define the `main` method as the entry point of the application
3. Use `System.out.println()` to print "Hello World" to the console
4. Compile and run the application to verify the output

### Post Conditions
- The application successfully compiles without errors
- When executed, the application displays "Hello World" in the console
- The program terminates after printing the message

### Hints
1. The `main` method must have the signature: `public static void main(String[] args)`
2. Use `System.out.println()` to print to the console with a newline
3. The `String[] args` parameter is required as part of the standard main method signature, even if not used in this use case
4. The `void` return type indicates the method doesn't return any value

### Code Snippet Example

```java
public class HelloApp {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

### Concepts Learned

#### 1. **public static void main(String[] args)**
- **public**: The method is accessible from outside the class
- **static**: The method belongs to the class itself, not to an instance of the class
- **void**: The method does not return any value
- **String[] args**: A parameter that holds command-line arguments passed to the program

#### 2. **void Return Type**
The `void` return type indicates that the `main` method does not return any value. It is a standard convention for the entry point of a Java application, as it is not expected to return any data to the caller (the JVM).

#### 3. **String Array Parameter**
The `String[] args` parameter holds command-line arguments passed to the program. In this use case, we are not utilizing any command-line arguments, but it is a standard part of the main method signature. It allows for future expansion where the program can accept input from the user when executed.

#### 4. **System.out.println()**
The `System.out.println()` method is the standard output stream for printing. It is used to display messages to the console. In this case, it prints "Hello World". The `println` method adds a newline after the message, so each call to `println` will print on a new line.

**Breakdown of System.out.println("Hello World"):**
- `System`: A final class in the `java.lang` package that provides access to system resources and standard input/output streams
- `out`: A static member of the `System` class that represents the standard output stream (console)
- `println`: A method of the `PrintStream` class (the type of `System.out`) that prints the specified message followed by a newline character

#### 5. **Program Execution Flow**
When the program is executed, the JVM looks for the `main` method as the starting point. It executes the code within the `main` method sequentially. In this case, it will execute the `System.out.println("Hello World")` statement, which outputs "Hello World" to the console, and then the program will terminate since there are no further instructions.

### Testing
To test this use case:
```bash
mvn clean compile
java -cp target/classes HelloApp
```

Expected Output:
```
Hello World
```

---

## UC2: Display "Hello" with Command-Line Argument

### Description
The app accepts a user's name as a command-line argument and displays a personalized greeting. This enhances the basic functionality of UC1 by allowing user input to customize the output. If no name is provided, a default greeting is displayed.

### Disadvantages of Previous Use Case
UC1 is limited because it only displays a static message "Hello World". To make the application more interactive and useful, it should accept user input and personalize the output based on that input.

### Preconditions
- Java 17 or higher is installed
- HelloApp is compiled and ready to run
- User can pass command-line arguments when executing the program

### Main Flow
1. User runs the application with a name argument: `java HelloApp John`
2. App reads the name from the `args[0]` parameter
3. App displays "Hello, John!" to the console
4. App terminates

**Alternative Flow (No Arguments):**
1. User runs the application without arguments: `java HelloApp`
2. App checks the `args.length` and determines no arguments were provided
3. App displays "Hello, World!" to the console
4. App terminates

### Post Conditions
- Personalized greeting is displayed based on the command-line argument provided
- If no argument is provided, a default greeting is displayed
- The program behaves predictably in both cases

### Hints for Implementing UC2
1. Command-line arguments are passed to the main method as the `String[] args` parameter
2. Access the first argument using `args[0]`
3. Always check if arguments exist before accessing them to avoid `ArrayIndexOutOfBoundsException`
4. Use string concatenation with the `+` operator to combine strings
5. Test with different names to verify the output

### Code Snippet Example

```java
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
```

### Example Output

**Input with argument:**
```bash
java HelloApp Alice
```
Output:
```
Hello, Alice!
```

**Input without argument:**
```bash
java HelloApp
```
Output:
```
Hello, World!
```

### Concepts Learned

#### 1. **Command-Line Arguments**
Parameters passed to the program when it is executed. They are accessible through the `args` array in the main method, allowing the program to receive input without prompting the user interactively.

#### 2. **Array Length**
The `args.length` property returns the number of command-line arguments provided. Checking this before accessing array elements prevents runtime errors like `ArrayIndexOutOfBoundsException`.

#### 3. **Array Indexing**
Arrays are zero-indexed in Java, so the first argument is accessed using `args[0]`, the second using `args[1]`, and so on. This is a fundamental concept for working with arrays and collections.

#### 4. **String Concatenation**
The `+` operator combines strings together. For example, `"Hello, " + name + "!"` concatenates three parts into a single string. This is a simple but powerful way to build dynamic output.

#### 5. **Conditional Logic**
Using `if-else` statements to check conditions and execute different code paths based on whether arguments are provided. This allows the program to behave differently depending on user input.

#### 6. **Error Prevention**
Always check the length of the `args` array before accessing its elements to prevent `ArrayIndexOutOfBoundsException` at runtime. This is a critical practice for defensive programming.

#### 7. **Default Values**
Providing a fallback message ("Hello, World!") when no command-line arguments are given ensures the program behaves predictably even without user input.

#### 8. **Array Handling**
Understanding how to work with arrays in Java, including accessing elements and checking their length, is fundamental for handling command-line arguments effectively.

### Testing
To test this use case:
```bash
# Compile the project
mvn clean compile

# Test with a name argument
java -cp target/classes HelloApp John

# Test without arguments
java -cp target/classes HelloApp
```

Expected Output:
```
Hello, John!
Hello, World!
```

---

## Next Steps
Proceed to UC3 to support optional argument handling with a default greeting path.

