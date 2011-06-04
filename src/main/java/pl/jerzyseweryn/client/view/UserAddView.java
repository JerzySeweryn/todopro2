package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.StyleConstants;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class UserAddView extends Composite implements UserAddInterface {
	
	private TextBox userLogin = null;
	private PasswordTextBox userPassword = null;
	private Button loginButton = null;
	private Button addButton = null;
	
	public UserAddView() {
		
		FlexTable loginPanel = new FlexTable();
		loginPanel.setStyleName(StyleConstants.USER_LOGIN_PANEL_TABLE);
		
		Label userLabel = new Label("E-mail");
		userLabel.setStyleName(StyleConstants.LABEL);
		
		userLogin = new TextBox();
		loginPanel.setWidget(0, 1, userLogin);
		
		Label passwordLabel = new Label("Password");
		passwordLabel.setStyleName(StyleConstants.LABEL);
		
		userPassword = new PasswordTextBox();
		loginPanel.setWidget(2, 1, userPassword);

		loginButton = new Button("Login");
		loginButton.setStyleName(StyleConstants.BUTTON_SMALL);
		
		addButton = new Button("Create account");
		addButton.setStyleName(StyleConstants.BUTTON_BIG);
		
		loginPanel.setWidget(1, 1, userLabel);
		loginPanel.setWidget(1, 2, userLogin);
		loginPanel.setWidget(2, 1, passwordLabel);
		loginPanel.setWidget(2, 2, userPassword);
		loginPanel.setWidget(3, 1, loginButton);
		loginPanel.setWidget(3, 2, addButton);
		
		initWidget(loginPanel);
	}
	public TextBox getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(TextBox userLogin) {
		this.userLogin = userLogin;
	}
	public PasswordTextBox getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(PasswordTextBox userPassword) {
		this.userPassword = userPassword;
	}
	public Button getAddButton() {
		return addButton;
	}
	public void setLoginButton(Button addButton) {
		this.addButton = addButton;
	}
	public Widget getViewWidget() {
        return this;
    }
	public Button getLoginButton() {
		return loginButton;
	}
}
