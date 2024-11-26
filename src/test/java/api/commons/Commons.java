package api.commons;

public class Commons {
	
	private static int programId;
	private static String programName;
	private static int batchId;
	public static int getProgramId() {
		return programId;
	}
	public static void setProgramId(int programId) {
		Commons.programId = programId;
	}
	public static String getProgramName() {
		return programName;
	}
	public static void setProgramName(String programName) {
		Commons.programName = programName;
	}
	public static int getBatchId() {
		return batchId;
	}

	public static void setBatchId(int batchId) {
		Commons.batchId = batchId;
	}
	
}
