import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("Sistema Bancario");
        System.out.println("\n");

        PessoaFisica pf1 = new PessoaFisica(

                "Leandro",
                "Concordia, BH - MG",
                "222222",
                27,
                'M'
        );


        System.out.println(pf1.toString());

        PessoaFisica pf2 = new PessoaFisica(

                "Xavier",
                "Renascença, BH - MG",
                "12345667",
                72,
                'M'
        );

        System.out.println(pf2.toString());

        if (pf1.equals(pf2)) {
            System.out.println("São iguais\n");
        }
        else {
            System.out.println("São diferentes!\n");
        }

        PessoaJuridica pj1 = new PessoaJuridica(

                "Araujo",
                "Savassi, BH - MG",
                "11111",
                6,
                "Distribuidora"

        );


        System.out.println(pj1.toString());

        PessoaJuridica pj2 = new PessoaJuridica(

                "Alves",
                "Carlos Prates, BH - MG",
                "11111",
                9,
                "Marketing"

        );

        System.out.println(pj2.toString());

        if (pj1.equals(pj2)) {
            System.out.println("São iguais\n");
        }
        else {
            System.out.println("São diferentes!\n");
        }


        Cliente[] clientes = new Cliente[4];

        clientes[0] = pf1;
        clientes[1] = pf2;
        clientes[2] = pj1;
        clientes[3] = pj2;



        System.out.println("Historico Conta");
        System.out.println("\n");


        Conta c1 = new Conta(
                444,
                "22234",
                879,
                pf1,
                1000
        );

        System.out.println(c1.toString());

        Conta c2 = new Conta(
                888,
                "43222",
                978,
                pf2,
                3000
        );

        System.out.println(c2.toString());

        try {
            c1.depositar(-10);
        } catch (ValorNegativoException e) {
            System.out.println(e.getMessage());
        }
        try {
            c1.sacar(-120);
        } catch (ValorNegativoException e) {
            System.out.println(e.getMessage());
        }
        try {
            c1.saque(1200);
        } catch(SemLimiteException v) {
            System.out.print(v.getMessage());
        }
    }

}