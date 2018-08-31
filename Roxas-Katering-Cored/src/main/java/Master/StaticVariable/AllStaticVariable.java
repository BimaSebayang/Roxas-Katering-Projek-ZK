package Master.StaticVariable;

import java.io.Serializable;

//ini digunakan hanya untuk pemanggilan hard-code saja;
public class AllStaticVariable implements Serializable{
	private static final long serialVersionUID = 1L;
	//untuk development
//	public final String FILINGSYSTEMURL = "http://localhost:8081/Roxas-Master-FillingSystem-App/";
//	public  final String TIBCOURL = "http://localhost:7081/";

	//untuk deployment
	public final String FILINGSYSTEMURL = "http://localhost:28080/Roxas-Master-FillingSystem-App/";
	public  final String TIBCOURL = "http://localhost:7081/";
	
}
