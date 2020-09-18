package com.company;

public class PrintHelper {
    public static void printDiscountTypes() {

    }

    public static void printUserType() {

    }

    public static void printOrganizationNames() {

    }

    public static void printPreschoolList() {
        int i = 0;
        while( i < Database.preschoolList.size() )
        {
            IPreschoolAccess p = Database.preschoolList.get(i);
            System.out.println((i+1) + " - " + p.getPreschoolName());
            i++;
        }
    }

    public static void printPreschoolInfo(IPreschoolAccess preschool) {
        System.out.println("Anaokulu Adı : " + preschool.getPreschoolName());
        System.out.println("Anaokulu Ücreti : " + preschool.getPrice());
        System.out.println("Anaokulun Erken Kayıt İndirim Bitiş Tarihi : " + preschool.getEndOfEarlyRegistrationDate());
    }

    public static void printDiscountList() {
        int i = 0;
        while( i < Database.discounts.size() )
        {
            Discount discount = Database.discounts.get(i);
            System.out.println((i+1) + " - " + discount.getDiscountName());
            i++;
        }

    }
}
