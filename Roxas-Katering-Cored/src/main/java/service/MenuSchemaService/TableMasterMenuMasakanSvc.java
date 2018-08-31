package service.MenuSchemaService;

import java.util.List;

import DataTransferObjectLib.MasterSchemaDto.TableMasterMenuMasakanDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import PagingLib.Slice.SlicePaging;

public interface TableMasterMenuMasakanSvc {
	public SlicePaging<TableMasterMenuMasakanDto> loadAllList(TableMasterMenuMasakanDto  filter,
    		String user, String projek, String search,int page, String direction, String orderBy); 
	public List<Object> getAllDataFilter(String user, String projek,String filterExec, String search); 
}
