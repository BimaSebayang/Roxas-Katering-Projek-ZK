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
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BasePopUpVmdMenu;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

@Init(superclass=true)
public class CallAllMenusPuVmd extends BasePopUpVmdMenu{

	private static final long serialVersionUID = 1L;
    private List<TableMenuDto> tableMenuDtos = new ArrayList<>();
    private TableMenuDto tableMenuDto = new TableMenuDto();
    private Map<String, Object> mappo = new HashMap<>();
    
    public void getObjectInformation() {
    	mappo = (Map<String, Object>) Executions.getCurrent().getAttribute("ObjectInformation");
    }
    
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
 		Map<String,Object> mapper = mappo;
 		Map<String,Object> mapRequest = CallRequestMappingJavaForIndex("/popUp1/GetAllExistingMenu", mapper);
 		if(mapRequest.size()>0){
 			tableMenuDtos.clear();
 			tableMenuDtos = getJava().mapperJsonToListDto(mapRequest,
 					new TypeToken<ArrayList<TableMenuDto>>() {
 					}.getType(), tableMenuDtos, "contents");
 			}	
 			else{
 				Messagebox.show("Data Tidak Ada");
 			}
 		BindUtils.postNotifyChange(null, null, this, "tableMenuDtos"); 
 	}
  
  
  
	@Command("pilih")
	public void pilih(@BindingParam("destroy")  Window lov){
		Map<String, Object> args = new HashMap<>();
		args.put("tableMenuDto", tableMenuDto);
		BindUtils.postGlobalCommand(null, null, "CallAllMenusPuVmd", args);
		lov.detach();
	}
  
  
public List<TableMenuDto> getTableMenuDtos() {
	return tableMenuDtos;
}
public void setTableMenuDtos(List<TableMenuDto> tableMenuDtos) {
	this.tableMenuDtos = tableMenuDtos;
}
public TableMenuDto getTableMenuDto() {
	return tableMenuDto;
}
public void setTableMenuDto(TableMenuDto tableMenuDto) {
	this.tableMenuDto = tableMenuDto;
}
}
