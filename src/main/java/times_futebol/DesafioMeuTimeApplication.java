package times_futebol;

import times_futebol.exceptions.CapitaoNaoInformadoException;
import times_futebol.exceptions.IdentificadorUtilizadoException;
import times_futebol.exceptions.JogadorNaoEncontradoException;
import times_futebol.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private Map<Long, TimeDeFutebol> times = new HashMap<>();

    private Map<Long, Jogador> jogadores = new HashMap<>();

    //    @Desafio("incluirTime") #
    public void incluirTime(Long id, String nome, LocalDate dataCriacao,
                            String corUniformePrincipal, String corUniformeSecundario) {
        if (times.containsKey(id)) {
            throw new IdentificadorUtilizadoException();
        }

        TimeDeFutebol timeDeFutebol = new TimeDeFutebol(id, nome, dataCriacao,
                corUniformePrincipal, corUniformeSecundario);
        times.put(id, timeDeFutebol);
    }

    //    @Desafio("incluirJogador") #
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
                               Integer nivelHabilidade, BigDecimal salario) {
        buscarTimePorId(idTime);
        if (jogadores.containsKey(id)) {
            throw new IdentificadorUtilizadoException();
        }

        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        jogadores.put(id, jogador);
    }

    //    @Desafio("definirCapitao") #
    public void definirCapitao(Long idJogador) {
        Jogador jogador = buscarJogadorPorId(idJogador);
        TimeDeFutebol time = buscarTimePorId(jogador.getIdTime());
        time.setIdCapitao(idJogador);
    }

    //    @Desafio("buscarCapitaoDoTime") #
    public Long buscarCapitaoDoTime(Long idTime) {
        Long idCapitao = buscarTimePorId(idTime).getIdCapitao();
        if (Objects.isNull(idCapitao)) {
            throw new CapitaoNaoInformadoException();
        }
        return idCapitao;
    }

    //    @Desafio("buscarNomeJogador") #
    public String buscarNomeJogador(Long idJogador) {
        return buscarJogadorPorId(idJogador).getNome();
    }

    //    @Desafio("buscarNomeTime") #
    public String buscarNomeTime(Long idTime) {
        return buscarTimePorId(idTime).getNome();
    }

    //    @Desafio("buscarJogadoresDoTime") #
    public List<Long> buscarJogadoresDoTime(Long idTime) {
        buscarTimePorId(idTime);
        return buscarJogadoresDoTimeStream(idTime)
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    //    @Desafio("buscarMelhorJogadorDoTime") #
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        buscarTimePorId(idTime);
        return buscarJogadoresDoTimeStream(idTime)
                .max(Comparator.comparing(Jogador::getNivelHabilidade)
                        .thenComparing(Comparator.comparing(Jogador::getId).reversed()))
                .map(Jogador::getId)
                .orElse(null);
    }

    //    @Desafio("buscarJogadorMaisVelho") #

    public Long buscarJogadorMaisVelho(Long idTime) {
        buscarTimePorId(idTime);
        return buscarJogadoresDoTimeStream(idTime)
                .min(Comparator.comparing(Jogador::getDataNascimento)
                        .thenComparing(Jogador::getId))
                .map(Jogador::getId)
                .orElse(null);
    }
    //    @Desafio("buscarTimes") #

    public List<Long> buscarTimes() {
        return times.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
    //    @Desafio("buscarJogadorMaiorSalario") #

    public Long buscarJogadorMaiorSalario(Long idTime) {
        buscarTimePorId(idTime);
        return buscarJogadoresDoTimeStream(idTime)
                .max(Comparator.comparing(Jogador::getSalario)
                        .thenComparing(Comparator.comparing(Jogador::getId).reversed()))
                .map(Jogador::getId)
                .orElse(null);
    }
    //    @Desafio("buscarSalarioDoJogador") #

    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        return buscarJogadorPorId(idJogador).getSalario();
    }
    //    @Desafio("buscarTopJogadores")

    public List<Long> buscarTopJogadores(Integer top) {
        return jogadores.values().stream()
                .sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
                        .thenComparing(Jogador::getId))
                .limit(top)
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }
    //    @Desafio("buscarCorCamisaTimeDeFora")

    public String buscarCorCamisaTimeDeFora(Long idTimeDaCasa, Long idTimeDeFora) {
        TimeDeFutebol timeDaCasa = buscarTimePorId(idTimeDaCasa);
        TimeDeFutebol timeDeFora = buscarTimePorId(idTimeDeFora);

        return timeDaCasa.getCorUniformePrincipal().equals(timeDeFora.getCorUniformePrincipal())
                ? timeDeFora.getCorUniformeSecundario()
                : timeDeFora.getCorUniformePrincipal();
    }

    private Stream<Jogador> buscarJogadoresDoTimeStream(Long idTime) {
        return jogadores.values().stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime));
    }

    private TimeDeFutebol buscarTimePorId(Long id) {
        TimeDeFutebol timeDeFutebol = times.get(id);
        if (Objects.isNull(timeDeFutebol)) {
            throw new TimeNaoEncontradoException();
        }
        return timeDeFutebol;
    }

    private Jogador buscarJogadorPorId(Long id) {
        Jogador jogador = jogadores.get(id);
        if (Objects.isNull(jogador)) {
            throw new JogadorNaoEncontradoException();
        }
        return jogador;
    }


    public Map<Long, TimeDeFutebol> getTimes() {
        return times;
    }

    public Map<Long, Jogador> getJogadores() {
        return jogadores;
    }
}

