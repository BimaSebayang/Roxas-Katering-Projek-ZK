package Source.LabelSource;

public enum LABEL {
    L001("NAMA KARYAWAN"),
	L002("NAMA MENU"),
	L003("NAMA TOMBOL"),
	L004("STATUS"),
	L005("TANGGAL PEMBUATAN");
	;
	
    public final String message;
	LABEL(String message){
		this.message = message;
	}
	
	public final String getMessage(){
		if(message == null){
			return "INVALID LABEL";
		}
		return message;
	}
}
