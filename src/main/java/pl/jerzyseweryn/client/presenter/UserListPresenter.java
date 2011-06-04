package pl.jerzyseweryn.client.presenter;

import java.util.List;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.service.UserServiceAsync;
import pl.jerzyseweryn.client.shared.UserBean;
import pl.jerzyseweryn.client.view.UserListInterface;
import pl.jerzyseweryn.client.view.UserListView;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.InjectService;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = UserListView.class)
public class UserListPresenter extends
		BasePresenter<UserListInterface, TestEventBus> {

	private UserServiceAsync userService = null;
	
	@InjectService
    public void setUserService( UserServiceAsync userService ) {
            this.userService = userService;
    }

	LoadingHelper loadingHelper = new LoadingHelper();

	@Override
	public void bind() {		
	}

	public void onUserList(String token) {
		eventBus.changeBody(view.getViewWidget());
		eventBus.displayMessage("", true);
		UserBean userBean = new UserBean();
		userBean.setFirstName(token);
		
		loadingHelper.loadingStar();
		
		userService.getUserBeanArrayList(userBean, new AsyncCallback<List<UserBean>>() {
			
			public void onFailure(Throwable caught) {
				eventBus.displayMessage("Server connection  error.", true);
				loadingHelper.loadingStop();
			}

			public void onSuccess(List userBeans) {
				view.getUserBeanCellTable().setRowData(0, userBeans);
				loadingHelper.loadingStop();
			}
		});
	}
	
//	class UserBeanAsyncCallback implements AsyncCallback<List<UserBean>> {
//		public void onFailure(Throwable caught) {
//			eventBus.displayMessage("Server connection  error.", true);
//			loadingHelper.loadingStop();
//		}
//
//		public void onSuccess(List<UserBean> userBeans) {
//			view.getUserBeanCellTable().setRowData(0, userBeans);
//			loadingHelper.loadingStop();
//		}
//	}
}
