package DataTransferObjectLib.MasterSchemaDto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DataTransferObjectLib.CommonDto;

public class TableMasterMenuMasakanDto extends CommonDto  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String kodeMakanan;
	private String namaMakanan;
	private String kodeResep;
	private String keterangan;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private Integer statusAktif;
	private String statusApproval;
	private BigDecimal harga;
	private String gambarMenu;
	private String projekCode;
	
	private String statusMakanan;
	private String statusPersetujuan;
	
	private List<String> kodeMakanans = new ArrayList<>();
	private List<String> namaMakanans = new ArrayList<>();
	private List<String> kodeReseps = new ArrayList<>();
	private List<String> statusMakanans = new ArrayList<>();
	private List<String> statusPersetujuans = new ArrayList<>();
	
	
	
	public List<String> getKodeMakanans() {
		return kodeMakanans;
	}
	public void setKodeMakanans(List<String> kodeMakanans) {
		this.kodeMakanans = kodeMakanans;
	}
	public List<String> getNamaMakanans() {
		return namaMakanans;
	}
	public void setNamaMakanans(List<String> namaMakanans) {
		this.namaMakanans = namaMakanans;
	}
	public List<String> getKodeReseps() {
		return kodeReseps;
	}
	public void setKodeReseps(List<String> kodeReseps) {
		this.kodeReseps = kodeReseps;
	}
	public List<String> getStatusMakanans() {
		return statusMakanans;
	}
	public void setStatusMakanans(List<String> statusMakanans) {
		this.statusMakanans = statusMakanans;
	}
	public List<String> getStatusPersetujuans() {
		return statusPersetujuans;
	}
	public void setStatusPersetujuans(List<String> statusPersetujuans) {
		this.statusPersetujuans = statusPersetujuans;
	}
	public String getKodeMakanan() {
		return kodeMakanan;
	}
	public void setKodeMakanan(String kodeMakanan) {
		this.kodeMakanan = kodeMakanan;
	}
	public String getNamaMakanan() {
		return namaMakanan;
	}
	public void setNamaMakanan(String namaMakanan) {
		this.namaMakanan = namaMakanan;
	}
	public String getKodeResep() {
		return kodeResep;
	}
	public void setKodeResep(String kodeResep) {
		this.kodeResep = kodeResep;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
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
	public String getStatusMakanan() {
		return statusMakanan;
	}
	public void setStatusMakanan(String statusMakanan) {
		this.statusMakanan = statusMakanan;
	}
	public String getStatusPersetujuan() {
		return statusPersetujuan;
	}
	public void setStatusPersetujuan(String statusPersetujuan) {
		this.statusPersetujuan = statusPersetujuan;
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
	public BigDecimal getHarga() {
		return harga;
	}
	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}
	public String getGambarMenu() {
		return gambarMenu;
	}
	public void setGambarMenu(String gambarMenu) {
		this.gambarMenu = gambarMenu;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	
	@Override
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
}
