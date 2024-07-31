package FinancialForecasting;

public class FinancialForecasting {

    // Method to calculate future value recursively
    public double calculateFutureValue(double initialValue, double growthRate, int periods) {
        // Base case: If no periods left, return the initial value
        if (periods == 0) {
            return initialValue;
        }

        // Recursive case: Calculate the future value for the remaining periods
        double futureValue = initialValue * (1 + growthRate);
        return calculateFutureValue(futureValue, growthRate, periods - 1);
    }

    public static void main(String[] args) {
        FinancialForecasting forecasting = new FinancialForecasting();

        // Example: Initial value = Rs.1000, Growth rate = 5% (0.05), Periods = 10
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        double futureValue = forecasting.calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Predicted future value after " + periods + " periods: Rs." + futureValue);
    }

}
