package ua.nure.kn.zapichnyi.usermanagement.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ua.nure.kn.zapichnyi.usermanagement.User;
import ua.nure.kn.zapichnyi.usermanagement.util.Messages;

public class UserTableModel extends AbstractTableModel {
  private static final String[] COLUMN_NAMES = {Messages.getString("UserTableModel.id"), Messages.getString("UserTableModel.first_name"), Messages.getString("UserTableModel.last_name")}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
private static final Class<?>[] COLUMN_CLASSES = {Long.class,String.class,String.class};
private List users= null;
  
  public UserTableModel(Collection users) {
	  this.users= new ArrayList(users);
  }
	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return COLUMN_NAMES.length;
	}
    
	@Override
	public String getColumnName(int column) {
	
		return COLUMN_NAMES[column];
	
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return COLUMN_CLASSES[columnIndex];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User  user = (User) users.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return user.getId();
		case 1:
			return user.getFirstName();
		case 2:
			return user.getLastName();
		}
		return null;
	}

}