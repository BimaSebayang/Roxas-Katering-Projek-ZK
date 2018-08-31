package RestResponse.FromFilingSystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.thoughtworks.xstream.core.util.Base64Encoder;

import Master.StaticVariable.AllStaticVariable;

public class RestTemplateFromFilingSystem implements Serializable{
	private final AllStaticVariable VARIABLE = new AllStaticVariable();
	private static final long serialVersionUID = 1L;
	
	private String titleFile = new String();
	private String typeFile = new String();
	private String uri = new String();
	private byte[] media;
	
	private String oldTitleFile = new String();
	private String newTitleFile = new String(); 
	
	public RestTemplateFromFilingSystem(String uri,String titleFile, String typeFile){
		this.titleFile = titleFile;
		this.typeFile = typeFile;
		this.uri = uri;
	}
	
	public RestTemplateFromFilingSystem(byte[] media , String uri, String titleFile, String typeFile){
		this.titleFile = titleFile;
		this.typeFile = typeFile;
		this.uri = uri;
		this.media = media;
	}
	
	public RestTemplateFromFilingSystem(byte[] media , String uri, String oldTitleFile,String newTitleFile, 
			String typeFile){
		this.oldTitleFile = oldTitleFile;
		this.newTitleFile = newTitleFile;
		this.typeFile = typeFile;
		this.uri = uri;
		this.media = media;
	}
	
	public String save(){
		RestTemplate restTemplate = new RestTemplate();
		Base64Encoder encoder = new Base64Encoder();
		String encoderMedia = encoder.encode(media);

		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("title", titleFile);
		mapRe.put("encoder", encoderMedia);
		mapRe.put("uri", uri);
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/saveImage", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/savePdf", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		return null;
	}
	
	public String delete(){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("title", titleFile);
		mapRe.put("uri", uri);
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/deleteImage", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/deletePdf", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		return null;
	}
	
	public String replace(){
		RestTemplate restTemplate = new RestTemplate();
		Base64Encoder encoder = new Base64Encoder();
		String encoderMedia = encoder.encode(media);
		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("oldTitle", oldTitleFile);
		mapRe.put("newTitle", newTitleFile);
		mapRe.put("encoder", encoderMedia);
		mapRe.put("uri", uri);
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/replaceImage", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/replacePdf", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		return null;
	}
	
	public ResponseEntity<byte[]> getTheBodyEntity(){
		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("title",titleFile);
		mapRe.put("uri", uri);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<byte[]> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/getSpecificImage", 
  					 HttpMethod.POST, httpEntity, byte[].class);
			return entity;
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<byte[]> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/getSpecificPdf", 
  					 HttpMethod.POST, httpEntity, byte[].class);
			return entity;
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		return null;
	}
	

	
}
