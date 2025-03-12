package app.initializate;

import app.patients.Patient;

import java.util.Random;

public class Initializate {

    public static Patient generatePatient(){
        DiseasesCreator diseasesCreator = initializateDiseases();
        return new Patient(diseasesCreator.getDiseases().get(new Random().nextInt(diseasesCreator.getDiseases().size())));
    }

    public static DiseasesCreator initializateDiseases(){
        return DiseasesCreator.getInstance();
    }
}
