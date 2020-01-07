package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Objects;

public class CalculadorDeClasses implements Calculavel {

    public BigDecimal somar(Object objectClass) {
        return calcular(objectClass, Somar.class);
    }

    public BigDecimal subtrair(Object objectClass) {
        return calcular(objectClass, Subtrair.class);
    }

    private BigDecimal calcular(Object objectClass, Class anotationClass) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal value;
        Field [] fields = objectClass.getClass().getDeclaredFields();

        try {
            for (Field declaredField : fields) {
                if(declaredField.getType().equals(BigDecimal.class)) {
                    if(declaredField.isAnnotationPresent(anotationClass)) {
                        declaredField.setAccessible(true);
                        value = (BigDecimal) declaredField.get(objectClass);
                        sum = sum.add(value);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return sum;
    }

    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }
}
