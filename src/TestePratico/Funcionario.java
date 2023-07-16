package TestePratico;


import java.math.BigDecimal;

import java.text.DecimalFormat;

/**
 * @author Carlos Monte-Alto
 */

public class Funcionario {

    private BigDecimal salario;
    private String funcao;

    public Funcionario (double salario,  String funcao) {
        BigDecimal salarioConvertido = new BigDecimal(salario);
        this.salario = salarioConvertido;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        BigDecimal salarioConvertido = new BigDecimal(salario);
        this.salario = salarioConvertido;
    }

    public String getFuncao() {
        return funcao;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String salarioFormatado = df.format(salario);
        return salarioFormatado  + "   ||   " + funcao
//                + "\r\n"
                ;

    }
}
