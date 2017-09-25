package assignment;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.IGenericClient;

/**
 *
 */
public class Connection {

    private IGenericClient client = null;

    public Connection(String baseUrl) {
        //Place your code here
        FhirContext ctx = FhirContext.forDstu2();
        client = ctx.newRestfulGenericClient(baseUrl);
    }

    public IGenericClient getClient() {
        return client;
    }


    public static void main(String[] args) {
     //   Connection conn = new Connection("https://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu3");
        Connection conn = new Connection("https://fhirtest.uhn.ca/baseDstu2");
        System.out.println(conn.getClient());
    }
}