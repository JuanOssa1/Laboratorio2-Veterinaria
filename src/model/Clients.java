package model;
import java.util.ArrayList;
public class Clients {
	// Attributes from the class
	private String name;
	private String identification;
	private String direction;
	private String phoneNumber;
	// Association attributes
	private ArrayList<Pets> petOfClientOnDebut;

	// builder class Veterinary (will be called in the main class)
	public Clients(String name, String identification, String direction, String phoneNumber) {
		this.name = name;
		this.identification = identification;
		this.direction = direction;
		this.phoneNumber = phoneNumber;
		petOfClientOnDebut = new ArrayList<Pets>();
	}

	public void addPet(Pets pet) {
		petOfClientOnDebut.add(pet);
	}

	public String getAll() {
		String clientdata = "\nNombre: " + name + "\nIdentificacion: " + identification + "\nDireccion" + direction
				+ "\nNumero telefonico: " + phoneNumber + "\nMascotas del cliente: " + petOfClientOnDebut;
		return clientdata;
	}

	public String showPets() {
		String msg = "";

		for (int i = 0; i < petOfClientOnDebut.size(); i++) {
			msg += ((i + 1) + ". " + petOfClientOnDebut.get(i).getName() + "\n");
		}

		return msg;
	}
	// Setters that allows to change variable information in a future
	public void setName(String newName) {
		this.name = newName;
	}

	public void setIdentification(String newIdentification) {
		this.identification = newIdentification;
	}

	public void setDirection(String newDirection) {
		this.direction = newDirection;
	}

	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	public ArrayList<Pets> getPetsofClientsOnDebut() {
		return this.petOfClientOnDebut;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public String getName() {
		return this.name;
	}

	public String getIdentification() {
		return this.identification;
	}

	public String getDirection() {
		return this.direction;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	

}