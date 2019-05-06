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
	/**
	 * Description: This method allows to add a pet to the list of pet of a client
	 * pre: The client was created before
	 * post: The pet is added to the pts of the client list
	 */
	public void addPet(Pets pet) {
		petOfClientOnDebut.add(pet);
	}
	/**
	 * Description: This method allows to show in a message with the type String all the information of a client 
	 * pre: The client was created before
	 * @return The client data(Name, identification, address, phone number, pets of the client)
	 */
	public String getAll() {
		//String show = "";
		String clientdata = "\nNombre: " + name + "\nIdentificacion: " + identification + "\nDireccion" + direction
				+ "\nNumero telefonico: " + phoneNumber + "\nMascotas del cliente: " ;
		for(int i = 0; i<petOfClientOnDebut.size(); i++){
			clientdata += (i+1) + ". " + petOfClientOnDebut.get(i).getName() + "\n";
		}
		return clientdata;
	}
	/**
	 * Description: This method allows to show the list of the pets of a client
	 * post: The pets of a client are searched
	 * @return a message with the pets of the client
	 */
	public String showPets() {
		String msg = "";

		for (int i = 0; i < petOfClientOnDebut.size(); i++) {
			msg += ((i + 1) + ". " + petOfClientOnDebut.get(i).getName() + "\n");
		}

		return msg;
	}
	// Setters that allows to change variable information in a future
	/**
	 * Description: This method allows to change the name of a client
	 * @param newName param must be not null 
	 * pre: The client was created before
	 * post: The name of the client is changed
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
	 * Description: This method allows to change the identification of a client
	 * @param newIdentification param must be not null 
	 * pre: The client was created before
	 * post: The identification of the client is changed
	 */
	public void setIdentification(String newIdentification) {
		this.identification = newIdentification;
	}
	/**
	 * Description: This method allows to change the address of a client
	 * @param newDirection param must be not null 
	 * pre: The client was created before
	 * post: The identification of the client is changed
	 */
	public void setDirection(String newDirection) {
		this.direction = newDirection;
	}
	/**
	 * Description: This method allows to change the phone number of a client
	 * @param newPhoneNumber param must be not null 
	 * pre: The client was created before
	 * post: The phone number of the client is changed
	 */
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}
	/**
	 * description: This method allows to get the client pet list
	 * @return Client pet list
	 */
	public ArrayList<Pets> getPetsofClientsOnDebut() {
		return this.petOfClientOnDebut;
	}

	// Gets that allows to use the information of the attributes in another
	/**
	 * Description: This method allows to get the name of a client to use it in another class if is needed 
	 * @return The name of the client
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Description: This method allows to get the identification of a client to use it in another class if is needed 
	 * @return The identification of the client
	 */
	public String getIdentification() {
		return this.identification;
	}
	/**
	 * Description: This method allows to get the address of a client to use it in another class if is needed 
	 * @return The address of the client
	 */
	public String getDirection() {
		return this.direction;
	}
	/**
	 * Description: This method allows to get the phone number of a client to use it in another class if is needed 
	 * @return The phone number of the client
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
}