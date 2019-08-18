package annotations_reflection.desafio;

import annotations_reflection.annotation.Somar;
import annotations_reflection.annotation.Subtrair;
import annotations_reflection.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.stream.Stream;

public class CalculadorDeClasses implements Calculavel {
    @Override
    public BigDecimal somar(Object object) {
        return Stream.of(getFields(object)).peek(field -> field.setAccessible(true))
                    .filter(field -> field.isAnnotationPresent(Somar.class))
                    .map(field -> (BigDecimal) getObject(field, object))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return Stream.of(getFields(object)).peek(field -> field.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Subtrair.class))
                .map(field -> (BigDecimal) getObject(field, object))
                .reduce(BigDecimal.ZERO, BigDecimal::subtract);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).add(subtrair(object));
    }

    private Field[] getFields(Object object) {
        Class<?> klass = object.getClass();
        return klass.getDeclaredFields();
    }

    private Object getObject(Field field, Object object) {
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
