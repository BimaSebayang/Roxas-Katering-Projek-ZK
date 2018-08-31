package entity.PortalSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.PortalSchema.PortalSchemaPk.TablePortalProjekDetailPk;

@Entity
@Table(name="PORTAL.TABLE_PORTAL_PROJEK_DETAIL")
@IdClass(TablePortalProjekDetailPk.class)
public class TablePortalProjekDetail {
private String kodePortalDetail;
private String kodePortal;
private String userId;
private Integer status;

@Id
@Column(name = "KODE_PORTAL_DETAIL")
public String getKodePortalDetail() {
	return kodePortalDetail;
}
public void setKodePortalDetail(String kodePortalDetail) {
	this.kodePortalDetail = kodePortalDetail;
}

@Column(name = "KODE_PORTAL")
public String getKodePortal() {
	return kodePortal;
}
public void setKodePortal(String kodePortal) {
	this.kodePortal = kodePortal;
}

@Column(name = "USER_ID")
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

@Column(name = "STATUS")
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
}
