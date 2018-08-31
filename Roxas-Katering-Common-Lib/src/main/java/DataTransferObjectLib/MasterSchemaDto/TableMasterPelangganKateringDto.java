package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DataTransferObjectLib.CommonDto;

public class TableMasterPelangganKateringDto extends CommonDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String kodePelanggan;
	private String namaPelanggan;
	private String tipePelanggan;
	private String kodeKupon;
	private String keterangan;
	private BigDecimal komposisiPesanan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String alamatPelanggan;
	private String password;
	private String kodePosPelanggan;
	private Integer statusAktif;
	private String statusApproval;
	private String projekCode;
	private String kontakPelanggan;
	
	//semua elemen alamat --start
		private String informasiAlamat = new String();
		private String kota = new String();
		private String provinsi = new String();
		//semua elemen alamat --end
	
	private String statusPelanggan = new String();
	private String statusPersetujuan = new String();
	private BigDecimal banyakPesanan = new BigDecimal(0);
	private List<BigDecimal> banyakPesanans = new ArrayList<>();
	private List<String> kodePelanggans = new ArrayList<>();
	private List<String> namaPelanggans = new ArrayList<>();
	private List<String> tipePelanggans = new ArrayList<>();
	private List<String> statusPelanggans = new ArrayList<>();
	private List<String> statusPersetujans = new ArrayList<>();
	private List<BigDecimal> komposisiPesanans = new ArrayList<>();
	
	
	public String getKodePelanggan() {
		return kodePelanggan;
	}
	public void setKodePelanggan(String kodePelanggan) {
		this.kodePelanggan = kodePelanggan;
	}
	public String getNamaPelanggan() {
		return namaPelanggan;
	}
	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}
	public String getTipePelanggan() {
		return tipePelanggan;
	}
	public void setTipePelanggan(String tipePelanggan) {
		this.tipePelanggan = tipePelanggan;
	}
	public String getKodeKupon() {
		return kodeKupon;
	}
	public void setKodeKupon(String kodeKupon) {
		this.kodeKupon = kodeKupon;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public BigDecimal getKomposisiPesanan() {
		return komposisiPesanan;
	}
	public void setKomposisiPesanan(BigDecimal komposisiPesanan) {
		this.komposisiPesanan = komposisiPesanan;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getAlamatPelanggan() {
		return alamatPelanggan;
	}
	public void setAlamatPelanggan(String alamatPelanggan) {
		this.alamatPelanggan = alamatPelanggan;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKodePosPelanggan() {
		return kodePosPelanggan;
	}
	public void setKodePosPelanggan(String kodePosPelanggan) {
		this.kodePosPelanggan = kodePosPelanggan;
	}
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	public String getStatusApproval() {
		return statusApproval;
	}
	public void setStatusApproval(String statusApproval) {
		this.statusApproval = statusApproval;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public String getStatusPelanggan() {
		return statusPelanggan;
	}
	public void setStatusPelanggan(String statusPelanggan) {
		this.statusPelanggan = statusPelanggan;
	}
	public String getStatusPersetujuan() {
		return statusPersetujuan;
	}
	public void setStatusPersetujuan(String statusPersetujuan) {
		this.statusPersetujuan = statusPersetujuan;
	}
	public BigDecimal getBanyakPesanan() {
		return banyakPesanan;
	}
	public void setBanyakPesanan(BigDecimal banyakPesanan) {
		this.banyakPesanan = banyakPesanan;
	}

	public List<String> getKodePelanggans() {
		return kodePelanggans;
	}
	public void setKodePelanggans(List<String> kodePelanggans) {
		this.kodePelanggans = kodePelanggans;
	}
	public List<String> getNamaPelanggans() {
		return namaPelanggans;
	}
	public void setNamaPelanggans(List<String> namaPelanggans) {
		this.namaPelanggans = namaPelanggans;
	}
	public List<String> getTipePelanggans() {
		return tipePelanggans;
	}
	public void setTipePelanggans(List<String> tipePelanggans) {
		this.tipePelanggans = tipePelanggans;
	}
	public List<String> getStatusPelanggans() {
		return statusPelanggans;
	}
	public void setStatusPelanggans(List<String> statusPelanggans) {
		this.statusPelanggans = statusPelanggans;
	}
	
	public List<String> getStatusPersetujans() {
		return statusPersetujans;
	}
	public void setStatusPersetujans(List<String> statusPersetujans) {
		this.statusPersetujans = statusPersetujans;
	}
	public List<BigDecimal> getBanyakPesanans() {
		return banyakPesanans;
	}
	public void setBanyakPesanans(List<BigDecimal> banyakPesanans) {
		this.banyakPesanans = banyakPesanans;
	}
	public List<BigDecimal> getKomposisiPesanans() {
		return komposisiPesanans;
	}
	public void setKomposisiPesanans(List<BigDecimal> komposisiPesanans) {
		this.komposisiPesanans = komposisiPesanans;
	}
	public String getInformasiAlamat() {
		return informasiAlamat;
	}
	public void setInformasiAlamat(String informasiAlamat) {
		this.informasiAlamat = informasiAlamat;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	public String getKontakPelanggan() {
		return kontakPelanggan;
	}
	public void setKontakPelanggan(String kontakPelanggan) {
		this.kontakPelanggan = kontakPelanggan;
	}
    	
	@Override
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
}
