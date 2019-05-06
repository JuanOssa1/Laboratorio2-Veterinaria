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
	/**
	 * Description: This method allows to show in a message with the type String all the information of a clinic history 
	 * pre: The clinic history was created before was created before
	 * @return The clinic history data(Symptom, diagnose, state of the clinic history, entry date, hospitalization price, summary)
	 */
	public String getAll() {
		String x = "\nSintomas: " + symptom + "\nDiagnostico: " + diagnosis + "\nEstado" + state
				+ "\nFecha de ingreso: " + admissionDateOnDebut + "\nMascota: " + petRequiredOnDebut + "\ncliente: "
				+ clientRequiredOnDebut + "\n precio total de hospitalizacion " + totalHospitalizationPrice
				+ "\n medicinas " + medicineRequiredOnDebut;
		return x;
	}
	/**
	 * Description: This method allows to show in a message with the type String all the information of a clinic history, with exactly date(day, month, year) and the name of the client
	 * pre: The clinic history was created before was created before
	 * @return The clinic history data(Symptom, diagnose, state of the clinic history, entry day, entry month, entry year, hospitalization price, summary, client name)
	 */
	public String getAllPlusData() {
		String x = "\nNombre de la mascota: " + petRequiredOnDebut.getName() + "\nTipo de mascota: "
				+ petRequiredOnDebut.getAnimalType() + "\nSintomas: " + symptom + "\nDiagnostico: " + diagnosis
				+ "\nEstado: " + state + "\nFecha de ingreso: " + admissionDateOnDebut.getDay() + "/"
				+ admissionDateOnDebut.getMonth() + "/" + admissionDateOnDebut.getYear() + "" + "\ncliente: "
				+ clientRequiredOnDebut.getName();
		return x;
	}
	/**
	 * Description: This method allows to save the information of a medicine in the list of medicines
	 * post: The medicine is added to the list of medicines
	 * @param name
	 * @param doseCuantity
	 * @param pricePerDose
	 * @param frecuencyOfAdministration
	 * @return A message that informs the user if the medicine was added
	 */
	public String saveMedicine(String name, double doseCuantity, double pricePerDose, int frecuencyOfAdministration) {
		String msg = "Medicina agregada de manera exitosa";
		Medicine newMedicine = new Medicine(name, doseCuantity, pricePerDose, frecuencyOfAdministration);
		medicineRequiredOnDebut.add(newMedicine);
		return msg;

	}
	// Setters that allows to change variable information in a future
	/**
	 * Description: This method allows to change the state of the clinic history to true or false
	 * pre: The clinic history was created before
	 * post: The state is changed
	 */
	public void setState(boolean newState) {
		this.state = newState;
	}
	/**
	*Description This method allows to set new notes to the possible diagnostic during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: New notes were added to the possible diagnostic in the patient clinic story.
	*@param The notes of possible diagnostic. This param must be not null.
	*/
	public void setSymptom(String newSymptom) {
		this.symptom += newSymptom;
	}
	/**
	*Description This method allows to set a new symptom presented during the hospitalization at the patient stories.
	*pre: The patient clinic story must be not null.
	*post: A new symptom were added to the patient clinic story.
	*@param The new symptom presented. This param must be not null.
	*/

	public void setDiagnosis(String newDiagnosis) {
		this.diagnosis += newDiagnosis;
	}
	/**
	 * Description: This method allows to change the total hospitalization price that is in a clinic history of a pet
	 * @param newTotalHospitaliZationPrice param must be not null
	 * pre: The clinic history was created before
	 * post: The hospitalization price is changed
	 */
	public void setTotalHospitalizationPrice(long newTotalHospitaliZationPrice) {
		this.totalHospitalizationPrice = newTotalHospitaliZationPrice;
	}
	/**
	 * Description: This method allows to change the summary of a clinic history 
	 * @param newSummary must be not null 
	 * pre: The clinic history was created before
	 * post: The summary is changed
	 */
	public void setSummary(String newSummary) {
		this.summary = newSummary;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	
	/**
	 * Description: This method allows to get the pet owner of the clinic history 
	 * pre: The clinic history was created before
	 * @return The pet owner of the clinic history
	 */
	public Pets getPetRequiredOnDebut() {
		return this.petRequiredOnDebut;
	}
	/**
	 * Description: This method allows to get the owner of the pet that have the clinic history
	 * @return Owner of the pet that have the clinic history
	 */
	public Clients getClientRequiredOnDebut() {
		return this.clientRequiredOnDebut;
	}
	/**
	 *Description: The method allows to get the date of admission of a pet in the hospitalization  
	 * @return A date of admission of a pet
	 */
	public Date getAdmissionDateOnDebut() {
		return this.admissionDateOnDebut;
	}
	/**
	 * Description: This method allows to get the list of medicines that are in the clinic history
	 * @return The list of medicines in the clinic history
	 */
	public ArrayList<Medicine> getMedicineRequiredOnDebut() {
		return this.medicineRequiredOnDebut;
	}
	/**
	 * Description: This method allows to get the hospitalization price that is on the clinic history
	 * @return hospitalization price 
	 */
	public long getTotalHospitalizationPrice() {
		return this.totalHospitalizationPrice;
	}
	
}