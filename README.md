# Ranking-Jogadores
PBL 02 - Resolução de Problemas Estruturados. Sistema simples de ranking de jogadores utilizando uma Árvore Binária de Busca (ABB) não balanceada.

Cada jogador possui, no mínimo:
- nickname (String)
- ranking (int) — será a chave de ordenação da ABB
O sistema deve permitir:
- Inserir jogadores na ABB
- Buscar jogador pelo nome
- Remover jogador pelo nome
- Visualizar a árvore (interface gráfica – TDE)
  
### A ABB deve ser implementada do zero, sem uso de coleções prontas para substituir a árvore.

## Classes obrigatórias

Player:
- String nickname, Int ranking
- construtor, getters, setters

Node/Nó:
- Player player, Node left, Node right
- construtor

BinarySearchTree
- Node root
- public void insert(Jogador j), public bool search(String name), public Player remove(String name), private Node insert(Node current, Jogador j), private Node search(Node current, String name), private Node remove(Node current, String name), public void inOrder() -> Opcional

### Todas as classes acima devem ser implementadas obrigatóriamente. Os atributos e métodos listados são obrigatórios, mas você pode adicionar novos atributos e métodos conforme achar necessário. 

## Implementação

Você deve implementar uma árvore binária de busca (ABB) de acordo com as regras mostradas em sala: maiores para a direita e menores para a esquerda. Os dados devem ser obtidos a partir do arquivo csv disponibilizado para download no enunciado da atividade. O arquivo contem duas colunas: nickname e ranking. O valor utilizado para inserção deve ser o ranking do jogador e deve ser inserido na ordem de leitura do arquivo. 

Além de adicionar os jogadores a partir do csv, o programa deve permitir a inserção, busca e remoção de forma manual. Isso pode ser feito tanto por um menu de opções no terminal, ou pela interface gráfica. Para inserir, o usuário deve informar o nickname e o ranking do jogador. A busca e a remoção devem ser feitas pelo nickname do jogador. Lembre que a inserção é feita pelo ranking, então para buscar e remover é preciso encontrar o ranking do jogador informado pelo usuário.

A Interface Gráfica deve demonstrar claramente a hierarquia da árvore e os elementos à esquerda e à direita. Cada nó da árvore deve exibir o nickname do jogador, não o ranking. Caso queira, pode incrementar com opções de carregar arquivo (csv) e adicionar, buscar ou remover jogador. O mínimo é a visualização hierárquica da árvore.


#### Especificações gerais obrigatórias
- O trabalho deve ser feito em duplas ou trios;
-  A entrega deve ser o link do github enviado pelo AVA;
- O último commit deve ser feito antes do prazo final de entrega estipulado no AVA;
- O métodos de inserção, remoção e busca devem ser implementados com recursividade;
- O trabalho deve seguir os princípios da orientação a objetos;
- O código deve estar sem nenhum comentário;
- Não é permitido usar nenhuma estrutura pronta do Java. Trabalhos que utilizem estruturas prontas serão zerados. (Caso utilize listas em alguma parte do trabalho, deve utilizar a estrutura implementada no RA1);
