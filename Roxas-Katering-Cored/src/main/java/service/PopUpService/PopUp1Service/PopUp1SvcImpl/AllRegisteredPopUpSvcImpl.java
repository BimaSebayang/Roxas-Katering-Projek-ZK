package service.PopUpService.PopUp1Service.PopUp1SvcImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import dao.MenuSchemaDao.TableButtonDao;
import dao.MenuSchemaDao.TableMenuDao;
import dao.MenuSchemaDao.TableUserDao;
import entity.MenuSchema.TableMenu;
import service.PopUpService.PopUp1Service.AllRegisteredPopUpSvc;

@Service("allRegisteredPopUpSvc")
@Transactional()
public class AllRegisteredPopUpSvcImpl implements AllRegisteredPopUpSvc {
    @Autowired
    private TableUserDao tableUserDao;
    @Autowired
    private TableMenuDao tableMenuDao;
    @Autowired
    private TableButtonDao tableButtonDao;

	@Override
	public List<TableUserDto> getAllUserTableDto(Map<String,Object> mapp, String search, String projekCode) {
		List<TableUserDto> tableUserDtos = new ArrayList<>();
		List<Object[]> objects = tableUserDao.allActiveUserInCurrentProjek("%"+search+"%", projekCode);
		for (Object[] ob : objects) {
			TableUserDto userDto = new TableUserDto();
			userDto.setUserId((String) ob[0]);
			userDto.setPegawaiId((String) ob[1]);
			userDto.setPegawaiName((String) ob[2]);
			tableUserDtos.add(userDto);
		}
		return tableUserDtos;
	}

	@Override
	public List<TableMenuDto> getAllMenuDto(Map<String, Object> mapp, String search, String projekCode) {
		List<TableMenuDto> tableMenuDtos = new ArrayList<>();
		List<Object[]> objects = tableMenuDao.getAllMenusInCurrentProjek(projekCode, "%"+search+"%");
		for (Object[] ob : objects) {
			TableMenuDto tableMenuDto = new TableMenuDto();
			tableMenuDto.setMenuCode((String) ob[0]);
			tableMenuDto.setMenuName((String) ob[1]);
			tableMenuDto.setNotes((String) ob[2]);
			tableMenuDtos.add(tableMenuDto);
		}
		return tableMenuDtos;
	}

	@Override
	public List<TableButtonDto> getAllButtonDto(Map<String, Object> mapp, String search, String projekCode) {
		List<TableButtonDto> tableButtonDtos = new ArrayList<>();
		String menuCode = (String) mapp.get("menuCode");
		String userId = (String) mapp.get("userId");
		List<Object[]> objects = tableButtonDao.getAllButtonInCurrentUserIdAndMenu(projekCode, menuCode, userId, 
				"%"+search+"%");
		for (Object[] ob : objects) {
			TableButtonDto tableButtonDto = new TableButtonDto();
			tableButtonDto.setButtonCode((String) ob[0]);
			tableButtonDto.setButtonName((String) ob[1]);
			tableButtonDto.setNotes((String) ob[2]);
			tableButtonDtos.add(tableButtonDto);
		} 
		return tableButtonDtos;
	}
    
    
    
	
}
