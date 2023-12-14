package CristinaPalmisani.entities;

import com.sun.istack.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "partita_calcio")
public class PartitaDiCalcio extends  Evento {
    private String squadraCasa;
    private String squadraOspite;
    @Nullable
    private String squadraVincente;
    private int numGolSqCasa;
    private int numGolSqOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti, Location location, String squadraCasa, String squadraOspite, int numGolSqCasa, int numGolSqOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = null;
        this.numGolSqCasa = numGolSqCasa;
        this.numGolSqOspite = numGolSqOspite;
    }

    public PartitaDiCalcio(){}

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumGolSqCasa() {
        return numGolSqCasa;
    }

    public void setNumGolSqCasa(int numGolSqCasa) {
        this.numGolSqCasa = numGolSqCasa;
    }

    public int getNumGolSqOspite() {
        return numGolSqOspite;
    }

    public void setNumGolSqOspite(int numGolSqOspite) {
        this.numGolSqOspite = numGolSqOspite;
    }
}
