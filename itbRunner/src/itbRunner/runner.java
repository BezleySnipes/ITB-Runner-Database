package itbRunner;

public class runner {

	private String runnerName;
	private String runnerCat;
	private int runnerAge;

	RunnerQueries runnerDb = new RunnerQueries();

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

	public void remove(String runnerName) {
		try {
			runnerDb.remove(runnerName);
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

	public void update(String runnerName, String runnerCat) {
		try {
			runnerDb.update(runnerName, runnerCat);
		} catch (Exception a) {
			// TODO: handle exception
			a.printStackTrace();
		}
	}

	public void showAll() {
		try {
			runnerDb.showAll();
		} catch (Exception a) {
			// TODO: handle exception
			a.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return runnerName + " , " + runnerAge + " , " + runnerCat + ".";
	}

	public String getRunnerName() {
		return runnerName;
	}

	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
	}

	public String getRunnerCat() {
		return runnerCat;
	}

	public void setRunnerCat(String runnerCat) {
		this.runnerCat = runnerCat;
	}

	public int getRunnerAge() {
		return runnerAge;
	}

	public void setRunnerAge(int runnerAge) {
		this.runnerAge = runnerAge;
	}

}