package com.company;

/**
 * DiscountService sınıfı DiscountCalculator sınıfına erişmek için kullanılan sınıfıtr.
 * Dependency Injection pattern'ı kullanılaark DiscounCalculator objesi oluşturur.
 * DiscountCalculator sınıfındaki metodlar bu sınıf üzerinden çağrılır.
 */
public class DiscountService {

    DiscountCalculator discountCalculator;
    private IUserAccess user;
    private IPreschoolAccess preschool;

    /**
     * Dependency Injection pattern'ı kullanılaark DiscounCalculator objesi oluşturur.
     * @param user ilgili kullanıcı
     * @param preschool ilgili anaokulu
     */
    public DiscountService(IUserAccess user, IPreschoolAccess preschool) {
        this.user = user;
        this.preschool = preschool;
        discountCalculator = new DiscountCalculator();
    }

    /**
     * DiscountCalculator sınıfındaki calculateDiscountOfUser metodunu çalıştırır.
     * @return indirim miktarını döner
     */
    public long executeCalculateDiscountOfUser () {
        return discountCalculator.calculateDiscountOfUser(user, preschool);
    }

}
