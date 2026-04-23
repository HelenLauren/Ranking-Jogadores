import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        int option = -1;

        while (option != 0) {
            System.out.println("\n1 - Inserir jogador");
            System.out.println("2 - Buscar jogador");
            System.out.println("3 - Remover jogador");
            System.out.println("4 - Mostrar ranking (inOrder)");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nickname: ");
                    String name = sc.nextLine();

                    System.out.print("Ranking: ");
                    int ranking = sc.nextInt();
                    sc.nextLine();

                    tree.insert(new Player(name, ranking));
                    System.out.println("Jogador " + name + "foi inserido.");
                    break;

                case 2:
                    System.out.print("BUSCA (nome): ");
                    String searchName = sc.nextLine();

                    boolean found = tree.search(searchName);

                    if (found)
                        System.out.println("O jogador foi encontrado.");
                    else
                        System.out.println("O jogador nao foi encontrado.");
                    break;

                case 3:
                    System.out.print("REMOVER (nome): ");
                    String removeName = sc.nextLine();

                    Player removed = tree.remove(removeName);

                    if (removed != null)
                        System.out.println("Removido: " + removed.getNickname());
                    else
                        System.out.println("O jogador " + removed.getNickname() + "nao foi encontrado.");
                    break;

                case 4:
                    System.out.println("\nRanking:");
                    tree.inOrder();
                    continue;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        }

        sc.close();
    }
}