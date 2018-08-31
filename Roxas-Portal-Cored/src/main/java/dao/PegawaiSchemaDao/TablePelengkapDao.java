package dao.PegawaiSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.PegawaiSchema.TableDataKaryawan;
import entity.PegawaiSchema.entityPegawaiPk.TableDataKaryawanPk;


public interface TablePelengkapDao extends JpaRepository<TableDataKaryawan, TableDataKaryawanPk>{
    
}
