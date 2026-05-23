package Utils;

public class Util {

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
}
