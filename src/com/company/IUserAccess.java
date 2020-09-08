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

    /**
     *
     * @return
     */
    boolean isWorkSaglikSen();

    /**
     *
     * @param workSaglikSen
     */
    void setWorkSaglikSen(boolean workSaglikSen);

    /**
     *
     * @return
     */
    boolean isWorkAnadoluLise();

    /**
     *
     * @param workAnadoluLise
     */
    void setWorkAnadoluLise(boolean workAnadoluLise);




}
