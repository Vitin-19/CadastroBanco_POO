package src.service;

import java.util.ArrayList;
import java.util.Random;

import src.model.Conta;

public class ContaService implements Metodos<Conta>{
    private static ContaService instance;
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    private ContaService(){};

    public static ContaService getInstance(){
        if (instance == null) instance = new ContaService();
        return instance;
    }

    @Override
    public Conta gravar(Conta conta) throws Exception{
        if(conta.getAgencia() <= 0){
            throw new Exception("Informações inválidas");
        }

        
        conta.setNumero(gerarNumero());

        while(!verificarNumero(conta.getNumero())){
            conta.setNumero(gerarNumero());
        }
        
        contas.add(conta);
        System.out.println(conta.getNumero());
        return conta;
    }

    @Override
    public void editar(Conta conta) throws Exception{
        if(conta.getAgencia() <= 0 || conta.getNumero() <= 0){
            throw new Exception("Informações inválidas");
        }

        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumero() == conta.getNumero()){
                contas.get(i).setAgencia(conta.getAgencia());
            }
        }
    }

    @Override
    public void excluir(int numero) throws Exception{
        if(numero <= 0){
            throw new Exception("número invalido");
        }

        boolean achado = false;

        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumero() == numero){
                contas.remove(i);
                achado = true;
                break;
            }
        }

        if(!achado) throw new Exception("conta não achada");
    }

    @Override
    public Conta consultar(int numero) throws Exception{
        if(numero <= 0){
            throw new Exception("número invalido");
        }

        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumero() == numero) return contas.get(i);
        }

        throw new Exception("conta não achada");
    }

    @Override
    public void cancelar(){
        return;
    }

    public void sacar(int agencia, int numero, double valor) throws Exception{
        if(agencia <= 0 || numero <= 0){
            throw new Exception("Informações inválidas");
        }

        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumero() == numero){
                contas.get(i).setSaldo(contas.get(i).getSaldo() - valor);
                return;
            }
        }

        throw new Exception("conta não achada");
    }

    public void depositar(int agencia, int numero, double valor) throws Exception{
        if(agencia <= 0 || numero <= 0){
            throw new Exception("Informações inválidas");
        }

        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumero() == numero){
                contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                return;
            }
        }

        throw new Exception("conta não achada");
    }

    public int gerarNumero(){
        Random gerador = new Random();
        return Math.abs(gerador.nextInt());
    }

    public boolean verificarNumero(int numero){
        for (Conta conta : contas) {
            if(conta.getNumero() == numero){
                return false;
            }
        }
        return true;
    }
}
