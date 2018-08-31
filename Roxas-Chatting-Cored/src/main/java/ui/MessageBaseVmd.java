package ui;

import java.io.Serializable;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.sys.DesktopCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MessageBaseVmd extends GenericForwardComposer implements Serializable{

	
	private static final long serialVersionUID = 1L;
	protected boolean onWantChat = false;
    protected String user = "";    
    private boolean onChat = false;
    public Desktop desktop;
    
    @Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		Init();
	}
    
    @Init
    public void Init() {
    	desktop = Executions.getCurrent().getDesktop(); 
    	//Messagebox.show("TEST MEss");
    	//desktop.enableServerPush(true);
    }
	
	@Command("openChat")
	public void openChat() {
		onChat = true;
		BindUtils.postNotifyChange(null, null, this, "onChat");
	}

   
	@Command("login")
	public void login(){
		onWantChat = true;
		onChat = false;
		BindUtils.postNotifyChange(null, null, this, "onChat");
		BindUtils.postNotifyChange(null, null, this, "onWantChat");
		Messagebox.show("desktop : " + desktop.getCurrentDirectory());
		desktop.enableServerPush(true);		
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public boolean isOnWantChat() {
		return onWantChat;
	}

	public void setOnWantChat(boolean onWantChat) {
		this.onWantChat = onWantChat;
	}
	
	public boolean isOnChat() {
		return onChat;
	}


	public void setOnChat(boolean onChat) {
		this.onChat = onChat;
	
	}
}
