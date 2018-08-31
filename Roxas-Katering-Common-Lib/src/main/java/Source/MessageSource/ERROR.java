package Source.MessageSource;

public enum ERROR {
	/*
	 * 
	 */
    E001("Mohon Pilih Gambar Terlebih Dahulu");
	
    private final String message;
	ERROR(String message){
		this.message = message;
	}
	
	public final String getMessage(){
		if(message == null){
			return "Informasi Belum Terdaftar";
		}
		return message;
	}
}
