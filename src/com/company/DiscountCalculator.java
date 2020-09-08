package com.company;

/**
 * İndirim hesaplaması yapar
 */
public class DiscountCalculator {

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
     * Verilen kişi ve kullanıcı bilgilerine göre yapılacak olan indirimin yüzde veya miktar bilgisini hesaplar
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     * @return yapıalcak olan indirimin yüzdesini veya miktarını calculateDecreasePercentOfANumber metoduna gönderir
     */
    public long calculateDiscountOfUser(User user, Preschool preschool) {
        long percent=0, amount = 0;

        if (preschool.isInEarlyRegistration())
            percent = Discounts.EARLY_REGISTRATION_DISCOUNT.value;

        switch (user.getTypeOfUser()) {
            case PERSONEL ->
                    percent += Discounts.PERSONNEL_DISCOUNT.value;
            case IHVAN ->
                    percent += Discounts.IHVAN_DISCOUNT.value;
        }

        if(user.isWorkAnadoluLise() && preschool.getPreschoolName().equals(PreschoolNames.MADENLER_LALEBAHCESI) )
            amount = Discounts.ANADOLU_DISCOUNT.value;

        if (user.isWorkSaglikSen() && preschool.getPreschoolName().equals(PreschoolNames.YUNUS_EMRE_LALEBAHCESI))
            percent += Discounts.SAGLIKSEN_DISCOUNT.value;

        return calculateDecreasePercentOfANumber(preschool.getPrice(),percent)-amount;
    }
}
