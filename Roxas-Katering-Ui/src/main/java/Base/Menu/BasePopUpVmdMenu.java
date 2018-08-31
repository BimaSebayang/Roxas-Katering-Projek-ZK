package Base.Menu;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.Window;

import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import Master.StaticVariable.AllStaticVariable;
import RestResponse.FromJava.RestTemplateFromJava;
import RestResponse.FromTibco.RestTemplateFromTibco;
import Source.MainSource.TransferUserData;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class BasePopUpVmdMenu  extends TransferUserData implements Serializable {

	private static final long serialVersionUID = 1L;
    protected Map<String, Object> mapp = new HashMap<>();
    private final AllStaticVariable VARIABLE = new AllStaticVariable();
	private RestTemplateFromJava java = new RestTemplateFromJava();
	private RestTemplateFromTibco tibco = new RestTemplateFromTibco();
    private String search = "";
	@Init
	public void loadList() {
	 mapp = (Map<String, Object>) Executions.getCurrent().getAttribute("ObjectInformation");
	 BindUtils.postNotifyChange(null, null, this, "mapp");
	}
	
	@Command("kembali")
	public void kembali(@BindingParam("destroy")  Window lov){
		lov.detach();
	}
	
	/**
	 * Request Mapping Dari Java Untuk Index
	 */
	public Map<String, Object> CallRequestMappingJavaForIndex
	    (String mainUrl, Object body){
		Object[] Params = {"user="+getCurrentEmployeId(),"projek="+getCurrentProjek(),"search="+getSearch()};
		BindUtils.postNotifyChange(null, null, this, "urlFromChildren");
		BindUtils.postNotifyChange(null, null, this, "mapFromChildren");
		return  CallRequestMappingJava(mainUrl, body, "POST", Params);
	}
	
	
	
	/**
	 * Request Mapping Dari Java
	 */
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
	
	public Map<String, Object> CallRequestMappingTibco(String mainUrl, Object body, String Method, Object... Params)
	{
	Map<String, Object> resultMap = new HashMap<>();
		
		if(Method.equalsIgnoreCase("POST")){
			resultMap = tibco.mapRestTemplateValueWithPostMethod(mainUrl, body, Params);
		} 
		else if(Method.equalsIgnoreCase("GET")){
			resultMap = tibco.mapRestTemplateValueWithGetMethod(mainUrl, Params);
		}
		return resultMap;
	}
	
	
	
	public String getCurrentProjek(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto().getProjekCode();
	}
	
	public String getCurrentEmployeId(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto().getPegawaiId();
	}
	
	public String getCurrentUserId(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto().getUserId();
	}
	
	private TableUserDto getCurrentUserDto(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto();
	}
	
	public TableMenuDto getCurrentMenuDto(){
		//TransferUserData userData = new TransferUserData();
		return tableMenuDto;
	}
	
	public Map<String, Object> getMapp() {
		return mapp;
	}
	public void setMapp(Map<String, Object> mapp) {
		this.mapp = mapp;
	}


	public RestTemplateFromJava getJava() {
		return java;
	}


	public void setJava(RestTemplateFromJava java) {
		this.java = java;
	}


	public RestTemplateFromTibco getTibco() {
		return tibco;
	}


	public void setTibco(RestTemplateFromTibco tibco) {
		this.tibco = tibco;
	}


	public String getSearch() {
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
	}
	
}
