import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        arvore.preencherArvore();

        System.out.println("==== Árvore Binária Com Código Morse ===");
        System.out.println("Restrições: Os caracteres devem ser sempre MAIÚSCULOS e SEM ACENTOS.");
        System.out.println("Cada sinal morse deve ser separado por espaços, EX: ... --- ...\n");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("1 - Codificar mensagem (texto => morse)");
            System.out.println("2 - Decodificar mensagem (morse => texto)");
            System.out.println("3 - Buscar caractere por código morse");
            System.out.println("4 - Exibir árvore morse");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.print("Digite a mensagem (MAIÚSCULA, SEM ACENTO): ");
                String mensagem = sc.nextLine();
                String morse = arvore.criarMorse(mensagem);
                System.out.println("Código Morse: " + morse);
            } else if (opcao == 2) {
                System.out.print("Digite a mensagem em código morse (separe letras com espaço): ");
                String morse = sc.nextLine();
                String texto = arvore.decifrarMensagem(morse);
                System.out.println("Mensagem decodificada: " + texto);
            } else if (opcao == 3) {
                System.out.print("Digite o código morse do caractere: ");
                String morse = sc.nextLine();
                char caractere = arvore.buscarCaractere(morse);
                if (caractere == '\0') {
                    System.out.println("Código Morse inválido ou não encontrado.");
                } else {
                    System.out.println("Caractere encontrado: " + caractere);
                }
            } else if (opcao == 4) {
                System.out.println("\nÁrvore Binária - Código Morse:");
                arvore.exibirArvoreMorse();
            } else if (opcao == 0) {
                System.out.println("Encerrando o programa.");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }
}
