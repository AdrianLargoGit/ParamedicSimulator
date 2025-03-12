package app.initializate;

import app.diseases.Disease;

import app.symptoms.SymptomEnum;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class DiseasesCreator {
    public static DiseasesCreator instance;
    private final List<Disease> diseases;
    private DiseasesCreator(){
        this.diseases = new ArrayList<>();
        diseases.add(new Disease("Resfriado Común", Arrays.asList(SymptomEnum.CONGESTION_NASAL, SymptomEnum.DOLOR_DE_GARGANTA, SymptomEnum.FIEBRE, SymptomEnum.DOLOR_DE_CABEZA_INTENSO), 0, 60, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Gripe", Arrays.asList(SymptomEnum.FIEBRE, SymptomEnum.FATIGA, SymptomEnum.DOLOR_MUSCULAR, SymptomEnum.DOLOR_DE_CABEZA_INTENSO), 0, 80, 60, 100, "90/60", "130/85", 36.5, 39.0, 12, 24, 95, 100, 70, 120));
        diseases.add(new Disease("Neumonía", Arrays.asList(SymptomEnum.DIFICULTAD_PARA_RESPIRAR, SymptomEnum.TOS, SymptomEnum.FIEBRE, SymptomEnum.DOLOR_TORACICO), 0, 90, 60, 100, "90/60", "130/85", 36.5, 39.0, 12, 24, 90, 100, 70, 120));
        diseases.add(new Disease("Bronquitis", Arrays.asList(SymptomEnum.DIFICULTAD_PARA_RESPIRAR, SymptomEnum.TOS, SymptomEnum.CONGESTION_NASAL, SymptomEnum.FIEBRE), 0, 100, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Neumonitis", Arrays.asList(SymptomEnum.DIFICULTAD_PARA_RESPIRAR, SymptomEnum.FATIGA, SymptomEnum.TOS, SymptomEnum.CONGESTION_NASAL), 0, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Alergia al Polen", Arrays.asList(SymptomEnum.CONGESTION_NASAL, SymptomEnum.DOLOR_DE_GARGANTA, SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.PICAZON), 0, 60, 60, 100, "90/60", "130/85", 36.5, 38.0, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Gastroenteritis", Arrays.asList(SymptomEnum.DIARREA, SymptomEnum.VOMITOS, SymptomEnum.DOLOR_ABDOMINAL, SymptomEnum.FIEBRE), 0, 80, 60, 100, "90/60", "130/85", 36.5, 38.5, 12, 24, 95, 100, 70, 120));
        diseases.add(new Disease("Alergia a la Penicilina", Arrays.asList(SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.PICAZON, SymptomEnum.CIANOSIS), 0, 100, 60, 100, "90/60", "130/85", 36.5, 38.0, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Angina Pectoris", Arrays.asList(SymptomEnum.DOLOR_TORACICO, SymptomEnum.PALPITACIONES, SymptomEnum.MAREO_O_DESMAYO, SymptomEnum.DIFICULTAD_PARA_RESPIRAR), 30, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 90, 100, 70, 120));
        diseases.add(new Disease("Parotiditis", Arrays.asList(SymptomEnum.FIEBRE, SymptomEnum.DOLOR_TORACICO, SymptomEnum.HINCHAZON, SymptomEnum.CONGESTION_NASAL), 0, 60, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Alergia al Polen Grave", Arrays.asList(SymptomEnum.CONGESTION_NASAL, SymptomEnum.DOLOR_DE_GARGANTA, SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.PICAZON, SymptomEnum.FALTA_DE_ALIENTO, SymptomEnum.CIANOSIS), 0, 80, 60, 100, "90/60", "130/85", 36.5, 38.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Insomnio", Arrays.asList(SymptomEnum.FATIGA, SymptomEnum.DOLOR_DE_CABEZA_INTENSO, SymptomEnum.DIFICULTAD_PARA_MOVERSE, SymptomEnum.DOLOR_MUSCULAR), 0, 100, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Hipo Persistente", Arrays.asList(SymptomEnum.HIPOPERSISTENTE, SymptomEnum.DOLOR_DE_CABEZA_INTENSO), 10, 60, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Acidosis Láctica", Arrays.asList(SymptomEnum.FATIGA, SymptomEnum.DIFICULTAD_PARA_RESPIRAR, SymptomEnum.PIEL_FRIA_Y_HUMEDA, SymptomEnum.PALIDEZ, SymptomEnum.MAREO_O_DESMAYO), 20, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Anemia", Arrays.asList(SymptomEnum.FATIGA, SymptomEnum.PALIDEZ, SymptomEnum.DIFICULTAD_PARA_MOVERSE, SymptomEnum.MAREO_O_DESMAYO, SymptomEnum.PALPITACIONES), 0, 100, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Varicela", Arrays.asList(SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.FIEBRE, SymptomEnum.PICAZON), 0, 60, 60, 100, "90/60", "130/85", 36.5, 38.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Sarampión", Arrays.asList(SymptomEnum.FIEBRE, SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.PICAZON, SymptomEnum.CONGESTION_NASAL), 0, 100, 60, 100, "90/60", "130/85", 36.5, 39.0, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Rubeola", Arrays.asList(SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.PICAZON, SymptomEnum.FIEBRE, SymptomEnum.CONGESTION_NASAL), 0, 100, 60, 100, "90/60", "130/85", 36.5, 39.0, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Dermatitis Alérgica", Arrays.asList(SymptomEnum.ERUPCIONES_CUTANEAS, SymptomEnum.PICAZON, SymptomEnum.HINCHAZON), 0, 100, 60, 100, "90/60", "130/85", 36.5, 38.0, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Epilepsia", Arrays.asList(SymptomEnum.PERDIDA_DE_CONCIENCIA, SymptomEnum.PARALISIS, SymptomEnum.DOLOR_DE_CABEZA_INTENSO), 0, 100, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Meningitis", Arrays.asList(SymptomEnum.FIEBRE, SymptomEnum.DOLOR_DE_CABEZA_INTENSO, SymptomEnum.PERDIDA_DE_CONCIENCIA, SymptomEnum.SENSIBILIDAD_A_LA_LUZ), 0, 60, 60, 100, "90/60", "130/85", 36.5, 38.5, 12, 24, 95, 100, 70, 120));
        diseases.add(new Disease("Apoplejía", Arrays.asList(SymptomEnum.PARALISIS, SymptomEnum.PERDIDA_DE_CONCIENCIA, SymptomEnum.MAREO_O_DESMAYO), 30, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Accidente Cerebrovascular", Arrays.asList(SymptomEnum.PARALISIS, SymptomEnum.PERDIDA_DE_CONCIENCIA, SymptomEnum.MAREO_O_DESMAYO), 30, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Cáncer de Pulmón", Arrays.asList(SymptomEnum.DIFICULTAD_PARA_RESPIRAR, SymptomEnum.TOS, SymptomEnum.PALPITACIONES), 40, 80, 60, 100, "90/60", "130/85", 36.5, 38.0, 12, 24, 90, 100, 70, 120));
        diseases.add(new Disease("Asma", Arrays.asList(SymptomEnum.DIFICULTAD_PARA_RESPIRAR, SymptomEnum.SIBILANCIAS, SymptomEnum.TOS), 0, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Insuficiencia Renal", Arrays.asList(SymptomEnum.DIFICULTAD_PARA_MOVERSE, SymptomEnum.PALIDEZ, SymptomEnum.MAREO_O_DESMAYO), 20, 80, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Faringitis", Arrays.asList(SymptomEnum.DOLOR_DE_GARGANTA, SymptomEnum.CONGESTION_NASAL, SymptomEnum.FIEBRE), 0, 60, 60, 100, "90/60", "130/85", 36.5, 37.5, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Cistitis", Arrays.asList(SymptomEnum.URGENCIA_URINARIA, SymptomEnum.DOLOR_AL_ORINAR, SymptomEnum.FIEBRE), 0, 80, 60, 100, "90/60", "130/85", 36.5, 38.0, 12, 20, 95, 100, 70, 120));
        diseases.add(new Disease("Hepatitis A", Arrays.asList(SymptomEnum.DOLOR_ABDOMINAL, SymptomEnum.FIEBRE, SymptomEnum.DIARREA, SymptomEnum.ERUPCIONES_CUTANEAS), 0, 80, 60, 100, "90/60", "130/85", 36.5, 38.5, 12, 24, 95, 100, 70, 120));
    }

    public static DiseasesCreator getInstance(){
        if (instance==null){
            instance = new DiseasesCreator();
        }
        return instance;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }
}
