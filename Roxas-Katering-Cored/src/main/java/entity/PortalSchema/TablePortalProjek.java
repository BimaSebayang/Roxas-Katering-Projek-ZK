package entity.PortalSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.PortalSchema.PortalSchemaPk.TablePortalProjekPk;


@Entity
@Table(name="PORTAL.TABLE_PORTAL_PROJEK")
@IdClass(TablePortalProjekPk.class)
public class TablePortalProjek {

	private String kodePortal;
	private String namaPortal;
	private String urlPortal;
	private String keterangan;
	private String kodeProjek;
	private Integer status;
	
	@Id
    @Column(name = "KODE_PORTAL")
	public String getKodePortal() {
		return kodePortal;
	}
	public void setKodePortal(String kodePortal) {
		this.kodePortal = kodePortal;
	}
	
	 @Column(name = "NAMA_PORTAL")
	public String getNamaPortal() {
		return namaPortal;
	}
	public void setNamaPortal(String namaPortal) {
		this.namaPortal = namaPortal;
	}
	
	 @Column(name = "URL_PORTAL")
	public String getUrlPortal() {
		return urlPortal;
	}
	public void setUrlPortal(String urlPortal) {
		this.urlPortal = urlPortal;
	}
	
	 @Column(name = "KETERANGAN")
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	 @Column(name = "KODE_PROJEK")
	public String getKodeProjek() {
		return kodeProjek;
	}
	public void setKodeProjek(String kodeProjek) {
		this.kodeProjek = kodeProjek;
	}
	
	 @Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
