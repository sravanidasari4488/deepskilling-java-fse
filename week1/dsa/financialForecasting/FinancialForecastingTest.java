package week2.financialForecasting;

/*
 * EXERCISE 7: FINANCIAL FORECASTING — ANALYSIS
 *
 * 1. Recursion Concept
 *    Recursion is when a method calls itself to solve a problem by reducing it
 *    into smaller subproblems, with a base case to stop further calls.
 *
 * 2. Forecast Formula
 *    FV(year) = FV(year - 1) * (1 + growthRate[year - 1])
 *    Base case: FV(0) = presentValue
 *
 * 3. Time Complexity
 *    - Simple recursive chain (implemented here): O(n) time, O(n) call stack.
 *      Each year depends only on previous year, so exactly n calls.
 *
 *    - If recursion recomputes overlapping subproblems, cost can become exponential.
 *      Memoization avoids repeated work by caching results.
 *
 * 4. Optimization
 *    - Use memoization (top-down dynamic programming) to store previously computed values.
 *    - Or use iterative DP / loop to reduce call-stack overhead to O(1) stack space.
 */
public class FinancialForecastingTest {

    public static void main(String[] args) {

        double presentValue = 10000.0;
        double[] growthRates = {0.05, 0.03, 0.04, 0.06, 0.02}; // 5 years
        int years = growthRates.length;

        System.out.println("--- Financial Forecasting with Recursion ---");
        double recursiveForecast = FinancialForecast.futureValueRecursive(presentValue, growthRates, years);
        System.out.printf("Future value after %d years (recursive): %.2f%n", years, recursiveForecast);

        System.out.println("\n--- Financial Forecasting with Memoized Recursion ---");
        double memoizedForecast = FinancialForecast.futureValueRecursiveMemoized(presentValue, growthRates, years);
        System.out.printf("Future value after %d years (memoized): %.2f%n", years, memoizedForecast);

        System.out.println("\n--- Year-wise Forecast ---");
        for (int year = 0; year <= years; year++) {
            double value = FinancialForecast.futureValueRecursiveMemoized(presentValue, growthRates, year);
            System.out.printf("Year %d -> %.2f%n", year, value);
        }
    }
}
