package pl.jerzyseweryn.client.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.Key;

import javax.persistence.Id;

import pl.jerzyseweryn.client.helper.PersistGeneric;

public class UserBean extends PersistGeneric implements Serializable {
	
	public static final Integer SUCCESS_CODE = 1;
	public static final Integer ERROR_CODE = 2;
	
    private Long id = (long) 10;
    
    @Id
    private String firstName = null;
    private String lastName = null;

    Key<UserBean> other;

    public UserBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Key<UserBean> getOther() {
        return other;
    }

    public void setOther(Key<UserBean> other) {
        this.other = other;
    }
}
