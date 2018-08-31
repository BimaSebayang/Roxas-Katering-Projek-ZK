package service.PegawaiSchemaService;

import java.util.List;

import dto.PegawaiSchemaDto.TableJobDto;
import entity.PegawaiSchema.TableJob;

public interface TableJobSvc {
   public List<TableJobDto> findAllJobDesc();
   
   public List<TableJobDto> findAllJobDescJson();
}
