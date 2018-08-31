package vmd.Transaksi.ImageMap;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.impl.ChildrenBindingImpl;
import org.zkoss.image.encoder.JPEGEncoder;
import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Messagebox.ClickEvent;

import com.google.gson.reflect.TypeToken;

import Base.Menu.BaseVmdMenu;
import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterKotaDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProvinsiDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import Master.SharingInformation.ImageCaptureDto;
import Source.LocaleSource.LOCALE;
import Source.MessageSource.ERROR;
import Source.MessageSource.WARNING;
import vmd.Transaksi.Regristrasi.MasterConfigurasiMenuVmd;

@Init(superclass = true)
public class MasterPemetaanProsedurFormVmd extends BaseVmdMenu implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected float coorX = 0;
	protected float coorY = 0;
	protected boolean coorVisible = false;
	protected List<byte[]> historyOverLay = new ArrayList<>();
	protected int countHistory = 0;
	protected byte[] parentsPic;
	protected byte[] childrenPic;
	protected Map<String, byte[]> mapChildLocks = new HashMap<>();
	protected Map<String, byte[]> mapProsesLocks = new HashMap<>();
	protected List<String> listChildLock = new ArrayList<>();
	protected String selectedItem;
	protected byte[] initPic;
	protected ImageCaptureDto imageInitPic;
	protected ImageCaptureDto imageParentsPic;
	protected List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDtos = new ArrayList<>();
	protected TableMasterProsedurformDtlDto tableMasterProsedurformDtlDto = new TableMasterProsedurformDtlDto();
	protected List<TableMasterProsedurformHdrDto> tableMasterProsedurformHdrDtos = new ArrayList<>();
	protected TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
    
	
	// start filter
	public int sequenceNo = 1;
	protected TableMasterProsedurformHdrDto filterTableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
	protected TableMasterProsedurformHdrDto tempFilterTableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
	protected List<Object> filters = new ArrayList<>();
	protected String filterTitle = new String();
	protected String detailName = new String();
	// bagian filter --end

	// CRUD --start
	protected Map<Integer, byte[]> historyPin = new HashMap<>();
	protected boolean onPemetaanProsedur = false;
	protected boolean onFilledName = false;
	protected List<String> prosedurNames = new ArrayList<>();
	protected List<String> detailNames = new ArrayList<>();
	// CRUD --end

	protected boolean onFilter = false;

	@Command
	public void slicePaging(){
	    searchOrClick();
	}

	@Command
	public void sliceSorter(@BindingParam("exec") String exec, @ContextParam(ContextType.BIND_CONTEXT) BindContext ctx){
		setSortingList(ctx,exec);
		slicePaging();
	}
	
	public void collectAllUsableName() {
		Map<String,Object> map = CallRequestMappingJava("/MasterPemetaanProsedurForm/collectName", getCurrentProjek(), "POST");
		prosedurNames = getJava().mapperJsonToListDto(map,
				new TypeToken<ArrayList<String>>() {
				}.getType(), prosedurNames, "contextProsedur");
		detailNames = getJava().mapperJsonToListDto(map,
				new TypeToken<ArrayList<String>>() {
				}.getType(), detailNames, "contextDetail");
	}	
	
	@Command("addProsedur")
	public void addProsedur() {
		setOnPemetaanProsedur(true);
		UndoUpload();
		BindUtils.postNotifyChange(null, null, this, "onPemetaanProsedur");
	}

	@Command
	public void filter(@BindingParam("exec") String exec) {
		setFilterTitle("FILTER : " + exec);
		setOnFilter(true);
		TableMasterProsedurformHdrDto  filterConfig = new TableMasterProsedurformHdrDto();
		
		if(exec.equalsIgnoreCase("ID PROSEDUR")) {
		List<String> resultA = new ArrayList<>();
		Map<String, Object> mapRequestA = new HashMap<>();
		mapRequestA = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter",
				"ID PROSEDUR");
		if (mapRequestA.size() > 0) {
			resultA = getJava().mapperJsonToListDto(mapRequestA, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultA, "contents");
			filterConfig.setProsedurIds(resultA);
		}
		}
		
		if(exec.equalsIgnoreCase("NAMA PROSEDUR")) {
		List<String> resultB = new ArrayList<>();
		Map<String, Object> mapRequestB = new HashMap<>();
		mapRequestB = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "NAMA PROSEDUR");
		if (mapRequestB.size() > 0) {
			resultB = getJava().mapperJsonToListDto(mapRequestB, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultB, "contents");
			filterConfig.setProsedurNames(resultB);
		}
		}

		if(exec.equalsIgnoreCase("MENU REFERENSI")) {
		List<String> resultC = new ArrayList<>();
		Map<String, Object> mapRequestC = new HashMap<>();
		mapRequestC = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "MENU REFERENSI");
		if (mapRequestC.size() > 0) {
			resultC = getJava().mapperJsonToListDto(mapRequestC, new TypeToken<ArrayList<Object>>() {
			}.getType(), resultC, "contents");
			filterConfig.setMenuReferensis(resultC);
		}
		}
		
		if(exec.equalsIgnoreCase("JUMLAH PROSEDUR")) {
		List<BigDecimal> resultD = new ArrayList<>();
		Map<String, Object> mapRequestD = new HashMap<>();
		mapRequestD  = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "JUMLAH PROSEDUR");
		if (mapRequestD.size() > 0) {
			resultD = getJava().mapperJsonToListDto(mapRequestD , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultD, "contents");
			filterConfig.setTotalProsedurs(resultD);
		}
		}
		
		
		if(exec.equalsIgnoreCase("STATUS PERSETUJUAN")) {
		List<String> resultE = new ArrayList<>();
		Map<String, Object> mapRequestE = new HashMap<>();
		mapRequestE  = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "STATUS PERSETUJUAN");
		if (mapRequestE.size() > 0) {
			resultE = getJava().mapperJsonToListDto(mapRequestE , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultE, "contents");
			filterConfig.setStatusPersetujuans(resultE);
		}
		}
		
		if(exec.equalsIgnoreCase("STATUS PROSEDUR")) {
		List<String> resultF = new ArrayList<>();
		Map<String, Object> mapRequestF = new HashMap<>();
		mapRequestF  = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "STATUS PROSEDUR");
		if (mapRequestF.size() > 0) {
			resultF = getJava().mapperJsonToListDto(mapRequestF , new TypeToken<ArrayList<Object>>() {
			}.getType(), resultF, "contents");
			filterConfig.setStatusProsedurs(resultF);
		}
		}
		
		filterTableMasterProsedurformHdrDto = filterConfig;
		BindUtils.postNotifyChange(null, null, this, "filterTitle");
		BindUtils.postNotifyChange(null, null, this, "onFilter");
		BindUtils.postNotifyChange(null, null, this, "filterTableMasterProsedurformHdrDto");
	}
	
	public void edit() {
		if( tableMasterProsedurformHdrDto.getProsedurId() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		
		if( !tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("REVS") && !tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("OPEN")) {
			showWarningMessageBox(WARNING.W005.getMessage());
			return;
		}
		
		for (TableMasterProsedurformDtlDto dtl : tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos()) {
			TableMasterProsedurformDtlDto dto = dtl;
			String[] splitterUri = dtl.getUrlDetailPicture().split("/");
			String uri = "/";
			String titleFile = splitterUri[splitterUri.length-1];
			for(int i = 0; i<splitterUri.length ; i++ ) {
				if(i!=(splitterUri.length-1)) {
					uri += splitterUri[i]+"/";
				}
			}
			//Messagebox.show("uri " + uri + " titleFile " + titleFile);
			byte[] detailGambar = getTheFile(uri, titleFile, "jpg");
			dto.setDetailGambar(detailGambar);
			tableMasterProsedurformDtlDtos.add(dto);
		}
		
		sequenceNo = tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos().size()+1;
		
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformHdrDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformDtlDtos");
		BindUtils.postNotifyChange(null, null, this, "sequenceNo");
		
		getCompleteGroupPageInfoForm(false, false, true, LOCALE.L007.getMessage());
	}
	
	public TableMasterProsedurformHdrDto allFilterTableMasterProsedurformHdrDto() {
		TableMasterProsedurformHdrDto filterConfig = new TableMasterProsedurformHdrDto();

			List<String> resultA = new ArrayList<>();
			Map<String, Object> mapRequestA = new HashMap<>();
			mapRequestA = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter",
					"ID PROSEDUR");
			if (mapRequestA.size() > 0) {
				resultA = getJava().mapperJsonToListDto(mapRequestA, new TypeToken<ArrayList<Object>>() {
				}.getType(), resultA, "contents");
				filterConfig.setProsedurIds(resultA);
			}
			
			
			List<String> resultB = new ArrayList<>();
			Map<String, Object> mapRequestB = new HashMap<>();
			mapRequestB = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "NAMA PROSEDUR");
			if (mapRequestB.size() > 0) {
				resultB = getJava().mapperJsonToListDto(mapRequestB, new TypeToken<ArrayList<Object>>() {
				}.getType(), resultB, "contents");
				filterConfig.setProsedurNames(resultB);
			}
			

			List<String> resultC = new ArrayList<>();
			Map<String, Object> mapRequestC = new HashMap<>();
			mapRequestC = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "MENU REFERENSI");
			if (mapRequestC.size() > 0) {
				resultC = getJava().mapperJsonToListDto(mapRequestC, new TypeToken<ArrayList<Object>>() {
				}.getType(), resultC, "contents");
				filterConfig.setMenuReferensis(resultC);
			}
			
			
			List<BigDecimal> resultD = new ArrayList<>();
			Map<String, Object> mapRequestD = new HashMap<>();
			mapRequestD  = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "JUMLAH PROSEDUR");
			if (mapRequestD.size() > 0) {
				resultD = getJava().mapperJsonToListDto(mapRequestD , new TypeToken<ArrayList<Object>>() {
				}.getType(), resultD, "contents");
				filterConfig.setTotalProsedurs(resultD);
			}
			
			List<String> resultE = new ArrayList<>();
			Map<String, Object> mapRequestE = new HashMap<>();
			mapRequestE  = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "STATUS PERSETUJUAN");
			if (mapRequestE.size() > 0) {
				resultE = getJava().mapperJsonToListDto(mapRequestE , new TypeToken<ArrayList<Object>>() {
				}.getType(), resultE, "contents");
				filterConfig.setStatusPersetujuans(resultE);
			}
			
			
			List<String> resultF = new ArrayList<>();
			Map<String, Object> mapRequestF = new HashMap<>();
			mapRequestF  = CallRequestMappingJavaForFilter("/MasterPemetaanProsedurForm/GetAllExistingFilter", "STATUS PROSEDUR");
			if (mapRequestF.size() > 0) {
				resultF = getJava().mapperJsonToListDto(mapRequestF , new TypeToken<ArrayList<Object>>() {
				}.getType(), resultF, "contents");
				filterConfig.setStatusProsedurs(resultF);
			}
		
		return filterConfig;
	}
	
	public void initTemporary() {
		tempFilterTableMasterProsedurformHdrDto = allFilterTableMasterProsedurformHdrDto();
	}
	
	@Override
	public void loadListAll(TableMenuDto menu) {
		// TODO Auto-generated method stub
		initBackground();
		initTemporary();
		initIndex();
		loadAllChildLock();
		super.loadListAll(menu);
	}
	
	public void initIndex() {
		Map<String, Object> mapRequest = new HashMap<>();
		mapRequest = CallRequestMappingJavaForIndex("/MasterPemetaanProsedurForm/GetAllExistingData",
				tempFilterTableMasterProsedurformHdrDto);
		if (mapRequest.size() > 0) {
			tableMasterProsedurformHdrDtos.clear();
			tableMasterProsedurformHdrDtos = getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableMasterProsedurformHdrDto>>() {
					}.getType(), tableMasterProsedurformHdrDtos, "contents");
		} else {
			Messagebox.show("Data Tidak Ada");
		}
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformHdrDtos");
	}
	

	@Command("buttonCommand")
	public void allCommandButton(@BindingParam("buttonName") String buttonName) {
		if (buttonName.equals("tambah")) {
			tambah();
		} else if (buttonName.equals("hapus")) {
		    hapus();
		} else if (buttonName.equals("aktivasi")) {
			// aktivasi();
		} else if (buttonName.equals("nonaktiv")) {
			// nonaktiv();
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
	
public void hapus() {
		
		if( tableMasterProsedurformHdrDto.getProsedurId() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		if( !tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("REJE") && !tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("OPEN")) {
			showWarningMessageBox(WARNING.W007.getMessage());
			return;
		}
		
		setSaatHapus(true);
		BindUtils.postNotifyChange(null, null, this, "saatHapus");
		detectQuestionMessageBox3("Apakah Anda Ingin Menghapus Data Ini ? ");
		
	}
	
	public void kirim() {
		if( tableMasterProsedurformHdrDto.getProsedurId() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		if( tableMasterProsedurformHdrDto.getStatusAktif() != 1 || !tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("OPEN")) {
			showWarningMessageBox(WARNING.W006.getMessage());
			return;
		}
		setSaatKirim(true);
		BindUtils.postNotifyChange(null, null, this, "saatKirim");
		detectQuestionForSend();
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
							tableMasterProsedurformHdrDto.setUpdatedBy(getCurrentEmployeId());
							tableMasterProsedurformHdrDto.setUpdatedDate(new Date());
							tableMasterProsedurformHdrDto.setStatusApproval("APPR");
		    Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/send",
		    		tableMasterProsedurformHdrDto, "POST","messageId="+tableMasterProsedurformHdrDto.getMessageId());
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
	
	public void lihat() {
		if( tableMasterProsedurformHdrDto.getProsedurId() == null) {
			showWarningMessageBox(WARNING.W004.getMessage());
			return;
		}
		
		for (TableMasterProsedurformDtlDto dtl : tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos()) {
			TableMasterProsedurformDtlDto dto = dtl;
			String[] splitterUri = dtl.getUrlDetailPicture().split("/");
			String uri = "/";
			String titleFile = splitterUri[splitterUri.length-1];
			for(int i = 0; i<splitterUri.length ; i++ ) {
				if(i!=(splitterUri.length-1)) {
					uri += splitterUri[i]+"/";
				}
			}
			//Messagebox.show("uri " + uri + " titleFile " + titleFile);
			byte[] detailGambar = getTheFile(uri, titleFile, "jpg");
			dto.setDetailGambar(detailGambar);
			tableMasterProsedurformDtlDtos.add(dto);
		}
		
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformHdrDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformDtlDtos");
		getCompleteGroupPageInfoForm(false, true, false, LOCALE.L011.getMessage());
	}

	@Command("saveForm")
	public void onSaveForm() {
		//Messagebox.show("TESTING CUYY");
		detectQuestionMessageBox3(" Apakah Anda Ingin Menyimpan Data Ini? ");
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
								tableMasterProsedurformHdrDto.setTotalProsedur(tableMasterProsedurformDtlDtos.size());
								tableMasterProsedurformHdrDto.setCreatedDate(new Date());
								tableMasterProsedurformHdrDto.setCreatedBy(getCurrentEmployeId());
								tableMasterProsedurformHdrDto.setStatusAktif(1);
								tableMasterProsedurformHdrDto.setStatusApproval("OPEN");
								tableMasterProsedurformHdrDto.setProjekCode(getCurrentProjek());
								tableMasterProsedurformHdrDto.setTableMasterProsedurformDtlDtos(tableMasterProsedurformDtlDtos);
								
								for (TableMasterProsedurformDtlDto tableMasterProsedurformDtlDto: tableMasterProsedurformDtlDtos) {
									String uri = "/Prosedure Picture/Save Folder/Master Pemetaan Prosedur";
									saveFile(tableMasterProsedurformDtlDto.getDetailGambar(), uri, tableMasterProsedurformDtlDto.getDetailName() + ".jpg", "jpg");
								}
								
								Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/Save",
										tableMasterProsedurformHdrDto, "POST");
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
							else if(isSaatEdit()){
								tableMasterProsedurformHdrDto.setProjekCode(getCurrentProjek());
								tableMasterProsedurformHdrDto.setTotalProsedur(tableMasterProsedurformDtlDtos.size());
								tableMasterProsedurformHdrDto.setStatusApproval("OPEN");
								tableMasterProsedurformHdrDto.setUpdatedBy(getCurrentEmployeId());
								tableMasterProsedurformHdrDto.setUpdatedDate(new Date());
								tableMasterProsedurformHdrDto.setTableMasterProsedurformDtlDtos(tableMasterProsedurformDtlDtos);
								//Messagebox.show("menu " + tableMasterProsedurformHdrDto.getMenuCode());
								for (TableMasterProsedurformDtlDto tableMasterProsedurformDtlDto: tableMasterProsedurformDtlDtos) {
									String uri = "/Prosedure Picture/Save Folder/Master Pemetaan Prosedur";
									saveFile(tableMasterProsedurformDtlDto.getDetailGambar(), uri, tableMasterProsedurformDtlDto.getDetailName() + ".jpg", "jpg");
								}
								
								Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/Save",
										tableMasterProsedurformHdrDto, "POST");
								if ((boolean) mapp.get("valid")) {
									String result = (String) mapp.get("result");
									detectQuestionMessageBox();
								}
							}
//							else if(isSaatAktivasi()){
//								Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/Aktivasi",
//										selectedTableConfigurationMenuDtosForDetail, "POST",
//										"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
//								if ((boolean) mapp.get("valid")) {
//									String result = (String) mapp.get("result");
//									detectQuestionMessageBox();
//								}
//							}
//							else if(isSaatNonAktivasi()){
//								Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/NonAktivasi",
//										selectedTableConfigurationMenuDtosForDetail, "POST",
//										"user="+getCurrentEmployeId(),"projek="+getCurrentProjek());
//								if ((boolean) mapp.get("valid")) {
//									String result = (String) mapp.get("result");
//									detectQuestionMessageBox();
//								}
//							}
							else if (isSaatHapus()) {
								tableMasterProsedurformHdrDto.setUpdatedBy(getCurrentEmployeId());
								tableMasterProsedurformHdrDto.setUpdatedDate(new Date());
								
								for (TableMasterProsedurformDtlDto dtl: tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos()) {
									String[] splitterUri = dtl.getUrlDetailPicture().split("/");
									String uri = "/";
									String titleFile = splitterUri[splitterUri.length-1];
									for(int i = 0; i<splitterUri.length ; i++ ) {
										if(i!=(splitterUri.length-1)) {
											uri += splitterUri[i]+"/";
										}
									}
									deleteFile( uri, titleFile, "jpg");
								}
								
								Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/delete",
										tableMasterProsedurformHdrDto, "POST");
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
	
	public void refresh() {
		//initIndex();
		UndoUpload();
		sequenceNo = 1;
		tableMasterProsedurformDtlDtos = new ArrayList<>();
		tableMasterProsedurformDtlDto = new TableMasterProsedurformDtlDto();
		tableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
		BindUtils.postNotifyChange(null, null, this, "sequenceNo ");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformDtlDtos");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformDtlDto");
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformHdrDto");
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
	
	public void tambah() {
		collectAllUsableName();
		getCompleteGroupPageInfoForm(true, false, false, LOCALE.L007.getMessage());
	}

	public void loadAllChildLock() {
		mapChildLocks.put("Steady",
				getTheFile("/Prosedure Picture/Example", "childLock1.png", LOCALE.L013.getMessage()));
		mapChildLocks.put("Signaled",
				getTheFile("/Prosedure Picture/Example", "childLock2.png", LOCALE.L013.getMessage()));
		mapChildLocks.put("Warning",
				getTheFile("/Prosedure Picture/Example", "childLock3.png", LOCALE.L013.getMessage()));
		listChildLock.add("Steady");
		listChildLock.add("Signaled");
		listChildLock.add("Warning");
		BindUtils.postNotifyChange(null, null, this, "mapChildLocks");
		BindUtils.postNotifyChange(null, null, this, "listChildLock");

	}

	// public void loadItem() {
	// parentsPic = getTheFile("/Prosedure Picture/Example", "Parent2.png",
	// LOCALE.L013.getMessage());
	// initPic = getTheFile("/Prosedure Picture/Example", "Parent2.png",
	// LOCALE.L013.getMessage());
	// BindUtils.postNotifyChange(null, null, this , "parentsPic");
	// BindUtils.postNotifyChange(null, null, this , "childrenPic");
	// }

	@Command("onSubtitute")
	public void getNewPicOverLay() {
		parentsPic = initPic;
		historyOverLay.add(parentsPic);
		countHistory++;
		BindUtils.postNotifyChange(null, null, this, "parentsPic");
	}

	@Command("onPhotoUpload")
	public void onPhotoUpload(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) {
		UploadEvent upEvent = null;
		Object objUploadEvent = ctx.getTriggerEvent();
		if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
			upEvent = (UploadEvent) objUploadEvent;
			Media media = upEvent.getMedia();
			String typeMedia = media.getContentType();
			String[] typeMedias = typeMedia.split("/");
			if (typeMedias[0].equalsIgnoreCase("image")) {
				imageInitPic = new ImageCaptureDto(media.getByteData(), "test");
				byte[] tempParents = bufferedImageToByte(rescalingImageNew(imageInitPic, 0.5));
				byte[] tempInitPic = bufferedImageToByte(rescalingImageNew(imageInitPic, 0.5));

				initPic = tempParents;
				parentsPic = tempInitPic;
				BindUtils.postNotifyChange(null, null, this, "parentsPic");
				BindUtils.postNotifyChange(null, null, this, "initPic");
			} else {
				showWarningMessageBox(WARNING.W003.getMessage());
			}
		}
	}

	protected Integer countHist = new Integer(1);
	
	
	@Command("lookPicture")
	public void LookPictures(@BindingParam("seePic") org.zkoss.image.Image seePic) {
		initPic = seePic.getByteData();
		BindUtils.postNotifyChange(null, null, this, "initPic");
	}
	
	@Command("selectedPin")
	public void SelectedPin(@BindingParam("pin") String pin) {
		selectedItem = pin;
		parentsPic = initPic;
		historyOverLay.add(parentsPic);
		countHist = Integer.sum(countHist.intValue(), 1);
		historyPin.put(countHist, parentsPic);
		BindUtils.postNotifyChange(null, null, this, "historyPin");
		BindUtils.postNotifyChange(null, null, this, "parentsPic");
		BindUtils.postNotifyChange(null, null, this, "selectedItem");
	}
	
	@Command("backFormPemetaan")
	public void backFormPemetaan(){
		UndoUpload();
		onPemetaanProsedur = false;
		BindUtils.postNotifyChange(null, null, this, "onPemetaanProsedur");
	}

	@Command("undoUpload")
	public void UndoUpload() {
		selectedItem = new String();
		childrenPic = null;
		parentsPic = null;
		initPic = null;
		historyPin = new HashMap<>();
		detailName = new String();
		BindUtils.postNotifyChange(null, null, this, "historyPin");
		BindUtils.postNotifyChange(null, null, this, "selectedItem");
		BindUtils.postNotifyChange(null, null, this, "childrenPic");
		BindUtils.postNotifyChange(null, null, this, "parentsPic");
		BindUtils.postNotifyChange(null, null, this, "initPic");
	}
	
	
	
	@Command("savePicture")
	public void savePicture() {
		onFilledName = true;
		BindUtils.postNotifyChange(null, null, this, "onFilledName");
	}
	
	
	
	@Command("saveProsedur")
	public void saveProsedur() {
		TableMasterProsedurformDtlDto dto = new TableMasterProsedurformDtlDto();
		dto.setProsedurSeq(new Integer(sequenceNo));
		dto.setDetailGambar(initPic);
		dto.setDetailName(detailName);
		tableMasterProsedurformDtlDtos.add(dto);
		detailNames.add(detailName);
		UndoUpload();
		BindUtils.postNotifyChange(null, null, this, "tableMasterProsedurformDtlDtos");
		onPemetaanProsedur = false;
		onFilledName = false;
		sequenceNo++;
		BindUtils.postNotifyChange(null, null, this, "onPemetaanProsedur");
		BindUtils.postNotifyChange(null, null, this, "onFilledName");
	}
	
	@Command("cancelForm")
	public void cancelForm() {
		onFilledName = false;
		detailName = new String();
		BindUtils.postNotifyChange(null, null, this, "onFilledName");
		BindUtils.postNotifyChange(null, null, this, "detailName");
	}

	@Command
	public void checkCoor(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
			throws IOException, ImageReadException {
		childrenPic = mapChildLocks.get(selectedItem);
		if (childrenPic != null) {
			Object tesEvent = ctx.getTriggerEvent();
			MouseEvent me = (MouseEvent) tesEvent;
			setCoorX(me.getX());
			setCoorY(me.getY());
			if (parentsPic != null) {
				initPic = getImageWithDinamicMoveForeground(parentsPic, childrenPic, coorX, coorY);
			} else {
				showErrorMessageBox(ERROR.E001.getMessage());
			}
			BindUtils.postNotifyChange(null, null, this, "coorX");
			BindUtils.postNotifyChange(null, null, this, "coorY");
			BindUtils.postNotifyChange(null, null, this, "coorVisible");
			BindUtils.postNotifyChange(null, null, this, "initPic");
		} else {
			showWarningMessageBox(WARNING.W001.getMessage());
			return;
		}
	}

	protected int i = 1;

	@Command("saveTemporary")
	public void SaveProcedure() {
		if (initPic == null) {
			showWarningMessageBox(WARNING.W002.getMessage());
			return;
		}
		mapProsesLocks.put("Proses" + i + ".jpg", initPic);
		initPic = null;
		parentsPic = null;
		BindUtils.postNotifyChange(null, null, this, "mapProsesLocks");
		BindUtils.postNotifyChange(null, null, this, "parentsPic");
		BindUtils.postNotifyChange(null, null, this, "initPic");
		i++;
	}

	@Command("back")
	public void BackProcedure() {
		countHistory--;
		initPic = historyOverLay.get(countHistory);
		parentsPic = initPic;
		BindUtils.postNotifyChange(null, null, this, "initPic");
		BindUtils.postNotifyChange(null, null, this, "parentsPic");
	}

	@Command("refresh")
	public void RefreshProcedure() {
		// loadItem();
	}

	@Command
	public void deletePics(@BindingParam("trash") String trash) {
		// Messagebox.show("hapus" + trash);
		if (initPic == mapProsesLocks.get(trash)) {
			initPic = null;
			BindUtils.postNotifyChange(null, null, this, "initPic");
		}
		mapProsesLocks.remove(trash);
		BindUtils.postNotifyChange(null, null, this, "mapProsesLocks");
	}

	@Command("callMenuId")
	public void onCallMenuCode() {
		Map<String, Object> mapp = new HashMap<>();
		callPopUpMenu("/MenuPopUp/CallAllMenusPu.zul", mapp);
	}
	
	@GlobalCommand("CallAllMenusPuVmd")
	public void popUpMenuHandler(@BindingParam("tableMenuDto") TableMenuDto dto) {
		tableMasterProsedurformHdrDto.setMenuCode(dto.getMenuCode());
		tableMasterProsedurformHdrDto.setMenuReferensi(dto.getMenuName());
		BindUtils.postNotifyChange(null, null, MasterPemetaanProsedurFormVmd.this, "tableMasterProsedurformHdrDto");
	}

	/**
	 * Make Image involving with its width and height
	 * 
	 * @param bg
	 * @param fg
	 * @param fgWidth
	 * @param fgHeight
	 * @return
	 * @throws IOException
	 * @throws ImageReadException
	 */
	public byte[] getImageWithDinamicMoveForeground(byte[] baiBg, byte[] baiFg, float coorX, float coorY)
			throws IOException, ImageReadException {
		byte[] finalImage = null;
		// BufferedImage bg = ImageIO.read(baiBg);
		// BufferedImage bg = ImageIO.read(new ByteArrayInputStream(baiBg));
		// BufferedImage fg = resizingImage(baiFg,70, 70);
		// BufferedImage finalPic = overLayImagesWithSpecificCoordinate(bg, fg, coorX,
		// coorY);
		BufferedImage finalPic = overLayImagesWithSpecificCoordinateNew(new ImageCaptureDto(baiBg, ""),
				new ImageCaptureDto(bufferedImageToByte(resizingImage(baiFg, 70, 70)), ""), coorX, coorY);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(finalPic, "jpg", baos);
		baos.flush();
		finalImage = baos.toByteArray();
		baos.close();
		return finalImage;
	}

	public byte[] bufferedImageToByte(BufferedImage image) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] finalImage = null;
		try {
			ImageIO.write(image, "jpg", baos);
			baos.flush();
			finalImage = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return finalImage;
	}

	public BufferedImage rescalingImageNew(ImageCaptureDto imageCapture, double scaled) {
		ByteArrayInputStream bisImage = new ByteArrayInputStream(imageCapture.getByte());
		Image image = null;
		try {
			image = ImageIO.read(bisImage);
		} catch (IOException e) {
			Messagebox.show("File Ini Mengandung CMYK " + bisImage);
			// image = finalConverter(bitConvert);
			e.printStackTrace();
		}

		Image scaledImage = image.getScaledInstance(new Integer((int) (imageCapture.getWidth() * scaled)),
				new Integer((int) (imageCapture.getHeight() * scaled)), Image.SCALE_SMOOTH);

		if (scaledImage instanceof BufferedImage) {
			return (BufferedImage) scaledImage;
		}
		BufferedImage bufferedImage = new BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		Graphics2D bgr = bufferedImage.createGraphics();
		bgr.drawImage(scaledImage, 0, 0, null);
		bgr.dispose();
		return bufferedImage;
	}

	public BufferedImage resizingImage(byte[] bitConvert, int newWidth, int newHeight)
			throws ImageReadException, IOException {
		ByteArrayInputStream bisImage = new ByteArrayInputStream(bitConvert);
		Image image = null;
		try {
			image = ImageIO.read(bisImage);
		} catch (IOException e) {
			Messagebox.show("File Ini Mengandung CMYK " + bisImage);
			e.printStackTrace();
		}

		Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

		if (scaledImage instanceof BufferedImage) {
			return (BufferedImage) scaledImage;
		}
		BufferedImage bufferedImage = new BufferedImage(scaledImage.getWidth(null), scaledImage.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D bgr = bufferedImage.createGraphics();
		bgr.drawImage(scaledImage, 0, 0, null);
		bgr.dispose();
		return bufferedImage;
	}

	@Command
	public void onDropping(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) {
		Object getEventCreature = ctx.getTriggerEvent();
		if (getEventCreature instanceof DropEvent) {
			DropEvent evt = (DropEvent) getEventCreature;
			Messagebox.show(evt.getY() + "posisi setelah dropping");
		}
	}

	@Command
	public void firstClick(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) {
		Object getEventCreature = ctx.getTriggerEvent();
		if (getEventCreature instanceof MouseEvent) {
			MouseEvent evt = (MouseEvent) getEventCreature;
			Messagebox.show(evt.getY() + "posisi sebelumnya");
		}
	}

	// public BufferedImage overLayImages

	/**
	 * Melakukan overlay dengan background yang sama
	 * 
	 * @param bg
	 * @param fg
	 * @param coorX
	 * @param coorY
	 * @return
	 */
	public BufferedImage overLayImagesWithSpecificCoordinate(BufferedImage bg, BufferedImage fg, float coorX,
			float coorY) {
		if (fg.getHeight() > bg.getHeight()) {
			Messagebox.show("picture foreground lebih besar dari background");
			return null;
		}

		BufferedImage biFinal = new BufferedImage(450, 400, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = biFinal.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(bg, 0, 0, null);
		g.setStroke(new BasicStroke(100));
		g.drawImage(fg, ((int) coorX) + 6 - ((int) (fg.getWidth() / 2)), ((int) coorY - fg.getHeight() + 8), null);
		g.dispose();
		return biFinal;
	}

	/**
	 * Melakukan overlay dengan background yang sama
	 * 
	 * @param bg
	 * @param fg
	 * @param coorX
	 * @param coorY
	 * @return
	 */
	public BufferedImage overLayImagesWithSpecificCoordinateNew(ImageCaptureDto bg, ImageCaptureDto fg, float coorX,
			float coorY) {
		if (fg.getHeight() > bg.getHeight()) {
			Messagebox.show("picture foreground lebih besar dari background");
			return null;
		}

		BufferedImage biFinal = new BufferedImage(bg.getWidth(), bg.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = biFinal.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(bg.getBuffImage(), 0, 0, null);
		g.setStroke(new BasicStroke(100));
		g.drawImage(fg.getBuffImage(), ((int) coorX) - ((int) (fg.getWidth() / 2)), ((int) coorY - fg.getHeight()),
				null);
		g.dispose();
		return biFinal;
	}

	
	//custom constraint 
	
	protected void InValidFormClass(String idName) {
		String si = "valid_FormClass('"+ idName +"',"+"'Panel"+idName+"',"+"'Label"+idName+"','textboxFormInputInvalid','panelFormInvalid','labelFormInputInvalid')";
		Clients.evalJavaScript(si);
	}
	
    protected void ValidFormClass(String idName) {
    	String si = "invalid_FormClass('"+ idName +"',"+"'Panel"+idName+"',"+"'Label"+idName+"','textboxFormInputInvalid','panelFormInvalid','labelFormInputInvalid')";
		Clients.evalJavaScript(si);
		String s = "valid_FormClass('"+ idName +"',"+"'Panel"+idName+"',"+"'Label"+idName+"','textboxFormInput','panelForm','labelFormInput')";
		Clients.evalJavaScript(s);
	}
	
	protected Constraint checkDetailName(){
		return new Constraint() {
			
			@Override
			public void validate(Component comp, Object value)
					throws WrongValueException {
				String idName = comp.getId();		        
				if(((String) value).trim().equalsIgnoreCase("")){
					InValidFormClass(idName);
				    throw new WrongValueException(comp,"Bagian Ini Tidak Boleh Kosong");
					}
				else {	
					
					if(detailNames.contains(value)) {
						InValidFormClass(idName);
					    throw new WrongValueException(comp,"Nama Detail Sudah Dipakai");
					}
					else {
					ValidFormClass(idName);
					}
			       }
				}
			 };
    	}

	protected Constraint checkProsedurName(){
		return new Constraint() {
			
			@Override
			public void validate(Component comp, Object value)
					throws WrongValueException {
				String idName = comp.getId();		        
				if(((String) value).trim().equalsIgnoreCase("")){
					InValidFormClass(idName);
				    throw new WrongValueException(comp,"Bagian Ini Tidak Boleh Kosong");
					}
				else {	
					
					if(prosedurNames.contains(value)) {
						InValidFormClass(idName);
					    throw new WrongValueException(comp,"Nama Prosedur Sudah Dipakai");
					}
					else {
					ValidFormClass(idName);
					}
			       }
				}
			 };
    	}
	protected Constraint consCheckProsedurName = checkProsedurName();
	protected Constraint consCheckDetailName = checkDetailName();
	
	public Constraint getConsCheckDetailName() {
		return consCheckDetailName;
	}

	public void setConsCheckDetailName(Constraint consCheckDetailName) {
		this.consCheckDetailName = consCheckDetailName;
	}

	public float getCoorX() {
		return coorX;
	}

	public void setCoorX(float coorX) {
		this.coorX = coorX;
	}

	public float getCoorY() {
		return coorY;
	}

	public void setCoorY(float coorY) {
		this.coorY = coorY;
	}

	public boolean isCoorVisible() {
		return coorVisible;
	}

	public void setCoorVisible(boolean coorVisible) {
		this.coorVisible = coorVisible;
	}

	public byte[] getParentsPic() {
		return parentsPic;
	}

	public void setParentsPic(byte[] parentsPic) {
		this.parentsPic = parentsPic;
	}

	public byte[] getChildrenPic() {
		return childrenPic;
	}

	public void setChildrenPic(byte[] childrenPic) {
		this.childrenPic = childrenPic;
	}

	public byte[] getInitPic() {
		return initPic;
	}

	public void setInitPic(byte[] initPic) {
		this.initPic = initPic;
	}

	public Map<String, byte[]> getMapChildLocks() {
		return mapChildLocks;
	}

	public void setMapChildLocks(Map<String, byte[]> mapChildLocks) {
		this.mapChildLocks = mapChildLocks;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public List<String> getListChildLock() {
		return listChildLock;
	}

	public void setListChildLock(List<String> listChildLock) {
		this.listChildLock = listChildLock;
	}

	public List<byte[]> getHistoryOverLay() {
		return historyOverLay;
	}

	public void setHistoryOverLay(List<byte[]> historyOverLay) {
		this.historyOverLay = historyOverLay;
	}

	public int getCountHistory() {
		return countHistory;
	}

	public void setCountHistory(int countHistory) {
		this.countHistory = countHistory;
	}

	public Map<String, byte[]> getMapProsesLocks() {
		return mapProsesLocks;
	}

	public void setMapProsesLocks(Map<String, byte[]> mapProsesLocks) {
		this.mapProsesLocks = mapProsesLocks;
	}

	public List<TableMasterProsedurformDtlDto> getTableMasterProsedurformDtlDtos() {
		return tableMasterProsedurformDtlDtos;
	}

	public void setTableMasterProsedurformDtlDtos(List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDtos) {
		this.tableMasterProsedurformDtlDtos = tableMasterProsedurformDtlDtos;
	}

	public TableMasterProsedurformDtlDto getTableMasterProsedurformDtlDto() {
		return tableMasterProsedurformDtlDto;
	}

	public void setTableMasterProsedurformDtlDto(TableMasterProsedurformDtlDto tableMasterProsedurformDtlDto) {
		this.tableMasterProsedurformDtlDto = tableMasterProsedurformDtlDto;
	}

	public List<TableMasterProsedurformHdrDto> getTableMasterProsedurformHdrDtos() {
		return tableMasterProsedurformHdrDtos;
	}

	public void setTableMasterProsedurformHdrDtos(List<TableMasterProsedurformHdrDto> tableMasterProsedurformHdrDtos) {
		this.tableMasterProsedurformHdrDtos = tableMasterProsedurformHdrDtos;
	}

	public TableMasterProsedurformHdrDto getTableMasterProsedurformHdrDto() {
		return tableMasterProsedurformHdrDto;
	}

	public void setTableMasterProsedurformHdrDto(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto) {
		this.tableMasterProsedurformHdrDto = tableMasterProsedurformHdrDto;
	}

	public boolean isOnFilter() {
		return onFilter;
	}

	public void setOnFilter(boolean onFilter) {
		this.onFilter = onFilter;
	}

	public TableMasterProsedurformHdrDto getFilterTableMasterProsedurformHdrDto() {
		return filterTableMasterProsedurformHdrDto;
	}

	public void setFilterTableMasterProsedurformHdrDto(
			TableMasterProsedurformHdrDto filterTableMasterProsedurformHdrDto) {
		this.filterTableMasterProsedurformHdrDto = filterTableMasterProsedurformHdrDto;
	}

	public TableMasterProsedurformHdrDto getTempFilterTableMasterProsedurformHdrDto() {
		return tempFilterTableMasterProsedurformHdrDto;
	}

	public void setTempFilterTableMasterProsedurformHdrDto(
			TableMasterProsedurformHdrDto tempFilterTableMasterProsedurformHdrDto) {
		this.tempFilterTableMasterProsedurformHdrDto = tempFilterTableMasterProsedurformHdrDto;
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

	public boolean isOnPemetaanProsedur() {
		return onPemetaanProsedur;
	}

	public void setOnPemetaanProsedur(boolean onPemetaanProsedur) {
		this.onPemetaanProsedur = onPemetaanProsedur;
	}

	public Map<Integer, byte[]> getHistoryPin() {
		return historyPin;
	}

	public void setHistoryPin(Map<Integer, byte[]> historyPin) {
		this.historyPin = historyPin;
	}

	public boolean isOnFilledName() {
		return onFilledName;
	}

	public void setOnFilledName(boolean onFilledName) {
		this.onFilledName = onFilledName;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public Constraint getConsCheckProsedurName() {
		return consCheckProsedurName;
	}

	public void setConsCheckProsedurName(Constraint consCheckProsedurName) {
		this.consCheckProsedurName = consCheckProsedurName;
	}

}
