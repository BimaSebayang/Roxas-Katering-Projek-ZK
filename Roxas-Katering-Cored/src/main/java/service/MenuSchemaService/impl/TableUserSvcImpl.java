package service.MenuSchemaService.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MasterSchemaDao.TableMasterAllCodeDao;
import dao.MenuSchemaDao.TableUserDao;
import entity.MenuSchema.TableUser;
import CustomDao.MenuSchemaCustomDao.TableUserCustomDaoSvc;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import Master.JsonConverterGroup.JsonConverterSvc;
import Master.MapperClass.MappingClassSvc;
import service.MenuSchemaService.TableUserSvc;

@Service("tableUserSvc")
@Transactional
public class TableUserSvcImpl implements TableUserSvc{
	
	@Autowired
	private TableUserDao tableUserDao;
	
	@Autowired
	private TableUserCustomDaoSvc tableUserCustomDaoSvc;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
    @Autowired
    private JsonConverterSvc jsonConverterSvc;
    
    @Autowired
    private TableMasterAllCodeDao tableMasterAllCodeDao;
	
	@Override
	public Map<String, Object> checkUser(String userId, String password) {
		Map<String, Object> mapper = new HashMap<>();
				mapper = tableUserCustomDaoSvc.loginUser(userId, password);
		TableUserDto tableUserDto = new TableUserDto();
		TableUser tableUser = (TableUser) mapper.get("userId");
		tableUserDto = (TableUserDto) mappingClassSvc.mapperEntityToDto(tableUserDto, tableUser);
		Map<String, Object> mapperBaru = new HashMap<>();
		mapperBaru.put("countUser", mapper.get("countUser"));
		mapperBaru.put("userId", tableUserDto);
		return jsonConverterSvc.getHashMapResultJson(mapper);
	}

	@Override
	public int save(TableUserDto tableUserDto) {
		TableUser tableUser = new TableUser(); 
				tableUser = (TableUser) mappingClassSvc.mapperEntityToDto(tableUser, tableUserDto);
				tableUser.setPassword(tableMasterAllCodeDao.getTheDefaultPassword());
		tableUserDao.save(tableUser);
		return 0;
	}

	@Override
	public int activateUser(TableUserDto tableUserDto) {
		tableUserDao.activateUser(tableUserDto.getUpdatedBy(), 
				tableUserDto.getUpdatedDate(), tableUserDto.getPegawaiId(), tableUserDto.getUserId());
		return 0;
	}

	@Override
	public int disActivateUser(TableUserDto tableUserDto) {
		tableUserDao.disactivateUser(tableUserDto.getUpdatedBy(), 
				tableUserDto.getUpdatedDate(), tableUserDto.getPegawaiId(), tableUserDto.getUserId());
		return 0;
	}

	@Override
	public int deleteUser(TableUserDto tableUserDto) {
	
		tableUserDao.deleteUser(tableUserDto.getPegawaiId(), tableUserDto.getUserId());
		return 0;
	}

	@Override
	public List<TableUserDto> tableUserDtos() {
		List<Object[]> objects = tableUserDao.getAllUser();
		List<TableUserDto> tableUserDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TableUserDto userDto = new TableUserDto();
			userDto.setUserId((String) obj[0]);
			userDto.setPegawaiId((String) obj[1]);
			userDto.setPegawaiName((String) obj[2]);
			userDto.setStatusUser((String) obj[3]);
			tableUserDtos.add(userDto);
		}
		return tableUserDtos;
	}
     
}
