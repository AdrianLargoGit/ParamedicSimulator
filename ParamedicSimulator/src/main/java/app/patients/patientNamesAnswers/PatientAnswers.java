package app.patients.patientNamesAnswers;

import app.patients.Patient;
import app.symptoms.SymptomEnum;

public class PatientAnswers {
    public static void printWelcome(Patient patient){
        System.out.println("Hola, buenos días. Me llamo " + patient.getName() + " " + patient.getSurname() + ".");
        if (patient.getSymptom().size()>2){
            System.out.println("Vengo por un problemilla que me he encontrado. Tengo " + patient.getSymptom().get(0) + ", " + patient.getSymptom().get(1) + " y creo que también " + patient.getSymptom().get(2) + ".");
        } else System.out.println("Vengo por un problemilla que me he encontrado. Tengo " + patient.getSymptom().get(0) + " y " + patient.getSymptom().get(1) + ".");
        System.out.println("¿Me podría ayudar? He rellenado los datos que me habéis pedido, ten. *te entrega un formulario*.");
        System.out.println("\n--------------------- FORMULARIO --------------------\n");
        System.out.println(patient);
        System.out.println("\n-----------------------------------------------------\n");
    }

    public static void printViewPatient(Patient patient){
        System.out.println("El paciente parece " + patient.getNivelConciencia() + ", con un color de piel " + patient.getColorPiel() + "\n");
    }

    public static void printVitalSigns(Patient patient){
        System.out.println("\nPulso: " + patient.getPulse());
        System.out.println("Presión arterial: " + patient.getBloodPressure());
        System.out.println("Temperatura corporal: " + patient.getTemperature());
        System.out.println("Frecuencia respiratoria: " + patient.getRespiratoryRate() + "\n\n");
    }

    public static void printMachines(int n, Patient patient){
        switch (n){
            case 1:
                System.out.println("\nHaciendo análisis de sangre...");
                System.out.println(patient.getDisease().realizarAnalisisDeSangre());
                System.out.println("Oxigeno en sangre: " + patient.getOxigenSaturation());
                System.out.println("Glucosa en sangre: " + patient.getGlucose());
                System.out.println("\n");
                break;
            case 2:
                System.out.println("\nHaciendo análisis de orina...");
                System.out.println(patient.getDisease().realizarAnalisisDeOrina());
                System.out.println("\n");
                break;
            case 3:
                System.out.println("\nHaciendo electrocardiograma...");
                System.out.println(patient.getDisease().realizarElectrocardiograma());
                System.out.println("\n");
                break;
            case 4:
                System.out.println("\nComprobando gasometría arterial...");
                System.out.println(patient.getDisease().realizarGasometriaArterial());
                System.out.println("\n");
                break;
            default:
                System.out.println("\nEsa prueba no existe.\n");
        }
    }

    public static void printPista(Patient patient){
        if (patient.getSymptom().size()==patient.getDisease().getSymptoms().size()){
            System.out.println("\nNo tengo más síntomas, doctor.\n");
        } else {
            SymptomEnum newSy = null; int iterator = 0;
            while (newSy==null && iterator<patient.getDisease().getSymptoms().size()){
                if (!patient.getSymptom().contains(patient.getDisease().getSymptoms().get(iterator))){
                    System.out.print("\nCreo que tengo un nuevo síntoma: ");
                    newSy = patient.getDisease().getSymptoms().get(iterator);
                    System.out.println(newSy);
                    patient.getSymptom().add(newSy);
                    System.out.println("\n");
                } else iterator++;
            }
            if (newSy==null){
                System.out.println("\nNo sé lo que me pasa.");
            }

        }
    }
}
