package api.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ClassPojo {
		

	
		private float batchId;
		private String classComments;
		private String classDate;
	    private String classDescription;
	    private float classNo;
	    private String classNotes;
	    private String classRecordingPath;
	    private String classStaffId;
	    private String classTopic;
	    private List<String> classScheduledDates;
  

	public ClassPojo(float batchId, String classComments, String classDate, String classDescription, float classNo,
            String classNotes, String classRecordingPath, String classStaffId, String classTopic,
            List<String> classScheduledDates) {
		this.batchId = batchId;
        this.classComments = classComments;
        this.classDate = classDate;
        this.classDescription = classDescription;
        this.classNo = classNo;
        this.classNotes = classNotes;
        this.classRecordingPath = classRecordingPath;
        this.classStaffId = classStaffId;
        this.classTopic = classTopic;
        this.classScheduledDates = classScheduledDates;
        
	}

	public float getbatchId() {
        return batchId;
    }

    public void setbatchId(float batchId) {
        this.batchId = batchId;
    }

    public String getClassComments() {
        return classComments;
    }

    public void setClassComments(String classComments) {
        this.classComments = classComments;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
       this.classDate = classDate;
    	
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public float getClassNo() {
        return classNo;
    }

    public void setClassNo(float classNo) {
        this.classNo = classNo;
    }

    public String getClassNotes() {
        return classNotes;
    }

    public void setClassNotes(String classNotes) {
        this.classNotes = classNotes;
    }

    public String getClassRecordingPath() {
        return classRecordingPath;
    }

    public void setClassRecordingPath(String classRecordingPath) {
        this.classRecordingPath = classRecordingPath;
    }

    public String getClassStaffId() {
        return classStaffId;
    }

    public void setClassStaffId(String classStaffId) {
        this.classStaffId = classStaffId;
    }

    public String getClassTopic() {
        return classTopic;
    }

    public void setClassTopic(String classTopic) {
        this.classTopic = classTopic;
    }

    public List<String> getClassScheduledDates() {
        return classScheduledDates;
    }

    public void setClassScheduledDates(List<String> classScheduledDates) {
        this.classScheduledDates = classScheduledDates;
    }

    

}