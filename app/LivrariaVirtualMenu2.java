package app;

import javax.swing.JOptionPane;

public class LivrariaVirtualMenu2 {

    public static void main(String[] args) {
        while (true) {
            // Opções do menu
            String[] opcoes = {
                    "Registrar Livro",
                    "Fazer Venda",
                    "Visualizar Vendas",
                    "Sair"
            };

            // Exibe o menu e recebe a escolha do usuário
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Menu Livraria Virtual",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            // Tratamento da escolha do usuário
            switch (escolha) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Opção 'Registrar Livro' selecionada.");
                    // Aqui você pode adicionar o código para registrar um livro
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Opção 'Fazer Venda' selecionada.");
                    // Aqui você pode adicionar o código para fazer uma venda
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Opção 'Visualizar Vendas' selecionada.");
                    // Aqui você pode adicionar o código para visualizar as vendas
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    System.exit(0); // Encerra o programa
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
