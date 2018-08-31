package dto.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TableMasterSimulasiHargaMenuDtlDto  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String kodeSimulasi;
	private String kodeBahan;
	private BigDecimal hargaBahan;
	private Integer komposisiBahan;
	private String projekCode;
	private BigDecimal hasilSimulasi;
	private String kodeSimulasiTrx;
	public String getKodeSimulasi() {
		return kodeSimulasi;
	}
	public void setKodeSimulasi(String kodeSimulasi) {
		this.kodeSimulasi = kodeSimulasi;
	}
	public String getKodeBahan() {
		return kodeBahan;
	}
	public void setKodeBahan(String kodeBahan) {
		this.kodeBahan = kodeBahan;
	}
	public BigDecimal getHargaBahan() {
		return hargaBahan;
	}
	public void setHargaBahan(BigDecimal hargaBahan) {
		this.hargaBahan = hargaBahan;
	}
	public Integer getKomposisiBahan() {
		return komposisiBahan;
	}
	public void setKomposisiBahan(Integer komposisiBahan) {
		this.komposisiBahan = komposisiBahan;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public BigDecimal getHasilSimulasi() {
		return hasilSimulasi;
	}
	public void setHasilSimulasi(BigDecimal hasilSimulasi) {
		this.hasilSimulasi = hasilSimulasi;
	}
	public String getKodeSimulasiTrx() {
		return kodeSimulasiTrx;
	}
	public void setKodeSimulasiTrx(String kodeSimulasiTrx) {
		this.kodeSimulasiTrx = kodeSimulasiTrx;
	}

}
