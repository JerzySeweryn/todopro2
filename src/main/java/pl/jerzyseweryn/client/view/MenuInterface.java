package pl.jerzyseweryn.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public interface MenuInterface {
	Label getUserLoginLabel();
	Button getLogoutButton();
	Button getUserListButton();
	Button getTaskListButton();
	Widget getViewWidget();
}
