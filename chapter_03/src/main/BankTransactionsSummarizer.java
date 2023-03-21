package main;

@FunctionalInterface
public interface BankTransactionsSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}