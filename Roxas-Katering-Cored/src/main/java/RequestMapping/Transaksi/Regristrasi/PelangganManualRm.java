package RequestMapping.Transaksi.Regristrasi;

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
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import PagingLib.Slice.SlicePaging;
import service.MasterSchemaService.TableMasterPelangganKateringSvc;

@RestController
@RequestMapping("/PelangganManual")
public class PelangganManualRm {
@Autowired
private TableMasterPelangganKateringSvc tableMasterPelangganKateringSvc;
	
	  @RequestMapping(value = "/GetAllExistingData",
			    params= {"user","projek","search","page","direction","orderBy"},
				method = RequestMethod.POST)
		public Map<String,Object> loadList(
				@RequestBody TableMasterPelangganKateringDto tableMasterPelangganKateringDto,
				@RequestParam("user") String user,
				@RequestParam("projek") String projek,
				@RequestParam("search") String search,
				@RequestParam("page") int page,
				@RequestParam("direction") String direction,
				@RequestParam("orderBy") String orderBy){
		  
		  SlicePaging<TableMasterPelangganKateringDto> sliceRequest = tableMasterPelangganKateringSvc.
				  loadAllList(tableMasterPelangganKateringDto, user, projek, search,page, direction, orderBy);
		  
		  Map<String, Object> map = new HashMap<>();
		  map.put("counts", sliceRequest.getTotalData());
		  map.put("contents", sliceRequest.getObject());
		  return map;
	      }
	  
	  @RequestMapping(value = "/GetAllExistingFilter",
				params= {"user","projek","execFilter","search"},
				method = RequestMethod.GET)
		public Map<String,Object> getAllFilterDataInCurrentFilerExec(
				@RequestParam("user") String user,
				@RequestParam("projek") String projek,
				@RequestParam("execFilter") String execFilter,
				@RequestParam("search") String search){
		  List<Object> list = tableMasterPelangganKateringSvc.getAllDataFilter(user, projek, execFilter, search);
		  Map<String, Object> map = new HashMap<>();
		  map.put("counts", list.size());
		  map.put("contents", list);
		  return map;
	    }
	  
	  @RequestMapping(value="/Save",method= RequestMethod.POST)
	  public Map<String,Object> save(
			  @RequestBody TableMasterPelangganKateringDto tableMasterPelangganKateringDto){
		     int i = tableMasterPelangganKateringSvc.save(tableMasterPelangganKateringDto);
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
			  @RequestBody TableMasterPelangganKateringDto tableMasterPelangganKateringDto){
		     int i = tableMasterPelangganKateringSvc.deletePelanggan(tableMasterPelangganKateringDto);
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
				@RequestParam("messageId") String search, @RequestBody TableMasterPelangganKateringDto tableMasterPelangganKateringDto){
		  tableMasterPelangganKateringSvc.send(tableMasterPelangganKateringDto);
		  Map<String, Object> map = new HashMap<>();
		  map.put("result", "Data Berhasil Dikirim");
		  return map;
	}
	  
	 @RequestMapping(value = "/collectInformation",
				method = RequestMethod.POST)
		  public Map<String,Object> collectInformation(@RequestBody Map<String, Object> mapp){
		  TableMasterPelangganKateringDto tableMasterPelangganKateringDto = tableMasterPelangganKateringSvc.collectInformation(mapp);
		  Map<String, Object> map = new HashMap<>();
		  map.put("content", tableMasterPelangganKateringDto);
		  return map;
	}
	  
}
