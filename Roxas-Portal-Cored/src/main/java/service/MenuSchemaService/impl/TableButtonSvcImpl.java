package service.MenuSchemaService.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Master.MapperClass.MappingClassSvc;
import dao.MenuSchemaDao.TableButtonDao;
import dto.MenuSchemaDto.TableButtonDto;
import entity.MenuSchema.TableButton;
import service.GenerateAutoId.GenAutoSvc;
import service.MenuSchemaService.TableButtonSvc;

@Service("tableButtonSvc")
@Transactional
public class TableButtonSvcImpl implements TableButtonSvc {
	@Autowired
	private TableButtonDao tableButtonDao;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	@Autowired
	private GenAutoSvc genAutoSvc;

	@Override
	public List<TableButtonDto> getAllRequiredButtonForRecentUser(
			String userId, String menuCode) {
		List<Object[]> objects = tableButtonDao
				.getAllRequiredButtonForRecentUser(userId, menuCode);
		List<TableButtonDto> tableButtonDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableButtonDto dto = new TableButtonDto();
			dto.setButtonCode((String) obj[0]);
			dto.setButtonName((String) obj[1]);
			dto.setStatusName((String) obj[2]);
			tableButtonDtos.add(dto);
		}
		return tableButtonDtos;
	}

	@Override
	public List<TableButtonDto> getAllActiveMenu() {
		List<Object[]> objects = tableButtonDao.getAllActiveMenu();
		List<TableButtonDto> tableButtonDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableButtonDto tableButtonDto = new TableButtonDto();
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, obj[0]);
			tableButtonDto.setStatusName((String) obj[1]);
			tableButtonDtos.add(tableButtonDto);
		} 
		return tableButtonDtos;
	}

	@Override
	public List<TableButtonDto> getAllDisactiveMenu() {
		List<Object[]> objects = tableButtonDao.getAllDisactiveMenu();
		List<TableButtonDto> tableButtonDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableButtonDto tableButtonDto = new TableButtonDto();
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, obj[0]);
			tableButtonDto.setStatusName((String) obj[1]);
			tableButtonDtos.add(tableButtonDto);
		} 
		return tableButtonDtos;
	}

	@Override
	public TableButtonDto getTheInformationOfSelectedMenu(String buttonCode) {
		List<Object[]> objects = tableButtonDao.getTheInformationMenu(buttonCode);
		TableButtonDto tableButtonDto = new TableButtonDto();
		for (Object[] obj : objects) {
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, obj[0]);
			tableButtonDto.setStatusName((String) obj[1]);
		} 
		return tableButtonDto;
	}

	@Override
	public int save(TableButtonDto tableButtonDto) {
		TableButton tableButton = new TableButton();
		tableButton = (TableButton) mappingClassSvc.mapperEntityToDto(tableButton, tableButtonDto);
		tableButton.setButtonName(tableButtonDto.getButtonName().toUpperCase());
		if(tableButton.getButtonCode() == null){
			tableButton.setButtonCode(genAutoSvc.generateAutoIdForCurrentTable("TABLE_BUTTON", 
					"BUTTON", 2));
		}
		tableButtonDao.save(tableButton);
		return 0;
	}

	@Override
	public int activateButton(TableButtonDto tableButtonDto) {
		tableButtonDao.activateButton(tableButtonDto.getButtonCode());
		return 0;
	}

	@Override
	public int disActivateButton(TableButtonDto tableButtonDto) {
		tableButtonDao.disactivateButton(tableButtonDto.getButtonCode());
		return 0;
	}

	@Override
	public int deleteButton(TableButtonDto tableButtonDto) {
		tableButtonDao.deleteSelectedButton(tableButtonDto.getButtonCode());
		return 0;
	}
}
