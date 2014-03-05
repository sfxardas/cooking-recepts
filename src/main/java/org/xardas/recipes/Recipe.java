package org.xardas.recipes;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 04.02.14.
 */
@XmlRootElement
public class Recipe {

    private int id;
    private String name;
    private String description;
    private String preparation;
    private List<Ingredient> ingredients;
    private int timeInMin;
    private List<Tag> tags;
    private long lastChanged;

    public Recipe()
    {

    }

    public Recipe(int id, String name, String description, String preparation, List<Ingredient> ingredients, int timeInMin, long lastChanged) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.preparation = preparation;
        this.lastChanged = lastChanged;
        this.ingredients = new ArrayList<Ingredient>(ingredients);
        this.timeInMin = timeInMin;
        tags = new ArrayList<Tag>();
    }

    public void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }

    public void addTag(Tag tag)
    {
        tags.add(tag);
    }

    public void removeIngredient(String ingredient)
    {
        if(!ingredients.remove(ingredient))
        {
            throw new IllegalArgumentException("Ingredient Not Found");
        }
    }

    public void removeTag(Tag tag)
    {
        if(!tags.remove(tag))
        {
            throw new IllegalArgumentException("Tag Not Found");
        }
    }



    //getter and setter

    public int getTimeInMin() {
        return timeInMin;
    }

    @XmlElement ( name="ingredient")
    @XmlElementWrapper( name="ingredients" )
    public List<Ingredient> getIngredients() {
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

    @XmlElement ( name="tag")
    @XmlElementWrapper( name="tags" )
    public List<Tag> getTags() {
        return tags;
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

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setTimeInMin(int timeInMin) {
        this.timeInMin = timeInMin;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(long lastChanged) {
        this.lastChanged = lastChanged;
    }
}
