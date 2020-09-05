package com.company;

/**
 * Sistemde tanımlı olan indirim kuralları ile, bu kuralların hangi indirim tipinde uygulancaklarını listeleyen sınıf
 */
public enum Discounts {

    EARLY_REGISTRATION_DISCOUNT(DiscountType.PERCENTAGE, 20L),

    PERSONNEL_DISCOUNT (DiscountType.PERCENTAGE, 50L),

    IHVAN_DISCOUNT (DiscountType.PERCENTAGE, 5L),

    SAGLIKSEN_DISCOUNT (DiscountType.PERCENTAGE, 10L),

    ANADOLU_DISCOUNT (DiscountType.AMOUNT, 100L);

    Discounts(DiscountType discountType, Long value) {
        this.discountType = discountType;
        this.value = value;
    }

    DiscountType discountType;
    Long value;
}
