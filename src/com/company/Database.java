package com.company;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Discount> discounts = new ArrayList();

    public static List<Discount> discountByPreschool = new ArrayList<>();

    public static List<IPreschoolAccess> preschoolList = new ArrayList<>();

    /**
     *
     * @return
     */
    public static void setDefaultDiscount() {

        for ( DefaultDiscountList defaultDiscount : DefaultDiscountList.values())
        {
            discounts.add( defaultDiscount.discount);
        }

    }
    /**
     *
     * @param preschool
     * @return
     */
    public static List<Discount> setDiscountByPreschool(IPreschoolAccess preschool) {

        for (Discount discount : discounts) {
            if (discount.getPreschoolNamesAndTheirDiscounts().containsKey(preschool.getPreschoolName())
                    && !discountByPreschool.contains(discount))
                discountByPreschool.add(discount);
        }
        return discountByPreschool;
    }

    /**
     *
     * @return
     */
    public static List<IPreschoolAccess> setDefaultPreschoolList() {

        for (PreschoolList preschool : PreschoolList.values()) {
            preschoolList.add(preschool.preschool);
        }
        return preschoolList;
    }

}