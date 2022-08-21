package com.rahil;

public class Main {

    public static void main(String[] args) {
        int loanAmount = (int) Console.enterNumber("Enter principle", 1_000, 1_000_000);
        float annualRate = (float) Console.enterNumber("Enter annualRate", 1, 30);
        byte period = (byte) Console.enterNumber("Enter period(year)", 1,30);

        var calculator = new MortgageCalculate(loanAmount, annualRate, period);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
