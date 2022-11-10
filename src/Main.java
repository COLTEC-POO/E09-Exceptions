import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema Bancário\n");

        Cliente cliente1 = new PessoaFisica("Eduardo", "Belo Horizonte",20, "12345679-01", 'M');
        Cliente cliente2 = new PessoaJuridica("Coltec", "Av Antônio Carlos", "123465789-00", 30, "Educação");
        Conta contaTeste = new ContaCorrente(1202, -100, cliente1);
        Conta contaTeste2 = new ContaPoupanca(1204, 800, cliente2);
        try {
            contaTeste2.depositar(135);
            contaTeste2.sacar(35);
            contaTeste2.sacar(100);
            contaTeste2.depositar(1500);
            contaTeste2.sacar(870);
            contaTeste2.sacar(213);
            contaTeste2.depositar(750);
            contaTeste2.depositar(600);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        contaTeste2.imprimirExtrato(1);
        contaTeste2.imprimirExtrato(2);

        contaTeste2.imprimirExtratoTaxas();
    }
}