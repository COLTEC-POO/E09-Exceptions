public class ContaUniversitaria extends Conta{
    public ContaUniversitaria(Cliente dono) {
        super(dono);
        this.tipo = "CU";
    }

    @Override
    public void setLimite(double limite) throws IllegalArgumentException {
        if(limite > 500)
            throw new IllegalArgumentException("Limite Máximo Ultrapassado");
        else if(limite < 0)
            throw new IllegalArgumentException("Limite Mínimo Ultrapassado");
        else{
            this.limite = limite;
        }
    }

    @Override
    public double calculaTaxas() {
        return 0;
    }
}
