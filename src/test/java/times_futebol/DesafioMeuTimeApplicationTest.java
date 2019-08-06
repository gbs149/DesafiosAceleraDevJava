package times_futebol;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import times_futebol.exceptions.CapitaoNaoInformadoException;
import times_futebol.exceptions.IdentificadorUtilizadoException;
import times_futebol.exceptions.JogadorNaoEncontradoException;
import times_futebol.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DesafioMeuTimeApplicationTest {

    private DesafioMeuTimeApplication desafioMeuTimeApplication;

    @BeforeEach
    void setup() {
        desafioMeuTimeApplication = new DesafioMeuTimeApplication();
        desafioMeuTimeApplication.incluirTime(1L, "supertime", LocalDate.of(2000, 01, 01), "preto", "branco");
        desafioMeuTimeApplication.incluirJogador(1L, 1L, "Jarlieimisom", LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);
    }

    @Test
    void deveIncluirTime() {
        TimeDeFutebol timeDeFutebol = new TimeDeFutebol(2L, "time", LocalDate.now(), "cor1", "cor2");

        desafioMeuTimeApplication.incluirTime(2L, "time", LocalDate.now(), "cor1", "cor2");

        assertEquals(timeDeFutebol, desafioMeuTimeApplication.getTimes().get(2L));
    }

    @Test
    void deveLancarExcecaoAoIncluirTimesComMesmoId() {
        assertThrows(IdentificadorUtilizadoException.class,
                () -> desafioMeuTimeApplication.incluirTime(1L, "time2", LocalDate.now().plusDays(1L), "cor3", "cor4"));
    }

    @Test
    void deveIncluirJogador() {
        Jogador jogador = new Jogador(2L, 1L, "Jarlieimisom", LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);

        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Jarlieimisom", LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);

        assertEquals(jogador, desafioMeuTimeApplication.getJogadores().get(2L));
    }

    @Test
    void deveLancarExcecaoAoIncluirJogadoresComMesmoId() {
        assertThrows(IdentificadorUtilizadoException.class,
                () -> desafioMeuTimeApplication.incluirJogador(1L, 1L, "Memem", LocalDate.now().minusYears(18L), 2, BigDecimal.ONE));
    }

    @Test
    void deveDefinirCapitaoDoTime() {
        desafioMeuTimeApplication.definirCapitao(1L);

        assertEquals(1L, desafioMeuTimeApplication.getTimes().get(1L).getIdCapitao());
    }

    @Test
    void deveLancarExcecaoAoDefinirCapitaoCasoJogadorNaoExista() {
        assertThrows(JogadorNaoEncontradoException.class,
                () -> desafioMeuTimeApplication.definirCapitao(3L));
    }

    @Test
    void deveBuscarCapitaoDoTime() {
        desafioMeuTimeApplication.definirCapitao(1L);

        Long idCapitao = desafioMeuTimeApplication.buscarCapitaoDoTime(1L);

        assertEquals(1L, idCapitao);
    }

    @Test
    void deveLancarExcecaoCasoTimeNaoTenhaCapitao() {
        assertThrows(CapitaoNaoInformadoException.class,
                () -> desafioMeuTimeApplication.buscarCapitaoDoTime(1L));
    }

    @Test
    void deveBuscarNomeDeJogador() {
        String nomeJogador = "Nome do Jogador";
        desafioMeuTimeApplication.incluirJogador(2L, 1L, nomeJogador, LocalDate.now().minusYears(17L), 1, BigDecimal.TEN);

        String resultado = desafioMeuTimeApplication.buscarNomeJogador(2L);

        assertEquals(nomeJogador, resultado);
    }

    @Test
    void deveLancarExcecaoAoBuscarNomeDeJogadorInexistente() {
        assertThrows(JogadorNaoEncontradoException.class,
                () -> desafioMeuTimeApplication.buscarNomeJogador(3L));
    }

    @Test
    void deveBuscarNomeDoTime() {
        String resultado = desafioMeuTimeApplication.buscarNomeTime(1L);

        assertEquals("supertime", resultado);
    }

    @Test
    void deveLancarExcecaoAoBuscarNomeDeTimeInexistente() {
        assertThrows(TimeNaoEncontradoException.class,
                () -> desafioMeuTimeApplication.buscarNomeTime(3L));
    }

    @Test
    void deveBuscarJogadoresDoTime() {
        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Marekison", LocalDate.now().minusYears(25L), 3, BigDecimal.TEN);

        List<Long> jogadores = desafioMeuTimeApplication.buscarJogadoresDoTime(1L);

        assertEquals(2, jogadores.size());
        assertEquals(Arrays.asList(1L, 2L), jogadores);
    }

    @Test
    void deveRetornarListaVaziaCasoTimeNaoTenhaJogadores() {
        desafioMeuTimeApplication.incluirTime(2L, "time", LocalDate.now(), "cor1", "cor2");

        List<Long> jogadores = desafioMeuTimeApplication.buscarJogadoresDoTime(2L);

        assertEquals(Collections.EMPTY_LIST, jogadores);
    }

    @Test
    void deveBuscarMelhorJogadorDoTime() {
        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Marekison", LocalDate.now().minusYears(25L), 3, BigDecimal.TEN);

        Long idJogador = desafioMeuTimeApplication.buscarMelhorJogadorDoTime(1L);

        assertEquals(2L, idJogador);
    }

    @Test
    void deveBuscarJogadorMaisVelhoDoTime() {
        desafioMeuTimeApplication.incluirJogador(3L, 1L, "Marekison", LocalDate.now().minusYears(25L), 3, BigDecimal.TEN);
        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Marekison", LocalDate.now().minusYears(25L), 3, BigDecimal.TEN);

        Long idJogador = desafioMeuTimeApplication.buscarJogadorMaisVelho(1L);

        assertEquals(2L, idJogador);
    }

    @Test
    void deveBuscarListaDeTimes() {
        desafioMeuTimeApplication.incluirTime(2L, "time", LocalDate.now(), "cor1", "cor2");


        List<Long> times = desafioMeuTimeApplication.buscarTimes();

        assertEquals(2, times.size());
        assertEquals(Arrays.asList(1L, 2L), times);
    }


    @Test
    void deveRetornarListaVaziaAoBuscarListaDeTimesCasoNaoExista() {
        desafioMeuTimeApplication.getTimes().remove(1L);

        List<Long> times = desafioMeuTimeApplication.buscarTimes();

        assertEquals(Collections.emptyList(), times);
    }


    @Test
    void deveBuscarMaiorSalarioUsandoMenorIdComoDesempate() {
        desafioMeuTimeApplication.incluirJogador(3L, 1L, "Romidslei", LocalDate.now().minusYears(17L), 1, BigDecimal.valueOf(100));
        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Romidslei", LocalDate.now().minusYears(17L), 1, BigDecimal.valueOf(100));

        Long jogador = desafioMeuTimeApplication.buscarJogadorMaiorSalario(1L);

        assertEquals(2L, jogador);
    }

    @Test
    void deveBuscarSalarioDoJogador() {
        BigDecimal salario = desafioMeuTimeApplication.buscarSalarioDoJogador(1L);

        assertEquals(0, salario.compareTo(BigDecimal.TEN));
    }

    @Test
    void deveBuscarTopJogadores() {
        desafioMeuTimeApplication.incluirJogador(3L, 1L, "Romidslei", LocalDate.now().minusYears(17L), 2, BigDecimal.valueOf(100));
        desafioMeuTimeApplication.incluirJogador(2L, 1L, "Romidslei", LocalDate.now().minusYears(17L), 3, BigDecimal.valueOf(100));
        desafioMeuTimeApplication.incluirJogador(4L, 1L, "Romidslei", LocalDate.now().minusYears(17L), 1, BigDecimal.valueOf(100));

        List<Long> topJogadores = desafioMeuTimeApplication.buscarTopJogadores(2);

        assertEquals(2, topJogadores.size());
        assertEquals(Arrays.asList(2L, 3L), topJogadores);
    }


}