package annotations_reflection.desafio;

import annotations_reflection.desafio.classesteste.TesteSubtrair;
import annotations_reflection.desafio.classesteste.TesteSomar;
import annotations_reflection.desafio.classesteste.TesteTotalizar;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CalculadorDeClassesTest {

    CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();

    @Test
    void somarAtributos() {
        TesteSomar classeTeste = new TesteSomar();

        assertEquals(0, BigDecimal.valueOf(3).compareTo(calculadorDeClasses.somar(classeTeste)));
    }

    @Test
    void subtrairAtributos() {
        TesteSubtrair classeTeste = new TesteSubtrair();

        assertEquals(0, BigDecimal.valueOf(-3).compareTo(calculadorDeClasses.subtrair(classeTeste)));
    }


    @Test
    void totalizarAtributos() {
        TesteTotalizar classeTeste = new TesteTotalizar();

        assertEquals(0, BigDecimal.valueOf(1).compareTo(calculadorDeClasses.totalizar(classeTeste)));
    }


}