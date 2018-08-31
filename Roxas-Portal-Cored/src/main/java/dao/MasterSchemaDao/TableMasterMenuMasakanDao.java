package dao.MasterSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MasterSchema.TableMasterMenuMasakan;
import entity.MasterSchema.entityMasterPk.TableMasterMenuMasakanPk;

public interface TableMasterMenuMasakanDao extends 
JpaRepository<TableMasterMenuMasakan, TableMasterMenuMasakanPk>{

}
