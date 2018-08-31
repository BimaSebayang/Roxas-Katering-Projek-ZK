package service.PegawaiSchemaService.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.PegawaiSchemaDto.TableRoleDto;
import Master.JsonConverterGroup.JsonConverterSvc;
import Master.MapperClass.MappingClassSvc;
import dao.PegawaiSchemaDao.TableRoleDao;
import entity.PegawaiSchema.TableRole;
import service.PegawaiSchemaService.TableRoleSvc;

@Service("tableRoleSvc")
@Transactional
public class TableRoleSvcImpl implements TableRoleSvc{
    @Autowired
    private TableRoleDao tableRoleDao;
	@Autowired
	private MappingClassSvc mappingClassSvc;
    @Autowired
    private JsonConverterSvc jsonConverterSvc;
    
    
	@Override
	public List<TableRoleDto> findAllTableRole() {
		List<TableRoleDto> tableRoleDtos = new ArrayList<>();
		List<TableRole> tableRoles = tableRoleDao.findAll();
		for (TableRole role : tableRoles) {
			TableRoleDto tableRoleDto = new TableRoleDto();
			tableRoleDto = (TableRoleDto) mappingClassSvc.mapperEntityToDto(tableRoleDto,role);
			tableRoleDtos.add(tableRoleDto);
		}
		return tableRoleDtos;
	}
	
}
