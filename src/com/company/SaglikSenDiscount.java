package com.company;

/**
 * Kullanıcının Sağlık-Sen'e üye olma indirimini tanımlayan sınıftır.
 */
public class SaglikSenDiscount extends DiscountDecorator {

    /**
     * Constructor metodu, parametre olarak superclass'ının implement ettiği interface'si alır. Bu sayede diğer
     * indirim class'ları tarafından çağrılabilir.
     * @param wrappee Superclass'ın implement ettiği interface objesi
     */
    public SaglikSenDiscount(IDiscountCalculator wrappee) {
        super(wrappee);
    }

    /**
     * İndirim hesaplama metodu. Bu metodu DiscountDecorator sınıfını extend eden tüm child class'lar tarafından
     * çağrılır.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return Kullanıcının Sağlık-Sen'e üye olma indirimi ile superclass'ın indirimini hesaplayan metodunun toplamı
     */
    @Override
    public long calculateDiscount(IUserAccess user, IPreschoolAccess preschool) {
        return calculateMemberOfSaglikSenDiscount(preschool, user) + super.calculateDiscount(user, preschool);
    }

    /**
     * İlgili anaokulunun "Yunus Emre Lalebahçesi", ilgili kullanınıcının Sağlık-Sen'de çalışma durumuna göre indirim
     * indirim kural sınıfında tanımlı indirimi döner.
     * @param preschool ilgili anaokulu
     * @param user ilgili kullanıcı
     * @return indirim miktarı
     */
    public long calculateMemberOfSaglikSenDiscount (IPreschoolAccess preschool, IUserAccess user) {
        if (user.isWorkSaglikSen() && preschool.getPreschoolName().equals(PreschoolNames.YUNUS_EMRE_LALEBAHCESI))
        {
            return Discounts.SAGLIKSEN_DISCOUNT.value;
        }
        return 0;
    }
}
