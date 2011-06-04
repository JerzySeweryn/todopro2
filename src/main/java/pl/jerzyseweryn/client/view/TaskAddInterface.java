package pl.jerzyseweryn.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public interface TaskAddInterface {
	TextBox getTitleBox();
	Button getSaveButton();
	Button getCancelButton();
	Widget getViewWidget();
}
