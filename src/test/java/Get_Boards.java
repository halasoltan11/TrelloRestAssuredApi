import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Get_Boards {
    static   EnviromentVars env = new EnviromentVars();

    public static void main(String[] args) {
        //Get_boards in an organization:
        //https://api.trello.com/1/"+"organizations/"+ID+"/boards
        RestAssured.baseURI = "https://trello.com/1/boards/xBkMKUrd/";
        RequestSpecification request2 = RestAssured.given();
        request2.header("Content-Type" , "application/json");
        request2.queryParam("key", env.keys);
        request2.queryParam("token", env.tokens);
        Response response2 =  request2.get();
        response2.prettyPrint();
        String statusLine = response2.getStatusLine();
        System.out.println("Status line is " +  statusLine);
        Assert.assertEquals(  statusLine ,"HTTP/1.1 200 OK");
    }
}
