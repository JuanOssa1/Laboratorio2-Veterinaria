package model;
public class Pets {
	// Constants
	public final static String CATITO = "Gato";
	public final static String DOGTITO = "Perro";
	public final static String BIRDTITO = "Pajaro";
	public final static String OTHERTITO = "Otro";
	// Attributes from the class
	private String name;
	private String animalType;
	private int age;
	private double weight;
	private long hospitalizationValue;
	// Association attributes
	private ClinicHistory petClinicHistory;

	// builder class Pets (will be called in the main class)
	public Pets(String name, String animalType, int age, double weight) {
		this.name = name;
		this.animalType = animalType;
		this.age = age;
		this.weight = weight;

		switch (this.animalType) {
		case CATITO:
			if (weight >= 1 && weight <= 3) {
				hospitalizationValue = 10000;
			} else if (weight >= 3.1 && weight <= 10) {
				hospitalizationValue = 12000;
			}
			if (weight >= 10.1 && weight <= 20) {
				hospitalizationValue = 15000;
			} else if (weight > 20) {
				hospitalizationValue = 20000;
			}
			break;
		case DOGTITO:
			if (weight >= 1 && weight <= 3) {
				hospitalizationValue = 15000;
			} else if (weight >= 3.1 && weight <= 10) {
				hospitalizationValue = 17000;
			}
			if (weight >= 10.1 && weight <= 20) {
				hospitalizationValue = 20000;
			} else if (weight > 20) {
				hospitalizationValue = 25000;
			}
			break;
		case BIRDTITO:
			if (weight >= 1 && weight <= 3) {
				hospitalizationValue = 10000;
			} else if (weight >= 3.1 && weight <= 10) {
				hospitalizationValue = 12000;
			}
			if (weight >= 10.1 && weight <= 20) {
				hospitalizationValue = 20000;
			} else if (weight > 20) {
				hospitalizationValue = 25000;
			}
			break;
		case OTHERTITO:
			if (weight >= 1 && weight <= 3) {
				hospitalizationValue = 10000;
			} else if (weight >= 3.1 && weight <= 10) {
				hospitalizationValue = 17000;
			}
			if (weight >= 10.1 && weight <= 20) {
				hospitalizationValue = 30000;
			} else if (weight > 20) {
				hospitalizationValue = 30000;
			}
			break;
		}

		petClinicHistory = null;
	}

	/*
	 * public void createClinicHistory(boolean state, String symptom, String
	 * diagnosis, Date date, Pets petRequiredOnDebut, Clients
	 * clientRequiredOnDebut, long totalHospitalizationPrice) {
	 * this.petClinicHistory = new ClinicHistory(state, symptom, diagnosis,
	 * date, petRequiredOnDebut, clientRequiredOnDebut,
	 * totalHospitalizationPrice); }
	 */
	/*
	 * public void updateClinicHistory(boolean state, String symptom, String
	 * diagnosis, Pets petRequiredOnDebut, Clients clientRequiredOnDebut) {
	 * 
	 * this.petClinicHistory.setState(state);
	 * this.petClinicHistory.setSymptom(newSymptom); this.petClinicHistory.se
	 * this.petClinicHistory this.petClinicHistory this.petClinicHistory }
	 */
	// Setters that allows to change variable information in a future
	public void setName(String newName) {
		this.name = newName;
	}

	public void setAnimalType(String newAnimalType) {
		this.animalType = newAnimalType;
	}

	public void setAge(int newAge) {
		this.age = newAge;
	}

	public void setWeight(double newWeight) {
		this.weight = newWeight;
	}

	public void setHospitalizationValue(long newHospitalizationValue) {
		this.hospitalizationValue = newHospitalizationValue;
	}

	public void setClinicHistory(ClinicHistory newClinicHistory) {
		this.petClinicHistory = newClinicHistory;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public String getName() {
		return this.name;
	}

	public String getAnimalType() {
		return this.animalType;
	}

	public int getAge() {
		return this.age;
	}

	public double getWeight() {
		return this.weight;
	}

	public ClinicHistory getPetClinic() {
		return this.petClinicHistory;
	}

	public long getHospitalizationValue() {
		return this.hospitalizationValue;
	}

}