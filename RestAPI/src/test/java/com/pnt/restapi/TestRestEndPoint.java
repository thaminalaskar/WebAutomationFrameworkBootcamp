package com.pnt.restapi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class TestRestEndPoint {



    /*   There are following public apis
#	        Route	Method	Type	Full route	Description	Details
            1	/employee	GET	JSON	http://dummy.restapiexample.com/api/v1/employees	Get all employee data	Details
            2	/employee/{id}	GET	JSON	http://dummy.restapiexample.com/api/v1/employee/1	Get a single employee data	Details
            3	/create	POST	JSON	http://dummy.restapiexample.com/api/v1/create	Create new record in database	Details
            4	/update/{id}	PUT	JSON	http://dummy.restapiexample.com/api/v1/update/21	Update an employee record	Details
            5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/delete/2	Delete an employee record	Details
*/

    private String baseURL = RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/";
    private String employeesEndPoint = "employess";
    private String firstEmployeeEndpoint = "employee/1";
    private String creatingNewRecordEndpoint = "create";
    private String updateRecordEndPoint = "update/21";
    private String deleteRecordEndpoint = "delete/2";

    @Test
    public void getAllEmployeeData(){
        Response response = RestAssured.given().get(employeesEndPoint).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void getSingleEmployeeData(){
        Response response = RestAssured.given().get(firstEmployeeEndpoint).then().assertThat().statusCode(429).extract().response();
        System.out.println(response.asString());
    }

    @Test
    public void createNewRecord(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Name", "Jennifer");
        jsonObject.put("Age", "29");
        jsonObject.put("Salary", "75000");
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject).when().post(creatingNewRecordEndpoint).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
    }

    @Test
    public void updateRecord(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Jennifer");
        Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonObject).when().put(updateRecordEndPoint).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());
    }

    @Test
    public void deleteRecord(){
        Response response = RestAssured.given().when().delete(deleteRecordEndpoint).then().assertThat().statusCode(200).extract().response();
        System.out.println(response.asString());

    }
















}
