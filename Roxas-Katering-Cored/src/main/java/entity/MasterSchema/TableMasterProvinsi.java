package entity.MasterSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MasterSchema.entityMasterPk.TableMasterProvinsiPk;

@Entity
@Table(name = "MASTER.TABLE_MASTER_PROVINSI")
@IdClass(TableMasterProvinsiPk.class)
public class TableMasterProvinsi {
     
	private String kodeProvinsi;
	private String namaProvinsi;
	private String kodeIso;
	
	@Id
	@Column(name = "KODE_PROVINSI") 
	public String getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	
	@Column(name = "NAMA_PROVINSI")
	public String getNamaProvinsi() {
		return namaProvinsi;
	}
	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}
	
	@Column(name = "KODE_ISO")
	public String getKodeIso() {
		return kodeIso;
	}
	public void setKodeIso(String kodeIso) {
		this.kodeIso = kodeIso;
	}
	
	
     
     
}
