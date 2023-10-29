public class OperacaoDeposito extends Operacao{

    public OperacaoDeposito(double valor) {
        super('d', valor);



    }


    @Override
    public int compareTo(Operacao o) {
        return 0;
    }
}

