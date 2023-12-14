package CristinaPalmisani.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persone")
public class Persona {

    @OneToMany(mappedBy = "vincitore", cascade = CascadeType.REMOVE)
    Set<GaraAtletica> vincitoriGaraAtletica;
    @Id
    @GeneratedValue
    private  long id;
    private  String nome;
    private  String cognome;
    private String email;
    private LocalDate compleanno;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;
    @OrderBy("data_evento")
    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    private List<Partecipazione> listaPartecipazione;

    @ManyToMany
    @JoinTable(name = "competizione_atletica_atleti",
            joinColumns = @JoinColumn(name = "atleti_id"),
            inverseJoinColumns = @JoinColumn(name = "competizione_atletica_id"))
    private List<GaraAtletica> garaAtleticaList;

    public Persona(String nome, String cognome, String email, LocalDate compleanno, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.compleanno = compleanno;
        this.sesso = sesso;
    }

    public Persona(){}

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCompleanno() {
        return compleanno;
    }

    public void setCompleanno(LocalDate compleanno) {
        this.compleanno = compleanno;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public List<Partecipazione> getListaPartecipazione() {
        return listaPartecipazione;
    }

    public Set<GaraAtletica> getVincitoriGaraAtletica() {
        return vincitoriGaraAtletica;
    }

    public void setVincitoriGaraAtletica(Set<GaraAtletica> vincitoriGaraAtletica) {
        this.vincitoriGaraAtletica = vincitoriGaraAtletica;
    }

    public void setListaPartecipazione(List<Partecipazione> listaPartecipazione) {
        this.listaPartecipazione = listaPartecipazione;
    }

    public List<GaraAtletica> getGaraAtleticaList() {
        return garaAtleticaList;
    }

    public void setGaraAtleticaList(List<GaraAtletica> garaAtleticaList) {
        this.garaAtleticaList = garaAtleticaList;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", compleanno=" + compleanno +
                ", sesso=" + sesso +
                '}';
    }
}
