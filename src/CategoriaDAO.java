import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements IDao<Categoria>{

    @Override
    public void inserir(Categoria obj) {
         String sql = "INSERT INTO categorias (nome, ativo) VALUES (?, ?)";
          
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getAtivo());
            stmt.executeUpdate();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Categoria obj) {
        String sql = "UPDATE FROM categorias nome = ?, ativo = ? WHERE id = ?";
        
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getAtivo());
            stmt.setInt(3, obj.getId());
            stmt.executeUpdate();

            stmt.close();
            conn.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM categorias WHERE id = ?";

        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){
 
            stmt.setInt(3, id);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }

    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            
            while(rs.next()) {
                lista.add(new Categoria(
                    rs.getInt("id"), 
                    rs.getString("nome"), 
                    rs.getString("ativo")));
            }
            
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        Categoria categoria = new Categoria();
        String sql = "SELECT * FROM categorias WHERE id = ?";
        try (Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setInt(3, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            categoria.setId(rs.getInt("id"));
            categoria.setNome(rs.getString("nome"));
            categoria.setAtivo(rs.getString("ativo"));

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoria;
    }
    
}
