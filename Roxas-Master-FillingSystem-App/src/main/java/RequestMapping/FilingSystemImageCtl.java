package RequestMapping;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;









import com.thoughtworks.xstream.core.util.Base64Encoder;

import Master.RestResponseMapping;

@RestController
@RequestMapping("/filingSystemImage")
public class FilingSystemImageCtl {

	private final Path URITEMPORARY = Paths.get("D:\\Kumpulan Projek Bima",
			"Projek Filing System", "Master-Filling-Sytem-Folder");
	private final Path URIPICTURE = Paths.get(URITEMPORARY.toString(),"folderFilePictures");

	@RequestMapping(value = "/getSpecificImage", method = RequestMethod.POST)
	public ResponseEntity<byte[]> getImageAsResponseEntity(
			@RequestBody Map<String,Object> mapper) {
		HttpHeaders headers = new HttpHeaders();
		
		String uriTambahan = (String) mapper.get("uri");
		
		if(uriTambahan == null){	
			uriTambahan = "";
		}
        if((String) mapper.get("title")!=null){
		Path getTheFile = Paths.get(URIPICTURE.toString()+uriTambahan, (String) mapper.get("title"));
		File file = new File(getTheFile.toString());
        InputStream inputStream = null;
        byte[] media = null;
		try {
			inputStream = new FileInputStream(file);
			media = IOUtils.toByteArray(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	    }
        return new ResponseEntity<byte[]>(null, null, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImageEntity(@RequestBody Map<String,Object> mapper){
        String uriTambahan = (String) mapper.get("uri");
		
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		Path getTheFile = Paths.get(URIPICTURE.toString()+uriTambahan, (String) mapper.get("title"));
		File newFile = new File(getTheFile.toString());
		Base64Encoder decoder = new Base64Encoder();
		BufferedImage image = null;
	        byte[] imageByte = null;
	        try {
	            imageByte = decoder.decode((String) mapper.get("encoder"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		try {
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write(imageByte);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "berhasil";
	}
	
	@RequestMapping(value = "/deleteImage", method = RequestMethod.POST)
	public String deletePhotoEntity(@RequestBody Map<String,Object> mapper){
        String uriTambahan = (String) mapper.get("uri");
		
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		Path getTheFile = Paths.get(URIPICTURE.toString()+uriTambahan, (String) mapper.get("title"));
		try{
			Files.delete(getTheFile);
			System.err.println("file deleted");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "berhasil";
	}
	
	@RequestMapping(value = "/replaceImage", method = RequestMethod.POST)
	public String replacePhotoEntity(@RequestBody Map<String,Object> mapper){
        String uriTambahan = (String) mapper.get("uri");
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		if( (String) mapper.get("oldTitle") !=null){
		Path getTheOldFile = Paths.get(URIPICTURE.toString()+uriTambahan, (String) mapper.get("oldTitle"));
		try{
			Files.delete(getTheOldFile);
			System.err.println("file deleted");
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		Path getTheNewFile = Paths.get(URIPICTURE.toString()+uriTambahan, (String) mapper.get("newTitle"));
		File newFile = new File(getTheNewFile.toString());
		Base64Encoder decoder = new Base64Encoder();
		BufferedImage pdf = null;
	        byte[] pdfByte = null;
	        try {
	            pdfByte = decoder.decode((String) mapper.get("encoder"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		try {
			FileOutputStream fos = new FileOutputStream(newFile);
			fos.write(pdfByte);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "berhasil";
	}


}
