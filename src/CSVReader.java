import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {

    public static void carregarPlayers(BinarySearchTree bst, String caminho) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(caminho));
            String linha;
            int quantidade = 0;

            while ((linha = br.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) {
                    continue;
                }

                if (linha.toLowerCase().startsWith("nickname")) {
                    continue;
                }

                linha = linha.replace(",", " ");
                linha = linha.replace(";", " ");

                String[] partes = linha.split("\\s+");

                if (partes.length >= 2) {
                    String nickname = partes[0];
                    int ranking = Integer.parseInt(partes[1]);

                    bst.insert(new Player(nickname, ranking));
                    quantidade++;
                }
            }

            br.close();

            System.out.println("CSV carregado com sucesso!");
            System.out.println("Jogadores inseridos: " + quantidade);

        } catch (Exception e) {
            System.out.println("Erro ao ler o CSV.");
            e.printStackTrace();
        }
    }
}