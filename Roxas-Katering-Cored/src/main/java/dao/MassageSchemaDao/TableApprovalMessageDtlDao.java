package dao.MassageSchemaDao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MassageSchema.TableApprovalMessageDtl;
import entity.MassageSchema.entityMessagePk.TableApprovalMessageDtlPk;

public interface TableApprovalMessageDtlDao extends JpaRepository<TableApprovalMessageDtl, TableApprovalMessageDtlPk>{

}
