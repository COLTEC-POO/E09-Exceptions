package Conta;

import Cliente.Cliente;

import Operacao.Operacao;
import Operacao.OperacaoDeposito;
import Operacao.OperacaoSaque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
        super(numero, senha, saldo, dono, limite, cliente);
        setLimite(limite);
    }

    public double calculaTaxas() {
        return 0;
    }

    @Override
    public void sacar(double valor) {
        double saldoAtual = getSaldo();

        if (valor >= 0 && valor <= saldoAtual) {
            double taxa = 0;
            // Verifica se há operações antes de tentar acessar o array
            if (numOp > 0 && operacoes instanceof OperacaoSaque) {
                taxa = ((OperacaoSaque) operacoes).calculaTaxas() * valor;
            }

            // Adiciona a taxa de saque ao saldo
            this.setSaldo(saldoAtual - valor - taxa);

            this.operacoes.add(new OperacaoSaque(valor));

            numOp++; // Incrementa numOp após adicionar a operação
        } else {
            System.out.println("Dinheiro indisponível, valor disponível: R$: " + saldoAtual);
        }
    }

    @Override
    public void depositar(double valor) {
        double saldoAtual = getSaldo();

        if (valor >= 0) {
            this.setSaldo(saldoAtual + valor);

            this.operacoes.add(new OperacaoDeposito(valor));
            numOp++;
        }
    }

    @Override
    public void imprimirExtrato(int tipoOrdenacao) {
        List<Operacao> operacoesOrdenadas = new ArrayList<>(this.operacoes);

        if (tipoOrdenacao == 1) {
            // Ordenar por data de inserção (padrão)
            Collections.sort(operacoesOrdenadas);
        } else if (tipoOrdenacao == 2) {
            // Ordenar por tipo de operação (primeiro depósitos, depois saques)
            Collections.sort(operacoesOrdenadas, new Comparator<Operacao>() {
                @Override
                public int compare(Operacao o1, Operacao o2) {
                    return o1.getTipoOperacao().compareTo(o2.getTipoOperacao());
                }
            });
        } else {
            System.out.println("Tipo de ordenação inválido.");
            return;
        }

        System.out.println("Extrato da conta de " + this.dono);
        for (Operacao operacao : operacoesOrdenadas) {
            System.out.println(operacao);
        }
    }

    @Override
    public double setLimite(double valor) {
//            Limite máximo de 1000 reais, e limite mínimo de 100 reais.
        if (valor >= 100 && valor <= 1000) {
            return this.limite = valor;
        } else {
            System.out.println("Limite mínimo de 100 reais e máximo de 1000");
        }
        return 0;
    }
}
