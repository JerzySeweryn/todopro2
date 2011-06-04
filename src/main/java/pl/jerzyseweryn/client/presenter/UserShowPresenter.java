package pl.jerzyseweryn.client.presenter;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.view.UserShowInterface;
import pl.jerzyseweryn.client.view.UserShowView;

import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = UserShowView.class)
public class UserShowPresenter extends BasePresenter<UserShowInterface, TestEventBus> {
	
	@Override
	public void bind() {
	}
	
	public void onUserShow(String token) {
        eventBus.changeBody(view.getViewWidget());
    }
}
