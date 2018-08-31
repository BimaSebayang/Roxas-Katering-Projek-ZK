package service.PegawaiSchemaService;

import java.util.List;

import DataTransferObjectLib.PegawaiSchemaDto.TableDataKaryawanDto;

public interface TableDataKaryawanSvc {
      public List<TableDataKaryawanDto> getAllListDataKarywan();
      
      public TableDataKaryawanDto tableDataKaryawanDto(String idKaryawan);
      
      public int save(TableDataKaryawanDto tableDataKaryawanDto);
      
      public int delete(TableDataKaryawanDto tableDataKaryawanDto);
}
