package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MassageSchema.TableApprovalMessageDtl;
import entity.MassageSchema.entityMessagePk.TableApprovalMessageDtlPk;

public interface TrxApprovalDao extends JpaRepository<TableApprovalMessageDtl, TableApprovalMessageDtlPk>{

	
	@Query("select a,b, c.menuName, d.namaKaryawan, e.urlMenuApproval from TableApprovalMessageHdr a, TableApprovalMessageDtl b, TableMenu c, TableDataKaryawan d, TablePersonApprovalHdr e "
			+ " where b.approvalPerson = :approvalPerson and b.resultStatusApproval = 'APPR' "
			+ " and b.messageId = a.messageId and a.projekCode = b.projekCode and a.projekCode = :projekCode "
			+ " and c.menuCode = a.menuCode "
			+ " and d.pegawaiId = a.createdBy "
			+ " and e.menuCode = a.menuCode "
			//start searching
			+ " and (upper(b.messageId) like upper(:search) "
			+ " or upper(a.trxId) like upper(:search) "
			+ " or upper(c.menuName) like upper(:search)"
			+ " or upper(d.namaKaryawan) like upper(:search) "
			+ " or convert(varchar,b.createdDate,103) like upper(:search) ) ")
	public List<Object[]> collectUserMessage(@Param("approvalPerson") String employeeId, @Param("projekCode")String projekCode,@Param("search") String search);
}
