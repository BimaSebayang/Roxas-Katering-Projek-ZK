package RequestMapping.MenuLogin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.MenuSchemaService.TableConfigurationMenuSvc;
import CustomDao.MenuSchemaCustomDao.TableUserCustomDaoSvc;
import dao.MenuSchemaDao.TableMenuDao;
import dao.MenuSchemaDao.TableUserDao;
import dto.MenuSchemaDto.TableConfigurationMenuDto;
import dto.MenuSchemaDto.TableUserDto;

@RestController
@RequestMapping("/login")
public class MenuLoginRequestMapping {
    
	    @Autowired
	    private TableUserDao tableUserDao;
	    @Autowired
	    private TableUserCustomDaoSvc tableUserCustomDaoSvc;
		@Autowired
		private TableMenuDao tableMenuDao;
		@Autowired
		private TableConfigurationMenuSvc tableConfigurationMenuSvc;
		
		@RequestMapping(value = "/test",method= RequestMethod.GET)
		public Map<String,Object> testRestController(){
			Map<String,Object> mapper = new HashMap<>();
				  mapper.put("rightUserId","bimaSS");
				  mapper.put("rightPassword","Pass01.");		
			return mapper;
		}
		
		@RequestMapping(value="/menuLogin", method=RequestMethod.GET)
		public Map<String,Object> menuLogin(){
		    List<TableConfigurationMenuDto> tableConfigurationMenuDtos = tableConfigurationMenuSvc.menuLogin();	
			Map<String, Object> mapper = new HashMap<>();
		   mapper.put("counts", tableConfigurationMenuDtos.size());
		   mapper.put("contents", tableConfigurationMenuDtos);
		   return mapper;
		}
		
		@RequestMapping(value = "/authentication/{userId}",method= RequestMethod.GET)
		public Map<String,Object> loginProcess(
				@PathVariable("userId") String userId){
			Map<String,Object> mapper = tableUserCustomDaoSvc.getTheUserLogin(userId);
			return mapper;
		}
		
		@RequestMapping(value="/userInformation", method=RequestMethod.POST)
		public Map<String,Object> userInformation(
			@RequestBody Map<String, Object> mapp){
			Map<String,Object> mapper = tableUserCustomDaoSvc.loginUser(new String((String) mapp.get("user")), 
					new String((String) mapp.get("password")));
			return mapper;
			
		}
		
		@RequestMapping(value = "/information/authentication/{userId}",method= RequestMethod.GET)
		public Map<String,Object> loginInformation(
				@PathVariable("userId") String userId){
			Map<String,Object> mapper = new HashMap<>();
			TableUserDto tableUserDto = new TableUserDto();
			List<Object[]> obj = tableUserDao.getCurrentUser(userId);
			
			for (Object[] o: obj) {
				tableUserDto.setPegawaiId((String) o[1]);
				tableUserDto.setPegawaiName((String) o[2]);
			}
			
			mapper.put("userInfo", tableUserDto);
			return mapper;
		}
		
}
