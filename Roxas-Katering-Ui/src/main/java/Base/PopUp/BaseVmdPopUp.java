package Base.PopUp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import vmd.MenuUtama.MenuUtamaVmd;
import RestResponse.FromJava.RestTemplateFromJava;
import RestResponse.FromTibco.RestTemplateFromTibco;

public abstract class BaseVmdPopUp extends MenuUtamaVmd implements Serializable{
private static final long serialVersionUID = 1L;
	
	private RestTemplateFromJava java = new RestTemplateFromJava();
	private RestTemplateFromTibco tibco = new RestTemplateFromTibco();
	
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
}
