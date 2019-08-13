package times_futebol;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

import static times_futebol.NotNullValidador.validarNotNull;

public class Jogador {
    private Long id;
    private Long idTime;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nivelHabilidade;
    private BigDecimal salario;

    public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        this.id = id;
        this.idTime = idTime;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nivelHabilidade = nivelHabilidade;
        this.salario = salario;
    }

    @NotNull
    public Long getId() {
        return id;
    }

    @NotNull
    public Long getIdTime() {
        return idTime;
    }

    @NotNull
    public String getNome() {
        return nome;
    }

    @NotNull
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @NotNull
    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    @NotNull
    public BigDecimal getSalario() {
        return salario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        return id.equals(jogador.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
