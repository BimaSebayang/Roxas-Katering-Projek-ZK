package Master.MapperClass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public interface MappingClassSvc {
	public Object mapperEntityToDto(Object dto, Object entity);
	
	public <K, V> Object mapperLinkedHashMapToClass( Map<String, Object> mapper , Object dto, 
			String ObjectParameter);
}
