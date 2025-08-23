package src.controller;

import java.util.ArrayList;

import src.model.Cliente;

public class ClienteController implements Metodos{
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void gravar(Cliente newCliente) throws Exception{
        if(newCliente.getNome().isBlank() || newCliente.getEndereco().isBlank() || newCliente.getTelefone().isBlank() || newCliente.getCPF().isBlank() ){
            throw new Exception("Faltando informações");
        }

        newCliente.setId(clientes.size() + 1);
        clientes.add(newCliente);
    }

    public void excluir(int id) throws Exception{
        boolean achado = false;

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId() == 1){
                achado = true;
                clientes.remove(i);
                break;
            }
        }

        if(!achado) throw new Exception("Cliente não achado");
    }
}
