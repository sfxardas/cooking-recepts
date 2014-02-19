package org.xardas.db;


import org.junit.Assert;
import org.junit.Test;
import org.xardas.recepts.Ingredient;
import org.xardas.recepts.Recipe;
import org.xardas.recepts.Tag;

import javax.xml.bind.JAXB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 14.02.14.
 */
public class DataStorageTest {
    DataStorage storage;

    @org.junit.Before
    public void setUp() throws Exception {

        storage = new DataStorage();

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(2,"paprika","stk"));
        ingredients.add(new Ingredient(200,"käse","gr"));

        Recipe recipe = new Recipe(1,"paprikaauflauf","mh lecker","paprika in ofen", ingredients, 20, lastChanged);

        recipe.addTag(Tag.auflauf);
        recipe.addTag(Tag.vegetarisch);

        storage.addRecipe(recipe);


        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(300,"Nachos","gr"));
        ingredients.add(new Ingredient(200,"käse","gr"));
        ingredients.add(new Ingredient(1,"Salat","stk"));

        recipe = new Recipe(2,"Nachosalat","mh lecker","alles in ne schüssel", ingredients, 40, lastChanged);

        storage.addRecipe(recipe);

    }

    @org.junit.Test
    public void testMarshalling() throws Exception {

        File file = new File( "storage.xml" );
        JAXB.marshal(storage, file);

        DataStorage storage1 = JAXB.unmarshal(file,DataStorage.class);


        Assert.assertEquals("paprikaauflauf", storage1.getRecipes().get(0).getName());

    }

    @Test
    public void testAddAndRemove() throws Exception {

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(300,"asd","gr"));
        ingredients.add(new Ingredient(200,"käse","gr"));

        Recipe recipe = new Recipe(2, "Nudeln", "mh lecker", "alles in ne schüssel", ingredients, 10, lastChanged);

        storage.addRecipe(recipe);

        Assert.assertEquals(3,storage.getRecipes().size());

        storage.deleteRecipe(recipe);

        Assert.assertEquals(2,storage.getRecipes().size());


    }



    public void testExtremeValues() throws Exception {

        storage = new DataStorage();

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(2,"paprika","stk"));
        ingredients.add(new Ingredient(200,"käse","gr"));

        Recipe recipe = new Recipe(1,"paprikaauflauf","mh lecker","paprika in ofen", ingredients, 20, lastChanged);

        recipe.addTag(Tag.auflauf);
        recipe.addTag(Tag.vegetarisch);

        for(int i=0; i<3000;i++)
        {
            storage.addRecipe(recipe);
        }

        File file = new File( "storageExtreme.xml" );
        JAXB.marshal(storage, file);

        DataStorage storage1 = JAXB.unmarshal(file,DataStorage.class);


    }
}
