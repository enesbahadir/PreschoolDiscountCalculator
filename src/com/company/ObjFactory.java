package com.company;

/**
 * User ve Preschool sınıflarının nesnelerini oluşturan sınıf
 */
public class ObjFactory {
    /**
     * Yeni bir User nesnesi oluşturur.
     * @return User nesnesi döner
     */
    public static User getUserObj () {

        return new User ();
    }

    /**
     * verilen parametrelere göre yeni bir User nesnesi oluşturur.
     * @param name User ismi
     * @param typeOfUser User'ın tipi
     * @param isWorkSaglikSen User Sağlık-Sen'de çalışma durumu
     * @param isWorkAnadoluLise User'ın Anadolu Lisesinde çalışma durumu
     * @return Verilen parametreleri sağlayan bir User nesnesi döner
     */
    public static User getUserObj (String name, TypeOfUser typeOfUser, boolean isWorkSaglikSen, boolean isWorkAnadoluLise)
    {
        return new User (name, typeOfUser, isWorkSaglikSen, isWorkAnadoluLise);
    }

    /**
     * Yeni bir preschool nesnesi oluşturur.
     * @return Preschool nesnesi döner.
     */
    public static Preschool getPreschoolObj () {
        return new Preschool();
    }

    /**
     * Verilen parametrelere göre yeni bir Preschool nesnesi oluşturur.
     * @param preschoolName Anaokulunun adı
     * @param price Anaokulunun ücreti
     * @param endOfEarlyRegistrationDate Anaokulunun erken kayıt dönemi son tarihi
     * @return Verilen parametreleri sağlan bir Preschool nesnesi döner.
     */
    public static Preschool getPreschoolObj (PreschoolNames preschoolName, int price, String endOfEarlyRegistrationDate)
    {
        return new Preschool (preschoolName, price, endOfEarlyRegistrationDate);
    }
}

