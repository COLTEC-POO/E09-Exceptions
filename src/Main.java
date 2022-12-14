public class Main {
    public static void main(String[] args){

        Conta contacoltec = new ContaCorrente(new PessoaJuridica(), 100000);
        System.out.println(contacoltec.toString());

        Conta minhaConta = new ContaPoupanca(new PessoaFisica(),900);
        System.out.println(minhaConta.toString());

        Conta contaaluno = new ContaUniversitaria(new PessoaFisica(), 250);
        System.out.println(contaaluno.toString());


        
        try{
            minhaConta.setlimite(1000); 
            minhaConta.depositar(850);
            minhaConta.sacar(150);
        }
        catch (ValorNegativoException ex){
            System.out.println("Valor invalido!" + ex.getMessage());
        }
        catch (SemLimiteException ex){
            System.out.println("Limite inválido!" + ex.getMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println("Limite inválido para esta conta!" + ex.getMessage());
        }

        

        try{
            contacoltec.setlimite(-200); // limite mínimo -100
            contacoltec.depositar(900);
            contacoltec.sacar(400);
        }
        catch (ValorNegativoException ex){
            System.out.println("Valor invalido!" + ex.getMessage());
        }
        catch (SemLimiteException ex){
            System.out.println("Limite inválido!" + ex.getMessage());
        }
        catch (IllegalArgumentException ex){
            System.out.println("Limite inválido para esta conta!" + ex.getMessage());
        }
    }
}
