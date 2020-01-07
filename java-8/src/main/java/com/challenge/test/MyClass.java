package com.challenge.test;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class MyClass {
    @Somar
    private BigDecimal test2  = new BigDecimal(10);
    @Somar
    private BigDecimal test3 = new BigDecimal(2);
}
