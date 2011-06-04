package pl.jerzyseweryn.client.shared;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import pl.jerzyseweryn.client.helper.PersistGeneric;

import com.google.gwt.user.client.rpc.IsSerializable;

public class TaskBean extends PersistGeneric implements Serializable {
	
	public static final String STATUS_OPEN = "open";
	public static final String STATUS_CLOSE = "close";
	
	public static final Integer SUCCESS_CODE = 1;
	public static final Integer ERROR_CODE = 2;

	@Id
    private Long id;

    private String title = null;

    private String status = STATUS_OPEN;

    public TaskBean() {
    }
    
	public TaskBean(Long id, String title, String status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}
	
	public TaskBean(String title, Date added, String addedby) {
		super(addedby, added);
		this.title = title;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
