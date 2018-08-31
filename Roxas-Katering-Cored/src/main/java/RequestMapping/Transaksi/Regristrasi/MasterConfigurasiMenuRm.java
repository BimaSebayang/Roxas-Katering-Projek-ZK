package RequestMapping.Transaksi.Regristrasi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import PagingLib.Slice.SlicePaging;
import service.MenuSchemaService.TableConfigurationMenuSvc;
import entity.MenuSchema.TableConfigurationMenu;

@RestController
@RequestMapping("/MasterConfigurasiMenu")
public class MasterConfigurasiMenuRm {
  @Autowired
  private TableConfigurationMenuSvc tableConfigurationMenuSvc;
	
  
  @RequestMapping(value = "/allAktifList",
			params= {"search","user", "projek"},
			method = RequestMethod.GET)
	public Map<String,Object> getAllAktifList(
			@RequestParam("search") String search,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek){
	  List<TableConfigurationMenuDto> list = tableConfigurationMenuSvc.getAllDataAktifDanNonAktif(user, projek, search,"1");
	  Map<String, Object> map = new HashMap<>();
	  map.put("counts", list.size());
	  map.put("contents", list);
	  return map;
  }
  
  @RequestMapping(value = "/allNonAktifList",
			params= {"search","user", "projek"},
			method = RequestMethod.GET)
	public Map<String,Object> getAllNonAktifList(
			@RequestParam("search") String search,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek){
	  List<TableConfigurationMenuDto> list = tableConfigurationMenuSvc.getAllDataAktifDanNonAktif(user, projek, search,"0");
	  Map<String, Object> map = new HashMap<>();
	  map.put("counts", list.size());
	  map.put("contents", list);
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
	  List<Object> list = tableConfigurationMenuSvc.getAllDataFilter(user, projek, execFilter,search);
	  Map<String, Object> map = new HashMap<>();
	  map.put("counts", list.size());
	  map.put("contents", list);
	  return map;
    }
  
  @RequestMapping(value = "/GetAllExistingData",
			params= {"user","projek","search","page","direction","orderBy"},
			method = RequestMethod.POST)
	public Map<String,Object> getIndexOfAllDataInMasterConfigurasiMenu(
			@RequestBody TableConfigurationMenuDto tempTableConfigurationMenuDto,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek,
			@RequestParam("search") String search,
			@RequestParam("page") int page,
			@RequestParam("direction") String direction,
			@RequestParam("orderBy") String orderBy){
	  
	  SlicePaging<TableConfigurationMenuDto> slice = tableConfigurationMenuSvc.
			  getIndexOfAllDataInMasterConfigurasiMenu(tempTableConfigurationMenuDto, user, projek, search,page,direction,orderBy);
	  
	  Map<String, Object> map = new HashMap<>();
	  map.put("counts", slice.getTotalData());
	  map.put("contents", slice.getObject());
	  return map;
      }
  
  @RequestMapping(value="/Save",method= RequestMethod.POST)
  public Map<String,Object> save(
		  @RequestBody TableConfigurationMenuDto tableConfigurationMenuDto){
	     int i = tableConfigurationMenuSvc.saveNew(tableConfigurationMenuDto);
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
  
  @RequestMapping(value="/Aktivasi", 
		  params= {"user", "projek"}
		  ,method= RequestMethod.POST)
  public Map<String,Object> Aktivasi(
		  @RequestParam("user") String user,
		  @RequestParam("projek") String projek,
		  @RequestBody List<TableConfigurationMenuDto> tableConfigurationMenuDtos){
	     int i = tableConfigurationMenuSvc.aktivasiNew(tableConfigurationMenuDtos, projek, user);
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
  
  @RequestMapping(value="/NonAktivasi",
		  params= {"user", "projek"}
		  ,method= RequestMethod.POST)
  public Map<String,Object> NonAktivasi(
		  @RequestParam("user") String user,
		  @RequestParam("projek") String projek,
		  @RequestBody List<TableConfigurationMenuDto> tableConfigurationMenuDtos){
	     int i = tableConfigurationMenuSvc.nonAktivasiNew(tableConfigurationMenuDtos, projek, user);
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
		  @RequestBody TableConfigurationMenuDto tableConfigurationMenuDto){
	     int i = tableConfigurationMenuSvc.deleteConfiguration(tableConfigurationMenuDto.getMenuCode(),
	    		 tableConfigurationMenuDto.getMenuButton(), tableConfigurationMenuDto.getUserId());
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
  

  
  
}
