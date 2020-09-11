package com.company;

/**
 *  Kullanıcının indirimini hesaplayan sınıfların objesini oluşturan factory sınıfıdır.
 */
public class DiscountFactory {
    static DiscountDecorator discountDecorator;

    /**
     *
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return DiscountDecorator objesi döner.
     */
    public static DiscountDecorator createDiscountDecorator (IUserAccess user, IPreschoolAccess preschool) {
        return new UserTypeDiscount( new EarlyRegistrationDiscount( new AnadoluLiseDiscount( new SaglikSenDiscount(
                new DiscountCalculator(user, preschool)))));
    }
}
