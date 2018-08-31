package vmd.MenuUtama;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import RestResponse.FromFilingSystem.RestTemplateFromFilingSystem;
import RestResponse.FromJava.RestTemplateFromJava;

import com.google.gson.reflect.TypeToken;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MenuUtamaVmd {
	
	protected TableUserDto tableUserDto;
	protected List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
	protected TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
	protected List<TableButtonDto> tableButtonDtos = new ArrayList<>();
	protected TableButtonDto tableButtonDto = new TableButtonDto();
	 private byte[] background= null;
		
	    protected void getAllBackgound(){
	    	background = (new RestTemplateFromFilingSystem(
					"/background", "headerImage.png", "jpg"))
					.getTheBodyEntity().getBody();
	    	
	    	BindUtils.postNotifyChange(null, null, this,  "background");
	    }
	
	    
	    
	@Init
	public void loadList(){
		Desktop desktop = Executions.getCurrent().getDesktop(); 
		desktop.enableServerPush(true);		
		Messagebox.show("test" + desktop.getCurrentDirectory());
		RestTemplateFromJava java = new RestTemplateFromJava();
		Map<String,Object> mapperJava = new HashMap<>();
		tableUserDto = (TableUserDto) Sessions.getCurrent().getAttribute("user");
		mapperJava = java.mapRestTemplateValueWithGetMethod("/MenuUtama/AllExistingMenuUser/"+tableUserDto.getUserId());
		if(mapperJava.size()>0){
			tableConfigurationMenuDtos = java.mapperJsonToListDto(mapperJava,
					new TypeToken<ArrayList<TableConfigurationMenuDto>>() {
					}.getType(), tableConfigurationMenuDtos, "contents");
			}	
			else{
				Messagebox.show("Data Tidak Ada");
			}
		getAllBackgound();
		BindUtils.postNotifyChange(null, null, this,
				"tableConfigurationMenuDtos");
		}
		
	private String zIconSclass = "z-icon-lock";
	
	@Command("buttonMenu")
	public void allCommandButton(@BindingParam("menu") String menuCode) {
     
		for (TableConfigurationMenuDto menu : tableConfigurationMenuDtos) {
			if(menu.getTableMenuDto().getMenuCode().equalsIgnoreCase(menuCode)){
				tableConfigurationMenuDto = menu;
				zIconSclass = "z-icon-unlock";
			}
		}	
		
		//Messagebox.show(" menu " + menuCode);
		BindUtils.postNotifyChange(null, null, this,
				"tableConfigurationMenuDto");
		BindUtils.postNotifyChange(null, null, this,
				"zIconSclass");
	}
	
	
	public TableUserDto getTableUserDto() {
		return tableUserDto;
	}

	public void setTableUserDto(TableUserDto tableUserDto) {
		this.tableUserDto = tableUserDto;
	}

	public List<TableConfigurationMenuDto> getTableConfigurationMenuDtos() {
		return tableConfigurationMenuDtos;
	}

	public void setTableConfigurationMenuDtos(
			List<TableConfigurationMenuDto> tableConfigurationMenuDtos) {
		this.tableConfigurationMenuDtos = tableConfigurationMenuDtos;
	}

	public TableConfigurationMenuDto getTableConfigurationMenuDto() {
		return tableConfigurationMenuDto;
	}

	public void setTableConfigurationMenuDto(
			TableConfigurationMenuDto tableConfigurationMenuDto) {
		this.tableConfigurationMenuDto = tableConfigurationMenuDto;
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


	public String getzIconSclass() {
		return zIconSclass;
	}


	public void setzIconSclass(String zIconSclass) {
		this.zIconSclass = zIconSclass;
	}

	public byte[] getBackground() {
		return background;
	}

	public void setBackground(byte[] background) {
		this.background = background;
	}

}
