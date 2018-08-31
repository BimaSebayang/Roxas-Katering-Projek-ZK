package Master.StaticVariable;

import java.io.Serializable;

//ini digunakan hanya untuk pemanggilan hard-code saja;
public class AllStaticVariable implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Untuk Development
//	  public  final String TIBCOURL = "http://localhost:7081/";
//	  public final String JAVAURL = "http://localhost:8180/Roxas-Katering-Cored/";
//	  public final String FILINGSYSTEMURL = "http://localhost:8081/Roxas-Master-FillingSystem-App/";
//    public final String PORTALCOREURL = "http://localhost:8090/Roxas-Portal-Cored/";	
//    public final String JAVAPORTAL = "http://localhost:8090/Roxas-Portal-Cored/";
    
    //Untuk Deployment
    public  final String TIBCOURL = "http://localhost:7081/";
	public final String JAVAURL = "http://localhost:28080/Roxas-Katering-Cored/";
	public final String FILINGSYSTEMURL = "http://localhost:28080/Roxas-Master-FillingSystem-App/";
    public final String PORTALCOREURL = "http://localhost:28080/Roxas-Portal-Cored/";	
    public final String JAVAPORTAL = "http://localhost:28080/Roxas-Portal-Cored/";
}
