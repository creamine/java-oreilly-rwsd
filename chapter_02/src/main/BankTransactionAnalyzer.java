package main;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {
        // Filename from command line args
        final String fileName = args[0];
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
        System.out.println("The total for all transactions is: " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is: "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is: "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out
                .println("The total salary received is: " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
