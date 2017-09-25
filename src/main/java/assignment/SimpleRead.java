package assignment;

import java.util.List;
import java.util.ArrayList;

import ca.uhn.fhir.model.base.composite.BaseHumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.primitive.StringDt;

/**
 *
 */
public class SimpleRead {

    //This Connection object is the same as the one you implemented in the first FHIR task
    private Connection connection = null;

    public SimpleRead(Connection connection) {
        this.connection = connection;
    }

    public String getNameByPatientID(String id) {
        String name = null;
        //Place your code here
        Patient patient = this.connection.getClient().read()
                .resource(Patient.class)
                .withId(id)
                .execute();
        name = patient.getName().get(0).getNameAsSingleString();
//        for (HumanNameDt bsd : patient.getName()) {
//            name = bsd.getNameAsSingleString();
//        }
        return name;
    }

    public List<String> getIDByPatientName(String name) {
        List<String> answer = new ArrayList<String>();
        //Place your code here
        Bundle results = this.connection.getClient()
                .search()
                .forResource(Patient.class)
                .where(Patient.FAMILY.matches().value(name))
                .returnBundle(ca.uhn.fhir.model.dstu2.resource.Bundle.class)
                .execute();

        List<Bundle.Entry> list = results.getEntry();
        for (Bundle.Entry be : list) {
            Patient p1 = (Patient) be.getResource();
            answer.add(p1.getId().getIdPart());
//            String id1 = p1.getId().getIdPart();
//            for (HumanNameDt hdt : p1.getName()) {
//                for (StringDt s : hdt.getFamily()) {
//                    if (s.getValue().equalsIgnoreCase(name)) {
//                        answer.add(p1.getId().getIdPart());
//                    }
//                }
//            }
        }
        System.out.println("Found " + results.getEntry().size() + " patients named: " + name);
        return answer;
    }


    public static void main(String[] args) {
        //  Connection conn = new Connection("https://fhirtesting.hdap.gatech.edu/hapi-fhir-jpaserver-example/baseDstu2");
        Connection conn = new Connection("https://fhirtest.uhn.ca/baseDstu2");
        SimpleRead sr = new SimpleRead(conn);
        // id value as argument  is invented; you want to change them
        System.out.println("Name: " + sr.getNameByPatientID("5773"));
        System.out.println(sr.getIDByPatientName("Smith"));

//        iD's = [5773, 5776, 5779, 5780, 5783, 5785, 5789, 5774, 5775, 5777]

    }


}