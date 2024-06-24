import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.mariadb.jdbc.client.result.Result;
public class UsuarioDAO {
    public void inserir(Usuario usuario) {
        ConectaDB conexao = new ConectaDB();
        String sql = "INSERT INTO usuario(nome, email) VALUES (?,?)";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.execute();
            System.out.println("O usuário " + usuario.getNome() + " foi cadastrado com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha na execução: " + e);
        }

    }

    public LinkedList<Usuario> listarTodos() {
        ConectaDB conexao = new ConectaDB();
        String sql = "SELECT * FROM usuario ORDER BY idUsuario";
        LinkedList<Usuario> lista = new LinkedList<>();
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            ResultSet resultados = pst.executeQuery();
            // executar consulta
            while (resultados.next()) {
                // recuperando dados do banco
                String nome = resultados.getString("nome");
                String email = resultados.getString("email");
                int id = resultados.getInt("idUsuario");
                // cria objeto java
                Usuario obj = new Usuario(nome, email);
                obj.setId(id);
                // adicionar na lista
                lista.add(obj);

            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os usuários: " + e.getMessage());
        }
        return null;
    }

    public Usuario consultar(int id) {
        ConectaDB conexao = new ConectaDB();
        String sql = "SELECT * FROM usuario where idUsuario = ?";
        Usuario usuario = null;
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultado = pst.executeQuery();
            // executar consulta
            if (resultado.next()) {
                // recuperando dados do banco
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                int idUsuario = resultado.getInt("idUsuario");
                // cria objeto livro e popula
                usuario = new Usuario(nome, email);
                usuario.setId(idUsuario);
                return usuario;
            } else {
                System.out.println("Não há registro com o id = " + id);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar usuário: " + e.getMessage());
        }
        return usuario;
    }

    public void excluir(int id) {
        ConectaDB conexao = new ConectaDB();
        String sql = "DELETE FROM usuario where idUsuario = ?";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, id);
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                System.out.println("Usuário excluído com sucesso!");
            } else {
                System.out.println("Usuário com id = " + id + " não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
    }


    public void alterar(Usuario usuario) {
        ConectaDB conexao = new ConectaDB();
        String sql = "UPDATE usuario SET nome = ?, email = ? WHERE idUsuario = ?";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setInt(3, usuario.getId());
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                System.out.println("O usuário " + usuario.getNome() + " foi alterado com sucesso.");
            } else {
                System.out.println("Usuário com id = " + usuario.getId() + " não encontrado!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao alterar usuário: " + e.getMessage());
        }
    }
}

