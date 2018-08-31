package vmd.Transaksi.Regristrasi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Sessions;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MasterSchemaDto.TableMasterMenuMasakanDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import Source.LocaleSource.LOCALE;

@Init(superclass = true)
public class MenuMasakanVmd extends BaseVmdMenu implements Serializable  {
	private static final long serialVersionUID = 1L;

	 private List<TableMasterMenuMasakanDto> tableMasterMenuMasakanDtos = new ArrayList<>();
	 private TableMasterMenuMasakanDto tableMasterMenuMasakanDto = new TableMasterMenuMasakanDto();
	
	//bagian filter --start
    private TableMasterMenuMasakanDto filterTableMasterMenuMasakanDto = new TableMasterMenuMasakanDto();
    private TableMasterMenuMasakanDto tempFilterTableMasterMenuMasakanDto = new TableMasterMenuMasakanDto();
    private List<Object> filters = new ArrayList<>();
    private String filterTitle = new String();
    private boolean onFilter = false;
    //bagian filter --end
    
    //Url Part --start
    private final String finalUrl = "/MenuMasakan";
    //Url part --end

    @Command
	public void sliceSorter(@BindingParam("exec") String exec, @ContextParam(ContextType.BIND_CONTEXT) BindContext ctx){
		setSortingList(ctx,exec);
		slicePaging();
	}
	
	@Command
	public void searchOrClick() {
		initIndex();
	}

	@Command
	public void slicePaging(){
	    searchOrClick();
	}

	@Command
	public void okFilter(@BindingParam("fold") String fold) {
		initIndex();
		setOnFilter(false);
		BindUtils.postNotifyChange(null, null, this, "onFilter");
	}
    
    @Override
	public void loadListAll(TableMenuDto menu) {
		initTemporary();
		initIndex();
		super.loadListAll(menu);
	}
    
	public void initIndex() {
		initBackground();
		Map<String, Object> mapRequest = new HashMap<>();
		mapRequest = CallRequestMappingJavaForIndex(finalUrl+"/GetAllExistingData",
				tempFilterTableMasterMenuMasakanDto);
		if (mapRequest.size() > 0) {
			tableMasterMenuMasakanDtos.clear();
			tableMasterMenuMasakanDtos = getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableMasterMenuMasakanDto>>() {
					}.getType(), tableMasterMenuMasakanDtos, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableMasterMenuMasakanDtos");
	}
    
	public void initTemporary() {
		tempFilterTableMasterMenuMasakanDto = allFilterTableMasterMenuMasakanDto();
	}
	
	@Command("buttonCommand")
	public void allCommandButton(@BindingParam("buttonName") String buttonName) {
		if (buttonName.equals("tambah")) {
			tambah();
		} else if (buttonName.equals("hapus")) {
			// hapus();
		} else if (buttonName.equals("aktivasi")) {
			 //aktivasi();
		} else if (buttonName.equals("nonaktiv")) {
			 //nonaktiv();
		} else if (buttonName.equals("lihat")) {
			//lihat();
		} else if (buttonName.equals("edit")) {
			//edit();
		} else if (buttonName.equals("kirim")) {
			//kirim();
		} else {
			Messagebox.show("button belum bisa dipakai");
		}
	}
	 
	public void tambah() {
		Sessions.getCurrent().setAttribute("Tambah", "HasilTambah");
		getCompleteGroupPageInfoForm(true, false, false, LOCALE.L007.getMessage());
	}
	
	public TableMasterMenuMasakanDto allFilterTableMasterMenuMasakanDto() {
		TableMasterMenuMasakanDto  filterConfig = new TableMasterMenuMasakanDto();

		List<String> resultA = new ArrayList<>();
		Map<String, Object> mapRequestA = new HashMap<>();
		mapRequestA = CallRequestMappingJavaForFilter(finalUrl+"/GetAllExistingFilter",
				"KODE MENU");
		if (mapRequestA.size() > 0) {
			resultA = getJava().mapperJsonToListDto(mapRequestA, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultA, "contents");
			filterConfig.setKodeMakanans(resultA);
		}

		List<String> resultB = new ArrayList<>();
		Map<String, Object> mapRequestB = new HashMap<>();
		mapRequestB = CallRequestMappingJavaForFilter(finalUrl+"/GetAllExistingFilter", "NAMA MENU");
		if (mapRequestB.size() > 0) {
			resultB = getJava().mapperJsonToListDto(mapRequestB, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultB, "contents");
			filterConfig.setNamaMakanans(resultB);
		}

		List<String> resultC = new ArrayList<>();
		Map<String, Object> mapRequestC = new HashMap<>();
		mapRequestC = CallRequestMappingJavaForFilter(finalUrl+"/GetAllExistingFilter", "KODE RESEP");
		if (mapRequestC.size() > 0) {
			resultC = getJava().mapperJsonToListDto(mapRequestC, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultC, "contents");
			filterConfig.setKodeReseps(resultC);
		}

		List<String> resultD = new ArrayList<>();
		Map<String, Object> mapRequestD = new HashMap<>();
		mapRequestD  = CallRequestMappingJavaForFilter(finalUrl+"/GetAllExistingFilter", "STATUS MENU");
		if (mapRequestD.size() > 0) {
			resultD = getJava().mapperJsonToListDto(mapRequestD , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultD, "contents");
			filterConfig.setStatusMakanans(resultD);
		}

		
		List<String> resultE = new ArrayList<>();
		Map<String, Object> mapRequestE = new HashMap<>();
		mapRequestE  = CallRequestMappingJavaForFilter(finalUrl+"/GetAllExistingFilter", "STATUS PERSETUJUAN");
		if (mapRequestE.size() > 0) {
			resultE = getJava().mapperJsonToListDto(mapRequestE , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultE, "contents");
			filterConfig.setStatusPersetujuans(resultE);
		}
		
		return filterConfig;
	}
	

   	public List<TableMasterMenuMasakanDto> getTableMasterMenuMasakanDtos() {
		return tableMasterMenuMasakanDtos;
	}




	public void setTableMasterMenuMasakanDtos(List<TableMasterMenuMasakanDto> tableMasterMenuMasakanDtos) {
		this.tableMasterMenuMasakanDtos = tableMasterMenuMasakanDtos;
	}




	public TableMasterMenuMasakanDto getTableMasterMenuMasakanDto() {
		return tableMasterMenuMasakanDto;
	}




	public void setTableMasterMenuMasakanDto(TableMasterMenuMasakanDto tableMasterMenuMasakanDto) {
		this.tableMasterMenuMasakanDto = tableMasterMenuMasakanDto;
	}




	public TableMasterMenuMasakanDto getFilterTableMasterMenuMasakanDto() {
		return filterTableMasterMenuMasakanDto;
	}
	public void setFilterTableMasterMenuMasakanDto(TableMasterMenuMasakanDto filterTableMasterMenuMasakanDto) {
		this.filterTableMasterMenuMasakanDto = filterTableMasterMenuMasakanDto;
	}
	public TableMasterMenuMasakanDto getTempFilterTableMasterMenuMasakanDto() {
		return tempFilterTableMasterMenuMasakanDto;
	}
	public void setTempFilterTableMasterMenuMasakanDto(TableMasterMenuMasakanDto tempFilterTableMasterMenuMasakanDto) {
		this.tempFilterTableMasterMenuMasakanDto = tempFilterTableMasterMenuMasakanDto;
	}
	public List<Object> getFilters() {
		return filters;
	}
	public void setFilters(List<Object> filters) {
		this.filters = filters;
	}
	public String getFilterTitle() {
		return filterTitle;
	}
	public void setFilterTitle(String filterTitle) {
		this.filterTitle = filterTitle;
	}
	public boolean isOnFilter() {
		return onFilter;
	}
	public void setOnFilter(boolean onFilter) {
		this.onFilter = onFilter;
	}
    
    
}
