public class OperacaoSaque extends Operacao{

    public OperacaoSaque(double valor) {
        super('s', valor);
    }

    @Override
    public int compareTo(Operacao o) {
        return 0;
    }
}