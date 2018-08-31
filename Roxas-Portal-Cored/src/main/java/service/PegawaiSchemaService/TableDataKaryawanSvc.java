package service.PegawaiSchemaService;

import java.util.List;

import dto.PegawaiSchemaDto.TableDataKaryawanDto;

public interface TableDataKaryawanSvc {
      public List<TableDataKaryawanDto> getAllListDataKarywan();
      
      public TableDataKaryawanDto tableDataKaryawanDto(String idKaryawan);
      
      public int save(TableDataKaryawanDto tableDataKaryawanDto);
      
      public int delete(TableDataKaryawanDto tableDataKaryawanDto);
}
