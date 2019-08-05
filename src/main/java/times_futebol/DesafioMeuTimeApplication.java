package times_futebol;

import times_futebol.exceptions.IdentificadorUtilizadoException;
import times_futebol.exceptions.JogadorNaoEncontradoException;
import times_futebol.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

    List<TimeDeFutebol> times = new ArrayList<>();

    List<Jogador> jogadores = new ArrayList<>();



    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
                            String corUniformeSecundario) throws IdentificadorUtilizadoException {
        TimeDeFutebol timeDeFutebol = new TimeDeFutebol(id, nome, dataCriacao, corUniformePrincipal,
                corUniformeSecundario);
        if (times.contains(timeDeFutebol)) {
            throw new IdentificadorUtilizadoException("Identificador utilizado: " + timeDeFutebol.getId());
        }
        times.add(timeDeFutebol);
    }



    public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento,
                               Integer nivelHabilidade, BigDecimal salario)
            throws IdentificadorUtilizadoException, TimeNaoEncontradoException {
        TimeDeFutebol time = buscarTime(idTime);
        if (time == null) {
            throw new TimeNaoEncontradoException();
        }
        Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
        if (jogadores.contains(jogador)) {
            throw new IdentificadorUtilizadoException("Identificador utilizado: " + jogador.getId());
        }
        jogadores.add(jogador);
        time.adicionaJogador(jogador);
    }

    private TimeDeFutebol buscarTime(Long timeId) {
        return times.stream()
                .filter(time -> time.getId().equals(timeId))
                .findFirst()
                .orElse(null);
    }

    public void definirCapitao(Long idJogador) {
        throw new UnsupportedOperationException();
    }


    public Long buscarCapitaoDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }


    public String buscarNomeJogador(Long idJogador) throws JogadorNaoEncontradoException {
        Optional<String> nomeJogador = jogadores.stream()
                .filter(jogador -> jogador.getId().equals(idJogador))
                .findFirst()
                .map(Jogador::getNome);

        if (!nomeJogador.isPresent()) {
            throw new JogadorNaoEncontradoException();
        }
        return nomeJogador.get();
    }


    public String buscarNomeTime(Long idTime) {
        throw new UnsupportedOperationException();
    }


    public List<Long> buscarJogadoresDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }


    public Long buscarMelhorJogadorDoTime(Long idTime) {
        throw new UnsupportedOperationException();
    }


    public Long buscarJogadorMaisVelho(Long idTime) {
        throw new UnsupportedOperationException();
    }


    public List<Long> buscarTimes() {
        throw new UnsupportedOperationException();
    }


    public Long buscarJogadorMaiorSalario(Long idTime) {
        throw new UnsupportedOperationException();
    }


    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        throw new UnsupportedOperationException();
    }


    public List<Long> buscarTopJogadores(Integer top) {
        throw new UnsupportedOperationException();
    }


    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
        throw new UnsupportedOperationException();
    }

}

