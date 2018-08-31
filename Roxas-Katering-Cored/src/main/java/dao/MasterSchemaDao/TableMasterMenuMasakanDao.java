package dao.MasterSchemaDao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterMenuMasakan;
import entity.MasterSchema.entityMasterPk.TableMasterMenuMasakanPk;

public interface TableMasterMenuMasakanDao extends 
JpaRepository<TableMasterMenuMasakan, TableMasterMenuMasakanPk>{

	@Query("select a, b.mstCodeTypeName, c.mstCodeTypeName " + 
			"from TableMasterMenuMasakan a, TableMasterAllCode b, TableMasterAllCode c " + 
			"where  " + 
			"a.createdBy = :user " + 
			"and  " + 
			"a.projekCode = :projek " + 
			"and " + 
			"b.mstColumnName = 'STATUS_AKTIF' " + 
			"and " + 
			"b.mstCodeType = a.statusAktif " + 
			"and " + 
			"c.mstColumnName = 'STATUS_APPROVAL' " + 
			"and  " + 
			"c.mstColumnName = a.statusApproval "
			//Start Filter
			+" and a.kodeMakanan in :kodeMakanans "
			+" and a.namaMakanan in :namaMakanans "
			+" and a.kodeResep in :kodeReseps "
			+" and b.mstCodeTypeName in :statusMakanans "
			+" and c.mstCodeTypeName in :statusPersetujuans "
			//Start Searching
			+" and ( upper(a.kodeMakanan) like :search "
			+ " or upper(a.namaMakanan) like :search "
			+ " or upper(a.kodeResep) like :search "
			+ " or upper(b.mstCodeTypeName) like :search "
			+ " or upper(c.mstCodeTypeName) like :search "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) )")
	public Page<Object[]> getAllExistingData(@Param("kodeMakanans") List<String> kodeMakanans,@Param("namaMakanans") List<String> namaMakanans, 
			@Param("kodeReseps") List<String> kodeReseps, @Param("statusMakanans")List<String> statusMakanans, @Param("statusPersetujuans")List<String> statusPersetujuans
			,@Param("user") String user, @Param("projek") String projek, @Param("search") String search, Pageable pageable);
	
	@Query("select a.kodeMakanan, a.namaMakanan, a.kodeResep, b.mstCodeTypeName, c.mstCodeTypeName " + 
			"from TableMasterMenuMasakan a, TableMasterAllCode b, TableMasterAllCode c " + 
			"where  " + 
			"a.createdBy = :user " + 
			"and  " + 
			"a.projekCode = :projek " + 
			"and " + 
			"b.mstColumnName = 'STATUS_AKTIF' " + 
			"and " + 
			"b.mstCodeType = a.statusAktif " + 
			"and " + 
			"c.mstColumnName = 'STATUS_APPROVAL' " + 
			"and  " + 
			"c.mstColumnName = a.statusApproval "
			+" and ( upper(a.kodeMakanan) like :search "
			+ " or upper(a.namaMakanan) like :search "
			+ " or upper(a.kodeResep) like :search "
			+ " or upper(b.mstCodeTypeName) like :search "
			+ " or upper(c.mstCodeTypeName) like :search "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) )")
	public List<Object[]> getTheFilterList(@Param("user") String user,@Param("projek") String projek, @Param("search") String search);
}
