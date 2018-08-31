package Master.DownloadAndUpload;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.util.media.Media;


public class MasterDownloadFile implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Media media;
	private String title;
	private String format;
	private String contentType;
	private byte[] byteData;
	private Map<String, Object> map = new HashMap<>();
	public  MasterDownloadFile(){
		
	}
	
	public MasterDownloadFile(Media media) {
		this.media  = media;
	}
	
	public MasterDownloadFile(byte[] byteData, String title, String contentType){
	   this.byteData = byteData;
	   this.title = title;
	   this.contentType = contentType;
	}
	
	
	//media download masih dalam tahap pengembangan
	public void mediaDownload(){
	  
        if(media != null){
	    map.put("mediaName", this.media.getContentType());
		map.put("mediaByte",  this.media.getByteData());
		map.put("mediaTitle", this.media.getName());
		map.put("mediaFormat", this.media.getFormat());
        }
        else{
        	map.put("mediaName", this.contentType);
    		map.put("mediaByte",  this.byteData);
    		map.put("mediaTitle", this.title);
    		map.put("mediaFormat", this.format);
        }
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public String getTitle() {
		mediaDownload();
		return (String) map.get("mediaTitle");
	}

	public String getFormat() {
		mediaDownload();
		return (String) map.get("mediaFormat");
	}


	public String getContentType() {
		mediaDownload();
		return (String) map.get("mediaName");
	}


	public byte[] getByteData() {
		mediaDownload();
		return (byte[]) map.get("mediaByte");
	}

}
