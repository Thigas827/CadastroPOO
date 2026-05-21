import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciContainer {

    // Lista de container
    private List<Container> lista = new ArrayList<>();

    public void registrarEntradContainer(Scanner entrada, GerenciNavio gerenciN) {

        System.out.println("Digite o codigo de indentificação do Container: ");
        int i = entrada.nextInt();

        System.out.println("Escolha o tipo de carga de container: ");
        System.out.println("1. Dry box");
        System.out.println("2. High cube");
        System.out.println("3. Graneleiro Dry");
        System.out.println("4. Open Top");

        int opcao = entrada.nextInt();
        entrada.nextLine(); // Limpar buffer

        String tipoCont = "";

        switch (opcao) {
            case 1:
                tipoCont = "Dry box";
                break;
            case 2:
                tipoCont = "High cube";
                break;
            case 3:
                tipoCont = "Graneleiro Dry";
                break;
            case 4:
                tipoCont = "Open Top";
                break;
            default:
                System.out.println(
                        "Opção invalida! Tipo de container não registrado");
                tipoCont = "Indefinido";
                break;
        }

        DateTimeFormatter formatoDataEntrada = DateTimeFormatter.ofPattern("ddMMyyyy");
        DateTimeFormatter formatoHoraEntrada = DateTimeFormatter.ofPattern("HHmm");

        System.out.print("Digite a data de entrada (ddmmaaaa - APENAS NUMEROS): ");
        String stringData = entrada.nextLine();

        // Conversão dos numeros para formato de data correto
        LocalDate dataEntrada = LocalDate.parse(stringData, formatoDataEntrada);

        // Leitura da HORA
        System.out.print("Digite a hora de entrada (hhmm - APENAS NUMEROS): ");
        String stringHora = entrada.nextLine();

        // Conversão dos numeros para formato de hora real
        LocalTime horaEntrada = LocalTime.parse(stringHora, formatoHoraEntrada);
        System.out.println("Digite o destino do container ");
        String d = entrada.nextLine();
        // ====================================================================================

        // Lista de navios para verificar navios disponives
        List<Navio> listaDeNaviosDisponiveis = gerenciN.getListaNavios();

        if (listaDeNaviosDisponiveis.isEmpty()) {
            System.out.println("\nNenhum navio registrado para origem do container. ");
            return;
        }

        System.out.println("\n=== Navios disponiveis para origem ===");
        for (int index = 0; index < listaDeNaviosDisponiveis.size(); index++) {
            Navio navioAtual = listaDeNaviosDisponiveis.get(index);
            System.out.println(index + " = " + navioAtual.getNomeNavio());
        }
        System.out.print("Digite o NÚMERO do navio de origem: ");
        int indiceNavioOrigem = entrada.nextInt();
        entrada.nextLine();

        if (indiceNavioOrigem < 0 || indiceNavioOrigem >= listaDeNaviosDisponiveis.size()) {
            System.out.println("Numero de navio invalido! Abortando registro de container. ");
            return;
        }

        // 4. Pescamos o navio escolhido da lista
        Navio navioEscolhido = listaDeNaviosDisponiveis.get(indiceNavioOrigem);

        // 5. AGORA SIM! Criamos o container passando todas as 6 informações (incluindo
        // o navio!)
        Container novoContainer = new Container(i, tipoCont, dataEntrada, horaEntrada, d, navioEscolhido);

        lista.add(novoContainer);
        System.out.println("Container registrado com sucesso!");
    }
}
