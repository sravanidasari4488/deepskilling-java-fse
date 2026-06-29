package week2.financialForecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    public static double futureValueRecursive(double presentValue, double[] growthRates, int year) {
        if (year == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue, growthRates, year - 1) * (1 + growthRates[year - 1]);
    }

    public static double futureValueRecursiveMemoized(double presentValue, double[] growthRates, int year) {
        Map<Integer, Double> memo = new HashMap<>();
        memo.put(0, presentValue);
        return futureValueRecursiveMemoized(growthRates, year, memo);
    }

    private static double futureValueRecursiveMemoized(double[] growthRates, int year, Map<Integer, Double> memo) {
        if (memo.containsKey(year)) {
            return memo.get(year);
        }
        double value = futureValueRecursiveMemoized(growthRates, year - 1, memo) * (1 + growthRates[year - 1]);
        memo.put(year, value);
        return value;
    }
}
