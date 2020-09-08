package com.company;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Anaokulunun erken kayıt döneminde olup olmadığını kontrol eden sınıf
 */
public class EarlyRegistrationDateCalculator {
    /**
     * Erken kayıt döneminde olup olmadığını gelen tarih ile bugünü kıyas ederek döner
     * @param endOfEarlyRegistrationDate anaokulundan gelen erken kayıt bitiş tarihi
     * @return Erken kayıt dönemi içerisnde ise doğru, erken kayıt dönemi dışında ise yanlış döner
     */
    public static boolean isInEarlyRegistrationDate (String endOfEarlyRegistrationDate)  {
        Date earlyRegistrationDate = null;
        try {
            earlyRegistrationDate = new SimpleDateFormat("dd/MM/yyyy").parse(endOfEarlyRegistrationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date toDay = new Date();
        if(toDay.compareTo(earlyRegistrationDate) <= 0)
            return true;
        return false;
    }
}
