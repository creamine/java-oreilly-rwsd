package main;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        // Path to the csv file
        final Path path = Paths.get(RESOURCES + fileName);
        // Getting a list of lines in the file
        final List<String> lines = Files.readAllLines(path);
        // Using BankStatementCSVParser to parse lines from CSV
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        // Processing the transactions
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        // Displaying the summary of transactions
        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        final List<BankTransaction> transactions = bankStatementProcessor
                .findTransactions(new BankTransactionIsInFebruaryAndExpensive());
        System.out.println("The total for all transactions is: " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for expensive transactions in February is: "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out
                .println("The total salary received is: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out
                .println("The transactions greater than or equal to 5,000: "
                        + bankStatementProcessor.findTransactionsGreaterThanEqual(5000));
    }
}
