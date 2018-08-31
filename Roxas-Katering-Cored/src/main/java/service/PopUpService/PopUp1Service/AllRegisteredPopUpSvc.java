package service.PopUpService.PopUp1Service;

import java.util.List;
import java.util.Map;

import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;

public interface AllRegisteredPopUpSvc {
    public List<TableUserDto> getAllUserTableDto(Map<String,Object> mapp, String search, String projekCode);
    public List<TableMenuDto> getAllMenuDto(Map<String,Object> mapp, String search, String projekCode);
    public List<TableButtonDto> getAllButtonDto(Map<String,Object> mapp, String search, String projekCode);
}
