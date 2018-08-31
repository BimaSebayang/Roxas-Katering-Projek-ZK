package RequestMapping.PopUp.PopUp1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import service.PopUpService.PopUp1Service.AllRegisteredPopUpSvc;

@RestController
@RequestMapping("/popUp1")
public class AllRegisteredPopUpRm {

	@Autowired
	private AllRegisteredPopUpSvc allRegisteredPopUpSvc;
	
	@RequestMapping(value = "/GetAllExistingUser",
			params= {"user","projek","search"},
			method = RequestMethod.POST)
	public Map<String,Object> getIndexOfAllDataInMasterConfigurasiMenu(
			@RequestBody Map<String, Object> mapp,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek,
			@RequestParam("search") String search){
	    
		 List<TableUserDto> getAllUser = allRegisteredPopUpSvc.getAllUserTableDto(mapp, search, projek);
		  
		  Map<String, Object> map = new HashMap<>();
		  map.put("counts", getAllUser.size());
		  map.put("contents",getAllUser);
		  return map;
	}
	
	@RequestMapping(value = "/GetAllExistingMenu",
			params= {"user","projek","search"},
			method = RequestMethod.POST)
	public Map<String,Object> GetAllExistingMenu(
			@RequestBody Map<String, Object> mapp,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek,
			@RequestParam("search") String search){
	    
		 List<TableMenuDto> getAllMenus = allRegisteredPopUpSvc.getAllMenuDto(mapp, search, projek);
		  
		  Map<String, Object> map = new HashMap<>();
		  map.put("counts", getAllMenus.size());
		  map.put("contents",getAllMenus);
		  return map;
	}
	
	@RequestMapping(value = "/GetAllExistingButton",
			params= {"user","projek","search"},
			method = RequestMethod.POST)
	public Map<String,Object> GetAllExistingButton(
			@RequestBody Map<String, Object> mapp,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek,
			@RequestParam("search") String search){
	    
		 List<TableButtonDto> getAllButton = allRegisteredPopUpSvc.getAllButtonDto(mapp, search, projek);
		  
		  Map<String, Object> map = new HashMap<>();
		  map.put("counts", getAllButton.size());
		  map.put("contents",getAllButton);
		  return map;
	}
	
}
