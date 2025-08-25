package src.service;

public interface Metodos<T> {
    public void gravar(T obj) throws Exception;
    public void editar(T obj) throws Exception;
    public void excluir(int id) throws Exception;
    public T consultar(int num) throws Exception;
    public void cancelar() throws Exception;
}   
