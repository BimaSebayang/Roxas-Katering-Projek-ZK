package vmd.Message.Transaksi.Regristrasi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Window;
import org.zkoss.zul.Messagebox.Button;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterKotaDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProvinsiDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;

@Init(superclass = true)
public class PelangganManualMessageVmd extends BaseVmdMenu implements Serializable  {
	private static final long serialVersionUID = 1L;
	private List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtos = new ArrayList<>();
    private TableMasterPelangganKateringDto tableMasterPelangganKateringDto = new TableMasterPelangganKateringDto();
    
  //bagian combobox --start
    private List<TableMasterProvinsiDto> tableMasterProvinsiDtos = new ArrayList<>();
    private TableMasterProvinsiDto tableMasterProvinsiDto = new TableMasterProvinsiDto();
    private List<TableMasterKotaDto> tableMasterKotaDtos = new ArrayList<>();
    private TableMasterKotaDto tableMasterKotaDto = new TableMasterKotaDto();
    private TableApprovalMessageDtlDto tableApprovalMessageDtlDto = new TableApprovalMessageDtlDto();
    //bagian combobox --end
    
    private Map<String, Object> mappo = new HashMap<>();
    
    public void getObjectInformation() {
    	mappo = (Map<String, Object>) Executions.getCurrent().getAttribute("ObjectInformation");
    }
    
    @Command("approvedForm")
	public void approvedForm(@BindingParam("destroy")  Window lov){
    	detectQuestionMessageBox3(lov, "APPD", "Menyetujui");
	}
    
    @Command("revisedForm")
	public void revisedForm(@BindingParam("destroy")  Window lov){
    	detectQuestionMessageBox3(lov, "REVS", "Merevisi");
	}
    
    @Command("rejectedForm")
	public void rejectedForm(@BindingParam("destroy")  Window lov){
    	detectQuestionMessageBox3(lov, "REJE", "Menolak");
	}
    
    @Command("backForm")
	public void backForm(@BindingParam("destroy")  Window lov){
    	detectQuestionMessageBox2(lov);
	}
    
    @SuppressWarnings("unchecked")
	protected void detectQuestionMessageBox3(final Window lov, final String statusApproval, final String command) {
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(" Apakah Anda Ingin "+ command +" Transaksi Ini ? ", "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
							tableMasterPelangganKateringDto.setUpdatedBy(getCurrentEmployeId());
						    tableMasterPelangganKateringDto.setUpdatedDate(new Date());
						    tableMasterPelangganKateringDto.setStatusApproval(statusApproval);
						    Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/send",
						    tableMasterPelangganKateringDto, "POST","messageId="+tableMasterPelangganKateringDto.getMessageId());
							String result = (String) mapp.get("result");
							showInformationMessageBox(result);
							lov.detach();
						} else {
							return;
						}
					}
				}, params);
	}
    
    @SuppressWarnings("unchecked")
	protected void detectQuestionMessageBox2(final Window lov) {
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(" Apakah Anda Ingin Keluar Dari Form Ini? ", "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
							lov.detach();
						} else {
							return;
						}
					}
				}, params);
	}
    
	public void initIndex() {
		tableApprovalMessageDtlDto = (TableApprovalMessageDtlDto) mappo.get("messageInformation");
		
		Map<String, Object> map = new HashMap<>();
		map.put("trxId", tableApprovalMessageDtlDto.getTableApprovalMessageHdrDto().getTrxId());
		map.put("projekCode", getCurrentProjek());
		Map<String, Object> mapRequest = new HashMap<>();
		mapRequest = CallRequestMappingJava("/PelangganManual/collectInformation",
				map,"POST");
		
		tableMasterPelangganKateringDto =(TableMasterPelangganKateringDto) getJava().mapperJsonToDto(tableMasterPelangganKateringDto, mapRequest, "content");
		tableMasterPelangganKateringDto.setMessageId(tableApprovalMessageDtlDto.getMessageId());
		System.err.println("komposisi : " + tableMasterPelangganKateringDto.getKomposisiPesanan());
		if(tableMasterPelangganKateringDto.getTipePelanggan().equalsIgnoreCase("M")) {
			tableMasterPelangganKateringDto.setTipePelanggan("MANUAL");
		}
		String[] splitter = tableMasterPelangganKateringDto.getAlamatPelanggan().split("%");
		tableMasterPelangganKateringDto.setInformasiAlamat(splitter[0]);
		TableMasterKotaDto dto = new TableMasterKotaDto();
		dto.setNamaKota(splitter[2]);
		tableMasterKotaDto = dto;
		TableMasterProvinsiDto pto = new TableMasterProvinsiDto();
		pto.setNamaProvinsi(splitter[4]);
		tableMasterProvinsiDto = pto;
		BindUtils.postNotifyChange(null, null, this, "tableMasterKotaDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProvinsiDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterPelangganKateringDto");
		initBackground();
	}
	
	@Override
	public void loadListAll(TableMenuDto menu) {
		getObjectInformation();
		initIndex();
		//Messagebox.show("Banyaknya adalah : " + tableApprovalMessageDtlDtos.size());
		super.loadListAll(menu);
	}

	public List<TableMasterPelangganKateringDto> getTableMasterPelangganKateringDtos() {
		return tableMasterPelangganKateringDtos;
	}

	public void setTableMasterPelangganKateringDtos(
			List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtos) {
		this.tableMasterPelangganKateringDtos = tableMasterPelangganKateringDtos;
	}

	public TableMasterPelangganKateringDto getTableMasterPelangganKateringDto() {
		return tableMasterPelangganKateringDto;
	}

	public void setTableMasterPelangganKateringDto(TableMasterPelangganKateringDto tableMasterPelangganKateringDto) {
		this.tableMasterPelangganKateringDto = tableMasterPelangganKateringDto;
	}

	public List<TableMasterProvinsiDto> getTableMasterProvinsiDtos() {
		return tableMasterProvinsiDtos;
	}

	public void setTableMasterProvinsiDtos(List<TableMasterProvinsiDto> tableMasterProvinsiDtos) {
		this.tableMasterProvinsiDtos = tableMasterProvinsiDtos;
	}

	public TableMasterProvinsiDto getTableMasterProvinsiDto() {
		return tableMasterProvinsiDto;
	}

	public void setTableMasterProvinsiDto(TableMasterProvinsiDto tableMasterProvinsiDto) {
		this.tableMasterProvinsiDto = tableMasterProvinsiDto;
	}

	public List<TableMasterKotaDto> getTableMasterKotaDtos() {
		return tableMasterKotaDtos;
	}

	public void setTableMasterKotaDtos(List<TableMasterKotaDto> tableMasterKotaDtos) {
		this.tableMasterKotaDtos = tableMasterKotaDtos;
	}

	public TableMasterKotaDto getTableMasterKotaDto() {
		return tableMasterKotaDto;
	}

	public void setTableMasterKotaDto(TableMasterKotaDto tableMasterKotaDto) {
		this.tableMasterKotaDto = tableMasterKotaDto;
	}

	public TableApprovalMessageDtlDto getTableApprovalMessageDtlDto() {
		return tableApprovalMessageDtlDto;
	}

	public void setTableApprovalMessageDtlDto(TableApprovalMessageDtlDto tableApprovalMessageDtlDto) {
		this.tableApprovalMessageDtlDto = tableApprovalMessageDtlDto;
	}

	public Map<String, Object> getMappo() {
		return mappo;
	}

	public void setMappo(Map<String, Object> mappo) {
		this.mappo = mappo;
	}
}
