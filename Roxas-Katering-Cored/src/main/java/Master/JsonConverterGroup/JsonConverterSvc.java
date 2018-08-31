package Master.JsonConverterGroup;

import java.util.List;
import java.util.Map;

public interface JsonConverterSvc {
	public <T> Object getTheResult(Object domainObjectConverter, Class<T> clazz);
	
	public <T> List<T> getArrayListResultJson(Object domainObjectConverter,Class<T> clazz);
	
	public <T, K> Map<T, K> getHashMapResultJson(Object domainObjectConverter);
}
