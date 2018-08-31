import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleWriteExample {

	public static void main(String[] args) {
		    JSONObject obj = new JSONObject();
//	        obj.put("name", "mkyong.com");
//	        obj.put("age", new Integer(100));
//
//	        JSONArray list = new JSONArray();
//	        list.add("msg 1");
//	        list.add("msg 2");
//	        list.add("msg 3");
//
//	        obj.put("messages", list);
		    
		    obj.put("projectCodePerson", "KATERING");
		    obj.put("messageIdPerson", "EMP0002K1");
		    obj.put("idPerson", "EMP0002");
		    obj.put("chatTypePerson", "PERSONAL");
		    
		    List<Map<String,Map<String,Object>>> list = new ArrayList<>();
		    Map<String, Map<String,Object>> mapp = new HashMap<>();
		    Map<String, Object> mappp = new HashMap<>();
		    mappp.put("sendDate", new Date());
		    mappp.put("message", "Hai");
		    mappp.put("messager", "EMP0001");
		    mappp.put("statusMessage", true);
		    mappp.put("receiver", "EMP0002");
		    mapp.put("Detail1", mappp);
		    list.add(mapp);
		    obj.put("Detail", list);
		    
	        try (FileWriter file = new FileWriter("D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileJsons\\EMP0001.json")) {

	            file.write(obj.toJSONString());
	            file.flush();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.print(obj);
	}

}
