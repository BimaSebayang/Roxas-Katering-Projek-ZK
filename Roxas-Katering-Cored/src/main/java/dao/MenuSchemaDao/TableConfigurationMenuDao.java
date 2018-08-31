package dao.MenuSchemaDao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MenuSchema.TableConfigurationMenu;
import entity.MenuSchema.entityMenuPk.TableConfigurationMenuPk;

public interface TableConfigurationMenuDao  extends 
    JpaRepository<TableConfigurationMenu, TableConfigurationMenuPk>{
	
	@Modifying
	@Query("update TableConfigurationMenu a set a.status = '1', a.updatedBy = :updatedBy, a.updatedDate = :updatedDate"
			+ " where a.menuCode = :menuCode and a.menuButton = :menuButton and a.userId = :userId ")
	public void activateConfigurationMenu(@Param("updatedBy") String updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("menuCode") String menuCode, @Param("menuButton") String menuButton ,@Param("userId") String userId);
	
	@Modifying
	@Query("update TableConfigurationMenu a set a.status = '0', a.updatedBy = :updatedBy, a.updatedDate = :updatedDate"
			+ " where a.menuCode = :menuCode and a.menuButton = :menuButton and a.userId = :userId ")
	public void disactivateConfigurationMenu(@Param("updatedBy") String updatedBy, @Param("updatedDate") Date updatedDate,
			@Param("menuCode") String menuCode, @Param("menuButton") String menuButton ,@Param("userId") String userId);
	
	@Modifying
	@Query("delete from TableConfigurationMenu a "
			+ " where a.menuCode = :menuCode and a.menuButton = :menuButton and a.userId = :userId ")
	public void deleteConfiguration( @Param("menuCode") String menuCode, @Param("menuButton") String menuButton ,@Param("userId") String userId);
	
	@Query("select a,b,c from TableConfigurationMenu a, TableMenu b, TableButton c "
          + " where " 
          + " a.menuButton = c.buttonCode "
          + " and " 
          + " a.menuCode = b.menuCode "
          + " and a.menuCode = 'MENU01'")
	public List<Object[]> menuLogin();
	
	
	@Query("select a,b,c from TableConfigurationMenu a, TableMenu b, TableButton c "
	          + " where " 
	          + " a.menuButton = c.buttonCode "
	          + " and " 
	          + " a.menuCode = b.menuCode "
	          + " and a.userId = :userId "
	          + " and a.status = '1' "
	          + " and b.status = '1' "
	          + " and c.status = '1' ")
	public List<Object[]> AllExistingMenuAndButtonForCurrentUser(@Param("userId") String userId);
	
	@Query("select distinct a.menuCode, b.menuName, b.menuUrl from TableConfigurationMenu a, TableMenu b "
			+ " where "
			+ " a.menuCode = b.menuCode "
			+ " and a.userId = :userId "
	        + " and a.status = '1' "
	        + " and b.status = '1' "
	        + " and a.menuCode != 'MENU01' ")
	public List<Object[]> AllExistingMenuUser(@Param("userId") String userId);
	
	
	@Query("select a,b,c from TableConfigurationMenu a, TableMenu b, TableButton c "
	          + " where " 
	          + " a.menuButton = c.buttonCode "
	          + " and " 
	          + " a.menuCode = b.menuCode "
	          + " and a.userId = :userId "
	          + " and a.menuCode = :menuCode "
	          + " and a.status = '1' "
	          + " and c.status = '1' ")
	public List<Object[]> AllExistingButtonInCurrentUser(@Param("userId") String userId
			, @Param("menuCode") String menuCode);
	
	@Query("select e.namaKaryawan ,b.menuName , c.buttonName , f.mstCodeTypeName "
			+ "  , a.createdDate, h.namaKaryawan, a from TableConfigurationMenu a, "
			+ "  TableMenu b, TableButton c, TableUser d, TableDataKaryawan e, "
			+ "  TableMasterAllCode f, TableUser g, TableDataKaryawan h "
            + "  where a.menuCode = b.menuCode "
            + "  and a.menuButton = c.buttonCode "
            + "  and a.userId = d.userId "
            + "  and d.pegawaiId = e.pegawaiId "
            + "  and a.status = f.mstCodeType " 
            + "  and f.mstColumnName = 'STATUS' " 
            + "  and a.createdBy = g.pegawaiId "
            + "  and g.pegawaiId = h.pegawaiId "
            + "  and a.status = 1 "
            + "  order by e.namaKaryawan ,b.menuName ,  c.buttonName ")
	public List<Object[]> AllActiveConfigurationMenu();
	
	
	@Query("select e.namaKaryawan ,b.menuName , c.buttonName , f.mstCodeTypeName "
			+ "  , a.createdDate, h.namaKaryawan, a from TableConfigurationMenu a, "
			+ "  TableMenu b, TableButton c, TableUser d, TableDataKaryawan e, "
			+ "  TableMasterAllCode f, TableUser g, TableDataKaryawan h "
            + "  where a.menuCode = b.menuCode "
            + "  and a.menuButton = c.buttonCode "
            + "  and a.userId = d.userId "
            + "  and d.pegawaiId = e.pegawaiId "
            + "  and a.status = f.mstCodeType " 
            + "  and f.mstColumnName = 'STATUS' " 
            + "  and a.createdBy = g.pegawaiId "
            + "  and g.pegawaiId = h.pegawaiId "
            + "  and a.status = 0 "
            + "  order by e.namaKaryawan ,b.menuName ,  c.buttonName ")
	public List<Object[]> AllNonActiveConfigurationMenu();
	//tester
	
	@Query(value="select top 2 a.* from menu.TABLE_CONFIGURATION_MENU a where a.user_id = :user "
			,nativeQuery=true)
	public List<TableConfigurationMenu> findAllConfigurationMenuWithNative(@Param("user") String user);
	
	@Query(value="select top 2 a.* from menu.TABLE_CONFIGURATION_MENU a", nativeQuery=true)
	public List<TableConfigurationMenu> findAllConfigurationMenuWithNative();
	
	@Query(value = "select a from TableConfigurationMenu a")
	public List<TableConfigurationMenu> findAllConfigurationMenu();
	
	
	//Start For Project Katering
	@Query(value = "select  distinct(a.menuCode) , b from TableConfigurationMenu a, TableMenu b "
			+ " where "
			+ " a.menuCode = b.menuCode "
			+ " and "
			+ " a.userId = :userId "
			+ " and "
			+ " a.status = '1' "
			+ " and "
			+ " b.status = '1' "
			+ " and "
			+ " a.projekCode = b.projekCode "
			+ " and "
			+ " a.projekCode = :projekCode ")
	public List<Object[]> getAllExistingMenuAndButtonInCurrentUserAndProjek
	(@Param("userId") String userId, @Param("projekCode") String projekCode);
	
	@Query("SELECT a,c FROM TableConfigurationMenu a, TableButton c "  
           + " WHERE "
           + " a.menuButton = c.buttonCode "
           + " AND "
           + " a.userId = :userId "
           + " AND "
           + " a.status = '1' "
           + " AND "
           + " c.status = '1' "
           + " AND "
           + " a.projekCode = c.projekCode "
           + " AND "
           + " a.projekCode = :projekCode "
           + " AND a.menuCode = :menuCode ")
	public List<Object[]> getAllExistingButtonInCurrentMenuProjekAndUser
	(@Param("userId") String userId, @Param("projekCode") String projekCode, 
			@Param("menuCode") String menuCode);
	
	
	@Query(value = "Select b.menuName as menuName, c.buttonName as buttonName, d.namaKaryawan as namaKaryawan, a.createdDate , f.mstCodeTypeName as mstCodeTypeName"
			+ " , d.pegawaiId as pegawaiId, a "
			+ " from TableConfigurationMenu a, TableMenu b, TableButton c, TableDataKaryawan d, TableUser e, TableMasterAllCode f "
			+ " where "
			+ " a.menuButton = c.buttonCode "
			+ " and "
			+ " a.menuCode = b.menuCode "
			+ " and "
			+ " b.status = '1' "
			+ " and "
			+ " c.status = '1' "
			+ " and "
			+ " a.projekCode = b.projekCode "
			+ " and "
			+ " b.projekCode = c.projekCode "
			+ " and "
			+ " a.projekCode = :projekCode "
			+ " and "
			+ " e.userId = a.userId "
			+ " and "
			+ " e.pegawaiId = d.pegawaiId "
			+ " and "
			+ " a.createdBy = :createdBy "
			+ " and "
			+ " f.mstColumnName = 'STATUS' "
			+ " and "
			+ " f.mstCodeType = a.status "
			//Start Filter
			+ " and b.menuName in :listMenuName "
			+ " and f.mstCodeTypeName in :listCodeTypeName "
			+ " and c.buttonName  in :listButtonName "
			+ " and d.namaKaryawan in :listNamaKaryawan "
			//Start Searching
			+ " and ( upper(b.menuName) like upper(:search) "
			+ " or upper(f.mstCodeTypeName) like upper(:search)"
			+ " or upper(c.buttonName) like upper(:search) "
			+ " or upper(d.namaKaryawan) like upper(:search) "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) "
			+ " )")
	public Page<Object[]> getAllExistingData(@Param("projekCode") String projekCode, 
			@Param("createdBy") String createdBy, 
			@Param("listMenuName") List<String> listMenuName,
			@Param("listCodeTypeName") List<String> listCodeTypeName,
			@Param("listButtonName") List<String> listButtonName, 
			@Param("listNamaKaryawan") List<String> listNamaKaryawan,
			@Param("search") String search, Pageable pageable);
	//End For Projek Katering
	
	
	@Query(value = "Select  b.menuName, c.buttonName, d.namaKaryawan, a "
			+ " from TableConfigurationMenu a, TableMenu b, TableButton c, TableDataKaryawan d, TableUser e, TableMasterAllCode f "
			+ " where "
			+ " a.menuButton = c.buttonCode "
			+ " and "
			+ " a.menuCode = b.menuCode "
			+ " and "
			+ " a.status = :status "
			+ " and "
			+ " b.status = '1' "
			+ " and "
			+ " c.status = '1' "
			+ " and "
			+ " a.projekCode = b.projekCode "
			+ " and "
			+ " b.projekCode = c.projekCode "
			+ " and "
			+ " a.projekCode = :projekCode "
			+ " and "
			+ " e.userId = a.userId "
			+ " and "
			+ " e.pegawaiId = d.pegawaiId "
			+ " and "
			+ " a.createdBy = :createdBy "
			+ " and "
			+ " f.mstColumnName = 'STATUS' "
			+ " and "
			+ " f.mstCodeType = a.status "
			//Start Searching
			+ " and ( upper(b.menuName) like upper(:search) "
			+ " or upper(c.buttonName) like upper(:search) "
			+ " or upper(d.namaKaryawan) like upper(:search) "
			+ " )")
	public List<Object[]> getDataAktifDanNonAktif(@Param("status") String status, @Param("createdBy") String createdBy, @Param("projekCode") String projekCode, 
			@Param("search") String search);
	
	@Query(value = "Select a, b.menuName, c.buttonName, d.namaKaryawan, a.createdDate, f.mstCodeTypeName  "
			+ " from TableConfigurationMenu a, TableMenu b, TableButton c, TableDataKaryawan d, TableUser e, TableMasterAllCode f "
			+ " where "
			+ " a.menuButton = c.buttonCode "
			+ " and "
			+ " a.menuCode = b.menuCode "
			+ " and "
			+ " b.status = '1' "
			+ " and "
			+ " c.status = '1' "
			+ " and "
			+ " a.projekCode = b.projekCode "
			+ " and "
			+ " b.projekCode = c.projekCode "
			+ " and "
			+ " a.projekCode = :projekCode "
			+ " and "
			+ " e.userId = a.userId "
			+ " and "
			+ " e.pegawaiId = d.pegawaiId "
			+ " and "
			+ " a.createdBy = :createdBy "
			+ " and "
			+ " f.mstColumnName = 'STATUS' "
			+ " and "
			+ " f.mstCodeType = a.status "
			//Start Searching
			+ " and ( upper(b.menuName) like upper(:search) "
			+ " or upper(f.mstCodeTypeName) like upper(:search)"
			+ " or upper(c.buttonName) like upper(:search) "
			+ " or upper(d.namaKaryawan) like upper(:search) "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) "
			+ " )")
	public List<Object[]> getTheFilterList(@Param("projekCode") String projekCode, 
			@Param("createdBy") String createdBy, @Param("search") String search);
}
