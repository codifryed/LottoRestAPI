/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wbs.jsf1.rest.v1.api.impl;

import java.time.LocalDate;
import java.util.Date;
import javax.ejb.Local;
import wbs.jsf1.persistence.Gewinnklasse;
import wbs.jsf1.persistence.Gewinnklasseziehungquote;
import wbs.jsf1.persistence.Spiel;
import wbs.jsf1.persistence.Ziehung;

/**
 *
 * @author Administrator
 */
@Local
public interface QueryUtilLocal {

    Gewinnklasse gewinnklasseSpielGewinnklasse(Spiel spiel, int gewinnklasse, Date datum);

    Gewinnklasseziehungquote gewinnklasseziehungquote(Gewinnklasse gewinnklasse, Ziehung ziehungId);

    Ziehung ziehung(Date datum);
}
