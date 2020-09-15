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
                                OrganizationNames.NONE,
                                new ArrayList<>() {{
                                    add(PreschoolNames.MADENLER_LALEBAHCESI);
                                    add((PreschoolNames.YUNUS_EMRE_LALEBAHCESI));
                                }} )),
    PERSONNEL_DISCOUNT(new Discount("PERSONNEL_DISCOUNT",50L,DiscountType.PERCENTAGE,
                                    new ArrayList<>() {{
                                        add(TypeOfUser.PERSONEL);
                                    }},
                                    OrganizationNames.NONE,
                                    new ArrayList<>() {{
                                        add(PreschoolNames.MADENLER_LALEBAHCESI);
                                        add((PreschoolNames.YUNUS_EMRE_LALEBAHCESI));
                                    }} )),
    IHVAN_DISCOUNT(new Discount("IHVAN_DISCOUNT",5L,DiscountType.PERCENTAGE,
                                new ArrayList<>() {{
                                    add(TypeOfUser.IHVAN);
                                }},
                                OrganizationNames.NONE,
                                new ArrayList<>() {{
                                    add(PreschoolNames.MADENLER_LALEBAHCESI);
                                    add((PreschoolNames.YUNUS_EMRE_LALEBAHCESI));
                                }} )),
    SAGLIKSEN_DISCOUNT(new Discount("SAGLIKSEN_DISCOUNT",10L,DiscountType.PERCENTAGE,
                                    new ArrayList<>() {{
                                        add(TypeOfUser.IHVAN);
                                        add(TypeOfUser.STANDART);
                                    }},
                                    OrganizationNames.SAGLIKSEN,
                                    new ArrayList<>() {{
                                        add(PreschoolNames.MADENLER_LALEBAHCESI);
                                    }} )),
    ANADOLU_DISCOUNT(new Discount("ANADOLU_DISCOUNT",100L,DiscountType.AMOUNT,
                                    new ArrayList<>() {{
                                        add(TypeOfUser.IHVAN);
                                        add(TypeOfUser.STANDART);
                                    }},
                                    OrganizationNames.ANADOLU,
                                    new ArrayList<>() {{
                                        add(PreschoolNames.YUNUS_EMRE_LALEBAHCESI);
                                    }} )),;

    DefaultDiscountList(Discount discount) {
        this.discount = discount;
    }
    Discount discount;
}
