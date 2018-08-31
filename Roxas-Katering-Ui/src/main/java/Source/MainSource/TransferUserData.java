package Source.MainSource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.lang.Threads;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Window;

import RestResponse.FromJava.RestTemplateFromJava;
import Source.LocaleSource.LOCALE;
import vmd.WorkingThread;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TransferUserData extends Thread implements Serializable{
	private static final long serialVersionUID = 1L;
	public TableUserDto tableUserDto = new TableUserDto();
	protected List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
	public TableMenuDto tableMenuDto = new TableMenuDto();
	protected TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
	protected List<TableButtonDto> tableButtonDtos = new ArrayList<>();
	protected TableButtonDto tableButtonDto = new TableButtonDto();
	 private byte[] background= null;
   protected List<TableConfigurationMenuDto> tableConfigurationMenusForMaster = new ArrayList<>();
   protected List<TableConfigurationMenuDto> tableConfigurationMenusForRegristrasi = new ArrayList<>();
   protected List<TableConfigurationMenuDto> tableConfigurationMenusForAkunting = new ArrayList<>();
   protected List<TableConfigurationMenuDto> tableConfigurationMenusForOrder = new ArrayList<>();
   protected List<TableConfigurationMenuDto> tableConfigurationMenuForImageMap = new ArrayList<>();
   protected List<TableApprovalMessageDtlDto> tableApprovalMessageDtlDtos = new ArrayList<>();
   protected TableApprovalMessageDtlDto tableApprovalMessageDtlDto = new TableApprovalMessageDtlDto();
   protected Integer countMessage = new Integer(0);
   protected RestTemplateFromJava java = new RestTemplateFromJava();
   private String searchApproval = "" ;  
   private boolean onSend = false;
   private boolean onNotif = false;
   private boolean onTransaksi =false;
   
   public void groupTransferUserDate(boolean onSend, boolean onTransaksi, boolean onNotif) {
	   setOnNotif(onNotif);
	   setOnSend(onSend);
	   setOnTransaksi(onTransaksi);
	   BindUtils.postNotifyChange(null, null, this, "onSend");
	   BindUtils.postNotifyChange(null, null, this, "onNotif");
	   BindUtils.postNotifyChange(null, null, this, "onTransaksi");
   }
   
   
   
   @Command("sendGo")
   public void sendGo() {
	   groupTransferUserDate(true, false,false);
	   
	   //desktop.enableServerPush(true); 
   }
   
   @Command("notifGo")
   public void notifGo() {
	   groupTransferUserDate(false, false,true);
   }
   
   @Command("openChat")
   public void openChat() {
	   //Messagebox.show("Test");
	  // Clients.evalJavaScript("window.open('http://localhost:2080/Roxas-Chatting-Cored/ChatCoredUi/Ui/ChatUi.zul','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");
	  // Executions.getCurrent().sendRedirect("http://localhost:2080/Roxas-Chatting-Cored/ChatCoredUi/Ui/ChatUi.zul", "_blank");
	   //Executions.getCurrent().setAttribute("ObjectInformation", mapp);
	   
		Window window = (Window) Executions.createComponents(
				"/ChatCoredUi/Ui/ChatUi.zul", null,
				null);
		window.doModal();
	    Map<String, Object> args = new HashMap<>();
	//   ((Window) Executions.createComponents("http://localhost:2080/Roxas-Chatting-Cored/ChatCoredUi/Ui/ChatUi.zul", null, args)).doModal();
   }
   
	public void loadTrxApproval(TableUserDto tableUserDto) {
		Map<String, Object> mapRequest = CallRequestMappingJava("/message/collectUserApproval", null, "GET", "user="+tableUserDto.getPegawaiId() , 
				"projek="+tableUserDto.getProjekCode(), "search="+getSearchApproval());
		if (mapRequest.size() > 0) {
			tableApprovalMessageDtlDtos.clear();
			tableApprovalMessageDtlDtos = java.mapperJsonToListDto(mapRequest,
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
	
	
	    
	@Init
	@SuppressWarnings("unchecked")
	public void loadList(){
		
//		Desktop desktop = Executions.getCurrent().getDesktop(); 
//		desktop.enableServerPush(true);		
//		Messagebox.show("test" + desktop.getCurrentDirectory());
//		
		
		RestTemplateFromJava java = new RestTemplateFromJava();
		Map<String,Object> mapperJava = new HashMap<>();
		
//      From Database --start
//		Map<String, TableUserDto> mappot = new HashMap<>();
//		mappot = (Map<String, TableUserDto>) Executions.getCurrent().getArg();
//		tableUserDto = mappot.get("useDto");
//        tableUserDto = (TableUserDto) Sessions.getCurrent().getAttribute("userDto");
		
//      From Database --end
		Map<String, Object> mapp = (Map<String, Object>) Sessions.getCurrent().getAttribute("TransferUserInformation");
		try {
		tableUserDto.setUserId((String) mapp.get("userId"));
		tableUserDto.setProjekCode((String) mapp.get("projekCode"));
		tableUserDto.setStatus((int) mapp.get("status"));
		tableUserDto.setPegawaiId((String) mapp.get("pegawaiId"));
		tableUserDto.setPegawaiName((String) mapp.get("pegawaiName"));
		loadTrxApproval(tableUserDto);
		}catch(NullPointerException nep) {
			 Executions.sendRedirect("/");
		     return;
		}
		//Custom --start
//		tableUserDto.setUserId("aditF");
//		tableUserDto.setProjekCode("KATERING");
//		tableUserDto.setStatus(1);
//		tableUserDto.setPegawaiId("EMP0004");
//		tableUserDto.setPegawaiName("ADITYA FAUZI");
		
//		tableUserDto.setUserId("bimaSS");
//		tableUserDto.setProjekCode("KATERING");
//		tableUserDto.setStatus(1);
//		tableUserDto.setPegawaiId("EMP0001");
//		tableUserDto.setPegawaiName("BIMA SATRYA SEBAYANG");
		
		
//		tableUserDto.setUserId("nurHS");
//		tableUserDto.setProjekCode("KATERING");
//		tableUserDto.setStatus(1);
//		tableUserDto.setPegawaiId("EMP0002");
//		tableUserDto.setPegawaiName("NUR HARTATI SAFITRI");
		
//		tableUserDto.setUserId("nurHS");
//		tableUserDto.setProjekCode("KATERING");
//		tableUserDto.setStatus(1);
//		tableUserDto.setPegawaiId("EMP0003");
//		tableUserDto.setPegawaiName("NUR HARTATI SAFITRI");
		
		//Custom --end
		
		
		
		Map<String, Object> map= new HashMap<>();
		map.put("userDto", tableUserDto);
		mapperJava = java.mapRestTemplateValueWithPostMethod
				("/MenuUtama/AllExistingMenuUser",map);
		
		if(mapperJava.size()>0){
			tableConfigurationMenuDtos = java.mapperJsonToListDto(mapperJava,
					new TypeToken<ArrayList<TableConfigurationMenuDto>>() {
					}.getType(), tableConfigurationMenuDtos, "contents");
			}	
			else{
				Messagebox.show("Data Tidak Ada");
			}
		
		
		for (TableConfigurationMenuDto config: tableConfigurationMenuDtos) {
			String[] configSplitter = config.getTableMenuDto().getMenuUrl().split("/");
			if(configSplitter[1].equalsIgnoreCase(LOCALE.L001.getMessage())){
				tableConfigurationMenusForMaster.add(config);
			}
			else if(configSplitter[1].equalsIgnoreCase(LOCALE.L002.getMessage())){
				if(configSplitter[2].equalsIgnoreCase(LOCALE.L003.getMessage())){
					tableConfigurationMenusForOrder.add(config);
				}
				else if(configSplitter[2].equalsIgnoreCase(LOCALE.L004.getMessage())){
					tableConfigurationMenusForRegristrasi.add(config);
				}
				else if(configSplitter[2].equalsIgnoreCase(LOCALE.L005.getMessage())){
					tableConfigurationMenusForAkunting.add(config);
				}
				else if(configSplitter[2].equalsIgnoreCase(LOCALE.L006.getMessage())) {
					tableConfigurationMenuForImageMap.add(config);
				}
			}
		}
		
		getAllBackgound();
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableConfigurationMenusForMaster");
		getAllBackgound();
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableConfigurationMenusForOrder");
		getAllBackgound();
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableConfigurationMenusForRegristrasi");
		getAllBackgound();
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableConfigurationMenusForAkunting");
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableUserDto");
		}
		
	private String zIconSclass = "z-icon-lock";
	
	@Command("buttonMenu")
	public void allCommandButton(@BindingParam("menu") String menuCode) {
		 groupTransferUserDate(false, true,false);
		for (TableConfigurationMenuDto menu : tableConfigurationMenuDtos) {
			if(menu.getTableMenuDto().getMenuCode().equalsIgnoreCase(menuCode)){
				tableConfigurationMenuDto = menu;
				tableMenuDto.setMenuCode(tableConfigurationMenuDto.getMenuCode());
				tableMenuDto.setProjekCode(tableConfigurationMenuDto.getProjekCode());
				zIconSclass = "z-icon-unlock";
			}
		}	
	    setTableMenuDto(tableMenuDto);	
		//Messagebox.show(" menu " + menuCode);
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableConfigurationMenuDto");
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"tableMenuDto");
		BindUtils.postNotifyChange(null, null, TransferUserData.this,
				"zIconSclass");
	}

	public TableUserDto getTableUserDto() {
		loadList();
		return tableUserDto;
	}
	
	   protected void getAllBackgound(){
//	    	background = (new RestTemplateFromFilingSystem(
//					"/background", "headerImage.png", "jpg"))
//					.getTheBodyEntity().getBody();
//	    	
//	    	BindUtils.postNotifyChange(null, null, this,  "background");
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

	public List<TableConfigurationMenuDto> getTableConfigurationMenusForMaster() {
		return tableConfigurationMenusForMaster;
	}

	public void setTableConfigurationMenusForMaster(
			List<TableConfigurationMenuDto> tableConfigurationMenusForMaster) {
		this.tableConfigurationMenusForMaster = tableConfigurationMenusForMaster;
	}

	public List<TableConfigurationMenuDto> getTableConfigurationMenusForRegristrasi() {
		return tableConfigurationMenusForRegristrasi;
	}

	public void setTableConfigurationMenusForRegristrasi(
			List<TableConfigurationMenuDto> tableConfigurationMenusForRegristrasi) {
		this.tableConfigurationMenusForRegristrasi = tableConfigurationMenusForRegristrasi;
	}

	public List<TableConfigurationMenuDto> getTableConfigurationMenusForAkunting() {
		return tableConfigurationMenusForAkunting;
	}

	public void setTableConfigurationMenusForAkunting(
			List<TableConfigurationMenuDto> tableConfigurationMenusForAkunting) {
		this.tableConfigurationMenusForAkunting = tableConfigurationMenusForAkunting;
	}

	public List<TableConfigurationMenuDto> getTableConfigurationMenusForOrder() {
		return tableConfigurationMenusForOrder;
	}

	public void setTableConfigurationMenusForOrder(
			List<TableConfigurationMenuDto> tableConfigurationMenusForOrder) {
		this.tableConfigurationMenusForOrder = tableConfigurationMenusForOrder;
	}

	public TableMenuDto getTableMenuDto() {
		
		return tableMenuDto;
	}

	public void setTableMenuDto(TableMenuDto tableMenuDto) {
		this.tableMenuDto = tableMenuDto;
	}

	public List<TableConfigurationMenuDto> getTableConfigurationMenuForImageMap() {
		return tableConfigurationMenuForImageMap;
	}

	public void setTableConfigurationMenuForImageMap(List<TableConfigurationMenuDto> tableConfigurationMenuForImageMap) {
		this.tableConfigurationMenuForImageMap = tableConfigurationMenuForImageMap;
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

	public String getSearchApproval() {
		return searchApproval;
	}

	public void setSearchApproval(String searchApproval) {
		this.searchApproval = searchApproval;
	}

	public Integer getCountMessage() {
		return countMessage;
	}

	public void setCountMessage(Integer countMessage) {
		this.countMessage = countMessage;
	}
	
	public Map<String, Object> CallRequestMappingJava(String mainUrl, Object body, String Method, Object... Params)
	{
		Map<String, Object> resultMap = new HashMap<>();
		
		if(Method.equalsIgnoreCase("POST")){
			resultMap = java.mapRestTemplateValueWithPostMethod(mainUrl, body, Params);
		} 
		else if(Method.equalsIgnoreCase("GET")){
			resultMap = java.mapRestTemplateValueWithGetMethod(mainUrl, Params);
		}
		
		return resultMap;
	}

	public boolean isOnSend() {
		return onSend;
	}

	public void setOnSend(boolean onSend) {
		this.onSend = onSend;
	}

	public boolean isOnNotif() {
		return onNotif;
	}

	public void setOnNotif(boolean onNotif) {
		this.onNotif = onNotif;
	}

	public boolean isOnTransaksi() {
		return onTransaksi;
	}

	public void setOnTransaksi(boolean onTransaksi) {
		this.onTransaksi = onTransaksi;
	}
}
