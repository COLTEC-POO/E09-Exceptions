import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        adicionaClientes();
        criaContas();
        try {
            contas.get(0).tranferencia(contas.get(1),5000,"11.222.123/0001-00");
            contas.get(0).tranferencia(contas.get(2),10000,"11.222.123/0001-00");

            contas.get(1).saque(100,"111.111.111-11");
            contas.get(1).tranferencia(contas.get(2),100,"111.111.111-11");

            contas.get(2).saque(100,"121.212.131-31");
            contas.get(2).tranferencia(contas.get(3),150,"121.212.131-31");

            contas.get(0).tranferencia(contas.get(1),5000,"11.222.123/0001-00");
            contas.get(0).tranferencia(contas.get(2),10000,"11.222.123/0001-00");

            contas.get(1).tranferencia(contas.get(4),350,"111.111.111-11");
            contas.get(2).tranferencia(contas.get(1),130,"121.212.131-31");

            contas.get(1).tranferencia(contas.get(3),450,"111.111.111-11");
            contas.get(2).tranferencia(contas.get(4),450,"121.212.131-31");

            contas.get(0).imprimirExtato(1);
            contas.get(1).imprimirExtato(1);
            contas.get(2).imprimirExtato(1);
        } catch (ValorNegativoException | SemLimiteException ex){
            System.out.println(ex.getMessage());
        }
    }

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Conta> contas = new ArrayList<>();

    public static void adicionaClientes(){
        Cliente EmpresaA = new PessoaJuridica("EmpresaA", "Rua X", "Tec", "11.222.123/0001-00",7);

        Cliente Wallace = new PessoaFisica("Wallace", "Rua A", "111.111.111-11", 24, 'M');
        Cliente Germana = new PessoaFisica("Germana", "Rua C", "121.212.131-31", 25, 'F');
        Cliente Miguel = new PessoaFisica("Miguel", "Rua A", "101.200.125-12", 4, 'M');
        Cliente Nicolas = new PessoaFisica("Nicolas", "Rua A", "001.151.314-25", 7, 'M');

        clientes.add(EmpresaA);
        clientes.add(Wallace);
        clientes.add(Germana);
        clientes.add(Miguel);
        clientes.add(Nicolas);
    }

    public static void criaContas(){

        Conta ContaEmpresaA = new ContaCorrente(clientes.get(0),100_000,50000.0);
        Conta ContaWallace = new ContaCorrente(clientes.get(1), 1500.00, 850.0);
        Conta ContaGermana = new ContaCorrente(clientes.get(2), 1500.00, 850.0);
        Conta ContaMiguel = new ContaPoupanca(clientes.get(3), 0.00, 850.0);
        Conta ContaNicolas = new ContaPoupanca(clientes.get(4), 0.00, 850.0);

        contas.add(ContaEmpresaA);
        contas.add(ContaWallace);
        contas.add(ContaGermana);
        contas.add(ContaMiguel);
        contas.add(ContaNicolas);
    }

}
