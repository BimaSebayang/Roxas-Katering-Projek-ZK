package vmd.Transaksi.Regristrasi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import RestResponse.FromJava.RestTemplateFromJava;
import Source.LocaleSource.LOCALE;
import Source.MessageSource.INFORMATION;
import Source.MessageSource.WARNING;

@Init(superclass = true)
public class MasterConfigurasiMenuVmd extends BaseVmdMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
	private TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
	private TableButtonDto tableButtonDto = new TableButtonDto();
	
	// bagian filter --start
	private TableConfigurationMenuDto filterTableConfigurationMenuDto = new TableConfigurationMenuDto();
	private TableConfigurationMenuDto tempFilterTableConfigurationMenuDto = new TableConfigurationMenuDto();
	private List<String> filters = new ArrayList<>();
	private String filterTitle = new String();
	// bagian filter --end
	
	//bagian form refactor --start
	private List<TableConfigurationMenuDto> tableConfigurationMenuDtosForDetail = new ArrayList<>();
	private List<TableConfigurationMenuDto> selectedTableConfigurationMenuDtosForDetail = new ArrayList<>();
	//bagian form refactor --end
	

	private boolean onFilter = false;

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

	@Command
	public void filter(@BindingParam("exec") String exec) {
		Map<String, Object> mapRequest = new HashMap<>();
		filterTableConfigurationMenuDto = new TableConfigurationMenuDto();
		mapRequest = CallRequestMappingJavaForFilter("/MasterConfigurasiMenu/GetAllExistingFilter",exec);
		if (mapRequest.size() > 0) {
			filters.clear();
			filters = getJava().mapperJsonToListDto(mapRequest, new TypeToken<ArrayList<Object>>() {
			}.getType(), filters, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		setFilterTitle("FILTER : " + exec);
		setOnFilter(true);
		if (exec.equalsIgnoreCase("NAMA KARYAWAN")) {
			filterTableConfigurationMenuDto.setNamaKaryawans(filters);
		} else if (exec.equalsIgnoreCase("NAMA MENU")) {
			filterTableConfigurationMenuDto.setNamaMenus(filters);
		} else if (exec.equalsIgnoreCase("NAMA TOMBOL")) {
			filterTableConfigurationMenuDto.setNamaTombols(filters);
		} else if (exec.equalsIgnoreCase("STATUS")) {
			filterTableConfigurationMenuDto.setStatuss(filters);
		}
		BindUtils.postNotifyChange(null, null, this, "filterTitle");
		BindUtils.postNotifyChange(null, null, this, "onFilter");
		BindUtils.postNotifyChange(null, null, this, "filterTableConfigurationMenuDto");
	}

	public TableConfigurationMenuDto allFilterTableConfigurationMenuDto() {
		TableConfigurationMenuDto filterConfig = new TableConfigurationMenuDto();

		List<String> resultKaryawan = new ArrayList<>();
		Map<String, Object> mapRequestKaryawan = new HashMap<>();
		mapRequestKaryawan = CallRequestMappingJavaForFilter("/MasterConfigurasiMenu/GetAllExistingFilter",
				"NAMA KARYAWAN");
		if (mapRequestKaryawan.size() > 0) {
			resultKaryawan = getJava().mapperJsonToListDto(mapRequestKaryawan, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultKaryawan, "contents");
			filterConfig.setNamaKaryawans(resultKaryawan);
		}

		List<String> resultMenu = new ArrayList<>();
		Map<String, Object> mapRequestMenu = new HashMap<>();
		mapRequestMenu = CallRequestMappingJavaForFilter("/MasterConfigurasiMenu/GetAllExistingFilter", "NAMA MENU");
		if (mapRequestMenu.size() > 0) {
			resultMenu = getJava().mapperJsonToListDto(mapRequestMenu, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultMenu, "contents");
			filterConfig.setNamaMenus(resultMenu);
		}

		List<String> resultTombol = new ArrayList<>();
		Map<String, Object> mapRequestTombol = new HashMap<>();
		mapRequestTombol = CallRequestMappingJavaForFilter("/MasterConfigurasiMenu/GetAllExistingFilter", "NAMA TOMBOL");
		if (mapRequestTombol.size() > 0) {
			resultTombol = getJava().mapperJsonToListDto(mapRequestTombol, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultTombol, "contents");
			filterConfig.setNamaTombols(resultTombol);
		}

		List<String> resultStatus = new ArrayList<>();
		Map<String, Object> mapRequestStatus = new HashMap<>();
		mapRequestStatus  = CallRequestMappingJavaForFilter("/MasterConfigurasiMenu/GetAllExistingFilter", "STATUS");
		if (mapRequestStatus.size() > 0) {
			resultStatus = getJava().mapperJsonToListDto(mapRequestStatus , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultStatus, "contents");
			filterConfig.setStatuss(resultStatus);
		}

		return filterConfig;
	}
	
	public void initTemporary() {
		tempFilterTableConfigurationMenuDto = allFilterTableConfigurationMenuDto();
	}
	

	
	public void refresh() {
		String test = (String) Sessions.getCurrent().getAttribute("Tambah");
		initIndex();
		tableConfigurationMenuDtosForDetail = new ArrayList<>();
		selectedTableConfigurationMenuDtosForDetail = new ArrayList<>();
		tableConfigurationMenuDto = new TableConfigurationMenuDto();
		BindUtils.postNotifyChange(null, null, this, "tableConfigurationMenuDto");
		BindUtils.postNotifyChange(null, null, this, "selectedTableConfigurationMenuDtosForDetail");
		BindUtils.postNotifyChange(null, null, this, "tableConfigurationMenuDtosForDetail");
	}

		
	public void initIndex() {
		initBackground();
		
		Map<String, Object> mapRequest = new HashMap<>();
		mapRequest = CallRequestMappingJavaForIndex("/MasterConfigurasiMenu/GetAllExistingData",
				tempFilterTableConfigurationMenuDto);
		if (mapRequest.size() > 0) {
			tableConfigurationMenuDtos.clear();
			tableConfigurationMenuDtos = getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableConfigurationMenuDto>>() {
					}.getType(), tableConfigurationMenuDtos, "contents");
			//Messagebox.show("total elements : " + mapRequest.get("counts"));
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableConfigurationMenuDtos");
	}

	
	@Override
	public void loadListAll(TableMenuDto menu) {
		initTemporary();
		initIndex();
		super.loadListAll(menu);
	}

	@Command("buttonCommand")
	public void allCommandButton(@BindingParam("buttonName") String buttonName) {
		if (buttonName.equals("tambah")) {
			tambah();
		} else if (buttonName.equals("hapus")) {
			 hapus();
		} else if (buttonName.equals("aktivasi")) {
			 aktivasi();
		} else if (buttonName.equals("nonaktiv")) {
			 nonaktiv();
		} else if (buttonName.equals("lihat")) {
			lihat();
		} else {
			Messagebox.show("button belum bisa dipakai");
		}
	}
    
	public void hapus() {
		if( tableConfigurationMenuDto.getNamaKaryawan() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		setSaatHapus(true);
		BindUtils.postNotifyChange(null, null, this, "saatHapus");
		detectQuestionMessageBox3("Apakah Anda Ingin Menghapus Data Ini ? ");
		
	}
	
	public void aktivasi() {
		getCompleteGroupPageRefactorForm(true, false, "AKTIVASI");
		Map<String,Object> mapp = new HashMap<>();
		mapp = CallRequestMappingJava("/MasterConfigurasiMenu/allNonAktifList", null, "GET" , "search="+getDetailSearch(),"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
		if (mapp.size() > 0) {
			tableConfigurationMenuDtosForDetail.size();
			tableConfigurationMenuDtosForDetail = getJava().mapperJsonToListDto(mapp,
					new TypeToken<ArrayList<TableConfigurationMenuDto>>() {
					}.getType(), tableConfigurationMenuDtosForDetail, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableConfigurationMenuDtosForDetail");
	}
	
	public void nonaktiv() {
		getCompleteGroupPageRefactorForm(false, true, "NON AKTIVASI");
		Map<String,Object> mapp = new HashMap<>();
		mapp = CallRequestMappingJava("/MasterConfigurasiMenu/allAktifList", null, "GET" , "search="+getDetailSearch(),"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
		if (mapp.size() > 0) {
			tableConfigurationMenuDtosForDetail.size();
			tableConfigurationMenuDtosForDetail = getJava().mapperJsonToListDto(mapp,
					new TypeToken<ArrayList<TableConfigurationMenuDto>>() {
					}.getType(), tableConfigurationMenuDtosForDetail, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableConfigurationMenuDtosForDetail");
	}
	
	public void lihat() {
		if( tableConfigurationMenuDto.getNamaKaryawan() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		//Messagebox.show(" nama " + tableConfigurationMenuDto.getMenuName());
		getCompleteGroupPageInfoForm(false, true, false, LOCALE.L011.getMessage());
	}
	
	public void tambah() {
		Sessions.getCurrent().setAttribute("Tambah", "HasilTambah");
		getCompleteGroupPageInfoForm(true, false, false, LOCALE.L007.getMessage());
	}

	// bagian detail --start
	@Command("saveForm")
	public void onSaveForm() {
		//Messagebox.show("TESTING CUYY");
		detectQuestionMessageBox3(" Apakah Anda Ingin Menyimpan Data Ini? ");
	}
	
	// bagian detail --start
	@Command("saveRefactor")
	public void saveRefactor() {
			if(selectedTableConfigurationMenuDtosForDetail.size()==0){
				showWarningMessageBox("Mohon Pilih Data Yang Ingin Ditransaksikan");
				return;
			}
			else if(saatAktivasi) {
			detectQuestionMessageBox3(" Apakah Anda Ingin Mengaktifkan Data Yang Dipilih? ");
			}
			else if(saatNonAktivasi){
				detectQuestionMessageBox3(" Apakah Anda Ingin Mengnonaktifkan Data Yang Dipilih? ");	
			}
	}

	@Command("backForm")
	public void onBackForm() {
		detectQuestionMessageBox2();
	}

	@Command("helpForm")
	public void onHelpForm() {
		getValidationGroupPageHelpAndInfo(true, false, "");
	}

	@Command("showProcedure")
	public void onShowProcedure() {

	}

	@Command("returnProcedure")
	public void onReturnProcedure() {
		getValidationGroupPageHelpAndInfo(false, true, "");
	}

	@Command("callUserId")
	public void onCallUserId() {
		Map<String, Object> mapp = new HashMap<>();
		callPopUpMenu("/MenuPopUp/CallUSerIdPu.zul", mapp);
	}

	@Command("callMenuCode")
	public void onCallMenuCode() {
		Map<String, Object> mapp = new HashMap<>();
		callPopUpMenu("/MenuPopUp/CallAllMenusPu.zul", mapp);
	}

	@Command("callButtonCode")
	public void onCallButtonCode() {
		Map<String, Object> mapp = new HashMap<>();
		mapp.put("menuCode", tableConfigurationMenuDto.getMenuCode());
		mapp.put("userId", tableConfigurationMenuDto.getUserId());
		callPopUpMenu("/MenuPopUp/CallAllButtonsPu.zul", mapp);
	}

	@GlobalCommand("CallUserIdPuVmd")
	public void popUpPegawaiHandler(@BindingParam("tableUserDto") TableUserDto dto) {
		tableConfigurationMenuDto.setUserId(dto.getUserId());
		tableConfigurationMenuDto.setNamaKaryawan(dto.getPegawaiName());
		tableConfigurationMenuDto.setPegawaiId(dto.getPegawaiId());
		BindUtils.postNotifyChange(null, null, MasterConfigurasiMenuVmd.this, "tableConfigurationMenuDto");
	}

	@GlobalCommand("CallAllMenusPuVmd")
	public void popUpMenuHandler(@BindingParam("tableMenuDto") TableMenuDto dto) {
		tableConfigurationMenuDto.setMenuCode(dto.getMenuCode());
		tableConfigurationMenuDto.setMenuName(dto.getMenuName());
		BindUtils.postNotifyChange(null, null, MasterConfigurasiMenuVmd.this, "tableConfigurationMenuDto");
	}

	@GlobalCommand("CallAllButtonsPuVmd")
	public void popUpButtonHandler(@BindingParam("tableButtonDto") TableButtonDto dto) {
		tableConfigurationMenuDto.setTableButtonDto(dto);
		BindUtils.postNotifyChange(null, null, MasterConfigurasiMenuVmd.this, "tableConfigurationMenuDto");
	}

	@SuppressWarnings("unchecked")
	protected void detectQuestionMessageBox() {
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show("Data Berhasil Disimpan, Apakah Anda Masih Ingin Mengisi Form Lagi? ", "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
							if(groupPageInfoForm) {
							refresh();
							refreshListAll();
							}
							else if(groupRefactorInfoForm){
								if(isSaatAktivasi()) {
									refresh();
									aktivasi();
								}
								else if (isSaatNonAktivasi()){
									refresh();
									nonaktiv();
								}
							}
						} else {
							if(groupPageInfoForm){
							getCompleteGroupPageInfoForm(false, false, false, LOCALE.L007.getMessage());
							refresh();
							refreshListAll();
							}
							else if(groupRefactorInfoForm) {
								refresh();
								refreshListAll();
								getCompleteGroupPageRefactorForm(false, false,"");
							}
						}
					}
				}, params);
	}

	@SuppressWarnings("unchecked")
	protected void detectQuestionMessageBox2() {
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(" Apakah Anda Ingin Keluar Dari Form Ini? ", "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
							if(groupPageInfoForm){
							getCompleteGroupPageInfoForm(false, false, false, "");
							}
							if(groupRefactorInfoForm) {
								getCompleteGroupPageRefactorForm(false, false,"");
							}
							refresh();
							refreshListAll();
							
						} else {
							return;
						}
					}
				}, params);
	}

	@SuppressWarnings("unchecked")
	protected void detectQuestionMessageBox3(String message) {
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(message, "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
							if (isSaatTambah()) {
								tableConfigurationMenuDto.setStatus("1");
								tableConfigurationMenuDto.setCreatedDate(new Date());
								tableConfigurationMenuDto.setProjekCode(getCurrentProjek());
								tableConfigurationMenuDto.setCreatedBy(getCurrentEmployeId());
								tableConfigurationMenuDto
										.setMenuButton(tableConfigurationMenuDto.getTableButtonDto().getButtonCode());
								Map<String, Object> mapp = CallRequestMappingJava("/MasterConfigurasiMenu/Save",
										tableConfigurationMenuDto, "POST");
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
							else if(isSaatAktivasi()){
								Map<String, Object> mapp = CallRequestMappingJava("/MasterConfigurasiMenu/Aktivasi",
										selectedTableConfigurationMenuDtosForDetail, "POST",
										"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
							else if(isSaatNonAktivasi()){
								Map<String, Object> mapp = CallRequestMappingJava("/MasterConfigurasiMenu/NonAktivasi",
										selectedTableConfigurationMenuDtosForDetail, "POST",
										"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
							else if (isSaatHapus()) {
								Map<String, Object> mapp = CallRequestMappingJava("/MasterConfigurasiMenu/delete",
										tableConfigurationMenuDto, "POST");
									String result = (String) mapp.get("result");
									showInformationMessageBox(result);
									setSaatHapus(false);
									BindUtils.postNotifyChange(null, null, this, "saatHapus");
									refresh();
									refreshListAll();
							}
						} else {
							return;
						}
					}
				}, params);
	}

	
	// bagian detail --end

	public List<TableConfigurationMenuDto> getTableConfigurationMenuDtos() {
		return tableConfigurationMenuDtos;
	}

	public void setTableConfigurationMenuDtos(List<TableConfigurationMenuDto> tableConfigurationMenuDtos) {
		this.tableConfigurationMenuDtos = tableConfigurationMenuDtos;
	}

	public TableConfigurationMenuDto getTableConfigurationMenuDto() {
		return tableConfigurationMenuDto;
	}

	public void setTableConfigurationMenuDto(TableConfigurationMenuDto tableConfigurationMenuDto) {
		this.tableConfigurationMenuDto = tableConfigurationMenuDto;
	}

	

	public TableButtonDto getTableButtonDto() {
		return tableButtonDto;
	}

	public void setTableButtonDto(TableButtonDto tableButtonDto) {
		this.tableButtonDto = tableButtonDto;
	}

	public List<String> getFilters() {
		return filters;
	}

	public void setFilters(List<String> filters) {
		this.filters = filters;
	}

	public boolean isOnFilter() {
		return onFilter;
	}

	public void setOnFilter(boolean onFilter) {
		this.onFilter = onFilter;
	}

	public TableConfigurationMenuDto getFilterTableConfigurationMenuDto() {
		return filterTableConfigurationMenuDto;
	}

	public void setFilterTableConfigurationMenuDto(TableConfigurationMenuDto filterTableConfigurationMenuDto) {
		this.filterTableConfigurationMenuDto = filterTableConfigurationMenuDto;
	}

	public String getFilterTitle() {
		return filterTitle;
	}

	public void setFilterTitle(String filterTitle) {
		this.filterTitle = filterTitle;
	}

	public TableConfigurationMenuDto getTempFilterTableConfigurationMenuDto() {
		return tempFilterTableConfigurationMenuDto;
	}

	public void setTempFilterTableConfigurationMenuDto(TableConfigurationMenuDto tempFilterTableConfigurationMenuDto) {
		this.tempFilterTableConfigurationMenuDto = tempFilterTableConfigurationMenuDto;
	}

	public List<TableConfigurationMenuDto> getTableConfigurationMenuDtosForDetail() {
		return tableConfigurationMenuDtosForDetail;
	}

	public void setTableConfigurationMenuDtosForDetail(
			List<TableConfigurationMenuDto> tableConfigurationMenuDtosForDetail) {
		this.tableConfigurationMenuDtosForDetail = tableConfigurationMenuDtosForDetail;
	}

	public List<TableConfigurationMenuDto> getSelectedTableConfigurationMenuDtosForDetail() {
		return selectedTableConfigurationMenuDtosForDetail;
	}

	public void setSelectedTableConfigurationMenuDtosForDetail(
			List<TableConfigurationMenuDto> selectedTableConfigurationMenuDtosForDetail) {
		this.selectedTableConfigurationMenuDtosForDetail = selectedTableConfigurationMenuDtosForDetail;
	}

    
}
