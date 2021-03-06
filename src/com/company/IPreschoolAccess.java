package com.company;

/**
 * Preschool sınıfına erişmek için kullanılan interface
 */
public interface IPreschoolAccess {

     /**
      * Anaokulu adlarına erişim için kullanılan get metodu
      * @return Anaokulu Adı
      */
     String getPreschoolName();

     /**
      * Anaokulu adını değiştiemek için kullanılan set metodu
      * @param preschoolName Anaokulu Adı
      */
     void setPreschoolName(String preschoolName);

     /**
      * Anaokulunun erken kayıt dönemi içerisinde olup - olmadığını dönen isInEarlyRegistration'a erişim metodu
      * @return Anaokulu erken kayıt dönemi içerisinde ise true - doğru, aksi halde false - yanlış döner
      */
     boolean isInEarlyRegistration();

     /**
      * Anaokulunun erken kayıt dönemi içerisinde olma bilgisini değiştiren set metodu
      * @param inEarlyRegistration Anaokulu erken kayıt dönem bilgisi
      */
     void setInEarlyRegistration(boolean inEarlyRegistration);

     /**
      * Anaokulun ücret bilgisine erişmek için kullanılan get metodu
      * @return Anaokulunun ücret bilgisi
      */
     long getPrice();

     /**
      *Anaokulun ücret bilgisine erişmek için kullanılan get metodu
      * @param price Anaokulu ücret bilgisi
      */
     void setPrice(long price);

     /**
      * Anaokulu erken kayıt dönemi sonu bilgisine erişmek için kullanılan get metodu
      * @return Anaokulu erken kayıt dönemi sonu bilgisi
      */
     String getEndOfEarlyRegistrationDate();

     /**
      *Anaokulu erken kayıt dönemi sonu bilgisini değiştirmek için kullanılan set metodu
      * @param earlyRegistrationDate Anaokulu erken kayıt dönemi sonu bilgisi
      */
     void setEndOfEarlyRegistrationDate(String earlyRegistrationDate);

}
