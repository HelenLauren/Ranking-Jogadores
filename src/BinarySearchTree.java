public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void insert(Player player) {
        root = insertRec(root, player);
    }

    private Node insertRec(Node current, Player player) {
        if (current == null) {
            return new Node(player);
        }

        if (player.getRanking() < current.getPlayer().getRanking()) {
            current.setLeft(insertRec(current.getLeft(), player));
        } else {
            current.setRight(insertRec(current.getRight(), player));
        }

        return current;
    }

    public boolean search(String nickname) {
        return searchRec(root, nickname);
    }

    private boolean searchRec(Node current, String nickname) {
        if (current == null) {
            return false;
        }

        if (current.getPlayer().getNickname().equalsIgnoreCase(nickname)) {
            return true;
        }

        return searchRec(current.getLeft(), nickname) || searchRec(current.getRight(), nickname);
    }

    public Player searchByRanking(int ranking) {
        return searchByRankingRec(root, ranking);
    }

    private Player searchByRankingRec(Node current, int ranking) {
        if (current == null) {
            return null;
        }

        if (ranking == current.getPlayer().getRanking()) {
            return current.getPlayer();
        }

        if (ranking < current.getPlayer().getRanking()) {
            return searchByRankingRec(current.getLeft(), ranking);
        }

        return searchByRankingRec(current.getRight(), ranking);
    }

    public void remove(String nickname) {
        Player player = findPlayer(root, nickname);

        if (player != null) {
            root = removeRec(root, player.getRanking());
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    private Player findPlayer(Node current, String nickname) {
        if (current == null) {
            return null;
        }

        if (current.getPlayer().getNickname().equalsIgnoreCase(nickname)) {
            return current.getPlayer();
        }

        Player left = findPlayer(current.getLeft(), nickname);

        if (left != null) {
            return left;
        }

        return findPlayer(current.getRight(), nickname);
    }

    private Node removeRec(Node current, int ranking) {
        if (current == null) {
            return null;
        }

        if (ranking < current.getPlayer().getRanking()) {
            current.setLeft(removeRec(current.getLeft(), ranking));
        } else if (ranking > current.getPlayer().getRanking()) {
            current.setRight(removeRec(current.getRight(), ranking));
        } else {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            Node menor = findMin(current.getRight());

            current.getPlayer().setNickname(menor.getPlayer().getNickname());
            current.getPlayer().setRanking(menor.getPlayer().getRanking());

            current.setRight(removeRec(current.getRight(), menor.getPlayer().getRanking()));
        }

        return current;
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    public void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(Node current, int level) {
        if (current == null) {
            return;
        }

        printTreeRec(current.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(current.getPlayer().getNickname() + " (" + current.getPlayer().getRanking() + ")");

        printTreeRec(current.getLeft(), level + 1);
    }
}