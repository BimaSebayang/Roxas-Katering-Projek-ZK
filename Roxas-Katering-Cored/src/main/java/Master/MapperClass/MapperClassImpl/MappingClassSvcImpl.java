package Master.MapperClass.MapperClassImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import Master.MapperClass.MappingClassSvc;

//created by : Bima S.
@Service("mappingClassSvc")
public class MappingClassSvcImpl implements MappingClassSvc{

	@Override
	public Object mapperEntityToDto(Object dto, Object entity) {
		Class entityClass = entity.getClass();
		Class dtoClass = dto.getClass();

		Method[] entityMethods = entityClass.getMethods();
		Method[] dtoMethods = dtoClass.getMethods();

		for (Method methodDto : dtoMethods) {
			if (methodDto.getName().substring(0, 3).equalsIgnoreCase("set")) {
				for (Method method : entityMethods) {
					if (method.getName().substring(0, 3)
							.equalsIgnoreCase("get")) {
						if (methodDto
								.getName()
								.substring(3)
								.equalsIgnoreCase(method.getName().substring(3))) {
							try {
								methodDto.invoke(dto, method.invoke(entity)); //disini mapping terjadi
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (InvocationTargetException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return dto;
	}

	//ini hanya dipakai untuk keperluan jika map.get(object) tidak bisa dicasting.
	@Override
	public <K, V> Object mapperLinkedHashMapToClass(Map<String, Object> map,
			Object dto, String ObjectParameter) {
		Class dtoClass = dto.getClass();
		Method[] dtoMethods = dtoClass.getMethods();
        Map<String, Object> mapL =  (Map<String, Object>) map.get(ObjectParameter); 
        
        for (Method methodDto : dtoMethods) {
        	if (methodDto.getName().substring(0, 3).equalsIgnoreCase("set")) {
		          for (Entry<String, Object> method : mapL.entrySet()) {
					if(methodDto
							.getName()
							.substring(3)
							.equalsIgnoreCase(method.getKey())){
						try {
							methodDto.invoke(dto, method.getValue());
						} catch (IllegalAccessException
								| IllegalArgumentException
								| InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
        	}
        }
        
		return dto;
	}

}
