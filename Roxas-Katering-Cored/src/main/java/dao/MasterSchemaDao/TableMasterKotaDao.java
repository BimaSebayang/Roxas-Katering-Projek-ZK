package dao.MasterSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterKota;
import entity.MasterSchema.entityMasterPk.TableMasterKotaPk;

public interface TableMasterKotaDao  extends 
JpaRepository<TableMasterKota, TableMasterKotaPk>{
    
    @Query("select a from TableMasterKota a where a.kodeProvinsi in (select b.kodeProvinsi from TableMasterProvinsi b where b.kodeProvinsi like case when "
    		+ " :kodeProvinsi = '' then '%%' else :kodeProvinsi end ) order by a.namaKota")
    public List<TableMasterKota> listTableMasterKota (@Param("kodeProvinsi") String kodeProvinsi);
	
}
