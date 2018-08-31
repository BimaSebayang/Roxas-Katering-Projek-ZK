package Master;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RestResponseMapping {
    private String requestContent;
    private File file;
    private byte[] byteFile;
    private String fileTitle;
    private final Path URITEMPORARY = Paths.get("D:\\Kumpulan Projek Bima","ProjectMasterApp V1.0",
    		                                     "App-FilingSystem");
    private final Path  URIPICTURE = Paths.get(URITEMPORARY.toString(),"src","main"
			                         ,"folderFilePictures");
    
    public RestResponseMapping(String requestContent, String fileTitle){
    	this.requestContent = requestContent;
    	this.fileTitle = fileTitle;
    }
    
    
    public RestResponseMapping(String requestContent, File file){
    	this.requestContent = requestContent;
    	this.file = file;
    }
    
    public RestResponseMapping(String requestContent, byte[] byteFile){
    	this.requestContent = requestContent;
    	this.byteFile = byteFile;
    }
    
    public Map<String,Object> setTheValueOfRequestContent(){
    	Map<String,Object> mapper = new HashMap<>();
    	if(requestContent.equalsIgnoreCase("pdf")){
    		
    	}
    	else if(requestContent.equalsIgnoreCase("image")){
    		
    		if(file !=null){
    			return null;
    		}
    		
    		if(byteFile !=null){
    			return null;
    		}
    		
    		Path getTheFile = Paths.get(URIPICTURE.toString(), fileTitle);
			try {
				byte[] fileOnByte = Files.readAllBytes(getTheFile);
				mapper.put("fileOnByte", fileOnByte);
				mapper.put("fileTitle", fileTitle);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	
    		
    	}
    	else if(requestContent.equalsIgnoreCase("word")){
    		
    	}
    	else if(requestContent.equalsIgnoreCase("excel")){
    		
    	}
    	else if(requestContent.equalsIgnoreCase("text")){
    		
    	}
    	else{
    	
    		if(file !=null){
    			return null;
    		}
    		
    		if(byteFile !=null){
    			return null;
    		}
    		
    	}
    	
    	return mapper;
    }
    
}
