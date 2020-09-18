package com.company;

import java.util.Objects;

/**
 * Kullanıcının ve anaokulunun bilgilerini alarak indirimin hesaplandığı sınıftır.
 */
public class DiscountCalculator  {

    private IUserAccess user;
    private IPreschoolAccess preschool;
    private Iterator iterator;

    /**
     * Kullanıcı ve anaokulu bilgilerinin alındığı constructor metodudur.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     */
    public DiscountCalculator(IUserAccess user, IPreschoolAccess preschool) {
        this.user = user;
        this.preschool = preschool;

        // @TODO dependency
        ConcreteCollection concreteCollection = new ConcreteCollection();
        iterator = concreteCollection.createDiscountIterator(preschool);
    }

    /**
     *
     * @return
     */
    public long calculateDiscount() {

        long percent = 0;
        long amount = 0;

        while(iterator.hasNext())
        {
            Discount discount = iterator.next();

            switch (discount.getDiscountType()) {
                case PERCENTAGE -> percent += executeCalculateMethods(discount);
                case AMOUNT -> amount += executeCalculateMethods(discount);
            }
        }
        return calculatePriceWithDiscount(percent,amount);
    }

    /**
     *
     * @param discount
     * @return
     */
    public long executeCalculateMethods(Discount discount) {
        return calculateEarlyRegistrationDiscount(discount) +
                calculateOrganizationDiscount(discount) +
                calculateUserTypeDiscount(discount);
    }

    /**
     *
     * @param percent
     * @param amount
     * @return
     */
    public long calculatePriceWithDiscount(long percent, long amount)
    {
        return preschool.getPrice() - (preschool.getPrice()*percent/100) - amount ;

    }

    /**
     * Erken kayıt indirimini anaokulu bilgileri üzerinden hesaplayan metoddur.
     * @param discount
     * @return
     */
    public long calculateEarlyRegistrationDiscount(Discount discount) {
        if(discount.getDiscountName().equals(DefaultDiscountList.EARLY_REGISTRATION_DISCOUNT.name())
                && preschool.isInEarlyRegistration())
        {
            return discount.getPreschoolNamesAndTheirPrice().get(preschool.getPreschoolName());
        }
        return 0;
    }

    /**
     * Kullanıcı tipi indirimini hesaplayan metoddur. İndirim tablosunda kullanıcı tipi tek olan indirim kontrolü yaparak
     * kullanıcı tipine özel indirimi hesaplar.
     * @param discount
     * @return
     */
    public long calculateUserTypeDiscount(Discount discount) {
        if( discount.getTypeOfUser().size() == 1 && discount.getTypeOfUser().contains(user.getTypeOfUser()))
        {
            return discount.getPreschoolNamesAndTheirPrice().get(preschool.getPreschoolName());
        }
        return 0;

    }

    /**
     * Kurum indirimlerinin hesaplandığı metoddur.
     * Anaokulunun anlaştığı kurum ile kullanıcının çalıştığı kurumların karşılaştırmasını yapar.
     * @param discount
     * @return
     */
    public long calculateOrganizationDiscount (Discount discount) {
        if(discount.getOrganizationName() != null &&
                Objects.equals(discount.getOrganizationName(), user.getOrganizationName()) )
            return discount.getPreschoolNamesAndTheirPrice().get(preschool.getPreschoolName());
        return 0;
    }

}
