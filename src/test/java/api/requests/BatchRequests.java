package api.requests;

import api.Utility.CommonUtils;
import api.Utility.TokenManager;
import api.commons.Commons;
import api.payload.BatchPayload;
import api.pojo.BatchPojo;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BatchRequests extends CommonUtils {
    private RequestSpecification requestSpec;
    private List<Map<String, String>> excelData;
    private Map<String, String> currentRow;
    private BatchPojo batch;
    private Response response;

    private static final String INVALID_Batch_ID = "405";
    private static final String INVALID_TOKEN = "njbsjkbfk";


    public RequestSpecification setAuth(){
        RestAssured.baseURI = endpoints.getString("baseUrl");
        return given()
                .header("Authorization", "Bearer " + TokenManager.getToken());
    }

    public void createBatch(String scenario)
        throws IOException, InvalidFormatException, ParseException{

        Map<String, Object> batchDetails =new BatchPayload().getDataFromExcel(scenario);
        if(batchDetails !=null) {
           if(batchDetails.get("batch") !=null) {
            this.batch = (BatchPojo)  batchDetails.get("batch");
        }
        if(batchDetails.get("currentRow") !=null) {
            this.currentRow = (Map<String, String>) batchDetails.get("currentRow");
        }
        }
    }
    public RequestSpecification buildRequest(RequestSpecification requestSpec){

        if (requestSpec ==null) {
            throw new IllegalStateException("RequestSpecification is not initialized.");

        }
        return requestSpec.contentType(currentRow.get("ContentType")).body(batch);
    }
    public Response sendRequest(RequestSpecification requestSpec) {

        String endpoint = currentRow.get("EndPoint");
        response = CommonUtils.getResponse(requestSpec,endpoint);

        int batchId = response.jsonPath().getInt("batchId");
        Commons.setBatchId(batchId);
        return response;
    }

    public int getStatusCode() {
        String expectedStatusCodeString = currentRow.get("StatusCode");
        int expectedStatusCode = (int) Double.parseDouble(expectedStatusCodeString); // Convert "201.0" to 201
        return expectedStatusCode;
    }

    public Response senddeleteRequest(RequestSpecification requestSpec,String deleteEndpoint) {

        String endpoint = currentRow.get("EndPoint");


        if (deleteEndpoint.contains("Id")) {
            endpoint += currentRow.get("ScenarioName").equalsIgnoreCase("PutInvalidProgramId")
                    ? INVALID_Batch_ID
                    : 8750;//Commons.getProgramId();

        }
        response = CommonUtils.getResponse(requestSpec,endpoint);
        return response;
    }



}
