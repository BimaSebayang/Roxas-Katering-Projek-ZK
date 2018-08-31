
package dao.MenuSchemaDao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MenuSchema.TableMenu;
import entity.MenuSchema.TableUser;
import entity.MenuSchema.entityMenuPk.TableUserPk;

public interface TableUserDao extends JpaRepository<TableUser, TableUserPk>{
	@Modifying
	@Query("update TableUser a set a.status = '1', a.updatedBy = :updatedBy, a.updatedDate = :updatedDate"
			+ " where a.pegawaiId = :pegawaiId and a.userId = :userId ")
	public void activateUser(@Param("updatedBy") String updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("pegawaiId") String pegawaiId, @Param("userId") String userId);
	
	@Modifying
	@Query("update TableUser a set a.status = '0', a.updatedBy = :updatedBy, a.updatedDate = :updatedDate"
			+ " where a.pegawaiId = :pegawaiId and a.userId = :userId ")
	public void disactivateUser(@Param("updatedBy") String updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("pegawaiId") String pegawaiId, @Param("userId") String userId);
	
	@Modifying
	@Query("delete from TableUser a "
			+ " where a.pegawaiId = :pegawaiId and a.userId = :userId ")
	public void deleteUser( @Param("pegawaiId") String pegawaiId, @Param("userId") String userId);
	
	@Query("select a from TableUser a ")
	public List<TableUser> users();
	
	@Query("select a.userId,a.pegawaiId,b.namaKaryawan, c.mstCodeTypeName from TableUser a, "
           + " TableDataKaryawan b, TableMasterAllCode c "
           + " where "
           + " a.pegawaiId = b.pegawaiId "
           + " and "
           + " a.status= c.mstCodeType "
           + " and "
           + " c.mstColumnName = 'STATUS'")
	public List<Object[]> getAllUser();
	
	@Query("select a.userId,a.pegawaiId,b.namaKaryawan, c.mstCodeTypeName from TableUser a, "
	           + " TableDataKaryawan b, TableMasterAllCode c "
	           + " where "
	           + " a.pegawaiId = b.pegawaiId "
	           + " and "
	           + " a.status= c.mstCodeType "
	           + " and "
	           + " c.mstColumnName = 'STATUS'"
	           + " and a.userId = :userId ")
		public List<Object[]> getCurrentUser(@Param("userId") String userId);
	
	@Query("select a.userId , a.pegawaiId, b.namaKaryawan, c.mstCodeTypeName, "
		    + " a.createdDate, d.namaKaryawan , a.updatedDate, "
            + " b.namaKaryawan  from TableUser a , TableDataKaryawan b , TableMasterAllCode c, TableDataKaryawan d  "
            + " where "
            + " a.createdBy = d.pegawaiId and "
            + " a.pegawaiId = b.pegawaiId and "
            + " c.mstCodeType = a.status and " 
            + " (c.mstColumnName) = UPPER('status') "
            + " and a.status = 0 ")
     public List<Object[]> AllNonActiveUser();
     
     @Query("select a.userId , a.pegawaiId, b.namaKaryawan, c.mstCodeTypeName, "
 		    + " a.createdDate, d.namaKaryawan , a.updatedDate "
 		     + " from TableUser a , TableDataKaryawan b , TableMasterAllCode c, TableDataKaryawan d  "
             + " where "
             + " a.createdBy = d.pegawaiId and "
             + " a.pegawaiId = b.pegawaiId and "
             + " c.mstCodeType = a.status and " 
             + " (c.mstColumnName) = UPPER('status') "
             + " and a.status = 1 ")
      public List<Object[]> AllActiveUser();
}
