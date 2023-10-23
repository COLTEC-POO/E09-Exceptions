// Importação das subclasses de Cliente do pacote Cliente
import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;

// Importação das subclasses de Conta do pacote Conta
import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import Conta.ContaUniversitaria;
import Exceptions.NegativoException;

// Importação de bibliotecas Java
import java.util.List;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws NegativoException {

        // Inicialização de dados
        PessoaFisica pF = new PessoaFisica("João", "Rua A", "12345678900", 30, 'M');
        ContaCorrente contaC = new ContaCorrente(1, "123", 20000, "João", 1000, pF);

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(pF);

        System.out.println("======Sistema Bancário======");
        System.out.println("Donos registrados:");
        for(Cliente c: listaClientes) {
            System.out.println(c.nome);
        }

        // Tratando a Exception
    try {
        contaC.sacar(-300);
        contaC.sacar(-200);
        contaC.depositar(-3000);
    } catch(NegativoException erro) {
        System.out.println(erro.getMessage());
    }

        // Impressão no Terminal
        System.out.println();

        // Imprimindo Extrato de acordo com tipo inserido
        contaC.imprimirExtrato(2);
        System.out.println();
        contaC.imprimirExtratoTaxas();
    }
}