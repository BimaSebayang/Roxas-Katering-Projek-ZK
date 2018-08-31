package entity.MasterSchema;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import entity.MasterSchema.entityMasterPk.TableMasterAllCodePk;

@Entity
@Table(name="MASTER.TABLE_MASTER_ALL_CODE")
@IdClass(TableMasterAllCodePk.class)
public class TableMasterAllCode {
        private String mstCode;
        private String mstColumnName;
        private String mstConditionName;
		private String notes;
        private String mstCodeType;
        private String mstCodeTypeName;
        private String typeData;
        
        @Id
       	@Column(name="MST_CODE")
		public String getMstCode() {
			return mstCode;
		}
		public void setMstCode(String mstCode) {
			this.mstCode = mstCode;
		}
		
		
		
		@Column(name="NOTES")
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		
		@Column(name="MST_CODE_TYPE")
		public String getMstCodeType() {
			return mstCodeType;
		}
		public void setMstCodeType(String mstCodeType) {
			this.mstCodeType = mstCodeType;
		}
		
		@Column(name="MST_CODE_TYPE_NAME")
		public String getMstCodeTypeName() {
			return mstCodeTypeName;
		}
		public void setMstCodeTypeName(String mstCodeTypeName) {
			this.mstCodeTypeName = mstCodeTypeName;
		}
		
		@Column(name="TYPE_DATA")
		public String getTypeData() {
			return typeData;
		}
		public void setTypeData(String typeData) {
			this.typeData = typeData;
		}
		
		@Column(name="MST_COLUMN_NAME")
		public String getMstColumnName() {
			return mstColumnName;
		}
		public void setMstColumnName(String mstColumnName) {
			this.mstColumnName = mstColumnName;
		}
		
		@Column(name="MST_CONDITION_NAME")
		public String getMstConditionName() {
			return mstConditionName;
		}
		public void setMstConditionName(String mstConditionName) {
			this.mstConditionName = mstConditionName;
		}
        
}
