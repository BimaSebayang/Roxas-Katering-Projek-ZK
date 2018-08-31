package vmd.MenuPopUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zul.Window;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BasePopUpVmdMenu;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

@Init(superclass=true)
public class CallUserIdPuVmd extends BasePopUpVmdMenu{
	private static final long serialVersionUID = 1L;
    private List<TableUserDto> tableUserDtos = new ArrayList<>();
    private TableUserDto tableUserDto = new TableUserDto();
    
    @Command
	public void searchOrClick() {
		//Messagebox.show(getSearch() + "hasil");
    	loadList();
	}
    
	@Override
	public void loadList() {
		super.loadList();
		loadItem();
	}
	
	
	public void loadItem() {
		Map<String,Object> mapp = new HashMap<>();
		Map<String,Object> mapRequest = CallRequestMappingJavaForIndex("/popUp1/GetAllExistingUser", mapp);
		if(mapRequest.size()>0){
			tableUserDtos.clear();
			tableUserDtos = getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableUserDto>>() {
					}.getType(), tableUserDtos, "contents");
			}	
			else{
				Messagebox.show("Data Tidak Ada");
			}
		BindUtils.postNotifyChange(null, null, this, "tableUserDtos"); 
	}
	
	
	
	@Command("pilih")
	public void pilih(@BindingParam("destroy")  Window lov){
		Map<String, Object> args = new HashMap<>();
		args.put("tableUserDto", tableUserDto);
		BindUtils.postGlobalCommand(null, null, "CallUserIdPuVmd", args);
		lov.detach();
	}


	public List<TableUserDto> getTableUserDtos() {
		return tableUserDtos;
	}


	public void setTableUserDtos(List<TableUserDto> tableUserDtos) {
		this.tableUserDtos = tableUserDtos;
	}


	public TableUserDto getTableUserDto() {
		return tableUserDto;
	}


	public void setTableUserDto(TableUserDto tableUserDto) {
		this.tableUserDto = tableUserDto;
	}
}
