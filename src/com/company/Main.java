package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user= ObjFactory.getUserObj();

        Preschool preschool = ObjFactory.getPreschoolObj();
        Preschool ylb = ObjFactory.getPreschoolObj(PreschoolNames.YUNUS_EMRE_LALEBAHCESI,1000,"01/10/2020");
        Preschool mlb = ObjFactory.getPreschoolObj(PreschoolNames.MADENLER_LALEBAHCESI,1200,"01/09/2020");

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
                user.setWorkSaglikSen(true);
                wrongInput = false;
                break;
            }
            else if (userChoose.equalsIgnoreCase("h")) {
                user.setWorkSaglikSen(false);
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
                user.setWorkSaglikSen(true);
                wrongInput = false;
                break;
            }
            else if (userChoose.equalsIgnoreCase("h")) {
                user.setWorkSaglikSen(false);
                wrongInput = false;
                break;
            }
            else
                System.out.println("Hatalı giriş yaptınız. Lütfen Madenler Anadolu Lisesinde çalışma durumunu giriniz. E/H");
        }

        wrongInput = true;
        i=1;
        System.out.println("Lütfen kayıt olmak istediğiniz anaokulunun başında yazan numarayı giriniz");

        for (PreschoolNames preschoolNames : PreschoolNames.values()) {
            System.out.println(""+ i++ +"- " + preschoolNames);
        }

        while(wrongInput) {
            preschoolChoose = keyboard.nextLine();
            switch (preschoolChoose) {
                case "1" :
                    preschool = ylb;
                    wrongInput = false;
                    break;

                case "2" :
                    preschool = mlb;
                    wrongInput = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen kayıt olmak istediğiniz anaokulunun başında yazan numarayı giriniz ");
            }

        }

        DiscountService d = new DiscountService(user,preschool);
        long result = d.executeCalculateDiscountOfUser();
        System.out.println(result);
      //  System.out.println(user.getName() +" isimli kullanıcının "+ preschool.getPreschoolName()
      //         + " isimli anaokuluna kayıt için ödeyeceği ücret "+ d.calculateDiscountOfUser(user,preschool) +" TL" );

    }
}
