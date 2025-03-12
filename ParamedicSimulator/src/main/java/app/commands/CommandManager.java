package app.commands;

import app.initializate.Initializate;
import app.patients.Patient;
import app.patients.patientNamesAnswers.PatientAnswers;

public class CommandManager {
    public static void menu(){
        Patient patient = Initializate.generatePatient();
        PatientAnswers.printWelcome(patient);
        PatientAnswers.printViewPatient(patient);
        int puntuation = 100;
        boolean exit = false;
        while (!exit){
            switch (CommandView.printMenu()){
                case 1:
                    PatientAnswers.printVitalSigns(patient);
                    puntuation -= 2;
                    break;
                case 2:
                    PatientAnswers.printMachines(1, patient);
                    puntuation -= 7;
                    break;
                case 3:
                    PatientAnswers.printMachines(2, patient);
                    puntuation -= 7;
                    break;
                case 4:
                    PatientAnswers.printMachines(3, patient);
                    puntuation -= 7;
                    break;
                case 5:
                    PatientAnswers.printMachines(4, patient);
                    puntuation -= 7;
                    break;
                case 6:
                    PatientAnswers.printPista(patient);
                    puntuation -= 25;
                    break;
                case 7:
                    CommandView.printAnswer(patient.getDisease().getName(), puntuation);
                    exit = true;
                    break;
                case 8:
                    CommandView.printDiseases();
                    puntuation -= 10;
                    break;
                case 9:
                    CommandView.printOther("\n\nCambiando paciente...");
                    patient = Initializate.generatePatient();
                    PatientAnswers.printWelcome(patient);
                    PatientAnswers.printViewPatient(patient);
                    puntuation = 100;
                    break;
                case 10:
                    CommandView.printOther("\nSaliendo del programa...");
                    exit = true;
                    break;
                default:
                    CommandView.printOther("\nEsa opción no se encuentra en el menú, por favor seleccione una elegible.");
            }
        }
        CommandView.sc.close();
    }
}
