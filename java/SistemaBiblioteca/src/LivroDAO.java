import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.mariadb.jdbc.client.result.Result;

public class LivroDAO {
    public void inserir(Livro livro) {
        ConectaDB conexao = new ConectaDB();
        String sql = "INSERT INTO livro(titulo, autor, ano) VALUES (?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAno_publicacao());
            pst.execute();
            System.out.println("O livro " + livro.getTitulo() + " foi inserido com sucesso.");
        } catch (Exception e) {
            System.out.println("Falha na execução: " + e);
        }

    }

    public LinkedList<Livro> listarTodos() {
        ConectaDB conexao = new ConectaDB();
        String sql = "SELECT * FROM livro ORDER BY idLivro";
        LinkedList<Livro> lista = new LinkedList<>();
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            ResultSet resultados = pst.executeQuery();
            // executar consulta
            while (resultados.next()) {
                // recuperando dados do banco
                String titulo = resultados.getString("titulo");
                String autor = resultados.getString("autor");
                int ano = resultados.getInt("ano");
                int id = resultados.getInt("idLivro");
                // cria objeto java
                Livro obj = new Livro(titulo);
                obj.setAutor(autor);
                obj.setAno_publicacao(ano);
                obj.setId(id);
                // adicionar na lista
                lista.add(obj);

            }
            return lista;
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os livros: " + e.getMessage());
        }
        return null;
    }

    public Livro consultar(int id) {
        ConectaDB conexao = new ConectaDB();
        String sql = "SELECT * FROM livro where idLivro = ?";
        Livro livro = null;
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet resultado = pst.executeQuery();
            // executar consulta
            if (resultado.next()) {
                // recuperando dados do banco
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                int ano = resultado.getInt("ano");
                int idLivro = resultado.getInt("idLivro");
                // cria objeto livro e popula
                livro = new Livro(titulo);
                livro.setAutor(autor);
                livro.setAno_publicacao(ano);
                livro.setId(idLivro);
                return livro;
            } else {
                System.out.println("Não há registro com o id = " + id);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar livro: " + e.getMessage());
        }
        return livro;
    }

    public void excluir(int id) {
        ConectaDB conexao = new ConectaDB();
        String sql = "DELETE FROM livro where idLivro = ?";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, id);
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                System.out.println("Livro excluído com sucesso!");
            } else {
                System.out.println("Livro com id = " + id + " não encontrado!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao remover livro: " + e.getMessage());
        }
    }


    public void alterar(Livro livro) {
        ConectaDB conexao = new ConectaDB();
        String sql = "UPDATE livro SET titulo = ?, autor = ?, ano = ? WHERE idLivro = ?";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setString(1, livro.getTitulo());
            pst.setString(2, livro.getAutor());
            pst.setInt(3, livro.getAno_publicacao());
            pst.setInt(4, livro.getId());
            int resultado = pst.executeUpdate();
            if (resultado > 0) {
                System.out.println("O livro " + livro.getTitulo() + " foi alterado com sucesso.");
            } else {
                System.out.println("Livro com id = " + livro.getId() + " não encontrado!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao alterar livro: " + e.getMessage());
        }
    }
    
}
