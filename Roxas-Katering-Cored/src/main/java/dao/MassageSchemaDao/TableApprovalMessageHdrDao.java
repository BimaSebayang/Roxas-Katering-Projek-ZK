package dao.MassageSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MassageSchema.TableApprovalMessageHdr;
import entity.MassageSchema.entityMessagePk.TableApprovalMessageHdrPk;

public interface TableApprovalMessageHdrDao extends JpaRepository<TableApprovalMessageHdr, TableApprovalMessageHdrPk>{

}
