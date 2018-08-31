package Master.CommonLibrary;

public interface TypeCheckerSvc {
    
	public boolean convertToNumeric(String strCheck);
	public boolean isNumeric(String strCheck);
	public boolean isNumber(String strCheck);
	public boolean thereIsNumber(String strCheck);
	public boolean thereIsSpecialCharacter(String strCheck);
}
