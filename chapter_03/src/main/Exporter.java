package main;

/*
 * The reason you introduce an interface is to let you decouple from multiple implementations of exporters. 
 * This goes in line with the Open/Closed Principle you learned in the previous section. 
 * In fact, if you need to substitute the implementation of an exporter to JSON 
 * with an exporter to XML this will be straightforward given they will both implement the same interface. 
 * To avoid: return type 'void' as it's not useful and implies a change is happening somewhere..
 *           also 'void' makes it very hard to test the result with assertions.
 *           That's why we use return type 'String' instead.
 */

@FunctionalInterface
public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
