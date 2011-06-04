package pl.jerzyseweryn.client.presenter;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.service.AsyncUserBeanHelper;
import pl.jerzyseweryn.client.service.UserServiceAsync;
import pl.jerzyseweryn.client.shared.UserBean;
import pl.jerzyseweryn.client.view.UserLoginInterface;
import pl.jerzyseweryn.client.view.UserLoginView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.InjectService;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = UserLoginView.class)
public class UserLoginPresenter extends BasePresenter<UserLoginInterface, TestEventBus> {
	
	private UserServiceAsync userService = null;
	
	@InjectService
    public void setUserService( UserServiceAsync userService ) {
            this.userService = userService;
    }
	
	private String login;
	private String pasword;
	
	LoadingHelper loadingHelper = new LoadingHelper();
	
	@Override
	public void bind() {
		view.getLoginButton().addClickHandler(new LoginClickHandler());
		view.getAddButton().addClickHandler(new AddClickHandler());
	}
	
	public void onStart() {
		view.getUserLogin().setText("");
		view.getUserPassword().setText("");
        eventBus.changeBody(view.getViewWidget());
    }
	
	class LoginClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			login = view.getUserLogin().getText();
			pasword = view.getUserPassword().getText();
			
			if (login.trim().isEmpty() || pasword.trim().isEmpty()) {
				eventBus.displayMessage("Login or password cannot be empty.", true);
				return;
			}
			
			UserBean user = new UserBean();
			user.setFirstName(login);
			user.setLastName(pasword);
			
			loadingHelper.loadingStar();
			userService.login(user, new AsyncUserBeanHelper("", "Login and password don't match.", loadingHelper, eventBus, login){
				public void success(){
					eventBus.displayMessage("Hi, " + login, true);
					eventBus.taskList(login);
					eventBus.menuShow(login);
				}
			});
		}
	}
	
	class AddClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			loadingHelper.loadingStar();
			eventBus.addUser();
			loadingHelper.loadingStop();
		}
	}
}
