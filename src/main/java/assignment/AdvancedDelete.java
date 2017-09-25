package assignment;

import assignment.Connection;

import org.hl7.fhir.instance.model.api.IBaseOperationOutcome;

import ca.uhn.fhir.model.primitive.IdDt;

/**
 *
 */
public class AdvancedDelete {

    //This Connection object is the same as the one you implemented in the first FHIR task
    private Connection connection = null;

    public AdvancedDelete(Connection connection) {
        this.connection = connection;
    }

    public void deletePatient(String patientId) {
        //Place your code here

    }

    public void deleteObservation(String observationId) {
        //Place your code here

    }


    public static void main(String[] args) {
        //  Connection conn = new Connection("https://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu2");
        Connection conn = new Connection("https://fhirtest.uhn.ca/baseDstu2");
        AdvancedDelete ad = new AdvancedDelete(conn);

     // id values as arguments  are invented; you want to change them
        ad.deletePatient("64954");
        ad.deleteObservation("64978");


    }


}