package TestePratico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Carlos Monte-Alto
 */

public class Pessoa {

    private String nome;
    private LocalDate nascimento;

    public Pessoa (String nome, int ano, int mes, int dia) {
        this.nome = nome;
        LocalDate nascimento = LocalDate.of(ano, mes, dia);
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public String toString() {

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = nascimento.format(formatador);

        return nome  + "   ||    " + valorFormatado
//                + "\r\n"
                ;

    }
}
