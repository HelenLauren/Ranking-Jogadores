import javax.swing.*;
import java.awt.*;

public class RankingApp {
    private BinarySearchTree bst;
    private TreePanel treePanel;
    private JTextField campoNome;
    private JTextField campoRanking;
    private JLabel resultado;

    public RankingApp() {
        bst = new BinarySearchTree();
        CSVReader.carregarPlayers(bst, "players.csv");
        criarTela();
    }

    private void criarTela() {
        JFrame frame = new JFrame("Ranking de Jogadores");
        frame.setSize(1300, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel painelTopo = criarPainelTopo();
        treePanel = new TreePanel(bst);

        frame.add(painelTopo, BorderLayout.NORTH);
        frame.add(treePanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel criarPainelTopo() {
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));

        JLabel labelNome = new JLabel("Nickname:");
        campoNome = new JTextField(15);

        JButton botaoBuscarNome = new JButton("Buscar por nome");

        JLabel labelRanking = new JLabel("Ranking:");
        campoRanking = new JTextField(6);

        JButton botaoBuscarRanking = new JButton("Buscar por ranking");
        JButton botaoInserir = new JButton("Inserir");
        JButton botaoRemover = new JButton("Remover");

        resultado = new JLabel(" ");

        botaoBuscarNome.addActionListener(e -> buscarPorNome());
        botaoBuscarRanking.addActionListener(e -> buscarPorRanking());
        botaoInserir.addActionListener(e -> inserirJogador());
        botaoRemover.addActionListener(e -> removerJogador());

        painel.add(labelNome);
        painel.add(campoNome);
        painel.add(botaoBuscarNome);
        painel.add(labelRanking);
        painel.add(campoRanking);
        painel.add(botaoBuscarRanking);
        painel.add(botaoInserir);
        painel.add(botaoRemover);
        painel.add(resultado);

        return painel;
    }

    private void buscarPorNome() {
        String nickname = campoNome.getText().trim();

        if (nickname.isEmpty()) {
            resultado.setText("Digite um nickname.");
            return;
        }

        if (bst.search(nickname)) {
            resultado.setText("Jogador encontrado: " + nickname);
            treePanel.destacarPorNickname(nickname);
        } else {
            resultado.setText("Jogador não encontrado.");
            treePanel.limparDestaque();
        }
    }

    private void buscarPorRanking() {
        try {
            int ranking = Integer.parseInt(campoRanking.getText().trim());
            Player player = bst.searchByRanking(ranking);

            if (player != null) {
                resultado.setText("Ranking encontrado: " + player.getNickname());
                treePanel.destacarPorRanking(ranking);
            } else {
                resultado.setText("Ranking não encontrado.");
                treePanel.limparDestaque();
            }
        } catch (Exception e) {
            resultado.setText("Digite um ranking válido.");
        }
    }

    private void inserirJogador() {
        try {
            String nickname = campoNome.getText().trim();
            int ranking = Integer.parseInt(campoRanking.getText().trim());

            if (nickname.isEmpty()) {
                resultado.setText("Digite um nickname.");
                return;
            }

            bst.insert(new Player(nickname, ranking));
            resultado.setText("Jogador inserido: " + nickname);
            treePanel.destacarPorRanking(ranking);
            treePanel.repaint();

        } catch (Exception e) {
            resultado.setText("Digite nickname e ranking válidos.");
        }
    }

    private void removerJogador() {
        String nickname = campoNome.getText().trim();

        if (nickname.isEmpty()) {
            resultado.setText("Digite um nickname para remover.");
            return;
        }

        if (bst.search(nickname)) {
            bst.remove(nickname);
            resultado.setText("Jogador removido: " + nickname);
            treePanel.limparDestaque();
            treePanel.repaint();
        } else {
            resultado.setText("Jogador não encontrado.");
        }
    }
}