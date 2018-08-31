package CustomDao.MenuSchemaCustomDao;

import java.util.Map;

import entity.MenuSchema.TableUser;

public interface TableUserCustomDaoSvc {
   public Map<String,Object> loginUser(String userId, String password);
   public Map<String,Object> getTheUserLogin(String userId);
   public Map<String,Object> allActiveUser();
   public Map<String,Object> allNonActiveUser();
}
