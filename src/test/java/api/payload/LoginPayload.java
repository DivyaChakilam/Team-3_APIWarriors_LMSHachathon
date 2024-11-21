package api.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import api.Utility.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode methods
//@NoArgsConstructor // Generates a no-arguments constructor
//@AllArgsConstructor // Generates an all-arguments constructor
public class LoginPayload extends CommonUtils {

	 @JsonProperty("userLoginEmailId")
	private String email;
	 @JsonProperty("password")
	  private String password;
	  
	  public LoginPayload() {}
	  
	  public LoginPayload(String email, String password) {
	        this.email = email;
	        this.password = password;
	    }
	// Getters and Setters

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
}
