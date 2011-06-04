package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.UserBean;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public interface UserViewInterface {

	HasClickHandlers getButton();

	HasText getId();

	HasText getLastName();

	HasText getFirstName();

	Widget getViewWidget();

    HasText getCountList();

    public CellTable<UserBean> getUserBeanCellTable();

}
