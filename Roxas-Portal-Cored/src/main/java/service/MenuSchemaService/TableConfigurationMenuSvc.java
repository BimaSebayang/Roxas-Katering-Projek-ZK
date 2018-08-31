package service.MenuSchemaService;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import dto.MenuSchemaDto.TableConfigurationMenuDto;

public interface TableConfigurationMenuSvc {
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
	
	
}
