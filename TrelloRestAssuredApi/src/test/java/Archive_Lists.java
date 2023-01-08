import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Archive_Lists {
    static   EnviromentVars env = new EnviromentVars();
    public static void main(String[] args) {
        //Archive_List
        //https://api.trello.com/1/lists/{{ListId}}/closed?key={{APIKEY}}&token={{APIToken}}&value=true
        RestAssured.baseURI = "https://api.trello.com/1/lists/" + "63bb2271f63a8e006ec9a961" + "/closed";
        RequestSpecification archiveList = RestAssured.given();
        archiveList.queryParam("key", env.keys);
        archiveList.queryParam("token", env.tokens);
        archiveList.queryParam("value", true);
        Response putList =  archiveList.put();
        putList.prettyPrint();
        int ArchiiveCode = putList.getStatusCode();
        System.out.println("Status Code for Archiving is " +  ArchiiveCode);
        Assert.assertEquals(ArchiiveCode ,200);

    }
}
