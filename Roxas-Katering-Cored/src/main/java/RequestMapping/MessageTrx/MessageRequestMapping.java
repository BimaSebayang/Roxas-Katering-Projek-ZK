package RequestMapping.MessageTrx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageDtlDto;
import DataTransferObjectLib.MassageSchemaDto.TableApprovalMessageHdrDto;
import Master.MapperClass.MappingClassSvc;
import dao.TrxApprovalDao;
import entity.MassageSchema.TableApprovalMessageDtl;
import entity.MassageSchema.TableApprovalMessageHdr;

@RestController
@RequestMapping("/message")
public class MessageRequestMapping {
  
	@Autowired
	private TrxApprovalDao trxApprovalDao;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	@RequestMapping(value = "/collectUserApproval",
			params= {"user","projek","search"},
			method = RequestMethod.GET)
	public Map<String,Object> CollectUserApproval(
			@RequestParam("search") String search,
			@RequestParam("user") String user,
			@RequestParam("projek") String projek){
		       
		        List<TableApprovalMessageDtlDto> tableApprovalMessageDtlDtos = new ArrayList<>();
		        List<Object[]> collectUserApproval = trxApprovalDao.collectUserMessage(user, projek, "%"+search+"%");
		        for (Object[] ob : collectUserApproval) {
					TableApprovalMessageDtlDto dto = new TableApprovalMessageDtlDto();
					TableApprovalMessageHdr tableApprovalMessageHdr = (TableApprovalMessageHdr) ob[0];
					TableApprovalMessageDtl tableApprovalMessageDtl = (TableApprovalMessageDtl) ob[1];
					String menuName = (String) ob[2];
					String namaKaryawan = (String) ob[3];
					TableApprovalMessageDtlDto tableApprovalMessageDtlDto = new TableApprovalMessageDtlDto();
					TableApprovalMessageHdrDto tableApprovalMessageHdrDto = new TableApprovalMessageHdrDto();
					tableApprovalMessageDtlDto = (TableApprovalMessageDtlDto) mappingClassSvc.mapperEntityToDto(tableApprovalMessageDtlDto, tableApprovalMessageDtl);
					tableApprovalMessageHdrDto = (TableApprovalMessageHdrDto) mappingClassSvc.mapperEntityToDto(tableApprovalMessageHdrDto, tableApprovalMessageHdr);
					tableApprovalMessageDtlDto.setTableApprovalMessageHdrDto(tableApprovalMessageHdrDto);
					tableApprovalMessageDtlDto.setMenuName(menuName);
					tableApprovalMessageDtlDto.setNamaKaryawan(namaKaryawan);
					tableApprovalMessageDtlDto.setUrlMenuApproval((String) ob[4]);
					tableApprovalMessageDtlDtos.add(tableApprovalMessageDtlDto);
				}
		        Map<String, Object> map = new HashMap<>();
		        map.put("counts", tableApprovalMessageDtlDtos.size());
		  	    map.put("contents", tableApprovalMessageDtlDtos);
				return map;
	}
	
}
