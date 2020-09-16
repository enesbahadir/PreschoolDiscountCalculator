package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user= new User();

        IPreschoolAccess preschool = new Preschool();
        PreschoolManager.setDefaultPreschoolList();


        Scanner keyboard = new Scanner(System.in);
        int i = 1;
        boolean wrongInput = true;
        String preschoolChoose, userChoose;

        System.out.println("Lütfen isminizi giriniz");
        user.setName(keyboard.nextLine());

        System.out.println("Lütfen seçtiğiniz kullanıcı tipinin başında yazan numarayı giriniz");

        for(TypeOfUser typeOfUser : TypeOfUser.values())
            System.out.println(""+ i++ +"- " + typeOfUser);

        while (wrongInput) {
            userChoose = keyboard.nextLine();
            switch (userChoose) {
                case "1" : {
                    user.setTypeOfUser(TypeOfUser.PERSONEL);
                    wrongInput = false;
                    break;
                }
                case "2" : {
                    user.setTypeOfUser(TypeOfUser.IHVAN);
                    wrongInput = false;
                    break;
                }
                case "3" : {
                    user.setTypeOfUser(TypeOfUser.STANDART);
                    wrongInput = false;
                    break;
                }
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen seçtiğiniz kullanıcı tipinin başında yazan numarayı giriniz ");
            }
        }

        System.out.println("Lütfen Sağlık-Sen'e üyelik durumunu giriniz. E/H");

        wrongInput = true;
        while (wrongInput) {
            userChoose = keyboard.nextLine();
            if (userChoose.equalsIgnoreCase("e")) {
                user.setOrganizationName(OrganizationNames.SAGLIKSEN);
                wrongInput = false;
                break;
            }
            else if (userChoose.equalsIgnoreCase("h")) {

                wrongInput = false;
                break;
            }
            else
                System.out.println("Hatalı giriş yaptınız. Lütfen Sağlık-Sen'e üyelik durumunu giriniz. E/H ");
        }

        System.out.println("Lütfen Madenler Anadolu Lisesinde çalışma durumunu giriniz. E/H");

        wrongInput = true;
        while (wrongInput) {
            userChoose = keyboard.nextLine();
            if (userChoose.equalsIgnoreCase("e")) {
                user.setOrganizationName(OrganizationNames.ANADOLU);
                wrongInput = false;
                break;
            }
            else if (userChoose.equalsIgnoreCase("h")) {

                wrongInput = false;
                break;
            }
            else
                System.out.println("Hatalı giriş yaptınız. Lütfen Madenler Anadolu Lisesinde çalışma durumunu giriniz. E/H");
        }

        wrongInput = true;
        i=1;
        System.out.println("Lütfen kayıt olmak istediğiniz anaokulunun başında yazan numarayı giriniz");

        for (PreschoolList preschoolNames : PreschoolList.values()) {
            System.out.println(""+ i++ +"- " + preschoolNames.name());
        }

        while(wrongInput) {
            preschoolChoose = keyboard.nextLine();
            switch (preschoolChoose) {
                case "1" :
                    preschool = PreschoolManager.preschoolList.get(0);
                    wrongInput = false;
                    break;

                case "2" :
                    preschool = PreschoolManager.preschoolList.get(1);
                    wrongInput = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen kayıt olmak istediğiniz anaokulunun başında yazan numarayı giriniz ");
            }

        }


        DiscountCalculator discountCalculator = new DiscountCalculator(user,preschool);
        System.out.println(discountCalculator.calculateDiscount());


    }
}