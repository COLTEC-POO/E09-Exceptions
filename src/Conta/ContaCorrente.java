package Conta;

// Clientes
import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;

// Operacoes

import Operacao.Operacao;
import Operacao.OperacaoSaque;
import Operacao.OperacaoDeposito;

// Interfaces
import ITaxas.ITaxas;

// Exceptions
import Exceptions.NegativoException;

// Java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContaCorrente extends Conta implements ITaxas {

    public ContaCorrente(int numero, String senha, double saldo, String dono, double limite, Cliente cliente) {
        super(numero, senha, saldo, dono, limite, cliente);
        setLimite(limite);
    }

    @Override

    public double calculaTaxas() {
        if (cliente instanceof PessoaFisica) {
            return 10.0;
        } else if (cliente instanceof PessoaJuridica) {
            return 20.0;
        }
        return 0.0; // Se não for nem PessoaFisica nem PessoaJuridica, retorna 0.
    }

    @Override
    public void sacar(double valor) throws NegativoException  {
        // Verifica se há operações antes de tentar acessar o array
        double taxa = 0;
        if (numOp > 0 && operacoes.get(numOp - 1) instanceof OperacaoSaque) {
            taxa = ((OperacaoSaque) operacoes.get(numOp - 1)).calculaTaxas();
        }

        double saldoAtual = getSaldo();
        if (valor > 0 && valor + taxa <= saldoAtual) {
            // Adiciona a taxa de saque ao saldo
            this.setSaldo(saldoAtual - valor - taxa);
            this.operacoes.add(new OperacaoSaque(valor));
            numOp++;
        } else if (valor > saldoAtual){
            System.out.println("Dinheiro indisponível, valor disponível: R$: " + saldoAtual);

        } else {
            throw new NegativoException(valor);
        }
    }

    @Override
    public void depositar(double valor) throws NegativoException {
        double saldoAtual = getSaldo();

        if (valor >= 0) {

            this.setSaldo(saldoAtual + valor);

            this.operacoes.add(new OperacaoDeposito(valor));
            numOp++;
        } else {
            throw new NegativoException(valor);
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
        if (valor >= -100) {
            return this.limite = valor;
        } else {
            System.out.println("Limite mínimo de -100 reais");
        }
        return 0;
    }
}
