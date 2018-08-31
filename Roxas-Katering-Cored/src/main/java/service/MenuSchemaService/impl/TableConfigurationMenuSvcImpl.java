package service.MenuSchemaService.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import CustomDao.MenuSchemaCustomDao.TableConfigurationMenuCustomDaoSvc;
import DataTransferObjectLib.MenuSchemaDto.TableButtonDto;
import DataTransferObjectLib.MenuSchemaDto.TableConfigurationMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableMenuDto;
import DataTransferObjectLib.MenuSchemaDto.TableUserDto;
import DataTransferObjectLib.PegawaiSchemaDto.TableJobDto;
import Master.JsonConverterGroup.JsonConverterSvc;
import Master.MapperClass.MappingClassSvc;
import PagingLib.Request.RequestPaging;
import PagingLib.Slice.SlicePaging;
import dao.MenuSchemaDao.TableConfigurationMenuDao;
import entity.MenuSchema.TableButton;
import entity.MenuSchema.TableConfigurationMenu;
import entity.MenuSchema.TableMenu;
import entity.PegawaiSchema.TableJob;
import service.MenuSchemaService.TableConfigurationMenuSvc;

@Service("tableConfigurationMenuSvc")
@Transactional
public class TableConfigurationMenuSvcImpl extends RequestPaging implements TableConfigurationMenuSvc{

	private static final long serialVersionUID = 1L;

	@Autowired
	private TableConfigurationMenuCustomDaoSvc tableConfigurationMenuCustomDaoSvc;
	
	@Autowired
	private TableConfigurationMenuDao tableConfigurationMenuDao;
	
	@Autowired
	private MappingClassSvc mappingClassSvc;
	
    @Autowired
    private JsonConverterSvc jsonConverterSvc;
	
	@Override
	public List<TableConfigurationMenuDto> menuLogin() {
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.menuLogin();
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			TableButtonDto tableButtonDto = new TableButtonDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableMenu tableMenu = (TableMenu) obj[1];
			TableButton tableButton = (TableButton) obj[2];
			
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, tableMenu);
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);

			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDto.setTableButtonDto(tableButtonDto);
			
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
			
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);		
	}

	@Override
	public List<TableConfigurationMenuDto> AllExistingMenuAndButtonForCurrentUser(
			String userId) {
        List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.AllExistingMenuAndButtonForCurrentUser(userId);
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			TableButtonDto tableButtonDto = new TableButtonDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableMenu tableMenu = (TableMenu) obj[1];
			TableButton tableButton = (TableButton) obj[2];
			
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, tableMenu);
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);

			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDto.setTableButtonDto(tableButtonDto);
			
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
			
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}

	
	@Override
	public List<TableConfigurationMenuDto> AllExistingButtonInCurrentUser(
			String userId, String menuCode) {
        List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.AllExistingButtonInCurrentUser(userId, menuCode);
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			TableButtonDto tableButtonDto = new TableButtonDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableMenu tableMenu = (TableMenu) obj[1];
			TableButton tableButton = (TableButton) obj[2];
			
			tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto, tableMenu);
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);

			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDto.setTableButtonDto(tableButtonDto);
			
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
			
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}

	@Override
	public List<TableConfigurationMenuDto> AllNonActiveConfigurationMenu() {
		List<Object[]> listActiveObject = tableConfigurationMenuDao.AllNonActiveConfigurationMenu();
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		for (Object[] obj : listActiveObject) {
			TableConfigurationMenuDto menuDto = new TableConfigurationMenuDto();
			menuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(menuDto, obj[6]);
			menuDto.setNamaKaryawan((String) obj[0]);
			menuDto.setMenuName((String) obj[1]);
			menuDto.setButtonName((String) obj[2]);
			menuDto.setMstCodeTypeName((String) obj[3]);
			menuDto.setCreatedDate((Date) obj[4]);
			menuDto.setCreatedByName((String) obj[5]);
			tableConfigurationMenuDtos.add(menuDto);
		}
		return tableConfigurationMenuDtos;
	}

	@Override
	public List<TableConfigurationMenuDto> AllActiveConfigurationMenu() {
		List<Object[]> listActiveObject = tableConfigurationMenuDao.AllActiveConfigurationMenu();
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		for (Object[] obj : listActiveObject) {
			TableConfigurationMenuDto menuDto = new TableConfigurationMenuDto();
			menuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(menuDto, obj[6]);
			menuDto.setNamaKaryawan((String) obj[0]);
			menuDto.setMenuName((String) obj[1]);
			menuDto.setButtonName((String) obj[2]);
			menuDto.setMstCodeTypeName((String) obj[3]);
			menuDto.setCreatedDate((Date) obj[4]);
			menuDto.setCreatedByName((String) obj[5]);
			tableConfigurationMenuDtos.add(menuDto);
		}
		return tableConfigurationMenuDtos;
	}

	@Override
	public int save(TableConfigurationMenuDto tableConfigurationMenuDto) {
		TableConfigurationMenu tableConfigurationMenu = new TableConfigurationMenu();
		tableConfigurationMenu = (TableConfigurationMenu) mappingClassSvc.mapperEntityToDto(tableConfigurationMenu, tableConfigurationMenuDto);
	    tableConfigurationMenuDao.save(tableConfigurationMenu);
		return 0;
	}

	@Override
	public int activateConfigurationMenu(String updatedBy, Date updatedDate,
			String menuCode, String menuButton, String userId) {
		tableConfigurationMenuDao.activateConfigurationMenu
		(updatedBy, updatedDate, menuCode, menuButton, userId);
		return 0;
	}

	@Override
	public int disactivateConfigurationMenu(String updatedBy, Date updatedDate,
			String menuCode, String menuButton, String userId) {
		tableConfigurationMenuDao.disactivateConfigurationMenu(updatedBy, updatedDate, menuCode, menuButton, userId);
		return 0;
	}

	@Override
	public int deleteConfiguration(String menuCode, String menuButton, String userId) {
		tableConfigurationMenuDao.deleteConfiguration(menuCode, menuButton, userId);
		return 0;
	}


	
	//Start For Projek Katering
	
	@Override
	public List<TableConfigurationMenuDto> AllExistingMenuUserWithBody(
			TableUserDto tableUserDto) {
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();

		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.
				getAllExistingMenuAndButtonInCurrentUserAndProjek(tableUserDto.getUserId(), 
						tableUserDto.getProjekCode());
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			//TableConfigurationMenu a = (TableConfigurationMenu) obj[1];
			TableMenu b = (TableMenu) obj[1];
			//tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto,a);
		    tableMenuDto = (TableMenuDto) mappingClassSvc.mapperEntityToDto(tableMenuDto,b);
			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}
	
	@Override
	public List<TableConfigurationMenuDto> AllExistingMenuUser(String userId) {
List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<Object[]> tableConfigurationMenus = tableConfigurationMenuDao.AllExistingMenuUser(userId);
		for (Object[] obj : tableConfigurationMenus) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableMenuDto tableMenuDto = new TableMenuDto();
			String menuCode = (String) obj[0];
			String menuName = (String) obj[1];
			String menuUrl = (String) obj[2];
			tableMenuDto.setMenuCode(menuCode);
			tableMenuDto.setMenuName(menuName);
			tableMenuDto.setMenuUrl(menuUrl);
			tableConfigurationMenuDto.setTableMenuDto(tableMenuDto);
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
		}
        return jsonConverterSvc.getArrayListResultJson
        		(tableConfigurationMenuDtos,TableConfigurationMenuDto.class);	
	}

	@Override
	public List<TableButtonDto> AllExistingButtonInCurrentUserWithBody(
			TableUserDto tableUserDto, TableMenuDto tableMenuDto) {
		List<TableButtonDto> tableButtonDtos = new ArrayList<>();
		
		List<Object[]> objectList = tableConfigurationMenuDao.
				getAllExistingButtonInCurrentMenuProjekAndUser(tableUserDto.getUserId(), 
						tableUserDto.getProjekCode(), tableMenuDto.getMenuCode());
		
		for (Object[] obj : objectList) {
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) obj[0];
			TableButton tableButton = (TableButton) obj[1];
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto,
					tableConfigurationMenu);
			TableButtonDto tableButtonDto = new TableButtonDto();
			tableButtonDto = (TableButtonDto) mappingClassSvc.mapperEntityToDto(tableButtonDto, tableButton);
		   tableButtonDtos.add(tableButtonDto);
		}
		
		 return tableButtonDtos;	
	}

	@Override
	public SlicePaging<TableConfigurationMenuDto> getIndexOfAllDataInMasterConfigurasiMenu(
			TableConfigurationMenuDto filter, String user, String projek, String search,int page,String direction, String orderBy) {
		if(direction.equals("")||direction==null) {
			direction = "ASC";
		}
		if(orderBy.equals("")||orderBy==null) {
			orderBy = "(d.namaKaryawan),(b.menuName),(c.buttonName),(f.mstCodeTypeName),(a.createdDate)";
		}
		
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		
		List<String> menus = new ArrayList<>();
		List<String> statuss = new ArrayList<>();
		List<String> tombols = new ArrayList<>();
		List<String> karyawans = new ArrayList<>();
		
		if( filter.getNamaMenus().size()==0) {
			menus.add("");
		}
    	if (filter.getStatuss().size()==0) {
			statuss.add("");
		}
		if (filter.getNamaTombols().size()==0) {
			tombols.add("");
		}
    	if(filter.getNamaKaryawans().size()==0) {
			karyawans.add("");
		}
		
			for (String o : filter.getNamaMenus()) {
				menus.add(o);
			}
	    	for (String o : filter.getStatuss()) {
				statuss.add(o);
			}
			for (String o : filter.getNamaTombols()) {
				tombols.add(o);
			}
	    	for (String o : filter.getNamaKaryawans()) {
				karyawans.add(o);
			}
		
		Page<Object[]> getAllData = tableConfigurationMenuDao.
				getAllExistingData(projek, user,menus,statuss,tombols,
						karyawans,"%"+search+"%", createRequestPage(page,direction,orderBy));
		
		for (Object[] o : getAllData) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			TableConfigurationMenu tableConfigurationMenu = (TableConfigurationMenu) o[6];
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.mapperEntityToDto(tableConfigurationMenuDto, tableConfigurationMenu);
			tableConfigurationMenuDto.setMenuName((String) o[0]);
			tableConfigurationMenuDto.setButtonName((String) o[1]);
			tableConfigurationMenuDto.setNamaKaryawan((String) o[2]);
			tableConfigurationMenuDto.setCreatedDate((Date) o[3]);
			tableConfigurationMenuDto.setMstCodeTypeName((String) o[4]);
			TableButtonDto buttonDto = new TableButtonDto();
			buttonDto.setButtonCode(tableConfigurationMenu.getMenuButton());
			buttonDto.setButtonName((String) o[1]);
			tableConfigurationMenuDto.setTableButtonDto(buttonDto);
			tableConfigurationMenuDto.setPegawaiId((String) o[5]);
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
		    }
		
		return new SlicePaging<TableConfigurationMenuDto>(tableConfigurationMenuDtos, getAllData.getTotalElements());
	}

	@Override
	public int saveNew(TableConfigurationMenuDto tableConfigurationMenuDto) {
		TableConfigurationMenu configurationMenu = new TableConfigurationMenu();
		configurationMenu = (TableConfigurationMenu) mappingClassSvc.mapperEntityToDto(configurationMenu, tableConfigurationMenuDto);
		tableConfigurationMenuDao.save(configurationMenu);
		return 0;
	}

	@Override
	public List<Object> getAllDataFilter(String user, String projek, String filterExec,String search) {
		List<Object[]> listFilter=  tableConfigurationMenuDao.getTheFilterList(projek, user,"%"+search+"%");
		Set<Object> setFilter = new TreeSet<>();
		for (Object[] f : listFilter) {
		  if(filterExec.equalsIgnoreCase("NAMA KARYAWAN")){
			  setFilter.add( f[3]);
		  }
			else if(filterExec.equalsIgnoreCase("NAMA MENU")) {
				setFilter.add( f[1]);
			}
				else if(filterExec.equalsIgnoreCase("NAMA TOMBOL")) {
					setFilter.add(f[2]);
				}
					else if(filterExec.equalsIgnoreCase("STATUS")){
						setFilter.add(f[5]);
					}
						else if(filterExec.equalsIgnoreCase("TANGGAL DIBUAT")) {
							setFilter.add( f[4]);
						}
		 }
		
		List<Object>  finalFilter = new ArrayList<>();
		for (Object filter : setFilter) {
			finalFilter.add(filter);
		}
		
		return finalFilter;
	}

	@Override
	public List<TableConfigurationMenuDto> getAllDataAktifDanNonAktif(String user, String projek, String search,
			String status) {
		List<TableConfigurationMenuDto> tableConfigurationMenuDtos = new ArrayList<>();
		List<Object[]> object = tableConfigurationMenuDao.getDataAktifDanNonAktif(status, user, projek, "%"+search+"%");
		for (Object[] ob : object) {
			TableConfigurationMenuDto tableConfigurationMenuDto = new TableConfigurationMenuDto();
			tableConfigurationMenuDto = (TableConfigurationMenuDto) mappingClassSvc.
					                     mapperEntityToDto( tableConfigurationMenuDto , ob[3]);
			tableConfigurationMenuDto.setMenuName((String) ob[0]);
			tableConfigurationMenuDto.setButtonName((String) ob[1]);
			tableConfigurationMenuDto.setNamaKaryawan((String) ob[2]);
			tableConfigurationMenuDtos.add(tableConfigurationMenuDto);
		}
		return tableConfigurationMenuDtos;
	}

	@Override
	public int aktivasiNew(List<TableConfigurationMenuDto> tableConfigurationMenuDtos, String projek, String user) {
		for (TableConfigurationMenuDto dto : tableConfigurationMenuDtos) {
			tableConfigurationMenuDao.activateConfigurationMenu
		    (user, new Date(), dto.getMenuCode(), dto.getMenuButton(), dto.getUserId());
		}
		return 0;
	}

	@Override
	public int nonAktivasiNew(List<TableConfigurationMenuDto> tableConfigurationMenuDtos, String projek, String user) {
		for (TableConfigurationMenuDto dto : tableConfigurationMenuDtos) {
			tableConfigurationMenuDao.disactivateConfigurationMenu
			(user, new Date(), dto.getMenuCode(), dto.getMenuButton(), dto.getUserId());
		}
		return 0;
	}
	
	//End For Projek Katering

}
