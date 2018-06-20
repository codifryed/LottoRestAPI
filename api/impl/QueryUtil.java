/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wbs.jsf1.rest.v1.api.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import wbs.jsf1.persistence.Gewinnklasse;
import wbs.jsf1.persistence.Gewinnklasseziehungquote;
import wbs.jsf1.persistence.Spiel;
import wbs.jsf1.persistence.Ziehung;

/**
 *
 * @author Administrator
 */
@Stateless
public class QueryUtil implements QueryUtilLocal{

    @PersistenceContext(unitName = "jsf1PU")
    private EntityManager em;

    @Override
    public Gewinnklasse gewinnklasseSpielGewinnklasse(Spiel spiel, int gewinnklasse, Date datum){

        Query query = em.createQuery("SELECT g FROM Gewinnklasse g "
                + "                     WHERE g.spielId.spielId = :spieleId "
                + "                         AND g.gewinnklasseNr = :gewinnklasseNr "
                + "                         AND :from >= g.gueltigAb AND :to <= g.gueltigBis"
        )
        .setParameter("spieleId", spiel.getSpielId())
        .setParameter("gewinnklasseNr", gewinnklasse)
        .setParameter("from", datum)
        .setParameter("to", datum);
        
        System.out.println("Ausgabe Parameter: spielId: " + spiel.getSpielId() + " / gewinnklasse: " + gewinnklasse + " / datum: " + datum);
        
        System.out.println("Ergebnis aus Abfrage Gewinnklasse: " + query.getResultList().toString());
        List<Gewinnklasse> gewinnklassen = query.getResultList();

        return gewinnklassen.get(0);

    }

    @Override
    public Gewinnklasseziehungquote gewinnklasseziehungquote(Gewinnklasse gewinnklasse, Ziehung ziehungId) {

        Query query = em.createQuery("SELECT gq FROM Gewinnklasseziehungquote gq "
                + "                     WHERE gq.ziehungId = :ziehungId "
                                        + "AND gq.gewinnklasseId.gewinnklasseId = :gewinnklasseId")
        .setParameter("ziehungId", ziehungId)
        .setParameter("gewinnklasseId", gewinnklasse.getGewinnklasseId())
        ;

        System.out.println("Ergebnis aus Abfrage Gewinnklasseziehungquote: " + query.getResultList().toString());
        
        List<Gewinnklasseziehungquote> gewinnklasseziehungquoten = query.getResultList();

        return gewinnklasseziehungquoten.get(0);

    }

    @Override
    public Ziehung ziehung(Date datum) {

        Query query = em.createQuery("SELECT z FROM Ziehung z WHERE z.ziehungsdatum = :ziehungsdatum").setParameter("ziehungsdatum", datum);
        List<Ziehung> ziehung = query.getResultList();

        return ziehung.get(0);

    }
    
}
