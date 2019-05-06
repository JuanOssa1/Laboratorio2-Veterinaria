package model;
import java.util.ArrayList;
public class Veterinary
{
	// Constant
	public final static int TOTAL_MINIROOMS = 8;
	public final static int DAYSOFSERVICEOFTHEVET = 7;
	// Attributes from the class
	private String name;
	// Association attributes
	private ArrayList<Clients> clientRegistrationOnDebut;
	private ArrayList<Pets> petRegistrationOnDebut;
	private ArrayList<ClinicHistory> clinicHistoryOnDebut;
	private MiniRooms[] miniRoomsOnDebut;
	private ArrayList<OtherService> otherServices;
	//private OtherService[] otherServices;

	// builder class Veterinary (will be called in the main class)
	public Veterinary(String name) {
		this.name = name;
		// Array list
		clientRegistrationOnDebut = new ArrayList<Clients>();
		petRegistrationOnDebut = new ArrayList<Pets>();
		clinicHistoryOnDebut = new ArrayList<ClinicHistory>();
		otherServices = new ArrayList<OtherService>();
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
	/**
	 * Description: This method allows to the minirooms of the veterinary to true or false 
	 * @param newMiniRoomsOnDebut The param must be not null
	 */
	public void setMiniRoomsOnDebut(MiniRooms[] newMiniRoomsOnDebut) {
		this.miniRoomsOnDebut = newMiniRoomsOnDebut;
	}
	

	// Gets that allows to use the information of the attributes in another
	// class
	
	/**
	 *Description This method allows to create a client with a pet.
	 *pre: 
	 *post: The client and his pet are added to the veterinary.
	 * @param name The param must be not null
	 * @param identification The param must be not null
	 * @param direction The param must be not null
	 * @param phoneNumber The param must be not null
	 * @param petName The param must be not null
	 * @param animalType The param must be not null
	 * @param age The param must be not null
	 * @param weight The param must be not null
	 * @param height The param must be not null
	 * @param id The param must be not null
	 * @return Client added.
	 */
	public Clients registerClientAndFirstPet(String name, String identification, String direction, String phoneNumber,String petName, String animalType, int age, double weight, double height, String id) {
		Clients newClient = new Clients(name, identification, direction, phoneNumber);
		Pets pet = new Pets(petName, animalType, age, weight, height, id);
		newClient.addPet(pet);
		clientRegistrationOnDebut.add(newClient);
		petRegistrationOnDebut.add(pet);
		return newClient;
	}
	/**
	*Description This method allows to add more pets to an existing costumer .
	*pre: The client was created before.
	*post: The pet was added .
	*@return The pet body mass index.
	*@throws If the height is zero, so an exception is thrown due to the division on zero does not exist.
	*/
	public String registerPets(String petName, String animalType, int age, double weight, double height, Clients client, String id) {
		String msg = "";
		Pets newPet = new Pets(petName, animalType, age, weight, height, id);
		client.addPet(newPet);
		petRegistrationOnDebut.add(newPet);
		return msg;
	}
	/**
	*Description This method allows to calculate the body mass index for a pet.
	*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
	*post: The BMI is calculated.
	*@return The pet body mass index.
	*@throws If the height is zero, so an exception is thrown due to the division on zero does not exist.
	*/
	public double calculateBMIFromSpecificPet(/*double height, double weight,*/ Pets pet){
		double calculatedBMI = 0;
		calculatedBMI = pet.calculateBMI();
		return calculatedBMI;
	}
	/**
	 * Description: Allows to search a client with an id 
	 * pre: The client was created before with an id
	 * post The client is searched with the id
	 * @param clientIdentification
	 * @return The client required that have the specified id
	 */
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
	/**
	 * Description: This method allows to search a client with the id that user provides before that it get the data of the client
	 * pre: The client was created before
	 * post: The client is searched 
	 * post: The data of the client is searched 
	 * @param clientIdentification. The param must be not null
	 * @return The data of the specified client
	 */
	public String findClientData(String clientIdentification) {
		String foundClient = "";
		int centinel = -1;
		for (int i = 0; i < clientRegistrationOnDebut.size() && centinel == -1; i++) {
			if (clientIdentification.equalsIgnoreCase(clientRegistrationOnDebut.get(i).getIdentification())) {
				foundClient = clientRegistrationOnDebut.get(i).getAll();
				centinel = 2;
			}
		}
		return foundClient;
	}
	/**
	 * Description: This method allows to update the client identification, name, Address and phone of a client
	 * pre: The client was created before
	 * post: The client is searched
	 * post: The data is searched
	 * post: The data is updated
	 * @param clientIdentification The param must be not null
	 * @param newName The param must be not null
	 * @param newIdentification The param must be not null
	 * @param newAddress The param must be not null
	 * @param newPhone The param must be not null
	 * @return Message that gives information about the status of the update The param must be not null
	 */
	public String updateClientData(String clientIdentification, String newName, String newIdentification, String newAddress, String newPhone) {
		String msg = "";
		int centinel = -1;
		for (int i = 0; i < clientRegistrationOnDebut.size() && centinel == -1; i++) {
			if (clientIdentification.equalsIgnoreCase(clientRegistrationOnDebut.get(i).getName())) {
				clientRegistrationOnDebut.get(i).setDirection(newAddress);
				clientRegistrationOnDebut.get(i).setIdentification(newIdentification);
				clientRegistrationOnDebut.get(i).setName(newName);
				clientRegistrationOnDebut.get(i).setPhoneNumber(newPhone);
				centinel = 2;
				msg = "Actualizado exitosamente";
			}
			else{
				msg = "Oh no! parece que ha ocurrido un error intentalo de nuevo";
			}
		}
		return msg;	
	}
	/**
	 * Description: This method allows to search a client with the pet name of the client that the user needs
	 * pre: The client is created before with a pet
	 * post: The pet is searched
	 * post: The client is searched with the name of the pet
	 * @param petName The param must be not null
	 * @return The client required by the user
	 */
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
	/**
	 * Description:This method allows to search the available rooms in the veterinary
	 * pre: The rooms are created before
	 * post: Available rooms are searched
	 * @return The number of the available room
	 */
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
	/**
	 * Description: This method allows to create a Clinic History with the parameters that the user gives
	 * pre: The parameters most be not null
	 * post: The clinic history is created 
	 * @param state The param must be not null
	 * @param symptom The param must be not null
	 * @param diagnosis The param must be not null
	 * @param date The param must be not null
	 * @param petRequiredOnDebut The param must be not null
	 * @param clientRequiredOnDebut The param must be not null
	 * @param totalHospitalizationPrice The param must be not null
	 * @param summary The param must be not null
	 * @return The new clinic history The param must be not null
	 */
	public ClinicHistory createClinicHistory(boolean state, String symptom, String diagnosis, Date date,
		Pets petRequiredOnDebut, Clients clientRequiredOnDebut, long totalHospitalizationPrice, String summary) {
		ClinicHistory newClinicHistory = new ClinicHistory(state, symptom, diagnosis, date, petRequiredOnDebut,clientRequiredOnDebut, totalHospitalizationPrice, summary);
		clinicHistoryOnDebut.add(newClinicHistory);
		return newClinicHistory;
	}
	/**
	 * Description: This method allows to add a pet to an available room
	 * pre: The room must be available
	 * post: The pet is added to an available rooms
	 * @return A message that inform the user if the pet was added
	 */
	public String addPetToAnARoom(Pets current) {
		String msg = "Exitoso";
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
	/**
	 * Description: This method allows to show the number of the room where a pet is
	 * Post: The available rooms are searched
	 * @return A message with the number of the room where a pet is
	 */
	public String showPetsAndMiniRooms() {
		String msg = "";
		for (int i = 0; i < miniRoomsOnDebut.length; i++) {
			if (miniRoomsOnDebut[i].getPetOnRoomDebut() != null) {
				msg += ((i + 1) + ". " + miniRoomsOnDebut[i].getPetOnRoomDebut().getName() + "\n");
			}
			else {
				msg += ((i + 1) + ". No hay mascota en esta habitacion \n");
			}
		}
		return msg;
	}
	/**
	 * Description: This method allows to calculate the total medicine price of the medicines given to a pet specified by the user
	 * post: The pet is searched and get the price of the medicines required by the pet
	 * @return Total price of the medicines  of an specified pet
	 */
	public long calculateTotalMedicine(Pets selectedPet)												
	{
		long totalMedicine = 0;
		for (int i = 0; i < selectedPet.getPetClinic().getMedicineRequiredOnDebut().size(); i++) {
			totalMedicine += selectedPet.getPetClinic().getMedicineRequiredOnDebut().get(i).getTotalMedicinePrice();
		}
		return totalMedicine;
	}
	/**
	 * 
	 * @return
	 */
	public void addClinicHistory(ClinicHistory clinicHistory) {
		clinicHistoryOnDebut.add(clinicHistory);
	}
	/**
	 * 
	 * @return
	 */
	public long calculateTotalIncomeofHospitalization() {
		long totalIncome = 0;
		for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
			totalIncome += clinicHistoryOnDebut.get(i).getTotalHospitalizationPrice();
		}
		return totalIncome;
	}
	/**
	 * 
	 * @return
	 */
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
	/**
	 * Description: This method allows to add an a summary to a clinic history of and specified pet
	 * @param clinic The param must be not null
	 * @param all The param must be not null
	 * @return The summary of the required pet
	 */
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
	/**
	 * Description: This method allows to search the clinic history of a pet
	 * pre: The pet was created before
	 * post: The clinic history of the pet specified by the user are searched 
	 * @param current The param must be not null
	 * @return The clinic history of the pet 
	 */
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
	//GOOD
	/**
	 * Description: This method allows to search the clinic history of a pet
	 * pre: The pet was created before
	 * post: The clinic history of the pet specified by the user are searched 
	 * @param pet The param must be not null
	 * @return The clinic history of the pet 
	 */
	public ClinicHistory findClinicHistoryOfPetGood(String pet) {
		ClinicHistory petHistory = null;
		boolean found = false;

		for (int i = clinicHistoryOnDebut.size() - 1; i >= 0 && !found; i--) {
			if (clinicHistoryOnDebut.get(i).getPetRequiredOnDebut().getName().equalsIgnoreCase(pet)) {
				found = true;
				petHistory = clinicHistoryOnDebut.get(i);
			}
		}

		return petHistory;
	}
	/**
	 * Description: This method allows to search the clinic history of a pet that is not hospitalized
	 * pre The pet was created before
	 * pre: The pet is not hospitalized
	 * post: The clinic history of the pet that is not hospitalized is searched 
	 * @param petName The param must be not null
	 * @return Message that says to the user if a pet was hospitalized before
	 */
	public String findClinicHistoryOfPetOnHistorialOfClinicHistory(String petName) {
		String found = "";
		for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
			if (clinicHistoryOnDebut.get(i).getPetRequiredOnDebut().getName().equals(petName)) {
				found = "ya ha tenido hospitalizaciones";
			}
		}
		return found;
	}
	/**
	 * Description: This method allows to calculate how much time a pet was hospitalized 
	 * post: The time is calculated in days
	 * @param sickdate The param must be not null
	 * @param goodDate The param must be not null
	 * @return Number of days that a pet was hospitalized 
	 */
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
	/**
	 * Description: This method allows to register the services borrowed to a pet 
	 * post: The services is created and added
	 * @return Message that inform to the user the state of the registration
	 */
	public String otherServiceRegistration(String name, Date date, String idPet,  String idClient){
		String msg = "";
				OtherService service = new OtherService(name, date, idPet, idClient);
				otherServices.add(service);
				msg = "Agregado exitosamente";
			
		return msg;
	}
	/**
	 * Description This method allows to calculate the total income by services
	 * post: total income by services are calculated
	 * @return total income by services
	 */
	public double calculateIncomeByServices(){
		double value = 0;
		for(int i = 0; i<otherServices.size(); i++){
			value += otherServices.get(i).getCost();
		}
		return value;
	}
	/**
	 * Description: This method allows to calculate the average income of services divided with the number of services borrowed by the veterinary
	 * post: The average income by services is calculated
	 * @return Average income by services 
	 */
	public double averageIncomeByServices(){
		double value = 0;
		for(int i = 0; i<otherServices.size(); i++){
			value += otherServices.get(i).getCost();
			value = value/OtherService.MAXTYPESOFSERVICES;
		}
		return value;
	}
		/**
		 * Description: This method allows to calculate the total income of the veterinary including hospitalization and borrowed services
		 * post: Total income of hospitalizations is calculated
		 * post: Total income of services is calculated
		 * post: Combined total income is calculated
		 * @return Total income of the veterinary
		 */
		public double calculateTotalIncomeOfTheVet(){
			long totalIncomeH = 0;
			long totalIncomeS = 0;
			long totalIncome = 0;
			for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
				totalIncomeH += clinicHistoryOnDebut.get(i).getTotalHospitalizationPrice();
			}
			for(int i = 0; i<otherServices.size(); i++){
				totalIncomeS += otherServices.get(i).getCost();
			}
			totalIncome = totalIncomeH + totalIncomeS;
			return totalIncome;
		}
		/**
		 * Description: This method allows to calculate the average income of the veterinary in a range given by the user
		 * post: The number of hospitalization borrowed in the range are calculated
		 * post: The number of services borrowed in the range are calculated
		 * post: Total income in that range is calculated
		 * post: average income is calculated 
		 * @param startingDay The param must be not null
		 * @param startingMonth The param must be not null
		 * @param startingYear The param must be not null
		 * @param finalDay The param must be not null
		 * @param finalMonth The param must be not null
		 * @param finalYear The param must be not null
		 * @return Average income in the range given by the user
		 */
		public double totalAverageIncomeInAweek(int startingDay, int startingMonth, int startingYear, int finalDay, int finalMonth, int finalYear){
			int counterH = 0;
			int counterS = 0;
			long totalIncomeH = 0;
			long totalIncomeS = 0;
			long totalIncome = 0;
			//String msg = "";
			//int week = 0;
			double averageIncome = 0;
			for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
				if((clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getDay() >= startingDay && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getDay() <= finalDay) && (clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getMonth() >= startingMonth && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getMonth() <= finalMonth) && (clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getYear() >= startingYear && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getYear() <= finalYear)){
					totalIncomeH += clinicHistoryOnDebut.get(i).getTotalHospitalizationPrice();
					counterH++;
				}	
			}
			for(int i = 0; i<otherServices.size(); i++){
				if((otherServices.get(i).getDate().getDay() >= startingDay && otherServices.get(i).getDate().getDay() <= finalDay) && (otherServices.get(i).getDate().getMonth() >= startingMonth && otherServices.get(i).getDate().getMonth() <= finalMonth) && (otherServices.get(i).getDate().getYear() >= startingYear && otherServices.get(i).getDate().getYear() <= finalYear) ){
					totalIncomeS += otherServices.get(i).getCost();
					counterS++;
				}
				
			}
			totalIncome = totalIncomeH + totalIncomeS;
			averageIncome = totalIncome/(double)(counterS + counterH );
			return averageIncome;
		}
		///////////////////////////////////////////////////////////////////////////
		//ATENCION, EL METODO QUE SE ENCUENTRA COMENTADO ABAJO FUNCIONA MEDIANTE EL INGRESO DE FECHAS Y NO DE DIAD MESES Y ANIOS INDIVIDUALMENTE
		//////////////////////////////////////////////////////////////////////////
		/*
		public double totalAverageIncomeInAweek(Date dateStarting, Date dateFinal){
			long totalIncomeH = 0;
			long totalIncomeS = 0;
			long totalIncome = 0;
			//String msg = "";
			int week = 0;
			double averageIncome = 0;
			for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
				if((clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getDay() > dateStarting.getDay() && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getDay() < dateFinal.getDay()) && (clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getMonth() > dateStarting.getMonth() && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getMonth() < dateFinal.getMonth()) && (clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getYear() > dateStarting.getYear() && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getYear() < dateFinal.getYear())){
					totalIncomeH += clinicHistoryOnDebut.get(i).getTotalHospitalizationPrice();
				}	
			}
			for(int i = 0; i<otherServices.size(); i++){
				if((otherServices.get(i).getDate().getDay() > dateStarting.getDay() && otherServices.get(i).getDate().getDay() < dateFinal.getDay()) && (otherServices.get(i).getDate().getMonth() > dateStarting.getMonth() && otherServices.get(i).getDate().getMonth() < dateFinal.getMonth()) && (otherServices.get(i).getDate().getYear() > dateStarting.getYear() && otherServices.get(i).getDate().getYear() < dateFinal.getYear()) ){
					totalIncomeS += otherServices.get(i).getCost();
				}
				
			}
			totalIncome = totalIncomeH + totalIncomeS;
			week = ((dateFinal.getDay() - dateStarting.getDay())+((dateFinal.getMonth()-dateStarting.getMonth())*30)+((dateFinal.getYear()-dateStarting.getYear())*360));
			averageIncome = totalIncome/week;
			return averageIncome;
		}
		*/
		/**
		 * Description: This method allows to show the services 
		 * @param startingDay The param must be not null
		 * @param startingMonth The param must be not null
		 * @param startingYear The param must be not null
		 * @param finalDay The param must be not null
		 * @param finalMonth The param must be not null
		 * @param finalYear The param must be not null
		 * @return A message with the services borrowed The param must be not null
		 */
		public String reportInAspecificWeek(int startingDay, int startingMonth, int startingYear, int finalDay, int finalMonth, int finalYear){
			String msg = "";
			for(int i = 0; i<otherServices.size(); i++){
				if((otherServices.get(i).getDate().getDay() >= startingDay && otherServices.get(i).getDate().getDay() <= finalDay) && (otherServices.get(i).getDate().getMonth() >= startingMonth && otherServices.get(i).getDate().getMonth() <= finalMonth) && (otherServices.get(i).getDate().getYear() >= startingYear && otherServices.get(i).getDate().getYear() <= finalYear) ){
					msg += otherServices.get(i).getName();
				}
				else {
					msg = "no hay nada en ese dia";
				}
			}
			return msg;
		}	
		// ArrayList
		/**
		 * description: This method allows to get the clients registered on the veterinary list
		 * @return Veterinary clients registered list
		 */
		public ArrayList<Clients> getClientRegistrationOnDebut() {
			return this.clientRegistrationOnDebut;
		}
		/**
		 * description: This method allows to get the pets registered on the veterinary list
		 * @return Veterinary pets registered list
		 */
		public ArrayList<Pets> getPetRegistrationOnDebut() {
			return this.petRegistrationOnDebut;
		}
		/**
		 * description: This method allows to get the veterinary clinic History list
		 * @return Veterinary clinic history list
		 */
		public ArrayList<ClinicHistory> getClinicHistoryOnDebut() {
			return this.clinicHistoryOnDebut;
		}
		/**
		 * description: This method allows to get the limited rooms list
		 * @return Veterinary limited rooms list
		 */
		public MiniRooms[] getMiniRoomsOnDebut() {
			return this.miniRoomsOnDebut;
		}
}