package com.company;

import java.util.ArrayList;
import java.util.List;

public class PreschoolManager {

    /**
     *
     * @param preschool
     */
    public static void addNewPreschool(IPreschoolAccess preschool) {
        if (Database.preschoolList.contains(preschool)) {
            return;
        }
        Database.preschoolList.add(preschool);

    }

    /**
     *
     * @param preschool
     */
    public static void deletePreschoolFromList(IPreschoolAccess preschool)
    {
        Database.preschoolList.remove(preschool);
    }

    //setPreschool
}
