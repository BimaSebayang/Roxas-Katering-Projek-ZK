package Source.MessageSource;

public enum INFORMATION {
	/**
	 * Tombol Belum Tersedia
	 */
    I001("Tombol Belum Tersedia"),
	/**
	 * Masih Ingin Menyimpan Data Baru ?
	 */
	I002("Masih Ingin Menyimpan Data Baru ?"),
	/**
	 * Formulir Tidak Dapat Dibuka atau Belum Tersedia
	 */
	I003("Formulir Tidak Dapat Dibuka");
	
    private final String message;
	INFORMATION(String message){
		this.message = message;
	}
	
	public final String getMessage(){
		if(message == null){
			return "Informasi Belum Terdaftar";
		}
		return message;
	}
}
