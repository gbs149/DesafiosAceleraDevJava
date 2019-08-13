package annotations_reflection.desafio.classesteste;

import annotations_reflection.annotation.Somar;

import java.math.BigDecimal;

public class TesteSomar {
    @Somar
    public BigDecimal a = BigDecimal.ONE;

    @Somar
    public BigDecimal b = BigDecimal.ONE;

    @Somar
    public BigDecimal c = BigDecimal.ONE;

}
