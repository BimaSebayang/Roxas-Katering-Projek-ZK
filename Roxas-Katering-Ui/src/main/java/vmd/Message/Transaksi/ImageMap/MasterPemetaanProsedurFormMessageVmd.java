package vmd.Message.Transaksi.ImageMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Window;
import org.zkoss.zul.Messagebox.Button;

import com.google.gson.reflect.TypeToken;

import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterKotaDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProvinsiDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import vmd.Transaksi.ImageMap.MasterPemetaanProsedurFormVmd;

@Init(superclass = true)
public class MasterPemetaanProsedurFormMessageVmd extends MasterPemetaanProsedurFormVmd implements Serializable  {
	private static final long serialVersionUID = 1L;

	  private Map<String, Object> mappo = new HashMap<>();
	  public void getObjectInformation() {
	    	mappo = (Map<String, Object>) Executions.getCurrent().getAttribute("ObjectInformation");
	   }
	  
	  @Command("approvedForm")
		public void approvedForm(@BindingParam("destroy")  Window lov){
	    	detectQuestionMessageBox3(lov, "APPD", "Menyetujui");
		}
	    
	    @Command("revisedForm")
		public void revisedForm(@BindingParam("destroy")  Window lov){
	    	detectQuestionMessageBox3(lov, "REVS", "Merevisi");
		}
	    
	    @Command("rejectedForm")
		public void rejectedForm(@BindingParam("destroy")  Window lov){
	    	detectQuestionMessageBox3(lov, "REJE", "Menolak");
		}
	    
	    @Command("destroyMessage")
		public void destroyMessage(@BindingParam("destroy")  Window lov){
	    	detectQuestionMessageBox2(lov);
		}
	    
	    @SuppressWarnings("unchecked")
		protected void detectQuestionMessageBox3(final Window lov, final String statusApproval, final String command) {
			Map<String, String> params = new HashMap();
			params.put("sclass", "myMessagebox");
			Messagebox.show(" Apakah Anda Ingin "+ command +" Transaksi Ini ? ", "Konfirmasi",
					new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
						@Override
						public void onEvent(Event evt) throws Exception {
							if (evt.getName().equals("onOK")) {
								tableMasterProsedurformHdrDto.setUpdatedBy(getCurrentEmployeId());
							    tableMasterProsedurformHdrDto.setUpdatedDate(new Date());
							    tableMasterProsedurformHdrDto.setStatusApproval(statusApproval);
							    Map<String, Object> mapp = CallRequestMappingJava("/MasterPemetaanProsedurForm/send",
							    tableMasterProsedurformHdrDto, "POST","messageId="+tableMasterProsedurformHdrDto.getMessageId());
								String result = (String) mapp.get("result");
								showInformationMessageBox(result);
								lov.detach();
							} else {
								return;
							}
						}
					}, params);
		}
	    
	    @SuppressWarnings("unchecked")
		protected void detectQuestionMessageBox2(final Window lov) {
			Map<String, String> params = new HashMap();
			params.put("sclass", "myMessagebox");
			Messagebox.show(" Apakah Anda Ingin Keluar Dari Form Ini? ", "Konfirmasi",
					new Button[] { Button.OK, Button.CANCEL }, null, Messagebox.QUESTION, null, new EventListener() {
						@Override
						public void onEvent(Event evt) throws Exception {
							if (evt.getName().equals("onOK")) {
								lov.detach();
							} else {
								return;
							}
						}
					}, params);
		}
	  
	  public void initIndex() {
			tableApprovalMessageDtlDto = (TableApprovalMessageDtlDto) mappo.get("messageInformation");
			tableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
			tableMasterProsedurformDtlDtos.clear();
			Map<String, Object> map = new HashMap<>();
			map.put("trxId", tableApprovalMessageDtlDto.getTableApprovalMessageHdrDto().getTrxId());
			map.put("projekCode", getCurrentProjek());
			Map<String, Object> mapRequest = new HashMap<>();
			mapRequest = CallRequestMappingJava("/MasterPemetaanProsedurForm/collectInformation",
					map,"POST");
			List<TableMasterProsedurformHdrDto> tableMasterProsedurformHdrDtos = new ArrayList<>();
			tableMasterProsedurformHdrDtos =getJava().mapperJsonToListDto(mapRequest,
					new TypeToken<ArrayList<TableMasterProsedurformHdrDto>>() {
					}.getType(), tableMasterProsedurformHdrDtos, "content");
			tableMasterProsedurformHdrDto = tableMasterProsedurformHdrDtos.get(0);
			tableMasterProsedurformHdrDto.setMessageId(tableApprovalMessageDtlDto.getMessageId());
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
			BindUtils.postNotifyChange(null, null, this, "tableMasterKotaDto");
			BindUtils.postNotifyChange(null, null, this, "tableMasterProvinsiDto");
			initBackground();
		}
		
		@Override
		public void loadListAll(TableMenuDto menu) {
			getObjectInformation();
			initIndex();
			//Messagebox.show("Banyaknya adalah : " + tableApprovalMessageDtlDtos.size());
			super.loadListAll(menu);
		}
}
