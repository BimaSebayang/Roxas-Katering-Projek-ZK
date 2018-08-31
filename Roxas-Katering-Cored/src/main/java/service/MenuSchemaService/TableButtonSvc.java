package service.MenuSchemaService;

import java.util.List;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;

public interface TableButtonSvc {
       
	  public List<TableButtonDto> getAllRequiredButtonForRecentUser(String userId,
			    String menuCode);
	  
	  public List<TableButtonDto> getAllActiveMenu();
		public List<TableButtonDto> getAllDisactiveMenu();
		public TableButtonDto getTheInformationOfSelectedMenu(String buttonCode);
		
		public int save( TableButtonDto tableButtonDto);
		public int activateButton( TableButtonDto tableButtonDto);
		public int disActivateButton( TableButtonDto tableButtonDto);
		public int deleteButton(TableButtonDto tableButtonDto);
	  
}
