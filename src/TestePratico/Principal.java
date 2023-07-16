package TestePratico;

/**
 * @author Carlos Monte-Alto
 */

public class Principal {

    public static void main (String args []){
        Lista lista = new Lista();

        lista.inseriPessoas();
        lista.inseriFuncionario();
        lista.imprimiPessoas("Lista com todos os funcionários: ");
        lista.removeFuncionario(1);
        lista.imprimiPessoas("Lista após a remoção de um funcionário: ");
        lista.aumentaSalario(0.1);
        lista.imprimiPessoas("Lista após reajuste de salário: ");
        lista.mapFuncionario();
        lista.imprimirAniversariante(10, 12);
        lista.imprimirFuncionarioAlfabetico();
        lista.imprimirMaiorIdade();
        lista.ImprimirTotalSalario();
        lista.imprimirSalarioMinimoPorFuncioario(1212.00);
    }
}
