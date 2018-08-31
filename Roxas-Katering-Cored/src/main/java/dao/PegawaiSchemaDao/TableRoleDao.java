package dao.PegawaiSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.PegawaiSchema.TableJob;
import entity.PegawaiSchema.TableRole;
import entity.PegawaiSchema.entityPegawaiPk.TableJobPk;
import entity.PegawaiSchema.entityPegawaiPk.TableRolePk;

public interface TableRoleDao extends JpaRepository<TableRole, TableRolePk>{
	
	@Query(" select a from TableRole a ")
	public List<TableRole> tableRoles();

}
