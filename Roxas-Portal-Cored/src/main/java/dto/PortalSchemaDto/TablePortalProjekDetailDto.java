package dto.PortalSchemaDto;

import java.io.Serializable;

public class TablePortalProjekDetailDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String getKodePortalDetail() {
		return kodePortalDetail;
	}
	public void setKodePortalDetail(String kodePortalDetail) {
		this.kodePortalDetail = kodePortalDetail;
	}
	public String getKodePortal() {
		return kodePortal;
	}
	public void setKodePortal(String kodePortal) {
		this.kodePortal = kodePortal;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	private String kodePortalDetail;
	private String kodePortal;
	private String userId;
	private Integer status;
	private String namaPortal;
	private String urlGambar;
	private String urlPortal;
	public String getUrlPortal() {
		return urlPortal;
	}
	public void setUrlPortal(String urlPortal) {
		this.urlPortal = urlPortal;
	}
	public String getUrlGambar() {
		return urlGambar;
	}
	public void setUrlGambar(String urlGambar) {
		this.urlGambar = urlGambar;
	}
	public String getNamaPortal() {
		return namaPortal;
	}
	public void setNamaPortal(String namaPortal) {
		this.namaPortal = namaPortal;
	}
}
