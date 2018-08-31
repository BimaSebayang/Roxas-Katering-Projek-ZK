package service.MasterSchemaService;

import java.util.List;
import java.util.Map;

import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import PagingLib.Slice.SlicePaging;

public interface TableMasterPelangganKateringSvc {
   public SlicePaging<TableMasterPelangganKateringDto> loadAllList(TableMasterPelangganKateringDto filter, String user,
		   String projek, String search,int page, String direction, String orderBy);
   public List<Object> getAllDataFilter(String user, String projek,String filterExec, String search); 
   public int save(TableMasterPelangganKateringDto tableMasterPelangganKateringDto);
   public int deletePelanggan(TableMasterPelangganKateringDto tableMasterPelangganKateringDto);
   public void send(TableMasterPelangganKateringDto tableMasterPelangganKateringDto);
   public TableMasterPelangganKateringDto collectInformation(Map<String,Object> mapp);
}
