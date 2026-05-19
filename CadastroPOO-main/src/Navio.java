import java.time.LocalDate;
import java.time.LocalTime;

public class Navio {
    private String nomeNavio;
    private String tipoNavio;
    private LocalDate dataEntrada;
    private LocalTime horaEntrada;
    private int quantContain;

    public Navio(String nomeNavio, String tipoNavio, LocalDate dataEntrada, LocalTime horaEntrada, int quantContain) {
        this.nomeNavio = nomeNavio;
        this.tipoNavio = tipoNavio;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.quantContain = quantContain;
    }

    public Navio() {
    }

    public String getNomeNavio() {
        return nomeNavio;
    }

    public void setNomeNavio(String nomeNavio) {
        this.nomeNavio = nomeNavio;
    }

    public String getTipoNavio() {
        return tipoNavio;
    }

    public void setTipoNavio(String tipoNavio) {
        this.tipoNavio = tipoNavio;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getQuantContain() {
        return quantContain;
    }

    public void setQuantContain(int quantContain) {
        this.quantContain = quantContain;
    }

}
