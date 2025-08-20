import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    
    public void inserir(Produto p) {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
          
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Produto buscarProdutoPorId(Integer id) {
        Produto produto = new Produto();
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);)
        {
            stmt.setInt(3, id);
            stmt.executeQuery();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return produto;
    }

    public void atualizar(Produto p) {
        String sql = "UPDATE FROM produtos nome = ?, preco = ? WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getPreco());
            stmt.setInt(3, p.getId());
            stmt.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletar(Integer id) {
        String sql = "DELETE FROM produtos WHERE id = ?";


        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
 
            stmt.setInt(3, id);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}