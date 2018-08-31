package service.PegawaiSchemaService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Master.MapperClass.MappingClassSvc;
import dao.PegawaiSchemaDao.TableDataKaryawanDao;
import dao.PegawaiSchemaDao.TablePengenalDao;
import dto.PegawaiSchemaDto.TableDataKaryawanDto;
import entity.PegawaiSchema.TableDataKaryawan;
import entity.PegawaiSchema.TablePengenal;
import service.GenerateAutoId.GenAutoSvc;
import service.PegawaiSchemaService.TableDataKaryawanSvc;

@Service("tableDataKaryawanSvc")
@Transactional
public class TableDataKaryawanSvcImpl implements TableDataKaryawanSvc{

	@Autowired
	private TableDataKaryawanDao tableDataKaryawanDao;
	
	@Autowired
	private TablePengenalDao tablePengenalDao;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
	@Autowired
	private GenAutoSvc genAutoSvc;
	
	@Override
	public List<TableDataKaryawanDto> getAllListDataKarywan() {
		List<Object[]> objects = tableDataKaryawanDao.allListPegawai();
		List<TableDataKaryawanDto> tableDataKaryawanDtos = new ArrayList<>();
		for (Object[] obj: objects) {
			TableDataKaryawanDto tableDataKaryawanDto = new TableDataKaryawanDto();
			tableDataKaryawanDto.setId((String) obj[0]);
			tableDataKaryawanDto.setNamaKaryawan((String) obj[1]);
			tableDataKaryawanDto.setCreatedDate((Date) obj[2]);
			tableDataKaryawanDto.setCreatedByName(tableDataKaryawanDao.getNamaKaryawanFromCurrentId((String) obj[3]));
		    tableDataKaryawanDto.setCreatedBy((String) obj[3]);
			tableDataKaryawanDto.setUpdatedDate((Date) obj[4]);
		    tableDataKaryawanDto.setUpdatedByName(tableDataKaryawanDao.getNamaKaryawanFromCurrentId((String) obj[5]));
		    tableDataKaryawanDto.setJobDesk((String) obj[6]);
		    tableDataKaryawanDto.setRoleDescription((String) obj[7]);
		    tableDataKaryawanDto.setJenisKelaminDescription((String) obj[9]);
		    tableDataKaryawanDto.setStatusName((String) obj[8]);
		    tableDataKaryawanDto.setPhoto((String) obj[10]);
		    tableDataKaryawanDto.setBerkasUpload((String) obj[11]);
		    tableDataKaryawanDtos.add(tableDataKaryawanDto);
		}
		return tableDataKaryawanDtos;
	}

	@Override
	public int save(TableDataKaryawanDto tableDataKaryawanDto) {
		TableDataKaryawan tableDataKaryawan = new TableDataKaryawan(); 
		tableDataKaryawan = (TableDataKaryawan) 
		mappingClassSvc.mapperEntityToDto(tableDataKaryawan, tableDataKaryawanDto);
		if(tableDataKaryawanDto.getId() == null){
			tableDataKaryawan.setPegawaiId(genAutoSvc.generateAutoIdForCurrentTable("TABLE_DATA_KARYAWAN", 
					"EMP", 4));
		}
		else{
			tableDataKaryawan.setPegawaiId(tableDataKaryawanDto.getId());
		}
		tableDataKaryawanDao.save(tableDataKaryawan);
		TablePengenal tablePengenal = new TablePengenal();
		tablePengenal.setPegawaiId(tableDataKaryawan.getPegawaiId());
		tablePengenal.setJid(tableDataKaryawanDto.getJobId());
		tablePengenal.setRoleId(tableDataKaryawanDto.getRoleId());
		tablePengenal.setStatus(1);
		tablePengenalDao.save(tablePengenal);
		return 0;
	}

	@Override
	public TableDataKaryawanDto tableDataKaryawanDto(String idKaryawan) {
		List<Object[]> objects = tableDataKaryawanDao.allInformationPegawai(idKaryawan);
		TableDataKaryawanDto tableDataKaryawanDto = new TableDataKaryawanDto();
		for (Object[] obj : objects) {
			TableDataKaryawan tableDataKaryawan = (TableDataKaryawan) obj[0];
			tableDataKaryawanDto = (TableDataKaryawanDto) mappingClassSvc.mapperEntityToDto(tableDataKaryawanDto,tableDataKaryawan);
			tableDataKaryawanDto.setId(tableDataKaryawan.getPegawaiId());
			tableDataKaryawanDto.setRoleDescription((String) obj[1]);
			tableDataKaryawanDto.setRoleId((String) obj[2]);
			tableDataKaryawanDto.setJobDesk((String) obj[3]);
			tableDataKaryawanDto.setJobId((String) obj[4]);
		}
		return tableDataKaryawanDto;
	}

	@Override
	public int delete(TableDataKaryawanDto tableDataKaryawanDto) {
		tableDataKaryawanDao.deleteKaryawan(tableDataKaryawanDto.getId());
        tablePengenalDao.deletePengenal(tableDataKaryawanDto.getId());
		return 0;
	}

}
