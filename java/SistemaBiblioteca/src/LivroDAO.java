import java.sql.PreparedStatement;

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
}
