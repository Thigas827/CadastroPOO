import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GerenciNavio gerenciN = new GerenciNavio();
        int opcao = 0;

        do {
            String menu = """
                    ========== MENU ==========
                    1. Registrar entrada de navio
                    2. Registrar saída de navio
                    3. Registrar entrada de container
                    4. Registrar saída de container
                    5. Listar navios no porto
                    6. Listar containers no porto
                    7. Sair
                    =========================
                    Escolha uma opção: """;
            System.out.print(menu);
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    gerenciN.registrarEntradNavio(entrada);
                    break;
                case 2:
                    gerenciN.registrarSaidaNavio(entrada);
                    break;
                case 3:
                    // Lógica para registrar entrada de container
                    break;
                case 4:
                    // Lógica para registrar saída de container
                    break;
                case 5:
                    // Lógica para listar navios no porto
                    break;
                case 6:
                    // Lógica para listar containers no porto
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
            }
        } while (opcao != 7);
        entrada.close();
    }
}
