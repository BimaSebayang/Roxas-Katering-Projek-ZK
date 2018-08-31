package Source.ConstraintSource;

public enum CONSTRAINT {
	 C001("");
		
	    private final String message;
	    CONSTRAINT(String message){
			this.message = message;
		}
		
		public final String getMessage(){
			if(message == null){
				return "INVALID LABEL";
			}
			return message;
		}
}
