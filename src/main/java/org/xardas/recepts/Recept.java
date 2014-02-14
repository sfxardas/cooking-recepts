package org.xardas.recepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sebastian on 04.02.14.
 */
public class Recept {

    private final int id;
    private final String name;
    private final String description;
    private final String preparation;
    private final ArrayList<String> ingredients;
    private final int timeInMin;


    public Recept(int id, String name, String description, String preparation, List<String> ingredients, int timeInMin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preparation = preparation;
        this.ingredients = new ArrayList<String>(ingredients);
        this.timeInMin = timeInMin;
    }

    public void addIngredient(String ingredient)
    {
        ingredients.add(ingredient);
    }

    public int getTimeInMin() {
        return timeInMin;
    }

    public List<String> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public String getPreparation() {
        return preparation;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
