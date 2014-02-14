package org.xardas.db;

import org.xardas.recepts.Recept;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sebastian on 04.02.14.
 */

@XmlRootElement( namespace = "http://cooking.recepts/" )
public class DataStorage {

    private final List<Recept> recepts = new ArrayList<Recept>();


    public void addRecept(Recept recept)
    {
        recepts.add(recept);
    }

    public void deleteRecept(Recept recept)
    {
        if(recepts.remove(recept))
        {
            throw new IllegalArgumentException("Recept Not Found");
        }
    }

    public void transform() {

    }

    @XmlElement( name = "recept" )
    public List<Recept> getRecepts() {
        return recepts;
    }
}
