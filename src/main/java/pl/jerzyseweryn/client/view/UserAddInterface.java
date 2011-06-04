package pl.jerzyseweryn.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public interface UserAddInterface {
	TextBox getUserLogin();
	PasswordTextBox getUserPassword();
	Button getAddButton();
	Button getLoginButton();
	Widget getViewWidget();
}
