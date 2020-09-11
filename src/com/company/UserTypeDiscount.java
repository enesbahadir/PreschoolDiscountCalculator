package com.company;

/**
 * Kullanıcının tipine özel yapılacak indirimi tanımlayan sınıftır.
 */
public class UserTypeDiscount extends DiscountDecorator{

    /**
     * Constructor metodu, parametre olarak superclass'ının implement ettiği interface'si alır. Bu sayede diğer
     * indirim class'ları tarafından çağrılabilir.
     * @param wrappee Superclass'ın implement ettiği interface objesi
     */
    public UserTypeDiscount(IDiscountCalculator wrappee) {
        super(wrappee);
    }

    /**
     * İndirim hesaplama metodu. Bu metodu DiscountDecorator sınıfını extend eden tüm child class'lar tarafından
     * çağrılır.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return Kullanıcının tipine özel indirim ile superclass'ın indirimini hesaplayan metodunun toplamı
     */
    @Override
    public long calculateDiscount(IUserAccess user, IPreschoolAccess preschool) {
        return calculateUserTypeDiscount(user) + super.calculateDiscount(user, preschool);
    }

    /**
     * Kullanıcı tipine özel yapılacak olan indirimi kural sınıfında tanımlı indirimi döner.
     * @param user ilgili kullanıcı
     * @return indirim miktarı
     */
    public long calculateUserTypeDiscount (IUserAccess user) {

        switch (user.getTypeOfUser()) {
            case PERSONEL -> {
                return Discounts.PERSONNEL_DISCOUNT.value;
            }
            case IHVAN -> {
                return Discounts.IHVAN_DISCOUNT.value;
            }
        }
        return 0;
    }
}
