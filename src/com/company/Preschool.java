package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Sistemde kayıtlı olan anaokulu bilgilerinin saklandığı sınıf
 */
public class Preschool implements IPreschoolAccess{
    private PreschoolNames preschoolName;
    private int price;
    private String 	endOfEarlyRegistrationDate;
    private boolean isInEarlyRegistration;
    private List <Discount> discountList;
    private OrganizationNames organizationName;

    public Preschool() {
    }

    /**
     *
     * @param preschoolName
     * @param price
     * @param endOfEarlyRegistrationDate
     */
    public Preschool(PreschoolNames preschoolName, int price,
                     String endOfEarlyRegistrationDate) {
        this.preschoolName = preschoolName;
        this.price = price;
        this.endOfEarlyRegistrationDate = endOfEarlyRegistrationDate;
        isInEarlyRegistration = EarlyRegistrationDateCalculator.isInEarlyRegistrationDate(endOfEarlyRegistrationDate);
        discountList = DiscountManager.setDefaultDiscountByPreschool(this);
    }

    /**
     *
     * @return
     */
    public PreschoolNames getPreschoolName() {
        return preschoolName;
    }

    /**
     *
     * @param preschoolName
     */
    public void setPreschoolName(PreschoolNames preschoolName) {
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
    public int getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
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

    public List<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<Discount> discountList) {
        this.discountList = discountList;
    }

    public OrganizationNames getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(OrganizationNames organizationName) {
        this.organizationName = organizationName;
    }

}
