package pl.jerzyseweryn.client.presenter;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.view.MenuInterface;
import pl.jerzyseweryn.client.view.MenuView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = MenuView.class)
public class MenuPresenter extends BasePresenter<MenuInterface, TestEventBus> {

	private String token;
	
	private String cacheToken;

	@Override
	public void bind() {
		view.getLogoutButton().addClickHandler(new LogoutClickHandler());
		view.getUserListButton().addClickHandler(new UserListClickHandler());
		view.getTaskListButton().addClickHandler(new TaskListClickHandler());
	}

	public void onMenuShow(String token) {
		this.token = token;
		view.getUserLoginLabel().setText(token);
		eventBus.changeMenu(view.getViewWidget());
		check_perms();
	}

	private void check_perms() {
		view.getUserListButton().setVisible("admin".equals(token));
		view.getUserListButton().setVisible("admin".equals(token));
	}

	class TaskListClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			eventBus.taskList(token);
		}
	}

	class UserListClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			eventBus.userList(token);
		}

	}

	class LogoutClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			eventBus.displayMessage("Success logout.", true);
			eventBus.start();
		}

	}

	public String getCacheToken() {
		return cacheToken;
	}

	public void setCacheToken(String cacheToken) {
		this.cacheToken = cacheToken;
	}

}
