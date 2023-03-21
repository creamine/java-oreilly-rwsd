package main;

/*
 * Introducing a specialized domain object: SummaryStatistics
 * A domain object is simply an instance of a class that is related to your domain. 
 * By introducing a domain object, you introduce a form of decoupling. 
 * In fact, if there are new requirements where you need to export additional information, 
 * you can just include it as part of this new class without having to introduce cascading changes.
 */

public class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double avg;

    public SummaryStatistics(final double sum, final double max, final double min, final double avg) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.avg = avg;
    }

    public double getSum() {
        return sum;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAvg() {
        return avg;
    }
}