import java.util.List;
import java.util.Scanner;

public class Main {

    private static ProdutoDAO produtoDao = new ProdutoDAO();

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        int opc = 0;

        while (opc != 5) {
            System.out.println("Escolha uma opção:\n 1 - Inserir | 2 - Listar | 3 - Atualizar | 4 - Deletar");

            opc = teclado.nextInt();

            switch (opc) {
                case 1:
                    inserir();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    atualizar();
                    break;

                case 4:
                    deletar();
                    break;

                default:
                    break;
            }

        }
    }

    private static void deletar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    private static void atualizar() {
        try {
            System.out.println("ALTERAÇÃO DE PRODUTO\n");
            System.out.println("Digite o ID do produto : ");
            int id = teclado.nextInt();
            teclado.next();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static void listar() {
        try {
            List<Produto> produtos = produtoDao.listar();
            System.out.println("LISTA DE PRODUTOS\n");
            for (Produto produto : produtos) {
                System.out.println("Produto #"+produto.getId());
                System.out.println("Produto: "+produto.getNome());
                System.out.println("Preço: "+produto.getPreco());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar a tabela de produtos - "+e.getMessage());
        }
    }

    private static void inserir() {
        Produto novoProduto = new Produto();
        System.out.println("NOVO PRODUTO");
        System.out.println("Digite o nome do produto:");
        novoProduto.setNome(teclado.nextLine());
        System.out.println("Digite o preço do produto:");
        novoProduto.setPreco(teclado.nextDouble());
        teclado.next();
        try {
            produtoDao.inserir(novoProduto);
            System.out.println("Produto cadastrado!!!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o produto - "+e.getMessage());
        }
    }
}