package dao.PegawaiSchemaDao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.PegawaiSchema.TableJob;
import entity.PegawaiSchema.entityPegawaiPk.TableJobPk;

public interface TableJobDao extends JpaRepository<TableJob, TableJobPk>{

	@Query(value = "select a from TableJob a")
	public List<TableJob> findAll();
	
}
