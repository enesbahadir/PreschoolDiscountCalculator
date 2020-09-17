package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Sistemde kayıtlı olan anaokulu bilgilerinin saklandığı sınıf
 */
public class Preschool implements IPreschoolAccess{

    private String preschoolName;
    private long price;
    private String 	endOfEarlyRegistrationDate;
    private boolean isInEarlyRegistration;

    public Preschool() { }

    /**
     *
     * @param preschoolName
     * @param price
     * @param endOfEarlyRegistrationDate
     */
    public Preschool(String preschoolName, long price,
                     String endOfEarlyRegistrationDate) {
        this.preschoolName = preschoolName;
        this.price = price;
        this.endOfEarlyRegistrationDate = endOfEarlyRegistrationDate;
        isInEarlyRegistration = EarlyRegistrationDateCalculator.isInEarlyRegistrationDate(endOfEarlyRegistrationDate);
    }

    /**
     *
     * @return
     */
    public String getPreschoolName() {
        return preschoolName;
    }

    /**
     *
     * @param preschoolName
     */
    public void setPreschoolName(String preschoolName) {
        this.preschoolName = preschoolName;
    }

    /**
     *
     * @return
     */
    public boolean isInEarlyRegistration() {
        return isInEarlyRegistration;
    }

    /**
     *
     * @param inEarlyRegistration
     */
    public void setInEarlyRegistration(boolean inEarlyRegistration) {
        isInEarlyRegistration = inEarlyRegistration;
    }

    /**
     *
     * @return
     */
    public long getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(long price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getEndOfEarlyRegistrationDate() {
        return endOfEarlyRegistrationDate;
    }

    /**
     *
     * @param earlyRegistrationDate
     */
    public void setEndOfEarlyRegistrationDate(String earlyRegistrationDate) {
        this.endOfEarlyRegistrationDate = earlyRegistrationDate;
    }


}
