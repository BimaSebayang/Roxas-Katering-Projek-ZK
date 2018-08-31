package service.MenuSchemaService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CustomDao.MenuSchemaCustomDao.TableConfigurationMenuCustomDaoSvc;
import Master.JsonConverterGroup.JsonConverterSvc;
import Master.MapperClass.MappingClassSvc;
import dao.MenuSchemaDao.TableConfigurationMenuDao;
import dto.MenuSchemaDto.TableButtonDto;
import dto.MenuSchemaDto.TableConfigurationMenuDto;
import dto.MenuSchemaDto.TableMenuDto;
import dto.PegawaiSchemaDto.TableJobDto;
import entity.MenuSchema.TableButton;
import entity.MenuSchema.TableConfigurationMenu;
import entity.MenuSchema.TableMenu;
import entity.PegawaiSchema.TableJob;
import service.MenuSchemaService.TableConfigurationMenuSvc;

@Service("tableConfigurationMenuSvc")
@Transactional
public class TableConfigurationMenuSvcImpl implements TableConfigurationMenuSvc{

	@Autowired
	private TableConfigurationMenuCustomDaoSvc tableConfigurationMenuCustomDaoSvc;
	
	@Autowired
	private TableConfigurationMenuDao tableConfigurationMenuDao;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
    @Autowired
    private JsonConverterSvc jsonConverterSvc;
	
	@Override
	public List<TableConfigurationMenuDto> menuLogin() {
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.menuLogin();
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			TableButtonDto tableButtonDto = new TableButtonDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableMenu tableMenu = (TableMenu) obj[1];
			TableButton tableButton = (TableButton) obj[2];
			
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, tableMenu);
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);

			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDto.setTableButtonDto(tableButtonDto);
			
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
			
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);		
	}

	@Override
	public List<TableConfigurationMenuDto> AllExistingMenuAndButtonForCurrentUser(
			String userId) {
        List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.AllExistingMenuAndButtonForCurrentUser(userId);
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			TableButtonDto tableButtonDto = new TableButtonDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableMenu tableMenu = (TableMenu) obj[1];
			TableButton tableButton = (TableButton) obj[2];
			
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, tableMenu);
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);

			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDto.setTableButtonDto(tableButtonDto);
			
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
			
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}

	@Override
	public List<TableConfigurationMenuDto> AllExistingMenuUser(String userId) {
List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.AllExistingMenuUser(userId);
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			String menuCode = (String) obj[0];
			String menuName = (String) obj[1];
			String menuUrl = (String) obj[2];
			tableMenuDto.setMenuCode(menuCode);
			tableMenuDto.setMenuName(menuName);
			tableMenuDto.setMenuUrl(menuUrl);
			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}

	@Override
	public List<TableConfigurationMenuDto> AllExistingButtonInCurrentUser(
			String userId, String menuCode) {
        List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.AllExistingButtonInCurrentUser(userId, menuCode);
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			TableButtonDto tableButtonDto = new TableButtonDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableMenu tableMenu = (TableMenu) obj[1];
			TableButton tableButton = (TableButton) obj[2];
			
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, tableMenu);
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);

			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDto.setTableButtonDto(tableButtonDto);
			
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
			
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}

	@Override
	public List<TableConfigurationMenuDto> AllNonActiveConfigurationMenu() {
		List<Object[]> listActiveObject = tableConfigurationMenuDao.AllNonActiveConfigurationMenu();
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		for (Object[] obj : listActiveObject) {
			TableConfigurationMenuDto menuDto = new TableConfigurationMenuDto();
			menuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(menuDto, obj[6]);
			menuDto.setNamaKaryawan((String) obj[0]);
			menuDto.setMenuName((String) obj[1]);
			menuDto.setButtonName((String) obj[2]);
			menuDto.setMstCodeTypeName((String) obj[3]);
			menuDto.setCreatedDate((Date) obj[4]);
			menuDto.setCreatedByName((String) obj[5]);
			tableConfigurationMenuDtos.add(menuDto);
		}
		return tableConfigurationMenuDtos;
	}

	@Override
	public List<TableConfigurationMenuDto> AllActiveConfigurationMenu() {
		List<Object[]> listActiveObject = tableConfigurationMenuDao.AllActiveConfigurationMenu();
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		for (Object[] obj : listActiveObject) {
			TableConfigurationMenuDto menuDto = new TableConfigurationMenuDto();
			menuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(menuDto, obj[6]);
			menuDto.setNamaKaryawan((String) obj[0]);
			menuDto.setMenuName((String) obj[1]);
			menuDto.setButtonName((String) obj[2]);
			menuDto.setMstCodeTypeName((String) obj[3]);
			menuDto.setCreatedDate((Date) obj[4]);
			menuDto.setCreatedByName((String) obj[5]);
			tableConfigurationMenuDtos.add(menuDto);
		}
		return tableConfigurationMenuDtos;
	}

	@Override
	public int save(TableConfigurationMenuDto tableConfigurationMenuDto) {
		TableConfigurationMenu tableConfigurationMenu = new TableConfigurationMenu();
		tableConfigurationMenu = (TableConfigurationMenu) mappingClassSvc.mapperEntityToDto(tableConfigurationMenu, tableConfigurationMenuDto);
	    tableConfigurationMenuDao.save(tableConfigurationMenu);
		return 0;
	}

	@Override
	public int activateConfigurationMenu(String updatedBy, Date updatedDate,
			String menuCode, String menuButton, String userId) {
		tableConfigurationMenuDao.activateConfigurationMenu
		(updatedBy, updatedDate, menuCode, menuButton, userId);
		return 0;
	}

	@Override
	public int disactivateConfigurationMenu(String updatedBy, Date updatedDate,
			String menuCode, String menuButton, String userId) {
		tableConfigurationMenuDao.disactivateConfigurationMenu(updatedBy, updatedDate, menuCode, menuButton, userId);
		return 0;
	}

	@Override
	public int deleteConfiguration(String menuCode, String menuButton, String userId) {
		tableConfigurationMenuDao.deleteConfiguration(menuCode, menuButton, userId);
		return 0;
	}

}
