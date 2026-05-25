package Utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Util {

    // Metodo para limpar a tela + Timer de espera
    public static void limpaTimer(int miliseg) {
        try {
            Thread.sleep(miliseg);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (Exception e) {
            // Em caso de erro
            for (int linha = 0; linha < 50; linha++) {
                System.out.println();
            }
        }
    }

    // Metodo para ler a data formatada
    public static LocalDate lerDataValida(Scanner entrada, String mensagem) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");

        while (true) {
            try {
                System.out.print(mensagem);
                String input = entrada.nextLine();

                return LocalDate.parse(input, formato);

            } catch (DateTimeParseException e) {
                System.out.println("Erro: Data inválida! Use exatamente 8 números (ex: 23052026); \n");
            }
        }
    }

    // Ferramenta 2: Lê e blinda a Hora
    public static LocalTime lerHoraValida(Scanner entrada, String mensagem) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HHmm");

        while (true) {
            try {
                System.out.print(mensagem);
                String input = entrada.nextLine();

                return LocalTime.parse(input, formato);

            } catch (DateTimeParseException e) {
                System.out.println("Erro: Hora inválida! Use exatamente 4 números (Ex: 1512).\n");
            }
        }
    }

    public static void gerarRecibo(String conteudo, String nomeArquivo) {
        try (FileWriter arquivo = new FileWriter(nomeArquivo, true);
                PrintWriter gravador = new PrintWriter(arquivo)) {
            gravador.println("=== REGISTRO ===");
            gravador.println(conteudo);
            gravador.println("================\n");
        } catch (IOException e) {
            System.out.println("Erro critico: Não foi possivel salvar o arquivo " + nomeArquivo);
        }
    }
}
