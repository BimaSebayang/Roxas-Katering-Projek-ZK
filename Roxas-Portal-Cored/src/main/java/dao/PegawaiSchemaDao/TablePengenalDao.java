package dao.PegawaiSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.PegawaiSchema.TablePengenal;
import entity.PegawaiSchema.entityPegawaiPk.TablePengenalPk;



public interface TablePengenalDao extends JpaRepository<TablePengenal, TablePengenalPk>{	
	

	@Modifying
	@Query("delete from TablePengenal a  where a.pegawaiId = :pegawaiId ")
	public void deletePengenal(@Param("pegawaiId") String pegawaiId);
	
	@Query("select a.pegawaiId, b.namaKaryawan, c.mstCodeTypeName from "
          + " TablePengenal a, TableDataKaryawan b, TableMasterAllCode c " 
          + " where a.pegawaiId = b.pegawaiId "
          + " and " 
          + " a.status = c.mstCodeType "
          + " and " 
          + " c.mstColumnName = 'STATUS' "
          + " and "
          + " a.pegawaiId not in (select c.pegawaiId from TableUser c)")
	public List<Object[]> getAllInDataUser();
	
	
	@Query("select a.pegawaiId, b.namaKaryawan, c.mstCodeTypeName from "
	          + " TablePengenal a, TableDataKaryawan b, TableMasterAllCode c " 
	          + " where a.pegawaiId = b.pegawaiId "
	          + " and " 
	          + " a.status = c.mstCodeType "
	          + " and " 
	          + " c.mstColumnName = 'STATUS' ")
		public List<Object[]> getAllDataPegawai();
}
