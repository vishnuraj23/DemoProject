package Common_PageObjects;


public enum PageObjects_Login {

	 username("txtUserName"), 
	 password("txtPassword"),
	 submitbutton("//span[text()='Submit']"),
	 
	;

	private final String enumValue;
	
	private PageObjects_Login (String s) {
		enumValue =s ;
	}
	
	public String getValue() {
		return enumValue;
	}
	
	public String toString() {
		return getValue();
	}
	
}
