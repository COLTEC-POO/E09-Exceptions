import java.util.Date;

public class PessoaJuridica extends Cliente{

    String cnpj;
    int numFuncionarios;
    String setor;

    public PessoaJuridica(String nome, String endereco, String cnpj, int numFuncionarios, String setor){

        this.nome = nome;
        this.endereco = endereco;
        data = new Date();

        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;

    }

    public PessoaJuridica(String nome, String cnpj, int numFuncionarios, String setor){

        this.nome = nome;
        this.cnpj = cnpj;
        this.numFuncionarios = numFuncionarios;
        this.setor = setor;


    }

    public PessoaJuridica( String cnpj, int numFuncionarios, String setor){

        this.cnpj = "null";
        this.numFuncionarios = 0;
        this.setor = "null";

    }

    public String toString() {
        String PessoaJuridicaStr = "Nome: " + this.nome + "\n" +
                "CNPJ: " + this.cnpj + "\n" +
                "SETOR: " + this.setor + "\n" +
                "FUNCIONARIOS: " + this.numFuncionarios + "\n";

        return PessoaJuridicaStr;
    }

    public boolean equals(Object obj) {

        PessoaJuridica objPessoaJuridica = (PessoaJuridica) obj;
        if (this.cnpj.equals(objPessoaJuridica.cnpj)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean autenticar(String chave) {
        if(chave.equals(this.cnpj)) {
            return true;
        } else {
            return false;
        }
    }

}
