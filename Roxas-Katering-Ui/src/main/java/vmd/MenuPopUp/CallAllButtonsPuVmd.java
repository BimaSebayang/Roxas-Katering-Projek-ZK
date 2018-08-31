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
import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;


@Init(superclass=true)
public class CallAllButtonsPuVmd extends BasePopUpVmdMenu {

	private static final long serialVersionUID = 1L;
	private List<TableButtonDto> tableButtonDtos = new ArrayList<>();
	private TableButtonDto tableButtonDto = new TableButtonDto();
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
			getObjectInformation();
			Map<String,Object> mapper = mappo;
			Map<String,Object> mapRequest = CallRequestMappingJavaForIndex("/popUp1/GetAllExistingButton", mapper);
			if(mapRequest.size()>0){
				tableButtonDtos.clear();
				tableButtonDtos = getJava().mapperJsonToListDto(mapRequest,
						new TypeToken<ArrayList<TableButtonDto>>() {
						}.getType(), tableButtonDtos, "contents");
				}	
				else{
					Messagebox.show("Data Tidak Ada");
				}
			BindUtils.postNotifyChange(null, null, this, "tableButtonDtos"); 
		}

		
		@Command("pilih")
		public void pilih(@BindingParam("destroy")  Window lov){
			Map<String, Object> args = new HashMap<>();
			args.put("tableButtonDto", tableButtonDto);
			BindUtils.postGlobalCommand(null, null, "CallAllButtonsPuVmd", args);
			lov.detach();
		}
	
	
	public List<TableButtonDto> getTableButtonDtos() {
		return tableButtonDtos;
	}
	public void setTableButtonDtos(List<TableButtonDto> tableButtonDtos) {
		this.tableButtonDtos = tableButtonDtos;
	}
	public TableButtonDto getTableButtonDto() {
		return tableButtonDto;
	}
	public void setTableButtonDto(TableButtonDto tableButtonDto) {
		this.tableButtonDto = tableButtonDto;
	}

}
