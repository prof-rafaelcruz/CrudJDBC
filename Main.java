import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO produtoDao = new ProdutoDAO();

        Scanner teclado = new Scanner(System.in);

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    private static void listar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

    private static void inserir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }
}