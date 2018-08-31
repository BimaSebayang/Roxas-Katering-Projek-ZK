package Source.LocaleSource;

/**
 * Memanggil Semua Variable Static Yang Dapat Dipakai Berulang Kali
 * V1.1
 */
public enum LOCALE {
	// local variable untuk projek katering --start

	/**
	 * Memanggil Variable "Master"
	 */
	L001("Master"),
	/**
	 * Memanggil Variable "Transaksi"
	 */
	L002("Transaksi"),
	/**
	 * Memanggil Variable "Order"
	 */
	L003("Order"),
	/**
	 * Memanggil Variable "Regristrasi"
	 */
	L004("Regristrasi"),
	/**
	 * Memanggil Variable "Akunting"
	 */
	L005("Akunting"),
	/**
	 * Memanggil Variable "Image Map"
	 */
	L006("ImageMap"),
	/**
	 * Memanggil Variable "Tambah"
	 */
	L007("TAMBAH"),
	/**
	 * Memanggil Variable "Hapus"
	 */
	L008("HAPUS"), 
	/**
	 * Memanggil Variable "Aktivasi"
	 */
	L009("AKTIVASI"),
	/**
	 * Memanggil Variable "Non-Aktivasi"
	 */
	L010("NON AKTIVASI"),
	/**
	 * Memanggil Variable "LIHAT"
	 */
	L011("LIHAT"), 
	/**
	 * Memanggil Variable "EDIT"
	 */
	L012("EDIT"),
	/**
	 * Memanggil Variable "jpg"
	 */
	L013("jpg"),
	/**
	 * Memanggil Variable "pdf"
	 */
	L014("pdf"),
    
	/**
	 * Memanggil semua cool icon
	 */
	L015("/Cool Icon Picture");
	
	// local variable untuk projek katering --end
	private final String message;

	LOCALE(String message) {
		this.message = message;
	}

	public final String getMessage() {
		if (message == null) {
			return "Informasi Belum Terdaftar";
		}
		return message;
	}
}
