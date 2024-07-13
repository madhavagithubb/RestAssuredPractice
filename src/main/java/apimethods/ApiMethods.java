package apimethods;


import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import Pojoclasses.AddNewPet;
import Pojoclasses.category;
import Pojoclasses.tags;
import Utility.ApiUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ApiMethods extends ApiUtility{
	private static HttpRequest request;
	private static Response response;
	static String petstoreurl = ReadPropertiesFile("petstorebaseurl");
	static String reqresbaseurl = ReadPropertiesFile("reqresbaseurl");
	static String FindPetById = ReadPropertiesFile("FindPetById");
	static String addnewpet = ReadPropertiesFile("AddNewPet");
	static String createUser = ReadPropertiesFile("createUser");
	static String UpdateUser = ReadPropertiesFile("UpdateUser");

	
	
	public static void setupUrl(String httpmethod) throws InvalidFormatException, IOException {
		
		
		if(httpmethod.equalsIgnoreCase("Get")) {
			response = given().baseUri(petstoreurl).contentType(ContentType.JSON).log().all().get(FindPetById);
		}
		else if(httpmethod.equalsIgnoreCase("Post")) {
			Object body = payload();
			response = given().baseUri(reqresbaseurl).body(body).contentType(ContentType.JSON).log().all().post(createUser);
		}
		else if(httpmethod.equalsIgnoreCase("Put")) {
			Object body = payload();
			response = given().baseUri(reqresbaseurl).body(body).contentType(ContentType.JSON).log().all().put(UpdateUser);
		}
	}
	
	public static Object payload() throws NumberFormatException, InvalidFormatException, IOException {
//		AddNewPet anp = new AddNewPet();
//		category ct = new category();
//		tags tg = new tags();
//		ct.setId(Double.parseDouble(ReadXLTestData("categoryId")));
//		ct.setName(ReadXLTestData("categoryName"));
//		tg.setId(Double.parseDouble(ReadXLTestData("tagsId")));
//		tg.setName(ReadXLTestData("tagsName"));
//		List<String> photourls = new ArrayList<String>();
//		photourls.add(ReadXLTestData("photoUrls"));
//		anp.setId(Double.parseDouble(ReadXLTestData("categoryId")));
//		anp.setName(ReadXLTestData("categoryName"));
//		anp.setCategory(ct);
//		anp.setTags(tg);
//		anp.setPhotoUrls(photourls);
//		anp.setStatus("available");
//		return anp;	
		
		HashMap hm = new HashMap();
		hm.put("name", "morpheus");
		hm.put("job", "leader");
		return hm;
	}
	
	
	public static void ValidateResponse() {
		 response.then().contentType(ContentType.JSON).log().all().assertThat().statusCode(200);
		
	}
	
	public static void ValidateResponse(int code) {
		 response.then().contentType(ContentType.JSON).log().all().assertThat().statusCode(code);
		
	}

}
