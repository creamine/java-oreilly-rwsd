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

## Coupling

Another important characteristic about the code you write is coupling. Where cohesion is about how related things are in a class, package, or method, coupling is about how dependent you are on other classes. Another way to think about coupling is how much knowledge (i.e., specific implementation) you rely on about certain classes.
Coupling is concerned with how dependent things are. For example, so far the class BankStatementAnalyzer relies on the class BankStatementCSVParser. What if you need to change the parser so it supports statements encoded as JSON entries? What about XML entries? This would be an annoying refactoring! But do not worry, you can decouple different components by using an interface, which is the tool of choice for providing flexibility for changing requirements.

## Testing

You have written some software and it looks like things are working if you execute your application a couple of times. However, how confident are you that your code will always work? What guarantee can you give your client that you have met the requirements? In this section, you will learn about testing and how to write your first automated test using the most popular and widely adopted Java testing framework: JUnit.

### **Automated Testing:**

In automated testing you have a suite of tests that runs automatically without human intervention. This means the tests can be executed quickly when you are introducing changes in the code and you want to increase confidence that the behavior of your software is correct and has not suddenly become unexpected.

#### - CONFIDENCE:

First, performing tests on the software to validate whether the behavior matches the specification gives you confidence that you have met the requirements of your client. You can present the test specifications and results to your client as a guarantee. In a sense, the tests become the specification from your client.

#### - ROBUSTNESS TO CHANGES:

Second, if you introduce changes to your code, how do you know that you have not accidentally broken something? If the code is small you may think problems will be obvious. However, what if you are working on a codebase with millions of lines of code? How confident would you feel about making changes to a colleague’s code? Having a suite of automated tests is very useful to check that you have not introduced new bugs.

#### - PROGRAM COMPREHENSION:

Third, automated tests can be useful to help you understand how the different components inside the source code project works. In fact, tests make explicit the dependencies of different components and how they interact together. This can be extremely useful for quickly getting an overview of your software. Say you are assigned to a new project. Where would you start to get an overview of different components? The tests are a great place to start.

### **Using JUnit:**

Hopefully you are now convinced of the value of writing automated tests. In this section, you will learn how to create your first automated test using a popular Java framework called JUnit. You will see that writing a test takes time. In addition, you will have to think about the longer-term maintenance of the test you write since it is regular code, after all. However, the benefits listed in the previous section far outweigh the downsides of having to write tests. Specifically, you will write unit tests, which verify a small isolated unit of behavior for correctness, such as a method or a small class. Throughout the book you will learn about guidelines for writing good tests. Here you will first get an initial overview for writing a simple test for the BankTransactionCSVParser.

#### - ASSERTIONS:

| Assertion state                               | Purpose                                                                                  |
| --------------------------------------------- | ---------------------------------------------------------------------------------------- |
| Assert.fail(message)                          | Let the method fail. This is useful as a placeholder before you implement the test code. |
| Assert.assertEquals​(expected, actual)        | Test that two values are the same.                                                       |
| Assert.assertEquals​(expected, actual, delta) | Assert that two floats or doubles are equal to within a delta.                           |
| Assert.assertNotNull(object)                  | Assert that an object is not null.                                                       |

### **CODE COVERAGE:**

Code coverage refers to how much of the source code of your software (i.e., how many lines or blocks) is tested by a set of tests. It is generally a good idea to aim for high coverage because it reduces the chance of unexpected bugs. There isn’t a specific percentage that is considered sufficient, but we recommend aiming for 70%–90%.

Popular code coverage tools in Java include JaCoCo, Emma, and Cobertura. In practice, you will see people talking about line coverage, which tells you how many statements the code covered. This technique gives a false sense of having good coverage because conditionals (if, while, for) will count as one statement. However, conditionals have multiple possible paths. You should therefore favor branch coverage, which checks the true and false branch for each conditional.

## **Takeaways**

- God Classes and code duplication lead to code that is hard to reason about and maintain.

- The Single Responsibility Principle helps you write code that is easier to manage and maintain.

- Cohesion is concerned with how how strongly related the responsibilities of a class or method are.

- Coupling is concerned with how dependent a class is on other parts of your code.

- High cohesion and low coupling are characteristics of maintainable code.

- A suite of automated tests increases confidence that your software is correct, makes it more robust for changes, and helps program comprehension.

- JUnit is a Java testing framework that lets you specify unit tests that verify the behavior of your methods and classes.

- Given-When-Then is a pattern for setting up a test into three parts to help understand the tests you implement.
