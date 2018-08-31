package DataTransferObjectLib.PortalSchemaDto;

import java.io.Serializable;

public class TablePortalProjekDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String kodePortal;
	private String namaPortal;
	private String urlPortal;
	private String keterangan;
	private String kodeProjek;
	private Integer status;
	
	public String getKodePortal() {
		return kodePortal;
	}
	public void setKodePortal(String kodePortal) {
		this.kodePortal = kodePortal;
	}
	public String getNamaPortal() {
		return namaPortal;
	}
	public void setNamaPortal(String namaPortal) {
		this.namaPortal = namaPortal;
	}
	public String getUrlPortal() {
		return urlPortal;
	}
	public void setUrlPortal(String urlPortal) {
		this.urlPortal = urlPortal;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getKodeProjek() {
		return kodeProjek;
	}
	public void setKodeProjek(String kodeProjek) {
		this.kodeProjek = kodeProjek;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
