package service.MenuSchemaService.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import DataTransferObjectLib.MasterSchemaDto.TableMasterMenuMasakanDto;
import Master.MapperClass.MappingClassSvc;
import PagingLib.Request.RequestPaging;
import PagingLib.Slice.SlicePaging;
import dao.MasterSchemaDao.TableMasterMenuMasakanDao;
import service.MenuSchemaService.TableMasterMenuMasakanSvc;

@Service("tableMasterMenuMasakanSvc")
@Transactional
public class TableMasterMenuMasakanSvcImpl extends RequestPaging implements TableMasterMenuMasakanSvc {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TableMasterMenuMasakanDao tableMasterMenuMasakanDao;

	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	@Override
	public SlicePaging<TableMasterMenuMasakanDto> loadAllList(TableMasterMenuMasakanDto filter, String user,
			String projek, String search, int page, String direction, String orderBy) {
		List<String> kodeMakanans = new ArrayList<>();
		List<String> namaMakanans = new ArrayList<>();
		List<String> kodeReseps  = new ArrayList<>();
		List<String> statusMakanans = new ArrayList<>();
		List<String> statusPersetujuans = new ArrayList<>();
		
		if(direction.equals("")||direction==null) {
			direction = "ASC";
		}
		if(orderBy.equals("")||orderBy==null) {
			orderBy = "(a.kodeMakanan),(a.namaMakanan),(a.kodeResep),(b.mstCodeTypeName),(c.mstCodeTypeName),(a.createdDate)";
		}
		
		if(filter.getKodeMakanans().size()==0) {
			kodeMakanans.add("");
		}
		if(filter.getNamaMakanans().size()==0) {
			namaMakanans.add("");
		}
		if(filter.getKodeReseps().size()==0) {
			kodeReseps.add("");
		}
		if(filter.getStatusMakanans().size()==0) {
			statusMakanans.add("");
		}
		if(filter.getStatusPersetujuans().size()==0) {
			statusPersetujuans.add("");
		}
		
		for(String o : filter.getKodeMakanans()) {
			kodeMakanans.add(o);
		}
		for(String o : filter.getNamaMakanans()) {
			namaMakanans.add(o);
		}
		for(String o : filter.getKodeReseps()) {
			kodeReseps.add(o);
		}
		for(String o : filter.getStatusMakanans()) {
			statusMakanans.add(o);
		}
		for(String o : filter.getStatusPersetujuans()) {
			statusPersetujuans.add(o);
		}
		
		Page<Object[]> obj = tableMasterMenuMasakanDao.getAllExistingData
				(kodeMakanans, namaMakanans, kodeReseps, statusMakanans, statusPersetujuans, user, projek, search, createRequestPage(page, direction, orderBy));
		List<TableMasterMenuMasakanDto> tableMasterMenuMasakanDtos = new ArrayList<>();
		for (Object[] o : obj) {
			TableMasterMenuMasakanDto tableMasterMenuMasakanDto = new TableMasterMenuMasakanDto();
			tableMasterMenuMasakanDto = (TableMasterMenuMasakanDto) mappingClassSvc.mapperEntityToDto(tableMasterMenuMasakanDto, o[0]);
			tableMasterMenuMasakanDto.setStatusMakanan((String) o[1]);
			tableMasterMenuMasakanDto.setStatusPersetujuan((String) o[2]);
			tableMasterMenuMasakanDtos.add(tableMasterMenuMasakanDto);
		}
		return new SlicePaging<TableMasterMenuMasakanDto>(tableMasterMenuMasakanDtos, obj.getTotalElements());
	}

	@Override
	public List<Object> getAllDataFilter(String user, String projek, String filterExec, String search) {
		List<Object[]> listFilter =tableMasterMenuMasakanDao.getTheFilterList(user, projek, search);
		List<Object> result = new ArrayList<>();
		Set<Object> setFilter = new TreeSet<>();
		for (Object[] o : listFilter) {
		if(filterExec.equalsIgnoreCase("KODE MENU")) {
			setFilter.add(o[0]);
		}
			else if(filterExec.equalsIgnoreCase("NAMA MENU")) {
				setFilter.add(o[1]);
			}
				else if(filterExec.equalsIgnoreCase("KODE RESEP")) {
					setFilter.add(o[2]);
				}
					else if(filterExec.equalsIgnoreCase("STATUS MENU")) {
						setFilter.add(o[3]);
					}
						else if(filterExec.equalsIgnoreCase("STATUS PERSETUJUAN")) {
							setFilter.add(o[5]);
						}
		}
		
		for (Object object : setFilter) {
			result.add(object);
		}
		return result;
	}

}
