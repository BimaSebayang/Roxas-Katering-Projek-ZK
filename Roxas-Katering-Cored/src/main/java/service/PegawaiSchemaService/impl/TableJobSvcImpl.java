	package service.PegawaiSchemaService.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DataTransferObjectLib.PegawaiSchemaDto.TableJobDto;
import Master.JsonConverterGroup.JsonConverterSvc;
import Master.MapperClass.MappingClassSvc;
import service.PegawaiSchemaService.TableJobSvc;
import dao.PegawaiSchemaDao.TableJobDao;
import entity.PegawaiSchema.TableJob;

@Service("tableJobSvc")
@Transactional
public class TableJobSvcImpl  implements TableJobSvc {
      
	@Autowired 
    private TableJobDao tableJobDao;
    
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
    @Autowired
    private JsonConverterSvc jsonConverterSvc;
    
	@Override
	public List<TableJobDto> findAllJobDesc() {
		List<TableJobDto> tableJobDtos = new ArrayList<>();
		
		List<TableJob> tableJobs = tableJobDao.findAll();
		
		for (TableJob tableJob : tableJobs) {
			TableJobDto tableJobDto = new TableJobDto();
			tableJobDto = (TableJobDto) mappingClassSvc.mapperEntityToDto(tableJobDto, tableJob);
			tableJobDtos.add(tableJobDto);
		}
		
		return tableJobDtos;
	}

	@Override
	public List<TableJobDto> findAllJobDescJson() {
	List<TableJobDto> tableJobDtos = new ArrayList<>();
		
		List<TableJob> tableJobs = tableJobDao.findAll();
		for (TableJob tableJob : tableJobs) {
			TableJobDto tableJobDto = new TableJobDto();
			tableJobDto = (TableJobDto) mappingClassSvc.mapperEntityToDto(tableJobDto, tableJob);
			tableJobDtos.add(tableJobDto);
		}
		
        return jsonConverterSvc.getArrayListResultJson(tableJobDtos,TableJobDto.class);		
	}
      
      
}
