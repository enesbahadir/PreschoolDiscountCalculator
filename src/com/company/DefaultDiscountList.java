package com.company;

import java.util.ArrayList;

/**
 * Programın açılışında tanımlı olan indirim listedir.
 */
public enum DefaultDiscountList {
    EARLY_REGISTRATION_DISCOUNT(new Discount("EARLY_REGISTRATION_DISCOUNT",20L,DiscountType.PERCENTAGE,
                                new ArrayList<>() {{
                                    add(TypeOfUser.PERSONEL);
                                    add(TypeOfUser.IHVAN);
                                    add(TypeOfUser.STANDART);
                                }},
                                null,
                                new ArrayList<>() {{
                                    add(PreschoolList.YUNUS_EMRE_LALEBAHCESI.name());
                                    add((PreschoolList.YUNUS_EMRE_LALEBAHCESI).name());
                                }} )),
    PERSONNEL_DISCOUNT(new Discount("PERSONNEL_DISCOUNT",50L,DiscountType.PERCENTAGE,
                                    new ArrayList<>() {{
                                        add(TypeOfUser.PERSONEL);
                                    }},
                                    null,
                                    new ArrayList<>() {{
                                        add(PreschoolList.MADENLER_LALEBAHCESI.name());
                                        add((PreschoolList.YUNUS_EMRE_LALEBAHCESI).name());
                                    }} )),
    IHVAN_DISCOUNT(new Discount("IHVAN_DISCOUNT",5L,DiscountType.PERCENTAGE,
                                new ArrayList<>() {{
                                    add(TypeOfUser.IHVAN);
                                }},
                                null,
                                new ArrayList<>() {{
                                    add(PreschoolList.MADENLER_LALEBAHCESI.name());
                                    add((PreschoolList.YUNUS_EMRE_LALEBAHCESI.name()));
                                }} )),
    SAGLIKSEN_DISCOUNT(new Discount("SAGLIKSEN_DISCOUNT",10L,DiscountType.PERCENTAGE,
                                    new ArrayList<>() {{
                                        add(TypeOfUser.IHVAN);
                                        add(TypeOfUser.STANDART);
                                    }},
                                    OrganizationNames.SAGLIKSEN,
                                    new ArrayList<>() {{
                                        add(PreschoolList.MADENLER_LALEBAHCESI.name());
                                    }} )),
    ANADOLU_DISCOUNT(new Discount("ANADOLU_DISCOUNT",100L,DiscountType.AMOUNT,
                                    new ArrayList<>() {{
                                        add(TypeOfUser.IHVAN);
                                        add(TypeOfUser.STANDART);
                                    }},
                                    OrganizationNames.ANADOLU,
                                    new ArrayList<>() {{
                                        add(PreschoolList.YUNUS_EMRE_LALEBAHCESI.name());
                                    }} )),;

    DefaultDiscountList(Discount discount) {
        this.discount = discount;
    }
    Discount discount;
}
