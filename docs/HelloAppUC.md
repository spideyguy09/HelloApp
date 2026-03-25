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
Proceed to UC5 to read a single name from standard input using an enhanced for loop.

---

## UC5: Display "Hello" with Multiple Command-Line Arguments using Enhanced For Loop or Default Message

### Description
The app accepts zero or more command-line arguments and prints a greeting. It uses an enhanced for loop (for-each loop) to process multiple names. If no arguments are provided, it displays the default greeting: "Hello, World!".

### Disadvantages of Previous Use Case
UC4 used a traditional indexed `for` loop (via `String.join`), which is more verbose for simple array iteration. For read-only traversal of all arguments, an enhanced for loop is cleaner and easier to maintain.

### Preconditions
- Java 17 or higher is installed
- HelloApp is compiled and ready to run
- App is launched with zero or more command-line arguments

### Main Flow
1. User runs the application with names (or without names)
2. App checks whether arguments are provided
3. If no arguments are provided, app prints "Hello, World!"
4. If arguments are provided, app iterates through `args` using an enhanced for loop
5. App builds a comma-separated list of names using `StringBuilder`
6. App prints a single greeting: "Hello, `<names>`!"
7. App terminates

### Post Conditions
- A greeting is displayed with all provided names, or defaults to "Hello, World!" when no arguments are given

### Hints
1. Use `args.length == 0` to detect missing arguments
2. Use `for (String name : args)` to iterate through all arguments
3. Use `StringBuilder` for efficient string construction
4. Avoid trailing commas by appending delimiter conditionally
5. Test with 0, 1, and multiple arguments

### Code Snippet Example

```java
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
```

### Example Output

**Input with no arguments:**
```bash
java HelloApp
```
Output:
```
Hello, World!
```

**Input with one argument:**
```bash
java HelloApp Alice
```
Output:
```
Hello, Alice!
```

**Input with multiple arguments:**
```bash
java HelloApp Alice Bob Charlie
```
Output:
```
Hello, Alice, Bob, Charlie!
```

### Concepts Learned

#### 1. **Enhanced For Loop (For-Each)**
Cleaner iteration over array elements without index management. The syntax `for (String name : args)` automatically handles iteration bounds, making code more readable and less error-prone.

#### 2. **Default Handling**
Graceful behavior when input is missing ensures the program always produces valid output regardless of how it is invoked.

#### 3. **Array Length Check**
Using `args.length == 0` prevents invalid assumptions about input presence and is the foundation of safe argument handling.

#### 4. **StringBuilder**
`StringBuilder` is a mutable sequence of characters used for efficient string construction. Unlike the `+` operator which creates new `String` objects each time, `StringBuilder.append()` modifies the same object in place, reducing memory overhead.

#### 5. **Conditional Delimiter Logic**
Checking `nameBuilder.length() > 0` before appending `", "` ensures no leading comma appears in the output. This is the cleanest way to avoid trailing or leading delimiters when building comma-separated lists.

#### 6. **Readable Control Flow**
Separating the no-input and input-present paths into distinct `if-else` branches improves maintainability and makes the intent of each path immediately clear.

### Testing
```bash
mvn clean compile

# Test with no arguments
java -cp target/classes HelloApp

# Test with one argument
java -cp target/classes HelloApp Alice

# Test with multiple arguments
java -cp target/classes HelloApp Alice Bob Charlie
```

Expected Output:
```
Hello, World!
Hello, Alice!
Hello, Alice, Bob, Charlie!
```

---

## Next Steps
Proceed to UC6 to read and process multiple names using substring to remove the trailing delimiter.

---

## UC6: Display "Hello" with Multiple Command-Line Arguments using substring to Remove Trailing Delimiter

### Description
The app accepts zero or more command-line arguments and prints a greeting. It uses an enhanced for loop to process multiple names and the `substring` method to remove the trailing delimiter. If no arguments are provided, it displays the default greeting: "Hello, World!".

### Disadvantages of Previous Use Case
UC5 used a conditional check (`if (nameBuilder.length() > 0)`) to avoid appending a leading delimiter. While functional, UC6 offers a cleaner alternative by appending the delimiter after every element uniformly, then using `substring()` to remove the trailing characters. This separates the construction phase from the cleanup phase, making the intent clearer.

### Preconditions
- Java 17 or higher is installed
- HelloApp is compiled and ready to run
- App is launched with zero or more command-line arguments

### Main Flow
1. User runs the application with names (or without names)
2. App checks whether arguments are provided
3. If no arguments are provided, app prints "Hello, World!"
4. If arguments are provided, app iterates through `args` using an enhanced for loop
5. App appends each name followed by `", "` to a `StringBuilder`
6. App uses `substring()` to remove the trailing `", "`
7. App prints the greeting: "Hello, `<names>`!"
8. App terminates

### Post Conditions
- A greeting is displayed with all provided names separated by commas, or defaults to "Hello, World!" when no arguments are given

### Hints
1. Use `args.length == 0` to detect missing arguments
2. Use `for (String name : args)` to iterate through all arguments
3. Always append the same delimiter after each name, including the last one
4. Use `substring(0, nameBuilder.length() - 2)` to remove the last two characters (`", "`)
5. Check `nameBuilder.length() > 0` before calling `substring()` to avoid errors
6. Test with 0, 1, and multiple arguments

### Code Snippet Example

```java
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
```

### Example Output

**Input with no arguments:**
```bash
java HelloApp
```
Output:
```
Hello, World!
```

**Input with one argument:**
```bash
java HelloApp Alice
```
Output:
```
Hello, Alice!
```

**Input with multiple arguments:**
```bash
java HelloApp Alice Bob Charlie
```
Output:
```
Hello, Alice, Bob, Charlie!
```

### Concepts Learned

#### 1. **substring() Method**
`substring(int beginIndex, int endIndex)` extracts a portion of a string from `beginIndex` (inclusive) to `endIndex` (exclusive). Using `substring(0, nameBuilder.length() - 2)` removes the final `", "` appended after the last name — a clean post-construction cleanup pattern.

Breakdown of `nameBuilder.substring(0, nameBuilder.length() - 2)`:
- `nameBuilder.length()` — total character count in the `StringBuilder`
- `nameBuilder.length() - 2` — position just before the last `", "`
- `substring(0, nameBuilder.length() - 2)` — extracts everything except the trailing delimiter

#### 2. **String Immutability vs StringBuilder Mutability**
Strings in Java are immutable — once created, they cannot be changed. `StringBuilder` is mutable and allows in-place modifications. Calling `substring()` on a `StringBuilder` returns a new `String` without modifying the original builder.

#### 3. **Enhanced For Loop Simplicity**
The `for (String name : args)` loop is cleaner than indexed loops when only element values (not indices) are needed. It eliminates boundary conditions and makes code more readable.

#### 4. **StringBuilder Efficiency**
`StringBuilder` avoids creating multiple intermediate `String` objects during concatenation. Each `append()` modifies the existing object in memory, making it more efficient than using `+` in a loop.

#### 5. **Delimiter Handling Pattern**
Appending the same delimiter after every element (uniformly) and then stripping it at the end is a common and readable pattern in Java — it avoids conditional checks inside the loop.

#### 6. **Conditional Cleanup**
Always check `nameBuilder.length() > 0` before calling `substring()` to prevent exceptions on empty strings. This is a key defensive programming practice.

### Testing
```bash
mvn clean compile

# Test with no arguments
java -cp target/classes HelloApp

# Test with one argument
java -cp target/classes HelloApp Alice

# Test with multiple arguments
java -cp target/classes HelloApp Alice Bob Charlie
```

Expected Output:
```
Hello, World!
Hello, Alice!
Hello, Alice, Bob, Charlie!
```

---

## Next Steps
Proceed to UC7 to handle multiple names using the built-in `String.join()` method.

---

## UC7: Display "Hello" with Multiple Command-Line Arguments using String.join() Method or Default Message

### Description
The app accepts zero or more command-line arguments and prints a greeting. It uses the `String.join()` method to efficiently concatenate multiple names with a specified delimiter. If no arguments are provided, it displays the default greeting: "Hello, World!".

### Disadvantages of Previous Use Case
UC6 used `substring()` to remove the trailing delimiter after constructing the string with a loop. While effective, this approach requires multiple steps: building the string, and then removing trailing characters. UC7 uses `String.join()`, a built-in Java utility that directly concatenates strings with a delimiter without requiring any manual loop or cleanup.

### Preconditions
- Java 17 or higher is installed
- HelloApp is compiled and ready to run
- App is launched with zero or more command-line arguments

### Main Flow
1. User runs the application with names (or without names)
2. App checks whether arguments are provided
3. If no arguments are provided, app uses `"World"` as the name text
4. If arguments are provided, app uses `String.join(", ", args)` to concatenate all names
5. App prints the greeting: "Hello, `<names>`!"
6. App terminates

### Post Conditions
- A greeting is displayed with all provided names separated by commas, or defaults to "Hello, World!" when no arguments are given

### Hints
1. Use `args.length == 0` to detect missing arguments
2. `String.join()` accepts a delimiter as the first parameter and an array or variable args as the second parameter
3. `String.join()` automatically handles delimiter placement — no trailing delimiter is added
4. A ternary operator makes this a single, readable line
5. Test with 0, 1, and multiple arguments and compare readability with UC5 and UC6

### Code Snippet Example

```java
public class HelloApp {
    public static void main(String[] args) {
        // UC7: Accept multiple names using String.join() method or use default "World"
        String names = (args.length == 0) ? "World" : String.join(", ", args);
        System.out.println("Hello, " + names + "!");
    }
}
```

### Example Output

**Input with no arguments:**
```bash
java HelloApp
```
Output:
```
Hello, World!
```

**Input with one argument:**
```bash
java HelloApp Alice
```
Output:
```
Hello, Alice!
```

**Input with multiple arguments:**
```bash
java HelloApp Alice Bob Charlie
```
Output:
```
Hello, Alice, Bob, Charlie!
```

### Concepts Learned

#### 1. **String.join() Method**
`String.join(String delimiter, String... elements)` concatenates strings with a specified delimiter. It places the delimiter between elements only — no leading or trailing delimiter is ever added. It was introduced in Java 8 and is part of the `java.lang.String` class.

In `String.join(", ", args)`:
- `", "` — the delimiter placed between each name
- `args` — the array of strings to join
- Returns a single `String` with all names separated by commas and spaces

#### 2. **Static Utility Methods**
`String.join()` is a static method — it belongs to the `String` class and is called without creating a `String` instance. Static utility methods provide convenient functionality and improve code readability.

#### 3. **Method Overloading**
`String.join()` has two overloaded versions:
- `String.join(String delimiter, String... elements)` — for variable arguments or arrays
- `String.join(String delimiter, Iterable<? extends CharSequence> elements)` — for collections like `ArrayList`

Both versions work the same way. This use case uses the first version with the `args` array.

#### 4. **Ternary Operator**
The ternary expression `(args.length == 0) ? "World" : String.join(", ", args)` compactly selects between two outcomes. It is equivalent to an `if-else` block but in a single expression, reducing code length significantly.

#### 5. **No Trailing Delimiter**
`String.join()` never appends a trailing delimiter, unlike the manual loop approaches in UC5 and UC6. This eliminates the need for conditional checks or post-construction cleanup.

#### 6. **Comparison with Previous Approaches**
| Use Case | Technique | Lines of Code |
|----------|-----------|--------------|
| UC5 | Enhanced for loop + conditional delimiter | ~16 |
| UC6 | Enhanced for loop + substring cleanup | ~13 |
| UC7 | String.join() + ternary | ~5 |

`String.join()` achieves the same result with minimal code while being more readable and maintainable.

#### 7. **Readability and Maintainability**
`String.join(", ", args)` directly expresses the intent: "join these strings with this delimiter." This reduces cognitive load and makes the code immediately understandable without tracing loop logic.

#### 8. **Performance**
`String.join()` uses `StringBuilder` internally, so it is just as efficient as the manual `StringBuilder` approach in UC5 and UC6 — but with far cleaner syntax.

### Testing
```bash
mvn clean compile

# Test with no arguments
java -cp target/classes HelloApp

# Test with one argument
java -cp target/classes HelloApp Alice

# Test with multiple arguments
java -cp target/classes HelloApp Alice Bob Charlie
```

Expected Output:
```
Hello, World!
Hello, Alice!
Hello, Alice, Bob, Charlie!
```

---

## Conclusion

Through the progression of UC5 to UC7, we explored three techniques for building comma-separated output from command-line arguments:

- **UC5** — Enhanced for loop with conditional delimiter (readable, explicit control)
- **UC6** — Enhanced for loop with `substring()` cleanup (clean post-construction pattern)
- **UC7** — `String.join()` (most concise, leveraging Java's standard library)

Each use case reduced the code further while introducing important Java concepts. UC7 demonstrates how built-in utility methods can replace manual loop logic entirely, resulting in cleaner, more maintainable code.
