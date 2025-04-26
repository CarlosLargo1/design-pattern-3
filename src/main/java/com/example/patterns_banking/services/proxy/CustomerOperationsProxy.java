package com.example.patterns_banking.services.proxy;

import java.util.regex.Pattern;

public class CustomerOperationsProxy implements ICustomerOperations{

    private static final Pattern YAHOO_PATTERN = Pattern.compile("^[\\w.+\\-]+@yahoo\\..+$", Pattern.CASE_INSENSITIVE);

    @Override
    public Boolean isNotYahooEmail(String email) {
        return !YAHOO_PATTERN.matcher(email).matches();
    }
}
