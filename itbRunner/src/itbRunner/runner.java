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