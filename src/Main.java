public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("Sistema Bancario.");

        PessoaFisica erick = new PessoaFisica();
        erick.setCpf("14479890661");
        erick.setNome("Erick Etiene");

        Conta contaErick = new ContaCorrente(erick);
        contaErick.setNumConta(333);

        try{
            contaErick.setLimite(1000);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            contaErick.depositar(1000);
        }catch (ValorNegativoException e){
            System.out.println(e.getMessage());
        }

        try{
            contaErick.sacar(1000);
        }catch (ValorNegativoException e){
            System.out.println(e.getMessage());
        } catch (LimiteInsuficienteException e){
            System.out.println(e.getMessage());

        }


        contaErick.imprimeExtratoTaxas();



//        PessoaJuridica jCliente = new PessoaJuridica();
//        Conta jConta = new Conta(jCliente);



    }
}