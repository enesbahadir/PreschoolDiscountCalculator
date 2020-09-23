package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Programın açılışında tanımlı olan indirim listedir.
 */
public enum DefaultDiscountList {
    EARLY_REGISTRATION_DISCOUNT(new Discount("EARLY_REGISTRATION_DISCOUNT", DiscountType.PERCENTAGE,
                                new ArrayList<>() {{
                                    add(UserType.PERSONEL);
                                    add(UserType.IHVAN);
                                    add(UserType.STANDART);
                                }},
                                null, new HashMap<String, Long >() {{
                                put(PreschoolList.YUNUS_EMRE_LALEBAHCESI.name(), 20L);
                                put((PreschoolList.MADENLER_LALEBAHCESI).name(), 20L);
    }} )),

    PERSONNEL_DISCOUNT(new Discount("PERSONNEL_DISCOUNT",DiscountType.PERCENTAGE,
                                    new ArrayList<>() {{
                                        add(UserType.PERSONEL);
                                    }},
                                    null,
                                    new HashMap<String, Long >() {{
                                        put(PreschoolList.YUNUS_EMRE_LALEBAHCESI.name(), 50L);
                                        put((PreschoolList.MADENLER_LALEBAHCESI).name(), 50L);
            }} )),
    IHVAN_DISCOUNT(new Discount("IHVAN_DISCOUNT",DiscountType.PERCENTAGE,
                                new ArrayList<>() {{
                                    add(UserType.IHVAN);
                                }},
                                null,
                                new HashMap<String, Long >() {{
                                    put(PreschoolList.YUNUS_EMRE_LALEBAHCESI.name(), 5L);
                                    put((PreschoolList.MADENLER_LALEBAHCESI).name(), 5L);
                                }} )),
    SAGLIKSEN_DISCOUNT(new Discount("SAGLIKSEN_DISCOUNT",DiscountType.PERCENTAGE,
                                    new ArrayList<>() {{
                                        add(UserType.IHVAN);
                                        add(UserType.STANDART);
                                    }},
                                    OrganizationNames.SAGLIKSEN,
                                    new HashMap<String, Long >() {{
                                        put(PreschoolList.YUNUS_EMRE_LALEBAHCESI.name(), 10L);
                                    }} )),
    ANADOLU_DISCOUNT(new Discount("ANADOLU_DISCOUNT",DiscountType.AMOUNT,
                                    new ArrayList<>() {{
                                        add(UserType.IHVAN);
                                        add(UserType.STANDART);
                                    }},
                                    OrganizationNames.ANADOLU,
                                    new HashMap<String, Long >() {{
                                        put(PreschoolList.MADENLER_LALEBAHCESI.name(), 100L);
                                    }} )),;

    DefaultDiscountList(Discount discount) {
        this.discount = discount;
    }
    Discount discount;
}
