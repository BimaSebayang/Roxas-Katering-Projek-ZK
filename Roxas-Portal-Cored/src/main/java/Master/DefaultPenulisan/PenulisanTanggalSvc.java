package Master.DefaultPenulisan;

import java.util.Date;

public interface PenulisanTanggalSvc {
    public String penulisanTanggal(Date tanggal );
    
    public String penulisanJam(Date tanggal);
    
    public String tampilkanHari(Date tanggal);
}
