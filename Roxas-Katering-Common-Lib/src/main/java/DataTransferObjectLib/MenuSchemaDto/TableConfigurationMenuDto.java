package DataTransferObjectLib.MenuSchemaDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TableConfigurationMenuDto implements Serializable{
	private static final long serialVersionUID = 1L;

    private String menuCode;
    private String menuButton;
    private String userId;
    private String status;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String projekCode;
    private TableButtonDto tableButtonDto;
    private TableMenuDto tableMenuDto;
    private TableUserDto tableUserDto;
    
    private String namaKaryawan;
    private String menuName;
    private String buttonName;
    private String mstCodeTypeName;
    private String createdByName;
    private String pegawaiId;
    
    private List<String> namaKaryawans;
    private List<String> namaMenus;
    private List<String> namaTombols;
    private List<String> statuss;
    private Date startDate;
    private Date endDate;
    
	public String getPegawaiId() {
		return pegawaiId;
	}
	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}
	public TableButtonDto getTableButtonDto() {
		return tableButtonDto;
	}
	public void setTableButtonDto(TableButtonDto tableButtonDto) {
		this.tableButtonDto = tableButtonDto;
	}
	public TableMenuDto getTableMenuDto() {
		return tableMenuDto;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getButtonName() {
		return buttonName;
	}
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	public String getMstCodeTypeName() {
		return mstCodeTypeName;
	}
	public void setMstCodeTypeName(String mstCodeTypeName) {
		this.mstCodeTypeName = mstCodeTypeName;
	}
	public String getCreatedByName() {
		return createdByName;
	}
	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}
	public void setTableMenuDto(TableMenuDto tableMenuDto) {
		this.tableMenuDto = tableMenuDto;
	}
	public TableUserDto getTableUserDto() {
		return tableUserDto;
	}
	public void setTableUserDto(TableUserDto tableUserDto) {
		this.tableUserDto = tableUserDto;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public String getProjekCode() {
		return projekCode;
	}
	public void setProjekCode(String projekCode) {
		this.projekCode = projekCode;
	}
	public String getMenuButton() {
		return menuButton;
	}
	public void setMenuButton(String menuButton) {
		this.menuButton = menuButton;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public List<String> getNamaKaryawans() {
		return namaKaryawans;
	}
	public void setNamaKaryawans(List<String> namaKaryawans) {
		this.namaKaryawans = namaKaryawans;
	}
	public List<String> getNamaMenus() {
		return namaMenus;
	}
	public void setNamaMenus(List<String> namaMenus) {
		this.namaMenus = namaMenus;
	}
	public List<String> getNamaTombols() {
		return namaTombols;
	}
	public void setNamaTombols(List<String> namaTombols) {
		this.namaTombols = namaTombols;
	}
	public List<String> getStatuss() {
		return statuss;
	}
	public void setStatuss(List<String> statuss) {
		this.statuss = statuss;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
