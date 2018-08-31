package dao.MenuSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MenuSchema.TableMenu;
import entity.MenuSchema.TablePopUpMenu;
import entity.MenuSchema.entityMenuPk.TableMenuPk;
import entity.MenuSchema.entityMenuPk.TablePopUpMenuPk;

public interface TablePopUpMenuDao extends 
JpaRepository<TablePopUpMenu, TablePopUpMenuPk>{
       @Query("select a from TablePopUpMenu a where a.popupMenuFile = :popupMenuFile and a.status = '1' ")
       public List<TablePopUpMenu> requestPopUpMenu(@Param("popupMenuFile") String popupMenuFile);
}
