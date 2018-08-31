package service.MenuSchemaService;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import PagingLib.Slice.SlicePaging;

public interface TableConfigurationMenuSvc  {
    public List<TableConfigurationMenuDto> menuLogin();
    public List<TableConfigurationMenuDto> AllExistingMenuAndButtonForCurrentUser(String userId);
    public List<TableConfigurationMenuDto> AllExistingMenuUser(String userId);
    public List<TableConfigurationMenuDto> AllExistingButtonInCurrentUser(String userId
			,String menuCode);
    public List<TableConfigurationMenuDto> AllNonActiveConfigurationMenu();
    public List<TableConfigurationMenuDto> AllActiveConfigurationMenu();
    
    public int save(TableConfigurationMenuDto tableConfigurationMenuDto);
    public int activateConfigurationMenu(String updatedBy,Date updatedDate, String menuCode, 
    		String menuButton , String userId);
    public int disactivateConfigurationMenu(String updatedBy,Date updatedDate, String menuCode, 
    		String menuButton , String userId);
    public int deleteConfiguration(String menuCode, String menuButton ,String userId);
	
	
    
    //Start For Projek Katering 
    public List<TableConfigurationMenuDto> AllExistingMenuUserWithBody(TableUserDto tableUserDto);
    public List<TableButtonDto> AllExistingButtonInCurrentUserWithBody(TableUserDto tableUserDto, 
    		TableMenuDto tableMenuDto);
    public int aktivasiNew(List<TableConfigurationMenuDto> tableConfigurationMenuDtos, String projek, String user);
    public int nonAktivasiNew(List<TableConfigurationMenuDto> tableConfigurationMenuDtos, String projek, String user);
    public int saveNew(TableConfigurationMenuDto tableConfigurationMenuDto);
    public SlicePaging<TableConfigurationMenuDto> getIndexOfAllDataInMasterConfigurasiMenu(TableConfigurationMenuDto filter,
    		String user, String projek, String search,int page, String direction, String orderBy); 
    public List<Object> getAllDataFilter(String user, String projek,String filterExec, String search); 
    public List<TableConfigurationMenuDto> getAllDataAktifDanNonAktif(String user, String projek, String search, String status);
    //End For Projek Katering
}
