/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapplication;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        restNewsAPI client = new restNewsAPI();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Kyle
 */
public class restNewsAPI {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/newsFeeder/webresources";

    public restNewsAPI() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public String getHtml() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public String putHtml(Object requestEntity) throws ClientErrorException { //use this to request the news feed html page
        return webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML), String.class);
    }

    public void close() {
        client.close();
    }
    
}
