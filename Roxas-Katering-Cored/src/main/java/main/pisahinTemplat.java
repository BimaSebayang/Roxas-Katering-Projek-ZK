package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class pisahinTemplat {

	public static Map<String,Object> splitExistingString(String objectSplitting){
        char[] tempL = objectSplitting.toCharArray(); 
		String realTemplate = "";
		String realNumberGenerate = "";
		int indexOut = 0;
		for(int i = tempL.length-1 ; i>0 ; i--){
			String _l = Character.toString(tempL[i]); 
		        if(isNumber(_l)){
		        	indexOut = i;
		        }	
		    
		        else{
		        
		        	break;
		        }
		        
		}
		for (int i = indexOut; i < tempL.length; i++) {
			String _l = Character.toString(tempL[i]); 
			realNumberGenerate += _l; 
		}
		
		for(int i = 0; i<indexOut ;i++){
			String _l = Character.toString(tempL[i]); 
			realTemplate += _l; 
		}
		
		Map<String, Object> mapSplitter = new HashMap<>();
 		mapSplitter.put("template", realTemplate);
 		mapSplitter.put("numberGenerator", realNumberGenerate);
 		return mapSplitter;
 	}
	
	public static boolean isNumber(String temp){
		if(temp.equalsIgnoreCase("1")){
			return true;
		}
		else if(temp.equalsIgnoreCase("2")){
			return true;
		}
		else if(temp.equalsIgnoreCase("3")){
			return true;
		}
		else if(temp.equalsIgnoreCase("4")){
			return true;
		}
		else if(temp.equalsIgnoreCase("5")){
			return true;
		}
		else if(temp.equalsIgnoreCase("6")){
			return true;
		}
		else if(temp.equalsIgnoreCase("7")){
			return true;
		}
		else if(temp.equalsIgnoreCase("8")){
			return true;
		}
		else if(temp.equalsIgnoreCase("9")){
			return true;
		}
		else if(temp.equalsIgnoreCase("0")){
			return true;
		}
		return false;
	}
	
	public static boolean isTempValid(String temp){
		char[] tempL = temp.toCharArray(); 
		try{
		String _temp = Character.toString(tempL[tempL.length-1]);
		if(isNumber(_temp)){
			return false;
		 }
		}catch(ArrayIndexOutOfBoundsException ex){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<String> kumpul = new ArrayList<>();
		kumpul.add("TES001");
		kumpul.add("TES002");
		kumpul.add("TES03");
		kumpul.add("TESS0010");
		kumpul.add("TESS0020");
		kumpul.add("TESS030");
		kumpul.add("TESS0300");
		
		Map<String,String> kumpulanEn = new TreeMap<>();
		
		for (String _kumpul : kumpul) {
			String untukTemplate = new String();
			String untukNumber = new String();
			
			untukTemplate = (String) splitExistingString(_kumpul).get("template");
			untukNumber = (String) splitExistingString(_kumpul).get("numberGenerator");
			
			kumpulanEn.put(untukNumber,untukTemplate);
		}
		
		
		int _h = 0 ;
		for (Entry<String, String> map: kumpulanEn.entrySet()) {
			if(map.getValue().equalsIgnoreCase("TESS")){
			    _h = new Integer(map.getKey()) + 1;	
			}
			
		}
	
		
		System.out.println("keluaran : " + _h);
		//System.out.println(i);
		
	}

}
