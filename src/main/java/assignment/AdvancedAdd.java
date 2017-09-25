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
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.model.dstu2.valueset.ObservationStatusEnum;
import ca.uhn.fhir.model.dstu2.composite.QuantityDt;

/**
 *
 */
public class AdvancedAdd {

    //This Connection object is the same as the one you implemented in the first FHIR task
    private Connection connection = null;

    public AdvancedAdd(Connection connection) {
        this.connection = connection;
    }

    public String addPatient(String firstName, String lastName) {
        String id = null;
        //Place your code here
        //Return the ID of the new patient
        //Be sure it is just the logical ID Part
        return id;

    }

    public String addObservation(String patientId, String loincCode, String loincDisplayName,
                                 double value, String valueUnit, String valueCode) {
        String id = null;
        //Place your code here
        //Return the ID of the new Observation
        //Be sure it is just the logical ID Part

        return id;

    }

    public static void main(String[] args) {
        //     Connection conn = new Connection("https://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu2");
        Connection conn = new Connection("https://fhirtest.uhn.ca/baseDstu2");
        AdvancedAdd aa = new AdvancedAdd(conn);
        String id = aa.addPatient("John","Smith");


        System.out.println(aa.addObservation(id,"789-8",
                "Erythrocytes [#/volume] in Blood by Automated count", 4.12,
                "10 trillion/L", "10*12/L"));


    }

}