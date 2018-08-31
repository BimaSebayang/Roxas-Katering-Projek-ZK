package dao.MasterSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterProsedurformDtl;
import entity.MasterSchema.entityMasterPk.TableMasterProsedurformDtlPk;


public interface TableMasterProsedurformDtlDao extends 
JpaRepository<TableMasterProsedurformDtl, TableMasterProsedurformDtlPk>{

	@Query(" select a.detailName from TableMasterProsedurformDtl a where a.projekCode = :projekCode ")
	public List<String> collectAllExistingDetaillProsedurName(@Param("projekCode") String projekCode);
	
	@Query(" select a from TableMasterProsedurformDtl a where a.projekCode = :projekCode and a.prosedurId = :prosedurId ")
	public List<TableMasterProsedurformDtl> collectAllDetail(@Param("projekCode") String projekCode, @Param("prosedurId") String prosedurId);
	
	@Query("select a.prosedurIdDetail from TableMasterProsedurformDtl a where a.projekCode = :projekCode and a.prosedurId = :prosedurId ")
	public List<String> getAllDetail(@Param("projekCode") String projekCode, @Param("prosedurId") String prosedurId);
	
	@Modifying
	@Query(" delete from TableMasterProsedurformDtl a where a.projekCode = :projekCode and a.prosedurId = :prosedurId  and a.prosedurIdDetail = :prosedurIdDetail")
    public int deleteUnusedDetail(@Param("projekCode") String projekCode, @Param("prosedurId") String prosedurId, @Param("prosedurIdDetail") String prosedurIdDetail);
}
