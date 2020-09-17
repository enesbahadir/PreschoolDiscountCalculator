package com.company;

import java.util.Objects;

/**
 * Kullanıcının ve anaokulunun bilgilerini alarak indirimin hesaplandığı sınıftır.
 */
public class DiscountCalculator  {

    private IUserAccess user;
    private IPreschoolAccess preschool;

    /**
     * Kullanıcı ve anaokulu bilgilerinin alındığı constructor metodudur.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     */
    public DiscountCalculator(IUserAccess user, IPreschoolAccess preschool) {
        this.user = user;
        this.preschool = preschool;
    }

    /**
     * Üzerinde çalışılmaya devam ediliyor.
     * @return
     */
    public long calculateDiscount() {
        long percent = 0;
        long amount = 0;
        Iterator iterator = createIterator();

        while(iterator.hasNext())
        {
            Discount discount = iterator.next();
            switch (discount.getDiscountType()) {
                case PERCENTAGE -> {
                    percent = percent + calculateEarlyRegistrationDiscount(discount);
                    percent = percent + calculateOrganizationDiscount(discount);
                    percent = percent + calculateUserTypeDiscount(discount);
                }
                case AMOUNT -> {
                    amount = amount + calculateEarlyRegistrationDiscount(discount);
                    amount = amount + calculateOrganizationDiscount(discount);
                    amount = amount + calculateUserTypeDiscount(discount);
                }
            }
        }
        return calculateNewPrice(percent,amount);
    }

    public long calculateNewPrice(long percent, long amount)
    {
        preschool.setPrice( preschool.getPrice() - (preschool.getPrice()*percent/100) - amount );
        return preschool.getPrice();
    }

    /**
     * Anaokulunun sahip olduğu indirim listesinde ilerlemeyi sağlayan iterator sınıfının objesini oluşturur.
     * @return
     */
    public Iterator createIterator () {
        return new DiscountIterator(DiscountManager.setDefaultDiscountByPreschool(preschool) );
    }

    /**
     * Erken kayıt indirimini anaokulu bilgileri üzerinden hesaplayan metoddur.
     * @param discount
     * @return
     */
    public long calculateEarlyRegistrationDiscount(Discount discount) {
        return discount.getName().equals(DefaultDiscountList.EARLY_REGISTRATION_DISCOUNT.name())
                && preschool.isInEarlyRegistration() ? discount.getValue() : 0;
    }

    /**
     * Kullanıcı tipi indirimini hesaplayan metoddur. İndirim tablosunda kullanıcı tipi tek olan indirim kontrolü yaparak
     * kullanıcı tipine özel indirimi hesaplar.
     * @param discount
     * @return
     */
    public long calculateUserTypeDiscount(Discount discount) {
        return discount.getTypeOfUser().size() == 1 && discount.getTypeOfUser().contains(user.getTypeOfUser())
                ? discount.getValue() : 0;
    }

    /**
     * Kurum indirimlerinin hesaplandığı metoddur.
     * Anaokulunun anlaştığı kurum ile kullanıcının çalıştığı kurumların karşılaştırmasını yapar.
     * @param discount
     * @return
     */
    public long calculateOrganizationDiscount (Discount discount) {
       return discount.getOrganizationName() != null && Objects.equals(discount.getOrganizationName(),
               user.getOrganizationName())
                 ? discount.getValue() : 0;

    }

}
