package com.challenge.test;

import com.challenge.desafio.CalculadorDeClasses;

public class Main {
    public static void main(String args[]) throws Exception {
        CalculadorDeClasses cc = new CalculadorDeClasses();
        System.out.println("Result: " + cc.totalizar(new MyClass()));
    }
}
