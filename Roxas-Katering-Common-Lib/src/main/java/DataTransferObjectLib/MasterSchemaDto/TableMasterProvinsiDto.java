package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;

public class TableMasterProvinsiDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String kodeProvinsi;
	private String namaProvinsi;
	private String kodeIso;
	
	public String getKodeProvinsi() {
		return kodeProvinsi;
	}
	public void setKodeProvinsi(String kodeProvinsi) {
		this.kodeProvinsi = kodeProvinsi;
	}
	public String getNamaProvinsi() {
		return namaProvinsi;
	}
	public void setNamaProvinsi(String namaProvinsi) {
		this.namaProvinsi = namaProvinsi;
	}
	public String getKodeIso() {
		return kodeIso;
	}
	public void setKodeIso(String kodeIso) {
		this.kodeIso = kodeIso;
	}
}
