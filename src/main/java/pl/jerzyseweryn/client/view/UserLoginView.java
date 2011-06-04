package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.StyleConstants;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class UserLoginView extends Composite implements UserLoginInterface {
	
	private TextBox userLogin = null;
	private PasswordTextBox userPassword = null;
	private Button loginButton = null;
	private Button addButton = null;
	
	public UserLoginView() {
		
//		VerticalPanel loginPanel = new VerticalPanel();
		FlexTable loginPanel = new FlexTable();
		
		loginPanel.setStyleName(StyleConstants.USER_LOGIN_PANEL_TABLE);
		
		Label userLabel = new Label("E-mail");
		userLabel.setStyleName(StyleConstants.LABEL);
		
		userLogin = new TextBox();
		
		Label passwordLabel = new Label("Password");
		passwordLabel.setStyleName(StyleConstants.LABEL);
		
		userPassword = new PasswordTextBox();
		
		loginButton = new Button("Login");
		loginButton.setStyleName(StyleConstants.BUTTON_BIG);
		
		addButton = new Button("Create account");
		addButton.setStyleName(StyleConstants.BUTTON_SMALL);
		
		loginPanel.setWidget(1, 1, userLabel);
		loginPanel.setWidget(1, 2, userLogin);
		loginPanel.setWidget(2, 1, passwordLabel);
		loginPanel.setWidget(2, 2, userPassword);
		loginPanel.setWidget(3, 1, loginButton);
		loginPanel.setWidget(3, 2, addButton);
		
//		loginPanel.add(userLabel);
//		loginPanel.add(userLogin);
//		loginPanel.add(passwordLabel);
//		loginPanel.add(userPassword);
//		
//		HorizontalPanel menuPanel = new HorizontalPanel();
//		menuPanel.add(loginButton);
//		menuPanel.add(addButton);
//		loginPanel.add(menuPanel);
		
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
	public Button getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(Button loginButton) {
		this.loginButton = loginButton;
	}
	public Widget getViewWidget() {
        return this;
    }
	public Button getAddButton() {
		return addButton;
	}
}
