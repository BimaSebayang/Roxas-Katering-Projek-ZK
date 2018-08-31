package RequestMapping.GlobalVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import DataTransferObjectLib.MasterSchemaDto.TableMasterKotaDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProvinsiDto;
import Master.MapperClass.MappingClassSvc;
import dao.MasterSchemaDao.TableMasterAllCodeDao;
import dao.MasterSchemaDao.TableMasterKotaDao;
import dao.MasterSchemaDao.TableMasterProvinsiDao;
import entity.MasterSchema.TableMasterAllCode;
import entity.MasterSchema.TableMasterKota;
import entity.MasterSchema.TableMasterProvinsi;
import entity.MasterSchema.entityMasterPk.TableMasterProvinsiPk;

@RestController
@RequestMapping("/GlobalVariable")
public class GlobalVariableStatusRequestMapping {
     @Autowired
     private TableMasterAllCodeDao tableMasterAllCodeDao;
     @Autowired
     private TableMasterKotaDao tableMasterKotaDao;
     @Autowired
     private TableMasterProvinsiDao tableMasterProvinsiDao;
     @Autowired
     private MappingClassSvc mappingClassSvc;
	
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
	
	@RequestMapping(value="/getKota",  method = RequestMethod.POST)
	public Map<String, Object> mapGetKota(@RequestBody Map<String,Object> map){
		List<TableMasterKota> allKotas = tableMasterKotaDao.listTableMasterKota((String) map.get("kodeProvinsi"));
		List<TableMasterKotaDto> tableMasterKotaDtos = new ArrayList<>();
		for (TableMasterKota kota : allKotas) {
			TableMasterKotaDto dto = new TableMasterKotaDto();
			dto = (TableMasterKotaDto) mappingClassSvc.mapperEntityToDto(dto, kota);
			tableMasterKotaDtos.add(dto);
		}
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", tableMasterKotaDtos.size());
		maps.put("contents", tableMasterKotaDtos);
		return maps;
	}
	
	@RequestMapping(value="/getProvinsi",  method = RequestMethod.POST)
	public Map<String, Object> mapGetProvinsi(@RequestBody Map<String,Object> map){
		List<TableMasterProvinsi> tableMasterProvinsis = tableMasterProvinsiDao.listTableMasterProvinsi((String) map.get("kodeKota"));
		List<TableMasterProvinsiDto> tableMasterProvinsiDtos = new ArrayList<>();
		for (TableMasterProvinsi provinsi : tableMasterProvinsis) {
			TableMasterProvinsiDto dto = new TableMasterProvinsiDto();
			dto = (TableMasterProvinsiDto) mappingClassSvc.mapperEntityToDto(dto, provinsi);
			tableMasterProvinsiDtos.add(dto);
		}
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts",tableMasterProvinsiDtos.size());
		maps.put("contents", tableMasterProvinsiDtos);
		return maps;
	}
}
