package entity.MenuSchema.entityMenuPk;

import java.io.Serializable;

import javax.persistence.Embeddable;


public class TableMenuPk implements Serializable{
	private static final long serialVersionUID = 1L;
	private String menuCode;
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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
