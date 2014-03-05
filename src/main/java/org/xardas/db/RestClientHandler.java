package org.xardas.db;


import com.sun.deploy.util.SessionState;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * The rest client handler does connect to the rest-service provided on the glasfish server and handles the access between
 * server and client application
 *
 * Created by Sebastian on 05.03.14.
 */
public class RestClientHandler {

    private final String wsUri;
    private final WebResource webResource;

    public RestClientHandler()
    {
        this("http://recipewebservice.sfxardas.cloudbees.net/recipeWS/resources/recipe");
    }

    public RestClientHandler(String wsUri) {
        this.wsUri = wsUri;
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        webResource = client.resource(UriBuilder.fromUri(wsUri).build());
    }

    public String getAllRecipes() {

        return webResource.path("getAllRecipes").accept(MediaType.TEXT_XML).get(String.class);

    }

    public String checkUpdatedRecipe(int id,long timestamp) {

        return null;
    }

    public String insertRecipe(String content) {

        return content;
    }

    public String updateRecipe(String content) {


        return content;
    }

}
