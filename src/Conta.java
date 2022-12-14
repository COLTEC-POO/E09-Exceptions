import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public abstract class Conta implements ITaxas {
    //atributos
    private static int totalContas=0;
    private int numConta;
    private Cliente Cliente;
    private double saldo;
    private double limite;
    private boolean tipo;
    private List <Operacao> operacoes;
    private int Numop=0;
    private Cliente dadosCliente;


    //Getters
    public int getnumConta(){
        return this.numConta;
    }
    public Cliente getCliente(){
        return this.Cliente;
    }
    public double getsaldo(){
        return this.saldo;
    }
    public double getlimite(){
        return this.limite;
    }
    public boolean gettipo(){
        return this.tipo;
    }
    public int getNumOp(){
        return this.Numop;
    }
    public int gettotalContas(){
        return totalContas;
    }
    public Cliente getdadosCliente(){
        return this.dadosCliente;
    }
    
    

    //Setters
    public void setnumConta(int numConta){
         this.numConta = numConta;
    }
    public void setcCliente(Cliente Cliente){
         this.Cliente = Cliente;
    }
    public void setsaldo(double saldo){
         this.saldo = saldo;
    }

    public void setlimite(double limite) {
        this.limite = limite;
    }

    private void settotalContas(int totalContas){
        Conta.totalContas = totalContas;
    }
    public void setdadosCliente(Cliente dadosCliente){
        this.dadosCliente = dadosCliente;
    }


    //Ações

        public Conta(Cliente tipo){
            this.dadosCliente=tipo;
            this.numConta =totalContas;
            this.limite = 0;
            this.saldo = 0;
            this.Numop=0;

            settotalContas(this.gettotalContas() + 1);
        }
        

    //Metodo para fazer depositos
    public void depositar (double valor) throws ValorNegativoException{

        if(valor < 0){
            throw new ValorNegativoException("Não foi possível realizar o depósito!");
        }
        else {
            this.saldo = this.saldo + valor;
            this.operacoes.add(new OperacaoDeposito(valor));
        }
    }


    public abstract void limiteConta(double valor) throws SemLimiteException;;

    //Metodo para saque 

   public void sacar(double valor) throws ValorNegativoException, SemLimiteException{

        if (valor > this.saldo || valor < 0){
            throw new ValorNegativoException("Não foi possivel realizar o saque, verifique o valor inserido!");
        }

        if(valor > this.limite){
            throw new SemLimiteException("Saque acima do limite!");
        }

        else {
            this.saldo = this.saldo - valor;
            this.operacoes.add(new OperacaoSaque(valor));
        }
    }

    public int imprimeExtrato(int opcao) {

            if (opcao == 1) {
                System.out.println("Visualização Padrão: de acordo com a data de inserção na lista");
    
                for (Operacao nova : this.operacoes) {
                    System.out.println(nova);
                }
            }
            if (opcao == 2) {
    
                System.out.println("Visualização Ordenada: de acordo com o tipo (depósito, saque)");
                Collections.sort(this.operacoes);
    
                for (Operacao nova : this.operacoes) {
                    System.out.println(nova);
                }
            }
    
            return opcao;
        }
    

    public String toString() {
		 String dadosCliente ="Numero da Conta: " + this.numConta + "\n" +
						 	 "Limite: " + this.limite + "\n" +
						 	 "Saldo: " + this.saldo;
						 
		return dadosCliente;
	}

    public boolean equals(Object objeto) {

            Conta CompararConta = (Conta) objeto;
        
            if(this.numConta == CompararConta.numConta) {
                return true;
            }else {
                return false;
            }

    }

    public boolean validaOperacao(){
        Scanner entrada = new Scanner(System.in);
        String chaveid;

        System.out.println(this.dadosCliente.getNome() + "\nDigite Sua Senha: ");
        chaveid = entrada.nextLine();

        if(!this.dadosCliente.autenticar(chaveid))
            entrada.close();
            return false;
        
    }

    @Override
    public double calculaTaxa(){
        return 0.0;
    }
    @Override
    public void ExtratoTaxas() {
        double anuidade, soma = 0;
        
        anuidade = this.calculaTaxa();
        System.out.println("=== Extrato de Taxas ===");
        System.out.println("MANUTENÇÃO CONTA: R$ " + anuidade);

        for(Operacao nova: this.operacoes){
            if(nova instanceof OperacaoSaque){
                soma+=((OperacaoSaque)nova).calculaTaxa();
            }
        }

        System.out.println("TOTAL: R$ " + (soma + anuidade));
    }

}