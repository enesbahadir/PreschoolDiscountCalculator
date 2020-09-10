package com.company;

/**
 * İndirim kuralların tanımlanacağı sınıfların interfacesidir.
 */
public interface IDiscountCalculator {
    /**
     * kullanıcnın indirim miktarını hesaplayan metoddur.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return indirim mikyarı
     */
    long calculateDiscount(IUserAccess user, IPreschoolAccess preschool);

}
