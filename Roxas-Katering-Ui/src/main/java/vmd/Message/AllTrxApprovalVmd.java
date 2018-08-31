package vmd.Message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import Source.MainSource.TransferUserData;

@Init(superclass = true)
public class AllTrxApprovalVmd extends BaseVmdMenu implements Serializable  {
	private static final long serialVersionUID = 1L;
	private List<TableApprovalMessageDtlDto> tableApprovalMessageDtlDtos = new ArrayList<>();
	private TableApprovalMessageDtlDto tableApprovalMessageDtlDto = new TableApprovalMessageDtlDto();
	
	@Command("goToAprrove")
	public void goToApprove(@BindingParam("url") String url) {
		Map<String, Object> mapp = new HashMap<>();
		mapp.put("messageInformation", tableApprovalMessageDtlDto);
		callPopUpMenu(url, mapp);
	}
	
	@Command
	public void searchOrClick() {
		initIndex();
	}
	
	public void initIndex() {
		Map<String, Object> mapRequest = CallRequestMappingJava("/message/collectUserApproval", null, "GET", "user="+getCurrentEmployeId() , 
				"projek="+getCurrentProjek(), "search="+getSearch());
		if (mapRequest.size() > 0) {
			tableApprovalMessageDtlDtos.clear();
			tableApprovalMessageDtlDtos = getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableApprovalMessageDtlDto>>() {
					}.getType(), tableApprovalMessageDtlDtos, "contents");
			int counting = (int) mapRequest.get("counts");
			setCountMessage(new Integer( counting));
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableApprovalMessageDtlDtos");
		BindUtils.postNotifyChange(null, null, this, "countMessage");
	}
	
	@Override
	public void loadListAll(TableMenuDto menu) {
		initIndex();
		//Messagebox.show("Banyaknya adalah : " + tableApprovalMessageDtlDtos.size());
		super.loadListAll(menu);
	}

	
	
	public List<TableApprovalMessageDtlDto> getTableApprovalMessageDtlDtos() {
		return tableApprovalMessageDtlDtos;
	}

	public void setTableApprovalMessageDtlDtos(List<TableApprovalMessageDtlDto> tableApprovalMessageDtlDtos) {
		this.tableApprovalMessageDtlDtos = tableApprovalMessageDtlDtos;
	}

	public TableApprovalMessageDtlDto getTableApprovalMessageDtlDto() {
		return tableApprovalMessageDtlDto;
	}

	public void setTableApprovalMessageDtlDto(TableApprovalMessageDtlDto tableApprovalMessageDtlDto) {
		this.tableApprovalMessageDtlDto = tableApprovalMessageDtlDto;
	}
	
	
}
