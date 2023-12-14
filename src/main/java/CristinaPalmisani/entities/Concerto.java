package CristinaPalmisani.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;
    @Column(name = "in_streaming")
    private boolean inStreaming;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti, Location location, GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto(){
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
