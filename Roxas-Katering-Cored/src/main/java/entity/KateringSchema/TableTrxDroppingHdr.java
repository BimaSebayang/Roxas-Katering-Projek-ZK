package entity.KateringSchema;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.KateringSchema.entityKateringPk.TableTrxDroppingHdrPk;

@Entity
@Table(name="KATERING.TABLE_TRX_DROPPING_HDR")
@IdClass(TableTrxDroppingHdrPk.class)
public class TableTrxDroppingHdr {
    private String kodeDropping;
    private String serialNumber;
    private String kodePesanan;
    private String droppingSts;
    private Date droppingDate;
    private Date droppedDate;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String projekCode;
    
    
    @Id
    @Column(name="KODE_DROPPING") 
	public String getKodeDropping() {
		return kodeDropping;
	}
	public void setKodeDropping(String kodeDropping) {
		this.kodeDropping = kodeDropping;
	}
	
	 @Column(name="SERIAL_NUMBER")
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	 @Column(name="KODE_PESANAN")
	public String getKodePesanan() {
		return kodePesanan;
	}
	public void setKodePesanan(String kodePesanan) {
		this.kodePesanan = kodePesanan;
	}
	
	 @Column(name="DROPPING_STS")
	public String getDroppingSts() {
		return droppingSts;
	}
	public void setDroppingSts(String droppingSts) {
		this.droppingSts = droppingSts;
	}
	
	 @Column(name="DROPPING_DATE")
	 @Temporal(TemporalType.DATE)
	public Date getDroppingDate() {
		return droppingDate;
	}
	public void setDroppingDate(Date droppingDate) {
		this.droppingDate = droppingDate;
	}
	
	 @Column(name="DROPPED_DATE")
	 @Temporal(TemporalType.DATE)
	public Date getDroppedDate() {
		return droppedDate;
	}
	public void setDroppedDate(Date droppedDate) {
		this.droppedDate = droppedDate;
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
	 @Temporal(TemporalType.TIMESTAMP)
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
	
	 @Column(name="PROJEK_CODE")
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
}
