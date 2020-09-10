package com.company;

/**
 * Kullanıcının Anadolu Lisesinde çalışma indirimi tanımlayan sınıftır.
 */
public class AnadoluLiseDiscount extends DiscountDecorator {
    /**
     * Constructor metodu, parametre olarak superclass'ının implement ettiği interface'si alır. Bu sayede diğer
     * indirim class'ları tarafından çağrılabilir.
     * @param wrappee Superclass'ın implement ettiği interface objesi
     */
    public AnadoluLiseDiscount(IDiscountCalculator wrappee) {
        super(wrappee);
    }

    /**
     * İndirim hesaplama metodu. Bu metodu DiscountDecorator sınıfını extend eden tüm child class'lar tarafından
     * çağrılır.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return Anadolu lisesinde çalışma indirimi ile superclass'ın indirim hesaplayan metodunun toplamı
     */
    @Override
    public long calculateDiscount(IUserAccess user, IPreschoolAccess preschool) {
        return calculateWorkAnadoluLiseDiscount(preschool, user) + super.calculateDiscount(user, preschool);
    }

    /**
     * İlgili anaokulunun "Madenler Lalebahçesi", ilgili kullanınıcının Anadolu Lisesi'nde çalışma durumuna göre
     * indirim kural sınıfında tanımlı indirimi döner.
     * @param preschool ilgili anaokulu
     * @param user ilgili kullanıcı
     * @return indirim miktarı
     */
    public long calculateWorkAnadoluLiseDiscount (IPreschoolAccess preschool, IUserAccess user) {
        if(user.isWorkAnadoluLise() && preschool.getPreschoolName().equals(PreschoolNames.MADENLER_LALEBAHCESI) )
        {
            return Discounts.ANADOLU_DISCOUNT.value;
        }
        return 0;
    }
}
