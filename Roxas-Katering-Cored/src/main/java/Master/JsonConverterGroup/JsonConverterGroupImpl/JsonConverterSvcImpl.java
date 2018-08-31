package Master.JsonConverterGroup.JsonConverterGroupImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import Master.JsonConverterGroup.JsonConverterSvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;


//created by : Bima S.
@Service("jsonConverterSvc")
public class JsonConverterSvcImpl implements JsonConverterSvc{
	
	// untuk mengubah nilai json menjadi object dalam Class
	public <T> Object getTheResult(Object domainObjectConverter, Class<T> clazz) {
		Object a = new Object();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		try {
			String _hasil = mapper.writeValueAsString(domainObjectConverter);
			try {
				a = mapper.readValue(_hasil, clazz);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		String _hasilOnConsole;
		try {
			_hasilOnConsole = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(domainObjectConverter);
			System.err.println(_hasilOnConsole);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return a;
	}

	// untuk mengubah nilai json menjadi object dalam ArrayList
	public <T> List<T> getArrayListResultJson(Object domainObjectConverter,Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		List<T> objects = new ArrayList<>();
		TypeFactory _t = TypeFactory.defaultInstance();
		try {
			String _hasil = mapper.writeValueAsString(domainObjectConverter);  
			try {
				objects = mapper.readValue(_hasil,
						_t.constructCollectionType(ArrayList.class, clazz));  //membaca nilai json menjadi sebuah object
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _hasilOnConsole;
		try {
			_hasilOnConsole = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(domainObjectConverter);
			System.err.println(_hasilOnConsole);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objects;
	}

	// untuk mengubah nilai json menjadi object dalam HashMap
	public <T, K> Map<T, K> getHashMapResultJson(Object domainObjectConverter)  {
		ObjectMapper mapper = new ObjectMapper();
		Map<T, K> mapping = new HashMap<>();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		String json = new String();
		try {
			json = mapper.writeValueAsString(domainObjectConverter);
			try {
				mapping = mapper.readValue(json, new TypeReference<HashMap<T, K>>() {
				});
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String _hasilOnConsole;
		try {
			_hasilOnConsole = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(domainObjectConverter);
			System.err.println(_hasilOnConsole);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    return mapping;
	}
}