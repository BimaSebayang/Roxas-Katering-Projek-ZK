package RequestMapping.GlobalVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.MasterSchemaDao.TableMasterAllCodeDao;
import entity.MasterSchema.TableMasterAllCode;

@RestController
@RequestMapping("/GlobalVariable")
public class GlobalVariableStatusRequestMapping {
     @Autowired
     private TableMasterAllCodeDao tableMasterAllCodeDao;
	
	@RequestMapping(value = "/OneParamater", method = RequestMethod.POST)
	public Map<String,Object> mapWithOneParam(@RequestBody Map<String,Object> map){
		List<TableMasterAllCode> allCodes = tableMasterAllCodeDao.tableMasterAllCodesWithOneParam((String) map.get("mstColumnName"));
		Map<String,Object> maps = new HashMap<>();
		maps.put("counts", maps.size());
		maps.put("contents", allCodes);
		return maps;
	}
	
	@RequestMapping(value = "/twoParamater", method = RequestMethod.POST)
	public Map<String,Object> mapWithTwoParam(@RequestBody Map<String,Object> map){
		List<TableMasterAllCode> allCodes = tableMasterAllCodeDao.tableMasterAllCodesWithTwoParam
				((String) map.get("mstColumnName"), (String) map.get("mstCodeType"));
		Map<String,Object> maps = new HashMap<>();
		maps.put("counts", maps.size());
		maps.put("contents", allCodes);
		return map;
	}
	
}
