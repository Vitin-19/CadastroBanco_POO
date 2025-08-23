package src.model;

public abstract class Conta {
    private int agencia;
    private long numero;
    private double saldo;

    public Conta(int agencia, long numero, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    // get e set

    public int getAgencia(){ return this.agencia; }
    public void setAgencia(int agencia){ this.agencia = agencia; }

    public long getNumero(){ return this.numero; }
    public void setNumero(long numero){ this.numero = numero; }

    public double getSaldo(){ return this.saldo; }
    public void setSaldo(double saldo){ this.saldo = saldo; }

}
