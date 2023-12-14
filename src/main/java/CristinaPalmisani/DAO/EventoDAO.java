package CristinaPalmisani.DAO;

import CristinaPalmisani.entities.Concerto;
import CristinaPalmisani.entities.Evento;

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

    public List<Concerto> getConcertiInStreaming(){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concert c WHERE c.inStreaming = true", Concerto.class);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(){
        TypedQuery<Concerto> query = em.createQuery("SELECT c FROM Concert c WHERE c.genere = : genere", Concerto.class);
        return query.getResultList();
    }
}
