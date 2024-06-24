import java.util.LinkedList;

public class MainDB {
    public static void main(String[] args) {

        System.out.println("\n\n ********** LIVROS ********** \n");

        System.out.println("INSERINDO LIVROS...\n");

        Livro liv = new Livro("Teste2");
        liv.setAutor("Teste2");
        liv.setAno_publicacao(2005);

        LivroDAO objDAO = new LivroDAO();
        objDAO.inserir(liv);

        System.out.println("\n\nLISTANDO TODOS OS LIVROS...\n");
        LinkedList<Livro> dados = objDAO.listarTodos();
        System.out.println(dados);

        System.out.println("\n\nBUSCANDO LIVRO POR ID...\n");
        Livro liv2 = objDAO.consultar(9);
        if (liv2 != null) {
            System.out.println(liv2);
        }

        
        Livro liv3 = new Livro("Teste3");
        liv3.setAutor("Teste2");
        liv3.setAno_publicacao(2010);
        liv3.setId(9);
        
        System.out.println("\n\nALTERANDO LIVRO...\n");
        objDAO.alterar(liv3);
        
        System.out.println("\n\nEXCLUINDO LIVRO POR ID...\n");
        objDAO.excluir(7);

        System.out.println("\n\nLISTANDO TODOS OS LIVROS...\n");
        LinkedList<Livro> dados2 = objDAO.listarTodos();
        System.out.println(dados2);

        
        System.out.println("\n\n ********** USUÁRIOS ********** \n");

        System.out.println("INSERINDO USUÁRIOS...\n");

        Usuario user1 = new Usuario("Julia Teixeira Barbosa", "julia@email.com");
        Usuario user2 = new Usuario("Rafael Peres Ferreira", "rafael@email.com");

        UsuarioDAO objDAO_usu = new UsuarioDAO();
        objDAO_usu.inserir(user1);
        objDAO_usu.inserir(user2);

        System.out.println("\n\nLISTANDO TODOS OS USUÁRIOS...\n");

        LinkedList<Usuario> dadosUsu = objDAO_usu.listarTodos();
        System.out.println(dadosUsu);
        
        System.out.println("\n\nBUSCANDO USUÁRIOS POR ID...\n");
        
        Usuario user = objDAO_usu.consultar(2);
        if (user != null) {
            System.out.println(user);
        }

        System.out.println("\n\nALTERANDO USUÁRIOS...\n");

        Usuario user3 = new Usuario("Giseli Teixeira", "giseli@email.com");
        user3.setId(2);
        objDAO_usu.alterar(user3);
        
        System.out.println("\n\nREMOVENDO USUÁRIOS POR ID...\n");

        objDAO_usu.excluir(3);
        objDAO_usu.excluir(2);
        
        System.out.println("\n\nLISTANDO TODOS OS USUÁRIOS...\n");

        LinkedList<Usuario> dadosUsu2 = objDAO_usu.listarTodos();
        System.out.println(dadosUsu2);
       
        
    }
}
