package beanSession;

import java.util.Set;

public class User {

    private long   ID;
    private String email;
    private String pwd;

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Set<Long> listIdItems;

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public Set<Long> getListIdItems() {
        return listIdItems;
    }

    public void setListIdItems( long id ) {

        listIdItems.add( id );
    }

    public long getID() {
        return ID;
    }

    public void setID( long iD ) {
        ID = iD;
    }

    public void setPWD( String pwd ) {
        this.pwd = pwd;
    }

    public String getPWD() {
        return pwd;
    }

}
