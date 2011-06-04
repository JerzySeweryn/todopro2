package pl.jerzyseweryn.client.view;


import pl.jerzyseweryn.client.shared.StyleConstants;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class RootView extends Composite implements RootViewInterface {

	private SimplePanel body = new SimplePanel();
	private SimplePanel menu = new SimplePanel();

	public RootView() {
		VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.setStyleName(StyleConstants.MAIN_PANEL_STYLE);
		
		menu.setStyleName(StyleConstants.MENU_STYLE);
		body.setStyleName(StyleConstants.BODY_STYLE);

		mainPanel.add(menu);
		mainPanel.add( body );
		initWidget( mainPanel );
	}

	public void setBody( Widget body ) {
		this.body.setWidget( body );
	}

	public Widget getViewWidget() {
		return this;
	}

	public void setMenu(Widget menu) {
		this.menu.setWidget( menu );
	}

}
