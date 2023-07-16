package TestePratico;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author Carlos Monte-Alto
 */

public class ListaAuxiliar implements Comparable <ListaAuxiliar> {

    private String nome;
    private LocalDate nascimento;
    private BigDecimal salario;
    private String funcao;

    public ListaAuxiliar(String nome, LocalDate nascimento, BigDecimal salario, String funcao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.salario = salario;
        this.funcao = funcao;
    }

    public String toString() {

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = nascimento.format(formatador);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String salarioFormatado = df.format(salario);

        return nome + "   ||    " + valorFormatado + "   ||    " + salarioFormatado + "   ||    " + funcao
                + "\r\n"
                ;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int compareTo(ListaAuxiliar geral) {
        return this.nome.compareTo(geral.getNome());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaAuxiliar that = (ListaAuxiliar) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcao);
    }
}

