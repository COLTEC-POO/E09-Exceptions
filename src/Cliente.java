import java.util.Date;


public abstract class Cliente {

    String nome;
    String endereco;
    Date data;

    public Cliente(String nome, int cpf, String endereco){

        this.nome = nome;
        this.endereco = endereco;
        data = new Date();
    }

    public Cliente() {

        this.endereco = "null";
        this.nome = "null";
    }

    public void imprimir() {

        System.out.println("Endereco: " + this.endereco);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data: " + this.data);

    }

    public abstract boolean autenticar (String chave);

}
