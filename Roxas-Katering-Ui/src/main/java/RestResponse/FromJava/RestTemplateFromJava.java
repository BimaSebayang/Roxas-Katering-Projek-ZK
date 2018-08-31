package RestResponse.FromJava;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import PagingLib.Slice.SlicePaging;
import RestResponse.AdditionPackage.DateDeserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Master.StaticVariable.AllStaticVariable;


public class RestTemplateFromJava implements Serializable{
	
	private final AllStaticVariable VARIABLE = new AllStaticVariable();
	private static final long serialVersionUID = 1L;
	 //ini digunakan untuk ambil rest template dari tibco menggunakan method Get
	   //url tanpa "/" didepannya
	public Map<String,Object> mapRestTemplateValueWithGetMethod(String url, Object... params){
		   RestTemplate restTemplate = new RestTemplate();
		  
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
		   ResponseEntity<String> entity = restTemplate.getForEntity(VARIABLE.JAVAURL+url+finalParams, String.class);
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
		   ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.JAVAURL+url+finalParams, 
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
	   
	   
      public <T>SlicePaging<T> slicePagingWithPostMethod(String url, Object objBodyRequest, Object... params){
		   
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
		     ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.JAVAURL+url+finalParams, 
					 HttpMethod.POST, httpEntity, String.class);
			 MediaType contentType = entity.getHeaders().getContentType();
			 HttpStatus statusCode = entity.getStatusCode();
			 TypeFactory _t = TypeFactory.defaultInstance();
			 System.err.println(entity.getBody());
			 ObjectMapper mapper = new ObjectMapper();
			 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
			 SlicePaging<T> test = new SlicePaging<T>();
				try {
					test =  mapper.readValue(entity.getBody(), new TypeReference<SlicePaging<T>>(){});
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
	   
      public <T>SlicePaging<T> slicePagingWithGetMethod(String url, Object... params){
		   RestTemplate restTemplate = new RestTemplate();
		  
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
		   ResponseEntity<String> entity = restTemplate.getForEntity(VARIABLE.JAVAURL+url+finalParams, String.class);
		   MediaType contentType = entity.getHeaders().getContentType();
		   HttpStatus statusCode = entity.getStatusCode();
		   TypeFactory _t = TypeFactory.defaultInstance();
		   System.err.println(entity.getBody());
		   ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
						false);
			SlicePaging<T> test = new SlicePaging<T>();
				try {
					test =  mapper.readValue(entity.getBody(), new TypeReference<SlicePaging<T>>(){});
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
      
	   public Object mapperJsonToDto(Object dto, Map<String,Object> mapp, String valueParam) {
		   Class entityClass = dto.getClass();
		   Method[] entityMethods = entityClass.getMethods();
			for (Method methodDto : entityMethods) {
				if(methodDto.getName().substring(0, 3).equalsIgnoreCase("set")){
					for (Entry<String, Object> o: mapp.entrySet()) {
						if(o.getKey().equalsIgnoreCase(valueParam)){
							Map<String, Object> mappTheValue = new HashMap<>();
							mappTheValue =(Map<String, Object>) o.getValue();
							for (Entry<String, Object> valueMap : mappTheValue.entrySet()) {
							 if(valueMap.getKey().equalsIgnoreCase(methodDto.getName().substring(3))){
								 try {
									methodDto.invoke(dto, valueMap.getValue());
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									try {
										
										System.out.println("error pada bagian : " + methodDto.getName().substring(3));
										try {
											methodDto.invoke(dto, new BigDecimal((Double)valueMap.getValue()));
										}catch(ClassCastException cce) {
											try {
											System.out.println("bagian " + methodDto.getName().substring(3) + " tidak dapat dicasting ke double");
											methodDto.invoke(dto, new BigDecimal((Integer)valueMap.getValue()));
											}catch(ClassCastException cce2) {
												System.out.println("bagian " + methodDto.getName().substring(3) + " tidak dapat dicasting ke Integer");
												methodDto.invoke(dto, (Long)valueMap.getValue());
											}
										}
										
									} catch (IllegalAccessException | IllegalArgumentException
											| InvocationTargetException e1) {
										e1.printStackTrace();
									}
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
							  }
						    }
						}
					}
				}
			}
	
		return dto;
	   }
	   
	   
	   public <T> List<T> mapperJsonToListDto(
				Map<String, Object> mapper, Type clazz, List<T> ListDestination, String objectParameter) {
			
			Map<String,Object> mapperJava = new HashMap<>();
			
			mapperJava = mapper;
			
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
			
			Gson gson = gsonBuilder.create();
			String json  = gson.toJson(mapperJava.get(objectParameter));
			
			System.err.println(json);
					
			List<T> claszz  =  gson.fromJson(json, clazz);
			
		    for (T t : claszz) {
				ListDestination.add(t);
			}
		    
			return ListDestination;
		}
}
