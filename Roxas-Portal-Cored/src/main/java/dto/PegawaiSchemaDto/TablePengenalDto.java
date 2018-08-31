package dto.PegawaiSchemaDto;

import java.io.Serializable;

public class TablePengenalDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pegawaiId;
	private String namaKaryawan;
	private String statusKondisi;
    private String jid;
    private String roleId;
	private Integer status;
	
	public String getPegawaiId() {
		return pegawaiId;
	}
	public void setPegawaiId(String pegawaiId) {
		this.pegawaiId = pegawaiId;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getStatusKondisi() {
		return statusKondisi;
	}
	public void setStatusKondisi(String statusKondisi) {
		this.statusKondisi = statusKondisi;
	}
	public String getJid() {
		return jid;
	}
	public void setJid(String jid) {
		this.jid = jid;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
