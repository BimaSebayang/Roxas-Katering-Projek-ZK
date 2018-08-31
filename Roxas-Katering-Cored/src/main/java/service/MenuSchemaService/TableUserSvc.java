package service.MenuSchemaService;

import java.util.List;
import java.util.Map;

import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

public interface TableUserSvc {

	public Map<String,Object> checkUser(String userId, String password);
	public List<TableUserDto> tableUserDtos();
	public int save(TableUserDto tableUserDto);
	public int activateUser(TableUserDto tableUserDto);
	public int disActivateUser(TableUserDto tableUserDto);
	public int deleteUser(TableUserDto tableUserDto);
	
}
