package com.company;

/**
 * Kullanıcının erken kayıt indirimini tanımlayan sınıftır.
 */
public class EarlyRegistrationDiscount extends DiscountDecorator {

    /**
     * Constructor metodu, parametre olarak superclass'ının implement ettiği interface'si alır. Bu sayede diğer
     * indirim class'ları tarafından çağrılabilir.
     * @param wrappee Superclass'ın implement ettiği interface objesi
     */
    public EarlyRegistrationDiscount(IDiscountCalculator wrappee) {
        super(wrappee);
    }

    /**
     * İndirim hesaplama metodu. Bu metodu DiscountDecorator sınıfını extend eden tüm child class'lar tarafından
     * çağrılır.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return Kullanıcının erken kayıt indirimini ile superclass'ın indirimini hesaplayan metodunun toplamı
     */
    @Override
    public long calculateDiscount(IUserAccess user, IPreschoolAccess preschool) {
        return calculateEarlyDiscount(preschool) + super.calculateDiscount(user, preschool);
    }

    /**
     * Anaokulunu erken kayıt döneminde ise indirim kural sınıfda tanımlı indirimi döner.
     * @param preschool ilgili anaokulu
     * @return indirim miktarı
     */
    public long calculateEarlyDiscount (IPreschoolAccess preschool) {
        if (preschool.isInEarlyRegistration())
            return Discounts.EARLY_REGISTRATION_DISCOUNT.value;
        return 0;
    }
}
