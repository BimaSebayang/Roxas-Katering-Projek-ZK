package dao.MasterSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MasterSchema.TableMasterResepMasakan;
import entity.MasterSchema.entityMasterPk.TableMasterResepMasakanPk;

public interface TableMasterResepMasakanDao extends 
JpaRepository<TableMasterResepMasakan, TableMasterResepMasakanPk>{

}
