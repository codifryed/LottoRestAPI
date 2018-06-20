package wbs.jsf1.rest.v1.api;

import wbs.jsf1.rest.v1.api.*;
import wbs.jsf1.rest.v1.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import wbs.jsf1.rest.v1.model.Gewinnquoten;
import java.time.LocalDate;

import java.util.List;
import wbs.jsf1.rest.v1.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-03-15T00:05:48.184+01:00")
public abstract class GewinnquotenApiService {
    public abstract Response getGewinnquoten(LocalDate datum,SecurityContext securityContext) throws NotFoundException;
}
