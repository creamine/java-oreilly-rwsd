package main;

import java.util.List;

/*
 * Creating the BankStatementParser interface to decouple the two classes
 * BankStatementAnalyzer (main) and BankStatementCSVParser and introduce usage of 
 * other type of parsers (JSON, XML, etc. implementing the newly built interface)
 */
public interface BankStatementParser {
    BankTransaction parseFrom(String line);

    List<BankTransaction> parseLinesFrom(List<String> lines);
}
