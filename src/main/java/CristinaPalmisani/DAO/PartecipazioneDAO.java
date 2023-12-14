package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Evento;
import CristinaPalmisani.entities.Partecipazione;
import CristinaPalmisani.entities.Stato;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PartecipazioneDAO {
    private  final EntityManager em;

    public PartecipazioneDAO(EntityManager eem) {
        this.em = eem;
    }

    public void savePartecipazione(Partecipazione partecipazione){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("Partecipazione di: " + partecipazione.getPersona().getNome() + " per " + partecipazione.getEvento().getTitolo() + " salvata correttamente!");
    }

    public Partecipazione getById(long id){
        return em.find(Partecipazione.class, id);
    }

    public void deletePartecipazione(Partecipazione partecipazione){

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(partecipazione);

            System.out.println("Partecipazione di: " + partecipazione.getPersona().getNome() + " per " + partecipazione.getEvento() + " eliminata correttamente!");
    }

    public List<Partecipazione> getPartecipazioneDaConfermaprePerEvento(){
        TypedQuery<Partecipazione> query = em.createNamedQuery("partecipazioneEventoConf", Partecipazione.class);
        query.setParameter("stato", Stato.DA_CONFERMARE);
        return  query.getResultList();

    }
}
