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
    private final ArrayList<String> ingredient;
    private final int timeInMin;


    public Recept(int id, String name, String description, String preparation, List<String> ingredient, int timeInMin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preparation = preparation;
        this.ingredient = new ArrayList<String>(ingredient);
        this.timeInMin = timeInMin;
    }

    public int getTimeInMin() {
        return timeInMin;
    }

    public List<String> getIngredient() {
        return Collections.unmodifiableList(ingredient);
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
