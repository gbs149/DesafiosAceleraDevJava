package times_futebol;

import times_futebol.exceptions.CapitaoNaoInformadoException;
import times_futebol.exceptions.IdentificadorUtilizadoException;
import times_futebol.exceptions.JogadorNaoEncontradoException;
import times_futebol.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    private List<TimeDeFutebol> times = new ArrayList<>();

    private List<Jogador> jogadores = new ArrayList<>();

    //    @Desafio("incluirTime") #
    public void incluirTime(Long id, String nome, LocalDate dataCriacao,
                            String corUniformePrincipal, String corUniformeSecundario) {
        times.stream()
                .filter(time -> time.getId().equals(id))
                .findFirst()
                .ifPresent(o -> {
                    throw new IdentificadorUtilizadoException();
                });

        TimeDeFutebol timeDeFutebol = new TimeDeFutebol(id, nome, dataCriacao,
                corUniformePrincipal, corUniformeSecundario);
        times.add(timeDeFutebol);
    }

    //    @Desafio("incluirJogador") #
    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
                               Integer nivelHabilidade, BigDecimal salario) {
        buscarTimePorId(idTime);
        jogadores.stream()
                .filter(jogador -> jogador.getId().equals(id))
                .findFirst()
                .ifPresent(jogador -> {
                    throw new IdentificadorUtilizadoException();
                });

        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        jogadores.add(jogador);
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
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .map(Jogador::getId)
                .collect(Collectors.toList());
    }

    //    @Desafio("buscarMelhorJogadorDoTime") #
    public Long buscarMelhorJogadorDoTime(Long idTime) {
        buscarTimePorId(idTime);
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getNivelHabilidade)
                        .thenComparing(Comparator.comparing(Jogador::getId).reversed()))
                .map(Jogador::getId)
                .orElse(null);
    }

    //    @Desafio("buscarJogadorMaisVelho") #
    public Long buscarJogadorMaisVelho(Long idTime) {
        buscarTimePorId(idTime);
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .min(Comparator.comparing(Jogador::getDataNascimento)
                        .thenComparing(Jogador::getId))
                .map(Jogador::getId)
                .orElse(null);
    }

    //    @Desafio("buscarTimes") #
    public List<Long> buscarTimes() {
        return times.stream()
                .map(TimeDeFutebol::getId)
                .sorted()
                .collect(Collectors.toList());
    }

    //    @Desafio("buscarJogadorMaiorSalario") #
    public Long buscarJogadorMaiorSalario(Long idTime) {
        buscarTimePorId(idTime);
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
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
        return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
                        .thenComparing(Comparator.comparing(Jogador::getId)))
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

    private TimeDeFutebol buscarTimePorId(Long id) {
        return times.stream()
                .filter(time -> time.getId().equals(id))
                .findFirst()
                .orElseThrow(TimeNaoEncontradoException::new);
    }

    private Jogador buscarJogadorPorId(Long id) {
        return jogadores.stream()
                .filter(j -> j.getId().equals(id))
                .findFirst()
                .orElseThrow(JogadorNaoEncontradoException::new);
    }


    public List<TimeDeFutebol> getTimes() {
        return times;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
}

