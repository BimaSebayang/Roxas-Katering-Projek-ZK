import java.io.File;

public class readAllFile {
  public static void main(String[] args) {
	 // System.out.println("tst");
	  final File folder = new File("D:\\Kumpulan Projek Bima\\Projek Filing System\\Master-Filling-Sytem-Folder\\folderFileXmls\\ChattingHystory");
	  int count = 0;
	  for (final File fileEntry : folder.listFiles()) {
		  System.out.println(fileEntry.getName());
	            if(fileEntry.getName().equals("EMP00001"));
	            {
	            	count++;
	            }
	    }
	  if(count==0) {
		  System.out.println("File belum Ada");
	  }
  }
}
