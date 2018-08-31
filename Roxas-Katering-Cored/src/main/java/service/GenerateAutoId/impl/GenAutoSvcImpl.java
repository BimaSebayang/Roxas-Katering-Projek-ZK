package service.GenerateAutoId.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import Master.MapperClass.MappingClassSvc;
import dao.MenuSchemaDao.TableButtonDao;
import dao.MenuSchemaDao.TableMenuDao;
import dao.PegawaiSchemaDao.TableDataKaryawanDao;
import entity.MenuSchema.TableButton;
import entity.MenuSchema.TableMenu;
import entity.PegawaiSchema.TableDataKaryawan;
import service.GenerateAutoId.GenAutoSvc;

@Service("genAutoSvc")
@Transactional
public class GenAutoSvcImpl implements GenAutoSvc {
     @Autowired
     private TableMenuDao tableMenuDao;
     
     @Autowired
     private TableButtonDao tableButtonDao;
     
     @Autowired
     private TableDataKaryawanDao tableDataKaryawanDao;
     
     @Autowired
     private MappingClassSvc mappingClassSvc;
     
     public boolean isNumber(String temp){
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
 	
 	public boolean isTempValid(String temp){
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
 	
 	public Map<String,Object> splitExistingString(String objectSplitting){
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
 	
	
 	public String genAutoNumber(List<String> existId,String tempName,int numberTemp){
 	   
	    //untuk template --start
	    List<String> existTemp = new ArrayList<>();
	    for (String id : existId) {
	    	if(!existTemp.contains(id)){
			existTemp.add(((String) splitExistingString(id).get("template")).trim());
	    	}
		}
	    
	    
	    String usingTemp = "";
	    for (String _existTemp : existTemp) {
			if(_existTemp.equalsIgnoreCase(tempName)){
				usingTemp = _existTemp;
			}
			else{
				usingTemp = tempName.toUpperCase();
			}
		}
	    //untuk template --end
	    
	    Map<String,String> kumpulanEn = new TreeMap<>();
	    //untuk generate auto --start
	    List<String> existNumber = new ArrayList<>();
	    for (String id : existId) {
	    	String untukTemplate = new String();
			String untukNumber = new String();
			
			untukTemplate = (String) splitExistingString(id).get("template");
			untukNumber = (String) splitExistingString(id).get("numberGenerator");
			
			kumpulanEn.put(untukNumber,untukTemplate);
		}
	    
	    int _h = 0 ;
		for (Entry<String, String> map: kumpulanEn.entrySet()) {
			if(map.getValue().equalsIgnoreCase(usingTemp)){
			    _h = new Integer(map.getKey()) + 1;	
			}
			else{
				_h = new Integer(0)+1;
			}
		}
	    //untuk generate auto --end
		
		String _hasil = String.valueOf(_h);
		System.err.println(_hasil);
		String _perulanganNol = "";
		int banyakAngka = _hasil.length();
		
	     for (int op = 1 ; op <= (numberTemp - banyakAngka)  ; op++) {
			   _perulanganNol = _perulanganNol + "0";
		 }
	     
		
		return usingTemp+_perulanganNol+_hasil;
 	}
     
	@Override
	public String generateAutoIdForCurrentTable(String tableName,String tempName, int numberTemp) {
	if(isTempValid(tempName)){
		if(tableName.equalsIgnoreCase("TABLE_MENU")){
		    List<TableMenu> tableMenus = tableMenuDao.findAll();
		    List<String> existId = new ArrayList<>();
		    for (TableMenu tableMenu : tableMenus) {
				existId.add(tableMenu.getMenuCode());
			}   
		 
			return genAutoNumber(existId, tempName, numberTemp);
		}
		else if(tableName.equalsIgnoreCase("TABLE_BUTTON")){
			 List<TableButton> tableButtons = tableButtonDao.findAll();
			    List<String> existId = new ArrayList<>();
			    for (TableButton tableButton : tableButtons) {
					existId.add(tableButton.getButtonCode());
				}   
			 
				return genAutoNumber(existId, tempName, numberTemp);
		}
		else if(tableName.equalsIgnoreCase("TABLE_MENU")){
			
		}
		
		else if (tableName.equalsIgnoreCase("TABLE_DATA_KARYAWAN")) {
			 List<TableDataKaryawan> tableDataKaryawans = tableDataKaryawanDao.findAll();
			    List<String> existId = new ArrayList<>();
			    for (TableDataKaryawan tableDataKaryawan : tableDataKaryawans) {
					existId.add(tableDataKaryawan.getPegawaiId());
				}   
				return genAutoNumber(existId, tempName, numberTemp);
		}
		else{
			return "Table Tidak Ada";
		}
		
	}
	
		return "Template Tidak Valid";
	}
	
	
	
}
