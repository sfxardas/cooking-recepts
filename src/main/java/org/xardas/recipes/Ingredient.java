package org.xardas.recipes;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by Sebastian on 15.02.14.
 */

@XmlType
public class Ingredient {

    private double amount;
    private String name;
    private String unit;

    public Ingredient() {
    }

    public Ingredient(double amount, String name, String unit) {
        this.amount = amount;
        this.name = name;
        this.unit = unit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
