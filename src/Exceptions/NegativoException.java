package Exceptions;

public class NegativoException extends  Exception {
    public NegativoException(double valor) {
        super("Valor Negativo: " + valor);
    }
}
