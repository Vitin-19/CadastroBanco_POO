package src.service;

import java.util.ArrayList;

import src.model.Cliente;

public class ClienteService implements Metodos<Cliente>{
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public void gravar(Cliente cliente) throws Exception{
        if(cliente.getNome().isBlank() || cliente.getEndereco().isBlank() || cliente.getTelefone().isBlank() || cliente.getCPF().isBlank() ){
            throw new Exception("Faltando informações");
        }

        cliente.setId(clientes.size() + 1);
        clientes.add(cliente);
    }

    @Override
    public void excluir(int id) throws Exception{
        boolean achado = false;
        if(id <= 0){
            throw new Exception("id inválido");
        }

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId() == id){
                achado = true;
                clientes.remove(i);
                break;
            }
        }

        if(!achado) throw new Exception("Cliente não achado");
    }

    @Override
    public void editar(Cliente cliente) throws Exception{
        if(cliente.getNome().isBlank() || cliente.getEndereco().isBlank() || cliente.getTelefone().isBlank() || cliente.getCPF().isBlank() || cliente.getId() <= 0){
            throw new Exception("Faltando informações");
        }

        final int id = cliente.getId();
        boolean achado = false;

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId() == id){
                clientes.get(i).setCPF(cliente.getCPF());
                clientes.get(i).setEndereco(cliente.getEndereco());
                clientes.get(i).setNome(cliente.getNome());
                clientes.get(i).setTelefone(cliente.getTelefone());

                achado = true;
                break;
            }
        }
        
        if(!achado) throw new Exception("Cliente não achado");

    }

    @Override
    public Cliente consultar(int id) throws Exception{
        if(id <= 0) throw new Exception("id inválido");
        
        boolean achado = true;

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId() == id) return clientes.get(i);
        }

        if (!achado) throw new Exception("Cliente não achado");
        return new Cliente(null, null, null, null);
    }

    @Override
    public void cancelar(){
        return;
    }
}
