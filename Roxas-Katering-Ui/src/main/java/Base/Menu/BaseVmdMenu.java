package Base.Menu;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Window;

import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.core.util.Base64Encoder;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import Master.ConstraintClass.ConstraintForm;
import Master.StaticVariable.AllStaticVariable;
import RestResponse.FromJava.RestTemplateFromJava;
import RestResponse.FromTibco.RestTemplateFromTibco;
import Source.LabelSource.LABEL;
import Source.LocaleSource.LOCALE;
import Source.MainSource.TransferUserData;
import Source.MessageSource.INFORMATION;

/**
 * BASE VMD UNTUK MENU TRANSAKSI
 */

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public abstract class BaseVmdMenu extends TransferUserData implements Serializable{
	protected ConstraintForm formConstraint = new ConstraintForm();
	protected TableMenuDto currentMenu = new TableMenuDto();
	private static final long serialVersionUID = 1L;
	private final AllStaticVariable VARIABLE = new AllStaticVariable();
	private RestTemplateFromJava java = new RestTemplateFromJava();
	private RestTemplateFromTibco tibco = new RestTemplateFromTibco();
	public Map<String,Object> mapFromChildren = new HashMap<>();
	public String urlFromChildren = new String();
	public int countExistingButton = 0;
	protected String search = "";
	protected String titleDetail = "";
	protected String detailSearch = "";
	protected LABEL L;
	protected byte[] rocketLauncher;
	protected byte[] sateliteLauncher;
	protected boolean saatTambah = false;
	protected boolean saatHapus = true;
	protected boolean saatAktivasi = false;
	protected boolean saatNonAktivasi = false;
	protected boolean saatEdit = false;
	protected boolean saatLihat = false;
	protected boolean groupPageInfoForm = false;
	protected boolean groupRefactorInfoForm = false;
	protected boolean saatHelp = false;
	protected boolean saatReturn = true;
	protected boolean onFilledFormAgain = false;
	protected boolean onFormFilled = true;
	protected boolean saatDelete = true;
	protected boolean saatKirim = false;
	
	//form part --start
	
	protected boolean onForm1 = true;
	protected boolean onForm2 = false;
	protected boolean onForm3 = false;
	protected int pageNum = 0;
	protected int pageSize;
	protected int totalElements;
	protected String direction = "ASC";
	protected String orderBy = "";
	//form part --end
	
	@Command("refreshList")
	public void refreshListAll() {
		pageNum = 0;
	    String direction = "ASC";
	    String orderBy = "";
		search = new String();
		BindUtils.postNotifyChange(null, null, this, "direction");
     	BindUtils.postNotifyChange(null, null, this, "orderBy");
		BindUtils.postNotifyChange(null, null, this, "pageNum");
		BindUtils.postNotifyChange(null, null, this, "search");
		loadListAll(null);
	}
	
	//For CallRequestMapping --start

	//Cara Panggil request Yang Lama
	/**
	 * Request Mapping Dari Java Untuk Index
	 */
	public Map<String, Object> CallRequestMappingJavaForIndex
	    (String mainUrl, Object body){
		urlFromChildren = mainUrl;
		//mapFromChildren = (Map<String, Object>) body;
		Object[] Params = {"user="+getCurrentEmployeId(),"projek="+getCurrentProjek(),"search=%"+getSearch()+"%","page="+pageNum,"direction="+direction,"orderBy="+orderBy};
		BindUtils.postNotifyChange(null, null, this, "urlFromChildren");
		BindUtils.postNotifyChange(null, null, this, "mapFromChildren");
		Map<String, Object> mapRequest = CallRequestMappingJava(mainUrl, body, "POST", Params);
		totalElements = (int) mapRequest.get("counts");
		BindUtils.postNotifyChange(null, null, this, "totalElements");
		return  mapRequest;
	}
	
	public Map<String, Object> CallRequestMappingJavaForFilter(String mainUrl, String execFilter){
	urlFromChildren = mainUrl;
	Object[] Params = {"user="+getCurrentEmployeId(),"projek="+getCurrentProjek(),"execFilter="+execFilter,"search=%"+getSearch()+"%"};
	BindUtils.postNotifyChange(null, null, this, "urlFromChildren");
	BindUtils.postNotifyChange(null, null, this, "mapFromChildren");
	return  CallRequestMappingJava(mainUrl, null, "GET", Params);
    }
	
	/**
	 * Request Mapping Dari Java
	 */
	public Map<String, Object> CallRequestMappingJava(String mainUrl, Object body, String Method, Object... Params)
	{
		Map<String, Object> resultMap = new HashMap<>();
		
		if(Method.equalsIgnoreCase("POST")){
			resultMap = java.mapRestTemplateValueWithPostMethod(mainUrl, body, Params);
		} 
		else if(Method.equalsIgnoreCase("GET")){
			resultMap = java.mapRestTemplateValueWithGetMethod(mainUrl, Params);
		}
		
		return resultMap;
	}
	
	
	
	public Map<String, Object> CallRequestMappingTibco(String mainUrl, Object body, String Method, Object... Params)
	{
	Map<String, Object> resultMap = new HashMap<>();
		
		if(Method.equalsIgnoreCase("POST")){
			resultMap = tibco.mapRestTemplateValueWithPostMethod(mainUrl, body, Params);
		} 
		else if(Method.equalsIgnoreCase("GET")){
			resultMap = tibco.mapRestTemplateValueWithGetMethod(mainUrl, Params);
		}
		return resultMap;
	}
	
	
	public String saveFile(byte[] media , String uri, String titleFile, String typeFile){
		
		RestTemplate restTemplate = new RestTemplate();
		Base64Encoder encoder = new Base64Encoder();
		String encoderMedia = encoder.encode(media);

		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("title", titleFile);
		mapRe.put("encoder", encoderMedia);
		mapRe.put("uri", uri);
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/saveImage", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/savePdf", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		
		return "ERROR WHILE PARSING";
	}
	
	public String deleteFile(String uri, String titleFile, String typeFile){
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("title", titleFile);
		mapRe.put("uri", uri);
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/deleteImage", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/deletePdf", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		return "ERROR WHILE PARSING";
	}
	
	public String replace(byte[] media , String uri, String oldTitleFile,String newTitleFile, 
			String typeFile){
		RestTemplate restTemplate = new RestTemplate();
		Base64Encoder encoder = new Base64Encoder();
		String encoderMedia = encoder.encode(media);
		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("oldTitle", oldTitleFile);
		mapRe.put("newTitle", newTitleFile);
		mapRe.put("encoder", encoderMedia);
		mapRe.put("uri", uri);
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/replaceImage", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<String> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/replacePdf", 
  					 HttpMethod.POST, httpEntity, String.class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		return "ERROR WHILE PARSING";
	}
	
	public byte[] getTheFile(String uri,String titleFile, String typeFile){
		Map<String, Object> mapRe = new HashMap<>();
		mapRe.put("title",titleFile);
		mapRe.put("uri", uri);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity httpEntity = new HttpEntity(mapRe);
		if(typeFile.equalsIgnoreCase("jpg")){
			ResponseEntity<byte[]> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemImage/getSpecificImage", 
  					 HttpMethod.POST, httpEntity, byte[].class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("pdf")){		
			ResponseEntity<byte[]> entity = restTemplate.exchange(VARIABLE.FILINGSYSTEMURL+"filingSystemPdf/getSpecificPdf", 
  					 HttpMethod.POST, httpEntity, byte[].class);
			return entity.getBody();
		}
		else if(typeFile.equalsIgnoreCase("excel")){
			
		}
		else if(typeFile.equalsIgnoreCase("txt")){
			
		}
		else if(typeFile.equalsIgnoreCase("word")){
			
		}
		
		byte[] a = null;
		return a;
	}
	// For Call RequestMapping --end
	
	
	// For Call ShowMessageBox --start
	protected void showErrorMessageBox(String argument){
		Map<String,String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(argument,
			"Kesalahan", new Button[]{Button.OK}  , null, Messagebox.ERROR, null,null, params);
	}
	
	protected void showWarningMessageBox(String argument){
		Map<String,String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(argument,
			"Peringatan", new Button[]{Button.OK}  , null, Messagebox.EXCLAMATION, null,null, params);
		
	}
	
	protected void showInformationMessageBox(String argument){
		Map<String,String> params = new HashMap();
		params.put("sclass", "myMessagebox");
		Messagebox.show(argument,
			"Informasi", new Button[]{Button.OK}  , null, Messagebox.INFORMATION, null,null, params);
	}
	// For Call ShowMessageBox --end
	
	//for search --start
	
	//for search --start
	
	// For Call Constraint --start
	
	// For Call Constraint --end
	
	//page info --start
	
	//versi refactor 1
	public boolean getValidationGroupPageRefactorForm(boolean isAktivasi, boolean isNonAktivasi) {
		if(isAktivasi||isNonAktivasi) {
			return true;
		}
		return false;
	}
	
	//versi refactor 2
	public void getCompleteGroupPageRefactorForm(boolean isAktivasi, boolean isNonAktivasi, String title) {
		setGroupRefactorInfoForm(getValidationGroupPageRefactorForm(isAktivasi, isNonAktivasi));
		if(isAktivasi||isNonAktivasi) {
			setTitleDetail(title);
			}
			else {
				setTitleDetail("");
			}
		setSaatAktivasi(isAktivasi);
		setSaatNonAktivasi(isNonAktivasi);
		BindUtils.postNotifyChange(null, null, this, "saatAktivasi");
		BindUtils.postNotifyChange(null, null, this, "saatNonAktivasi");
		BindUtils.postNotifyChange(null, null, this, "groupRefactorInfoForm");
		BindUtils.postNotifyChange(null, null, this, "titleDetail");
	}
	
	//versi 1
	public boolean getValidationGroupPageInfoForm(boolean isTambah, boolean isLihat, boolean isEdit) {
		if(isTambah||isLihat||isEdit) {
			return true;
		}
		return false;
	}
	
	//versi 2
	public void getCompleteGroupPageInfoForm(boolean isTambah, boolean isLihat, boolean isEdit, String title) {
		setGroupPageInfoForm(getValidationGroupPageInfoForm(isTambah, isLihat, isEdit));
		if(isTambah||isLihat||isEdit) {
		setTitleDetail(title);
		}
		else {
			setTitleDetail("");
		}
		setSaatTambah(isTambah);
		setSaatLihat(isLihat);
		setSaatEdit(isEdit);
		BindUtils.postNotifyChange(null, null, this, "saatTambah");
		BindUtils.postNotifyChange(null, null, this, "saatLihat");
		BindUtils.postNotifyChange(null, null, this, "saatEdit");
		BindUtils.postNotifyChange(null, null, this, "groupPageInfoForm");
		BindUtils.postNotifyChange(null, null, this, "titleDetail");
	}

	public void getValidationGroupPageHelpAndInfo(boolean isHelp, boolean isReturn, String title) {
		setSaatHelp(isHelp);
		setSaatReturn(isReturn);
		BindUtils.postNotifyChange(null, null, this, "saatHelp");
		BindUtils.postNotifyChange(null, null, this, "saatReturn");
	}
	//page info --end
	
	//for call popupMenu/Sliding Menu/ Current Menu --start
	
	
	//for call popupMenu/Sliding Menu/ Current Menu --end
	public void callPopUpMenu(String uri, Map<String, Object> mapp) {
		Executions.getCurrent().setAttribute("ObjectInformation", mapp);
		Window window = (Window) Executions.createComponents(
				uri, null,
				null);
		window.doModal();
	}
	
	public void callSlidingMenu(String uri, Map<String, Object> mapp) {
		Executions.getCurrent().setAttribute("ObjectInformation", mapp);
		Window window = (Window) Executions.createComponents(
				uri, null,
				null);
		window.doModal();
	}
	
	public void callCurrentMenu(String uri, Map<String, Object> mapp) {
		Executions.getCurrent().setAttribute("ObjectInformation", mapp);
		Window window = (Window) Executions.createComponents(
				uri, null,
				null);
		window.doModal();
	}
	// For Call Important Information  --start
	
	
	/**
	 * For Call Super Implementation
	 */
	

	public void initBackground() {
		rocketLauncher = getTheFile(LOCALE.L015.getMessage(), "icon-form-6.png", LOCALE.L013.getMessage());
		sateliteLauncher = getTheFile(LOCALE.L015.getMessage(), "icon-form-9.jpg", LOCALE.L013.getMessage());
		BindUtils.postNotifyChange(null, null, this, "rocketLauncher");
		BindUtils.postNotifyChange(null, null, this, "sateliteLauncher");
		
	}

	
	
	@Init(superclass = true)
	public void loadListAll(@ExecutionArgParam("menuDto") TableMenuDto menu) {
		if(menu!=null){
		currentMenu = menu;	
		Map<String, Object> bodyRequest = new HashMap<>();
		bodyRequest.put("userDto", getCurrentUserDto());
		bodyRequest.put("menuDto", menu);
		Map<String, Object> map = CallRequestMappingJava
				("/MenuUtama/AllExistingButtonUser", bodyRequest, "POST"); 
		
		if(map.size()>0){
			tableButtonDtos = java.mapperJsonToListDto(map,
					new TypeToken<ArrayList<TableButtonDto>>() {
					}.getType(), tableButtonDtos, "contents");
			}	
			else{
				Messagebox.show("Data Tidak Ada");
			}
		BindUtils.postNotifyChange(null, null, this, "tableButtonDtos");
		BindUtils.postNotifyChange(null, null, this, "currentMenu");
		}
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getCurrentProjek(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto().getProjekCode();
	}
	
	public String getCurrentEmployeId(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto().getPegawaiId();
	}
	
	public String getCurrentUserId(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto().getUserId();
	}
	
	private TableUserDto getCurrentUserDto(){
		TransferUserData userData = new TransferUserData();
		return userData.getTableUserDto();
	}
	
	public TableMenuDto getCurrentMenuDto(){
		//TransferUserData userData = new TransferUserData();
		return tableMenuDto;
	}
	
	// For Call Important Information  --end
	
	//For Button Form --start
	
	public void openForms(boolean... onForms) {
			setOnForm1(onForms[0]);
			setOnForm2(onForms[1]);
			setOnForm3(onForms[2]);
			BindUtils.postNotifyChange(null, null, this, "onForm1");
			BindUtils.postNotifyChange(null, null, this, "onForm2");
			BindUtils.postNotifyChange(null, null, this, "onForm3");
	}
	
	@Command("actionForm")
	public void ActionForm(@BindingParam("valid") String valid){
		if(valid.equals("formulir1")) {
			openForms(true,false,false);
		}
		else if(valid.equals("formulir2")) {
			openForms(false,true,false);
		}
		else if(valid.equals("formulir3")) {
			openForms(false,false,true);
		}
		else {
			showInformationMessageBox(INFORMATION.I003.getMessage());
		}
	}
	//For Button Form --end
	
	public void setSortingList(BindContext binder,String sortedBy) {
		Listheader lh = (Listheader) binder.getTriggerEvent().getTarget();
		String dir = lh.getSortDirection();
		if(dir.equalsIgnoreCase("natural")||dir.equalsIgnoreCase("descending")) {
			direction = "DESC";
		}
		else {
			direction = "ASC";
		}
		orderBy = sortedBy;
	}
	
	
	//All SETTER AND GETTER
	public RestTemplateFromJava getJava() {
		return java;
	}
	public void setJava(RestTemplateFromJava java) {
		this.java = java;
	}
	public RestTemplateFromTibco getTibco() {
		return tibco;
	}
	public void setTibco(RestTemplateFromTibco tibco) {
		this.tibco = tibco;
	}



	public Map<String, Object> getMapFromChildren() {
		return mapFromChildren;
	}



	public void setMapFromChildren(Map<String, Object> mapFromChildren) {
		this.mapFromChildren = mapFromChildren;
	}



	public String getUrlFromChildren() {
		return urlFromChildren;
	}



	public void setUrlFromChildren(String urlFromChildren) {
		this.urlFromChildren = urlFromChildren;
	}



	public boolean isSaatTambah() {
		return saatTambah;
	}



	public void setSaatTambah(boolean saatTambah) {
		this.saatTambah = saatTambah;
	}



	public boolean isSaatHapus() {
		return saatHapus;
	}



	public void setSaatHapus(boolean saatHapus) {
		this.saatHapus = saatHapus;
	}



	public boolean isSaatAktivasi() {
		return saatAktivasi;
	}



	public void setSaatAktivasi(boolean saatAktivasi) {
		this.saatAktivasi = saatAktivasi;
	}



	public boolean isSaatNonAktivasi() {
		return saatNonAktivasi;
	}



	public void setSaatNonAktivasi(boolean saatNonAktivasi) {
		this.saatNonAktivasi = saatNonAktivasi;
	}



	public boolean isSaatEdit() {
		return saatEdit;
	}



	public void setSaatEdit(boolean saatEdit) {
		this.saatEdit = saatEdit;
	}



	public boolean isSaatLihat() {
		return saatLihat;
	}



	public void setSaatLihat(boolean saatLihat) {
		this.saatLihat = saatLihat;
	}



	public boolean isGroupPageInfoForm() {
		return groupPageInfoForm;
	}



	public void setGroupPageInfoForm(boolean groupPageInfoForm) {
		this.groupPageInfoForm = groupPageInfoForm;
	}



	public String getTitleDetail() {
		return titleDetail;
	}



	public void setTitleDetail(String titleDetail) {
		this.titleDetail = titleDetail;
	}



	public int getCountExistingButton() {
		return countExistingButton;
	}



	public void setCountExistingButton(int countExistingButton) {
		this.countExistingButton = countExistingButton;
	}



	public boolean isSaatHelp() {
		return saatHelp;
	}



	public void setSaatHelp(boolean saatHelp) {
		this.saatHelp = saatHelp;
	}



	public boolean isSaatReturn() {
		return saatReturn;
	}



	public void setSaatReturn(boolean saatReturn) {
		this.saatReturn = saatReturn;
	}



	public boolean isOnFilledFormAgain() {
		return onFilledFormAgain;
	}



	public void setOnFilledFormAgain(boolean onFilledFormAgain) {
		this.onFilledFormAgain = onFilledFormAgain;
	}



	public boolean isOnFormFilled() {
		return onFormFilled;
	}



	public void setOnFormFilled(boolean onFormFilled) {
		this.onFormFilled = onFormFilled;
	}

	public TableMenuDto getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(TableMenuDto currentMenu) {
		this.currentMenu = currentMenu;
	}

	public boolean isGroupRefactorInfoForm() {
		return groupRefactorInfoForm;
	}

	public String getDetailSearch() {
		return detailSearch;
	}

	public void setDetailSearch(String detailSearch) {
		this.detailSearch = detailSearch;
	}

	public void setGroupRefactorInfoForm(boolean groupRefactorInfoForm) {
		this.groupRefactorInfoForm = groupRefactorInfoForm;
	}

	public boolean isSaatDelete() {
		return saatDelete;
	}

	public void setSaatDelete(boolean saatDelete) {
		this.saatDelete = saatDelete;
	}

	public byte[] getRocketLauncher() {
		return rocketLauncher;
	}

	public void setRocketLauncher(byte[] rocketLauncher) {
		this.rocketLauncher = rocketLauncher;
	}

	public byte[] getSateliteLauncher() {
		return sateliteLauncher;
	}

	public void setSateliteLauncher(byte[] sateliteLauncher) {
		this.sateliteLauncher = sateliteLauncher;
	}

	public boolean isOnForm1() {
		return onForm1;
	}

	public void setOnForm1(boolean onForm1) {
		this.onForm1 = onForm1;
	}

	public boolean isOnForm2() {
		return onForm2;
	}

	public void setOnForm2(boolean onForm2) {
		this.onForm2 = onForm2;
	}

	public boolean isOnForm3() {
		return onForm3;
	}

	public void setOnForm3(boolean onForm3) {
		this.onForm3 = onForm3;
	}

	public ConstraintForm getFormConstraint() {
		return formConstraint;
	}

	public void setFormConstraint(ConstraintForm formConstraint) {
		this.formConstraint = formConstraint;
	}

	public boolean isSaatKirim() {
		return saatKirim;
	}

	public void setSaatKirim(boolean saatKirim) {
		this.saatKirim = saatKirim;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	
}
