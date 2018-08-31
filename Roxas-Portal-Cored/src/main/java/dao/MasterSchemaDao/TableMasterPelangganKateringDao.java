package dao.MasterSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MasterSchema.TableMasterPelangganKatering;
import entity.MasterSchema.entityMasterPk.TableMasterPelangganKateringPk;

public interface TableMasterPelangganKateringDao extends 
JpaRepository<TableMasterPelangganKatering, TableMasterPelangganKateringPk> {

}
