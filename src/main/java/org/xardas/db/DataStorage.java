package org.xardas.db;

import org.xardas.recepts.Recipe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 04.02.14.
 */

@XmlRootElement( namespace = "http://cooking.recipes/" )
public class DataStorage {

    private final List<Recipe> recipes = new ArrayList<Recipe>();


    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }

    public void deleteRecipe(Recipe recipe)
    {
        if(!recipes.remove(recipe))
        {
            throw new IllegalArgumentException("Recipe Not Found");
        }
    }

    public void transform() {

    }

    @XmlElement( name = "recipe" )
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
