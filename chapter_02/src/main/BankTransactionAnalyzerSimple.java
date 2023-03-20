package main;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "resources/";

    public static void main(String[] args) throws IOException {
        // Using BankStatementCSVParser (refactoring)
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        // Filename from command line args
        final String fileName = args[0];
        // Path to the csv file
        final Path path = Paths.get(RESOURCES + fileName);
        // Getting a list of lines in the file
        final List<String> lines = Files.readAllLines(path);
        // Using BankStatementCSVParser to parse lines from CSV
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        // Displaying the total
        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));

    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
