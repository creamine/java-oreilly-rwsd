package main;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementAnalyzer {
        private static final String RESOURCES = "src/main/resources/";

        public void analyze(final String fileName, final BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {
                // Path to the csv file
                final Path path = Paths.get(RESOURCES + fileName);
                // Getting a list of lines in the file
                final List<String> lines = Files.readAllLines(path);
                // Using BankStatementCSVParser to parse lines from CSV
                final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
                // Processing the transactions
                final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
                // Summarizing the transactions
                final SummaryStatistics summaryStatistics = bankStatementProcessor.summarizeTransactions();
                // Displaying the summary of statistics
                System.out.println(exporter.export(summaryStatistics));
        }
}
