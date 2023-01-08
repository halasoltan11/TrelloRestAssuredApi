import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Delete_Board {
    static   EnviromentVars env = new EnviromentVars();
    public static void main(String[] args) {
        //Delete_Board
        //https://api.trello.com/1/boards/{{BoardsId}}?key={{APIKEY}}&token={{APIToken}}
      RestAssured.baseURI = "https://api.trello.com/1/boards/63bb21d7db868a031c1035cc" ;
        RequestSpecification delBoard = RestAssured.given();
        delBoard.queryParam("key", env.keys);
        delBoard.queryParam("token", env.tokens);
        Response Del_response =  delBoard.delete();
        Del_response.prettyPrint();
        int del_BoardCode = Del_response.getStatusCode();
        System.out.println("Status Code is " +  del_BoardCode);
        Assert.assertEquals(del_BoardCode ,200);
    }
}
