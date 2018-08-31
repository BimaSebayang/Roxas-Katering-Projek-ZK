package Master.SharingInformation;

import java.io.Serializable;

import org.zkoss.zk.ui.Sessions;

public class GlobalInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public void sendInformationToCurrentUri(String uri , String codeMenu, Object... params){
		for(int i=0;i<params.length;i++){
			Sessions.getCurrent().setAttribute("uri", uri);
			Sessions.getCurrent().setAttribute(codeMenu+i, params[i]);
		}
	}
	
	public Object getInformationFromCurrentMenu(String codeMenu, int paramKe){
		int paramS = paramKe-1;
		return Sessions.getCurrent().getAttribute(codeMenu+paramS);
	}
}
