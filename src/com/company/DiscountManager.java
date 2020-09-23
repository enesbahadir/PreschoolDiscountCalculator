package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DiscountManager {

    public static void addNewDiscount (Discount discount)
    {
        if (Database.discounts.contains(discount)) {
            return;
        }
        Database.discounts.add(discount);
    }

    public static void deleteDiscount (Discount discount)
    {
        if (Database.discounts.contains(discount))
            Database.discounts.remove(discount);
    }

}
