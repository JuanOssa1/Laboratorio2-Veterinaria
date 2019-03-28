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

	// Setters that allows to change variable information in a future
	public void setName(String newName) {
		this.name = newName;
	}

	public void setDoseCuantity(double newDoseCuantity) {
		this.doseCuantity = newDoseCuantity;
	}

	public void setPricePerDose(double newPricePerDose) {
		this.pricePerDose = newPricePerDose;
	}

	public void setFrecuencyOfAdministration(int newFrecuencyOfAdministration) {
		this.frecuencyOfAdministration = newFrecuencyOfAdministration;
	}

	public void setTotalMedicinePrice(double newTotalMedicinePrice) {
		this.totalMedicinePrice = newTotalMedicinePrice;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public String getName() {
		return this.name;
	}

	public double getDoseCuantity() {
		return this.doseCuantity;
	}

	public double getPricePerDose() {
		return this.pricePerDose;
	}

	public int getFrecuencyOfAdministration() {
		return this.frecuencyOfAdministration;
	}

	public double getTotalMedicinePrice() {
		return this.totalMedicinePrice;
	}

}