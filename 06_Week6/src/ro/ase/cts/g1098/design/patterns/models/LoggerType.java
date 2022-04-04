package ro.ase.cts.g1098.design.patterns.models;

public enum LoggerType {

	ERROR("errors.log", "*Error*"), INFO("info.log", "<<Info>>");
	
	
	private String filename;
	private String logPattern;
	private LoggerType(String filename, String logPattern) {
		this.filename = filename;
		this.logPattern = logPattern;
	}
	public String getFilename() {
		return filename;
	}
	public String getLogPattern() {
		return logPattern;
	}
	
	
	
}
