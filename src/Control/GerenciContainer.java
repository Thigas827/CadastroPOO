package Control;

import Utils.Util;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Container;
import Model.Navio;

public class GerenciContainer {

    // Lista de container
    private List<Container> lista = new ArrayList<>();

    // ============== Metodo para registrar a ENTRADA do Container ==============
    public void registrarEntradContainer(Scanner entrada, GerenciNavio gerenciN) {

        System.out.println("Digite o codigo de indentificação do Container: ");
        int i = entrada.nextInt();

        System.out.println("Escolha o tipo de carga de container: ");
        System.out.println("1. Dry box");
        System.out.println("2. High cube");
        System.out.println("3. Graneleiro Dry");
        System.out.println("4. Open Top");

        boolean cargaValida = false;
        int opcao = entrada.nextInt();
        entrada.nextLine(); // Limpar buffer

        String tipoCont = "";

        switch (opcao) {
            case 1:
                tipoCont = "Dry box";
                cargaValida = true;
                break;
            case 2:
                tipoCont = "High cube";
                cargaValida = true;
                break;
            case 3:
                tipoCont = "Graneleiro Dry";
                cargaValida = true;
                break;
            case 4:
                tipoCont = "Open Top";
                cargaValida = true;
                break;
            default:
                System.out.println(
                        "Opção invalida! Tipo de container não registrado");
                tipoCont = "Indefinido";
                break;
        }

        // Metodo para hora e data (Util)
        LocalDate dataEntrada = Util.lerDataValida(entrada, "Digite a data de entrada (ddmmaaaa - 8 NUMEROS): ");
        LocalTime horaEntrada = Util.lerHoraValida(entrada, "Digite a hora de entrada (hhmm - 4 NUMEROS): ");

        System.out.println("Digite o destino do container ");
        String d = entrada.nextLine();

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

        Navio navioEscolhido = listaDeNaviosDisponiveis.get(indiceNavioOrigem);
        Container novoContainer = new Container(i, tipoCont, dataEntrada, horaEntrada, d, navioEscolhido);
        lista.add(novoContainer);
        System.out.println("Container registrado com sucesso!");

        Util.gerarRecibo(novoContainer.toString(), "recibos_containers.txt");

        Util.limpaTimer(500);
    }

    // ============== Metodo para registrar a SAIDA do Container ==============
    public void registrarSaidaContainer(Scanner entrada, GerenciNavio gerenciN) {
        Util.registrarSaidaGenerica(lista, entrada, "Container");
        Util.limpaTimer(1000); // Pausa e limpa
    }

    // ============== Metodo para LISTAR containers ==============
    public void listarContainers() {
        if (lista.isEmpty()) {
            System.out.println("\nNenhum container registrado no momento."); // Ajustado
            return;
        }

        System.out.println("\n=== Containers registrados no porto ==="); // Ajustado

        for (int i = 0; i < lista.size(); i++) {
            Container containerAtual = lista.get(i);
            System.out.println("\nContainer " + i + ":"); // Ajustado
            System.out.println(containerAtual);
        }
    }

    public List<Container> getListaContainers() {
        return lista;
    }
}