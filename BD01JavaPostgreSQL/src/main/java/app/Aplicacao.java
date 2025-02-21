package app;

import java.util.List;
import dao.JogosDAO;
import model.Jogos;
import java.util.*;

public class Aplicacao {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        JogosDAO jogosDAO = new JogosDAO();
        int opcao = 0;

        do {
            System.out.println("\nInsira uma opcao:\n");
            System.out.println("1. Listar jogos");
            System.out.println("2. Inserir jogo");
            System.out.println("3. Excluir jogo");
            System.out.println("4. Atualizar informacao de algum jogo");
            System.out.println("5. Sair do menu");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nLISTA:\n");
                    List<Jogos> jogosList = jogosDAO.get();
                    for (Jogos jogo : jogosList) {
                        System.out.println(jogo);
                    }
                    break;
                case 2:
                    Jogos jogoinsert = new Jogos(11, "Jogo da Cebolinha", "Brazuca Games", 50);
                    if (jogosDAO.insert(jogoinsert)) {
                        System.out.println(jogoinsert.getQuantidade() + " " + jogoinsert.getNome() + " da empresa " 
                                + jogoinsert.getEmpresa() + " foram adicionados");
                    } else {
                        System.out.println("O jogo nao foi adicionado");
                    }
                    break;
                case 3:
                    Jogos jogoexcluido = jogosDAO.get(5);
                    if (jogosDAO.delete(5)) {
                        System.out.println("O jogo excluido foi " + jogoexcluido);
                    } else {
                        System.out.println("O jogo nao foi excluido");
                    }
                    break;
                case 4:
                    Jogos jogo = jogosDAO.get(7);
                    if (jogo != null) {
                        jogo.setEmpresa("Rockstar");
                        jogo.setNome("Grand Theft Auto San Andreas");
                        jogo.setQuantidade(200000);

                        if (jogosDAO.update(jogo)) {
                            System.out.println("Nome da empresa foi mudado para Rockstar");
                            System.out.println("Nome do jogo foi mudado para Grand Theft Auto San Andreas");
                            System.out.println("Quantidade foi mudada para 200000");
                        } else {
                            System.out.println("ERRO NA ALTERACAO");
                        }
                    } else {
                        System.out.println("Jogo com código 7 não encontrado!");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);

        sc.close();
    }
}
