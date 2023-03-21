package main;

/*
 * Creating the BankTransactionFilter interface to enforce the Open/Close principle:
 * promoting the idea of being able to change the behavior of a method or class without 
 * having to modify the code. 
 * Introducing the BankTransactionFilter interface, responsible for the selection logic.
 */
@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
