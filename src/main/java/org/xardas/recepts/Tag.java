package org.xardas.recepts;

import javax.xml.bind.annotation.XmlType;

/**
 * This is a tag, which is used to classify a recipe.
 *
 * Created by Sebastian on 15.02.14.
 */
@XmlType
public enum Tag {

    vegetarisch ("vegetarisch"), auflauf ("Auflauf"), vorspeise ("Vorspeise"), hauptgang ("Hauptgang"), salat ("Salat")
    , partysnack ("Partysnack") ;


    private final String description;

    Tag(String description) {

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
