package com.example.bkd06k11.helpers;

import java.text.NumberFormat;
import java.util.Currency;

public class Helpers {
    public static String formatCurrency(Double amount) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setCurrency(Currency.getInstance("VND"));
        return format.format(amount);
    }
}
