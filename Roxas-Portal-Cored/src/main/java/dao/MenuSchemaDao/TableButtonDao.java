package dao.MenuSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MenuSchema.TableButton;
import entity.MenuSchema.entityMenuPk.TableButtonPk;

public interface TableButtonDao extends
		JpaRepository<TableButton, TableButtonPk> {
	@Query("select a.buttonCode, a.buttonName, b.mstCodeTypeName "
			+ "  from TableButton a, TableMasterAllCode b "
			+ "  where "
			+ "  a.buttonCode not in "
			+ " (select b.menuButton from TableConfigurationMenu b where b.userId = :userId "
			+ "  and b.menuCode = :menuCode) " + "  and "
			+ "  a.status = b.mstCodeType " + "  and "
			+ "  b.mstColumnName = 'STATUS'")
	public List<Object[]> getAllRequiredButtonForRecentUser(
			@Param("userId") String userId, @Param("menuCode") String menuCode);

	@Query("select a , b.mstCodeTypeName from TableButton a, TableMasterAllCode b "
			+ " where "
			+ " a.status = b.mstCodeType "
			+ " and "
			+ " b.mstColumnName = 'STATUS' " + " and a.status = '1' ")
	public List<Object[]> getAllActiveMenu();

	@Query("select  a , b.mstCodeTypeName from TableButton a, TableMasterAllCode b "
			+ " where "
			+ " a.status = b.mstCodeType "
			+ " and "
			+ " b.mstColumnName = 'STATUS' " + " and a.status = '0' ")
	public List<Object[]> getAllDisactiveMenu();

	@Query("select  a , b.mstCodeTypeName from TableButton a, TableMasterAllCode b "
			+ " where "
			+ " a.status = b.mstCodeType "
			+ " and "
			+ " b.mstColumnName = 'STATUS' " + " and a.buttonCode = :buttonCode ")
	public List<Object[]> getTheInformationMenu(
			@Param("buttonCode") String buttonCode);

	@Modifying
	@Query("update TableButton a set a.status = '1' "
			+ " where a.buttonCode = :buttonCode  ")
	public void activateButton(@Param("buttonCode") String buttonCode);

	@Modifying
	@Query("update TableButton a set a.status = '0' "
			+ " where a.buttonCode = :buttonCode  ")
	public void disactivateButton(@Param("buttonCode") String buttonCode);

	@Modifying
	@Query("delete from TableButton a  where a.buttonCode = :buttonCode ")
	public void deleteSelectedButton(@Param("buttonCode") String buttonCode);

}
