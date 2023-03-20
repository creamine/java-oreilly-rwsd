package main;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "resources/";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("Thte total for all transactions is " + total);

    }
}
