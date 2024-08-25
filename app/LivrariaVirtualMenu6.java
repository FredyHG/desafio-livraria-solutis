package app;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LivrariaVirtualMenu6 {

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
                    "Livraria Virtual - Squad 7",
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
                    JOptionPane.showMessageDialog(null, "Saindo...  \n\nAutores:\nPietra, Maria Eduarda, \nRenato, Fredy, \nSyllas, Luiz Carlos.", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);

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

            List<String> livrosImpressos = Arrays.asList(
                    "O Senhor dos Anéis - J.R.R. Tolkien (Impresso)",
                    "Dom Quixote - Miguel de Cervantes (Impresso)"
            );

            List<String> livrosEletronicos = Arrays.asList(
                    "Harry Potter e a Pedra Filosofal - J.K. Rowling (Eletrônico)",
                    "O Pequeno Príncipe - Antoine de Saint-Exupéry (Eletrônico)"
            );

            List<String> livrosTodos = Stream.concat(livrosImpressos.stream(), livrosEletronicos.stream())
                    .collect(Collectors.toList());

            StringBuilder listaDeLivros = new StringBuilder();

            switch (opcaoLivro) {
                case "1":
                    listaDeLivros.append("Livros Impressos:\n");
                    livrosImpressos.forEach(livro -> listaDeLivros.append(livro).append("\n"));
                    break;
                case "2":
                    listaDeLivros.append("Livros Eletrônicos:\n");
                    livrosEletronicos.forEach(livro -> listaDeLivros.append(livro).append("\n"));
                    break;
                case "3":
                    listaDeLivros.append("Todos os Livros:\n");
                    livrosTodos.forEach(livro -> listaDeLivros.append(livro).append("\n"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Livraria Virtual", JOptionPane.PLAIN_MESSAGE);
                    continue;
            }

            // Exibe a lista de livros em uma caixa de diálogo
            JOptionPane.showMessageDialog(
                    null,
                    listaDeLivros.toString(),
                    "Livraria Virtual",
                    JOptionPane.PLAIN_MESSAGE
            );
        }
    }
}

