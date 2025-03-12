package app.patients;

import java.util.List;

public class MedicalHistory {
    private List<AllergiesEnum> alergies;
    private List<MedicationsEnum> medications;
    private List<PreviousSurgeriesEnum> previousSurgeries;
    public MedicalHistory(List<AllergiesEnum> alergies, List<MedicationsEnum> medications, List<PreviousSurgeriesEnum> previousSurgeries){
        this.alergies = alergies;
        this.medications = medications;
        this.previousSurgeries = previousSurgeries;
    }

    @Override
    public String toString() {
        String result = "\tAlergias: ";
        for (AllergiesEnum allergie : alergies){
            result += "\n\t\t" + allergie;
        }
        result += "\n\tMedicaciones: ";
        for (MedicationsEnum medication : medications){
            result += "\n\t\t" + medication;
        }
        result += "\n\tAnteriores Cirugías: ";
        for (PreviousSurgeriesEnum previousSurgery : previousSurgeries){
            result += "\n\t\t" + previousSurgery;
        }
        return result;
    }
}
