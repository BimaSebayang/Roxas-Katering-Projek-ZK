package entity.MasterSchema;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MasterSchema.entityMasterPk.TableMasterSimulasiHargaMenuDtlPk;

@Entity
@Table(name = "MASTER.TABLE_MASTER_SIMULASI_HARGA_MENU_DTL")
@IdClass(TableMasterSimulasiHargaMenuDtlPk.class)
public class TableMasterSimulasiHargaMenuDtl {
	private String kodeSimulasi;
	private String kodeBahan;
	private BigDecimal hargaBahan;
	private Integer komposisiBahan;
	private String projekCode;
	private BigDecimal hasilSimulasi;
	private String kodeSimulasiTrx;
	
	@Column(name = "KODE_SIMULASI")
	public String getKodeSimulasi() {
		return kodeSimulasi;
	}
	public void setKodeSimulasi(String kodeSimulasi) {
		this.kodeSimulasi = kodeSimulasi;
	}
	
	@Column(name = "KODE_BAHAN")
	public String getKodeBahan() {
		return kodeBahan;
	}
	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
	}
	
	@Column(name = "HARGA_BAHAN")
	public BigDecimal getHargaBahan() {
		return hargaBahan;
	}
	public void setHargaBahan(BigDecimal hargaBahan) {
		this.hargaBahan = hargaBahan;
	}
	
	@Column(name = "KOMPOSISI_BAHAN")
	public Integer getKomposisiBahan() {
		return komposisiBahan;
	}
	public void setKomposisiBahan(Integer komposisiBahan) {
		this.komposisiBahan = komposisiBahan;
	}
	
	@Column(name = "PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	
	@Column(name = "HASIL_SIMULASI")
	public BigDecimal getHasilSimulasi() {
		return hasilSimulasi;
	}
	public void setHasilSimulasi(BigDecimal hasilSimulasi) {
		this.hasilSimulasi = hasilSimulasi;
	}
	
	@Id
	@Column(name = "KODE_SIMULASI_TRX")
	public String getKodeSimulasiTrx() {
		return kodeSimulasiTrx;
	}
	public void setKodeSimulasiTrx(String kodeSimulasiTrx) {
		this.kodeSimulasiTrx = kodeSimulasiTrx;
	}
	
	
}
