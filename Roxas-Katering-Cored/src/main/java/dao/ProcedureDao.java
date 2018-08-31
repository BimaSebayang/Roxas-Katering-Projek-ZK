package dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import entity.MenuSchema.TableMenu;
import entity.MenuSchema.entityMenuPk.TableMenuPk;

public interface ProcedureDao  extends  JpaRepository<TableMenu, TableMenuPk>{
     @Procedure(procedureName="FORMAT.GENERATE_AUTO_ID")
     public String generateNextNumber(String formatId, String creator, String projek, String menu, Date createdDate);
     
     @Procedure(procedureName="HISTORY.SP_CREATE_RUNNING_TRX")
     public void createHistoryTrancsaction(String trxId, String formatId, String menuCode, String projekCode, String reasonEdited, String flagDelete, String editedBy, Date editedDate);

     @Procedure(procedureName="MESSAGE.SP_CREATE_APPROVAL_TRX")
     public void createApprovalTrancsaction(
    		 String MessageId, String trxId, String formatId, String menuForm, String projekCode, String reason, String statusApproval, String editor, Date editedDate);

}
