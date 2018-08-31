package entity.KateringSchema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.KateringSchema.entityKateringPk.TableTrxDroppingDtlPk;


@Entity
@Table(name="KATERING.TABLE_TRX_DROPPING_DTL")
@IdClass(TableTrxDroppingDtlPk.class)
public class TableTrxDroppingDtl {
	 private String kodeDroppingDtl;
     private String kodeDropping;
     private String kodeMakanan;
     private Date droppedDateDetail;
     private Integer statusAktif;
     private String droppingNotes;
     private Date createdDate;
     private String createdBy;
     private Date updatedDate;
     private String updatedBy;
     private String kodePaketPengiriman;
     private String kodeKurirPengantar;
     private String projekCode;
     
   
	@Id
    @Column(name="KODE_DROPPING_DTL") 
	 public String getKodeDroppingDtl() {
		return kodeDroppingDtl;
	}
	public void setKodeDroppingDtl(String kodeDroppingDtl) {
		this.kodeDroppingDtl = kodeDroppingDtl;
	} 
    @Column(name="KODE_DROPPING") 
	public String getKodeDropping() {
		return kodeDropping;
	}
	public void setKodeDropping(String kodeDropping) {
		this.kodeDropping = kodeDropping;
	}
	
	@Column(name="KODE_MAKANAN") 
	public String getKodeMakanan() {
		return kodeMakanan;
	}
	public void setKodeMakanan(String kodeMakanan) {
		this.kodeMakanan = kodeMakanan;
	}
	
	@Column(name="DROPPED_DATE_DETAIL")
	@Temporal(TemporalType.DATE) 
	public Date getDroppedDateDetail() {
		return droppedDateDetail;
	}
	public void setDroppedDateDetail(Date droppedDateDetail) {
		this.droppedDateDetail = droppedDateDetail;
	}
	
	
	@Column(name="STATUS_AKTIF")
	public Integer getStatusAktif() {
		return statusAktif;
	}
	public void setStatusAktif(Integer statusAktif) {
		this.statusAktif = statusAktif;
	}
	
	@Column(name="DROPPING_NOTES")
	public String getDroppingNotes() {
		return droppingNotes;
	}
	public void setDroppingNotes(String droppingNotes) {
		this.droppingNotes = droppingNotes;
	}
	
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP) 
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	@Column(name="UPDATED_BY")
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="KODE_PAKET_PENGIRIM")
	public String getKodePaketPengiriman() {
		return kodePaketPengiriman;
	}
	public void setKodePaketPengiriman(String kodePaketPengiriman) {
		this.kodePaketPengiriman = kodePaketPengiriman;
	}
	
	@Column(name="KODE_KURIR_PENGANTAR")
	public String getKodeKurirPengantar() {
		return kodeKurirPengantar;
	}
	public void setKodeKurirPengantar(String kodeKurirPengantar) {
		this.kodeKurirPengantar = kodeKurirPengantar;
	}
	
	@Column(name="PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
     
     
     
     
}
