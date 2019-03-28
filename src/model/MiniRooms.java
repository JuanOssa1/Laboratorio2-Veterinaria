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
	public void setDisponibility(boolean newDisponibility) {
		this.disponibility = newDisponibility;
	}

	public void setPetOnRoomDebut(Pets newPetOnRoomDebut) {
		this.petOnRoomDebut = newPetOnRoomDebut;
	}

	public void setClinicHistoryOnRoomOnDebut(ClinicHistory newClinicHistoryOnRoomOnDebut) {
		this.clinicHistoryOnRoomOnDebut = newClinicHistoryOnRoomOnDebut;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public boolean getDisponibility() {
		return this.disponibility;
	}

	public Pets getPetOnRoomDebut() {
		return this.petOnRoomDebut;
	}

	public ClinicHistory getClinicHistoryOnRoomOnDebut() {
		return this.clinicHistoryOnRoomOnDebut;
	}

}

