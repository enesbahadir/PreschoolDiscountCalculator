package com.company;

/**
 * Kullanıcının toplam indirimini hesaplayan sınıftır. Kuralların tanımlı olduğu sınıfların super class'ıdır.
 */
public class DiscountDecorator implements IDiscountCalculator {

    private IDiscountCalculator wrappee;

    /**
     * Constructor metodu sayesinde kuralların tanımlı olduğu sınıflar birbirlerini çağırırlar.
     * @param wrappee Kuralların tanımlı olduğu sınıfların birbirlerini çağrılmasını sağlayan IDiscountCalculator
     *                interface objesi
     */
    public DiscountDecorator(IDiscountCalculator wrappee) {
        this.wrappee = wrappee;

    }

    /**
     * Kullanıcının indiriminin hesaplandığı metoddur.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return indirim miktarı
     */
    @Override
    public long calculateDiscount( IUserAccess user, IPreschoolAccess preschool) {
        return wrappee.calculateDiscount(user, preschool);
    }

    /**
     * Verilen parametrelerden ücretin yüzdesini hesaplayan metoddur.
     * @param price Anaokulu ücreti
     * @param percent İndirim yüzdesi
     * @return
     */
    public long calculateDecreasePercentOfANumber(long price, long percent) {

        if (percent == 0)
            return price;
        return price - (price * percent / 100);
    }
}
