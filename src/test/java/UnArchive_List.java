import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class UnArchive_List {
    static   EnviromentVars env = new EnviromentVars();
    public static void main(String[] args) {
        //UnArchive_List
        //https://api.trello.com/1/lists/{{ListId}}/closed?key={{APIKEY}}&token={{APIToken}}&value=false
       RestAssured.baseURI = "https://api.trello.com/1/lists/" + "63bb2271f63a8e006ec9a961" + "/closed";
        RequestSpecification unarchiveList = RestAssured.given();
        // requestList.header("Content-Type" , "application/json");
        unarchiveList.queryParam("key", env.keys);
        unarchiveList.queryParam("token", env.tokens);
        unarchiveList.queryParam("value", false);
        Response putList1 =  unarchiveList.put();
        putList1.prettyPrint();
        int unArchiiveCode = putList1.getStatusCode();
        System.out.println("Status Code is " +  unArchiiveCode);
        Assert.assertEquals(unArchiiveCode ,200);
    }
}
