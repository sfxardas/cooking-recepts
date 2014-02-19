package org.xardas.recepts;

import org.junit.Test;
import org.xardas.db.DataStorage;

import javax.xml.bind.JAXB;
import javax.xml.bind.util.JAXBResult;
import javax.xml.transform.Result;
import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Sebastian on 19.02.14.
 */
public class RecipeTest {


    @Test
    public void testMarshalling() throws Exception {

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(300,"Nachos","gr"));
        ingredients.add(new Ingredient(200,"käse","gr"));
        ingredients.add(new Ingredient(1,"Salat","stk"));

        Recipe recipe = new Recipe(2, "Nachosaslat", "mh lecker", "alles in ne schüssel", ingredients, 40, 0);

        DataStorage t = new DataStorage();
        t.addRecipe(recipe);

        StringWriter writer = new StringWriter();
        JAXB.marshal(recipe, writer);

        System.out.println(writer.toString());

    }
}
