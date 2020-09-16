package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DiscountManager {

    static List<Discount> discountList;

    /**
     *
     * @param preschool
     * @return
     */
     public static List<Discount> setDefaultDiscountByPreschool(IPreschoolAccess preschool) {
         discountList = new ArrayList<>();

        for ( DefaultDiscountList defaultDiscount : DefaultDiscountList.values())
        {
            if( defaultDiscount.discount.getPreschoolNames().contains( preschool.getPreschoolName()))
            {
                discountList.add( defaultDiscount.discount);
            }
        }
        return discountList;
    }

    /**
     *
     * @return
     */
    public static List<Discount> setDefaultDiscount() {
        discountList = new ArrayList<>();

        for ( DefaultDiscountList defaultDiscount : DefaultDiscountList.values())
        {
            discountList.add( defaultDiscount.discount);
        }
        return discountList;
    }



}
