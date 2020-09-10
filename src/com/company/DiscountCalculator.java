package com.company;

/**
 * İndirim kuralları için Kullanıcı ve Anaokulu bilgilerini ileten sınıftır.
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
     *
     * @param user
     * @param preschool
     * @return
     */
    @Override
    public long calculateDiscount(IUserAccess user, IPreschoolAccess preschool) {
        return 0;
    }

}
