package CustomDao.MenuSchemaCustomDao;

import java.util.List;

import entity.MenuSchema.TableConfigurationMenu;

public interface TableConfigurationMenuCustomDaoSvc  {
	public  List<TableConfigurationMenu> tableConfigurationMenusCustom(int Test);
	
	public  List<String> getTheFilterList(String user, String projek,String filterExec);
}
