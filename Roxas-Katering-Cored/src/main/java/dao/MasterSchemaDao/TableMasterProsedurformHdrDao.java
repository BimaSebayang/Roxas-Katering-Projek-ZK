package dao.MasterSchemaDao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterProsedurformHdr;
import entity.MasterSchema.entityMasterPk.TableMasterProsedurformHdrPk;


public interface TableMasterProsedurformHdrDao  extends 
JpaRepository<TableMasterProsedurformHdr, TableMasterProsedurformHdrPk>{

	@Query("select a, c.menuName, d.mstCodeTypeName, e.mstCodeTypeName from TableMasterProsedurformHdr a,  "
			+ " TableMenu c, TableMasterAllCode d, TableMasterAllCode e "
			//condition
			+ " where a.projekCode = :projekCode "
			+ " and "
			+ " a.createdBy = :createdBy "
			+ " and "
			+ " a.menuCode = c.menuCode "
			+ " and "
			+ " d.mstColumnName = 'STATUS_AKTIF' "
			+ " and "
			+ " d.mstCodeType = a.statusAktif "
			+ " and "
			+ " e.mstColumnName = 'STATUS_APPROVAL' "
			+ " and "
			+ " e.mstCodeType = a.statusApproval "
			//start filter
			+ " and a.prosedurId in :idProsedurs "
			+ " and upper(a.prosedurName) in  :namaProsedurs "
			+ " and a.totalProsedur in :jumlahProsedurs "
			+ " and upper(e.mstCodeTypeName) in :statusPersetujuans "
			+ " and upper(d.mstCodeTypeName) in :statusProsedurs "
			+ " and upper(c.menuName) in :menuReferensis "
			//searching
			+ " and (upper(a.prosedurId) like upper(:search) "
			+ " or upper(a.prosedurName) like upper(:search) "
			+ " or a.totalProsedur like :search "
			+ " or upper(e.mstCodeTypeName) like upper(:search) " //status persetujuan
			+ " or upper(d.mstCodeTypeName) like upper(:search) "
			+ " or upper(c.menuName) like upper(:search) "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) )")   //status aktif
	public Page<Object[]> getAllExistingData(@Param("idProsedurs") List<String> idProsedurs , @Param("namaProsedurs") List<String> namaProsedurs, @Param("menuReferensis") List<String> menuReferensis
			,@Param("jumlahProsedurs") List<Integer> jumlahProsedurs, @Param("statusPersetujuans") List<String> statusPersetujuans, @Param("statusProsedurs")List<String> statusProsedurs,
			@Param("createdBy") String user, @Param("projekCode") String projek, @Param("search") String search, Pageable pageable);
	
	@Query("select a.prosedurId, a.prosedurName,  c.menuName, a.totalProsedur, d.mstCodeTypeName, e.mstCodeTypeName from TableMasterProsedurformHdr a,  "
			+ " TableMenu c, TableMasterAllCode d, TableMasterAllCode e "
			//condition
			+ " where a.projekCode = :projekCode "
			+ " and "
			+ " a.createdBy = :createdBy "
			+ " and "
			+ " a.menuCode = c.menuCode "
			+ " and "
			+ " d.mstColumnName = 'STATUS_AKTIF' "
			+ " and "
			+ " d.mstCodeType = a.statusAktif "
			+ " and "
			+ " e.mstColumnName = 'STATUS_APPROVAL' "
			+ " and "
			+ " e.mstCodeType = a.statusApproval "
			//searching
			+ " and (upper(a.prosedurId) like upper(:search) "
			+ " or upper(a.prosedurName) like upper(:search) "
			+ " or a.totalProsedur like :search "
			+ " or upper(e.mstCodeTypeName) like upper(:search) " //status persetujuan
			+ " or upper(d.mstCodeTypeName) like upper(:search) "
			+ " or upper(c.menuName) like upper(:search) "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) )")   //status aktif
	public List<Object[]> getAllFilterList(@Param("createdBy") String user, 
			@Param("projekCode") String projek, @Param("search") String search);
	
	@Query("select a.prosedurName from TableMasterProsedurformHdr a where a.projekCode = :projekCode")
	public List<String> collectAllExistingProsedurName(@Param("projekCode") String projekCode );
	
	@Query("select a from TableMasterProsedurformHdr a where a.projekCode = :projekCode and a.prosedurId = :trxId ")
	public TableMasterProsedurformHdr collectInformation(@Param("projekCode") String projekCode,@Param("trxId") String trxId);
	
	@Modifying
	@Query("delete from TableMasterProsedurformHdr a where a.projekCode = :projekCode and a.prosedurId = :trxId ")
	public int deleteHdr(@Param("projekCode") String projekCode,@Param("trxId") String trxId);
}
