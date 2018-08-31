package CustomDao.MenuSchemaCustomDao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entity.MenuSchema.TableConfigurationMenu;
import entity.MenuSchema.TableMenu;
import CustomDao.MenuSchemaCustomDao.TableConfigurationMenuCustomDaoSvc;

@Service("tableConfigurationMenuCustomDaoSvc")
@Repository
@Transactional
public class TableConfigurationMenuCustomDaoSvcImpl implements TableConfigurationMenuCustomDaoSvc{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TableConfigurationMenu> tableConfigurationMenusCustom(int Test) {
		String query = "select top "+ Test + " a.* from menu.TABLE_CONFIGURATION_MENU a";
		List<TableConfigurationMenu> l = em.createNativeQuery(query, TableConfigurationMenu.class)
				.getResultList();
		return l;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getTheFilterList(String user, String projek,String filterExec) {
		String query = "SELECT distinct(" + filterExec + "), A.PROJEK_CODE "
				+ " FROM MENU.TABLE_CONFIGURATION_MENU A, MENU.TABLE_MENU B, MENU.TABLE_BUTTON C, "+ 
				" PEGAWAI.TABLE_DATA_KARYAWAN D, MENU.TABLE_USER_PEGANTI E, MASTER.TABLE_MASTER_ALL_CODE F " + 
				"WHERE " + 
				"A.MENU_BUTTON = C.BUTTON_CODE " + 
				"AND  " + 
				"A.MENU_CODE = B.MENU_CODE " + 
				"AND  " + 
				"A.STATUS = '1' " + 
				"AND " + 
				"B.STATUS = '1' " + 
				"AND " + 
				"C.STATUS = '1' " + 
				"AND A.PROJEK_CODE = B.PROJEK_CODE " + 
				"AND B.PROJEK_CODE = C.PROJEK_CODE " + 
				"AND A.PROJEK_CODE = '"+ projek + "' "+ 
				"AND E.USER_ID = A.USER_ID " + 
				"AND E.PEGAWAI_ID = D.PEGAWAI_ID " + 
				"AND A.CREATED_BY = '" + user + "' " + 
				"AND F.MST_COLUMN_NAME = 'STATUS' " + 
				"AND F.MST_CODE_TYPE = A.STATUS ";
		
		List<String> obj = this.em.createNativeQuery(query,TableMenu.class).getResultList();
		
	 
		
		
		return obj;
	}
	
}
