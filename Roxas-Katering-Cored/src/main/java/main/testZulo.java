package main;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.idom.Item;
import org.zkoss.zhtml.Messagebox;

public class testZulo {
	private String showIndex = "showIndex";
	
	public String getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(String showIndex) {
		this.showIndex = showIndex;
	}

	@Command("showIndex")
	public void showIndex(@BindingParam("index") String index) {
		if(index.equalsIgnoreCase("cobaIndex"))
	    Messagebox.show("tombol index, dengan " + index);
		if(index.equalsIgnoreCase("cobaItem"))
	    Messagebox.show("tombol delete, dengan " + index);
	}
	 
}
