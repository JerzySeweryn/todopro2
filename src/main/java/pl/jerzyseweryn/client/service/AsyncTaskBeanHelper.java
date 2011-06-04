package pl.jerzyseweryn.client.service;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.shared.TaskBean;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AsyncTaskBeanHelper implements AsyncCallback<TaskBean>, IsSerializable {
	String okMessage = "";
	String errorMessage = "";
	LoadingHelper loadingHelper;
//	TestEventBus eventBus;
//	String token;
	

	public AsyncTaskBeanHelper() {
	}

	public AsyncTaskBeanHelper(String okMessage, String errorMessage,
			LoadingHelper loadingHelper, TestEventBus eventBus, String token) {
		super();
		this.okMessage = okMessage;
		this.errorMessage = errorMessage;
		this.loadingHelper = loadingHelper;
//		this.eventBus = eventBus;
//		this.token = token;
	}

	public void onFailure(Throwable caught) {
//		eventBus.displayMessage("Server connection  error.", true);
		loadingHelper.loadingStop();
	}

	public void onSuccess(TaskBean resp) {
		if (TaskBean.SUCCESS_CODE == resp.getResponseCode()) {
//			eventBus.displayMessage(okMessage, true);
			success();
		} else {
//			eventBus.displayMessage(errorMessage, true);
		}
		loadingHelper.loadingStop();
	}
	public void success() {
	}
}