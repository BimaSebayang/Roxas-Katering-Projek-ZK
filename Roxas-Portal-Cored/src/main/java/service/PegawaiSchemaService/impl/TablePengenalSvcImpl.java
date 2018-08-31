package service.PegawaiSchemaService.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Master.JsonConverterGroup.JsonConverterSvc;
import Master.MapperClass.MappingClassSvc;
import dao.PegawaiSchemaDao.TablePengenalDao;
import dto.PegawaiSchemaDto.TablePengenalDto;
import service.PegawaiSchemaService.TablePengenalSvc;

@Service("tablePengenalSvc")
@Transactional
public class TablePengenalSvcImpl implements TablePengenalSvc{

	@Autowired
	private TablePengenalDao tablePengenalDao;
	@Autowired
	private MappingClassSvc mappingClassSvc;
    @Autowired
    private JsonConverterSvc jsonConverterSvc;
	
	@Override
	public List<TablePengenalDto> getAllNotDataUser() {
		List<Object[]> objects = tablePengenalDao.getAllInDataUser();
		List<TablePengenalDto> tablePengenalDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TablePengenalDto tablePengenalDto = new  TablePengenalDto();
			tablePengenalDto.setPegawaiId((String) obj[0]);
			tablePengenalDto.setNamaKaryawan((String) obj[1]);
			tablePengenalDto.setStatusKondisi((String) obj[2]);
			tablePengenalDtos.add(tablePengenalDto);
		}
		return tablePengenalDtos;
	}

	@Override
	public List<TablePengenalDto> getAllPegawai() {
		List<Object[]> objects = tablePengenalDao.getAllDataPegawai();
		List<TablePengenalDto> tablePengenalDtos = new ArrayList<>();
		for (Object[] obj : objects) {
			TablePengenalDto tablePengenalDto = new  TablePengenalDto();
			tablePengenalDto.setPegawaiId((String) obj[0]);
			tablePengenalDto.setNamaKaryawan((String) obj[1]);
			tablePengenalDto.setStatusKondisi((String) obj[2]);
			tablePengenalDtos.add(tablePengenalDto);
		}
		return tablePengenalDtos;
	}

}
