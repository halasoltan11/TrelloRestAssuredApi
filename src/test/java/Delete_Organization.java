import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Delete_Organization {
    static   EnviromentVars env = new EnviromentVars();

    public static void main(String[] args) {
        //https://api.trello.com/1/organizations/{{OrganizationID}}?key={{APIKEY}}&token={{APIToken}}
        RestAssured.baseURI = "https://api.trello.com/1/organizations/63bb21d53c41790292ea0a35" ;
        RequestSpecification delOrg = RestAssured.given();
        delOrg.queryParam("key", env.keys);
        delOrg.queryParam("token", env.tokens);
        Response Del_Org_response =  delOrg.delete();
        Del_Org_response.prettyPrint();
        int del_Orga_Code = Del_Org_response.getStatusCode();
        System.out.println("Status Code is " +  del_Orga_Code);
        Assert.assertEquals(del_Orga_Code ,200);

    }
}
