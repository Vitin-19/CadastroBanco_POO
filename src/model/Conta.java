package src.model;

public abstract class Conta {
    private int agencia = 0;
    private int numero = 0;
    private double saldo = 0;

    public Conta(int agencia, int numero, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }
    public Conta(){}

    // get e set

    public int getAgencia(){ return this.agencia; }
    public void setAgencia(int agencia){ this.agencia = agencia; }

    public int getNumero(){ return this.numero; }
    public void setNumero(int numero){ this.numero = numero; }

    public double getSaldo(){ return this.saldo; }
    public void setSaldo(double saldo){ this.saldo = saldo; }

}
