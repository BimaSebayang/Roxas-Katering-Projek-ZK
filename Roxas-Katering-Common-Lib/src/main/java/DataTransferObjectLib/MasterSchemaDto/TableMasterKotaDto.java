package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;

public class TableMasterKotaDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String kodeKota;
    private String namaKota;
    private String kodeProvinsi;
	public String getKodeKota() {
		return kodeKota;
	}
	public void setKodeKota(String kodeKota) {
		this.kodeKota = kodeKota;
	}
	public String getNamaKota() {
		return namaKota;
	}
	public void setNamaKota(String namaKota) {
		this.namaKota = namaKota;
	}
	public String getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
    
}
