package app.diseases;

import app.patients.AllergiesEnum;
import app.patients.MedicalHistory;
import app.patients.MedicationsEnum;
import app.patients.PreviousSurgeriesEnum;
import app.symptoms.SymptomEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Disease {
    private final String name;
    private final List<SymptomEnum> symptoms;
    private final int minAgeRange;
    private final int maxAgeRange;
    private final int minPulse;
    private final int maxPulse;
    private final String minBloodPressure;
    private final String maxBloodPressure;
    private final double minTemperature;
    private final double maxTemperature;
    private final int minRespiratoryRate;
    private final int maxRespiratoryRate;
    private final int minOxygenSaturation;
    private final int maxOxygenSaturation;
    private final int minGlucose;
    private final int maxGlucose;
    private final Random random = new Random();

    public Disease(String name, List<SymptomEnum> symptoms, int minAgeRange, int maxAgeRange, int minPulse, int maxPulse, String minBloodPressure, String maxBloodPressure, double minTemperature, double maxTemperature, int minRespiratoryRate, int maxRespiratoryRate, int minOxygenSaturation, int maxOxygenSaturation, int minGlucose, int maxGlucose) {
        this.name = name;
        this.symptoms = symptoms;
        this.minAgeRange = minAgeRange;
        this.maxAgeRange = maxAgeRange;
        this.minPulse = minPulse;
        this.maxPulse = maxPulse;
        this.minBloodPressure = minBloodPressure;
        this.maxBloodPressure = maxBloodPressure;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.minRespiratoryRate = minRespiratoryRate;
        this.maxRespiratoryRate = maxRespiratoryRate;
        this.minOxygenSaturation = minOxygenSaturation;
        this.maxOxygenSaturation = maxOxygenSaturation;
        this.minGlucose = minGlucose;
        this.maxGlucose = maxGlucose;
    }

    public int generateAge() {
        return random.nextInt(maxAgeRange - minAgeRange + 1) + minAgeRange;
    }

    public int generatePulse() {
        return random.nextInt(maxPulse - minPulse + 1) + minPulse;
    }

    public String generateBloodPressure() {
        return (random.nextInt(Integer.parseInt(maxBloodPressure.split("/")[0]) - Integer.parseInt(minBloodPressure.split("/")[0]) + 1) + Integer.parseInt(minBloodPressure.split("/")[0])) + "/"
                + (random.nextInt(Integer.parseInt(maxBloodPressure.split("/")[1]) - Integer.parseInt(minBloodPressure.split("/")[1]) + 1) + Integer.parseInt(minBloodPressure.split("/")[1]));
    }

    public double generateTemperature() {
        return minTemperature + (maxTemperature - minTemperature) * random.nextDouble();
    }

    public int generateRespiratoryRate() {
        return random.nextInt(maxRespiratoryRate - minRespiratoryRate + 1) + minRespiratoryRate;
    }

    public int generateOxygenSaturation() {
        return random.nextInt(maxOxygenSaturation - minOxygenSaturation + 1) + minOxygenSaturation;
    }

    public int generateGlucose() {
        return random.nextInt(maxGlucose - minGlucose + 1) + minGlucose;
    }

    public MedicalHistory generateMedicalHistory() {
        List<AllergiesEnum> allergies = new ArrayList<>();
        List<MedicationsEnum> medications = new ArrayList<>();
        List<PreviousSurgeriesEnum> previousSurgeries = new ArrayList<>();

        // Assigning medical history based on the disease
        if (this.name.equals("Gripe (Influenza)")) {
            allergies.add(AllergiesEnum.POLLEN);  // Flu-specific
            medications.add(MedicationsEnum.PARACETAMOL);  // Flu medication
            previousSurgeries.add(PreviousSurgeriesEnum.NONE);  // Flu doesn't typically require surgery
        } else if (this.name.equals("Resfriado Común")) {
            allergies.add(AllergiesEnum.DUST);  // Common cold-related allergy
            medications.add(MedicationsEnum.PARACETAMOL);  // Cold medication
            previousSurgeries.add(PreviousSurgeriesEnum.NONE);  // No surgeries
        } else if (this.name.equals("Asma")) {
            allergies.add(AllergiesEnum.POLLEN);  // Asthma is triggered by allergens
            medications.add(MedicationsEnum.ALBUTEROL);  // Asthma medication
            previousSurgeries.add(PreviousSurgeriesEnum.NONE);  // Asthma typically doesn't require surgery
        } else if (this.name.equals("Neumonía")) {
            allergies.add(AllergiesEnum.NONE);  // Pneumonia has no specific allergies
            medications.add(MedicationsEnum.ANTIBIOTICS);  // Pneumonia treatment
            previousSurgeries.add(PreviousSurgeriesEnum.NONE);  // No surgery specific to pneumonia
        } else if (this.name.equals("Diabetes")) {
            allergies.add(AllergiesEnum.FOOD);  // Some people with diabetes have food allergies
            medications.add(MedicationsEnum.INSULIN);  // Insulin for diabetes treatment
            previousSurgeries.add(PreviousSurgeriesEnum.HEART_SURGERY);  // Some diabetics might have heart surgeries
        }

        if (allergies.isEmpty()) {
            Arrays.stream(AllergiesEnum.values())
                    .filter(a -> random.nextBoolean() && !allergies.contains(a) && allergies.size() < 2)
                    .forEach(allergies::add);
            if (allergies.contains(AllergiesEnum.NONE)){
                allergies.clear();
                allergies.add(AllergiesEnum.NONE);
            }
        }

        if (medications.isEmpty()) {
            Arrays.stream(MedicationsEnum.values())
                    .filter(m -> random.nextBoolean() && !medications.contains(m) && medications.size() < 2)
                    .forEach(medications::add);
            if (medications.contains(MedicationsEnum.NONE)){
                medications.clear();
                medications.add(MedicationsEnum.NONE);
            }
        }

        if (previousSurgeries.isEmpty()) {
            Arrays.stream(PreviousSurgeriesEnum.values())
                    .filter(s -> random.nextBoolean() && !previousSurgeries.contains(s) && previousSurgeries.size() < 2)
                    .forEach(previousSurgeries::add);
            if (previousSurgeries.contains(PreviousSurgeriesEnum.NONE)){
                previousSurgeries.clear();
                previousSurgeries.add(PreviousSurgeriesEnum.NONE);
            }
        }

        return new MedicalHistory(allergies, medications, previousSurgeries);
    }

    public String realizarElectrocardiograma() {
        return switch (this.name) {
            case "Neumonía" -> "ECG: Ritmo normal, sin arritmias significativas, frecuencia cardíaca elevada.";
            case "Gripe" -> "ECG: Ritmo sinusal, frecuencia cardíaca normal.";
            case "Cáncer de Pulmón" -> "ECG: Ritmo normal, frecuencia cardíaca elevada.";
            case "Asma" -> "ECG: Ritmo sinusal, frecuencia cardíaca normal.";
            case "Insuficiencia Renal" -> "ECG: Ritmo sinusal, signos de posibles arritmias por hiperkalemia.";
            case "Faringitis" -> "ECG: Ritmo sinusal, frecuencia cardíaca normal.";
            case "Cistitis" -> "ECG: Ritmo sinusal, frecuencia cardíaca normal.";
            case "Hepatitis A" -> "ECG: Ritmo sinusal, sin alteraciones significativas.";
            case "Apoplejía" -> "ECG: Ritmo normal, sin arritmias, ritmo sinusal.";
            case "Accidente Cerebrovascular" -> "ECG: Ritmo normal, posible bradicardia.";
            case "Meningitis" -> "ECG: Ritmo normal, sin alteraciones.";
            case "Epilepsia" -> "ECG: Ritmo normal, presencia de actividad epiléptica en ciertos casos.";
            case "Cáncer de Estómago" -> "ECG: Ritmo normal, sin alteraciones.";
            case "Diabetes" -> "ECG: Ritmo normal, sin alteraciones significativas.";
            case "Migraña" -> "ECG: Ritmo sinusal, frecuencia cardíaca normal.";
            case "EPOC" -> "ECG: Ritmo sinusal, frecuencia cardíaca normal.";
            case "Fiebre tifoidea" -> "ECG: Ritmo sinusal, leve bradicardia.";
            case "Dengue" -> "ECG: Ritmo sinusal, sin alteraciones.";
            case "Hepatitis B" -> "ECG: Ritmo sinusal, sin alteraciones.";
            case "Leptospirosis" -> "ECG: Ritmo sinusal, sin alteraciones significativas.";
            case "Lupus" -> "ECG: Ritmo normal, sin arritmias.";
            default -> "ECG: Sin alteraciones significativas.";
        };
    }

    public String realizarAnalisisDeSangre() {
        return switch (this.name) {
            case "Neumonía" -> "Análisis de sangre: Leucocitos elevados, posible anemia leve.";
            case "Gripe" -> "Análisis de sangre: Leucocitos normales, aumento de proteína C reactiva (PCR).";
            case "Insuficiencia Renal" -> "Análisis de sangre: Creatinina elevada, niveles bajos de glóbulos rojos.";
            case "Cáncer de Pulmón" -> "Análisis de sangre: Leucocitos elevados, posible anemia.";
            case "Asma" -> "Análisis de sangre: Eosinofilia leve.";
            case "Faringitis" -> "Análisis de sangre: Leucocitos elevados, posible PCR elevada.";
            case "Cistitis" -> "Análisis de sangre: Leucocitos elevados, PCR elevada.";
            case "Hepatitis A" -> "Análisis de sangre: Transaminasas elevadas, bilirubina elevada.";
            case "Apoplejía" -> "Análisis de sangre: Leucocitos normales, hemoglobina y hematocrito dentro del rango.";
            case "Accidente Cerebrovascular" -> "Análisis de sangre: Leucocitos normales, hemoglobina en rango normal.";
            case "Meningitis" -> "Análisis de sangre: Leucocitos elevados, PCR elevada.";
            case "Epilepsia" -> "Análisis de sangre: Niveles normales de glucosa y electrolitos.";
            case "Cáncer de Estómago" -> "Análisis de sangre: Hemoglobina baja, posible anemia ferropénica.";
            case "Diabetes" -> "Análisis de sangre: Glucosa elevada, posible hemoglobina glicosilada elevada.";
            case "Migraña" -> "Análisis de sangre: Leucocitos normales, sin alteraciones.";
            case "EPOC" -> "Análisis de sangre: Leucocitos normales, posible aumento de hematocrito.";
            case "Fiebre tifoidea" -> "Análisis de sangre: Leucocitos elevados, neutrófilos bajos.";
            case "Dengue" -> "Análisis de sangre: Leucocitos bajos, plaquetas bajas.";
            case "Hepatitis B" -> "Análisis de sangre: Transaminasas elevadas, bilirubina elevada.";
            case "Leptospirosis" -> "Análisis de sangre: Leucocitos elevados, creatinina elevada.";
            case "Lupus" -> "Análisis de sangre: Anemia, leucocitos bajos, plaquetas bajas.";
            default -> "Análisis de sangre: Sin alteraciones significativas.";
        };
    }

    public String realizarAnalisisDeOrina() {
        return switch (this.name) {
            case "Insuficiencia Renal" -> "Análisis de orina: Proteinuria, posible hematuria.";
            case "Diabetes" -> "Análisis de orina: Glucosuria, posible cetonuria.";
            case "Cistitis" -> "Análisis de orina: Leucocitos elevados, presencia de nitritos.";
            case "Hepatitis A" -> "Análisis de orina: Bilirrubina positiva, urobilinógeno elevado.";
            case "Leptospirosis" -> "Análisis de orina: Proteinuria leve, hematuria.";
            case "Lupus" -> "Análisis de orina: Proteinuria, posible hematuria.";
            default -> "Análisis de orina: Sin alteraciones significativas.";
        };
    }

    public String realizarGasometriaArterial() {
        return switch (this.name) {
            case "Neumonía" -> "Gasometría: pH 7.35, PaO2 bajo, saturación de oxígeno al 90%.";
            case "Asma" -> "Gasometría: pH normal, PaO2 bajo, saturación de oxígeno al 92%.";
            case "Insuficiencia Renal" -> "Gasometría: pH 7.32, bicarbonato bajo, PaCO2 elevado.";
            case "EPOC" -> "Gasometría: pH 7.36, PaO2 bajo, saturación de oxígeno al 88%.";
            case "Fiebre tifoidea" -> "Gasometría: pH normal, PaO2 bajo, saturación de oxígeno al 93%.";
            case "Dengue" -> "Gasometría: pH normal, PaCO2 elevado debido a deshidratación.";
            case "Leptospirosis" -> "Gasometría: pH normal, PaCO2 elevado, saturación de oxígeno normal.";
            case "Lupus" -> "Gasometría: pH normal, PaCO2 ligeramente elevado.";
            default -> "Gasometría: Sin alteraciones significativas.";
        };
    }

    public String getName() {
        return name;
    }

    public List<SymptomEnum> getSymptoms() {
        return symptoms;
    }
}
