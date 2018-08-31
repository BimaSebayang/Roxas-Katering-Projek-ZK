package service.MenuSchemaService.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import Master.MapperClass.MappingClassSvc;
import dao.MenuSchemaDao.TableMenuDao;
import entity.MenuSchema.TableMenu;
import service.GenerateAutoId.GenAutoSvc;
import service.MenuSchemaService.TableMenuSvc;

@Service("tableMenuSvc")
@Transactional
public class TableMenuSvcImpl implements TableMenuSvc {
	@Autowired
	private TableMenuDao tableMenuDao;
	@Autowired
	private MappingClassSvc mappingClassSvc;
	@Autowired
	private GenAutoSvc genAutoSvc;
	

	@Override
	public List<TableMenuDto> getAllRequiredMenuForRecentUser(String userId) {
		List<Object[]> objects = tableMenuDao.getAllRequiredMenuForRecentUser();
		List<TableMenuDto> tableMenuDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableMenuDto dto = new TableMenuDto();
			dto.setMenuCode((String) obj[0]);
			dto.setMenuName((String) obj[1]);
			dto.setStatusName((String) obj[2]);
			tableMenuDtos.add(dto);
		}
		return tableMenuDtos;
	}

	@Override
	public List<TableMenuDto> getAllActiveMenu() {
		List<Object[]> objects = tableMenuDao.getAllActiveMenu();
		List<TableMenuDto> tableMenuDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableMenuDto dto = new TableMenuDto();
			dto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(dto, obj[0]);
			dto.setStatusName((String) obj[1]);
			tableMenuDtos.add(dto);
		}
		return tableMenuDtos;
	}

	@Override
	public List<TableMenuDto> getAllDisactiveMenu() {
		List<Object[]> objects = tableMenuDao.getAllDisactiveMenu();
		List<TableMenuDto> tableMenuDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableMenuDto dto = new TableMenuDto();
			dto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(dto, obj[0]);
			dto.setStatusName((String) obj[1]);
			tableMenuDtos.add(dto);
		}
		return tableMenuDtos;
	}

	@Override
	public TableMenuDto getTheInformationOfSelectedMenu(String menuCode) {
		List<Object[]>objects = tableMenuDao.getTheInformationMenu(menuCode);
		TableMenuDto tableMenuDto = new TableMenuDto();
		for (Object[] obj : objects) {
			tableMenuDto.setStatusName((String) obj[1]);
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, obj[0]);
		}
		return tableMenuDto;
	}

	@Override
	public int save(TableMenuDto tableMenuDto) {
		TableMenu tableMenu = new TableMenu();
		tableMenu = (TableMenu) mappingClassSvc.mapperEntityToDto(tableMenu,tableMenuDto);
		tableMenu.setMenuName(tableMenuDto.getMenuName().toUpperCase());
		if(tableMenu.getMenuCode() == null){
		tableMenu.setMenuCode(genAutoSvc.generateAutoIdForCurrentTable("TABLE_MENU", "MENU", 2));
		}
		tableMenuDao.save(tableMenu);
		return 0;
	}

	@Override
	public int activateMenu(TableMenuDto tableMenuDto) {
		tableMenuDao.activateMenu(tableMenuDto.getMenuCode());
		return 0;
	}

	@Override
	public int disActivateMenu(TableMenuDto tableMenuDto) {
		tableMenuDao.disactivateMenu(tableMenuDto.getMenuCode());
		return 0;
	}

	@Override
	public int deleteMenu(TableMenuDto tableMenuDto) {
		tableMenuDao.deleteSelectedMenu(tableMenuDto.getMenuCode());
		return 0;
	}

	
	//incase kalau tidak work
	@Override
	public int updateMenu(TableMenuDto tableMenuDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
