package RequestMapping;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtworks.xstream.core.util.Base64Encoder;


@RestController
@RequestMapping("/filingSystemPdf")
public class FilingSystemPdfCtl {

	

	private final Path URITEMPORARY = Paths.get("D:\\Kumpulan Projek Bima",
			"Projek Filing System", "Master-Filling-Sytem-Folder");
	private final Path URIPDF = Paths.get(URITEMPORARY.toString(),"folderFilePdfs");

	
	@RequestMapping(value="/getSpecificPdf", method=RequestMethod.POST)
	public ResponseEntity<byte[]> getPDF(@RequestBody  Map<String,Object> mapper) {
	   
		
        String uriTambahan = (String) mapper.get("uri");
		
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		
		if((String) mapper.get("title")!=null){
		Path getTheFile = Paths.get(URIPDF.toString()+uriTambahan, (String) mapper.get("title"));
		File file = new File(getTheFile.toString());
        InputStream inputStream = null;
        byte[] media = null;
		try {
			inputStream = new FileInputStream(file);
			media = IOUtils.toByteArray(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "output.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(media, headers, HttpStatus.OK);
	    return response;
		}
		return new ResponseEntity<byte[]>(null, null, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/savePdf", method = RequestMethod.POST)
	public String savePdfEntity(@RequestBody Map<String,Object> mapper){
        String uriTambahan = (String) mapper.get("uri");
		
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		if((String) mapper.get("title")!=null){
		Path getTheFile = Paths.get(URIPDF.toString()+uriTambahan, (String) mapper.get("title"));
		File newFile = new File(getTheFile.toString());
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
		}
		return "berhasil";
	}
	
	@RequestMapping(value = "/deletePdf", method = RequestMethod.POST)
	public String deletePdfeEntity(@RequestBody Map<String,Object> mapper){
        String uriTambahan = (String) mapper.get("uri");
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		Path getTheFile = Paths.get(URIPDF.toString()+uriTambahan, (String) mapper.get("title"));
		try{
			Files.delete(getTheFile);
			System.err.println("file deleted");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "berhasil";
	}
	
	@RequestMapping(value = "/replacePdf", method = RequestMethod.POST)
	public String replacePdfeEntity(@RequestBody Map<String,Object> mapper){
        String uriTambahan = (String) mapper.get("uri");
		
		if(uriTambahan == null){	
			uriTambahan = "";
		}
		
		if( (String) mapper.get("oldTitle") !=null){
		Path getTheFile = Paths.get(URIPDF.toString()+uriTambahan, (String) mapper.get("oldTitle"));
		try{
			Files.delete(getTheFile);
			System.err.println("file deleted");
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		Path getTheNewFile = Paths.get(URIPDF.toString()+uriTambahan, (String) mapper.get("newTitle"));
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
