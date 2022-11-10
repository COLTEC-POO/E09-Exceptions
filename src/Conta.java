
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Conta implements ITaxas {
    private Cliente dono;
    private int numConta;
    protected double saldo;
    protected double limite;

    protected String tipo;

    public static int totalContas;

    private List<Operacao> operacoes;



    //Metodos
    public Conta(Cliente dono) {
        this.dono = dono;
        this.operacoes = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {

        Conta objConta = (Conta) obj;

        if(this.numConta == objConta.numConta) return true;
        return false;

    }

    public void setNumConta(int val){
        this.numConta = val;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Cliente getDono() {
        return this.dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }
    public double getLimite() {
        return limite;
    }

    public abstract void setLimite(double limite);

    public boolean sacar(double valor) throws ValorNegativoException, LimiteInsuficienteException {

        if(valor < 0)
            throw new ValorNegativoException("Valor Invalido: Negativo" + valor);
        else if(valor > this.limite)
            throw new LimiteInsuficienteException("Valor Invalido: Sem limite na conta");

        if (!(valor > this.saldo) && !(valor < 0.0)) {
            this.operacoes.add(new OperacaoSaque(valor));
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(double valor) throws ValorNegativoException{
        if (valor < 0.0)
            throw new ValorNegativoException("Valor Invalido: Deposito Negativo");
        else {
            this.operacoes.add(new OperacaoDeposito(valor));
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
            return true;
        }
    }


    /*
    public boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor) && destino.depositar(valor)) {
            this.operacoes[Operacao.totalOperacoes] = new Operacao(valor);

            System.out.println("Transferência realizada com sucesso!\n");
            return true;
        } else {
            System.out.println("Transferência mal sucedida.");
            return false;
        }
    }
    */

    public void imprimeExtrato(int order){
        System.out.println("===Extrato conta " + getNumConta() + "===" + "\nDono: " + getDono().getNome());

        if(order == 1){
            for(Operacao i: this.operacoes){
                System.out.println(i.getData() + " " + i.getTipo() + "      " + i.getValor() );
            }
        }else if(order == 2){

            List<Operacao> auxList = new ArrayList<>();
            for(Operacao i: operacoes){
                auxList.add(i);
            }

            Collections.sort(auxList);
            for(Operacao i: auxList){
                System.out.println(i.getData() + " " + i.getTipo() + "      " + i.getValor() );
            }


        }
    }

    public void imprimeExtratoTaxas(){

        Operacao atual;
        double total = this.calculaTaxas();

        System.out.println("Extrato de Taxas\t" + this.getNumConta() + "\t" + this.getDono().getNome());
        System.out.println("Imposto sobre tipo de conta: " + this.calculaTaxas());
        System.out.println("\nOperações: ");

        for(Operacao i: this.operacoes){
            atual = i;
            if(atual.calculaTaxas() == 0) continue;

            System.out.println(atual.getTipo() + ": " + atual.calculaTaxas());
            total += atual.calculaTaxas();
        }

        System.out.println("Total: " + total);
    }



    public String toString() {
        return "=== Conta: " + this.numConta + " ==="
        + "Dono: " + this.dono.getNome()
        + "Limite: " + this.limite +
        this.saldo;
    }

    private void imprimeSaldo() {
        System.out.println("Saldo: " + this.saldo);
    }




}
