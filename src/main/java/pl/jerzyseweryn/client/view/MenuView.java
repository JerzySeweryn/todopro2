package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.StyleConstants;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MenuView extends Composite implements MenuInterface {
	
	private Label userLoginLabel = null;
	private Button logoutButton = null;
	private Button userListButton = null;
	private Button taskListButton = null;
	
	public MenuView() {
		HorizontalPanel menuPanel = new HorizontalPanel();
		menuPanel.setStyleName(StyleConstants.MENU_PANEL);
		
		userLoginLabel = new Label("");
		userLoginLabel.setStyleName(StyleConstants.LABEL_VALUE);
		
		logoutButton = new Button("Logout");
		logoutButton.setStyleName(StyleConstants.BUTTON_BIG);

		userListButton = new Button("Users");
		userListButton.setStyleName(StyleConstants.BUTTON_BIG);
		
		taskListButton = new Button("Tasks");
		taskListButton.setStyleName(StyleConstants.BUTTON_BIG);

//		menuPanel.add(userLoginLabel);
		menuPanel.add(userListButton);
		menuPanel.add(taskListButton);
		menuPanel.add(logoutButton);
		
		initWidget(menuPanel);
	}
	
	public Widget getViewWidget() {
        return this;
    }
	
	public Label getUserLoginLabel() {
		return userLoginLabel;
	}

	public Button getLogoutButton() {
		return logoutButton;
	}

	public Button getUserListButton() {
		return userListButton;
	}

	public Button getTaskListButton() {
		return taskListButton;
	}
	
}
