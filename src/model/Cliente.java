package src.model;

public class Cliente extends Pessoa{
    private int id;

    public Cliente(String nome, String endereco, String telefone, String cpf){
        super(nome, endereco, telefone, cpf);
    }

    // get e set

    public int getId(){ return this.id; }
    public void setId(int id){ this.id = id; }
    
}
