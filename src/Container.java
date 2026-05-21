import java.time.LocalDate;
import java.time.LocalTime;

public class Container {
    private int id;
    private String tipoCont;
    private LocalDate dataEntrada;
    private LocalTime horaEntrada;
    private String destino;
    private Navio navioOrigem; 


    public Container(int id, String tipoCont, LocalDate dataEntradaCont, LocalTime horaEntradaCont, String destino,
            Navio navioOrigem) {
        this.id = id;
        this.tipoCont = tipoCont;
        this.dataEntrada = dataEntradaCont;
        this.horaEntrada = horaEntradaCont;
        this.destino = destino;
        this.navioOrigem = navioOrigem;
    }

    public Container(){
    }

 public int getId() {
    return id;
 }

 public void setId(int id) {
    this.id = id;
 }

 public String getTipoCont() {
    return tipoCont;
 }

 public void setTipoCont(String tipoCont) {
    this.tipoCont = tipoCont;
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

 public String getDestino() {
    return destino;
 }

 public void setDestino(String destino) {
    this.destino = destino;
 }

 public Navio getNavioOrigem() {
    return navioOrigem;
 }

 public void setNavioOrigem(Navio navioOrigem) {
    this.navioOrigem = navioOrigem;
 
    }

 @Override
    public String toString() {
        return """
                Identificação: %d
                Tipo de container: %s
                Data de entrada: %s
                Hora de entrada: %s
                Destino: %s
                Navio de origem: %s
                -------------------------------
                """.formatted(id, tipoCont, dataEntrada, horaEntrada, destino, navioOrigem.getNomeNavio());
    }

}