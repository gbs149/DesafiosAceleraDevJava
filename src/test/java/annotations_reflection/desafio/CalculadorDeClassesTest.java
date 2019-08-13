package annotations_reflection.desafio;

import annotations_reflection.desafio.classesteste.TesteSomar;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorDeClassesTest {

    CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();

    @Test
    public void somarAtributos() {
        TesteSomar classeTeste = new TesteSomar();

        assertEquals(0, BigDecimal.valueOf(3).compareTo(calculadorDeClasses.somar(classeTeste)));
    }


}