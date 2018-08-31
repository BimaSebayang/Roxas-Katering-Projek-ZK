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

import DataTransferObjectLib.MasterSchemaDto.TableMasterMenuMasakanDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import PagingLib.Slice.SlicePaging;
import service.MenuSchemaService.TableMasterMenuMasakanSvc;

@RestController
@RequestMapping("/MenuMasakan")
public class MenuMasakanRm {
	
	@Autowired
	private TableMasterMenuMasakanSvc tableMasterMenuMakananSvc;
	
	@RequestMapping(value = "/GetAllExistingData",
		    params= {"user","projek","search","page","direction","orderBy"},
			method = RequestMethod.POST)
	public Map<String,Object> loadList(
			@RequestBody TableMasterMenuMasakanDto tableMasterMenuMasakanDto,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek,
			@RequestParam("search") String search,
			@RequestParam("page") int page,
			@RequestParam("direction") String direction,
			@RequestParam("orderBy") String orderBy){
	  
	  SlicePaging<TableMasterMenuMasakanDto> sliceRequest = tableMasterMenuMakananSvc.
			  loadAllList(tableMasterMenuMasakanDto, user, projek, search,page, direction, orderBy);
	  
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
	  List<Object> list = tableMasterMenuMakananSvc.getAllDataFilter(user, projek, execFilter, search);
	  Map<String, Object> map = new HashMap<>();
	  map.put("counts", list.size());
	  map.put("contents", list);
	  return map;
    }
}
