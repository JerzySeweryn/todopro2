package pl.jerzyseweryn.client.helper;

import java.io.Serializable;

import com.google.gwt.user.client.ui.RootPanel;

public class LoadingHelper implements Serializable{

	public void loadingStar(){
		RootPanel.get("loading").setStyleName("loading-yes");
	}
	
	public void loadingStop(){
		RootPanel.get("loading").setStyleName("loading-no");
	}
}
