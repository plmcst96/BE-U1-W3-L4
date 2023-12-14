package CristinaPalmisani.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "gara_atletica")
public class GaraAtletica extends Evento{

    @ManyToMany
    @JoinTable(name = "competizione_atletica_atleti",
    joinColumns = @JoinColumn(name = "competizione_atletica_id"),
    inverseJoinColumns = @JoinColumn(name = "atleti_id"))
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti, Location location, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti, location);
        this.vincitore = vincitore;
    }

    public GaraAtletica(){}

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
