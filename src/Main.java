public class Main {

    public static void main(String[] args){

        System.out.println("======== Sistema Bancario ========");
        System.out.println("\n");

        //Cliente clientePJ = new PessoaJuridica("Empresa XYZ", "Rua B", "24.812.098/9861-51", 3, "Gerente");


        Cliente pessoa = new PessoaFisica("João", "Rua A", "532.136.925-22", 22, 'M');
    
        
        // Testando o erro sacar ou depositar
        try {
            Conta cc2 = new ContaCorrente(2332, "fdfsfr11", 1000, pessoa, 500);
            
            cc2.sacar(-2000);

        } catch (IllegalArgumentException e){
            System.out.println("ERRO: " + e.getMessage());
        } catch (ValorNegativoException erro){
            System.out.println("ERRO: " + erro.getMessage());
        } finally {
            System.out.println("SEGUNDO PROCESSO CONCLUIDO!");
        }

        // Testando erro limite
        try {
            Conta cc = new ContaUniversitaria(2332, "fdfsfr11", 1000, pessoa, -500);
            
            cc.depositar(2000);

        } catch (IllegalArgumentException e){
            System.out.println("ERRO: " + e.getMessage());
        } catch (ValorNegativoException erro){
            System.out.println("ERRO: " + erro.getMessage());
        } finally {
            System.out.println("PRIMEIRO PROCESSO CONCLUIDO!");
        }
        
    }
}
