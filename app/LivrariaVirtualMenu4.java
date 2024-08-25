package app;

import javax.swing.JOptionPane;

public class LivrariaVirtualMenu4 {

    public static void main(String[] args) {
        while (true) {
            // Exibição do menu principal
            String menuPrincipal = "Escolha uma opção:\n"
                    + "1. Cadastrar Livro\n"
                    + "2. Realizar Venda\n"
                    + "3. Listar Livros\n"
                    + "4. Listar Vendas\n"
                    + "5. Sair";

            // Configuração do JOptionPane com título e mensagem personalizada
            String opcaoPrincipal = JOptionPane.showInputDialog(
                    null,
                    menuPrincipal,
                    "Livraria Virtual",
                    JOptionPane.PLAIN_MESSAGE
            );

            // Verifica se o usuário fechou a janela ou clicou em "Cancelar"
            if (opcaoPrincipal == null) {
                break; // Sai do loop
            }

            // Processa a opção escolhida
            switch (opcaoPrincipal) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Opção 'Cadastrar Livro' selecionada.", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    // Código para cadastrar livro
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Opção 'Realizar Venda' selecionada.", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    // Código para realizar venda
                    break;
                case "3":
                    listarLivros();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Opção 'Listar Vendas' selecionada.", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    // Código para listar vendas
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Saindo...", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0); // Sai do programa
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    private static void listarLivros() {
        while (true) {
            // Exibição do submenu para listar livros
            String submenuLivros = "Listar Livros:\n"
                    + "1. Impressos\n"
                    + "2. Eletrônicos\n"
                    + "3. Todos\n"
                    + "4. Voltar";

            // Configuração do JOptionPane com título e mensagem personalizada
            String opcaoLivro = JOptionPane.showInputDialog(
                    null,
                    submenuLivros,
                    "Livraria Virtual",
                    JOptionPane.PLAIN_MESSAGE
            );

            // Verifica se o usuário fechou a janela ou clicou em "Cancelar"
            if (opcaoLivro == null || opcaoLivro.equals("4")) {
                break; // Sai do submenu
            }

            // Processa a opção escolhida
            switch (opcaoLivro) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Listando livros impressos...", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    // Código para listar livros impressos
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Listando livros eletrônicos...", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    // Código para listar livros eletrônicos
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Listando todos os livros...", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    // Código para listar todos os livros
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
}

