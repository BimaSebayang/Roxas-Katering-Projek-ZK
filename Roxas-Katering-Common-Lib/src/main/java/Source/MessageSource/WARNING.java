package Source.MessageSource;

public enum WARNING {
	/**
	 * "Mohon Pilih Anotasi Terlebih Dahulu"
	 */
    W001("Mohon Pilih Anotasi Terlebih Dahulu"),
	/**
	 * "Mohon Set Picture Terlebih dahulu"
	 */
    W002("Mohon Set Picture Terlebih dahulu"),
	/**
	 * "Mohon Pilih Picture/Gambar"
	 */
    W003("Mohon Pilih Picture/Gambar"),
	/**
	 * "Mohon Pilih Picture/Gambar"
	 */
    W004("Mohon Pilih Data Terlebih Dahulu"),
    /**
	 * "Hanya Data Dengan Status Aktif Dan Transaksi Masih Berlangsung Yang Dapat Di Edit"
	 */
    W005("Hanya Data Dengan Status  Transaksi Revisi atau Masih Berlangsung Yang Dapat Di Edit"),
    /**
	 * "Hanya Data Dengan Status Aktif Dan Transaksi Masih Berlangsung Yang Dapat Di Kirim"
	 */
    W006("Hanya Data Dengan Status Transaksi Masih Berlangsung Yang Dapat Di Kirim"),
    /**
	 * "Hanya Data Dengan Status Aktif Dan Transaksi Masih Berlangsung Yang Dapat Di Hapus"
	 */
    W007("Hanya Data Dengan Status Transaksi Ditolak atau  Masih Berlangsung Yang Dapat Di Hapus");
	
    private final String message;
	WARNING(String message){
		this.message = message;
	}
	
	public final String getMessage(){
		if(message == null){
			return "Informasi Belum Terdaftar";
		}
		return message;
	}
}
