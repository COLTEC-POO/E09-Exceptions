import java.util.ArrayList;
import java.util.Collections;

public abstract class Conta implements ITaxas{

    protected int numero;
    protected String senha;
    protected double saldo;
    protected Cliente dono;
    protected double limite;
    private ArrayList<Operacao> operacoes;
    

    protected static int totalContas = 0;
    

    public String toString(){
        

        String ContaStr =
        "========== Conta =========" +"\n" +
        "Numero da Conta: " + this.numero + "\n" +
        "Saldo: " + this.saldo + "\n" +
        "Dono: " + this.dono.nome + "\n" + 
        "Limte: " + this.limite + "\n" +
        "==========================" + "\n";

        return ContaStr;
    }  


    public Conta(int numero, String senha, double saldo,Cliente dono,double limite){

        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.dono = dono;
        this.limite = limite;

        operacoes = new ArrayList<>();


        // Conta quantas novas contas já foram criadas
        totalContas++;

    }


    //public TIPO_RETORNO NOME_DO_MÉTODO(TIPO VARI1, TIPO VARI2,...){
    //}

    public void depositar(double valor) throws ValorNegativoException {

        if (valor < 0){
            throw new ValorNegativoException("Valor do deposito negativo: " + valor);
        }

       
        this.saldo += valor;

        this.operacoes.add(new OperacaoDeposito(valor));
        

    }

    public boolean sacar(double valor) throws ValorNegativoException {

        if (valor < 0){
            throw new ValorNegativoException("Valor de saque negativo: " + valor);
        }
        
        if(valor <= this.saldo) {
            this.saldo -= valor;

            this.operacoes.add(new OperacaoSaque(valor));
            return true;
        }
        else{
           return false;
        }
            
        
    }

    public void transferir(double valor, Conta destino) throws ValorNegativoException{
        if(this.sacar(valor)){
            destino.depositar(valor);
        
        }
        else{
            System.out.println("Nao foi possivel realizar a transferencia!");
        }
    }



    public void imprimirExtrato(){

        System.out.println("Extrato ordenado em ordem de insercao: ");
        System.out.println("\n");

        for(Operacao operacaoAtual : this.operacoes){
            System.out.println(operacaoAtual.getData() + "\t" + operacaoAtual.getTipo() + "\t" + operacaoAtual.getValor());
        }

        System.out.println("\n");

        System.out.println("Extrato ordenados pelos tipos: ");
        System.out.println("\n");

        Collections.sort(operacoes);

        for(Operacao operacaoAtual : this.operacoes){
            System.out.println(operacaoAtual.getData() + "\t" + operacaoAtual.getTipo() + "\t" + operacaoAtual.getValor());
        }

    }

    public boolean equals(Object outraC){

        if(outraC instanceof Conta){

            Conta outraConta = (Conta) outraC;
            return this.getNumero() == outraConta.getNumero();

        } else{
            return false;
        }

    }

    public void imprimirExtratoTaxas(){
        double totalTaxasOperacoes = 0.0;

        double manutencao = calculaTaxas();

        System.out.println("==== Extrato de Taxas ====");
        System.out.println("Manutencao da conta: " + manutencao);

        for(Operacao operacaoAtual : this.operacoes){

            double taxa = 0.0;

            if(operacaoAtual instanceof ITaxas){
                ITaxas operacaoComTaxas = (ITaxas) operacaoAtual;
                taxa = operacaoComTaxas.calculaTaxasOperacao();
            }

            if(operacaoAtual.getTipo() == 's'){
               
                System.out.println("Saque: " + taxa);

            }
            if(operacaoAtual.getTipo() == 'd'){
                 System.out.println("Deposito: " + taxa);

            }
            totalTaxasOperacoes += taxa;
            

        }

        System.out.println("\nTotal: " + (manutencao + totalTaxasOperacoes));
        
    }

    public abstract void setLimite();


    // DONO
    public Cliente getDono(){
        return this.dono;
    }
    public Cliente setDono(){
        return this.dono;
    }

    // NUMERO
    public int getNumero(){
        return this.numero;
    }
    public int setNumero(){
        return this.numero;
    }

    // SALDO
    public double getSaldo(){
        return this.saldo;
    }

    //LIMITE
    public double getLimite(double limite){

        return this.limite;
    }

    // TOTAL DE CONTAS 

    public static int getTotalContas(){
        return totalContas;
    }

}
