import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Create_And_Get_List {
    static   EnviromentVars env = new EnviromentVars();
    public static void main(String[] args) {
        RestAssured.baseURI = "https://api.trello.com/1/lists/";
        RequestSpecification requestList = RestAssured.given();
        requestList.header("Content-Type" , "application/json");
        requestList.queryParam("name", "Lists");
        requestList.queryParam("idBoard", "63bb21d7db868a031c1035cc");//https://trello.com/b/xBkMKUrd/boardfeb#
       // System.out.println(IDBoard);
        requestList.queryParam("key", env.keys);
        requestList.queryParam("token", env.tokens);
        Response response_List =  requestList.post();
        response_List.prettyPrint();
        JsonPath pathn = response_List.jsonPath();
        String ID_List = pathn.getString("id");
        System.out.println("List_ID  is  " + ID_List);

 // Get_List
        // https://api.trello.com/1/boards/{{BoardsId}}/lists?key={{APIKEY}}&token={{APIToken}}
    RestAssured.baseURI = "https://api.trello.com/1/boards/" + "63bb21d7db868a031c1035cc" + "/lists";
        RequestSpecification request_List = RestAssured.given();
        request_List.header("Content-Type" , "application/json");
        request_List.queryParam("key", env.keys);
        request_List.queryParam("token", env.tokens);
        request_List.queryParam("name", "List_one");
        Response responseList =  request_List.get();
        responseList.prettyPrint();
       String statusList = responseList.getStatusLine();
        System.out.println("Status line for Get List " +  statusList);
        Assert.assertEquals(statusList ,"HTTP/1.1 200 OK");
    }
}
