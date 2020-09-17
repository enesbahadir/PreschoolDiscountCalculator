package com.company;

public enum PreschoolList {
    YUNUS_EMRE_LALEBAHCESI(new Preschool("YUNUS_EMRE_LALEBAHCESI", 1000L,
            "01/10/2020")),
    MADENLER_LALEBAHCESI(new Preschool("MADENLER_LALEBAHCESI", 1200L,
            "01/09/2020"))
    ;

    PreschoolList(IPreschoolAccess preschool) {
        this.preschool = preschool;
    }
    IPreschoolAccess preschool;

}
