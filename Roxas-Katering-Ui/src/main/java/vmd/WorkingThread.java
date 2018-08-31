package vmd;

import org.zkoss.lang.Threads;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;

public class WorkingThread extends Thread {
	   private final Desktop _desktop;
	   
	   public WorkingThread(Desktop desktop) {
	      _desktop = desktop;
	   }
	 
	   public void run() {
	      try {
	 
	         if (_desktop.isServerPushEnabled()) {
	 
	            for (int i = 0; i < 5; i++) {
	               Executions.activate(_desktop);
	               Clients.showBusy("Executing " + (i + 1) + " of 5");
	               Executions.deactivate(_desktop);
	                     
	               // Simulate a long opetation
	               Threads.sleep(500);
	            }
	            Executions.activate(_desktop);
	            Clients.clearBusy();
	            Executions.deactivate(_desktop);
	         }
	 
	      } catch (InterruptedException ex) {
	      } finally {
	         _desktop.enableServerPush(false);
	      }
	   }
	 
	}
