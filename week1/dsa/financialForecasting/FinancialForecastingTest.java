package week2.financialForecasting;

public class FinancialForecastingTest {

    public static void main(String[] args) {

        double presentValue = 10000.0;
        double[] growthRates = {0.05, 0.03, 0.04, 0.06, 0.02};
        int years = growthRates.length;

        double recursiveForecast = FinancialForecast.futureValueRecursive(presentValue, growthRates, years);
        double memoizedForecast = FinancialForecast.futureValueRecursiveMemoized(presentValue, growthRates, years);

        System.out.println("Recursive forecast: " + recursiveForecast);
        System.out.println("Memoized forecast: " + memoizedForecast);
    }
}
