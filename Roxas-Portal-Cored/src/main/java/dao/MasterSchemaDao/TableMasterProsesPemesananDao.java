package dao.MasterSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MasterSchema.TableMasterProsesPemesanan;
import entity.MasterSchema.entityMasterPk.TableMasterProsesPemesananPk;

public interface TableMasterProsesPemesananDao extends 
JpaRepository<TableMasterProsesPemesanan, TableMasterProsesPemesananPk>{

}
