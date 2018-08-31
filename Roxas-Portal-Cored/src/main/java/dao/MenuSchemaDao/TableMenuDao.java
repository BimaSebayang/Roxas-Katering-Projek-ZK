package dao.MenuSchemaDao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MenuSchema.TableMenu;
import entity.MenuSchema.entityMenuPk.TableMenuPk;


public interface TableMenuDao extends 
JpaRepository<TableMenu, TableMenuPk>{
	
	//semua employee dikasih menu dengan kode = "MENU01"
	@Query("select a from TableMenu a where a.menuCode = 'MENU01'")
	public TableMenu menuLogin();
	
	@Query("select a.menuCode, a.menuName, b.mstCodeTypeName from TableMenu a, TableMasterAllCode b "
         + " where " 
         + " a.status = b.mstCodeType "
         + " and "
         + " b.mstColumnName = 'STATUS'")
	public List<Object[]> getAllRequiredMenuForRecentUser();
	
	@Query("select a , b.mstCodeTypeName from TableMenu a, TableMasterAllCode b "
	         + " where " 
	         + " a.status = b.mstCodeType "
	         + " and "
	         + " b.mstColumnName = 'STATUS' "
	         + " and a.status = '1' ")
    public List<Object[]> getAllActiveMenu();
    
    @Query("select  a , b.mstCodeTypeName from TableMenu a, TableMasterAllCode b "
	         + " where " 
	         + " a.status = b.mstCodeType "
	         + " and "
	         + " b.mstColumnName = 'STATUS' "
	         + " and a.status = '0' ")
   public List<Object[]> getAllDisactiveMenu();
   
   @Query("select  a , b.mstCodeTypeName from TableMenu a, TableMasterAllCode b "
	         + " where " 
	         + " a.status = b.mstCodeType "
	         + " and "
	         + " b.mstColumnName = 'STATUS' "
	         + " and a.menuCode = :menuCode ")
 public List<Object[]> getTheInformationMenu(@Param("menuCode") String menuCode);
 
 
 @Modifying
	@Query("update TableMenu a set a.status = '1' "
			+ " where a.menuCode = :menuCode  ")
	public void activateMenu( @Param("menuCode") String menuCode);
 
 
 @Modifying
	@Query("update TableMenu a set a.status = '0' "
			+ " where a.menuCode = :menuCode  ")
	public void disactivateMenu( @Param("menuCode") String menuCode);
    		
	
 @Modifying
	@Query("delete from TableMenu a "
			+ " where a.menuCode = :menuCode ")
	public void deleteSelectedMenu( @Param("menuCode") String menuCode);   
    
}
