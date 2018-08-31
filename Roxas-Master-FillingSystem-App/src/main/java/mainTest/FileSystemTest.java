package mainTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;


public class FileSystemTest {

	public static void main(String[] args) {
		Path myPath = Paths.get("/some/path");
		Path anotherPath = Paths.get("some","path","something.txt");
		
		System.err.println("The Home Folder Is : " + System.getProperty("user.home"));
		System.err.println("Path to this program is : " + System.getProperty("user.dir"));
		
		Path picturesDirectory = Paths.get(System.getProperty("user.dir"),"src","main"
				,"folderFilePictures" );
		System.out.println("your directory is : " + picturesDirectory);
		Path path = Paths.get(picturesDirectory.toString()+"/ListUserBaru.png");
		try {
			byte[] data = Files.readAllBytes(path);
			System.out.println(" all byte is : " +data );
			FileUtils.writeByteArrayToFile(new File(picturesDirectory.toString()+"/ListUserBaruCopied.png"),
					data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//      cara mendelete file 
//		try{
//			Path deleteFileOnPathDirectory = Paths.get(picturesDirectory.toString(), "list user.png");
//			Files.delete(deleteFileOnPathDirectory);
//			System.err.println("file deleted");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		//cara merename file
//		try{
//			Path oldFilePath = Paths.get(picturesDirectory.toString(), "list user.png");
//			File oldFile = new File(oldFilePath.toString());
//			File newFile = new File(picturesDirectory.toString()+"/ListUserBaru.png");
//			oldFile.renameTo(newFile);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
		//cara copy File
//		try{
//			Path picturesWrongPath = Paths.get(System.getProperty("user.dir"),"src","main"
//					,"folderFileWords","images (1).jpg");
//			File oldFile = new File(picturesWrongPath.toString());
//			File newFile = new File(picturesDirectory.toString()+"/imagesCopied.png");
//			
//			//create new file
//			newFile.createNewFile();
//			
//			//create our stream 
//			FileInputStream fis = new FileInputStream(oldFile);
//			FileOutputStream fos = new FileOutputStream(newFile);
//			
//			//write out file into new file 
//			int aByte;
//			
//			while((aByte = fis.read())!=-1){
//				fos.write(aByte);
//			}
//			fis.close();
//			fos.close();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			
//		}
		
		//cara move file 
//		try{
//			
//			Path picturesWrongPath = Paths.get(System.getProperty("user.dir"),"src","main"
//					,"folderFileWords","images (1).jpg");
//			File oldFile = new File(picturesWrongPath.toString());
//			File newFile = new File(picturesDirectory.toString()+"/imagesCopied.png");
//			
//			//create new file
//			newFile.createNewFile();
//			
//			//create our stream 
//			FileInputStream fis = new FileInputStream(oldFile);
//			FileOutputStream fos = new FileOutputStream(newFile);
//			
//			//write out file into new file 
//			int aByte;
//			
//			while((aByte = fis.read())!=-1){
//				fos.write(aByte);
//			}
//			fis.close();
//			fos.close();
//			
//			//remove old file
//		    oldFile.delete();
// 			System.err.println("file deleted");
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			
//		}

	}
}
