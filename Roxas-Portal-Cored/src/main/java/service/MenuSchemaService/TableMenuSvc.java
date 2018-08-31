package service.MenuSchemaService;

import java.util.List;



import dto.MenuSchemaDto.TableMenuDto;
import dto.MenuSchemaDto.TableUserDto;

public interface TableMenuSvc {
   
	public List<TableMenuDto> getAllRequiredMenuForRecentUser(String userId);
	
	public List<TableMenuDto> getAllActiveMenu();
	public List<TableMenuDto> getAllDisactiveMenu();
	public TableMenuDto getTheInformationOfSelectedMenu(String menuCode);
	
	public int save( TableMenuDto tableMenuDto);
	public int activateMenu( TableMenuDto tableMenuDto);
	public int disActivateMenu( TableMenuDto tableMenuDto);
	public int deleteMenu( TableMenuDto tableMenuDto);
	
	//in case save tidak berhasil
	public int updateMenu( TableMenuDto tableMenuDto);
}
