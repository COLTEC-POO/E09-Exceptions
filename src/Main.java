public class Main {

    public static void main(String[] args) {

        Cliente lucasF = new PessoaFisica("Rua da Amizade, 123", "Lucas Silva", "123.456.789-10", 30, 'M');

        Cliente lucasJ = new PessoaJuridica("Avenida Comércio, 456", "Tech Solutions Ltd.", "99.888.777/0001-11", 5, "Information Technology");

        Conta universitaria = new ContaUniversitaria(101, lucasF, 5000); // Minimum limit of 0 and maximum limit of 5000 reais

        System.out.println(universitaria);

        universitaria.setLimite(8000);
    
        universitaria.setLimite(4500);
    
        System.out.println(universitaria);

        Conta correnteJ = new ContaCorrente(202, lucasJ, 10000); // Minimum limit of -100 and no maximum limit

        System.out.println(correnteJ);

        correnteJ.setLimite(-200);

        correnteJ.setLimite(15000);
        

        System.out.println(correnteJ);

        Conta poupanca = new ContaPoupanca(303, lucasF, 10000); // Minimum limit of 100 reais and maximum of 10000

        System.out.println(poupanca);

        poupanca.setLimite(2000);
    
        poupanca.setLimite(9000);

        System.out.println(poupanca);


        universitaria.depositar(1000);
    
        universitaria.sacar(800);
       
        correnteJ.depositar(500);
        
        correnteJ.sacar(200);
        
        poupanca.sacar(12000);
    }
}
