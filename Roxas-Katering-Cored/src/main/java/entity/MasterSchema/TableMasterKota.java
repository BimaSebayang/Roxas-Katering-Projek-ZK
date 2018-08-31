package entity.MasterSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MasterSchema.entityMasterPk.TableMasterKotaPk;
import entity.MasterSchema.entityMasterPk.TableMasterProvinsiPk;


@Entity
@Table(name = "MASTER.TABLE_MASTER_KOTA")
@IdClass(TableMasterKotaPk.class)
public class TableMasterKota {
	private String kodeKota;
    private String namaKota;
    private String kodeProvinsi;
    
    
	@Id
	@Column(name = "KODE_KOTA") 
	public String getKodeKota() {
		return kodeKota;
	}
	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}
	
	@Column(name = "NAMA_KOTA") 
	public String getNamaKota() {
		return namaKota;
	}
	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}
	
	@Column(name = "KODE_PROVINSI") 
	public String getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
}
