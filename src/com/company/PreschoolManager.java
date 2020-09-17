package com.company;

import java.util.ArrayList;
import java.util.List;

public class PreschoolManager {
    static List<IPreschoolAccess> preschoolList = new ArrayList<>();

    public static List<IPreschoolAccess> setDefaultPreschoolList() {
        for (PreschoolList preschools : PreschoolList.values() )
        {
            preschoolList.add(preschools.preschool);
        }
        return preschoolList;
    }



}
