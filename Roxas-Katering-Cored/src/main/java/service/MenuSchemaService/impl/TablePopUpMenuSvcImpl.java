package service.MenuSchemaService.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MenuSchemaDto.TablePopUpMenuDto;
import Master.MapperClass.MappingClassSvc;
import dao.MenuSchemaDao.TablePopUpMenuDao;
import entity.MenuSchema.TablePopUpMenu;
import service.MenuSchemaService.TablePopUpMenuSvc;

@Service("tablePopUpMenuSvc")
@Transactional
public class TablePopUpMenuSvcImpl implements TablePopUpMenuSvc{
     @Autowired
     private TablePopUpMenuDao tablePopUpMenuDao;
     @Autowired 
     private MappingClassSvc mappingClassSvc;
     
	@Override
	public TablePopUpMenuDto requestPopUpMenu(String request) {
		List<TablePopUpMenu> popUpMenus = tablePopUpMenuDao.requestPopUpMenu(request);
		TablePopUpMenuDto dto = new TablePopUpMenuDto();
		for (TablePopUpMenu tablePopUpMenu : popUpMenus) {
		   dto = (TablePopUpMenuDto) mappingClassSvc.mapperEntityToDto(dto, tablePopUpMenu);	
		}
		return dto;
	}

}
