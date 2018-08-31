package dao.MasterSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterProvinsi;
import entity.MasterSchema.entityMasterPk.TableMasterProvinsiPk;

public interface TableMasterProvinsiDao  extends 
JpaRepository<TableMasterProvinsi, TableMasterProvinsiPk>{

	
	@Query("select a from TableMasterProvinsi a where a.kodeProvinsi in (select b.kodeProvinsi from TableMasterKota b where b.kodeKota like "
			+ " case when :kodeKota = '' then '%%' else :kodeKota end ) order by a.namaProvinsi ")
	public List<TableMasterProvinsi> listTableMasterProvinsi(@Param("kodeKota") String kodeKota);
}
