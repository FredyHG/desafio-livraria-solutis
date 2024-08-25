package app;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import java.awt.Font;

public class LivrariaVirtualMenu5 {

    public static void main(String[] args) {
        // Define a fonte padrão para JOptionPane
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 16));
        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 16));

        int contador = 0;

        while (true) {
            contador++; // Incrementa o contador a cada vez que o menu é exibido

            String menuPrincipal = "Escolha uma opção:\n"
                    + "1. Cadastrar Livro\n"
                    + "2. Realizar Venda\n"
                    + "3. Listar Livros\n"
                    + "4. Listar Vendas\n"
                    + "5. Sair";

            String opcaoPrincipal = JOptionPane.showInputDialog(
                    null,
                    menuPrincipal,
                    "Livraria Virtual",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (opcaoPrincipal == null) {
                break; // Sai do loop se o usuário cancelar ou fechar a janela
            }

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
                    // Exibe a mensagem de despedida e encerra após um atraso
                    JOptionPane.showMessageDialog(null, "Saindo...  ", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);

                    // Cria um Timer para encerrar o programa após um pequeno atraso (1 segundo)
                    Timer timer = new Timer(1000, e -> System.exit(0));
                    timer.setRepeats(false); // O Timer só deve executar uma vez
                    timer.start();

                    // Pausa a execução até que o Timer feche o programa
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
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

            String opcaoLivro = JOptionPane.showInputDialog(
                    null,
                    submenuLivros,
                    "Livraria Virtual",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (opcaoLivro == null || opcaoLivro.equals("4")) {
                break; // Sai do submenu
            }

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

