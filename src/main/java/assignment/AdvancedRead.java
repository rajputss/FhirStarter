package assignment;

import assignment.Connection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Observation;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.rest.gclient.TokenClientParam;

/**
 *
 */
public class AdvancedRead {

    //This Connection object is the same as the one you implemented in the first FHIR task
    private Connection connection = null;

    public AdvancedRead(Connection connection) {
        this.connection = connection;
    }

    public int getTotalNumPatientsByObservation(String loincCode) {
        int num = -1;
        //Place your code here
        return num;
    }

    public static void main(String[] args) {
        //  Connection conn = new Connection("https://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu2");
        Connection conn = new Connection("https://fhirtest.uhn.ca/baseDstu2");
        AdvancedRead ar = new AdvancedRead(conn);
        System.out.println(ar.getTotalNumPatientsByObservation("789-8"));



    }



}