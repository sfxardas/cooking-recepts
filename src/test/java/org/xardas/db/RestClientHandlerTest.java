package org.xardas.db;

import org.junit.Test;

/**
 * Created by Sebastian on 05.03.14.
 */
public class RestClientHandlerTest {

    @Test
    public void testGetAllRecipes() throws Exception {

        RestClientHandler handler = new RestClientHandler();

        System.out.println(handler.getAllRecipes());

    }
}
