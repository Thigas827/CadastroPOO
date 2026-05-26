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

    // ============== Metodo para registrar a ENTRADA do Navio ==================
    public void registrarEntradNavio(Scanner entrada) {
        System.out.println("Nome do navio: ");
        String n = entrada.nextLine();

        System.out.println("Escolha o tipo de carga do navio: ");
        System.out.println("1. Carga geral");
        System.out.println("2. Granel liquido");
        System.out.println("3. Granel sólido");
        System.out.println("4. Carga conteirizada");

        boolean cargaValida = false;
        int opcao = entrada.nextInt();
        entrada.nextLine(); // Limpar buffer

        String tipoCarga = "";

        switch (opcao) {
            case 1:
                tipoCarga = "Carga geral";
                cargaValida = true;
                break;
            case 2:
                tipoCarga = "Granel liquido";
                cargaValida = true;
                break;
            case 3:
                tipoCarga = "Granel sólido";
                cargaValida = true;
                break;
            case 4:
                tipoCarga = "Carga conteirizada";
                cargaValida = true;
                break;
            default:
                System.out.println(
                        "Opção invalida! Esse tipo de carga nao está registrada, escolha novamente entre as opções listadas.");
                tipoCarga = "Indefinido";
                break;
        }

        // Metodo para hora e data (Util)
        LocalDate dataEntrada = Util.lerDataValida(entrada, "Digite a data de entrada (ddmmaaaa - 8 NUMEROS): ");
        LocalTime horaEntrada = Util.lerHoraValida(entrada, "Digite a hora de entrada (hhmm - 4 NUMEROS): ");

        System.out.println("Digite a quantidade de containers: ");
        int quantContain = entrada.nextInt();
        entrada.nextLine(); // Limpar o buffer do teclado

        Navio novoNavio = new Navio(n, tipoCarga, dataEntrada, horaEntrada, quantContain);

        lista.add(novoNavio);
        System.out.println("Navio registrado com sucesso!");

        // Salva a ficha completa no HD
        Util.gerarRecibo(novoNavio.toString(), "recibos_navios.txt");

        Util.limpaTimer(500);
    }

    // ============== Metodo para registrar a SAIDA do container ==================
    public void registrarSaidaNavio(Scanner entrada) {
        Util.registrarSaidaGenerica(lista, entrada, "Navio");
        Util.limpaTimer(1000); // Pausa e limpa
    }

    // ====================== Metodo para LISTAR os Navios ======================
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
