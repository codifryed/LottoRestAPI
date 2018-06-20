package wbs.jsf1.rest.v1.api.factories;

import wbs.jsf1.rest.v1.api.GewinnquotenApiService;
import wbs.jsf1.rest.v1.api.impl.GewinnquotenApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-03-15T00:05:48.184+01:00")
public class GewinnquotenApiServiceFactory {
    private final static GewinnquotenApiService service = new GewinnquotenApiServiceImpl();

    public static GewinnquotenApiService getGewinnquotenApi() {
        return service;
    }
}
