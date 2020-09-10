package com.company;

/**
 * İndirim hesaplamasının yapıldığı sınıf
 */
public class DiscountCalculator {


    /**
     * Verilen kişi ve kullanıcı bilgilerine göre yapılacak olan indirimin yüzde veya miktar bilgisini hesaplar.
     * İndirim kural sınıfında tanımlı her bir kural için ayrı bir metod çağırır.

     * @return yapıalcak olan indirimin yüzdesini veya miktarını calculateDecreasePercentOfANumber metoduna gönderir
     */
    public long calculateDiscountOfUser(IUserAccess user, IPreschoolAccess preschool) {

        long percentDiscount;
        long amountDiscount;

        percentDiscount = calculateEarlyDiscount(preschool);

        percentDiscount += calculateUserTypeDiscount(user);

        percentDiscount += calculateMemberOfSaglikSenDiscount(preschool, user);

        amountDiscount = calculateWorkAnadoluLiseDiscount(preschool, user);

        return calculateDecreasePercentOfANumber(preschool.getPrice(),percentDiscount) - amountDiscount;

    }

    /** Verilen ücret ve yüzde bilgilerine göre, ücretin yüzde oranında indirilmiş halini hesaplar
     * @param price ücret
     * @param percent indirim yüzdesi
     * @return ücretin yüzde olarak indirilmiş hali
     */
    public long calculateDecreasePercentOfANumber(long price, long percent) {

        if (percent == 0)
            return price;
        return price - (price * percent / 100);
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
