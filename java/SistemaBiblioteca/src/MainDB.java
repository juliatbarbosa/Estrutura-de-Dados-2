public class MainDB {
    public static void main(String[] args) {
        Livro liv = new Livro("O Senhor dos Anéis", "J. R. R Tolkien", 1953);

        LivroDAO objDAO = new LivroDAO();
        objDAO.inserir(liv);
    }
}
