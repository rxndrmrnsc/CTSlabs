package ro.ase.csie.cts.gr1098.design.patterns.singleton;

public class DBConnection {
	
	private static DBConnection connection;
	
	String ipAddress;
	String userName;
	String userPass;
	
	private DBConnection() {}
	
	private DBConnection(String ipAddress, String userName, String userPass) {
		super();
		this.ipAddress = ipAddress;
		this.userName = userName;
		this.userPass = userPass;
	}

	public static synchronized DBConnection getInstance() {
		if(connection == null) {
			connection = new DBConnection();
		}
		return connection;
	}
}
