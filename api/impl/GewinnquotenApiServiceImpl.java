package wbs.jsf1.rest.v1.api.impl;

import wbs.jsf1.rest.v1.api.*;
import wbs.jsf1.rest.v1.model.*;

import wbs.jsf1.rest.v1.model.Gewinnquoten;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import wbs.jsf1.rest.v1.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import wbs.jsf1.persistence.Gewinnklasse;
import wbs.jsf1.persistence.Gewinnklasseziehungquote;
import wbs.jsf1.persistence.GewinnklasseziehungquoteFacadeLocal;
import wbs.jsf1.persistence.Ziehung;
import wbs.jsf1.persistence.ZiehungFacadeLocal;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-03-15T00:05:48.184+01:00")
public class GewinnquotenApiServiceImpl extends GewinnquotenApiService {

	@EJB 
	GewinnklasseziehungquoteFacadeLocal gewinnklasseziehungsquoteFacade;

	@EJB
	ZiehungFacadeLocal ziehungFacade;

	@PersistenceContext(unitName = "jsf1PU")
    	private EntityManager em;
	
    @Override
    public Response getGewinnquoten(LocalDate datum, SecurityContext securityContext) throws NotFoundException {
	// Lets get some data

	    Gewinnquoten gewinnquoten = new Gewinnquoten();
	    gewinnquoten.setEinsatz6aus49(45_519_638_00L);
	    gewinnquoten.setEinsatzspiel77(12_544_652_50L);
	    gewinnquoten.setEinsatzspiel6(5_226_630_00L);
	    Model6aus49 m1 = new Model6aus49();
	    m1.setKlasse("1");
	    m1.setAnzahlrichtige("6 Richtige + SZ");
	    m1.setGewinne(0L);
	    m1.setQuoten(0L);
	    Model6aus49 m2 = new Model6aus49();
	    m2.setKlasse("2");
	    m2.setAnzahlrichtige("6 Richtige");
	    m2.setGewinne(1L);
	    m2.setQuoten(2_501_305_90L);
	    gewinnquoten.add6aus49sItem(m1);
	    gewinnquoten.add6aus49sItem(m2);

	    Spiel77 s77 = new Spiel77();
	    s77.setKlasse("VII");
	    s77.setAnzahlrichtige("1 richtige Endziffer");
	    s77.setGewinne(334_953L);
	    s77.setQuoten(5_00L);
	    gewinnquoten.addSpiel77sItem(s77);

	    Spiel6 s6 = new Spiel6();
	    s6.setKlasse("II");
	    s6.setAnzahlrichtige("5 richtige Endziffern");
	    s6.setGewinne(22L);
	    s6.setQuoten(6_666_00L);
	    gewinnquoten.addSpiel6sItem(s6);

	return Response.ok().entity(gewinnquoten).build();
	    
//        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
