package service.MasterSchemaService.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;
import Master.MapperClass.MappingClassSvc;
import dao.ProcedureDao;
import dao.MasterSchemaDao.TableMasterProsedurformDtlDao;
import entity.MasterSchema.TableMasterProsedurformDtl;
import service.MasterSchemaService.TableMasterProsedurformDtlSvc;

@Service("tableMasterProsedurformDtlSvc")
@Transactional
public class TableMasterProsedurformDtlSvcImpl implements TableMasterProsedurformDtlSvc {
	@Autowired
	private TableMasterProsedurformDtlDao tableMasterProsedurformDtlDao;
	@Autowired
	private ProcedureDao procedureDao;
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	@Override
	public List<String> collectDetailName(String projekCode) {
		List<String> allList = tableMasterProsedurformDtlDao.collectAllExistingDetaillProsedurName(projekCode);
		return allList;
	}

	@Override
	public int saveDetail(TableMasterProsedurformDtlDto tableMasterProsedurformDtlDto, TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto, String prosedurId) {
		TableMasterProsedurformDtl tableMasterProsedurformDtl = new TableMasterProsedurformDtl();
		if(tableMasterProsedurformDtlDto.getProsedurIdDetail()==null) {
		tableMasterProsedurformDtl = (TableMasterProsedurformDtl) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformDtl,tableMasterProsedurformDtlDto);
					String prosedurIdDetail = procedureDao.generateNextNumber("FORM12",tableMasterProsedurformHdrDto.getCreatedBy(), tableMasterProsedurformHdrDto.getProjekCode(),
							"TRANKAT13", tableMasterProsedurformHdrDto.getCreatedDate());
					tableMasterProsedurformDtl = (TableMasterProsedurformDtl) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformDtl, tableMasterProsedurformDtlDto);
					tableMasterProsedurformDtl.setProsedurId(prosedurId);
					tableMasterProsedurformDtl.setProsedurIdDetail(prosedurIdDetail);
					tableMasterProsedurformDtl.setCreatedBy(tableMasterProsedurformHdrDto.getCreatedBy());
					tableMasterProsedurformDtl.setCreatedDate(tableMasterProsedurformHdrDto.getCreatedDate());
					tableMasterProsedurformDtl.setProjekCode(tableMasterProsedurformHdrDto.getProjekCode());
					String url = "/Prosedure Picture/Save Folder/Master Pemetaan Prosedur/"+tableMasterProsedurformDtlDto.getDetailName() + ".jpg";
					tableMasterProsedurformDtl.setUrlDetailPicture(url);
					System.err.println("prosedur dtl : " + prosedurIdDetail);
					tableMasterProsedurformDtlDao.save(tableMasterProsedurformDtl);
		}
		else {
			tableMasterProsedurformDtl = (TableMasterProsedurformDtl) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformDtl, tableMasterProsedurformDtlDto);
			tableMasterProsedurformDtl.setUpdatedBy(tableMasterProsedurformHdrDto.getUpdatedBy());
			tableMasterProsedurformDtl.setUpdatedDate(tableMasterProsedurformHdrDto.getUpdatedDate());
			tableMasterProsedurformDtl.setProjekCode(tableMasterProsedurformHdrDto.getProjekCode());
			procedureDao.createHistoryTrancsaction(tableMasterProsedurformDtl.getProsedurIdDetail(), 
					"FORM12","TRANKAT13", tableMasterProsedurformHdrDto.getProjekCode(), "EDIT BY USER","0", tableMasterProsedurformHdrDto.getUpdatedBy(), 
					tableMasterProsedurformHdrDto.getUpdatedDate());
			        tableMasterProsedurformDtlDao.save(tableMasterProsedurformDtl);
		}
		return 0;
	}

	@Override
	public int deleteUnusedDetail(List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDto,
			TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto, String prosedurId) {
		List<String> allDetail = tableMasterProsedurformDtlDao.getAllDetail(tableMasterProsedurformHdrDto.getProjekCode(), tableMasterProsedurformHdrDto.getProsedurId());
		List<String> getDtlThatWillSave = new ArrayList<>();
		for (TableMasterProsedurformDtlDto ob: tableMasterProsedurformDtlDto) {
			getDtlThatWillSave.add(ob.getProsedurIdDetail());
		}
		for (String ob : allDetail) {
			if(!getDtlThatWillSave.contains(ob)) {
				tableMasterProsedurformDtlDao.deleteUnusedDetail(tableMasterProsedurformHdrDto.getProjekCode(), tableMasterProsedurformHdrDto.getProsedurId(), 
						ob);
				procedureDao.createHistoryTrancsaction(ob, 
						"FORM12","TRANKAT13", tableMasterProsedurformHdrDto.getProjekCode(), "DELETE BY USER","1", tableMasterProsedurformHdrDto.getUpdatedBy(), 
						tableMasterProsedurformHdrDto.getUpdatedDate());
			}
		}

		return 0;
	}

}
