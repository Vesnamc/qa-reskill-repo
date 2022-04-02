package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChoosers {

    public static String getRandomSex(){
        ArrayList<String> listOfSex = new ArrayList<>();
        listOfSex.add("M");
        listOfSex.add("F");
        return  listOfSex.get(RandomUtils.nextInt(0, listOfSex.size()));
    }
}
