package Control;

import Utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Navio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GerenciNavio {

    // Lista de navios registrados
    private List<Navio> lista = new ArrayList<>();

    // Metodo para regisrtrar a entrada do navio
    public void registrarEntradNavio(Scanner entrada) {
        System.out.println("Nome do navio: ");
        String n = entrada.nextLine();

        System.out.println("Escolha o tipo de carga do navio: ");
        System.out.println("1. Carga geral");
        System.out.println("2. Granel liquido");
        System.out.println("3. Granel sólido");
        System.out.println("4. Carga conteirizada");

        int opcao = entrada.nextInt();
        entrada.nextLine(); // Limpar buffer

        String tipoCarga = "";

        switch (opcao) {
            case 1:
                tipoCarga = "Carga geral";
                break;
            case 2:
                tipoCarga = "Granel liquido";
                break;
            case 3:
                tipoCarga = "Granel sólido";
                break;
            case 4:
                tipoCarga = "Carga conteirizada";
                break;
            default:
                System.out.println(
                        "Opção invalida! Esse tipo de carga nao está registrada, escolha novamente entre as opções listadas.");
                tipoCarga = "Indefinido";
                break;
        }

        // Formatadores para leitura do input de DATA e HORA
        DateTimeFormatter formatoDataEntrada = DateTimeFormatter.ofPattern("ddMMyyyy");
        DateTimeFormatter formatoHoraEntrada = DateTimeFormatter.ofPattern("HHmm");

        // Leitura da DATA
        System.out.print("Digite a data de entrada (ddmmaaaa - APENAS NUMEROS): ");
        String stringData = entrada.nextLine();

        // Conversão dos numeros para formato de data correto
        LocalDate dataEntrada = LocalDate.parse(stringData, formatoDataEntrada);

        // Leitura da HORA
        System.out.print("Digite a hora de entrada (hhmm - APENAS NUMEROS): ");
        String stringHora = entrada.nextLine();

        // Conversão dos numeros para formato de hora real
        LocalTime horaEntrada = LocalTime.parse(stringHora, formatoHoraEntrada);
        System.out.println("Digite a quantidade de containers: ");
        int q = entrada.nextInt();

        Navio novoNavio = new Navio(n, tipoCarga, dataEntrada, horaEntrada, q);
        lista.add(novoNavio);
        System.out.println("Navio registrado! ");
    }

    // Metodo para registrar a saida do navio
    public void registrarSaidaNavio(Scanner entrada) {
        if (lista.isEmpty()) {
            System.out.println("\nNenhum navio registrado.");
            return;
        }
        System.out.println("\n=== Navios disponiveis para saída ===");

        // Loop para percorrer a lista
        for (int i = 0; i < lista.size(); i++) {
            Navio navioAtual = lista.get(i);
            System.out.println(i + " = " + navioAtual.getNomeNavio());
        }
        System.out.print("\nDigite o NUMERO do navio que irá sair: ");
        int indiceSaida = entrada.nextInt();
        entrada.nextLine();

        if (indiceSaida >= 0 && indiceSaida < lista.size()) {
            lista.remove(indiceSaida);

            System.out.println("Navio removido e saida registrada com sucesso!");
        } else {
            System.out.println("numero inválido! Retornando ao menu.");
        }
    }

    // Metodo para listar os navios
    public void listarNavios() {
        if (lista.isEmpty()) {
            System.out.println("\nNenhum navio registrado.");
            return;
        }
        System.out.println("\n=== Navios registrados no porto ===");
        for (int i = 0; i < lista.size(); i++) {
            Navio navioAtual = lista.get(i);
            System.out.println("Navio " + i + ":");
            System.out.println(navioAtual);
        }
    }

    public List<Navio> getListaNavios() {
        return lista;
    }
}
