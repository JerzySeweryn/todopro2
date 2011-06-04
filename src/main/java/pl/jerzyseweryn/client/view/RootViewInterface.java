package pl.jerzyseweryn.client.view;

import com.google.gwt.user.client.ui.Widget;

public interface RootViewInterface {
	void setBody(Widget body);
	void setMenu(Widget menu);
	Widget getViewWidget();
}
