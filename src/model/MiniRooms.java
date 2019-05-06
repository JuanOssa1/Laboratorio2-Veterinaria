package model;
public class MiniRooms {
	// Constants
	// Attributes from the class
	private boolean disponibility;
	// Association attributes
	private Pets petOnRoomDebut;
	private ClinicHistory clinicHistoryOnRoomOnDebut;

	// builder class Pets (will be called in the main class)
	public MiniRooms(boolean availability) {
		disponibility = availability;
		this.petOnRoomDebut = null;
		clinicHistoryOnRoomOnDebut = null;
	}
	// Setters that allows to change variable information in a future
	/**
	 * Description: This method allows to change the availability to true or false of the miniroom
	 * pre: The mini room must be created before
	 * post: The availability is changed
	 * @param newDisponibility param must be not null 
	 */
	public void setDisponibility(boolean newDisponibility) {
		this.disponibility = newDisponibility;
	}
	/**
	 * Description: This method allows to set a pet in a miniroom
	 * pre: The mini room must be created before
	 * post: The pet is setted
	 * @param newPetOnRoomDebut param must be not null 
	 */
	public void setPetOnRoomDebut(Pets newPetOnRoomDebut) {
		this.petOnRoomDebut = newPetOnRoomDebut;
	}
	/**
	 * Description: This method allows to set a clinic history to a mini room
	 * pre: The mini room must be created before
	 * post: The clinic history is setted
	 * @param newClinicHistoryOnRoomOnDebut param must be not null  
	 */
	public void setClinicHistoryOnRoomOnDebut(ClinicHistory newClinicHistoryOnRoomOnDebut) {
		this.clinicHistoryOnRoomOnDebut = newClinicHistoryOnRoomOnDebut;
	}
	// Gets that allows to use the information of the attributes in another
	// class
	/**
	 * Description: This method allows to get the availability of a mini room to use it in another class if is needed 
	 * @return The availability of a mini room
	 */
	public boolean getDisponibility() {
		return this.disponibility;
	}
	/**
	 * Description: This method allows to get the pet in a mini room to use it in another class if is needed 
	 * @return The pet in the mini room
	 */
	public Pets getPetOnRoomDebut() {
		return this.petOnRoomDebut;
	}
	/**
	 * Description: This method allows to get the clinic history of a pet in a mini room to use it in another class if is needed 
	 * @return The clinic history in the mini room
	 */
	public ClinicHistory getClinicHistoryOnRoomOnDebut() {
		return this.clinicHistoryOnRoomOnDebut;
	}
}
