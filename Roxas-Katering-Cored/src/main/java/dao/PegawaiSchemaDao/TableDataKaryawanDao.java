package dao.PegawaiSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.PegawaiSchema.TableDataKaryawan;
import entity.PegawaiSchema.entityPegawaiPk.TableDataKaryawanPk;

public interface TableDataKaryawanDao extends JpaRepository<TableDataKaryawan, TableDataKaryawanPk>{
  @Query("select a.pegawaiId, "
         + " a.namaKaryawan, a.createdDate, a.createdBy, a.updatedDate, a.updatedBy, "
         + " d.jobDesk, e.roleDesription, f.mstCodeTypeName, "
         + " c.mstCodeTypeName, a.photo, a.berkasUpload from TableDataKaryawan a, TablePengenal b, TableMasterAllCode c, " 
         + " TableJob d, TableRole e , TableMasterAllCode f "
         + " where a.pegawaiId = b.pegawaiId "
         + " and a.jenisKelamin = c.mstCodeType "
         + " and c.mstColumnName = 'JENIS_KELAMIN' "
         + " and b.jid = d.jid "
         + " and e.roleId = b.roleId "
         + " and b.status = f.mstCodeType "
         + " and f.mstColumnName = 'STATUS' "
         + " order by a.pegawaiId")
  public List<Object[]> allListPegawai();
  
  @Query("select a , e.roleDesription, e.roleId, d.jobDesk, d.jid from  "
  		 + " TableDataKaryawan a, TablePengenal b,  TableJob d, TableRole e"
  		 + " where a.pegawaiId = b.pegawaiId "
  		 + " and b.jid = d.jid "
         + " and e.roleId = b.roleId "
         + " and a.pegawaiId =:pegawaiId")
  public List<Object[]> allInformationPegawai(@Param("pegawaiId") String pegawaiId);
  
    @Modifying
	@Query("delete from  TableDataKaryawan a  "
			+ " where a.pegawaiId = :pegawaiId  ")
	public void deleteKaryawan(@Param("pegawaiId") String pegawaiId);
  
  @Query("select a.namaKaryawan from TableDataKaryawan a where a.pegawaiId = :pegawaiId")
  public String getNamaKaryawanFromCurrentId(@Param("pegawaiId") String pegawaiId);
}
