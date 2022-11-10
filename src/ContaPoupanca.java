public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente dono) {
        super(dono);
        this.tipo = "CP";
    }

    @Override
    public void setLimite(double limite) throws IllegalArgumentException{
        if(limite > 1000)
            throw new IllegalArgumentException("Limite Invalido: Limite máximo para Contas Poupança é 1000");
        else if(limite < 100)
            throw new IllegalArgumentException("Limite Invalido: Limite mínimo para Contas Poupança é 100");
        else{
            this.limite = limite;
        }
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}
