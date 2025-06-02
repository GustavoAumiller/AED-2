
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o tamanho da pilha: ");
            int n = scanner.nextInt();
            long startTime;
            long endTime;
            Stack<Integer> Pilha_Inteira = new Stack<>();
            for (int i = 0; i < n; i++) {
                Pilha_Inteira.push(RNG_inteira());
                System.out.println("Empilhado: " + Pilha_Inteira.peek());
            }
            System.out.println("\n\n1:Sort            2:Nova Inserção    3:Procura por valor    4:Valor no topo\n5:Remove Valor    6:Remove Topo      7:Remoção em massa    8:Encerrar");
            int n1 = scanner.nextInt();
            while (n1 != 8) {
                switch (n1) {
                    case 1 -> {
                        startTime = System.nanoTime();
                        Collections.sort(Pilha_Inteira);
                        endTime = System.nanoTime();
                        System.out.println("\n\nPilha Organizada: " + Pilha_Inteira);
                        System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                    }
                    case 2 -> {
                        System.out.print("Digite o número a ser inserido: ");
                        int newValue = scanner.nextInt();
                        startTime = System.nanoTime();
                        Pilha_Inteira.push(newValue);
                        endTime = System.nanoTime();
                        System.out.println("Empilhado: " + newValue);
                        System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                    }
                    case 3 -> {
                        System.out.print("Digite o número a ser procurado: ");
                        int searchValue = scanner.nextInt();
                        startTime = System.nanoTime();
                        if (Pilha_Inteira.contains(searchValue)) {
                            endTime = System.nanoTime();
                            System.out.println("Número " + searchValue + " Está na pilha.");
                            System.out.println("Posição: " + (Pilha_Inteira.search(searchValue) - 1));
                            System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                        } else {
                            System.out.println("Número " + searchValue + "  não encontrado na pilha.");
                        }
                    }
                    case 4 -> {
                        startTime = System.nanoTime();
                        if (!Pilha_Inteira.isEmpty()) {
                            endTime = System.nanoTime();
                            System.out.println("Topo da pilha: " + Pilha_Inteira.peek());
                            System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                        } else {
                            System.out.println("Pilha vazia");
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite o número a ser removido: ");
                        int removeValue = scanner.nextInt();
                        startTime = System.nanoTime();
                        if (Pilha_Inteira.remove(Integer.valueOf(removeValue))) {
                            endTime = System.nanoTime();
                            System.out.println("Número removido: " + removeValue);
                            System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                        } else {
                            System.out.println("Número " + removeValue + " não encontrado na pilha.");
                        }
                    }
                    case 6 -> {
                        startTime = System.nanoTime();
                        if (!Pilha_Inteira.isEmpty()) {
                            int removedTop = Pilha_Inteira.pop();
                            endTime = System.nanoTime();
                            System.out.println("Topo da pilha removido: " + removedTop);
                            System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                        } else {
                            System.out.println("Pilha vazia, não é possível remover o topo.");
                        }
                    }
                    case 7 -> {
                        System.out.print("Digite o número de elementos a serem removidos: ");
                        int numToRemove = scanner.nextInt();
                        startTime = System.nanoTime();
                        if (numToRemove <= Pilha_Inteira.size()) {
                            for (int i = 0; i < numToRemove; i++) {
                                Pilha_Inteira.pop();
                            }endTime = System.nanoTime();
                            System.out.println("\nTempo de Excução em Nanosegundos " + (endTime - startTime) + " ns" + "\n\nTempo de Execução em Milisegundos:    " + (endTime/1000000 - startTime/1000000) + " ms");
                        } else {
                            System.out.println("Número de elementos a remover excede o tamanho da pilha.");
                        }
                    }
                    case 8 -> {
                        System.out.println("Encerrando o programa.");
                        return;
                    }
                    default -> System.out.println("Opção inválida, tente novamente.");
                }
                System.out.println("\n\n1:Sort            2:Nova Inserção    3:Procura por valor    4:Valor no ropo\n5:Remove Valor    6:Remove Topo      7:Remoção em massa    8:Encerrar");
                n1 = scanner.nextInt();
            }
        }
    }

    static int  RNG_inteira() {
        Random random = new Random();
        return random.nextInt(1_000_000_000);
    }
}
