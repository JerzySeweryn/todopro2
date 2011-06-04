package pl.jerzyseweryn.client;

import pl.jerzyseweryn.client.presenter.MenuPresenter;
import pl.jerzyseweryn.client.presenter.RootPresenter;
import pl.jerzyseweryn.client.presenter.TaskAddPresenter;
import pl.jerzyseweryn.client.presenter.TaskListPresenter;
import pl.jerzyseweryn.client.presenter.UserAddPresenter;
import pl.jerzyseweryn.client.presenter.UserListPresenter;
import pl.jerzyseweryn.client.presenter.UserLoginPresenter;
import pl.jerzyseweryn.client.presenter.UserShowPresenter;
import pl.jerzyseweryn.client.view.RootView;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

@Events( startView = RootView.class )
public interface TestEventBus extends EventBus {

	@Event( handlers = RootPresenter.class )
	public void changeBody(Widget widget);
	
	@Event( handlers = RootPresenter.class )
	public void changeMenu(Widget widget);
	
	@Event( handlers = UserShowPresenter.class )
	public void userShow(String token);
	
	@Event( handlers = UserAddPresenter.class )
	public void addUser();
	
	@Event( handlers = TaskAddPresenter.class )
	public void addTask(String token);
	
	@Event( handlers = UserListPresenter.class )
	public void userList(String token);
	
	@Event( handlers = TaskListPresenter.class )
	public void taskList(String token);

	@Event( handlers = MenuPresenter.class )
	public void menuShow(String token);
	
	@Event( handlers = RootPresenter.class )
	public void displayMessage(String message, Boolean clear);

	@Start
	@Event( handlers = { RootPresenter.class, UserLoginPresenter.class } )
	public void start();
}
