
public class Main {

    public static void main (String[] args) {

    // Criação de contas e clientes de tipos variados

    Cliente vicenteF = new PessoaFisica("Rua Física", "Vicente do Carmo", "777.777.777-69", 25, 'M');
        
    Cliente vicenteJ = new PessoaJuridica("Rua Jurídica", "Empresa do Vicente", "88.888.888/0001-88", 3, "Entretenimento");


    // Atribuição de limites válidos para as contas - Questão 2

    Conta universitaria = new ContaUniversitaria(666, vicenteF, 100); // Limite mínimo de 0 e limite máximo de 500 reais

        System.out.println(universitaria);

    try {
    	universitaria.setLimite(5000);
    } catch (IllegalArgumentException e) {
      	System.out.println(e.getMessage());
    }

    try {
    	universitaria.setLimite(499);
    } catch (IllegalArgumentException e) {
      	System.out.println(e.getMessage());
    }


        System.out.println(universitaria);

    Conta correnteJ = new ContaCorrente(777, vicenteJ, 100); // Limite mínimo de -100 e sem limite máximo

        System.out.println(correnteJ);

    try { 
        correnteJ.setLimite(-101);
    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    try {
        correnteJ.setLimite(500);
    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

        System.out.println(correnteJ);


    Conta poupança = new ContaPoupanca(888, vicenteF, 100); // Limite mínimo de 100 reais e máximo de 1000
    
        System.out.println(poupança);

    try {
        poupança.setLimite(50);
    } catch(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

    try {
        poupança.setLimite(400);
    } catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
    }

        System.out.println(poupança);


    // Testes das checked exceptions - Questão 1
    

    // Operações em que nenhuma exceção é lançada

    try {
    	universitaria.depositar(400);
    } catch (ValorNegativoException e) {
      	System.out.println(e.getMessage());
    }

    try {
    	universitaria.sacar(500);
    } catch (ValorNegativoException e){
      	System.out.println(e.getMessage());
    } catch (SemLimiteException e) {  
    	System.out.println(e.getMessage());
    }

    // Operações em que ValorNegativoExceptions são lançadas

    try {
		correnteJ.depositar(-100);
    } catch (ValorNegativoException e) {
    	System.out.println(e.getMessage());
    }

    try {
    	correnteJ.sacar(-40);
    } catch (ValorNegativoException e){
      	System.out.println(e.getMessage());
    } catch (SemLimiteException e){
      	System.out.println(e.getMessage());
    }


    // Operações que SemLimiteExceptions são lançadas
    
    try {
        poupança.sacar(50000);
    } catch(ValorNegativoException e ){
      	System.out.println(e.getMessage());
    } catch (SemLimiteException e){
      	System.out.println(e.getMessage());
    }
    

  }
}