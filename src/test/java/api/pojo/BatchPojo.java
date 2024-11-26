package api.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
public class BatchPojo {

    @JsonProperty("batchDescription")
    private String batchDescription;
    @JsonProperty("batchName")
    private String batchName;
    @JsonProperty("batchNoOfClasses")
    private String batchNoOfClasses;
    @JsonProperty("batchStatus")
    private String batchStatus;
    @JsonProperty("programId")
    private String programId;
    @JsonProperty("programName")
    private String programName;

    public BatchPojo(String batchName, String batchStatus) {
    }

	public String getBatchDescription() {
		return batchDescription;
	}

	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchNoOfClasses() {
		return batchNoOfClasses;
	}

	public void setBatchNoOfClasses(String batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}

	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
    
}
