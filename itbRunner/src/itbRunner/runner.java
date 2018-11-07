package itbRunner;

public class runner {
	private String runnerName;
	private String runnerCat;
	private int runnerAge;

	Database runnerDb = new Database();

	// no parameters constructor
	public runner() {
		runnerName = "Not Running";
		runnerAge = 00;
		runnerCat = "Null";
	}

	// custom constructor
	public runner(String rName, int rAge, String rCat) {
		runnerName = rName;
		runnerCat = rCat;
		runnerAge = rAge;
	}

	public void remove(int runnerID) {
		try {
			runnerDb.remove(runnerID);
			;
		} catch (Exception a) {
			// TODO: handle exception
			a.printStackTrace();
		}
	}

	public void add(String runnerName, int runnerAge, String runnerCat) {
		try {
			runnerDb.insert(runnerName, runnerAge, runnerCat);
		} catch (Exception a) {
			// TODO: handle exception
			a.printStackTrace();
		}

	}
	
	public void update(int runnerId, String runnerCat) {
		try {
			runnerDb.update(runnerId, runnerCat);
		} catch (Exception a) {
			// TODO: handle exception
			a.printStackTrace();
		}

	}
}