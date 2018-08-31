package main;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class TestRequest {

	public static void main(String[] args) throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();
		 //restTemplate.get
		
		 //response entity yang get
		 ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:7081/login/authenticationLogin", String.class);
		 
		 //response entity yang post
		 Map<String, Object> mapZ = new HashMap<>();
		 mapZ.put("userId", "bimaS");
		 mapZ.put("password", "Pass01.");
		 mapZ.put("failedLogin", 0);
		 HttpEntity httpEntity = new HttpEntity(mapZ);
		 ResponseEntity<String> entity2 = restTemplate.exchange("http://localhost:7081/login/authentication", 
				 HttpMethod.POST, httpEntity, String.class);
		 
		 String body = entity.getBody();
		 MediaType contentType = entity.getHeaders().getContentType();
		 HttpStatus statusCode = entity.getStatusCode();
		 TypeFactory _t = TypeFactory.defaultInstance();
		 System.err.println(entity2.getBody());
		 
	     ObjectMapper mapper = new ObjectMapper();
		 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
		  
		 Map<String, Object> test = new HashMap<>();
				test =  mapper.readValue(entity.getBody(), new TypeReference<HashMap<String, Object>>(){});
		 
		 for (Entry<String, Object> s: test.entrySet()) {
			System.out.println(s.getValue());
		}
		 
		 //assertThat(name.asText(), notNullValue());
		
//		try { 
//
//            URL url = new URL("http://localhost:7081/login/authentication"); 
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
//            connection.setDoOutput(true); 
//            connection.setInstanceFollowRedirects(false); 
//            connection.setRequestMethod("POST"); 
//            connection.setRequestProperty("Content-Type", "application/json"); 
//
//            OutputStream os = connection.getOutputStream(); 
//           //how do I get json object and print it as string
//            os.flush(); 
//
//            connection.getResponseCode(); 
//            System.out.println(connection.getContent().toString());
//            connection.disconnect(); 
//        } catch(Exception e) { 
//            throw new RuntimeException(e); 
//        } 

	}

}
