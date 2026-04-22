public class BinarySearchTree {
    private Node root;

    public void insert(Player j) {
        root = insert(root, j);
    }

    private Node insert(Node current, Player j) {
        if (current == null) return new Node(j);

        if (j.getRanking() < current.player.getRanking())
            current.left = insert(current.left, j);
        else
            current.right = insert(current.right, j);

        return current;
    }

    public boolean search(String name) {
        return search(root, name) != null;
    }

    private Node search(Node current, String name) {
        if (current == null) return null;

        if (current.player.getNickname().equals(name))
            return current;

        Node left = search(current.left, name);
        if (left != null) return left;

        return search(current.right, name);
    }

    public Player remove(String name) {
        Node target = search(root, name);
        if (target == null) return null;
        root = remove(root, target.player.getRanking());
        return target.player;
    }

    private Node remove(Node current, int ranking) {
        if (current == null) return null;

        if (ranking < current.player.getRanking()) {
            current.left = remove(current.left, ranking);
        } else if (ranking > current.player.getRanking()) {
            current.right = remove(current.right, ranking);
        } else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node smallest = findMin(current.right);
            current.player = smallest.player;
            current.right = remove(current.right, smallest.player.getRanking());
        }

        return current;
    }

    private Node findMin(Node node) {
        return node.left == null ? node : findMin(node.left);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.player.getNickname() + " - " + node.player.getRanking());
            inOrder(node.right);
        }
    }
}