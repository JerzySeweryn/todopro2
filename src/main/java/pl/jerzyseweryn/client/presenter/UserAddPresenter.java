package pl.jerzyseweryn.client.presenter;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.service.AsyncUserBeanHelper;
import pl.jerzyseweryn.client.service.UserServiceAsync;
import pl.jerzyseweryn.client.shared.UserBean;
import pl.jerzyseweryn.client.view.UserAddInterface;
import pl.jerzyseweryn.client.view.UserAddView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.mvp4g.client.annotation.InjectService;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = UserAddView.class)
public class UserAddPresenter extends
		BasePresenter<UserAddInterface, TestEventBus> {

	private UserServiceAsync userService = null;
	
	@InjectService
    public void setUserService( UserServiceAsync userService ) {
            this.userService = userService;
    }

	LoadingHelper loadingHelper = new LoadingHelper();

	private String login;
	private String pasword;

	@Override
	public void bind() {
		view.getLoginButton().addClickHandler(new LoginClickHandler());
		view.getAddButton().addClickHandler(new AddClickHandler());
	}

	public void onAddUser() {
		eventBus.changeBody(view.getViewWidget());
		view.getUserLogin().setText("");
		view.getUserPassword().setText("");
	}

	class LoginClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			eventBus.start();
		}
	}

	class AddClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			login = view.getUserLogin().getText();
			pasword = view.getUserPassword().getText();

			if (login.trim().isEmpty() && pasword.trim().isEmpty()) {
				eventBus.displayMessage("Login or password cannot be empty.", true);
				return;
			}

			UserBean user = new UserBean();
			user.setFirstName(login);
			user.setLastName(pasword);
			
			loadingHelper.loadingStar();
			userService.create(user, new AsyncUserBeanHelper("OK", "Error", loadingHelper, eventBus, login){
				public void success(){
					eventBus.displayMessage("Account created. Hi, " + login, false);
					eventBus.userShow(login);
					eventBus.menuShow(login);
				}
			});
		}
	}
	
//	class UserBeanAsyncCallback implements AsyncCallback<UserBean> {
//		public void onFailure(Throwable caught) {
//			eventBus.displayMessage("Server connection  error.", true);
//			loadingHelper.loadingStop();
//		}
//		
//		public void onSuccess(UserBean userBean) {
//			if (UserBean.SUCCESS_CODE == userBean.getResponseCode()) {
//				eventBus.displayMessage("Account created. Hi, " + login, true);
//				eventBus.userShow(login);
//				eventBus.menuShow(login);
//			} else {
//				eventBus.displayMessage("Account not created.", true);
//			}
//			loadingHelper.loadingStop();
//		}
//	}
}
