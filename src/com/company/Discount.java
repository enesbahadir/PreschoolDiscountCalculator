package com.company;

import java.util.List;

/**
 * İndirimlere ait bilgilerin saklandığı sınıftır.
 */
public class Discount {

    private String name;
    private long value;
    private DiscountType discountType;
    private List<TypeOfUser> typeOfUser;
    private OrganizationNames organizationName;
    private List<PreschoolNames> preschoolNames;

    public Discount(String name, long value, DiscountType discountType, List<TypeOfUser> typeOfUser,
                    OrganizationNames organizationName, List<PreschoolNames> preschoolNames) {
        this.name = name;
        this.value = value;
        this.discountType = discountType;
        this.typeOfUser = typeOfUser;
        this.organizationName = organizationName;
        this.preschoolNames = preschoolNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public List<TypeOfUser> getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(List<TypeOfUser> typeOfUser) {
        this.typeOfUser = typeOfUser;
    }

    public OrganizationNames getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(OrganizationNames organizationName) {
        this.organizationName = organizationName;
    }


    public List<PreschoolNames> getPreschoolNames() {
        return preschoolNames;
    }

    public void setPreschoolNames(List<PreschoolNames> preschoolNames) {
        this.preschoolNames = preschoolNames;
    }

}
