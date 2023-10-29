import java.util.Date;

public class PessoaFisica extends Cliente {

    String cpf;
    int idade;
    char sexo;

    public PessoaFisica(String nome, String endereco, String cpf, int idade, char sexo){

        this.nome = nome;
        this.endereco = endereco;
        data = new Date();

        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;

    }

    public PessoaFisica(String nome, String cpf, int idade, char sexo){

        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    public PessoaFisica(String cpf, int idade, char sexo){

        this.cpf = "null";
        this.idade = 0;
        this.sexo = 0;
    }

    public String toString() {
        String PessoaFisicaStr = "Nome: " + this.nome + "\n" +
                "CPF: " + this.cpf + "\n" +
                "SEXO: " + this.sexo + "\n" +
                "IDADE: " + this.idade + "\n";

    return PessoaFisicaStr;
    }

    public boolean equals(Object obj) {

        PessoaFisica objPessoaFisica = (PessoaFisica) obj;
        if (this.cpf.equals(objPessoaFisica.cpf)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean autenticar(String chave) {
        if(chave.equals(this.cpf)) {
            return true;
        } else {
            return false;
        }
    }

}