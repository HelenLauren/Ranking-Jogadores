public class MorseNode {
    private char letter;
    private MorseNode left;
    private MorseNode right;

    public MorseNode(char letter) {
        this.letter = letter;
        this.left = null;
        this.right = null;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public MorseNode getLeft() {
        return left;
    }

    public void setLeft(MorseNode left) {
        this.left = left;
    }

    public MorseNode getRight() {
        return right;
    }

    public void setRight(MorseNode right) {
        this.right = right;
    }
}