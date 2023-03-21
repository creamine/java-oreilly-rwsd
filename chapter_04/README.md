## The Challenge

After successfully implementing an advanced Bank Statements Analyzer for Mark Erbergzuck you decide to run some errands—including going to an appointment with your dentist. Dr. Avaj has run her practice successfully for many years. Her happy patients retain their white teeth well into old age. The downside of such a successful practice is that every year more and more patient documents get generated. Every time she needs to find a record of prior treatment, her assistants spend longer and longer searching their filing cabinets.

She realizes that it’s time to automate the process of managing these documents and keeping track of them. Luckily, she has a patient who can do that for her! You are going to help by writing software for her that manages these documents and enables her to find the information that will allow her practice to thrive and grow.

## The Goal

Learning about a variety of different software development principles. Key to the design of managing documents is an inheritance relationship, which means extending a class or implementing an interface. In order to do this the right way you’ll get to understand the **Liskov Substitution Principle**, named after famed computer scientist Barbara Liskov.

Your understanding of when to use inheritance will get fleshed out with a discussion of the **“Composition over Inheritance” principle**.

Finally, you’ll extend your knowledge of how to write automated test code by understanding what makes a good and maintainable test. Now that we’ve spoiled the plot of this chapter, let’s get back to understanding what requirements Dr. Avaj has for the Document Management System.

### **Liskov Substitution Principle**: Let q(x) be a property provable about objects x of type T. Then q(y) should be true for objects y of type S where S is a subtype of T.

Informally you can think of this as meaning that child classes should maintain the behavior they inherit from their parents. We know, we know—it sounds like an obvious statement, but we can be more specific and split out LSP into four distinct parts:

- **Preconditions cannot be strengthened in a subtype:** A precondition establishes the conditions under which some code will work. For example, all our Importer implementations have the precondition that the file being imported exists and is readable. As a result, the importFile method has validation code before any Importer is invoked.
  LSP means that you can’t require any more restrictive preconditions than your parent required. So, for example, you can’t require your document to be smaller than 100KB in size if your parent should be able to import any size of document.

- **Postconditions cannot be weakened in a subtype:** Postconditions are things that have to be true after some code has run. For example, after importFile() has run, if the file in question is valid it must be in the list of documents returned by contents(). So if the parent has some kind of side effect or returns some value, then the child must do so as well.

- **Invariants of the supertype must be preserved in a subtype:** An invariant is something that never changes, like the ebb and flow of the tides. In the context of inheritance, we want to make sure that any invariants that are expected to be maintained by the parent class should also be maintained by the children.

- **The History Rule:** This is the hardest aspect of LSP to understand. In essence, the child class shouldn’t allow state changes that your parent disallowed. So, in our example program we have an immutable Document class. In other words, once it has been instantiated you can’t remove, add, or alter any of the attributes.
