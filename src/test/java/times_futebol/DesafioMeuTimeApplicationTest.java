package times_futebol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import times_futebol.exceptions.IdentificadorUtilizadoException;
import times_futebol.exceptions.JogadorNaoEncontradoException;
import times_futebol.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DesafioMeuTimeApplicationTest {

    private DesafioMeuTimeApplication desafioMeuTimeApplication;

    @BeforeEach
    void setup() throws IdentificadorUtilizadoException, TimeNaoEncontradoException {
        desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1L, "supertime", LocalDate.of(2000, 01, 01), "preto", "branco");
        desafioMeuTimeApplication.incluirJogador(1L, 1L, "Jarlieimisom", LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);
    }

    @Test
    void deveIncluirTime() throws IdentificadorUtilizadoException {
        TimeDeFutebol timeDeFutebol = new TimeDeFutebol(2L, "time", LocalDate.now(), "cor1", "cor2");
        desafioMeuTimeApplication.incluirTime(2L, "time", LocalDate.now(), "cor1", "cor2");
        assertEquals(timeDeFutebol, desafioMeuTimeApplication.times.get(1));
    }

    @Test
    void deveLancarExcecaoAoIncluirTimesComMesmoId() throws IdentificadorUtilizadoException {
        IdentificadorUtilizadoException exception = assertThrows(IdentificadorUtilizadoException.class,
                () -> desafioMeuTimeApplication.incluirTime(1L, "time2", LocalDate.now().plusDays(1L), "cor3", "cor4"));
        assertEquals("Identificador utilizado: 1", exception.getMessage());
    }

    @Test
    void deveIncluirJogador() throws IdentificadorUtilizadoException, TimeNaoEncontradoException {
        Jogador jogador = new Jogador(2L, 1L, "Jarlieimisom", LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);
        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Jarlieimisom", LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);
        assertEquals(jogador, desafioMeuTimeApplication.jogadores.get(0));
    }

    @Test
    void deveLancarExcecaoAoIncluirJogadoresComMesmoId() throws IdentificadorUtilizadoException, TimeNaoEncontradoException {
        IdentificadorUtilizadoException exception = assertThrows(IdentificadorUtilizadoException.class,
                () -> desafioMeuTimeApplication.incluirJogador(1L, 3L, "Memem", LocalDate.now().minusYears(18L), 2, BigDecimal.ONE));
        assertEquals("Identificador utilizado: 1", exception.getMessage());
    }

    @Test
    void deveBuscarNomeDeJogador() throws TimeNaoEncontradoException, IdentificadorUtilizadoException, JogadorNaoEncontradoException {
        String nomeJogador = "Nome do Jogador";
        desafioMeuTimeApplication.incluirJogador(2L, 1L, nomeJogador, LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);
        String resultado = desafioMeuTimeApplication.buscarNomeJogador(2L);
        assertEquals(nomeJogador, resultado);
    }


    @Test
    void deveLancarExcecaoAoBuscarNomeDeJogadorInexistente() throws TimeNaoEncontradoException, IdentificadorUtilizadoException, JogadorNaoEncontradoException {
        JogadorNaoEncontradoException exception = assertThrows(JogadorNaoEncontradoException.class,
                () -> desafioMeuTimeApplication.buscarNomeJogador(3L));
    }




}