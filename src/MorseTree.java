public class MorseTree {
    private MorseNode root;

    public MorseTree() {
        root = new MorseNode(' ');
        inserirAlfabeto();
    }

    private void inserirAlfabeto() {
        insert('A', ".-");
        insert('B', "-...");
        insert('C', "-.-.");
        insert('D', "-..");
        insert('E', ".");
        insert('F', "..-.");
        insert('G', "--.");
        insert('H', "....");
        insert('I', "..");
        insert('J', ".---");
        insert('K', "-.-");
        insert('L', ".-..");
        insert('M', "--");
        insert('N', "-.");
        insert('O', "---");
        insert('P', ".--.");
        insert('Q', "--.-");
        insert('R', ".-.");
        insert('S', "...");
        insert('T', "-");
        insert('U', "..-");
        insert('V', "...-");
        insert('W', ".--");
        insert('X', "-..-");
        insert('Y', "-.--");
        insert('Z', "--..");
    }

    public void insert(char letter, String code) {
        insert(root, letter, code, 0);
    }

    private void insert(MorseNode current, char letter, String code, int index) {
        if (index == code.length()) {
            current.setLetter(letter);
            return;
        }

        char symbol = code.charAt(index);

        if (symbol == '.') {
            if (current.getLeft() == null) {
                current.setLeft(new MorseNode(' '));
            }
            insert(current.getLeft(), letter, code, index + 1);
        } else if (symbol == '-') {
            if (current.getRight() == null) {
                current.setRight(new MorseNode(' '));
            }
            insert(current.getRight(), letter, code, index + 1);
        }
    }

    public char decodeLetter(String code) {
        return decodeLetter(root, code, 0);
    }

    private char decodeLetter(MorseNode current, String code, int index) {
        if (current == null) {
            return '?';
        }

        if (index == code.length()) {
            return current.getLetter();
        }

        char symbol = code.charAt(index);

        if (symbol == '.') {
            return decodeLetter(current.getLeft(), code, index + 1);
        } else if (symbol == '-') {
            return decodeLetter(current.getRight(), code, index + 1);
        }

        return '?';
    }

    public String decodeWord(String morseWord) {
        String[] letters = morseWord.split(" ");
        String result = "";

        for (int i = 0; i < letters.length; i++) {
            result += decodeLetter(letters[i]);
        }

        return result;
    }

    public String encodeLetter(char letter) {
        return encodeLetter(root, Character.toUpperCase(letter), "");
    }

    private String encodeLetter(MorseNode current, char letter, String path) {
        if (current == null) {
            return null;
        }

        if (current.getLetter() == letter) {
            return path;
        }

        String leftResult = encodeLetter(current.getLeft(), letter, path + ".");

        if (leftResult != null) {
            return leftResult;
        }

        return encodeLetter(current.getRight(), letter, path + "-");
    }

    public String encodeWord(String word) {
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            String code = encodeLetter(word.charAt(i));

            if (code != null) {
                result += code + " ";
            }
        }

        return result.trim();
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(MorseNode current, int level) {
        if (current == null) {
            return;
        }

        printTree(current.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(current.getLetter());

        printTree(current.getLeft(), level + 1);
    }
}