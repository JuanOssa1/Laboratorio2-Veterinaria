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
	private double height;
	private long hospitalizationValue;
	private String id;
	// Association attributes
	private ClinicHistory petClinicHistory;

	// builder class Pets (will be called in the main class)
	public Pets(String name, String animalType, int age, double weight, double height, String id) {
		this.name = name;
		this.animalType = animalType;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.id = id;

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
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The BMI is calculated.
	*@return The pet body mass index. Returns -1 if the height is zero  due to the division on zero does not exist.
	*/
	public double calculateBMI(){
		double BMI = 0;
		if(height != 0) {
			BMI = (weight)/(height * height);
		}
		else{
			BMI = -1;
		}
		return BMI;
	}

	/**
	 * Description: This method allows to set a clinic history to a pet
	 * pre: The clinic history was created before
	 * post: The clinic history is added to a pet
	 */
	public void setClinicHistory(ClinicHistory newClinicHistory) {
		this.petClinicHistory = newClinicHistory;
	}
	// Gets that allows to use the information of the attributes in another
	// class
	/**
	 * Description: This method allows to get the name of the pet to use it in another class if is needed 
	 * @return The name of a pet
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Description: This method allows to get the animal type of a pet to use it in another class if is needed 
	 * @return The animal type of a pet 
	 */
	public String getAnimalType() {
		return this.animalType;
	}
	/**
	 * Description: This method allows to get the clinic history of a pet to use it in another class if is needed 
	 * @return The clinic history of a pet
	 */
	public ClinicHistory getPetClinic() {
		return this.petClinicHistory;
	}
	/**
	 * Description: This method allows to get the cost of the hospitalization of a pet to use it in another class if is needed 
	 * @return The hospitalization cost of the pet
	 */
	public long getHospitalizationValue() {
		return this.hospitalizationValue;
	}

}