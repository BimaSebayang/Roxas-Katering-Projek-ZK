package CustomDao.MenuSchemaCustomDao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import entity.MenuSchema.TableConfigurationMenu;
import CustomDao.MenuSchemaCustomDao.TableConfigurationMenuCustomDaoSvc;

@Service("tableConfigurationMenuCustomDaoSvc")
public class TableConfigurationMenuCustomDaoSvcImpl implements TableConfigurationMenuCustomDaoSvc{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<TableConfigurationMenu> tableConfigurationMenusCustom(int Test) {
		String query = "select top "+ Test + " a.* from menu.TABLE_CONFIGURATION_MENU a";
		List<TableConfigurationMenu> l = em.createNativeQuery(query, TableConfigurationMenu.class)
				.getResultList();
		return l;
	}
	
}
