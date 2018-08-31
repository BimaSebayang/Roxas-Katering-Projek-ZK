package dao.MasterSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterAllCode;
import entity.MasterSchema.entityMasterPk.TableMasterAllCodePk;

public interface TableMasterAllCodeDao extends 
JpaRepository<TableMasterAllCode, TableMasterAllCodePk>{
	
	@Query("select a from TableMasterAllCode a where a.mstColumnName = :mstColumnName ")
	public List<TableMasterAllCode> tableMasterAllCodesWithOneParam(@Param("mstColumnName") String mstColumnName);
	
	@Query("select a from TableMasterAllCode a where a.mstColumnName = :mstColumnName and a.mstCodeType = :mstCodeType ")
	public List<TableMasterAllCode> tableMasterAllCodesWithTwoParam(@Param("mstColumnName") String mstColumnName, 
			@Param("mstCodeType") String mstCodeType);
	
	@Query("select a.mstConditionName from TableMasterAllCode a where a.mstCode = 'CODE03' ")
	public String getTheDefaultPassword();
}
