package org.xardas.db;


import org.xardas.recepts.Recept;

import javax.xml.bind.JAXB;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 14.02.14.
 */
public class DataStorageTest {


    @org.junit.Before
    public void setUp() throws Exception {


    }

    @org.junit.Test
    public void testAddRecept() throws Exception {

        DataStorage storage = new DataStorage();

        List<String> ingredients = new ArrayList<String>();
        ingredients.add("paprika 2x");
        ingredients.add("käse 200gr");

        Recept recept = new Recept(1,"paprikaauflauf","mh lecker","paprika in ofen", ingredients, 20);

        storage.addRecept(recept);


        ingredients = new ArrayList<String>();
        ingredients.add("hackfleisch");
        ingredients.add("käse 200gr");
        ingredients.add("nachos");
        ingredients.add("salat");

        recept = new Recept(2,"Nachosalat","mh lecker","alles in ne schüssel", ingredients, 40);

        storage.addRecept(recept);


        File file = new File( "storage.xml" );
        JAXB.marshal(storage, file);

        DataStorage storage1 = JAXB.unmarshal(file,DataStorage.class);

        System.out.println(storage1.getRecepts().get(0).getName());

    }
}
