package pl.jerzyseweryn.client.view;

import pl.jerzyseweryn.client.shared.StyleConstants;
import pl.jerzyseweryn.client.shared.UserBean;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class UserListView extends Composite implements UserListInterface {
	
	private CellTable<UserBean> userBeanCellTable = null;
	
	public UserListView() {
		FlexTable mainPanel = new FlexTable();
		mainPanel.addStyleName(StyleConstants.MAIN_CONTENT_PANEL_STYLE);
		
		userBeanCellTable = new CellTable<UserBean>();
        
		TextColumn<UserBean> idColumn = new TextColumn<UserBean>() {
            @Override
            public String getValue(UserBean userBean) {
                return userBean.getId().toString();
            }
        };
        userBeanCellTable.addColumn(idColumn, "ID");
        
        TextColumn<UserBean> firstColumn = new TextColumn<UserBean>() {
        	@Override
        	public String getValue(UserBean userBean) {
        		return userBean.getFirstName();
        	}
        };
        userBeanCellTable.addColumn(firstColumn, "First name");
        
        TextColumn<UserBean> lastColumn = new TextColumn<UserBean>() {
        	@Override
        	public String getValue(UserBean userBean) {
        		return userBean.getLastName();
        	}
        };
        userBeanCellTable.addColumn(lastColumn, "Last name");
        
		mainPanel.setWidget(1, 0, userBeanCellTable);
        
        initWidget(mainPanel);
	}
	
	public Widget getViewWidget() {
        return this;
    }

	public CellTable<UserBean> getUserBeanCellTable() {
		return userBeanCellTable;
	}
	
	
}
