package model;
public class Medicine {
	// Constants
	// Attributes from the class
	private String name;
	private double doseCuantity;
	private double pricePerDose;
	private int frecuencyOfAdministration;
	private double totalMedicinePrice;

	// Association attributes
	// builder class Pets (will be called in the main class)
	public Medicine(String name, double doseCuantity, double pricePerDose, int frecuencyOfAdministration) {
		this.name = name;
		this.doseCuantity = doseCuantity;
		this.pricePerDose = pricePerDose;
		this.frecuencyOfAdministration = frecuencyOfAdministration;
		this.totalMedicinePrice = ((pricePerDose * doseCuantity) * frecuencyOfAdministration);
	}
	// Gets that allows to use the information of the attributes in another
	/**
	 * Description: This method allows to get the total medicine price of a medicine to use it in another class if is needed 
	 * @return The medicine price
	 */
	public double getTotalMedicinePrice(){
		return totalMedicinePrice;
	}
}