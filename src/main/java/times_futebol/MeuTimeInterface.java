package times_futebol;

import times_futebol.exceptions.IdentificadorUtilizadoException;
import times_futebol.exceptions.JogadorNaoEncontradoException;
import times_futebol.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface MeuTimeInterface {
    
    void incluirTime(Long var1, String var2, LocalDate var3, String var4, String var5) throws IdentificadorUtilizadoException;

    
    void incluirJogador(Long var1, Long var2, String var3, LocalDate var4, Integer var5, BigDecimal var6) throws IdentificadorUtilizadoException, TimeNaoEncontradoException;

    
    void definirCapitao(Long var1);

    
    Long buscarCapitaoDoTime(Long var1);

    
    String buscarNomeJogador(Long var1) throws JogadorNaoEncontradoException;

    
    String buscarNomeTime(Long var1);

    
    Long buscarJogadorMaiorSalario(Long var1);

    
    BigDecimal buscarSalarioDoJogador(Long var1);

    
    List<Long> buscarJogadoresDoTime(Long var1);

    
    Long buscarMelhorJogadorDoTime(Long var1);

    
    Long buscarJogadorMaisVelho(Long var1);

    
    List<Long> buscarTimes();

    
    List<Long> buscarTopJogadores(Integer var1);

    
    String buscarCorCamisaTimeDeFora(Long var1, Long var2);
}

