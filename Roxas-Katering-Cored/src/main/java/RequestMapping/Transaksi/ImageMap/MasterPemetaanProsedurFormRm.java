package RequestMapping.Transaksi.ImageMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;
import PagingLib.Slice.SlicePaging;
import service.MasterSchemaService.TableMasterProsedurformDtlSvc;
import service.MasterSchemaService.TableMasterProsedurformHdrSvc;

@RestController
@RequestMapping("/MasterPemetaanProsedurForm")
public class MasterPemetaanProsedurFormRm {
	@Autowired
	private TableMasterProsedurformDtlSvc tableMasterProsedurformDtlSvc;
	@Autowired
	private TableMasterProsedurformHdrSvc tableMasterProsedurformHdrSvc;
	
	@RequestMapping(value = "/GetAllExistingFilter",
			params= {"user","projek","execFilter","search"},
			method = RequestMethod.GET)
	public Map<String,Object> getAllFilterDataInCurrentFilerExec(
			@RequestParam("user") String user,
			@RequestParam("projek") String projek,
			@RequestParam("execFilter") String execFilter,
			@RequestParam("search") String search){
	  List<Object> list = tableMasterProsedurformHdrSvc.getAllDataFilter(user, projek, execFilter, search);
	  Map<String, Object> map = new HashMap<>();
	  map.put("counts", list.size());
	  map.put("contents", list);
	  return map;
    }
	
	 @RequestMapping(value = "/GetAllExistingData",
			    params= {"user","projek","search","page","direction","orderBy"},
				method = RequestMethod.POST)
		public Map<String,Object> loadList(
				@RequestBody TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto,
				@RequestParam("user") String user,
				@RequestParam("projek") String projek,
				@RequestParam("search") String search,
				@RequestParam("page") int page,
				@RequestParam("direction") String direction,
				@RequestParam("orderBy") String orderBy){
		  
		 SlicePaging<TableMasterProsedurformHdrDto> slicer = 
				 tableMasterProsedurformHdrSvc.loadAllList(tableMasterProsedurformHdrDto, user, projek, search,page, direction, orderBy);
		  
		  Map<String, Object> map = new HashMap<>();
		  map.put("counts", slicer.getTotalData());
		  map.put("contents", slicer.getObject());
		  return map;
	      }
	
	@RequestMapping(value = "/collectName", method = RequestMethod.POST)
	public Map<String, Object> collectName(@RequestBody String projekCode){
		List<String> listProsedurName = tableMasterProsedurformHdrSvc.collectAllProsedurName(projekCode);
		List<String> listDetailName = tableMasterProsedurformDtlSvc.collectDetailName(projekCode);
		Map<String, Object> map = new HashMap<>();
		map.put("contextProsedur", listProsedurName);
		map.put("contextDetail", listDetailName);
		return map;
	}
	
	@RequestMapping(value = "/Save", method = RequestMethod.POST)
	public Map<String, Object> collectName(@RequestBody TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto){
		     String obj = tableMasterProsedurformHdrSvc.save(tableMasterProsedurformHdrDto);
		     int p = tableMasterProsedurformDtlSvc.deleteUnusedDetail(tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos(), 
		    		 tableMasterProsedurformHdrDto, obj);
		     int i = 1;
		     for (TableMasterProsedurformDtlDto dto : tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos()) {
				i = tableMasterProsedurformDtlSvc.saveDetail(dto, tableMasterProsedurformHdrDto, obj);
			 }
		      
		     Map<String, Object> mapp = new HashMap<>();
		     if(i==0) {
		     mapp.put("result", "Data Berhasil Disimpan");
		     mapp.put("valid", true);
		     }
		     else {
		     mapp.put("result", "Data Gagal Disimpan");
			 mapp.put("valid", false);
		     }
		     return mapp;
	
	}
	
	@RequestMapping(value="/delete"
			  ,method= RequestMethod.POST)
	  public Map<String,Object> NonAktivasi(
			  @RequestBody TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto){
		     int i = tableMasterProsedurformHdrSvc.delete(tableMasterProsedurformHdrDto);
		     Map<String, Object> mapp = new HashMap<>();
		     if(i==0) {
		     mapp.put("result", "Data Berhasil Dihapus");
		     mapp.put("valid", true);
		     }
		     else {
		     mapp.put("result", "Data Gagal Dihapus");
			 mapp.put("valid", false);
		     }
		     return mapp;
	  }
	
	@RequestMapping(value = "/send",
			params= {"messageId"},
			method = RequestMethod.POST)
	 public Map<String,Object> sendData(
			@RequestParam("messageId") String search, @RequestBody TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto){
	  tableMasterProsedurformHdrSvc.send(tableMasterProsedurformHdrDto);
	  Map<String, Object> map = new HashMap<>();
	  map.put("result", "Data Berhasil Dikirim");
	  return map;
    }
  
    @RequestMapping(value = "/collectInformation",
			method = RequestMethod.POST)
	  public Map<String,Object> collectInformation(@RequestBody Map<String, Object> mapp){
	  List<TableMasterProsedurformHdrDto> tableMasterProsedurformHdrDto = tableMasterProsedurformHdrSvc.collectInformation(mapp);
	  Map<String, Object> map = new HashMap<>();
	  map.put("content", tableMasterProsedurformHdrDto);
	  return map;
     }

}
