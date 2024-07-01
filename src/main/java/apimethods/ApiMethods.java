package apimethods;


import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
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
	static String url = ReadPropertiesFile("baseurl");
	static String FindPetById = ReadPropertiesFile("FindPetById");
	static String addnewpet = ReadPropertiesFile("AddNewPet");

	
	
	public static void setupUrl(String httpmethod) throws InvalidFormatException, IOException {
		
		
		if(httpmethod.equalsIgnoreCase("Get")) {
			response = given().baseUri(url).contentType(ContentType.JSON).log().all().get(FindPetById);
		}
		else if(httpmethod.equalsIgnoreCase("post")) {
			Object body = payload();
			response = given().baseUri(url).body(body).contentType(ContentType.JSON).log().all().post(addnewpet);
		}
	}
	
	public static Object payload() throws NumberFormatException, InvalidFormatException, IOException {
		AddNewPet anp = new AddNewPet();
		category ct = new category();
		tags tg = new tags();
		ct.setId(Double.parseDouble(ReadXLTestData("categoryId")));
		ct.setName(ReadXLTestData("categoryName"));
		tg.setId(Double.parseDouble(ReadXLTestData("tagsId")));
		tg.setName(ReadXLTestData("tagsName"));
		List<String> photourls = new ArrayList<String>();
		photourls.add(ReadXLTestData("photoUrls"));
		
		anp.setId(Double.parseDouble(ReadXLTestData("categoryId")));
		anp.setName(ReadXLTestData("categoryName"));
		anp.setCategory(ct);
		anp.setTags(tg);
		anp.setPhotoUrls(photourls);
		anp.setStatus("available");
		return anp;	
	}
	
	
	public static void ValidateResponse() {
		 response.then().contentType(ContentType.JSON).log().all().assertThat().statusCode(200);
		
	}

}
