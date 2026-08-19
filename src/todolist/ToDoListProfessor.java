package todolist;

import java.util.Scanner;

public class ToDoListProfessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tarefas = new String[10];
        boolean[] concluidas = new boolean[10];
        int opcao = 10;

        while (opcao != 5) {
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // CORREÇÃO: Limpa o buffer para o próximo nextLine() funcionar

            switch (opcao) {
                case 1:
                    int posicaoLivre = -1;
                    for (int i = 0; i < tarefas.length; i++) {
                        if (tarefas[i] == null) {
                            posicaoLivre = i; // CORREÇÃO: Armazena o índice correto 'i', antes era fixo em 1
                            break;
                        }
                    }
                    if (posicaoLivre == -1) {
                        System.out.println("A lista de tarefas esta cheia!");
                    } else {
                        System.out.print("Digite a tarefa: ");
                        tarefas[posicaoLivre] = scanner.nextLine(); // Agora o programa vai esperar você digitar
                        concluidas[posicaoLivre] = false;
                        System.out.println("Tarefa adicionada com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("---MINHAS TAREFAS---");
                    boolean existeTarefa = false;
                    for (int i = 0; i < tarefas.length; i++) {
                        if (tarefas[i] != null) {
                            existeTarefa = true;
                            // Exibe [x] se concluída ou [ ] se estiver pendente
                            String status = concluidas[i] ? "[x]" : "[ ]";
                            System.out.println((i + 1) + " - " + status + " " + tarefas[i]);
                        }
                    }
                    if (existeTarefa == false) {
                        System.out.println("Nenhuma tarefa cadastrada!");
                    }
                    break;

                case 3:
                    System.out.print("Digite o numero da tarefa a concluir: ");
                    int indiceConcluir = scanner.nextInt() - 1;
                    if (indiceConcluir >= 0 && indiceConcluir < tarefas.length && tarefas[indiceConcluir] != null) {
                        concluidas[indiceConcluir] = true;
                        System.out.println("Tarefa concluida com sucesso!");
                    } else {
                        System.out.println("Tarefa nao encontrada!");
                    }
                    break;

                case 4:
                    System.out.print("Digite o numero da tarefa a excluir: ");
                    int indiceExcluir = scanner.nextInt() - 1;
                    if (indiceExcluir >= 0 && indiceExcluir < tarefas.length && tarefas[indiceExcluir] != null) {
                        tarefas[indiceExcluir] = null;
                        concluidas[indiceExcluir] = false;
                        System.out.println("Tarefa excluida com sucesso!");
                    } else {
                        System.out.println("Tarefa nao encontrada!");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
        scanner.close();
    }
}
