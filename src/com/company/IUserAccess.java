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
    TypeOfUser getTypeOfUser();

    /**
     *
     * @param typeOfUser
     */
    void setTypeOfUser(TypeOfUser typeOfUser);


    OrganizationNames getOrganizationName() ;

    void setOrganizationName(OrganizationNames organizationName) ;



}
