package entity.MenuSchema.entityMenuPk;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;


public class TableConfigurationMenuPk implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	 private Date createdDate;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
