package dao.MasterSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MasterSchema.TableMasterSimulasiHargaMenuDtl;
import entity.MasterSchema.entityMasterPk.TableMasterSimulasiHargaMenuDtlPk;

public interface TableMasterSimulasiHargaMenuDtlDao extends 
JpaRepository<TableMasterSimulasiHargaMenuDtl, TableMasterSimulasiHargaMenuDtlPk>{

}
