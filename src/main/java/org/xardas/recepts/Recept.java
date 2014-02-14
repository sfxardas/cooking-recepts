package org.xardas.recepts;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sebastian on 04.02.14.
 */
@XmlType
public class Recept {

    private int id;
    private String name;
    private String description;
    private String preparation;
    private List<String> ingredients;
    private int timeInMin;

    public Recept()
    {

    }

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

    @XmlElement ( name="ingredient")
    @XmlElementWrapper( name="ingredients" )
    public List<String> getIngredients() {
        return ingredients;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTimeInMin(int timeInMin) {
        this.timeInMin = timeInMin;
    }
}
