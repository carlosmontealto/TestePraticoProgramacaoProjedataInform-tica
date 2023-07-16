package TestePratico;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.time.LocalDate;

/**
 * @author Carlos Monte-Alto
 */

public class Lista {

    List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    List<Funcionario> listaFuncioario = new ArrayList<Funcionario>();
    List<ListaAuxiliar> listaAuxiliar = new ArrayList<ListaAuxiliar>();
    Map<String, List> map = new TreeMap<>();

    public void inseriPessoas() {

        Pessoa a = new Pessoa("Maria", 2000, 10, 18);
        Pessoa b = new Pessoa("João", 1990, 5, 12);
        Pessoa c = new Pessoa("Caio", 1961, 5, 2);
        Pessoa d = new Pessoa("Miguel", 1988, 10, 14);
        Pessoa e = new Pessoa("Alice", 1995, 1, 5);
        Pessoa f = new Pessoa("Heitor", 1999, 11, 19);
        Pessoa g = new Pessoa("Arthur", 1993, 3, 31);
        Pessoa h = new Pessoa("Laura", 1994, 7, 8);
        Pessoa i = new Pessoa("Heloísa", 2003, 5, 24);
        Pessoa j = new Pessoa("Helena", 1996, 9, 2);

        listaPessoas.add(a);
        listaPessoas.add(b);
        listaPessoas.add(c);
        listaPessoas.add(d);
        listaPessoas.add(e);
        listaPessoas.add(f);
        listaPessoas.add(g);
        listaPessoas.add(h);
        listaPessoas.add(i);
        listaPessoas.add(j);

    }

    public void inseriFuncionario() {



        Funcionario a = new Funcionario(2009.44, "Operador");
        Funcionario b = new Funcionario(2284.38, "Operador");
        Funcionario c = new Funcionario(9836.14, "Coordenador");
        Funcionario d = new Funcionario(19119.88, "Diretor");
        Funcionario e = new Funcionario(2234.68, "Recepcionista");
        Funcionario f = new Funcionario(1582.72, "Operador");
        Funcionario g = new Funcionario(4071.84, "Contador");
        Funcionario h = new Funcionario(3017.45, "Gerente");
        Funcionario i = new Funcionario(1606.85, "Eletricista");
        Funcionario j = new Funcionario(2799.93, "Gerente");

        listaFuncioario.add(a);
        listaFuncioario.add(b);
        listaFuncioario.add(c);
        listaFuncioario.add(d);
        listaFuncioario.add(e);
        listaFuncioario.add(f);
        listaFuncioario.add(g);
        listaFuncioario.add(h);
        listaFuncioario.add(i);
        listaFuncioario.add(j);
    }

    public void removeFuncionario(String funcionario){
        for (int i = 0; i < listaPessoas.size(); i++) {

            String nome = listaPessoas.get(i).getNome();

            if (nome == funcionario){
                listaPessoas.remove(i);
        listaFuncioario.remove(i);
            } 
        }
    }

    public void imprimiPessoas(String titulo){

        System.out.println("_______________________________________________________");
        System.out.println("    " + titulo + "    ");
        System.out.println("Nome:  ||   Nascimento:  ||   Salário:  ||   Função: ");

        for (int i = 0; i < listaFuncioario.size(); i++){

            System.out.println(listaPessoas.get(i) + "  ||   " + listaFuncioario.get(i));

        }

        System.out.println("_______________________________________________________");

    }

    public void aumentaSalario (double porcentagem){
        for (int i = 0; i < listaFuncioario.size(); i++){
            double funcionario = listaFuncioario.get(i).getSalario().doubleValue();

            double aumentoSalario = funcionario + (funcionario * porcentagem);

            Funcionario a = new Funcionario(aumentoSalario, listaFuncioario.get(i).getFuncao());

            listaFuncioario.set(i, a);        }
    }

    public void mapFuncionario () {
        List<String> listaContador = new ArrayList<>();
        List<String> listaCoordenador = new ArrayList<>();
        List<String> listaDiretor = new ArrayList<>();
        List<String> listaEletricista = new ArrayList<>();
        List<String> listaGerente = new ArrayList<>();
        List<String> listaOperador = new ArrayList<>();
        List<String> listaRecepcionista = new ArrayList<>();

        for (int i = 0; i < listaPessoas.size(); i++) {

            String nome = listaPessoas.get(i).getNome();
            LocalDate nascimento = listaPessoas.get(i).getNascimento();
            BigDecimal salario = listaFuncioario.get(i).getSalario();
            String funcao = listaFuncioario.get(i).getFuncao();

            ListaAuxiliar a = new ListaAuxiliar(nome, nascimento, salario, funcao);

            listaAuxiliar.add(i, a);

            switch (funcao) {
                case "Contador":
                    listaContador.add(nome);
                    break;
                case "Coordenador":
                    listaCoordenador.add(nome);
                    break;
                case "Diretor":
                    listaDiretor.add(nome);
                    break;
                case "Eletricista":
                    listaEletricista.add(nome);
                    break;
                case "Gerente":
                    listaGerente.add(nome);
                    break;
                case "Operador":
                    listaOperador.add(nome);
                    break;
                case "Recepcionista":
                    listaRecepcionista.add(nome);
                    break;
            }
        }

        map.put("Contador", listaContador);
        map.put("Coordenador", listaCoordenador);
        map.put("Diretor", listaDiretor);
        map.put("Eletricista", listaEletricista);
        map.put("Gerente", listaGerente);
        map.put("Operador", listaOperador);
        map.put("Recepcionista", listaRecepcionista);


        System.out.println("_______________________________________________________");
        System.out.println("    Divisão de funcionários por função");
        map.entrySet().forEach(e -> {
            System.out.println("Função: " + e.getKey());
            System.out.println("Funcionário(s): " + e.getValue());
        });
        System.out.println("_______________________________________________________");


    }


    public void imprimirAniversariante (int mes1, int mes2) {

        System.out.println("_______________________________________________________");
        System.out.println("Aniversariantes dos meses 10 e 12");

        for (int i = 0; i < listaFuncioario.size(); i++){

            LocalDate nascimentoPessoa = listaPessoas.get(i).getNascimento();

            int mesAniversario = nascimentoPessoa.getMonthValue();

            if ((mesAniversario==mes1) || (mesAniversario==mes2)){
                System.out.println(listaPessoas.get(i).getNome());
            }
        }

        System.out.println("_______________________________________________________");

    }

    public void imprimirMaiorIdade() {

        int maiorIdade = 0;
        String aniversariante = "";
        int idade = 0;

        for (int i = 0; i < listaPessoas.size(); i++){
            LocalDate nascimentoPessoa = listaPessoas.get(i).getNascimento();

            int anoAniversario = nascimentoPessoa.getYear();
            idade = 2023 - anoAniversario;

            if (idade >= maiorIdade) {
                maiorIdade = idade;
                aniversariante = listaPessoas.get(i).getNome();

            }
        }

        System.out.println("_______________________________________________________");
        System.out.println("O Funcionário mais velho é: " + aniversariante + " com: " + maiorIdade + " anos.");
        System.out.println("_______________________________________________________");
    }

    public void imprimirFuncionarioAlfabetico() {
        System.out.println("_______________________________________________________");
        System.out.println("     Lista em ordem alfabética   ");
        System.out.println("Nome:  ||   Nascimento:  ||   Salário:  ||   Função: ");
        Collections.sort(listaAuxiliar);
        for (int i = 0; i < listaAuxiliar.size(); i++){

            System.out.print(listaAuxiliar.get(i));

        }
        System.out.println("_______________________________________________________");
    }

    public void ImprimirTotalSalario(){

        double salarioTotal= 0;
        for (int i = 0; i < listaFuncioario.size(); i++) {
            double salarioFuncionario = listaFuncioario.get(i).getSalario().doubleValue();

            salarioTotal += salarioFuncionario;
        }

        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("_______________________________________________________");
        System.out.println("Salário Total = " + df.format(salarioTotal));
        System.out.println("_______________________________________________________");
    }

    public void imprimirSalarioMinimoPorFuncioario(double salarioMinimo) {

        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("_______________________________________________________");
        System.out.println("Quantos salários-mínimos ganham cada funcionário");
        System.out.println("Nome:  ||   Quantidade de salários minimos:");

        for (int i = 0; i < listaFuncioario.size(); i++) {
            double salarioFuncionario = listaFuncioario.get(i).getSalario().doubleValue();
            BigDecimal salarioPorFuncionario = new BigDecimal(salarioFuncionario / salarioMinimo);

            String nomeFuncionario = listaPessoas.get(i).getNome();

            System.out.println(nomeFuncionario + "   ||   " + df.format(salarioPorFuncionario));
        }

        System.out.println("_______________________________________________________");
    }
}
