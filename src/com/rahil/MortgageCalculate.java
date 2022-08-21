package com.rahil;

public class MortgageCalculate {
    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int loanAmount;
    private float annualRate;
    private byte period;

    public MortgageCalculate(int loanAmount, float annualRate, byte period) {
        this.loanAmount = loanAmount;
        this.annualRate = annualRate;
        this.period = period;
    }

    public double calculateMortgage(){
        float monthlyRate = getMonthlyRate();
        float numberOfPayment = (period * MONTH_IN_YEAR) ;

        double mortgage = loanAmount
                * ((monthlyRate * Math.pow((1 + monthlyRate) , numberOfPayment))
                         / (Math.pow((1 + monthlyRate),numberOfPayment) - 1));
        return mortgage;
    }

    public double calculatePaymentSchedule(short numberOfPaymentMade){
        float monthlyRate = getMonthlyRate();
        float numberOfPayment = getNumberOfPayments();

        double balance = loanAmount
                * (Math.pow((1 + monthlyRate),numberOfPayment) - Math.pow((1 + monthlyRate),numberOfPaymentMade))
                / (Math.pow((1 + monthlyRate),numberOfPayment) - 1);

        return balance;
    }
    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
             balances[month -1] = calculatePaymentSchedule(month);

        return balances;
    }

    private int getNumberOfPayments() {
        return period * MONTH_IN_YEAR;
    }

    private float getMonthlyRate() {
        return (annualRate / PERCENT) / MONTH_IN_YEAR;
    }
}
