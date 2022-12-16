import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Conta implements ITaxas {

    private Cliente titular;
    private int numConta;
    private double saldo;
    public double limite;
    private List <Operacao> operacoes;
    public static int totalContas;

    public Conta() {
        this.numConta = 0;
        this.saldo = 0;
        this.limite = 0;
        this.operacoes = new ArrayList<>();

        Conta.totalContas++;
    }

    public Cliente getDono() {
        return titular;
    }

    public void setDono(Cliente dono) {
        this.titular = dono;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public abstract void setLimite(double limite) throws SemLimiteException;

    public void depositar (double valor) throws ValorNegativoException{

        if(valor < 0){
            throw new ValorNegativoException("Não foi possível realizar o depósito de: R$" + valor + " **");
        }
        else {
            this.saldo = this.saldo + valor;
            this.operacoes.add(new OperacaoDeposito(valor));
        }
    }

    public void sacar(double valor) throws ValorNegativoException, SemLimiteException{
        if (valor > this.saldo || valor < 0){
            throw new ValorNegativoException("** Não foi possível realizar o saque **");
        }
        if(valor > this.limite){
            throw new SemLimiteException("** O valor para saque inserido é maior que o limite permitido para a conta **");
        }
        else {
            this.saldo =- valor;
            this.operacoes.add(new OperacaoSaque(valor));
        }
    }

    /*
    public boolean transferir (Conta destino, double valor){
        boolean saqueRealizado = this.sacar(valor);
        if (saqueRealizado){
            destino.depositar(valor);
            return true;
        }else {
            return false;
        }
    }
     */

    public boolean equals(Object obj) {

        Conta contaNum = (Conta) obj;

        if (this.numConta == (contaNum.numConta)){
            return true;
        }
        else
            return false;

    }

    public String toString(){

        return "Nome: " + this.titular.nome+ "\n" + "Numero da conta: " + getNumConta() + "\n" +
                "Saldo: " + getSaldo() + "\n" + "Limite: " + getLimite();

    }

    public int imprimirExtrato(int opcao) {

        if (opcao == 1) {
            System.out.println("\nVisualização Padrao\n");

            for (Operacao atual : this.operacoes) {
                System.out.println(atual);
            }
        }
        if (opcao == 2) {

            System.out.println("\nVisualização Ordenada\n");
            Collections.sort(this.operacoes);

            for (Operacao atual : this.operacoes) {
                System.out.println(atual);
            }
        }

        return opcao;
    }

    public void imprimirExtratoTaxas(){

        double taxaManutencao = this.calculaTaxas();
        double totalOperacoes = 0;

        System.out.println(" ------Extrato de Taxas ------");
        System.out.println("....Nome: " + this.titular.nome);
        System.out.println("....Manutenção da conta: R$" + taxaManutencao);
        System.out.println("....Operações");

        for (Operacao atual: this.operacoes){

            if (atual instanceof OperacaoSaque) {
                totalOperacoes += ((OperacaoSaque) atual).calculaTaxas();
                System.out.println("Saque: " + ((OperacaoSaque) atual).calculaTaxas());
            }
        }

        totalOperacoes = totalOperacoes + taxaManutencao;

        System.out.println("\nTotal: R$" + totalOperacoes);
    }
}