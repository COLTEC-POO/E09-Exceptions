public class ContaCorrente extends Conta implements ITaxas {

    private double limite;


    public ContaCorrente(Cliente dono, int numConta) {
        super(dono, numConta);
        calculaTaxas();
    }

    public void setLimite (double limite){
        if(limite<-100){
            System.out.println("Ultrapassou o limite mínimo para este tipo de conta!");
        }
        else{
            this.limite=limite;
            System.out.println("Limite alterado!");
        }
    }

    public double calculaTaxas() {

        if (dono instanceof PessoaFisica) {
            setTaxas(10);
            //taxas= 10;
        }
        if (dono instanceof PessoaJuridica) {
            setTaxas(20);
            //taxas=20;
        }
        return getTaxas();
    }

}
