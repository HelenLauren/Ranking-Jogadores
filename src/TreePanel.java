import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private BinarySearchTree bst;
    private String nicknameDestacado;
    private Integer rankingDestacado;

    public TreePanel(BinarySearchTree bst) {
        this.bst = bst;
    }

    public void destacarPorNickname(String nickname) {
        this.nicknameDestacado = nickname;
        this.rankingDestacado = null;
        repaint();
    }

    public void destacarPorRanking(Integer ranking) {
        this.rankingDestacado = ranking;
        this.nicknameDestacado = null;
        repaint();
    }

    public void limparDestaque() {
        this.nicknameDestacado = null;
        this.rankingDestacado = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, bst.getRoot(), getWidth() / 2, 50, getWidth() / 4);
    }

    private void drawTree(Graphics g, Node node, int x, int y, int offset) {
        if (node == null) {
            return;
        }

        boolean destacado = false;

        if (nicknameDestacado != null && node.getPlayer().getNickname().equalsIgnoreCase(nicknameDestacado)) {
            destacado = true;
        }

        if (rankingDestacado != null && node.getPlayer().getRanking() == rankingDestacado) {
            destacado = true;
        }

        if (destacado) {
            g.setColor(Color.YELLOW);
            g.fillOval(x - 25, y - 25, 50, 50);
            g.setColor(Color.BLACK);
        }

        g.drawOval(x - 25, y - 25, 50, 50);
        g.drawString(node.getPlayer().getNickname(), x - 25, y);

        if (node.getLeft() != null) {
            g.drawLine(x, y + 25, x - offset, y + 80 - 25);
            drawTree(g, node.getLeft(), x - offset, y + 80, offset / 2);
        }

        if (node.getRight() != null) {
            g.drawLine(x, y + 25, x + offset, y + 80 - 25);
            drawTree(g, node.getRight(), x + offset, y + 80, offset / 2);
        }
    }
}