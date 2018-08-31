package service.MasterSchemaService;

import java.util.List;

import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;

public interface TableMasterProsedurformDtlSvc {
      
	public List<String> collectDetailName(String projekCode);
	public int saveDetail(TableMasterProsedurformDtlDto tableMasterProsedurformDtlDto, TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto, String prosedurId);
    public int deleteUnusedDetail(List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDto,TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto, String prosedurId);
}
