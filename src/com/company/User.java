package com.company;

/**
 * Kullanıcıya ait olan bilgilerin saklandığı class
 */
public class User implements IUserAccess{

    private String name;
    private UserType userType;
    private OrganizationNames organizationName;

    public User() {
    }

    /**
     * Constructor metodu
     * @param name kullanıcının ismi
     * @param userType kullanıcının tipi
     */
    public User(String name, UserType userType) {
        this.name = name;
        this.userType = userType;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public UserType getTypeOfUser() {
        return userType;
    }

    /**
     *
     * @param userType
     */
    public void setTypeOfUser(UserType userType) {
        this.userType = userType;
    }

    /**
     *
     * @return
     */


    public OrganizationNames getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(OrganizationNames organizationName) {
        this.organizationName = organizationName;
    }


}
