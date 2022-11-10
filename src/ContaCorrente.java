public class ContaCorrente extends Conta{

    public ContaCorrente(int numConta, double limiteMin, Cliente titular) {
        super(numConta, titular);
        this.setLimite(limiteMin);
    }

    public void setLimite(double limiteMin) {
        if(limiteMin < -100 || limiteMin > 0){
            throw new IllegalArgumentException("Valor de limite inválido");
        }
        else {
            this.limiteMin = limiteMin;
        }
        this.limiteMax = Double.MAX_VALUE;
    }

    public double calculaTaxas(){
        double taxa = 0;
        if(this.getTitular() instanceof PessoaFisica){
            taxa = 10;
        }
        if(this.getTitular() instanceof PessoaJuridica){
            taxa = 20;
        }
        return taxa;
    }
}
