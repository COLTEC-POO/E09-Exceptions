public class Main {
    public static void main (String[]args){

        //cadastro pessoas juridica

        PessoaJuridica Sorvebao=new PessoaJuridica();
        Sorvebao.setNome("Sorvebao");
        Sorvebao.setEndereco("Rua da Prata,111 - Itabirito");
        Sorvebao.setCnpj("11.101.102/0001-99");
        Sorvebao.setNumFuncionarios(50);
        Sorvebao.setSetor("Alimenticio");

        PessoaJuridica Poneiloja=new PessoaJuridica();
        Sorvebao.setNome("Poneiloja");
        Sorvebao.setEndereco("Rua da Prata,20 - Itabirito");
        Sorvebao.setCnpj("11.101.102/0001-99");
        Sorvebao.setNumFuncionarios(12);
        Sorvebao.setSetor("Alimenticio");

        //cadastro pessoas fisicas
        //Jonas
        PessoaFisica Jonas=new PessoaFisica();
        Jonas.setNome("Jonas");
        Jonas.setEndereco("Rua C,20-Horto");
        Jonas.setcpf("001.002.003-55");
        Jonas.setidade(18);
        Jonas.setGenero('m');

        //Samuel
        PessoaFisica Samuel=new PessoaFisica();
        Samuel.setNome("Samuel");
        Samuel.setEndereco("Rua D,25-Horto");
        Samuel.setcpf("001.002.003-55");
        Samuel.setidade(37);
        Samuel.setGenero('m');

        //Camila
        PessoaFisica Camila=new PessoaFisica();
        Camila.setNome("Camila");
        Camila.setEndereco("Rua E,30-Pampulha");
        Camila.setcpf("001.002.003-18");
        Camila.setidade(29);
        Camila.setGenero('f');


        //inicialização das Contas
        Conta jonas= new ContaCorrente(Jonas,1);
        //jonas.setLimite(200);
        jonas.setNumero("1");
        Conta samuel= new ContaPoupanca(Samuel,2);
        //samuel.setLimite(500);
        samuel.setNumero("1");
        Conta camila= new ContaUniversitaria(Camila,3);
        //camila.setLimite(800);
        Conta sorvebao=new ContaCorrente(Sorvebao,55);
       // sorvebao.setLimite(25000);


        //logs do sistema
        System.out.println("Total de contas:"+Conta.totalContas);
        float numOpTotal=camila.numeroOp+ samuel.numeroOp;
        System.out.println("Total de operações:"+ numOpTotal);
        float media=numOpTotal/Conta.totalContas;
        System.out.println("Média de operações:"+media);

        //testando toString
        //testando toString para pessoa fisica
        System.out.println("Resultado da chamada toString para pessoa fisica:");
        System.out.println(Jonas);
        //testando toString para pessoa juridica
        System.out.println("Resultado da chamada toString para pessoa juridica:");
        System.out.println(Sorvebao.toString());
        //testando toString para pessoa Conta
        System.out.println("Resultado da chamada toString para conta de pessoa fisica:");
        System.out.println(jonas.toString());
        System.out.println("Resultado da chamada toString para conta de pessoa juridica:");
        System.out.println(sorvebao.toString());

        //testando equals
        //testando equals Pessoa Juridica -Não está funcionando
        if(Sorvebao.equals(Poneiloja)){
            System.out.println("São iguais.");
        }
        else{
            System.out.println("São diferentes!");
        }
        //testando equals Pessoa Fisica
        if(Jonas.equals(Samuel)){
            System.out.println("São iguais.");
        }
        else{
            System.out.println("São diferentes!");
        }
        //testando equals para conta
        if(jonas.equals(samuel)){
            System.out.println("São iguais.");
        }
        else{
            System.out.println("São diferentes!");
        }
        //testando o metodo autenticar
        if(Jonas.autenticar("000"))
            System.out.println("Está autenticado!");
        else
            System.out.println("Não está autenticado!");

        if(Sorvebao.autenticar("11.101.102/0001-99"))
            System.out.println("Está autenticado!");
        else
            System.out.println("Não está autenticado!");

        sorvebao.imprimirExtratoTaxas();
        //sorvebao.imprimirExtrato(1);

       /*
       //imprimindo os extratos das contas
        System.out.println("*Extrato "+ Jonas.getNome());
        jonas.imprimirExtrato(1);
        System.out.println();
        System.out.println("*Extrato "+ Jonas.getNome());
        jonas.imprimirExtrato(2);
        System.out.println();
        System.out.println("*Extrato "+ Samuel.getNome());
        samuel.imprimirExtrato(1);
        System.out.println();System.out.println("*Extrato "+ Camila.getNome());
        camila.imprimirExtrato(1);
        System.out.println();
        System.out.println("*Extrato "+ Sorvebao.getNome());
        sorvebao.imprimirExtrato(2);
        System.out.println();
        */


        //Tratamento de exceções
        //testes
        try{

            //depositando dinheiro na conta
            jonas.depositar(800);
            samuel.depositar(1500);
            camila.depositar(2500);
            sorvebao.depositar(30000);

            //sacando dinheiro na conta
            jonas.sacar(500);
            jonas.sacar(50);
            jonas.sacar(18);
            samuel.sacar(100);
            camila.sacar(150);
            sorvebao.sacar(1230);
            sorvebao.sacar(250);


            //testando depositar valores negativos
            //jonas.depositar(-50);
            //samuel.depositar(-35);

            //testando sacar valores negativos
           // sorvebao.sacar(-1);
            //samuel.sacar(-35);

            //testando sacar fora do limite
            //sorvebao.sacar(500000);

            //testando os limites das contas criadas
            //conta corrente: limite entre 500 e 1000
           jonas.setLimite(-50);


        }catch( ValorNegativoException e){
            System.out.println(e.getMessage());

        }catch( SemLimiteException e){
            System.out.println(e.getMessage());

        }finally {
            //ultimos comandos que serão executados no bloco try catch
            System.out.println("Obrigado por utilizar o sistema!");
        }

    }

}
