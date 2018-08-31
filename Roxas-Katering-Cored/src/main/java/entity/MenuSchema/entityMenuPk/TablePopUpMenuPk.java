package entity.MenuSchema.entityMenuPk;

import java.io.Serializable;

public class TablePopUpMenuPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String popupMenuId;

	public String getPopupMenuId() {
		return popupMenuId;
	}

	public void setPopupMenuId(String popupMenuId) {
		this.popupMenuId = popupMenuId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
