package entity.KateringSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.KateringSchema.entityKateringPk.TableTrxPajakDtlPk;

@Entity
@Table(name = "KATERING.TABLE_TRX_PAJAK_DTL")
@IdClass(TableTrxPajakDtlPk.class)
public class TableTrxPajakDtl {
	private String kodePajakDtl;
	private String kodePajak;
	private String operator1;
	private String subOperator1;
	private String operator2;
	private String subOperator2;
	private String operator3;
	private String subOperator3;
	private String operator4;
	private String subOperator4;
	private String operator5;
	private String subOperator5;
	private String projekCode;

	
	@Id
    @Column(name="KODE_PAJAK_DTL") 
	public String getKodePajakDtl() {
		return kodePajakDtl;
	}

	public void setKodePajakDtl(String kodePajakDtl) {
		this.kodePajakDtl = kodePajakDtl;
	}
    
	@Column(name="KODE_PAJAK") 
	public String getKodePajak() {
		return kodePajak;
	}

	public void setKodePajak(String kodePajak) {
		this.kodePajak = kodePajak;
	}

	@Column(name="OPERATOR1") 
	public String getOperator1() {
		return operator1;
	}

	public void setOperator1(String operator1) {
		this.operator1 = operator1;
	}

	@Column(name="SUB_OPERATOR1") 
	public String getSubOperator1() {
		return subOperator1;
	}

	public void setSubOperator1(String subOperator1) {
		this.subOperator1 = subOperator1;
	}

	@Column(name="OPERATOR2") 
	public String getOperator2() {
		return operator2;
	}

	public void setOperator2(String operator2) {
		this.operator2 = operator2;
	}

	@Column(name="SUB_OPERATOR2") 
	public String getSubOperator2() {
		return subOperator2;
	}

	public void setSubOperator2(String subOperator2) {
		this.subOperator2 = subOperator2;
	}

	@Column(name="OPERATOR3") 
	public String getOperator3() {
		return operator3;
	}

	public void setOperator3(String operator3) {
		this.operator3 = operator3;
	}

	@Column(name="SUB_OPERATOR3") 
	public String getSubOperator3() {
		return subOperator3;
	}

	public void setSubOperator3(String subOperator3) {
		this.subOperator3 = subOperator3;
	}

	@Column(name="OPERATOR4") 
	public String getOperator4() {
		return operator4;
	}

	public void setOperator4(String operator4) {
		this.operator4 = operator4;
	}

	@Column(name="SUB_OPERATOR4") 
	public String getSubOperator4() {
		return subOperator4;
	}

	public void setSubOperator4(String subOperator4) {
		this.subOperator4 = subOperator4;
	}

	@Column(name="OPERATOR5") 
	public String getOperator5() {
		return operator5;
	}

	public void setOperator5(String operator5) {
		this.operator5 = operator5;
	}

	@Column(name="SUB_OPERATOR5") 
	public String getSubOperator5() {
		return subOperator5;
	}

	public void setSubOperator5(String subOperator5) {
		this.subOperator5 = subOperator5;
	}

	@Column(name="PROJEK_CODE") 
	public String getProjekCode() {
		return projekCode;
	}

	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}

}
