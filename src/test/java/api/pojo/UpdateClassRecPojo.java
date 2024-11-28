package api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import api.commons.Commons;

public class UpdateClassRecPojo {
	@JsonProperty("classRecordingPath")
    private String classRecordingPath;
	@JsonProperty("csId")
    private float csId;
   
	public UpdateClassRecPojo(String classRecordingPath, float csId) {
		this.classRecordingPath = classRecordingPath;
	    this.csId = csId;    
	}
	
	
	public String getClassRecordingPath() {
	    return classRecordingPath;
	}
	
	public void setClassRecordingPath(String classRecordingPath) {
	    this.classRecordingPath = classRecordingPath;
	}
	
	public float getcsId() {
	    return csId;
	}
	
	public void setcsId(float csId) {
	    this.csId = Commons.getClassId();
	}



}
