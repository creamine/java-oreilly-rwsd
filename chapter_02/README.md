## The Challenge

The FinTech industry is really hot right now. Mark Erbergzuck realizes that he spends a lot of money on different purchases and would benefit from automatically summarizing his expenses. He receives monthly statements from his bank, but he finds them a bit overwhelming. He has tasked you with developing a piece of software that will automate the processing of his bank statements so he can get better insights into his finances. Challenge accepted!

## The Goal

Learning the foundations about good software development before learning more advanced techniques in the next few chapters.

### **Single Responsibility Principle**: The Single Responsibility Principle (SRP) is a general software development guideline to follow that contributes to writing code that is easier to manage and maintain.

- A class has responsibility over a single functionality
- There is only one single reason for a class to change.

### **KISS Principle**: Keep It Short and Simple.

### **God Class**: Putting all of your code in one file, you end up with one giant class making it harder to understand its purpose because that class is responsible for everything.

### **Code Duplication**: Duplicating a certain logic, hardcoding it in multiple places.

### **DRY**: Don't Repeat Yourself.

## Class-Level & Method-Level Cohesion:

### Six common ways to group methods:

- **Functional:** This is generally a good way to achieve high cohesion because the methods are working together, so it makes sense to group them so they are easier to locate and understand. The danger with functional cohesion is that it may be tempting to have a profusion of overly simplistic classes grouping only a single method. Going down the road of overly simplistic classes adds unnecessary verbosity and complexity because there are many more classes to think about.
  Example:
- The methods parseFrom() and parseLinesFrom() are solving a defined task: parse the lines in the CSV format. In fact, the method parseLinesFrom() uses the method parseFrom().

- **Informational:** Another reason to group methods is because they work on the same data or domain object. Say you needed a way to create, read, update, and delete BankTransaction objects (CRUD operations); you may wish to have a class dedicated for these operations. The downside of this approach is that this kind of cohesion can group multiple concerns together, which introduces additional dependencies for a class that only uses and requires some of the operations.

- **Utility:** You may be tempted to group different unrelated methods inside a class. This happens when it is not obvious where the methods belong so you end up with a utility class that is a bit like a jack of all trades. This is generally to be avoided because you end up with low cohesion. The methods are not related, so the class as a whole is harder to reason about. In addition, utility classes exhibit a poor discoverability characteristic. You want your code to be easy to find and easy to understand how it is supposed to be used. Utility classes go against this principle because they contain different methods that are unrelated without a clear categorization.

- **Logical:** Say you needed to provide implementations for parsing from CSV, JSON, and XML. You may be tempted to group the methods responsible for parsing the different format inside one class. In fact, the methods are logically categorized to do “parsing.” However, they are different by nature and each of the methods would be unrelated. Grouping them would also break the SRP, which you learned about earlier, because the class is responsible for multiple concerns. There are techniques to solve the problem of providing different implementations for parsing while also keeping high cohesion.

- **Sequential:** Say you need to read a file, parse it, process it, and save the information. You may group all of the methods in one single class. After all the output of reading the file becomes the input to the parsing, the output of parsing becomes the input to the processing step, and so on. Unfortunately, in practice this means that the class grouping the methods has multiple reasons to change and is therefore breaking the SRP. A better approach is to break down each responsibility inside individual, cohesive classes.

- **Temportal:** A temporally cohesive class is one that performs several operations that are only related in time. A typical example is a class that declares some sort of initialization and clean-up operations

| Level of Cohesion               | Pro                                             | Con                                                    |
| ------------------------------- | ----------------------------------------------- | ------------------------------------------------------ |
| Functional (high cohesion)      | Easy to understand                              | Can lead to overly simplistic classes                  |
| Informational (medium cohesion) | Easy to maintain                                | Can lead to unnecessary dependencies                   |
| Sequential (medium cohesion)    | Easy to locate related operations               | Encourages violation of SRP                            |
| Logical (medium cohesion)       | Provides some form of high-level categorization | Encourages violation of SRP                            |
| Utility (low cohesion)          | Simple to put in place                          | Harder to reason about the responsibility of the class |
| Temporal (low cohesion)         | N/A                                             | Harder to understand and use individual operations     |
