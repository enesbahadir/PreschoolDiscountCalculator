package com.company;

import java.util.*;

public class Main {
    static IUserAccess user= new User();
    static IPreschoolAccess preschool = new Preschool();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Database.setDefaultPreschoolList();
        Database.setDefaultDiscount();

        userInputForPreschoolChoose();
        flowOfProgram();
    }
    public static void userInputForPreschoolChoose ( ) {

        int  preschoolChoose;

        System.out.println("Lütfen işlem yapmak istediğiniz anaokulunun başında yazan numarayı giriniz");
        PrintHelper.printPreschoolList();

        while(true) {
            preschoolChoose = keyboard.nextInt();
            if(preschoolChoose <= Database.preschoolList.size() ) {
                preschool = Database.preschoolList.get(preschoolChoose - 1);
                break;
            }
            System.out.println("Hatalı giriş yaptınız. Lütfen kayıt olmak istediğiniz " +
                    "anaokulunun başında yazan numarayı giriniz ");
        }
    }

    public static void flowOfProgram( ) {

        int  preschoolChoose;
        while(true) {

            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
            System.out.println("1 - İndirim Hesaplama Sistemi" + System.lineSeparator() +
                    "2 - Anaokulu Yönetim Sistemi" + System.lineSeparator() +
                    "3 - İndirim Yönetim Sistemi" + System.lineSeparator() +
                    "4 - Anaokulu Değiştirme" + System.lineSeparator() +
                    "5 - Çıkış");

            preschoolChoose = keyboard.nextInt();
            switch (preschoolChoose) {
                case 1 -> {
                    userInputForDiscount();
                    calculateDiscount();
                }
                case 2 -> managePreschool();
                case 3 -> manageDiscount();
                case 4 -> userInputForPreschoolChoose();
                default -> System.exit(0);
            }
        }
    }

    public static void userInputForDiscount() {


        userInputForUserName();
        userInputForUserType();
        userInputForSaglikSenWork();
        userInputForAnadoluWork();

    }

    public static void userInputForUserName ( ) {

        System.out.println("Lütfen isminizi giriniz");
        String name = keyboard.next();
        System.out.println(name);
        user.setName(name);

    }

    public static void userInputForUserType( ) {
        Scanner keyboard1 = new Scanner(System.in);
        int i = 1;
        boolean wrongInput = true;
        String userChoose;
        System.out.println("Lütfen seçtiğiniz kullanıcı tipinin başında yazan numarayı giriniz");

        for(UserType userType : UserType.values())
            System.out.println(""+ i++ +"- " + userType);

        while (wrongInput) {
            userChoose = keyboard1.nextLine();
            switch (userChoose) {
                case "1" -> {
                    user.setTypeOfUser(UserType.PERSONEL);
                    wrongInput = false;
                }
                case "2" -> {
                    user.setTypeOfUser(UserType.IHVAN);
                    wrongInput = false;
                }
                case "3" -> {
                    user.setTypeOfUser(UserType.STANDART);
                    wrongInput = false;
                }
                default -> System.out.println("Hatalı giriş yaptınız. Lütfen seçtiğiniz kullanıcı tipinin başında yazan numarayı giriniz ");
            }
        }
    }

    public static void userInputForSaglikSenWork ( ) {

        System.out.println("Lütfen Sağlık-Sen'e üyelik durumunu giriniz. E/H");
        String  userChoose;
        userChoose = keyboard.next();
        if (userChoose.equalsIgnoreCase("e")) {
            user.setOrganizationName(OrganizationNames.SAGLIKSEN);
        }
    }

    public static void userInputForAnadoluWork( ) {

        System.out.println("Lütfen Madenler Anadolu Lisesinde çalışma durumunu giriniz. E/H");
        String userChoose;
        userChoose = keyboard.next();
        if (userChoose.equalsIgnoreCase("e")) {
            user.setOrganizationName(OrganizationNames.ANADOLU);

        }

    }

    public static void calculateDiscount() {
        //@TODO dependency
        DiscountCalculator discountCalculator = new DiscountCalculator(user,preschool);
        System.out.println(discountCalculator.calculateDiscount());
    }

    public static void managePreschool() {

        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        System.out.println( "1 - Anaokulu Ekleme" + System.lineSeparator() +
                            "2 - Anaokulu Çıkarma" + System.lineSeparator() +
                            "3 - Anaokulu Değiştirme" );
        int preschoolChoose = keyboard.nextInt();
        switch (preschoolChoose) {
            case 1 -> addNewPreschool();
            case 2 -> deletePreschool();
            case 3 -> setPreschool();
        }
    }

    public static void addNewPreschool() {
        System.out.println("Lütfen eklemek istediğiniz anaokulunun ismini giriniz: ");
        String name = keyboard.next();
        System.out.println("Lütfen eklemek istediğiniz anaokulunun ücretini giriniz: ");
        long price = keyboard.nextLong();
        System.out.println("Lütfen eklemek istediğiniz anaokulunun erken kayıt bitiş tarihini " +
                "GG/AA/YYYY olarak giriniz:");
        String endOfEarlyRegistrationDate = keyboard.next();
        PreschoolManager.addNewPreschool( new Preschool(name, price, endOfEarlyRegistrationDate));
        PrintHelper.printPreschoolList();
    }

    public static void deletePreschool () {
        PrintHelper.printPreschoolList();
        System.out.println("Lütfen çıkarmak istediğiniz anaokulunun ismini giriniz: ");
        int choose = keyboard.nextInt();
        IPreschoolAccess preschool = Database.preschoolList.get(choose-1);
        PreschoolManager.deletePreschoolFromList(preschool);
        PrintHelper.printPreschoolList();
    }

    public static void setPreschool() {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        System.out.println( "1 - Anaokulu isim değiştirme" + System.lineSeparator() +
                            "2 - Anaokulu ücret değiştirme" + System.lineSeparator() +
                            "3 - Anaokulu erken kayıt tarihi değiştirme" );
        int preschoolChoose = keyboard.nextInt();
        switch (preschoolChoose) {
            case 1 -> setPreschoolName();
            case 2 -> setPreschoolPrice();
            case 3 -> setPreschoolEarlyRegistrationDate();
        }
    }

    public static void setPreschoolName() {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        String newPreschoolName = keyboard.next();
        preschool.setPreschoolName(newPreschoolName);
        PrintHelper.printPreschoolInfo(preschool);
    }

    public static void setPreschoolPrice() {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        long newPrice = keyboard.nextLong();
        preschool.setPrice(newPrice);
        PrintHelper.printPreschoolInfo(preschool);
    }

    public static void setPreschoolEarlyRegistrationDate() {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        String newPreschoolEarlyRegistrationDate = keyboard.next();
        preschool.setEndOfEarlyRegistrationDate(newPreschoolEarlyRegistrationDate);
        PrintHelper.printPreschoolInfo(preschool);
    }

    public static void manageDiscount() {
        System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz:");
        System.out.println( "1 - İndirim Ekleme" + System.lineSeparator() +
                            "2 - İndirim Çıkarma" + System.lineSeparator() +
                            "3 - İndirim Değiştirme" );
        int preschoolChoose = keyboard.nextInt();
        switch (preschoolChoose) {
            case 1 -> addNewDiscount();
            case 2 -> deleteDiscount();
            case 3 -> setPreschool();
        }
    }

    public static void addNewDiscount() {
        System.out.println("Lütfen eklemek istediğiniz indirimin ismini giriniz: ");
        String name = keyboard.next();

        System.out.println("Lütfen eklemek istediğiniz indirimin türünü seçiniz: ");
        PrintHelper.printDiscountTypes();
        String userChoose = keyboard.next();
        DiscountType discountTypeChoose = DiscountType.valueOf(userChoose);

        System.out.println("Lütfen eklemek istediğiniz indirimin uygulanacağı kişi türünü seçiniz: ");
        PrintHelper.printUserType();
        List<UserType> userTypeChoose = new ArrayList<>();

        while(true)
        {
            System.out.println("Eklemeden çıkmak için lütfen 'h' tuşuna basınız  ");
            userChoose = keyboard.next();
            if(userChoose.equalsIgnoreCase("h"))
                break;
            userTypeChoose.add(UserType.valueOf(userChoose));
        }


        System.out.println("Lütfen eklemek istediğiniz indirimin uygulanacağı kurumu seçiniz: ");
        PrintHelper.printOrganizationNames();
        userChoose = keyboard.next();
        OrganizationNames organizationNamesChoose = OrganizationNames.valueOf(userChoose);

        System.out.println("Lütfen eklemek istediğiniz indirimin uygulanacağı anaokulunu ve indirim miktarını giriniz:");
        PrintHelper.printPreschoolList();
        Map<String, Long > preschoolNamesAndTheirDiscounts = new HashMap<>();
        while(true) {
            System.out.println("Eklemeden çıkmak için lütfen 'h' tuşuna basınız  ");
            userChoose = keyboard.next();
            if (userChoose.equalsIgnoreCase("h"))
                break;
            long discountChoose = keyboard.nextLong();
            preschoolNamesAndTheirDiscounts.putIfAbsent(userChoose, discountChoose);
        }

        DiscountManager.addNewDiscount(new Discount(name, discountTypeChoose, userTypeChoose, organizationNamesChoose
        , preschoolNamesAndTheirDiscounts));

        PrintHelper.printDiscountList();

    }

    public static void deleteDiscount() {
        PrintHelper.printDiscountList();
        System.out.println("Lütfen çıkarmak istediğiniz indirimin kodunu giriniz: ");
        int choose = keyboard.nextInt();
        Discount discount = Database.discounts.get(choose-1);
        DiscountManager.deleteDiscount(discount);
        PrintHelper.printDiscountList();
    }


}