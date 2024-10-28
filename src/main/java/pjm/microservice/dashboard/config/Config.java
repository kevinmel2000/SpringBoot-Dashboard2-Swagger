package pjm.microservice.dashboard.config;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.util.MultiValueMap;
import pjm.microservice.dashboard.config.Constant.APP_WEBSERVER;
import pjm.microservice.dashboard.config.Constant.APP_ENVIRONMENT;

public class Config {
    public static APP_WEBSERVER appWebServer = APP_WEBSERVER.Wildfly;
    public static APP_ENVIRONMENT appEnvironment = APP_ENVIRONMENT.DEV;

    public static MultivaluedMap<String, Object> getDefaultHeader(String bearer){
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
        headers.add("Content-Type", "application/json");
        headers.add("accept", "application/json, text/plain, text/html");
        if (bearer != null) {
            headers.add("authorization", "bearer"+ bearer);
        }
        return headers;
    }
}
