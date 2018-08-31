package service.MasterSchemaService;

import java.util.List;
import java.util.Map;


import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;
import PagingLib.Slice.SlicePaging;

public interface TableMasterProsedurformHdrSvc {
    public List<String> collectAllProsedurName(String projekCode);
    public String save(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto);
    public SlicePaging<TableMasterProsedurformHdrDto> loadAllList(TableMasterProsedurformHdrDto filter, String user, String projek, String search, int page, String direction, String orderBy);
    public void send(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto);
    public List<Object> getAllDataFilter(String user, String projek, String filterExec, String search);
    public List<TableMasterProsedurformHdrDto> collectInformation(Map<String,Object> mapp);
    public int delete(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto);
}
