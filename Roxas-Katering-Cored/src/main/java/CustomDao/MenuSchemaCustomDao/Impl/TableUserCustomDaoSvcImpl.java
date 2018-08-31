package CustomDao.MenuSchemaCustomDao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import entity.MenuSchema.TableConfigurationMenu;
import entity.MenuSchema.TableUser;
import CustomDao.MenuSchemaCustomDao.TableUserCustomDaoSvc;

@Service("tableUserCustomDaoSvc")
public class TableUserCustomDaoSvcImpl implements TableUserCustomDaoSvc {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Map<String, Object> loginUser(String userId, String password) {
		Map<String, Object> map = new HashMap<>();
		String sqlCount = " select count(a.USER_ID) as existing_userId from MENU.TABLE_USER_PEGANTI a "
	            + " where a.USER_ID = '"+userId+"' and a.PASSWORD='"+password+"'";
		int count = (int) em.createNativeQuery(sqlCount).getSingleResult();
		
		if(count<1){
			map.put("countUser", count);
			map.put("userId", new TableUser());
		}
	    else if(count==1){
		String sql = " select a.* from MENU.TABLE_USER_PEGANTI a "
		            + " where a.USER_ID = '"+userId+"' and a.PASSWORD='"+password+"' ";
		TableUser user = (TableUser) em.createNativeQuery(sql, TableUser.class)
				.getSingleResult();
		
		map.put("countUser", count);
		map.put("userId", user);
		}
	    else{
	    	map.put("countUser", count);
			map.put("userId", new TableUser());
	    }
		
		return map;
	}
	
	@Override
	public Map<String,Object> getTheUserLogin(String userId) {
		Map<String, Object> map = new HashMap<>();
		String sqlCount = " select count(a.USER_ID) as existing_userId from MENU.TABLE_USER_PEGANTI a "
	            + " where a.USER_ID = '"+userId+"'";
		int count = (int) em.createNativeQuery(sqlCount).getSingleResult();
		
	
	    if(count==1){
		String sql = " select a.* from MENU.TABLE_USER_PEGANTI a "
		            + " where a.USER_ID = '"+userId+"'";
		TableUser user = (TableUser) em.createNativeQuery(sql, TableUser.class)
				.getSingleResult();
		
		map.put("rightUserId", user.getUserId());
		map.put("rightPassword", user.getPassword());
		map.put("userStatus", user.getStatus());
		}
	    else{
	    	map.put("rightUserId", null);
			map.put("rightPassword", null);
	    }
		
		return map;
	}

	@Override
	public Map<String, Object> allActiveUser() {
		Map<String, Object> map = new HashMap<>();
		String sql = "select a.USER_ID , a.ID, b.NAMA_KARYAWAN, c.MST_CODE_TYPE_NAME, a.CREATED_DATE, d.NAMA_KARYAWAN  , a.UPDATED_DATE, "
                + " e.NAMA_KARYAWAN  from MENU.TABLE_USER_PEGANTI a "
                + " inner join PEGAWAI.TABLE_DATA_KARYAWAN b "
                + " on " 
                + " a.ID = b.ID "
                + " inner join MASTER.TABLE_MASTER_ALL_CODE c "
                + " on " 
                + " c.MST_CODE_TYPE = a.STATUS " 
                + " inner join PEGAWAI.TABLE_DATA_KARYAWAN d "
                + " on "
                + " a.CREATED_BY = d.ID "
                + " left join PEGAWAI.TABLE_DATA_KARYAWAN e "
                + " on "
                + " a.UPDATED_BY = e.ID "
                + " where UPPER(c.MST_COLUMN_NAME) = UPPER('status') "
                + " and a.STATUS = 0 ";
		List<Object[]> objectUser = em.createNativeQuery(sql).getResultList();
		map.put("counts", objectUser.size());
		map.put("contents", objectUser);
		
		
		return map;
	}

	@Override
	public Map<String, Object> allNonActiveUser() {
		Map<String, Object> map = new HashMap<>();
		String sql = "select a.USER_ID , a.ID, b.NAMA_KARYAWAN, c.MST_CODE_TYPE_NAME, a.CREATED_DATE, d.NAMA_KARYAWAN  , a.UPDATED_DATE, "
                + " e.NAMA_KARYAWAN  from MENU.TABLE_USER_PEGANTI a "
                + " inner join PEGAWAI.TABLE_DATA_KARYAWAN b "
                + " on " 
                + " a.ID = b.ID "
                + " inner join MASTER.TABLE_MASTER_ALL_CODE c "
                + " on " 
                + " c.MST_CODE_TYPE = a.STATUS " 
                + " inner join PEGAWAI.TABLE_DATA_KARYAWAN d "
                + " on "
                + " a.CREATED_BY = d.ID "
                + " left join PEGAWAI.TABLE_DATA_KARYAWAN e "
                + " on "
                + " a.UPDATED_BY = e.ID "
                + " where UPPER(c.MST_COLUMN_NAME) = UPPER('status') "
                + " and a.STATUS = 0 ";
		List<Object[]> objectUser = em.createNativeQuery(sql).getResultList();
		map.put("counts", objectUser.size());
		map.put("contents", objectUser);
	
		return map;
	}

}
