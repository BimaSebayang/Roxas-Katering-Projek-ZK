package RequestMapping.MenuUtama;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import Master.MapperClass.MappingClassSvc;
import service.MenuSchemaService.TableConfigurationMenuSvc;

@RestController
@RequestMapping("/MenuUtama")
public class MenuUtamaRequestMapping {
	@Autowired
	private TableConfigurationMenuSvc tableConfigurationMenuSvc;
	@Autowired
	private MappingClassSvc mappingClassSvc;

	@RequestMapping(value="/AllExistingMenuUser/{userId}", method=RequestMethod.GET)
	public Map<String,Object> getAllExistingMenuUser(
			@PathVariable("userId") String userId){
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = tableConfigurationMenuSvc.AllExistingMenuUser(userId);
		Map<String,Object>map = new HashMap<>();
		map.put("counts", tableConfigurationMenuDtos.size());
		map.put("contents", tableConfigurationMenuDtos);
		return map;
	}
	
	@RequestMapping(value="/AllExistingMenuUser", method=RequestMethod.POST)
	public Map<String,Object> getAllExistingMenuUserWithBody(
			@RequestBody Map<String, Object> mapp){
		
		TableUserDto userDto = new TableUserDto();
			userDto = (TableUserDto) mappingClassSvc.mapperLinkedHashMapToClass(mapp, userDto,"userDto");
		
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = tableConfigurationMenuSvc.AllExistingMenuUserWithBody
				(userDto);
		Map<String,Object>map = new HashMap<>();
		map.put("counts", tableConfigurationMenuDtos.size());
		map.put("contents", tableConfigurationMenuDtos);
		return map;
	}
	
	@RequestMapping(value="/AllExistingButtonUser", method=RequestMethod.POST)
	public Map<String,Object> getAllExistingButtonUser(
			@RequestBody Map<String,Object> mapp){
		TableUserDto tableUserDto = new TableUserDto();
				tableUserDto = (TableUserDto) mappingClassSvc.mapperLinkedHashMapToClass(mapp, tableUserDto,"userDto");
		TableMenuDto tableMenuDto = new TableMenuDto();
		         tableMenuDto = (TableMenuDto) mappingClassSvc.mapperLinkedHashMapToClass(mapp, tableMenuDto,"menuDto");
	    List<TableButtonDto> tableButtonDtos = tableConfigurationMenuSvc.
				AllExistingButtonInCurrentUserWithBody(tableUserDto, tableMenuDto);
		Map<String,Object>map = new HashMap<>();
		map.put("counts", tableButtonDtos.size());
		map.put("contents", tableButtonDtos);
		return map;
	}
}
