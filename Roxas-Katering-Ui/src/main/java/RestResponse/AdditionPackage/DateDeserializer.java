package RestResponse.AdditionPackage;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer implements JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		  String date = json.getAsString();
          Date dateParse = new Date(Long.valueOf(date));
	      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss.SSS'Z'");
	      format.setTimeZone(TimeZone.getTimeZone("GMT"));
	      
	      return dateParse;
	}

}
