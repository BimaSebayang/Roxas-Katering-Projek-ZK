package Master.DefaultPenulisan.DefaultPenulisanImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import Master.DefaultPenulisan.PenulisanTanggalSvc;

@Service("penulisanTanggalSvc")
public class PenulisanTanggalImpl implements PenulisanTanggalSvc {

	@Override
	public String penulisanTanggal(Date tanggal) {
        String dateString = tanggal.toString();
		
		String[] date = dateString.split(" ");
	
		String[] convertTampilanTanggal = date[0].trim().split("-");
		String tampilanTanggalBaru = convertTampilanTanggal[2]+"/"+
		                             convertTampilanTanggal[1]+"/"+convertTampilanTanggal[0];
		return tampilanTanggalBaru;
	}

	@Override
	public String penulisanJam(Date tanggal) {
        String dateString = tanggal.toString();
		String[] date = dateString.split(" ");
		String tampilanJamBaru = date[1];		
		return tampilanJamBaru;
	}


	@Override
	public String tampilkanHari(Date tanggal) {
		Calendar c = Calendar.getInstance();
		c.setTime(tanggal);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		Map<Integer, String> mapHari = new HashMap<>();
		
		mapHari.put(new Integer(2), "Senin");
		mapHari.put(new Integer(3), "Selasa");
		mapHari.put(new Integer(4), "Rabu");
		mapHari.put(new Integer(5), "Kamis");
		mapHari.put(new Integer(6), "Jumat");
		mapHari.put(new Integer(7), "Sabtu");
		mapHari.put(new Integer(1), "Minggu");
		
		return mapHari.get(new Integer(dayOfWeek));
	}

}
