import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        GerenciNavio gerenciN = new GerenciNavio();
        GerenciContainer gerenciC = new GerenciContainer();
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
                    gerenciC.registrarEntradContainer(entrada, gerenciN);
                    break;
                case 4:
                    gerenciC.registrarSaidaContainer(entrada, gerenciN);
                    break;
                case 5:
                    gerenciN.listarNavios();
                    break;
                case 6:
                    gerenciC.listarContainers();
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
