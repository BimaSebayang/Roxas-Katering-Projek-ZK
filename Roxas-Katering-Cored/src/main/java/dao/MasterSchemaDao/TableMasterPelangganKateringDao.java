package dao.MasterSchemaDao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.MasterSchema.TableMasterPelangganKatering;
import entity.MasterSchema.entityMasterPk.TableMasterPelangganKateringPk;

public interface TableMasterPelangganKateringDao extends 
JpaRepository<TableMasterPelangganKatering, TableMasterPelangganKateringPk> {
	
	@Query(" select sum(b.totalPesanan) from TableMasterPelangganKatering a, TableTrxPemesananHdr b where  " 
		   + " b.kodePelanggan = a.kodePelanggan and a.kodePelanggan = :kodePelanggan ")
	public Long getTotalPesanan(@Param("kodePelanggan")String kodePelanggan);

	
	
	@Query(" select a, b.mstCodeTypeName, c.mstCodeTypeName " + 
			" from TableMasterPelangganKatering a, TableMasterAllCode b, " +
			" TableMasterAllCode c " + 
			" where  " + 
			" b.mstColumnName = 'STATUS_APPROVAL' " + 
			" and " +
			" b.mstCodeType = a.statusApproval " + 
			" and " + 
			" c.mstColumnName = 'STATUS_AKTIF' " + 
			" and " + 
			" c.mstCodeType = a.statusAktif " + 
			" and  " + 
			" a.createdBy = :user " + 
			" and  " + 
			" a.projekCode = :projek " + 
			" and " + 
			" a.tipePelanggan = 'M'"
			//start filter
			+ " and a.kodePelanggan in :kodePelanggans "
			+ " and upper(a.namaPelanggan) in :listNamaPelanggan"
			+ " and upper(c.mstCodeTypeName) in :listStatusPelanggans " //--untuk search status pelanggan
    		+ " and upper(b.mstCodeTypeName) in :listStatusPersetujuan"  //untuk searc status persetujuan
			+ " and a.komposisiPesanan in :komposisiPesanans "
			+ " and convert(decimal(20,4),(select case when sum(b.totalPesanan) is null then 0 "
			+ " else sum(b.totalPesanan) end "
			+ " from TableTrxPemesananHdr b where  "
			+ "     b.kodePelanggan = a.kodePelanggan )  "
	        + " ) in :totalPesananTerakhirs "
			//Start Searching
			+ " and ( upper(a.kodePelanggan) like upper(:search) "
			+ " or upper(a.namaPelanggan) like upper(:search)"
			+ " or upper(c.mstCodeTypeName) like upper(:search) " //--untuk search status pelanggan
			+ " or upper(b.mstCodeTypeName) like upper(:search) "  //untuk searc status persetujuan
			+ " or a.komposisiPesanan like upper(:search) "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) "
			+ " or (select sum(b.totalPesanan) from TableTrxPemesananHdr b where  b.kodePelanggan = a.kodePelanggan ) like upper(:search) "
			+ " ) group by b.mstCodeTypeName, c.mstCodeTypeName, "
			+ " a.kodePelanggan, a.namaPelanggan, a.tipePelanggan, a.kodeKupon, a.keterangan, a.komposisiPesanan, a.createdDate, a.createdBy, a.updatedDate, "
			+ " a.updatedBy, a.alamatPelanggan, a.password, a.kodePosPelanggan, a.statusAktif, a.statusApproval, a.projekCode, a.kontakPelanggan")
	public Page<Object[]> getAllExistingData(@Param("kodePelanggans") List<String> kodePelanggans,@Param("listNamaPelanggan") List<String> listNamaPelanggan,
			@Param("listStatusPelanggans") List<String> listStatusPelanggans, @Param("listStatusPersetujuan") List<String> listStatusPersetujuan
			,@Param("komposisiPesanans")List<BigDecimal> komposisiPesanans, @Param("totalPesananTerakhirs") List<BigDecimal> totalPesananTerakhirs
			,@Param("user") String user, 
			@Param("projek") String projek, @Param("search") String search, Pageable pageable);
	
	
	@Query(" select a.kodePelanggan, a.namaPelanggan, a.komposisiPesanan, b.mstCodeTypeName, c.mstCodeTypeName, " + 
			" (select sum(b.totalPesanan) from TableTrxPemesananHdr b where  " + 
			" b.kodePelanggan = a.kodePelanggan )" + 
			" from TableMasterPelangganKatering a, TableMasterAllCode b, " + 
			" TableMasterAllCode c " + 
			" where  " + 
			" b.mstColumnName = 'STATUS_APPROVAL' " + 
			" and  " + 
			" b.mstCodeType = a.statusApproval " + 
			" and " + 
			" c.mstColumnName = 'STATUS_AKTIF' " + 
			" and " + 
			" c.mstCodeType = a.statusAktif " + 
			" and  " + 
			" a.createdBy = :user " + 
			" and  " + 
			" a.projekCode = :projek " + 
			" and " + 
			" a.tipePelanggan = 'M'"
			//Start Searching
			+ " and ( upper(a.kodePelanggan) like upper(:search) "
			+ " or upper(a.namaPelanggan) like upper(:search)"
			+ " or upper(c.mstCodeTypeName) like upper(:search) " //--untuk search status pelanggan
			+ " or upper(b.mstCodeTypeName) like upper(:search) "  //untuk searc status persetujuan
			+ " or a.komposisiPesanan like upper(:search) "
			+ " or convert(varchar,a.createdDate,103) like upper(:search) "
			+ " or (select sum(b.totalPesanan) from TableTrxPemesananHdr b where  "
			+ "     b.kodePelanggan = a.kodePelanggan ) like upper(:search) "
			+ " )")
	public List<Object[]> getTheFilterList(@Param("user") String user, 
			@Param("projek") String projek, @Param("search") String search);
	
	@Modifying
	@Query("delete from TableMasterPelangganKatering a "
			+ " where a.kodePelanggan = :kodePelanggan ")
	public void deletePelanggan( @Param("kodePelanggan") String kodePelanggan);
	
	@Query("select a from TableMasterPelangganKatering a where a.kodePelanggan = :trxId and a.projekCode = :projekCode ")
	public TableMasterPelangganKatering collectUserInformation(@Param("trxId") String trxId, @Param("projekCode") String projekCode);
}
