package annotations_reflection.desafio;

import annotations_reflection.annotation.Somar;
import annotations_reflection.annotation.Subtrair;
import annotations_reflection.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) {
        BigDecimal result = BigDecimal.ZERO;
        Class<?> klass = object.getClass();
        Field[] fields = klass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Somar.class)) {
                try {
                    result = result.add((BigDecimal) field.get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public BigDecimal subtrair(Object object) {
        BigDecimal result = BigDecimal.ZERO;
        Class<?> klass = object.getClass();
        Field[] fields = klass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Subtrair.class)) {
                try {
                    result = result.subtract((BigDecimal) field.get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return null;
    }
}
