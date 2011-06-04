package pl.jerzyseweryn.client.presenter;

import java.util.List;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.service.AsyncTaskBeanHelper;
import pl.jerzyseweryn.client.service.TaskServiceAsync;
import pl.jerzyseweryn.client.shared.TaskBean;
import pl.jerzyseweryn.client.view.TaskListInterface;
import pl.jerzyseweryn.client.view.TaskListView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.SingleSelectionModel;
import com.mvp4g.client.annotation.InjectService;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = TaskListView.class)
public class TaskListPresenter extends BasePresenter<TaskListInterface, TestEventBus> {

	private TaskServiceAsync taskService = null;
	
	@InjectService
    public void setUserService( TaskServiceAsync taskService ) {
            this.taskService = taskService;
    }

	LoadingHelper loadingHelper = new LoadingHelper();

	private String token;

	final SingleSelectionModel<TaskBean> selectionModel = new SingleSelectionModel<TaskBean>();
	private TaskBean selected;

	@Override
	public void bind() {
		view.getTaskBeanCellTable().setSelectionModel(selectionModel);
		view.getAddButton().addClickHandler(new AddClickHandler());
		view.getDeleteButton().addClickHandler(new DeleteClickHandler());
		view.getOpenTaskButton().addClickHandler(new OpenClickHandler());
		view.getCloseTaskButton().addClickHandler(new CloseClickHandler());
	}

	public void onTaskList(String token) {
		this.token = token;
		eventBus.changeBody(view.getViewWidget());
		eventBus.displayMessage("", true);

		TaskBean taskBean = new TaskBean();
		taskBean.setAddedby(token);
		loadingHelper.loadingStar();
		taskService.getTaskBeanArrayList(taskBean, new AsyncCallback<List<TaskBean>>() {
			
			public void onFailure(Throwable caught) {
				eventBus.displayMessage("Server connection  error. " + caught.getMessage() , true);
				loadingHelper.loadingStop();
			}

			public void onSuccess(List taskBeans) {
				view.getDataProvider().setList(taskBeans);
				loadingHelper.loadingStop();
			}
		});
		
	}

//	class TaskBeansAsyncCallback implements Result<List<TaskBean>> {
//		public void onFailure(Throwable caught) {
//			eventBus.displayMessage("Server connection  error.", true);
//			loadingHelper.loadingStop();
//		}
//
//		public void onSuccess(List<TaskBean> taskBeans) {
//			view.getDataProvider().setList(taskBeans);
//			loadingHelper.loadingStop();
//		}
//	}

	class AddClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			eventBus.addTask(token);
		}
	}

	class DeleteClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			selected = selectionModel.getSelectedObject();
			if (selected == null) {
				eventBus.displayMessage("Not selected", true);
				return;
			}
			loadingHelper.loadingStar();
			taskService.delete(selected, new AsyncTaskBeanHelper("Deleted", "Not deleted", loadingHelper, eventBus, token) {
				public void success() {
					eventBus.taskList(token);
					eventBus.displayMessage("", true);
				}
			});
			selected = null;
		}
	}

	class OpenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			selected = selectionModel.getSelectedObject();
			if (selected == null) {
				eventBus.displayMessage("Not selected", true);
				return;
			}
			loadingHelper.loadingStar();
			taskService.open(selected, new AsyncTaskBeanHelper("Opened", "Not opened", loadingHelper, eventBus, token) {
				public void success() {
					eventBus.taskList(token);
				}
			});
			selected = null;
		}
	}

	class CloseClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			selected = selectionModel.getSelectedObject();
			if (selected == null) {
				eventBus.displayMessage("Not selected", true);
				return;
			}
			taskService.close(selected, new AsyncTaskBeanHelper("Closed", "Not closed", loadingHelper, eventBus, token) {
				public void success() {
					eventBus.taskList(token);
				}
			});
			selected = null;
		}
	}
}
