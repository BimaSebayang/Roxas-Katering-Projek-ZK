package RestResponse.FromTibco;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import Master.StaticVariable.AllStaticVariable;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class RestTemplateFromTibco implements Serializable{
	private final AllStaticVariable VARIABLE = new AllStaticVariable();
	private static final long serialVersionUID = 1L;

	   //ini digunakan untuk ambil rest template dari tibco menggunakan method Get
	   //url tanpa "/" didepannya
	   public Map<String,Object> mapRestTemplateValueWithGetMethod(String url,  Object... params){
		   String finalParams = "";
		   if(params.length != 0){
		   finalParams = "?";
		   for (int i = 0; i < params.length; i++) {
			 finalParams += params[i];
			 if(i<params.length){
				 finalParams += "&"; 
			 }
		   }
		   }		   
		   RestTemplate restTemplate = new RestTemplate();
		   ResponseEntity<String> entity = restTemplate.getForEntity(VARIABLE.TIBCOURL+url+finalParams, String.class);
		   MediaType contentType = entity.getHeaders().getContentType();
		   HttpStatus statusCode = entity.getStatusCode();
		   TypeFactory _t = TypeFactory.defaultInstance();
		   System.err.println(entity.getBody());
		   ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
			Map<String, Object> test = new HashMap<>();
				try {
					test =  mapper.readValue(entity.getBody(), new TypeReference<HashMap<String, Object>>(){});
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
		   return test;
	   }
	   
	   public Map<String,Object> mapRestTemplateValueWithPostMethod(String url, Object objBodyRequest, Object... params){
		   String finalParams = "";
		   if(params.length != 0){
		   finalParams = "?";
		   for (int i = 0; i < params.length; i++) {
			 finalParams += params[i];
			 if(i<params.length){
				 finalParams += "&"; 
			 }
		   }
		   }
		   RestTemplate restTemplate = new RestTemplate();
		   HttpEntity httpEntity = new HttpEntity(objBodyRequest);
		   ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.TIBCOURL+url+finalParams, 
					 HttpMethod.POST, httpEntity, String.class);
			 MediaType contentType = entity.getHeaders().getContentType();
			 HttpStatus statusCode = entity.getStatusCode();
			 TypeFactory _t = TypeFactory.defaultInstance();
			 System.err.println(entity.getBody());
			 ObjectMapper mapper = new ObjectMapper();
			 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
			 Map<String, Object> test = new HashMap<>();
				try {
					test =  mapper.readValue(entity.getBody(), new TypeReference<HashMap<String, Object>>(){});
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   return test;
	   }
	   
	   public String requestPopUpMenuUrl(String requestUrl, String menuCode, String userId){
		   Map<String,Object> map = new HashMap<>();
		   map.put("requestUrl",requestUrl);
		   String perfectUrl = "requestPopUp/"+menuCode+"/"+userId;
		   Map<String,Object> mapp = mapRestTemplateValueWithPostMethod(perfectUrl ,map);
		   String template = (String) mapp.get("url");
		   return template;
	   }
	   
	
}
