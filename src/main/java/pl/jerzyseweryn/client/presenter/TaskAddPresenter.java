package pl.jerzyseweryn.client.presenter;

import java.util.Date;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.service.AsyncTaskBeanHelper;
import pl.jerzyseweryn.client.service.TaskServiceAsync;
import pl.jerzyseweryn.client.shared.TaskBean;
import pl.jerzyseweryn.client.view.TaskAddInterface;
import pl.jerzyseweryn.client.view.TaskAddView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.InjectService;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = TaskAddView.class)
public class TaskAddPresenter extends
		BasePresenter<TaskAddInterface, TestEventBus> {

	private TaskServiceAsync taskService = null;
	
	@InjectService
    public void setUserService( TaskServiceAsync taskService ) {
            this.taskService = taskService;
    }
	
	LoadingHelper loadingHelper = new LoadingHelper();

	private String title;
	private String token;
	
	@Override
	public void bind() {
		
		view.getCancelButton().addClickHandler(new CancelClickHandler());
		view.getSaveButton().addClickHandler(new SaveClickHandler());
	}

	public void onAddTask(String token) {
		this.token = token;
		eventBus.changeBody(view.getViewWidget());
		view.getTitleBox().setText("");
	}
	
	class CancelClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			eventBus.taskList(token);
		}
		
	}
	
	class SaveClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			title = view.getTitleBox().getText();

			if (title.trim().isEmpty() || token.trim().isEmpty()) {
				eventBus.displayMessage("Title can't be empty.", true);
				return;
			} 
			TaskBean task = new TaskBean(title, new Date(), token);
			
			loadingHelper.loadingStar();
			taskService.create(task, new AsyncTaskBeanHelper("Added", "Not added", loadingHelper, eventBus, token){
				public void success(){
					eventBus.taskList(token);
				}
			});
		}
	}
}
