package Conta;

import Cliente.Cliente;
import Exceptions.LimiteException;
import Exceptions.NegativoException;
import Operacao.Operacao;
import Operacao.OperacaoSaque;
import Operacao.OperacaoDeposito;

import ITaxas.ITaxas;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ITaxas {

    // Variaveis privadas basicas da conta
    final int numero;
    final String senha;
    private double saldo;
    final String dono;
    public double limite;

    // inicializando cliente;
    public final Cliente cliente;

    // Inicializando o array de operacoes
    final List<Operacao> operacoes;

    // Numeros de Operacoes;
    public int numOp;

    // Flag de Ordenação
    int tipoOrdenacao;

    // Construtor da Conta
    public Conta(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
        this.dono = dono;

        this.cliente = cliente;

        this.limite = limite;

        this.operacoes = new ArrayList<>();

        this.numOp = 0;
    }

    // Comparando Contas
    public boolean equals(Object outro) {
        if (outro instanceof Conta) {
            Conta outraConta = (Conta) outro;

            System.out.println("As contas sao iguais");

            return this.numero == outraConta.numero;

        } else {
            System.out.println("As contas nao sao iguais");
            return false;
        }
    }

    // Metodo abstrato para forçar subClasses a implementar
    public abstract void depositar(double valor) throws NegativoException;

    // Metodo abstrato para forçar subClasses a implementar
    public abstract void sacar(double valor) throws NegativoException, LimiteException;

    // Metodo abstrato para forçar subClasses a implementar
    public abstract void imprimirExtrato(int tipoOrdenacao);

    public abstract double setLimite(double valor);

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Imprimir dados de conta
    public String toString() {
        return "Número da Conta: " + this.numero + "\nSaldo: R$" + getSaldo() + "\nDono: " + this.dono + "\nLimite: R$" + this.limite + "\n \n=== Dados como cliente === \n" + this.cliente.toString();
    }

    public void imprimirExtratoTaxas() {
        double totalTaxas = 0.0;

        System.out.println("=== Extrato de Taxas de " + this.dono + " ===");

        // Taxa de manutenção da conta
        double taxaManutencao = calculaTaxas();
        System.out.println("Manutenção da conta: " + taxaManutencao);
        totalTaxas += taxaManutencao;

        // Operações de saque
        for (Operacao operacao : this.operacoes) {
            if (operacao instanceof OperacaoSaque) {
                double taxaSaque = ((OperacaoSaque) operacao).calculaTaxas();
                System.out.println("Saque: " + taxaSaque);
                totalTaxas += taxaSaque;
            } else if (operacao instanceof OperacaoDeposito) {
                // Taxa de depósito (0 reais, conforme a sua implementação)
                double taxaDeposito = ((OperacaoDeposito) operacao).calculaTaxas();
                System.out.println("Depósito: " + taxaDeposito);
                totalTaxas += taxaDeposito;
            }
        }

        System.out.println("Total: " + totalTaxas);
        System.out.println();
    }
}