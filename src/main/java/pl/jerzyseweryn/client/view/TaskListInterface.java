package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.TaskBean;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public interface TaskListInterface {
	Widget getViewWidget();
	Button getAddButton();
	Button getDeleteButton();
	Button getOpenTaskButton();
	Button getCloseTaskButton();
	CellTable<TaskBean> getTaskBeanCellTable();
	ListDataProvider<TaskBean> getDataProvider();
}
