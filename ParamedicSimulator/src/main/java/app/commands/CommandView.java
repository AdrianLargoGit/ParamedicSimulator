package app.commands;

import app.diseases.Disease;
import app.initializate.DiseasesCreator;

import java.util.Scanner;

public class CommandView {
    public static final Scanner sc = new Scanner(System.in);
    public static int printMenu(){
        try{
            System.out.println("> 1. Conectar para mostrar signos vitales");
            System.out.println("> 2. Hacer análisis de sangre");
            System.out.println("> 3. Hacer análisis de orina");
            System.out.println("> 4. Hacer electrocardiograma");
            System.out.println("> 5. Comprobar gasometría arterial");
            System.out.println("> 6. Pista");
            System.out.println("> 7. Comprobar solución");
            System.out.println("> 8. Ver enfermedades posibles");
            System.out.println("> 9. Cambiar paciente");
            System.out.println("> 10. Salir del programa\n");
            System.out.println("En caso de no pasar un número, el programa se cerrará.");
            System.out.print("Opción (número): ");
            return sc.nextInt();
        } catch (Exception e){
            return 10;
        } finally {
            sc.nextLine();
        }
    }

    public static void printOther(String message){
        System.out.println(message + "\n");
    }

    private static String getAnswer(){
        System.out.print("\nTu respuesta: ");
        return sc.nextLine();
    }

    public static void printAnswer(String disease, int puntuacion){
        String answer = getAnswer();
        if (!disease.equalsIgnoreCase(answer)){
            System.out.println("Enfermedad a evaluar: " + disease);
            System.out.println("El paciente ha fallecido");
            System.out.println("Puntuacion: " + (puntuacion-50) + " sobre 100");
        } else {
            System.out.println("Enfermedad a evaluar: " + disease);
            System.out.println("Gracias, ahora me encuentro mucho mejor.");
            System.out.println("Puntuacion: " + (puntuacion+20) + " sobre 100");
        }
    }

    public static void printDiseases(){
        System.out.println("\nEnfermedades posibles: \n");
        for (Disease disease : DiseasesCreator.getInstance().getDiseases()){
            System.out.println("\t" + disease.getName());
        }
        System.out.println("\n");
    }
}
