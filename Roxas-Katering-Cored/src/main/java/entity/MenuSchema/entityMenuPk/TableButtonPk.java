package entity.MenuSchema.entityMenuPk;

import java.io.Serializable;

import javax.persistence.Embeddable;


public class TableButtonPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String buttonCode;

	public String getButtonCode() {
		return buttonCode;
	}

	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
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
