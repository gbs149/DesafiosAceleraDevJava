package annotations_reflection.desafio.classesteste;

import annotations_reflection.annotation.Somar;
import annotations_reflection.annotation.Subtrair;

import java.math.BigDecimal;

public class TesteTotalizar {
    @Somar
    public BigDecimal a = BigDecimal.ONE;

    @Somar
    @Subtrair
    public BigDecimal b = BigDecimal.ONE;

    @Somar
    @Subtrair
    public BigDecimal c = BigDecimal.ONE;

}
