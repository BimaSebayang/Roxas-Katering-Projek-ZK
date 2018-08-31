package RequestMapping.PortalCored;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Master.MapperClass.MappingClassSvc;
import dao.PortalSchemaDao.TablePortalProjekDao;
import dto.PortalSchemaDto.TablePortalProjekDetailDto;
import entity.MasterSchema.TableMasterAllCode;
import entity.PortalSchema.TablePortalProjekDetail;
import entity.PortalSchema.TablePortalProjek;

@RestController
@RequestMapping("/PortalCored")
public class PortalCoredRequestMapping {
	@Autowired
	private TablePortalProjekDao tablePortalProjekDao;
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	//ini hal pokok untuk bisa masuk ke portal
	@RequestMapping(value = "GetAllExistingPortalInCurrentUser/{userId}/{projekCode}",
			params= {"token","status","orderBy","search"},
			method = RequestMethod.GET)
	public Map<String,Object> mapWithOneParam(
			@PathVariable("userId") String userId,
			@PathVariable("projekCode") String projekCode,
			@RequestParam("token") String token,
			@RequestParam("status") Integer status,
			@RequestParam("orderBy") String orderBy,
			@RequestParam("search") String search){

		List<Object[]> collectAllPortal = new ArrayList<>();
		System.err.println("========= Lemparan request Param Start =========== " );
		System.err.println("token : " + token );
		System.err.println("status : " + status );
		System.err.println("order by : " + orderBy );
		System.err.println("search : " + search );
		System.err.println("========= Lemparan request Param End =========== " );
		if(orderBy.equalsIgnoreCase("ASC")){
		collectAllPortal = 
				tablePortalProjekDao.collectAllExistingPortalInCurrentUserIdAsc(userId,"%"+search+"%");
		}
		else if(orderBy.equalsIgnoreCase("DESC")){
		collectAllPortal = 
				tablePortalProjekDao.collectAllExistingPortalInCurrentUserIdDesc(userId,"%"+search+"%");
		}
		System.err.println("urutan nama projek : " );
		List<TablePortalProjekDetailDto> tablePortalProjekDetailDtos = new ArrayList<>();
		int li = 1;
 		for (Object[] obj : collectAllPortal) {
			TablePortalProjekDetailDto tablePortalProjekDetailDto = new TablePortalProjekDetailDto();
			TablePortalProjek tablePortalProjek = (TablePortalProjek) obj[0];
			TablePortalProjekDetail tablePortalProjekDetail =  (TablePortalProjekDetail) obj[1];
			tablePortalProjekDetailDto = (TablePortalProjekDetailDto) mappingClassSvc.
					mapperEntityToDto(tablePortalProjekDetailDto, tablePortalProjekDetail);
			tablePortalProjekDetailDto.setNamaPortal(tablePortalProjek.getNamaPortal());
			tablePortalProjekDetailDto.setUrlPortal(tablePortalProjek.getUrlPortal());
			tablePortalProjekDetailDto.setUrlGambar((String) obj[2]);
			tablePortalProjekDetailDtos.add(tablePortalProjekDetailDto);
			System.err.println(" urutan - " + li + tablePortalProjekDetailDto.getNamaPortal() );
		}
		
		Map<String, Object> maps = new HashMap<>();
		maps.put("counts", tablePortalProjekDetailDtos.size());
		maps.put("contents", tablePortalProjekDetailDtos);
		return maps;
	}
}
