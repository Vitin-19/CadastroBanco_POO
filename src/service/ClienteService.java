package src.service;

import java.util.ArrayList;

import src.model.Cliente;

public class ClienteService implements Metodos<Cliente>{
    private static ClienteService instance;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private ClienteService(){}

    public static ClienteService getInstance(){
        if (instance == null) instance = new ClienteService();
        return instance;
    }

    @Override
    public Cliente gravar(Cliente cliente) throws Exception{
        if(cliente.getNome().isBlank() || cliente.getEndereco().isBlank() || cliente.getTelefone().isBlank() || cliente.getCPF().isBlank() ){
            throw new Exception("Faltando informações");
        }

        for (Cliente clienteFor : clientes) {
            if(clienteFor.getCPF().equals(cliente.getCPF())) throw new Exception("cpf invalido");
        }

        cliente.setId(clientes.size() + 1);
        clientes.add(cliente);
        return cliente;
    }

    @Override
    public void excluir(int id) throws Exception{
        boolean achado = false;
        if(id <= 0){
            throw new Exception("id invalido");
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
        if(id <= 0) throw new Exception("id invalido");
        

        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getId() == id) return clientes.get(i);
        }

        throw new Exception("Cliente não achado");
    }
    
    public Cliente consultar(String cpf) throws Exception{
        if(cpf.isEmpty() || cpf.length() != 11) throw new Exception("cpf invalido");

        for (Cliente cliente : clientes) {
            if(cliente.getCPF().equals(cpf)) return cliente;
        }

        throw new Exception("Nenhum usuário foi achado com esse cpf");
    }

    @Override
    public void cancelar(){
        return;
    }
}
