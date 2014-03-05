package org.xardas.recepts;

import org.junit.Test;
import org.xardas.db.DataStorage;
import org.xardas.recipes.Ingredient;
import org.xardas.recipes.Recipe;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;
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

        StringWriter sw = new StringWriter();
        JAXB.marshal(recipe, sw);


        StringReader reader = new StringReader(sw.toString());
        Recipe recipe1 = JAXB.unmarshal(reader,Recipe.class);

        System.out.println(recipe1.getName());

    }
}
