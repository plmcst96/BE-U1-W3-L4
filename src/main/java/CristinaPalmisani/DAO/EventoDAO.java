package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Concerto;
import CristinaPalmisani.entities.Evento;
import CristinaPalmisani.entities.GenereConcerto;
import CristinaPalmisani.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {
    private  final EntityManager em;

    public EventoDAO(EntityManager eem) {
        this.em = eem;
    }

    public void save(Evento evento){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento " + evento.getTitolo() + " salvato correttamente!");
    }

    public Evento getById(long id){
        return em.find(Evento.class, id);
    }

    public void delete(long id){
        Evento found = this.getById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
        } else {
            System.out.println("Evento " + found.getTitolo() + " eliminato correttamente!");
        }
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = : genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteCasa(){
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partiteVinteCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(){
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("partiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
