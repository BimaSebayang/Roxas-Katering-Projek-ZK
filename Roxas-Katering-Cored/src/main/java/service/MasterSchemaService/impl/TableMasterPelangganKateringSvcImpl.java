package service.MasterSchemaService.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import Master.MapperClass.MappingClassSvc;
import PagingLib.Request.RequestPaging;
import PagingLib.Slice.SlicePaging;
import dao.ProcedureDao;
import dao.MasterSchemaDao.TableMasterPelangganKateringDao;
import entity.MasterSchema.TableMasterPelangganKatering;
import service.MasterSchemaService.TableMasterPelangganKateringSvc;

@Service("tableMasterPelangganKateringSvc")
@Transactional
public class TableMasterPelangganKateringSvcImpl extends RequestPaging implements TableMasterPelangganKateringSvc{

	private static final long serialVersionUID = 1L;

	@Autowired
	private TableMasterPelangganKateringDao tableMasterPelangganKateringDao;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	@Autowired
	private ProcedureDao procedureDao;
	
//	protected SlicePaging<TableMasterPelangganKateringDto> customloadAllList(TableMasterPelangganKateringDto filter, String user,
//			String projek, String search,int page, String direction, String orderBy){
//List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtos = new ArrayList<>();
//		
//		List<String> kodePelanggans = new ArrayList<>();
//		List<String> namaPelanggans = new ArrayList<>();
//		List<BigDecimal> totalPesananTerakhirs = new ArrayList<>();
//		List<String> statusPelanggans = new ArrayList<>();
//		List<String> statusPersetujuans = new ArrayList<>();
//		List<BigDecimal> komposisiPesanans = new ArrayList<>();
//		
//		if( filter.getKodePelanggans().size()==0) {
//			kodePelanggans.add("");
//		}
//    	if (filter.getNamaPelanggans().size()==0) {
//			namaPelanggans.add("");
//		}
//		if (filter.getBanyakPesanans().size()==0) {
//			totalPesananTerakhirs.add(new BigDecimal(-1));
//		}
//    	if(filter.getStatusPelanggans().size()==0) {
//			statusPelanggans.add("");
//		}
//    	if(filter.getStatusPersetujans().size()==0) {
//			statusPersetujuans.add("");
//		}
//    	if(filter.getKomposisiPesanans().size()==0) {
//			komposisiPesanans.add(new BigDecimal(-1));
//		}
//		
//    	for( String o :filter.getKodePelanggans()) {
//			kodePelanggans.add(o);
//		}
//    	for ( String o : filter.getNamaPelanggans()) {
//			namaPelanggans.add(o);
//		}
//		for (BigDecimal o : filter.getBanyakPesanans()) {
//			totalPesananTerakhirs.add(o);
//		}
//    	for(String o : filter.getStatusPelanggans()) {
//			statusPelanggans.add(o);
//		}
//    	for(String o : filter.getStatusPersetujans()) {
//			statusPersetujuans.add(o);
//		}
//    	for(BigDecimal o : filter.getKomposisiPesanans()) {
//			komposisiPesanans.add(o);
//		}
//			
//		List<Object[]> obj = tableMasterPelangganKateringDao.costumGetAllExistingData(kodePelanggans,namaPelanggans,statusPelanggans,statusPersetujuans,
//				komposisiPesanans,totalPesananTerakhirs,user, projek, "%"+search+"%");
//		Page<Object[]> pObj = 
//				Page 
//		for (Object[] o : obj) {
//			TableMasterPelangganKateringDto dto = new TableMasterPelangganKateringDto();
//			dto = (TableMasterPelangganKateringDto) mappingClassSvc.mapperEntityToDto(dto, o[0]);
//			dto.setStatusPersetujuan((String) o[1]);
//			dto.setStatusPelanggan((String) o[2]);
//			
//			Long longNumber = (Long) tableMasterPelangganKateringDao.getTotalPesanan(dto.getKodePelanggan());
//			
//			if(longNumber != null) {	
//			dto.setBanyakPesanan(new BigDecimal(longNumber));
//			}
//			else {
//			dto.setBanyakPesanan(new BigDecimal(0));	
//			}
//			tableMasterPelangganKateringDtos.add(dto);
//		}
//	}
	
	@Override
	public SlicePaging<TableMasterPelangganKateringDto> loadAllList(TableMasterPelangganKateringDto filter, String user,
			String projek, String search,int page, String direction, String orderBy) {
		
		if(direction.equals("")||direction==null) {
			direction = "ASC";
		}
		if(orderBy.equals("")||orderBy==null) {
			orderBy = "(a.kodePelanggan),(a.namaPelanggan),(c.mstCodeTypeName),(b.mstCodeTypeName),(a.komposisiPesanan),(a.createdDate)";
		}
		if(orderBy.equalsIgnoreCase("banyakPesanan")) {
			orderBy = "";
		}
		
		List<TableMasterPelangganKateringDto> tableMasterPelangganKateringDtos = new ArrayList<>();
		
		List<String> kodePelanggans = new ArrayList<>();
		List<String> namaPelanggans = new ArrayList<>();
		List<BigDecimal> totalPesananTerakhirs = new ArrayList<>();
		List<String> statusPelanggans = new ArrayList<>();
		List<String> statusPersetujuans = new ArrayList<>();
		List<BigDecimal> komposisiPesanans = new ArrayList<>();
		
		if( filter.getKodePelanggans().size()==0) {
			kodePelanggans.add("");
		}
    	if (filter.getNamaPelanggans().size()==0) {
			namaPelanggans.add("");
		}
		if (filter.getBanyakPesanans().size()==0) {
			totalPesananTerakhirs.add(new BigDecimal(-1));
		}
    	if(filter.getStatusPelanggans().size()==0) {
			statusPelanggans.add("");
		}
    	if(filter.getStatusPersetujans().size()==0) {
			statusPersetujuans.add("");
		}
    	if(filter.getKomposisiPesanans().size()==0) {
			komposisiPesanans.add(new BigDecimal(-1));
		}
		
    	for( String o :filter.getKodePelanggans()) {
			kodePelanggans.add(o);
		}
    	for ( String o : filter.getNamaPelanggans()) {
			namaPelanggans.add(o);
		}
		for (BigDecimal o : filter.getBanyakPesanans()) {
			totalPesananTerakhirs.add(o);
		}
    	for(String o : filter.getStatusPelanggans()) {
			statusPelanggans.add(o);
		}
    	for(String o : filter.getStatusPersetujans()) {
			statusPersetujuans.add(o);
		}
    	for(BigDecimal o : filter.getKomposisiPesanans()) {
			komposisiPesanans.add(o);
		}
			
		
		Page<Object[]> obj = tableMasterPelangganKateringDao.getAllExistingData(kodePelanggans,namaPelanggans,statusPelanggans,statusPersetujuans,
				komposisiPesanans,totalPesananTerakhirs,user, projek, "%"+search+"%", createRequestPage(page, direction, orderBy));
		for (Object[] o : obj) {
			TableMasterPelangganKateringDto dto = new TableMasterPelangganKateringDto();
			dto = (TableMasterPelangganKateringDto) mappingClassSvc.mapperEntityToDto(dto, o[0]);
			dto.setStatusPersetujuan((String) o[1]);
			dto.setStatusPelanggan((String) o[2]);
			
			Long longNumber = (Long) tableMasterPelangganKateringDao.getTotalPesanan(dto.getKodePelanggan());
			
			if(longNumber != null) {	
			dto.setBanyakPesanan(new BigDecimal(longNumber));
			}
			else {
			dto.setBanyakPesanan(new BigDecimal(0));	
			}
			tableMasterPelangganKateringDtos.add(dto);
		}
		
		return new SlicePaging<TableMasterPelangganKateringDto>(tableMasterPelangganKateringDtos, obj.getTotalElements());
	}

	@Override
	public List<Object> getAllDataFilter(String user, String projek, String filterExec, String search) {
		List<Object[]> listFilter = tableMasterPelangganKateringDao.getTheFilterList(user, projek, search);
		List<Object> result = new ArrayList<>();
		Set<Object> setFilter = new TreeSet<>();
		for (Object[] o : listFilter) {
		if(filterExec.equalsIgnoreCase("KODE PELANGGAN")) {
			setFilter.add(o[0]);
		}
			else if(filterExec.equalsIgnoreCase("NAMA PELANGGAN")) {
				setFilter.add(o[1]);
			}
				else if(filterExec.equalsIgnoreCase("TOTAL PESANAN TERAKHIR")) {
					if(o[5]!=null) {
					setFilter.add(new Long((long) o[5]));
					}
					else {
						setFilter.add(new Long(0));
					}
				}
					else if(filterExec.equalsIgnoreCase("STATUS PELANGGAN")) {
						setFilter.add(o[4]);
					}
						else if(filterExec.equalsIgnoreCase("STATUS PERSETUJUAN")) {
							setFilter.add(o[3]);
						}
							else if(filterExec.equalsIgnoreCase("KOMPOSISI PESANAN")) {
								setFilter.add(o[2]);
							}
		}
		
		for (Object object : setFilter) {
			result.add(object);
		}
		return result;
	}

	@Override
	public int save(TableMasterPelangganKateringDto tableMasterPelangganKateringDto) {
		TableMasterPelangganKatering tableMasterPelangganKatering = new TableMasterPelangganKatering();
		if(tableMasterPelangganKateringDto.getKodePelanggan()==null) {
		tableMasterPelangganKatering = (TableMasterPelangganKatering) mappingClassSvc.mapperEntityToDto(tableMasterPelangganKatering, tableMasterPelangganKateringDto);
		String genNum = procedureDao.generateNextNumber("FORM04", tableMasterPelangganKateringDto.getCreatedBy(), 
			 tableMasterPelangganKateringDto.getProjekCode(), "TRANKAT02", tableMasterPelangganKateringDto.getCreatedDate());
		tableMasterPelangganKatering.setKodePelanggan(genNum);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String date = sdf.format(new Date());
		tableMasterPelangganKatering.setKodeKupon(date+genNum);
		tableMasterPelangganKatering.setPassword("PASS01.");
		}
		else{
			tableMasterPelangganKatering = (TableMasterPelangganKatering) mappingClassSvc.mapperEntityToDto(tableMasterPelangganKatering, tableMasterPelangganKateringDto);
			procedureDao.createHistoryTrancsaction(tableMasterPelangganKatering.getKodePelanggan(), 
					 "FORM04", "TRANKAT02", tableMasterPelangganKatering.getProjekCode(), "EDIT BY USER","0", tableMasterPelangganKatering.getUpdatedBy(), 
					 tableMasterPelangganKatering.getUpdatedDate());
		}
		tableMasterPelangganKateringDao.save(tableMasterPelangganKatering);
		return 0;
	}

	@Override
	public int deletePelanggan(TableMasterPelangganKateringDto tableMasterPelangganKateringDto) {
		procedureDao.createHistoryTrancsaction(tableMasterPelangganKateringDto.getKodePelanggan(), 
				 "FORM04", "TRANKAT02", tableMasterPelangganKateringDto.getProjekCode(), "DELETE BY USER","1", tableMasterPelangganKateringDto.getUpdatedBy(), 
				 tableMasterPelangganKateringDto.getUpdatedDate());
		tableMasterPelangganKateringDao.deletePelanggan(tableMasterPelangganKateringDto.getKodePelanggan());
		return 0;
	}

	@Override
	public void send(TableMasterPelangganKateringDto tableMasterPelangganKateringDto) {
		String reason = "";
		if(tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("APPD")) {
			reason = "PENGIRIMAN UNTUK PERSETUJUAN PELANGGAN MANUAL";
		}
		else if(tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("REJE")) {
			reason = "PENGIRIMAN UNTUK PENOLAKAN PELANGGAN MANUAL";
		}
		else if(tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("REVS")) {
			reason = "PENGIRIMAN UNTUK MELAKUKAN REVISI PELANGGAN MANUAL";
		}
		else if(tableMasterPelangganKateringDto.getStatusApproval().equalsIgnoreCase("APPR")) {
			reason = "PENGIRIMAN UNTUK APPROVAL PELANGGAN MANUAL";
		}
		
		if(tableMasterPelangganKateringDto.getMessageId() == null) {
			tableMasterPelangganKateringDto.setMessageId("");
		}
		
		procedureDao.createApprovalTrancsaction(tableMasterPelangganKateringDto.getMessageId(), tableMasterPelangganKateringDto.getKodePelanggan(), 
				"FORM04", "TRANKAT02", tableMasterPelangganKateringDto.getProjekCode(), reason, tableMasterPelangganKateringDto.getStatusApproval(), 
				tableMasterPelangganKateringDto.getUpdatedBy(), tableMasterPelangganKateringDto.getUpdatedDate());
	}

	@Override
	public TableMasterPelangganKateringDto collectInformation(Map<String, Object> mapp) {
		String trxId = (String) mapp.get("trxId");
		String projekCode = (String) mapp.get("projekCode");
		TableMasterPelangganKatering tableMasterPelangganKatering = tableMasterPelangganKateringDao.collectUserInformation(trxId, projekCode);
		TableMasterPelangganKateringDto tableMasterPelangganKateringDto = new TableMasterPelangganKateringDto();
		tableMasterPelangganKateringDto = (TableMasterPelangganKateringDto) mappingClassSvc.mapperEntityToDto(tableMasterPelangganKateringDto, tableMasterPelangganKatering);
		return tableMasterPelangganKateringDto;
	}

}
