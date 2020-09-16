package com.company;

/**
 * Kullanıcıya ait olan bilgilerin saklandığı class
 */
public class User implements IUserAccess{

    private String name;
    private TypeOfUser typeOfUser;
    private OrganizationNames organizationName;

    public User() {
    }

    /**
     * Constructor metodu
     * @param name kullanıcının ismi
     * @param typeOfUser kullanıcının tipi
     */
    public User(String name,TypeOfUser typeOfUser) {
        this.name = name;
        this.typeOfUser = typeOfUser;
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
    public TypeOfUser getTypeOfUser() {
        return typeOfUser;
    }

    /**
     *
     * @param typeOfUser
     */
    public void setTypeOfUser(TypeOfUser typeOfUser) {
        this.typeOfUser = typeOfUser;
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
