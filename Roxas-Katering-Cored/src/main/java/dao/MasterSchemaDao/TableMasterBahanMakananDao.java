package dao.MasterSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MasterSchema.TableMasterBahanMakanan;
import entity.MasterSchema.entityMasterPk.TableMasterBahanMakananPk;

public interface TableMasterBahanMakananDao extends 
JpaRepository<TableMasterBahanMakanan, TableMasterBahanMakananPk>{

}
