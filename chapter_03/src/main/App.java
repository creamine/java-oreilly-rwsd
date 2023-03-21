package main;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        final Exporter exporter = new HtmlExporter();

        bankStatementAnalyzer.analyze("BankStatement.csv", bankStatementParser, exporter);
    }
}
