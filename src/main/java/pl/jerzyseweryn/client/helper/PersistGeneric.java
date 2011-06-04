package pl.jerzyseweryn.client.helper;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.googlecode.objectify.annotation.Indexed;

public class PersistGeneric implements IsSerializable {
	
	public static final Integer SUCCESS_CODE = 1;
	public static final Integer ERROR_CODE = 2;
	
	String reponseMessage;
	Integer responseCode;
	
	@Indexed
	private String addedby;
	
	private Date added;
	
	public PersistGeneric() {
	}
	
	public PersistGeneric(String addedby, Date added) {
		super();
		this.addedby = addedby;
		this.added = added;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getReponseMessage() {
		return reponseMessage;
	}
	public void setReponseMessage(String reponseMessage) {
		this.reponseMessage = reponseMessage;
	}
	public String getAddedby() {
		return addedby;
	}
	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}
	public Date getAdded() {
		return added;
	}
	public void setAdded(Date added) {
		this.added = added;
	}
	
}
