package src.model;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String CPF;

    public Pessoa(String nome, String endereco, String telefone, String cpf){
        this.nome = nome;
        this.endereco = endereco.toLowerCase();
        this.telefone = telefone;
        this.CPF = cpf;
    }

    // Get e set
    public String getNome(){ return this.nome; }
    public void setNome(String nome){ this.nome = nome.toUpperCase(); }

    public String getEndereco(){ return this.endereco; }
    public void setEndereco(String endereco){ this.endereco = endereco.toLowerCase(); }

    public String getTelefone(){ return this.telefone; }
    public void setTelefone(String telefone){ this.telefone = telefone; }

    public String getCPF(){ return this.CPF; }
    public void setCPF(String CPF){ this.CPF = CPF; }
}
