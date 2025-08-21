import java.util.List;

public interface IDao<T> {

    void inserir(T obj);
    void atualizar(T obj);
    void deletar(Integer id);
    List<T> listar();
    T buscarPorId(Integer id);
} 
