package dao.PortalSchemaDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.PortalSchema.*;
import entity.PortalSchema.PortalSchemaPk.*;


public interface TablePortalProjekDao extends JpaRepository<TablePortalProjek, TablePortalProjekPk>{

	@Query(" select a,b,c.mstConditionName from TablePortalProjek a, TablePortalProjekDetail b, TableMasterAllCode c where "
			+ " a.kodePortal = b.kodePortal "
			+ " and "
			+ " b.status = 1 "
			+ " and "
			+ " a.status = 1 "
			+ " and "
			+ " b.userId in (select c.userId from TableUser c where c.status = 1 ) "
			+ " and b.userId = :userId "
			+ " and c.mstCodeType = a.kodeProjek"
			+ " and upper(a.namaPortal) like upper(:search) "
			+ " order by a.namaPortal asc ")
	public List<Object[]> collectAllExistingPortalInCurrentUserIdAsc(@Param("userId") String userId, 
			@Param("search") String search );
	
	@Query(" select a,b,c.mstConditionName from TablePortalProjek a, TablePortalProjekDetail b,TableMasterAllCode c where "
			+ " a.kodePortal = b.kodePortal "
			+ " and "
			+ " b.status = 1 "
			+ " and "
			+ " a.status = 1 "
			+ " and "
			+ " b.userId in (select c.userId from TableUser c where c.status = 1 ) "
			+ " and b.userId = :userId "
			+ " and c.mstCodeType = a.kodeProjek"
			+ " and upper(a.namaPortal) like :search "
			+ " order by a.namaPortal desc ")
	public List<Object[]> collectAllExistingPortalInCurrentUserIdDesc(@Param("userId") String userId, 
			@Param("search") String search );
}
