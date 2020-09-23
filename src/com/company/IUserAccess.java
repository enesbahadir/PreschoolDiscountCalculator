package com.company;

/**
 * User sınıfına erişmek için kullanılan interface
 */
public interface IUserAccess {
    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @param name
     */
    void setName(String name);

    /**
     *
     * @return
     */
    UserType getTypeOfUser();

    /**
     *
     * @param userType
     */
    void setTypeOfUser(UserType userType);


    OrganizationNames getOrganizationName() ;

    void setOrganizationName(OrganizationNames organizationName) ;



}
