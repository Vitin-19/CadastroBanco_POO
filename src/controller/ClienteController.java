package src.controller;

import javax.swing.JOptionPane;

import src.model.Cliente;
import src.service.ClienteService;

public class ClienteController {
    private final ClienteService clienteService = ClienteService.getInstance();

    public void botaoAtualizar(Cliente cliente){
        if(cliente.getNome().isBlank() || cliente.getEndereco().isBlank() || cliente.getTelefone().isBlank() || cliente.getCPF().isBlank()){
            JOptionPane.showMessageDialog(null, "Faltando informações", "Falha na atualização", JOptionPane.ERROR_MESSAGE);
        }

        try{
            final int id = clienteService.consultar(cliente.getCPF()).getId();

            cliente.setId(id);
            clienteService.editar(cliente); 

            JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return;

        }catch(Exception e){
            if(e.getMessage().equals("Faltando informações")){
                JOptionPane.showMessageDialog(null, "Faltando informações", "Falha na atualização", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("Cliente não achado")){
                JOptionPane.showMessageDialog(null, "Cliente não achado", "Falha na atualização", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("cpf invalido")){
                JOptionPane.showMessageDialog(null, "CPF inválido", "Falha na atualização", JOptionPane.ERROR_MESSAGE);
            }
            if(e.getMessage().equals("Nenhum usuário foi achado com esse cpf")){
                JOptionPane.showMessageDialog(null, "Cliente não achado", "Falha na atualização", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
