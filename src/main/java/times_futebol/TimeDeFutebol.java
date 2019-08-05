package times_futebol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static times_futebol.NotNullValidator.validateNotNull;

public class TimeDeFutebol {
    private Long id;
    private Long idCapitao;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private List<Jogador> jogadores;

    public TimeDeFutebol(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
                         String corUniformeSecundario) {

        validateNotNull(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);

        jogadores = new ArrayList<>();
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.corUniformePrincipal = corUniformePrincipal;
        this.corUniformeSecundario = corUniformeSecundario;
    }

    public void adicionaJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeDeFutebol that = (TimeDeFutebol) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public Long getIdCapitao() {
        return idCapitao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
}
