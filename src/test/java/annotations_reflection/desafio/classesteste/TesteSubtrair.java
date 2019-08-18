package annotations_reflection.desafio.classesteste;

import annotations_reflection.annotation.Subtrair;

import java.math.BigDecimal;

public class TesteSubtrair {
    @Subtrair
    public BigDecimal a = BigDecimal.ONE;

    @Subtrair
    public BigDecimal b = BigDecimal.ONE;

    @Subtrair
    public BigDecimal c = BigDecimal.ONE;

}
