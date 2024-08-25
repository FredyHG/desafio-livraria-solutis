package app;

import javax.swing.JOptionPane;

public class LivrariaVirtualMenu3 {

    public static void main(String[] args) {
        while (true) {
            String menuPrincipal = "Escolha uma opção:\n"
                    + "1. Cadastrar Livro\n"
                    + "2. Realizar Venda\n"
                    + "3. Listar Livros\n"
                    + "4. Listar Vendas\n"
                    + "5. Sair";

            String opcaoPrincipal = JOptionPane.showInputDialog(menuPrincipal);

            if (opcaoPrincipal == null) {
                break; // Sai do loop se o usuário cancelar ou fechar a janela
            }

            switch (opcaoPrincipal) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Opção 'Cadastrar Livro' selecionada.");
                    // Código para cadastrar livro
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Opção 'Realizar Venda' selecionada.");
                    // Código para realizar venda
                    break;
                case "3":
                    listarLivros();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Opção 'Listar Vendas' selecionada.");
                    // Código para listar vendas
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0); // Sai do programa
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void listarLivros() {
        while (true) {
            String submenuLivros = "Listar Livros:\n"
                    + "1. Impressos\n"
                    + "2. Eletrônicos\n"
                    + "3. Todos\n"
                    + "4. Voltar";

            String opcaoLivro = JOptionPane.showInputDialog(submenuLivros);

            if (opcaoLivro == null || opcaoLivro.equals("4")) {
                break; // Sai do submenu se o usuário escolher "Voltar" ou fechar a janela
            }

            switch (opcaoLivro) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Listando livros impressos...");
                    // Código para listar livros impressos
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Listando livros eletrônicos...");
                    // Código para listar livros eletrônicos
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Listando todos os livros...");
                    // Código para listar todos os livros
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}


