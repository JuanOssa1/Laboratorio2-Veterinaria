package model;

import java.util.ArrayList;

public class ClinicHistory {
	// Constants
	// Attributes from the class
	private boolean state;
	private String symptom;
	private String diagnosis;
	private long totalHospitalizationPrice;
	private String summary;
	// Association attributes
	private Pets petRequiredOnDebut;
	private Clients clientRequiredOnDebut;
	private Date admissionDateOnDebut;
	private ArrayList<Medicine> medicineRequiredOnDebut;

	// builder class Pets (will be called in the main class)
	public ClinicHistory(boolean state, String symptom, String diagnosis, Date date, Pets petRequiredOnDebut,
			Clients clientRequiredOnDebut, long totalHospitalizationPrice, String summary) {
		this.state = state;
		this.symptom = symptom;
		this.diagnosis = diagnosis;
		this.admissionDateOnDebut = date;
		this.petRequiredOnDebut = petRequiredOnDebut;
		this.clientRequiredOnDebut = clientRequiredOnDebut;
		this.totalHospitalizationPrice = totalHospitalizationPrice;
		this.summary = summary;
		// ArrayList
		medicineRequiredOnDebut = new ArrayList<Medicine>();
	}
	public String getAll() {
		String x = "\nSintomas: " + symptom + "\nDiagnostico: " + diagnosis + "\nEstado" + state
				+ "\nFecha de ingreso: " + admissionDateOnDebut + "\nMascota: " + petRequiredOnDebut + "\ncliente: "
				+ clientRequiredOnDebut + "\n precio total de hospitalizacion " + totalHospitalizationPrice
				+ "\n medicinas " + medicineRequiredOnDebut;
		return x;
	}

	public String getAllPlusData() {
		String x = "\nNombre de la mascota: " + petRequiredOnDebut.getName() + "\nTipo de mascota: "
				+ petRequiredOnDebut.getAnimalType() + "\nSintomas: " + symptom + "\nDiagnostico: " + diagnosis
				+ "\nEstado: " + state + "\nFecha de ingreso: " + admissionDateOnDebut.getDay() + "/"
				+ admissionDateOnDebut.getMonth() + "/" + admissionDateOnDebut.getYear() + "" + "\ncliente: "
				+ clientRequiredOnDebut.getName();
		return x;
	}

	public String saveMedicine(String name, double doseCuantity, double pricePerDose, int frecuencyOfAdministration) {
		String msg = "Medicina agregada de manera exitosa";
		Medicine newMedicine = new Medicine(name, doseCuantity, pricePerDose, frecuencyOfAdministration);
		medicineRequiredOnDebut.add(newMedicine);
		return msg;

	}
	
	public void addMedicine(Medicine medicine) {
		medicineRequiredOnDebut.add(medicine);
	}

	// Setters that allows to change variable information in a future
	public void setState(boolean newState) {
		this.state = newState;
	}

	public void setSymptom(String newSymptom) {
		this.symptom = newSymptom;
	}

	public void setDiagnosis(String newDiagnosis) {
		this.diagnosis += newDiagnosis;
	}

	public void setPetRequiredOnDebut(Pets newPetRequiredOnDebut) {
		this.petRequiredOnDebut = newPetRequiredOnDebut;
	}

	public void setClientRequiredOnDebut(Clients newClientRequiredOnDebut) {
		this.clientRequiredOnDebut = newClientRequiredOnDebut;
	}

	public void setAdmissionDateOnDebut(Date newAdmissionDateOnDebut) {
		this.admissionDateOnDebut = newAdmissionDateOnDebut;
	}

	public void setTotalHospitalizationPrice(long newTotalHospitaliZationPrice) {
		this.totalHospitalizationPrice = newTotalHospitaliZationPrice;
	}

	public void setSummary(String newSummary) {
		this.summary = newSummary;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public boolean getState() {
		return this.state;
	}

	public String getSymptom() {
		return this.symptom;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public Pets getPetRequiredOnDebut() {
		return this.petRequiredOnDebut;
	}

	public Clients getClientRequiredOnDebut() {
		return this.clientRequiredOnDebut;
	}

	public Date getAdmissionDateOnDebut() {
		return this.admissionDateOnDebut;
	}

	public ArrayList<Medicine> getMedicineRequiredOnDebut() {
		return this.medicineRequiredOnDebut;
	}

	

	public long getTotalHospitalizationPrice() {
		return this.totalHospitalizationPrice;
	}

	public String getSummary() {
		return this.summary;
	}

	

}