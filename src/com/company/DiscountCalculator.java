package com.company;

/**
 * İndirim kuralları uygulandıktan sonra toplam indirimi hesaplayan sınıftır.
 */
public class DiscountCalculator implements IDiscountCalculator {

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
     * Bu metodda sorunum var.
     * @param user
     * @param preschool
     * @return
     */
    @Override
    public long calculateDiscount(IUserAccess user, IPreschoolAccess preschool) {
        return 0;
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
