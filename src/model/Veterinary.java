package model;
import java.util.ArrayList;
public class Veterinary

{

	// Constant
	public final static int TOTAL_MINIROOMS = 8;
	// Attributes from the class
	private String name;
	// Association attributes
	private ArrayList<Clients> clientRegistrationOnDebut;
	private ArrayList<Pets> petRegistrationOnDebut;
	private ArrayList<ClinicHistory> clinicHistoryOnDebut;
	private MiniRooms[] miniRoomsOnDebut;

	// builder class Veterinary (will be called in the main class)
	public Veterinary(String name) {
		this.name = name;
		// Array list
		clientRegistrationOnDebut = new ArrayList<Clients>();
		petRegistrationOnDebut = new ArrayList<Pets>();
		clinicHistoryOnDebut = new ArrayList<ClinicHistory>();
		// Fixed Array
		miniRoomsOnDebut = new MiniRooms[TOTAL_MINIROOMS];

		miniRoomsOnDebut[0] = new MiniRooms(true);
		miniRoomsOnDebut[1] = new MiniRooms(true);
		miniRoomsOnDebut[2] = new MiniRooms(true);
		miniRoomsOnDebut[3] = new MiniRooms(true);
		miniRoomsOnDebut[4] = new MiniRooms(true);
		miniRoomsOnDebut[5] = new MiniRooms(true);
		miniRoomsOnDebut[6] = new MiniRooms(true);
		miniRoomsOnDebut[7] = new MiniRooms(true);

	}

	// Setters that allows to change variable information in a future
	public void setName(String newName) {
		name = newName;
	}

	public void setMiniRoomsOnDebut(MiniRooms[] newMiniRoomsOnDebut) {
		this.miniRoomsOnDebut = newMiniRoomsOnDebut;
	}

	// Gets that allows to use the information of the attributes in another
	// class
	public String getName() {
		return this.name;
	}

	// ArrayList
	public ArrayList<Clients> getClientRegistrationOnDebut() {
		return this.clientRegistrationOnDebut;
	}

	public ArrayList<Pets> getPetRegistrationOnDebut() {
		return this.petRegistrationOnDebut;
	}

	public ArrayList<ClinicHistory> getClinicHistoryOnDebut() {
		return this.clinicHistoryOnDebut;
	}

	public MiniRooms[] getMiniRoomsOnDebut() {
		return this.miniRoomsOnDebut;
	}

	/**
	 * Description:Prueba pre:Prueba Precondiciones post:kldjklj
	 * 
	 * @param jjsdkljfl
	 * @return osiuiosdf
	 * @throws ljfksdj
	 */
	public Clients registerClientAndFirstPet(String name, String identification, String direction, String phoneNumber,
			String petName, String animalType, int age, double weight) {

		Clients newClient = new Clients(name, identification, direction, phoneNumber);
		Pets pet = new Pets(petName, animalType, age, weight);

		newClient.addPet(pet);
		clientRegistrationOnDebut.add(newClient);
		petRegistrationOnDebut.add(pet);

		return newClient;
	}

	public String registerPets(String petName, String animalType, int age, double weight, Clients client) {
		String msg = "";
		Pets newPet = new Pets(petName, animalType, age, weight);
		client.addPet(newPet);
		petRegistrationOnDebut.add(newPet);
		return msg;
	}

	public Clients findClient(String clientIdentification) {
		Clients foundClient = null;
		int centinel = -1;
		for (int i = 0; i < clientRegistrationOnDebut.size() && centinel == -1; i++) {
			if (clientIdentification.equals(clientRegistrationOnDebut.get(i).getIdentification())) {
				foundClient = clientRegistrationOnDebut.get(i);
				centinel = 2;
			} else if (clientIdentification.equals(clientRegistrationOnDebut.get(i).getName())) {
				foundClient = clientRegistrationOnDebut.get(i);
				centinel = 2;
			}

		}

		return foundClient;
	}

	public String findClientData(String clientIdentification) {
		String foundClient = "";
		int centinel = -1;
		for (int i = 0; i < clientRegistrationOnDebut.size() && centinel == -1; i++) {
			if (clientIdentification.equalsIgnoreCase(clientRegistrationOnDebut.get(i).getName())) {
				foundClient = clientRegistrationOnDebut.get(i).getAll();
				centinel = 2;
			}

		}

		return foundClient;
	}

	public String findClientDataWithPetName(String petName) {
		String foundClient = "";
		int centinel = -1;
		for (int i = 0; i < petRegistrationOnDebut.size() && centinel == -1; i++) {
			if (petName.equals(petRegistrationOnDebut.get(i).getName())) {
				foundClient = petRegistrationOnDebut.get(i).getPetClinic().getClientRequiredOnDebut().getAll();
				centinel = 2;
			}

		}
		return foundClient;
	}

	public int findAvaibleRooms() {
		int disponibility = 0;
		for (int i = 0; i < miniRoomsOnDebut.length; i++) {
			if (miniRoomsOnDebut[i] != null) {
				if (miniRoomsOnDebut[i].getDisponibility() == true) {
					disponibility++;
				}
			}
		}

		return disponibility;
	}

	/*
	 * public void ClinicHistory( boolean state, String symptom, String
	 * diagnosis, Pets petRequiredOnDebut, Clients clientRequiredOnDebut) {
	 * 
	 * }
	 */
	public ClinicHistory createClinicHistory(boolean state, String symptom, String diagnosis, Date date,
			Pets petRequiredOnDebut, Clients clientRequiredOnDebut, long totalHospitalizationPrice, String summary) {
		ClinicHistory newClinicHistory = new ClinicHistory(state, symptom, diagnosis, date, petRequiredOnDebut,
				clientRequiredOnDebut, totalHospitalizationPrice, summary);

		clinicHistoryOnDebut.add(newClinicHistory);

		// .setClinicHistoryOnRoomOnDebut(newClinicHistory)
		return newClinicHistory;
	}

	public String addPetToAnARoom(Pets current) {
		String msg = "";
		boolean found = false;
		for (int i = 0; i < miniRoomsOnDebut.length && !found; i++) {
			if (miniRoomsOnDebut[i].getDisponibility()) {
				found = true;
				miniRoomsOnDebut[i].setDisponibility(false);
				miniRoomsOnDebut[i].setPetOnRoomDebut(current);
				miniRoomsOnDebut[i].setClinicHistoryOnRoomOnDebut(current.getPetClinic());

			}
		}

		return msg;
	}

	public String showPetsAndMiniRooms() {
		String msg = "";

		for (int i = 0; i < miniRoomsOnDebut.length; i++) {
			if (miniRoomsOnDebut[i].getPetOnRoomDebut() != null) {
				msg += ((i + 1) + ". " + miniRoomsOnDebut[i].getPetOnRoomDebut().getName() + "\n");
			} else {
				msg += ((i + 1) + ". No hay mascota en esta habitacion \n");
			}
		}

		return msg;
	}

	public long calculateTotalMedicine(Pets selectedPet)// No puedo obtenerla
														// mediante la historia
														// clinica porque a
														// penas la esta creando
														// y llama un metodo que
														// todavia no existe
	{
		long totalMedicine = 0;

		for (int i = 0; i < selectedPet.getPetClinic().getMedicineRequiredOnDebut().size(); i++) {

			totalMedicine += selectedPet.getPetClinic().getMedicineRequiredOnDebut().get(i).getTotalMedicinePrice();
		}

		return totalMedicine;
	}

	public void addClinicHistory(ClinicHistory clinicHistory) {
		clinicHistoryOnDebut.add(clinicHistory);
	}

	public long calculateTotalIncomeofHospitalization() {
		long totalIncome = 0;
		for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
			totalIncome += clinicHistoryOnDebut.get(i).getTotalHospitalizationPrice();
		}
		return totalIncome;
	}

	public String showCurrentHospitalizedPets() {
		int centinel = -1;
		String pet = "";
		for (int i = 0; i < miniRoomsOnDebut.length && centinel == -1; i++) {

			pet = miniRoomsOnDebut[i].getClinicHistoryOnRoomOnDebut().getAllPlusData();

			if (miniRoomsOnDebut[i].getClinicHistoryOnRoomOnDebut().getAllPlusData() == null)
				;
			{
				centinel = 4;
			}
		}
		return pet;
	}

	public String addSummarytoAclinicHistory(Pets clinic, ClinicHistory all) //////////////////////// OJOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	{
		String summaryRecovered = "";
		for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
			if (clinic.getPetClinic().equals(clinicHistoryOnDebut.get(i))) {
				summaryRecovered = all.getAll();
				clinicHistoryOnDebut.get(i).setSummary(summaryRecovered);
			}
		}
		return summaryRecovered;
	}

	public ClinicHistory findClinicHistoryOfPet(Pets current) {
		ClinicHistory petHistory = null;
		boolean found = false;

		for (int i = clinicHistoryOnDebut.size() - 1; i > 0 && !found; i--) {
			if (clinicHistoryOnDebut.get(i).getPetRequiredOnDebut() == current) {
				found = true;
				petHistory = clinicHistoryOnDebut.get(i);
			}
		}

		return petHistory;
	}

	public String findClinicHistoryOfPetOnHistorialOfClinicHistory(String petName) {
		String found = "";
		for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
			if (clinicHistoryOnDebut.get(i).getPetRequiredOnDebut().getName().equals(petName)) {
				found = "ya ha tenido hospitalizaciones";
			}
		}
		return found;
	}

	public int calculateDate(Date sickdate, Date goodDate) {

		int operationDay = 30;
		int operationMonth = 12;
		int operationYear = 2019;
		int totalDaysSick = operationDay - sickdate.getDay();
		int totalMonthsSick = (operationMonth - sickdate.getMonth()) * 30;
		int totalYearsSick = (operationYear - sickdate.getYear()) * 360;
		int totalDaysMonthYearSick = totalDaysSick + totalMonthsSick + totalYearsSick;
		int totalDaysGood = operationDay - goodDate.getDay();
		int totalMonthsGood = (operationMonth - goodDate.getMonth()) * 30;
		int totalYearsGood = (operationYear - goodDate.getYear()) * 360;
		int totalDaysMonthYearGood = totalDaysGood + totalMonthsGood + totalYearsGood;
		int realTotal = totalDaysMonthYearGood - totalDaysMonthYearSick;

		return realTotal;
	}
}