package api.commons;

public class Commons {
	
	private static int programId;
	private static String programName;
	private static float classId = 42;
	private static String classTopic;
		
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
	
	public static float getClassId() {
		return classId;
	}
	public static void setClassId(float classId) {
		Commons.classId = classId;
	}
	
	public static String getClassTopic() {
		return classTopic;
	}
	public static void setClassTopic(String classTopic) {
		Commons.classTopic = classTopic;
	}
	
		
}
