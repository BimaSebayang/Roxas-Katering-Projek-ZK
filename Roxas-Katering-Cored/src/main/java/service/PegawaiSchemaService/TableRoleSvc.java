package service.PegawaiSchemaService;

import java.util.List;

import DataTransferObjectLib.PegawaiSchemaDto.TableRoleDto;

public interface TableRoleSvc {

	public List<TableRoleDto> findAllTableRole();
}
