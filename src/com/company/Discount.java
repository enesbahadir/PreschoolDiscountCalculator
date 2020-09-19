package com.company;

import java.util.List;
import java.util.Map;

/**
 * İndirimlere ait bilgilerin saklandığı sınıftır.
 */
public class Discount {

    private String discountName;
    private DiscountType discountType;
    private List<UserType> userType;
    private OrganizationNames organizationName;
    private Map<String, Long > preschoolNamesAndTheirDiscounts;

    public Discount(String discountName, DiscountType discountType, List<UserType> userType,
                    OrganizationNames organizationName, Map<String, Long> preschoolNamesAndTheirDiscounts) {
        this.discountName = discountName;
        this.discountType = discountType;
        this.userType = userType;
        this.organizationName = organizationName;
        this.preschoolNamesAndTheirDiscounts = preschoolNamesAndTheirDiscounts;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public List<UserType> getTypeOfUser() {
        return userType;
    }

    public void setTypeOfUser(List<UserType> userType) {
        this.userType = userType;
    }

    public OrganizationNames getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(OrganizationNames organizationName) {
        this.organizationName = organizationName;
    }

    public Map<String, Long> getPreschoolNamesAndTheirDiscounts() {
        return preschoolNamesAndTheirDiscounts;
    }

    public void setPreschoolNamesAndTheirDiscounts(Map<String, Long> preschoolNamesAndTheirDiscounts) {
        this.preschoolNamesAndTheirDiscounts = preschoolNamesAndTheirDiscounts;
    }
}
