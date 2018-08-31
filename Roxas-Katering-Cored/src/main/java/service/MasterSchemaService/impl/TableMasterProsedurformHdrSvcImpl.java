package service.MasterSchemaService.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.zkoss.zhtml.Big;

import DataTransferObjectLib.MasterSchemaDto.TableMasterPelangganKateringDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformDtlDto;
import DataTransferObjectLib.MasterSchemaDto.TableMasterProsedurformHdrDto;
import Master.MapperClass.MappingClassSvc;
import PagingLib.Request.RequestPaging;
import PagingLib.Slice.SlicePaging;
import dao.ProcedureDao;
import dao.MasterSchemaDao.TableMasterProsedurformDtlDao;
import dao.MasterSchemaDao.TableMasterProsedurformHdrDao;
import entity.MasterSchema.TableMasterPelangganKatering;
import entity.MasterSchema.TableMasterProsedurformDtl;
import entity.MasterSchema.TableMasterProsedurformHdr;
import service.MasterSchemaService.TableMasterProsedurformHdrSvc;

@Service("tableMasterProsedurformHdrSvc")
@Transactional
public class TableMasterProsedurformHdrSvcImpl  extends RequestPaging implements TableMasterProsedurformHdrSvc{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired	
	private TableMasterProsedurformHdrDao tableMasterProsedurformHdrDao;
	@Autowired
	private ProcedureDao procedureDao;
	@Autowired
	private MappingClassSvc mappingClassSvc;
	@Autowired
	private TableMasterProsedurformDtlDao tableMasterProsedurformDtlDao;
	
	@Override
	public List<String> collectAllProsedurName(String projekCode) {
		List<String> collectList = tableMasterProsedurformHdrDao.collectAllExistingProsedurName(projekCode);
		return collectList;
	}

	@Override
	public String save(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto) {
		String prosedurId = tableMasterProsedurformHdrDto.getProsedurId();
		if(prosedurId==null||prosedurId=="") {
		prosedurId = procedureDao.generateNextNumber("FORM13", tableMasterProsedurformHdrDto.getCreatedBy(), tableMasterProsedurformHdrDto.getProjekCode(),
				"TRANKAT13", tableMasterProsedurformHdrDto.getCreatedDate());
		TableMasterProsedurformHdr tableMasterProsedurformHdr = new TableMasterProsedurformHdr();
			tableMasterProsedurformHdr =	(TableMasterProsedurformHdr) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformHdr, tableMasterProsedurformHdrDto);
			tableMasterProsedurformHdr.setProsedurId(prosedurId);
			tableMasterProsedurformHdrDao.save(tableMasterProsedurformHdr);
		}
		else {
			TableMasterProsedurformHdr tableMasterProsedurformHdr = new TableMasterProsedurformHdr();
			tableMasterProsedurformHdr =(TableMasterProsedurformHdr) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformHdr, tableMasterProsedurformHdrDto);
			procedureDao.createHistoryTrancsaction(tableMasterProsedurformHdr.getProsedurId(), 
					"FORM13", "TRANKAT13", tableMasterProsedurformHdr.getProjekCode(), "EDIT BY USER","0", tableMasterProsedurformHdr.getUpdatedBy(), 
					tableMasterProsedurformHdr.getUpdatedDate());
			tableMasterProsedurformHdrDao.save(tableMasterProsedurformHdr);
		}
		return prosedurId;
	}

	@Override
	public SlicePaging<TableMasterProsedurformHdrDto> loadAllList(TableMasterProsedurformHdrDto filter,
			String user, String projek, String search, int page, String direction, String orderBy) {
		List<String> idProsedurs = new ArrayList<>();
		List<String> namaProsedurs = new ArrayList<>();
		List<String> menuReferensis = new ArrayList<>();
		List<Integer> jumlahProsedurs = new ArrayList<>();
		List<String> statusPersetujuans = new ArrayList<>();
		List<String> statusProsedurs = new ArrayList<>();
		
		if(direction.equals("")||direction==null) {
			direction = "ASC";
		}
		if(orderBy.equals("")||orderBy==null) {
			orderBy = "(a.prosedurId),(a.prosedurName),(a.totalProsedur),(e.mstCodeTypeName),(d.mstCodeTypeName),(c.menuName),(a.createdDate)";
		}
		
		if(filter.getProsedurIds().size()==0) {
			idProsedurs.add("");
		}
		
		if(filter.getProsedurNames().size()==0) {
			namaProsedurs.add("");
		}
		
		if(filter.getMenuReferensis().size()==0) {
			menuReferensis.add("");
		}
		if(filter.getTotalProsedurs().size()==0) {
			jumlahProsedurs.add(new Integer(-1));
		}
		if(filter.getStatusPersetujuans().size()==0) {
			statusPersetujuans.add("");
		}
		if(filter.getStatusProsedurs().size()==0) {
			statusProsedurs.add("");
		}
		
		
		for(String o : filter.getProsedurIds()) {
			idProsedurs.add(o);
		}
		
	    for(String o : filter.getProsedurNames()) {
			namaProsedurs.add(o);
		}
		
		for(String o : filter.getMenuReferensis()) {
			menuReferensis.add(o);
		}
		
		for(BigDecimal o : filter.getTotalProsedurs()) {
			jumlahProsedurs.add(new Integer(o.intValue()));
		}
		
		for(String o : filter.getStatusPersetujuans()) {
			statusPersetujuans.add(o);
		}
		
		for(String o : filter.getStatusProsedurs()) {
			statusProsedurs.add(o);
		}
		
		Page<Object[]> obj = tableMasterProsedurformHdrDao.getAllExistingData
				(idProsedurs, namaProsedurs, menuReferensis, jumlahProsedurs, statusPersetujuans, statusProsedurs, user, projek, search, createRequestPage(page, direction, orderBy));
		List<TableMasterProsedurformHdrDto> tableMasterProsedurformHdrDtos = new ArrayList<>();
		
		for (Object[] o : obj) {
			List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDtos = new ArrayList<>();
		    TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
		    tableMasterProsedurformHdrDto = (TableMasterProsedurformHdrDto) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformHdrDto, o[0]);
		    tableMasterProsedurformHdrDto.setMenuReferensi((String) o[1]);
		    tableMasterProsedurformHdrDto.setStatusProsedur((String) o[2]);
		    tableMasterProsedurformHdrDto.setStatusPersetujuan((String) o[3]);
		    for (TableMasterProsedurformDtl dtl : tableMasterProsedurformDtlDao.collectAllDetail(projek, tableMasterProsedurformHdrDto.getProsedurId())) {
				TableMasterProsedurformDtlDto dtlDto = new TableMasterProsedurformDtlDto();
				dtlDto = (TableMasterProsedurformDtlDto) mappingClassSvc.mapperEntityToDto(dtlDto, dtl);
				tableMasterProsedurformDtlDtos.add(dtlDto);
			}
		    tableMasterProsedurformHdrDto.setTableMasterProsedurformDtlDtos(tableMasterProsedurformDtlDtos);
		    tableMasterProsedurformHdrDtos.add(tableMasterProsedurformHdrDto);
		}
		
		
		return new SlicePaging<TableMasterProsedurformHdrDto>(tableMasterProsedurformHdrDtos, obj.getTotalElements());
	}

	@Override
	public List<Object> getAllDataFilter(String user, String projek, String filterExec, String search) {
		List<Object[]> listFilter = tableMasterProsedurformHdrDao.getAllFilterList(user, projek, search);
		List<Object> result = new ArrayList<>();
		Set<Object> setFilter = new TreeSet<>();
		for (Object[] o : listFilter) {
		if(filterExec.equalsIgnoreCase("ID PROSEDUR")) {
			setFilter.add(o[0]);
		}
			else if(filterExec.equalsIgnoreCase("NAMA PROSEDUR")) {
				setFilter.add(o[1]);
			}
				else if(filterExec.equalsIgnoreCase("MENU REFERENSI")) {
					setFilter.add(o[2]);
				}
					else if(filterExec.equalsIgnoreCase("JUMLAH PROSEDUR")) {
						setFilter.add(o[3]);
					}
						else if(filterExec.equalsIgnoreCase("STATUS PERSETUJUAN")) {
							setFilter.add(o[5]);
						}
							else if(filterExec.equalsIgnoreCase("STATUS PROSEDUR")) {
								setFilter.add(o[4]);
							}
		}
		
		for (Object object : setFilter) {
			result.add(object);
		}
		return result;
	}

	@Override
	public void send(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto) {
		String reason = "";
		if(tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("APPD")) {
			reason = "PENGIRIMAN UNTUK PERSETUJUAN PELANGGAN MANUAL";
		}
		else if(tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("REJE")) {
			reason = "PENGIRIMAN UNTUK PENOLAKAN PELANGGAN MANUAL";
		}
		else if(tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("REVS")) {
			reason = "PENGIRIMAN UNTUK MELAKUKAN REVISI PELANGGAN MANUAL";
		}
		else if(tableMasterProsedurformHdrDto.getStatusApproval().equalsIgnoreCase("APPR")) {
			reason = "PENGIRIMAN UNTUK APPROVAL PELANGGAN MANUAL";
		}
		
		if(tableMasterProsedurformHdrDto.getMessageId() == null) {
			tableMasterProsedurformHdrDto.setMessageId("");
		}
		
		System.err.println("Message Id : " + tableMasterProsedurformHdrDto.getMessageId());
		System.err.println("Prosedur Id : " + tableMasterProsedurformHdrDto.getProsedurId());
		System.err.println("Form Id : " + "FORM13");
		System.err.println("Menu Id : " + "TRANKAT13");
		System.err.println("Projek Code : " + tableMasterProsedurformHdrDto.getProjekCode());
		System.err.println("reason : " + reason);
		System.err.println("Status Approval : " + tableMasterProsedurformHdrDto.getStatusApproval());
		System.err.println("Updated Oleh : " + tableMasterProsedurformHdrDto.getUpdatedBy());
		System.err.println("Updated Date : " + tableMasterProsedurformHdrDto.getUpdatedDate());
		
		
		
		procedureDao.createApprovalTrancsaction(tableMasterProsedurformHdrDto.getMessageId(), tableMasterProsedurformHdrDto.getProsedurId(), 
				"FORM13", "TRANKAT13", tableMasterProsedurformHdrDto.getProjekCode(), reason, tableMasterProsedurformHdrDto.getStatusApproval(), 
				tableMasterProsedurformHdrDto.getUpdatedBy(), new Date());
	}

	@Override
	public List<TableMasterProsedurformHdrDto> collectInformation(Map<String, Object> mapp) {
		String trxId = (String) mapp.get("trxId");
		String projekCode = (String) mapp.get("projekCode");
		TableMasterProsedurformHdr tableMasterProsedurformHdr = tableMasterProsedurformHdrDao.collectInformation(projekCode, trxId);
		TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto = new TableMasterProsedurformHdrDto();
		tableMasterProsedurformHdrDto = (TableMasterProsedurformHdrDto) mappingClassSvc.mapperEntityToDto(tableMasterProsedurformHdrDto, tableMasterProsedurformHdr);
		List<TableMasterProsedurformDtlDto> tableMasterProsedurformDtlDtos = new ArrayList<>();
		for (TableMasterProsedurformDtl dtl : tableMasterProsedurformDtlDao.collectAllDetail(projekCode, tableMasterProsedurformHdrDto.getProsedurId())) {
			TableMasterProsedurformDtlDto dto = new TableMasterProsedurformDtlDto();
			dto = (TableMasterProsedurformDtlDto) mappingClassSvc.mapperEntityToDto(dto, dtl);
			tableMasterProsedurformDtlDtos.add(dto);
		}
		tableMasterProsedurformHdrDto.setTableMasterProsedurformDtlDtos(tableMasterProsedurformDtlDtos);
		
		List<TableMasterProsedurformHdrDto> tableMasterProsedurformHdrDtos = new ArrayList();
		tableMasterProsedurformHdrDtos.add(tableMasterProsedurformHdrDto);
		return tableMasterProsedurformHdrDtos;
	}

	@Override
	public int delete(TableMasterProsedurformHdrDto tableMasterProsedurformHdrDto) {
		for (TableMasterProsedurformDtlDto str : tableMasterProsedurformHdrDto.getTableMasterProsedurformDtlDtos()) {
			procedureDao.createHistoryTrancsaction(str.getProsedurIdDetail(), 
					"FORM12", "TRANKAT13", tableMasterProsedurformHdrDto.getProjekCode(), "DELETE BY USER","1", tableMasterProsedurformHdrDto.getUpdatedBy(), 
					tableMasterProsedurformHdrDto.getUpdatedDate());
			tableMasterProsedurformDtlDao.deleteUnusedDetail(tableMasterProsedurformHdrDto.getProjekCode(), str.getProsedurId(), str.getProsedurIdDetail());
		}
		procedureDao.createHistoryTrancsaction(tableMasterProsedurformHdrDto.getProsedurId(), 
				"FORM13", "TRANKAT13", tableMasterProsedurformHdrDto.getProjekCode(), "DELETE BY USER","1", tableMasterProsedurformHdrDto.getUpdatedBy(), 
				tableMasterProsedurformHdrDto.getUpdatedDate());
		int i = tableMasterProsedurformHdrDao.deleteHdr(tableMasterProsedurformHdrDto.getProjekCode(), tableMasterProsedurformHdrDto.getProsedurId());
		
		
		return 0;
	}

}
