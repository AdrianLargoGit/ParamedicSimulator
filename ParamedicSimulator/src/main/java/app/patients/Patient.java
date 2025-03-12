package app.patients;

import app.diseases.Disease;
import app.patients.patientNamesAnswers.Names;
import app.patients.patientNamesAnswers.PatientAnswers;
import app.patients.patientNamesAnswers.Surnames;
import app.symptoms.SymptomEnum;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Patient {
    private final Names name;
    private final Surnames surname;
    private final MedicalHistory medicalHistory;
    private final Disease disease;
    private final int age;
    private final int pulse;
    private final String bloodPressure;
    private final double temperature;
    private final int respiratoryRate;
    private final int oxigenSaturation;
    private final int glucose;
    private final List<SymptomEnum> symptom;
    private final double altura;
    private final String colorPiel;
    private final double peso;
    private final String nivelConciencia;
    public Patient(Disease disease){
        this.name = generateName();
        this.surname = generateSurname();
        this.medicalHistory = disease.generateMedicalHistory();
        this.disease = disease;
        this.age = disease.generateAge();
        this.pulse = disease.generatePulse();
        this.bloodPressure = disease.generateBloodPressure();
        this.temperature = disease.generateTemperature();
        this.respiratoryRate = disease.generateRespiratoryRate();
        this.oxigenSaturation = disease.generateOxygenSaturation();
        this.glucose = disease.generateGlucose();
        this.symptom = generateSymptoms();
        this.altura = generarAltura();
        this.peso = generarPeso();
        this.colorPiel = generarColorPiel();
        this.nivelConciencia = generarNivelConciencia();
    }

    private Names generateName(){
        Names nameR = null;
        int nam = (int) (Math.random()*Names.values().length);
        for (Names name : Names.values()){
            if (Names.values()[nam].equals(name)){
                nameR = name;
            }
        }
        return nameR;
    }

    private Surnames generateSurname(){
        Surnames surnameR = null;
        int sur = (int) (Math.random()*Surnames.values().length);
        for (Surnames surname : Surnames.values()){
            if (Surnames.values()[sur].equals(surname)){
                surnameR = surname;
            }
        }
        return surnameR;
    }

    private List<SymptomEnum> generateSymptoms(){
        Random random = new Random();
        List<SymptomEnum> randomSymptoms = disease.getSymptoms().stream()
                .sorted((a, b) -> random.nextInt(2) - 1)  // Aleatorizar el orden
                .limit(3)  // Limitar a los primeros 4 síntomas
                .collect(Collectors.toList());
        return randomSymptoms;
    }

    public List<SymptomEnum> getSymptom() {
        return symptom;
    }

    private double generarPeso() {
        double peso = 0;
        if (age<=4){
            peso = 3 +(age * 7);
        } else if (age <= 18 && age>4) {
            // Rango para niños y adolescentes
            peso = 40 + (age * 2);  // Aumento progresivo de peso por edad
        } else if (age > 18 && age <= 40) {
            // Adultos jóvenes
            if (disease.getName().equals("Anemia") || disease.getName().equals("Insuficiencia Renal") || disease.getName().equals("Tuberculosis")) {
                peso = 50 + (age * 0.5); // Peso más bajo debido a las enfermedades
            } else {
                peso = 70 + (age * 0.2); // Peso promedio
            }
        } else if (age > 40 && age <= 60) {
            // Adultos mayores
            if (disease.getName().equals("Insuficiencia Cardíaca") || disease.getName().equals("EPOC") || disease.getName().equals("Cáncer de Pulmón")) {
                peso = 60 + (age * 0.3); // Peso más bajo
            } else {
                peso = 75 + (age * 0.4); // Peso promedio
            }
        } else {
            // Ancianos
            if (disease.getName().equals("Insuficiencia Renal") || disease.getName().equals("Cáncer de Estómago") || disease.getName().equals("Diabetes")) {
                peso = 55 + (age * 0.1);  // Peso más bajo debido a enfermedades crónicas
            } else {
                peso = 70 + (age * 0.2);  // Peso promedio
            }
        }

        return peso;
    }

    // Generar altura según la edad y enfermedad
    private double generarAltura() {
        double altura = 0;
        if (age<= 4){
            altura = 0.5 + (age*0.2);
        } else if (age <= 18 && age>4) {
            // Rango para niños y adolescentes
            altura = 1.00 + (age * 0.05);  // Aumento progresivo de altura
        } else if (age > 18 && age <= 40) {
            // Adultos jóvenes
            altura = 1.6 + (age * 0.01); // Aumento moderado
        } else if (age > 40 && age <= 60) {
            // Adultos mayores
            altura = 1.60 + (age * 0.005); // Disminución gradual de altura por envejecimiento
        } else {
            // Ancianos
            altura = 1.55;  // Altura promedio para personas mayores
        }

        return altura;
    }

    // Generar color de piel según la enfermedad
    private String generarColorPiel() {
        switch (disease.getName()) {
            case "Anemia":
            case "Insuficiencia Renal":
            case "Cáncer de Estómago":
                return "Pálido";  // Piel más pálida debido a la falta de oxígeno o nutrientes.
            case "Hepatitis A":
            case "Hepatitis B":
                return "Amarillo";  // Ictericia debido a la acumulación de bilirrubina.
            case "EPOC":
                return "Normal";  // Normal, aunque la piel puede volverse un poco pálida si la enfermedad es grave.
            default:
                return "Normal";  // Para la mayoría de las enfermedades.
        }
    }

    // Generar nivel de conciencia según la enfermedad
    private String generarNivelConciencia() {
        switch (disease.getName()) {
            case "Apoplejía":
            case "Accidente Cerebrovascular":
            case "Meningitis":
                return "Confuso";  // Enfermedades que afectan el cerebro o el sistema nervioso.
            case "Epilepsia":
            case "Insuficiencia Renal":
            case "Faringitis":
                return "Normal";  // La mayoría de las enfermedades no afectan la conciencia directamente.
            case "Coma":
            case "Tétanos":
                return "Inconsciente";  // Enfermedades graves pueden llevar al paciente a un estado de inconsciencia.
            default:
                return "Normal";  // Para la mayoría de las enfermedades.
        }
    }

    public int getPulse() {
        return pulse;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public int getOxigenSaturation() {
        return oxigenSaturation;
    }

    public int getGlucose() {
        return glucose;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getColorPiel() {
        return colorPiel;
    }

    public String getNivelConciencia() {
        return nivelConciencia;
    }

    public Disease getDisease() {
        return disease;
    }

    public Names getName() {
        return name;
    }

    public Surnames getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + " " + surname + "\nEdad: " + age + "\nAltura: " + altura  + " m\nPeso: " + peso + " kg\n\nHistorial Clínico: \n" + medicalHistory;
    }
}
