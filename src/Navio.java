public class Navio {
    private String nomeNavio;
    private String tipoNavio;
    private String dataEntrada;
    private String horaEntrada;
    private int quantContain;

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

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getQuantContain() {
        return quantContain;
    }

    public void setQuantContain(int quantContain) {
        this.quantContain = quantContain;
    }

    public Navio(String nomeNavio, String tipoNavio, String dataEntrada, String horaEntrada, int quantContain) {
        this.nomeNavio = nomeNavio;
        this.tipoNavio = tipoNavio;
        this.dataEntrada = dataEntrada;
        this.horaEntrada = horaEntrada;
        this.quantContain = quantContain;
    }

}
