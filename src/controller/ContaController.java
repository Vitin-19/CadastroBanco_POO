package src.controller;

import javax.swing.JOptionPane;

import src.model.Cliente;
import src.model.Conta;
import src.service.ClienteService;
import src.service.ContaService;

public class ContaController {
    private final ClienteService clienteService = ClienteService.getInstance();
    private final ContaService contaService = ContaService.getInstance();

    public void botaoConsultar(Conta conta, Cliente cliente){
        try{
            Cliente clienteAchado = clienteService.consultar(cliente.getCPF());

            if(!clienteAchado.getEndereco().equals(cliente.getEndereco()) || !clienteAchado.getNome().equals(cliente.getNome()) || !clienteAchado.getTelefone().equals(cliente.getTelefone())){
                JOptionPane.showMessageDialog(null, "Dados não correspondentes", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Conta contaAchada = contaService.consultar(conta.getNumero());
            String menssagem = 
            "Agência: " + contaAchada.getAgencia() + "\n" +
            "Número: " + contaAchada.getNumero() + "\n" +
            "Saldo: R$" + contaAchada.getSaldo(); 

            JOptionPane.showMessageDialog(null, menssagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        }catch(Exception e){
            if(e.getMessage().contains("invalido")) {
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("Nenhum usuário foi achado com esse cpf")){
                JOptionPane.showMessageDialog(null, "Cpf ainda não cadastrado", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("conta não achada")){
                JOptionPane.showMessageDialog(null, "Conta não encontrada", "Falha na consulta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void botaoCriarConta(Cliente cliente, Conta conta){
        if(cliente.getNome().isBlank() || cliente.getEndereco().isBlank() || cliente.getTelefone().isBlank() || cliente.getCPF().isBlank() ){
            JOptionPane.showMessageDialog(null, "Faltando informações", "Falha na criação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(conta.getAgencia() <= 0){
            JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na criação", JOptionPane.ERROR_MESSAGE);
        }
        try{
            clienteService.gravar(cliente);
            int numero = contaService.gravar(conta).getNumero();

            JOptionPane.showMessageDialog(null, "Conta criada com sucesso\nNúmero da conta: "+ numero, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            if(e.getMessage().equals("Informações inválidas") || e.getMessage().equals("cpf invalido")){
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na criação", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("Faltando informações")){
                JOptionPane.showMessageDialog(null, "Faltando informações", "Falha na criação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void botaoSacar(int agencia, int numero, double valor){
        try{
            if(agencia <= 0 || numero <= 0 || valor <= 0){
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na transação", JOptionPane.ERROR_MESSAGE);
            }

            contaService.sacar(agencia, numero, valor);

            JOptionPane.showMessageDialog(null, "Transação realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            if(e.getMessage().equals("Informações inválidas") || e.getMessage().equals("número invalido")){
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na transação", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("conta não achada")){
                JOptionPane.showMessageDialog(null, "Conta não encontrada", "Falha na transação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void botaoDepositar(int agencia, int numero, double valor){
        try{
            if(agencia <= 0 || numero <= 0 || valor <= 0){
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na transação", JOptionPane.ERROR_MESSAGE);
            }

            contaService.depositar(agencia, numero, valor);

            JOptionPane.showMessageDialog(null, "Transação realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            if(e.getMessage().equals("Informações inválidas") || e.getMessage().equals("número invalido")){
                JOptionPane.showMessageDialog(null, "Dados inválidos", "Falha na transação", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("conta não achada")){
                JOptionPane.showMessageDialog(null, "Conta não encontrada", "Falha na transação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
