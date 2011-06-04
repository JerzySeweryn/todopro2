package pl.jerzyseweryn.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class UserShowView extends Composite implements UserShowInterface {
	
	public UserShowView() {
		FlexTable mainPanel = new FlexTable();
		Label introLabel = new Label("Możesz teraz zarządzać swoimi zadaniami.");
		mainPanel.setWidget(0, 0, introLabel);
		initWidget(mainPanel);
	}
	
	public Widget getViewWidget() {
        return this;
    }
}
