## The Challenge

Mark Erbergzuck was very happy with the work you did in the previous chapter. You built a basic Bank Statements Analyzer as a minimum viable product. Because of this success Mark Erbergzuck thinks that your product can be taken further and asks you to build a new version that support multiple features.

## The Goal

Providing functionality for searching for different kinds of transactions, supporting multiple formats, processors, and exporting the results into a nice report with different formats such as text and HTML.

going deeper in the software development quest. Learning about the Open/Closed principle, which is essential for adding flexibility to our codebase and improving code maintenance.
We will learn also general guidelines for when it makes sense to introduce interfaces, as well as other gotchas to avoid high coupling.
We will also learn about the use of exceptions in Java when it makes sense to include them as part of the APIs you define and when it doesn’t.
Finally, we will learn how to systematically build a Java project using an established build tool like Maven and Gradle.

### **Open/Closed Principle:**

Let’s start simple. You will implement a method that can find all the transactions over a certain amount. The first question is where should you declare this method? You could create a separate BankTransactionFinder class that will contain a simple findTransactions() method. However, you also declared a class BankTransactionProcessor in the previous chapter. So what should you do? In this case, there aren’t a lot of benefits in declaring a new class every time you need to add one single method. This actually adds complexity to your whole project, as it introduces a pollution of names that makes it harder to understand the relationships between these different behaviors. Declaring the method inside BankTransactionProcessor helps with discoverability as you immediately know that this is the class that groups all methods that do some form of processing. Now that you’ve decided where to declare it, you can implement it.

## **Takeaways**

- The Open/Closed Principle promotes the idea of being able to change the behavior of a method or class without having to modify the code.

- The Open/Closed Principle reduces fragility of code by not changing existing code, promotes reusability of existing code, and promotes decoupling, which leads to better code maintenance.

- God interfaces with many specific methods introduce complexity and coupling.

- An interface that is too granular with single methods can introduce the opposite of cohesion.

- You should not be worried about adding descriptive method names to help readability and comprehension of your API .

- Returning void as a result of an operation makes it difficult to test its behavior.

- Exceptions in Java contribute to documentation, type safety, and separation of concerns.

- Use checked exceptions sparingly rather than the default as they can cause significant clutter.

- Overly specific exceptions can make software development unproductive.

- The Notification Pattern introduces a domain class to collect errors.

- Do not ignore an exception or catch the generic Exception as you will lose the benefits of diagnosing the root of the problem.

- A build tool automates the repetitive tasks in the software development life cycle including building, testing, and deploying your application.

- Maven and Gradle are two popular build tools used in the Java community.
