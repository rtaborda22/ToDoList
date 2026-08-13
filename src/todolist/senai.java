/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist;

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class senai {

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        String[] tarefas = new String[10];
        boolean[] concluidas = new boolean[10];
        
        int opcao = 0;

        while (opcao != 5) {
            System.out.println(" LISTA DE TAREFAS ");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");
            
            if (leitor.hasNextInt()) {
                opcao = leitor.nextInt();
                leitor.nextLine();
            } else {
                System.out.println("Erro: Você deve digitar apenas números de 1 a 5");
                leitor.nextLine(); 
                System.out.println();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da tarefa: ");
                    String novaTarefa = leitor.nextLine();
                    
                    boolean adicionou = false;
                    for (int i = 0; i < 10; i++) {
                        if (tarefas[i] == null) {
                            tarefas[i] = novaTarefa;
                            concluidas[i] = false;
                            adicionou = true;
                            System.out.println("Tarefa gravada com sucesso!");
                            break;
                        }
                    }
                    
                    if (adicionou == false) {
                        System.out.println("A lista está cheia, apague uma tarefa primeiro.");
                    }
                    break;

                case 2:
                    System.out.println(" Suas Tarefas ");
                    boolean temTarefa = false;
                    
                    for (int i = 0; i < 10; i++) {
                        if (tarefas[i] != null) {
                            temTarefa = true;
                            String status = "[Pendente]";
                            if (concluidas[i] == true) {
                                status = "[Concluida]";
                            }
                            System.out.println((i + 1) + " - " + tarefas[i] + " " + status);
                        }
                    }
                    
                    if (temTarefa == false) {
                        System.out.println("Você nao tem nenhuma tarefa cadastrada.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o numero da tarefa que deseja concluir: ");
                    if (leitor.hasNextInt()) {
                        int numeroConcluir = leitor.nextInt();
                        leitor.nextLine();
                        int indiceConcluir = numeroConcluir - 1;
                        
                        if (indiceConcluir >= 0 && indiceConcluir < 10 && tarefas[indiceConcluir] != null) {
                            concluidas[indiceConcluir] = true;
                            System.out.println("Tarefa marcada como feita");
                        } else {
                            System.out.println("Essa tarefa nao existe");
                        }
                    } else {
                        System.out.println("Erro: Digite um numero valido");
                        leitor.nextLine();
                    }
                    break;

                case 4:
                    System.out.print("Digite o numero da tarefa que deseja excluir: ");
                    if (leitor.hasNextInt()) {
                        int numeroExcluir = leitor.nextInt();
                        leitor.nextLine();
                        int indiceExcluir = numeroExcluir - 1;
                        
                        if (indiceExcluir >= 0 && indiceExcluir < 10 && tarefas[indiceExcluir] != null) {
                            tarefas[indiceExcluir] = null;
                            concluidas[indiceExcluir] = false;
                            System.out.println("Tarefa apagada");
                        } else {
                            System.out.println("Essa tarefa não existe");
                        }
                    } else {
                        System.out.println("Erro: Digite um número valido.");
                        leitor.nextLine();
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção errada, escolha de 1 a 5.");
                    break;
            }
            System.out.println();
        }

        leitor.close();
    }
}

}
