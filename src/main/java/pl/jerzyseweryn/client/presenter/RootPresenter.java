package pl.jerzyseweryn.client.presenter;

import pl.jerzyseweryn.client.TestEventBus;
import pl.jerzyseweryn.client.helper.LoadingHelper;
import pl.jerzyseweryn.client.view.RootView;
import pl.jerzyseweryn.client.view.RootViewInterface;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter( view = RootView.class )
public class RootPresenter extends BasePresenter<RootViewInterface, TestEventBus> {
	
	private LoadingHelper loadingHelper = new LoadingHelper();
	private VerticalPanel vp = new VerticalPanel();
	
	public void onChangeBody( Widget newPage ) {
		view.setBody( newPage );
	}
	
	public void onChangeMenu( Widget newMenu ) {
		view.setMenu( newMenu );
	}
	
	public void onDisplayMessage( String message, Boolean clear ) {
		if (clear) {
			vp.clear();
		}
		vp.add(new Label(message));
		RootPanel.get("messages").add(vp);
	}
	
	/**
	 * Metoda do czyszczenia danych przy starcie aplikacji
	 */
	public void onStart() {
		view.setMenu( new Label() ); //Aby wyczyścić menu po wyglogowaniu
		loadingHelper.loadingStop(); //Aby schować pasek ładowania
	}
}
