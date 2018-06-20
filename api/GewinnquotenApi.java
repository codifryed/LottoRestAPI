package wbs.jsf1.rest.v1.api;

import wbs.jsf1.rest.v1.model.*;
import wbs.jsf1.rest.v1.api.factories.GewinnquotenApiServiceFactory;

import io.swagger.annotations.ApiParam;

import wbs.jsf1.rest.v1.model.Gewinnquoten;
import java.time.LocalDate;

import java.util.List;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import org.threeten.bp.Month;
import wbs.jsf1.persistence.Gewinnklasse;
import wbs.jsf1.persistence.Gewinnklasseziehungquote;
import wbs.jsf1.persistence.Spiel;
import wbs.jsf1.persistence.SpielFacadeLocal;
import wbs.jsf1.persistence.Ziehung;
import wbs.jsf1.rest.v1.api.impl.QueryUtilLocal;

@Path("/gewinnquoten")


@io.swagger.annotations.Api(description = "the gewinnquoten API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-03-15T00:05:48.184+01:00")
public class GewinnquotenApi  {

@PersistenceContext(unitName = "jsf1PU")
    private EntityManager em;

   private final GewinnquotenApiService delegate;

    	@EJB
    QueryUtilLocal queryUtilLocal;
    @EJB 
    SpielFacadeLocal spielFacadeLocal;

   @Context
   private ServletConfig servletContext;

   public GewinnquotenApi() {
      GewinnquotenApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("GewinnquotenApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (GewinnquotenApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = GewinnquotenApiServiceFactory.getGewinnquotenApi();
      }

      this.delegate = delegate;
   }

    @GET
    @Path("/{datum}")
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Bekomme die Gewinnquoten von einem Datum", notes = "", response = Gewinnquoten.class, tags={ "users", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "erfolgreiche Aufruf", response = Gewinnquoten.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid datum gegeben", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Keine Ziehung mit gegebene Datum", response = Void.class) })
    public Response getGewinnquoten(@ApiParam(value = "Eine Ziehungs Datum",required=true) @PathParam("datum") String date //LocalDate datum
,@Context SecurityContext securityContext)
    throws NotFoundException {
	    
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate datum = null;

        try {
            datum = LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Invalid datum eingegeben")).build();

        }
        // ist das Datum in der Datenbank?
        try{
            Date date7 = Date.from(datum.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Query query = em.createNamedQuery("Ziehung.findByZiehungsdatum", Ziehung.class).setParameter("ziehungsdatum", date7);
            List<Ziehung> ziehungen = query.getResultList();
            if (ziehungen.isEmpty() && ziehungen != null) {
                return Response.status(Response.Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Keine Ziehung mit gegebene Datum")).build();
            }

            Ziehung zQuery = queryUtilLocal.ziehung(date7);
            System.out.println("Ergebnis Ziehung: " + zQuery.toString());

            Gewinnquoten gewinnquoten = new Gewinnquoten();
            gewinnquoten.setEinsatz6aus49(zQuery.getEinsatzLotto().longValue());
            gewinnquoten.setEinsatzspiel77(zQuery.getEinsatzSpiel77().longValue());
            gewinnquoten.setEinsatzspiel6(zQuery.getEinsatzSuper6().longValue());

            List<Spiel> spiele = spielFacadeLocal.findAll();
            for(Spiel sp : spiele){
                if(sp.getSpielId() == 3){
                    // 6 aus 49
                    // TODO: Dynamische Abfrage nach den Gewinnklassen
                    for(int i = 1; i<10; i++){
                        Gewinnklasse gkQuery = queryUtilLocal.gewinnklasseSpielGewinnklasse(sp, i, date7);
                        Gewinnklasseziehungquote gkq = queryUtilLocal.gewinnklasseziehungquote(gkQuery, zQuery );
                        Model6aus49 m1 = new Model6aus49();
                        m1.setKlasse(String.valueOf(gkQuery.getGewinnklasseNr()));
                        m1.setAnzahlrichtige(gkQuery.getBeschreibung());
                        m1.setGewinne(Long.valueOf(gkq.getAnzahlGewinner()));
                        m1.setQuoten(gkq.getQuote());
                        gewinnquoten.add6aus49sItem(m1);
                    }
                } else if(sp.getSpielId() == 2){
                    // Spiel 77
                    // TODO: Dynamische Abfrage nach den Gewinnklassen
                    for(int i = 1; i<8; i++){
                        Gewinnklasse gkQuery = queryUtilLocal.gewinnklasseSpielGewinnklasse(sp, i, date7);
                        Gewinnklasseziehungquote gkq = queryUtilLocal.gewinnklasseziehungquote(gkQuery, zQuery );
                        Spiel77 s77 = new Spiel77();
                        s77.setKlasse(gkQuery.getBezeichnungLatein());
                        s77.setAnzahlrichtige(gkQuery.getBeschreibung());
                        s77.setGewinne(Long.valueOf(gkq.getAnzahlGewinner()));
                        s77.setQuoten(gkq.getQuote());
                        gewinnquoten.addSpiel77sItem(s77);
                    }
                } else if(sp.getSpielId() == 1){
                    // Super 6
                    // TODO: Dynamische Abfrage nach den Gewinnklassen
                    for(int i = 1; i<7; i++){
                        Gewinnklasse gkQuery = queryUtilLocal.gewinnklasseSpielGewinnklasse(sp, i, date7);
                        Gewinnklasseziehungquote gkq = queryUtilLocal.gewinnklasseziehungquote(gkQuery, zQuery );
                        Spiel6 s6 = new Spiel6();
                        s6.setKlasse(gkQuery.getBezeichnungLatein());
                        s6.setAnzahlrichtige(gkQuery.getBeschreibung());
                        s6.setGewinne(Long.valueOf(gkq.getAnzahlGewinner()));
                        s6.setQuoten(gkq.getQuote());
                        gewinnquoten.addSpiel6sItem(s6);
                    }
                }
            }
            return Response.ok().entity(gewinnquoten).build();
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Sorry, no content")).build();
        }
	
//        return delegate.getGewinnquoten(datum,securityContext);
    }
}
