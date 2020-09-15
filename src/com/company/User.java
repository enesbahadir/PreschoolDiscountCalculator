package com.company;

/**
 * Kullanıcıya ait olan bilgilerin saklandığı class
 */
public class User implements IUserAccess{

    private String name;
    private TypeOfUser typeOfUser;
    private OrganizationNames organizationName;
    private boolean isWorkSaglikSen;
    private boolean isWorkAnadoluLise;

    public User() {
    }

    /**
     * Constructor metodu
     * @param name kullanıcının ismi
     * @param typeOfUser kullanıcının tipi
     * @param isWorkSaglikSen kullanıcının Sağlık-Sen'e üyelik bilgisi
     * @param isWorkAnadoluLise kullanıcının Anadolu Lise'sinde çalışma bilgisi
     */
    public User(String name,TypeOfUser typeOfUser,boolean isWorkSaglikSen, boolean isWorkAnadoluLise) {
        this.name = name;
        this.typeOfUser = typeOfUser;
        this.isWorkSaglikSen = isWorkSaglikSen;
        this.isWorkAnadoluLise = isWorkAnadoluLise;
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
    public boolean isWorkSaglikSen() {
        return isWorkSaglikSen;
    }

    /**
     *
     * @param workSaglikSen
     */
    public void setWorkSaglikSen(boolean workSaglikSen) {
        isWorkSaglikSen = workSaglikSen;
    }

    /**
     *
     * @return
     */
    public boolean isWorkAnadoluLise() {
        return isWorkAnadoluLise;
    }

    /**
     *
     * @param workAnadoluLise
     */
    public void setWorkAnadoluLise(boolean workAnadoluLise) {
        isWorkAnadoluLise = workAnadoluLise;
    }

    public OrganizationNames getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(OrganizationNames organizationName) {
        this.organizationName = organizationName;
    }


}
