package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.StyleConstants;
import pl.jerzyseweryn.client.shared.TaskBean;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class TaskListView extends Composite implements TaskListInterface {
	
	private CellTable<TaskBean> taskBeanCellTable = null;
	private Button addButton = null;
	private Button deleteButton = null;
	private Button openTaskButton = null;
	private Button closeTaskButton = null;
	final ListDataProvider<TaskBean> dataProvider = new ListDataProvider<TaskBean>();

	private DateTimeFormat fmt = DateTimeFormat.getFormat("dd-MM-yyyy HH:mm");
	
	public TaskListView() {
		VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.addStyleName(StyleConstants.MAIN_CONTENT_PANEL_STYLE);
		
		addButton = new Button("New");
		addButton.setStyleName(StyleConstants.BUTTON_SMALL);
		
		deleteButton = new Button("Delete");
		deleteButton.setStyleName(StyleConstants.BUTTON_SMALL);
		
		openTaskButton = new Button("Open");
		openTaskButton.setStyleName(StyleConstants.BUTTON_SMALL);

		closeTaskButton = new Button("Close");
		closeTaskButton.setStyleName(StyleConstants.BUTTON_SMALL);
		
		taskBeanCellTable = new CellTable<TaskBean>();
		taskBeanCellTable.setStyleName(StyleConstants.TABLE_STYLE);
        
		TextColumn<TaskBean> idColumn = new TextColumn<TaskBean>() {
            @Override
            public String getValue(TaskBean taskBean) {
                return taskBean.getId().toString();
            }
        };
        taskBeanCellTable.addColumn(idColumn, "ID");
        
        TextColumn<TaskBean> titleColumn = new TextColumn<TaskBean>() {
        	@Override
        	public String getValue(TaskBean taskBean) {
        		return taskBean.getTitle();
        	}
        };
        taskBeanCellTable.addColumn(titleColumn, "Title");
        
        TextColumn<TaskBean> addedColumn = new TextColumn<TaskBean>() {
        	@Override
        	public String getValue(TaskBean taskBean) {
        		return taskBean.getAdded() != null ? fmt.format(taskBean.getAdded()) : "";
        	}
        };
        taskBeanCellTable.addColumn(addedColumn, "Added");

        TextColumn<TaskBean> addedbyColumn = new TextColumn<TaskBean>() {
        	@Override
        	public String getValue(TaskBean taskBean) {
        		return taskBean.getAddedby();
        	}
        };
        taskBeanCellTable.addColumn(addedbyColumn, "Added by");

        TextColumn<TaskBean> statusColumn = new TextColumn<TaskBean>() {
        	@Override
        	public String getValue(TaskBean taskBean) {
        		return taskBean.getStatus();
        	}
        };
        taskBeanCellTable.addColumn(statusColumn, "Status");
        
        dataProvider.addDataDisplay(taskBeanCellTable);
        
        HorizontalPanel menuPanel = new HorizontalPanel();
        menuPanel.add(addButton);
        menuPanel.add(deleteButton);
        menuPanel.add(openTaskButton);
        menuPanel.add(closeTaskButton);
        
        mainPanel.add(menuPanel);
        mainPanel.add(taskBeanCellTable);
        
        initWidget(mainPanel);
	}
	
	public Widget getViewWidget() {
        return this;
    }

	public CellTable<TaskBean> getTaskBeanCellTable() {
		return taskBeanCellTable;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public ListDataProvider<TaskBean> getDataProvider() {
		return dataProvider;
	}

	public Button getOpenTaskButton() {
		return openTaskButton;
	}

	public Button getCloseTaskButton() {
		return closeTaskButton;
	}
	
	
}
