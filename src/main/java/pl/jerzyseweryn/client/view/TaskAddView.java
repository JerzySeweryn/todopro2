package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.StyleConstants;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TaskAddView extends Composite implements TaskAddInterface {
	
	private TextBox titleBox = null;
	private Button saveButton = null;
	private Button cancelButton = null;
	
	public TaskAddView() {
		
		FlexTable loginPanel = new FlexTable();
		loginPanel.setStyleName(StyleConstants.USER_LOGIN_PANEL_TABLE);
		
		Label titleLabel = new Label("Title: ");
		titleLabel.setStyleName(StyleConstants.LABEL);
		loginPanel.setWidget(0, 0, titleLabel);
		titleBox = new TextBox();
		loginPanel.setWidget(0, 1, titleBox);
		
		saveButton = new Button("Save");
		saveButton.setStyleName(StyleConstants.BUTTON_BIG);
		loginPanel.setWidget(1, 0, saveButton);
		
		cancelButton = new Button("Cancel");
		cancelButton.setStyleName(StyleConstants.BUTTON_SMALL);
		loginPanel.setWidget(1, 1, cancelButton);
		
		initWidget(loginPanel);
	}
	
	public Widget getViewWidget() {
        return this;
    }

	@Override
	public TextBox getTitleBox() {
		return titleBox;
	}

	@Override
	public Button getSaveButton() {
		return saveButton;
	}

	@Override
	public Button getCancelButton() {
		return cancelButton;
	}
	
}
