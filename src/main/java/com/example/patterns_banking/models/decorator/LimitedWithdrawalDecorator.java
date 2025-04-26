package com.example.patterns_banking.models.decorator;

import com.example.patterns_banking.models.Account;

public class LimitedWithdrawalDecorator extends AccountDecorator {
    private final double LIMIT = 20000;

    public LimitedWithdrawalDecorator(Account account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= LIMIT) {
            super.withdraw(amount);
        } else {
            double currentBalance = super.getBalance();
            double excess = amount - LIMIT;
            System.out.println("Exceeds limit " + LIMIT);
            System.out.println("Withdrawal sucessful. Excess :" + excess);
            super.withdraw(currentBalance);
            System.out.println("Account clean.");
        }
    }
}
