package service.PegawaiSchemaService;

import java.util.List;

import dto.PegawaiSchemaDto.TablePengenalDto;

public interface TablePengenalSvc {
	public List<TablePengenalDto> getAllPegawai();
        public List<TablePengenalDto> getAllNotDataUser();
}
