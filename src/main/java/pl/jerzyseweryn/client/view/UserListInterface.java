package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.UserBean;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Widget;

public interface UserListInterface {
	Widget getViewWidget();
	CellTable<UserBean> getUserBeanCellTable();
}
