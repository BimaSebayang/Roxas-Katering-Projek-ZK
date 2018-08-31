package vmd.Transaksi.Regristrasi;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Messagebox.Button;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MasterSchemaDto.TableMasterKotaDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProvinsiDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import Source.LocaleSource.LOCALE;
import Source.MessageSource.WARNING;

@Init(superclass = true)
public class PelangganManualVmd extends BaseVmdMenu implements Serializable  {
	private static final long serialVersionUID = 1L;
    private List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtos = new ArrayList<>();
    private TableMasterPelangganKateringDto tableMasterPelangganKateringDto = new TableMasterPelangganKateringDto();
    
    //bagian filter --start
    private TableMasterPelangganKateringDto filterTableMasterPelangganKateringDto = new TableMasterPelangganKateringDto();
    private TableMasterPelangganKateringDto tempFilterTableMasterPelangganKateringDto = new TableMasterPelangganKateringDto();
    private List<Object> filters = new ArrayList<>();
    private String filterTitle = new String();
    //bagian filter --end
    
    //bagian form refactor --start
    private List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtosForDetail = new ArrayList<>();
    private List<TableMasterPelangganKateringDto> selectedTableMasterPelangganKateringDtosForDetail = new ArrayList<>(); 
    //bagian form refactor --end
    
    //bagian combobox --start
    private List<TableMasterProvinsiDto> tableMasterProvinsiDtos = new ArrayList<>();
    private TableMasterProvinsiDto tableMasterProvinsiDto = new TableMasterProvinsiDto();
    private List<TableMasterKotaDto> tableMasterKotaDtos = new ArrayList<>();
    private TableMasterKotaDto tableMasterKotaDto = new TableMasterKotaDto();
    //bagian combobox --end
    
	private boolean onFilter = false;
	
	@Command
	public void sliceSorter(@BindingParam("exec") String exec, @ContextParam(ContextType.BIND_CONTEXT) BindContext ctx){
		setSortingList(ctx,exec);
		slicePaging();
	}
	
	@Command
	public void slicePaging(){
	    searchOrClick();
	}


	@Command("selectBox")
	public void comboboxTrigger(@BindingParam("box") String box) {
		if(box.equalsIgnoreCase("KOTA")) {
		Map<String, Object> mapRequestKota = new HashMap<>();
		Map<String, Object> objKirimKota  = new HashMap<>();
		if(tableMasterProvinsiDto.getKodeProvinsi()==null){
		objKirimKota.put("kodeProvinsi", "");
		}
		else {
			objKirimKota.put("kodeProvinsi", tableMasterProvinsiDto.getKodeProvinsi());
		}
		mapRequestKota = CallRequestMappingJava("/GlobalVariable/getKota",
				objKirimKota, "POST");
		if (mapRequestKota.size() > 0) {
			tableMasterKotaDtos.clear();
			tableMasterKotaDtos = getJava().mapperJsonToListDto(mapRequestKota,
					new TypeToken<ArrayList<TableMasterKotaDto>>() {
					}.getType(), tableMasterKotaDtos, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableMasterKotaDtos");
		}
		else if(box.equalsIgnoreCase("provinsi")) {
		Map<String, Object> mapRequestProvinsi = new HashMap<>();
		Map<String, Object> objKirimProvinsi  = new HashMap<>();
		if(tableMasterKotaDto.getKodeKota()==null) {
		objKirimProvinsi.put("kodeKota", "");
		}
		else {
			objKirimProvinsi.put("kodeKota", tableMasterKotaDto.getKodeKota());
		}
		mapRequestProvinsi =  CallRequestMappingJava("/GlobalVariable/getProvinsi",
				objKirimProvinsi,"POST");
		if (mapRequestProvinsi.size() > 0) {
			tableMasterProvinsiDtos.clear();
			tableMasterProvinsiDtos = getJava().mapperJsonToListDto(mapRequestProvinsi,
					new TypeToken<ArrayList<TableMasterProvinsiDto>>() {
					}.getType(), tableMasterProvinsiDtos, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableMasterProvinsiDtos");
	   }
	}
	@Command
	public void searchOrClick() {
		initIndex();
	}

	@Command
	public void okFilter(@BindingParam("fold") String fold) {
		initIndex();
		setOnFilter(false);
		BindUtils.postNotifyChange(null, null, this, "onFilter");
	}
	
	@Command
	public void filter(@BindingParam("exec") String exec) {
		setFilterTitle("FILTER : " + exec);
		setOnFilter(true);
		TableMasterPelangganKateringDto  filterConfig = new TableMasterPelangganKateringDto();
		
		if(exec.equalsIgnoreCase("KODE PELANGGAN")) {
		List<String> resultA = new ArrayList<>();
		Map<String, Object> mapRequestA = new HashMap<>();
		mapRequestA = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter",
				"KODE PELANGGAN");
		if (mapRequestA.size() > 0) {
			resultA = getJava().mapperJsonToListDto(mapRequestA, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultA, "contents");
			filterConfig.setKodePelanggans(resultA);
		}
		}
		
		if(exec.equalsIgnoreCase("NAMA PELANGGAN")) {
		List<String> resultB = new ArrayList<>();
		Map<String, Object> mapRequestB = new HashMap<>();
		mapRequestB = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "NAMA PELANGGAN");
		if (mapRequestB.size() > 0) {
			resultB = getJava().mapperJsonToListDto(mapRequestB, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultB, "contents");
			filterConfig.setNamaPelanggans(resultB);
		}
		}

		if(exec.equalsIgnoreCase("TOTAL PESANAN TERAKHIR")) {
		List<BigDecimal> resultC = new ArrayList<>();
		Map<String, Object> mapRequestC = new HashMap<>();
		mapRequestC = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "TOTAL PESANAN TERAKHIR");
		if (mapRequestC.size() > 0) {
			resultC = getJava().mapperJsonToListDto(mapRequestC, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultC, "contents");
			filterConfig.setBanyakPesanans(resultC);
		}
		}
		
		if(exec.equalsIgnoreCase("STATUS PELANGGAN")) {
		List<String> resultD = new ArrayList<>();
		Map<String, Object> mapRequestD = new HashMap<>();
		mapRequestD  = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "STATUS PELANGGAN");
		if (mapRequestD.size() > 0) {
			resultD = getJava().mapperJsonToListDto(mapRequestD , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultD, "contents");
			filterConfig.setStatusPelanggans(resultD);
		}
		}
		
		
		if(exec.equalsIgnoreCase("STATUS PERSETUJUAN")) {
		List<String> resultE = new ArrayList<>();
		Map<String, Object> mapRequestE = new HashMap<>();
		mapRequestE  = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "STATUS PERSETUJUAN");
		if (mapRequestE.size() > 0) {
			resultE = getJava().mapperJsonToListDto(mapRequestE , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultE, "contents");
			filterConfig.setStatusPersetujans(resultE);
		}
		}
		
		if(exec.equalsIgnoreCase("KOMPOSISI PESANAN")) {
		List<BigDecimal> resultF = new ArrayList<>();
		Map<String, Object> mapRequestF = new HashMap<>();
		mapRequestF  = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "KOMPOSISI PESANAN");
		if (mapRequestF.size() > 0) {
			resultF = getJava().mapperJsonToListDto(mapRequestF , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultF, "contents");
			filterConfig.setKomposisiPesanans(resultF);
		}
		}
		
		filterTableMasterPelangganKateringDto = filterConfig;
		BindUtils.postNotifyChange(null, null, this, "filterTitle");
		BindUtils.postNotifyChange(null, null, this, "onFilter");
		BindUtils.postNotifyChange(null, null, this, "filterTableMasterPelangganKateringDto");
	}
	
	public void initIndex() {
		initBackground();
		Map<String, Object> mapRequest = new HashMap<>();
		mapRequest = CallRequestMappingJavaForIndex("/PelangganManual/GetAllExistingData",
				tempFilterTableMasterPelangganKateringDto);
		if (mapRequest.size() > 0) {
			tableMasterPelangganKateringDtos.clear();
			tableMasterPelangganKateringDtos = getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableMasterPelangganKateringDto>>() {
					}.getType(), tableMasterPelangganKateringDtos, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableMasterPelangganKateringDtos");
	}

	
	public TableMasterPelangganKateringDto allFilterTableMasterPelangganKateringDto() {
		TableMasterPelangganKateringDto  filterConfig = new TableMasterPelangganKateringDto();

		List<String> resultA = new ArrayList<>();
		Map<String, Object> mapRequestA = new HashMap<>();
		mapRequestA = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter",
				"KODE PELANGGAN");
		if (mapRequestA.size() > 0) {
			resultA = getJava().mapperJsonToListDto(mapRequestA, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultA, "contents");
			filterConfig.setKodePelanggans(resultA);;
		}

		List<String> resultB = new ArrayList<>();
		Map<String, Object> mapRequestB = new HashMap<>();
		mapRequestB = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "NAMA PELANGGAN");
		if (mapRequestB.size() > 0) {
			resultB = getJava().mapperJsonToListDto(mapRequestB, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultB, "contents");
			filterConfig.setNamaPelanggans(resultB);
		}

		List<BigDecimal> resultC = new ArrayList<>();
		Map<String, Object> mapRequestC = new HashMap<>();
		mapRequestC = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "TOTAL PESANAN TERAKHIR");
		if (mapRequestC.size() > 0) {
			resultC = getJava().mapperJsonToListDto(mapRequestC, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultC, "contents");
			filterConfig.setBanyakPesanans(resultC);
		}

		List<String> resultD = new ArrayList<>();
		Map<String, Object> mapRequestD = new HashMap<>();
		mapRequestD  = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "STATUS PELANGGAN");
		if (mapRequestD.size() > 0) {
			resultD = getJava().mapperJsonToListDto(mapRequestD , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultD, "contents");
			filterConfig.setStatusPelanggans(resultD);
		}

		
		List<String> resultE = new ArrayList<>();
		Map<String, Object> mapRequestE = new HashMap<>();
		mapRequestE  = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "STATUS PERSETUJUAN");
		if (mapRequestE.size() > 0) {
			resultE = getJava().mapperJsonToListDto(mapRequestE , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultE, "contents");
			filterConfig.setStatusPersetujans(resultE);
		}
		
		List<BigDecimal> resultF = new ArrayList<>();
		Map<String, Object> mapRequestF = new HashMap<>();
		mapRequestF  = CallRequestMappingJavaForFilter("/PelangganManual/GetAllExistingFilter", "KOMPOSISI PESANAN");
		if (mapRequestF.size() > 0) {
			resultF = getJava().mapperJsonToListDto(mapRequestF , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultF, "contents");
			filterConfig.setKomposisiPesanans(resultF);
		}
		
		return filterConfig;
	}
	
	public void initTemporary() {
		tempFilterTableMasterPelangganKateringDto = allFilterTableMasterPelangganKateringDto();
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
			 //aktivasi();
		} else if (buttonName.equals("nonaktiv")) {
			 //nonaktiv();
		} else if (buttonName.equals("lihat")) {
			lihat();
		} else if (buttonName.equals("edit")) {
			edit();
		} else if (buttonName.equals("kirim")) {
			kirim();
		} else {
			Messagebox.show("button belum bisa dipakai");
		}
	}
	
	public void kirim() {
		if( tableMasterPelangganKateringDto.getKodePelanggan() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		if( tableMasterPelangganKateringDto.getStatusAktif() != 1 || !tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("OPEN")) {
			showWarningMessageBox(WARNING.W006.getMessage());
			return;
		}
		setSaatKirim(true);
		BindUtils.postNotifyChange(null, null, this, "saatKirim");
		detectQuestionForSend();
	}
	
	public void hapus() {
		
		if( tableMasterPelangganKateringDto.getKodePelanggan() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		if( !tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("REJE") && !tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("OPEN")) {
			showWarningMessageBox(WARNING.W007.getMessage());
			return;
		}
		
		setSaatHapus(true);
		BindUtils.postNotifyChange(null, null, this, "saatHapus");
		detectQuestionMessageBox3("Apakah Anda Ingin Menghapus Data Ini ? ");
		
	}
	
	public void edit() {
		if( tableMasterPelangganKateringDto.getKodePelanggan() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		
		if( !tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("REVS") && !tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("OPEN")) {
			showWarningMessageBox(WARNING.W005.getMessage());
			return;
		}
		
		if(tableMasterPelangganKateringDto.getTipePelanggan().equalsIgnoreCase("M")) {
			tableMasterPelangganKateringDto.setTipePelanggan("MANUAL");
		}
		
	    String[] splitter = tableMasterPelangganKateringDto.getAlamatPelanggan().split("%");
		
			tableMasterPelangganKateringDto.setInformasiAlamat(splitter[0]);
			TableMasterKotaDto dto = new TableMasterKotaDto();
			dto.setNamaKota(splitter[2]);
			tableMasterKotaDto = dto;
			TableMasterProvinsiDto pto = new TableMasterProvinsiDto();
			pto.setNamaProvinsi(splitter[4]);
			tableMasterProvinsiDto = pto;
			BindUtils.postNotifyChange(null, null, this, "tableMasterKotaDto");
			BindUtils.postNotifyChange(null, null, this, "tableMasterProvinsiDto");
		
		BindUtils.postNotifyChange(null, null, this, "tableMasterPelangganKateringDto");
		
		getCompleteGroupPageInfoForm(false, false, true, LOCALE.L007.getMessage());
	}
	
	public void lihat() {
		if( tableMasterPelangganKateringDto.getKodePelanggan() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		
		if(tableMasterPelangganKateringDto.getTipePelanggan().equalsIgnoreCase("M")) {
			tableMasterPelangganKateringDto.setTipePelanggan("MANUAL");
		}
		
		String[] splitter = tableMasterPelangganKateringDto.getAlamatPelanggan().split("%");
		
		tableMasterPelangganKateringDto.setInformasiAlamat(splitter[0]);
		TableMasterKotaDto dto = new TableMasterKotaDto();
		dto.setNamaKota(splitter[2]);
		tableMasterKotaDto = dto;
		TableMasterProvinsiDto pto = new TableMasterProvinsiDto();
		pto.setNamaProvinsi(splitter[4]);
		tableMasterProvinsiDto = pto;
		BindUtils.postNotifyChange(null, null, this, "tableMasterKotaDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProvinsiDto");
		
		BindUtils.postNotifyChange(null, null, this, "tableMasterPelangganKateringDto");
		getCompleteGroupPageInfoForm(false, true, false, LOCALE.L011.getMessage());
	}
	
	public void tambah() {
		getCompleteGroupPageInfoForm(true, false, false, LOCALE.L007.getMessage());
	}
	
	@Command("saveForm")
	public void onSaveForm() {
		//Messagebox.show("TESTING CUYY");
		detectQuestionMessageBox3(" Apakah Anda Ingin Menyimpan Data Ini? ");
	}
	@SuppressWarnings("unchecked")
	protected void detectQuestionMessageBox() {
		String mess ="";
		if(isSaatTambah()) {
			mess = "Data Berhasil Disimpan, Apakah Anda Masih Ingin Mengisi Form Lagi? ";
		}
		else if(isSaatEdit()) {
			mess = "Data Berhasil Disimpan, Apakah Anda Masih Ingin Mengubah Data Ini? ";
		}
		else if(isSaatAktivasi()) {
			mess = "Data Berhasil Disimpan, Apakah Anda Masih Ingin Melakukan Aktivasi Data Lagi? ";
		}
		else if(isSaatNonAktivasi()) {
			mess = "Data Berhasil Disimpan, Apakah Anda Masih Ingin Melakukan Non-Aktivasi Data Lagi? ";
		}
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(mess, "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
							if(groupPageInfoForm) {
							if(isSaatTambah()) {	
							refresh();
							refreshListAll();
							}
							else if(isSaatEdit()){
								return;
							}
							}
							else if(groupRefactorInfoForm){
								if(isSaatAktivasi()) {
									refresh();
									//aktivasi();
								}
								else if (isSaatNonAktivasi()){
									refresh();
									//nonaktiv();
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
	protected void detectQuestionForSend() {
		Map<String, String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show("Apakah Anda Ingin Mengirim Data Ini ? ", "Konfirmasi",
				new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
					@Override
					public void onEvent(Event evt) throws Exception {
						if (evt.getName().equals("onOK")) {
		    tableMasterPelangganKateringDto.setUpdatedBy(getCurrentEmployeId());
		    tableMasterPelangganKateringDto.setUpdatedDate(new Date());
		    tableMasterPelangganKateringDto.setStatusApproval("APPR");
		    Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/send",
		    tableMasterPelangganKateringDto, "POST","messageId="+tableMasterPelangganKateringDto.getMessageId());
			String result = (String) mapp.get("result");
			showInformationMessageBox(result);
			setSaatKirim(false);
			BindUtils.postNotifyChange(null, null, this, "saatKirim");
			refresh();
			refreshListAll();
						}
						else {
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
								tableMasterPelangganKateringDto.setTipePelanggan("M");
								tableMasterPelangganKateringDto.setCreatedDate(new Date());
								tableMasterPelangganKateringDto.setCreatedBy(getCurrentEmployeId());
								String perfectAddress = tableMasterPelangganKateringDto.getInformasiAlamat() + "%KOTA%"+tableMasterKotaDto.getNamaKota() +
										"%PROVINSI%" + tableMasterProvinsiDto.getNamaProvinsi();
								tableMasterPelangganKateringDto.setAlamatPelanggan(perfectAddress);
								tableMasterPelangganKateringDto.setStatusAktif(1);
								tableMasterPelangganKateringDto.setStatusApproval("OPEN");
								tableMasterPelangganKateringDto.setProjekCode(getCurrentProjek());
								Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/Save",
										tableMasterPelangganKateringDto, "POST");
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
							else if(isSaatEdit()){
								String perfectAddress = tableMasterPelangganKateringDto.getInformasiAlamat() + "%KOTA%"+tableMasterKotaDto.getNamaKota() +
										"%PROVINSI%" + tableMasterProvinsiDto.getNamaProvinsi();
								tableMasterPelangganKateringDto.setAlamatPelanggan(perfectAddress);
								tableMasterPelangganKateringDto.setUpdatedBy(getCurrentEmployeId());
								tableMasterPelangganKateringDto.setUpdatedDate(new Date());
								tableMasterPelangganKateringDto.setStatusApproval("OPEN");
								if(tableMasterPelangganKateringDto.getTipePelanggan().equalsIgnoreCase("MANUAL")) {
									tableMasterPelangganKateringDto.setTipePelanggan("M");
								}
								Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/Save",
										tableMasterPelangganKateringDto, "POST");
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
//							else if(isSaatAktivasi()){
//								Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/Aktivasi",
//										selectedTableConfigurationMenuDtosForDetail, "POST",
//										"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
//								if ((boolean) mapp.get("valid")) {
//									String result = (String) mapp.get("result");
//									detectQuestionMessageBox();
//								}
//							}
//							else if(isSaatNonAktivasi()){
//								Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/NonAktivasi",
//										selectedTableConfigurationMenuDtosForDetail, "POST",
//										"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
//								if ((boolean) mapp.get("valid")) {
//									String result = (String) mapp.get("result");
//									detectQuestionMessageBox();
//								}
//							}
							else if (isSaatHapus()) {
								tableMasterPelangganKateringDto.setUpdatedBy(getCurrentEmployeId());
								tableMasterPelangganKateringDto.setUpdatedDate(new Date());
								Map<String, Object> mapp = CallRequestMappingJava("/PelangganManual/delete",
										tableMasterPelangganKateringDto, "POST");
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

	
	@Command("backForm")
	public void onBackForm() {
		detectQuestionMessageBox2();
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
	
	public void refresh() {
		initIndex();
		tableMasterProvinsiDto = new TableMasterProvinsiDto();
		tableMasterKotaDto = new TableMasterKotaDto();
		tableMasterPelangganKateringDtosForDetail = new ArrayList<>();
		selectedTableMasterPelangganKateringDtosForDetail = new ArrayList<>();
		tableMasterPelangganKateringDto= new TableMasterPelangganKateringDto();
		BindUtils.postNotifyChange(null, null, this, "tableMasterProvinsiDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterKotaDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterPelangganKateringDtosForDetail");
		BindUtils.postNotifyChange(null, null, this, "selectedTableMasterPelangganKateringDtosForDetail");
		BindUtils.postNotifyChange(null, null, this, "tableMasterPelangganKateringDto");
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
	

	public List<TableMasterPelangganKateringDto> getTableMasterPelangganKateringDtos() {
		return tableMasterPelangganKateringDtos;
	}
	public void setTableMasterPelangganKateringDtos(
			List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtos) {
		this.tableMasterPelangganKateringDtos = tableMasterPelangganKateringDtos;
	}
	public TableMasterPelangganKateringDto getTableMasterPelangganKateringDto() {
		return tableMasterPelangganKateringDto;
	}
	public void setTableMasterPelangganKateringDto(TableMasterPelangganKateringDto tableMasterPelangganKateringDto) {
		this.tableMasterPelangganKateringDto = tableMasterPelangganKateringDto;
	}
	public TableMasterPelangganKateringDto getFilterTableMasterPelangganKateringDto() {
		return filterTableMasterPelangganKateringDto;
	}
	public void setFilterTableMasterPelangganKateringDto(
			TableMasterPelangganKateringDto filterTableMasterPelangganKateringDto) {
		this.filterTableMasterPelangganKateringDto = filterTableMasterPelangganKateringDto;
	}
	public TableMasterPelangganKateringDto getTempFilterTableMasterPelangganKateringDto() {
		return tempFilterTableMasterPelangganKateringDto;
	}
	public void setTempFilterTableMasterPelangganKateringDto(
			TableMasterPelangganKateringDto tempFilterTableMasterPelangganKateringDto) {
		this.tempFilterTableMasterPelangganKateringDto = tempFilterTableMasterPelangganKateringDto;
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
	public List<TableMasterPelangganKateringDto> getTableMasterPelangganKateringDtosForDetail() {
		return tableMasterPelangganKateringDtosForDetail;
	}
	public void setTableMasterPelangganKateringDtosForDetail(
			List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtosForDetail) {
		this.tableMasterPelangganKateringDtosForDetail = tableMasterPelangganKateringDtosForDetail;
	}
	public List<TableMasterPelangganKateringDto> getSelectedTableMasterPelangganKateringDtosForDetail() {
		return selectedTableMasterPelangganKateringDtosForDetail;
	}
	public void setSelectedTableMasterPelangganKateringDtosForDetail(
			List<TableMasterPelangganKateringDto> selectedTableMasterPelangganKateringDtosForDetail) {
		this.selectedTableMasterPelangganKateringDtosForDetail = selectedTableMasterPelangganKateringDtosForDetail;
	}
	
	public boolean isOnFilter() {
		return onFilter;
	}
	public void setOnFilter(boolean onFilter) {
		this.onFilter = onFilter;
	}

	public List<TableMasterProvinsiDto> getTableMasterProvinsiDtos() {
		return tableMasterProvinsiDtos;
	}

	public void setTableMasterProvinsiDtos(List<TableMasterProvinsiDto> tableMasterProvinsiDtos) {
		this.tableMasterProvinsiDtos = tableMasterProvinsiDtos;
	}

	public List<TableMasterKotaDto> getTableMasterKotaDtos() {
		return tableMasterKotaDtos;
	}

	public void setTableMasterKotaDtos(List<TableMasterKotaDto> tableMasterKotaDtos) {
		this.tableMasterKotaDtos = tableMasterKotaDtos;
	}
	public TableMasterProvinsiDto getTableMasterProvinsiDto() {
		return tableMasterProvinsiDto;
	}
	public void setTableMasterProvinsiDto(TableMasterProvinsiDto tableMasterProvinsiDto) {
		this.tableMasterProvinsiDto = tableMasterProvinsiDto;
	}
	public TableMasterKotaDto getTableMasterKotaDto() {
		return tableMasterKotaDto;
	}
	public void setTableMasterKotaDto(TableMasterKotaDto tableMasterKotaDto) {
		this.tableMasterKotaDto = tableMasterKotaDto;
	}
    
}
