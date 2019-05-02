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
		//otherServices = new ArrayList<OtherService>();
		/*
		Date date = new Date(2, 3, 2019);
		otherServices[0]= new OtherService("Don carlos", date, "100365", "4525645178");
		otherServices[1]= new OtherService("Don carlos", date, "100365", "4525645178");
		otherServices[2]= new OtherService("Don carlos", date, "100365", "4525645178");
		otherServices[3]= new OtherService("Don carlos", date, "100365", "4525645178");
		*/

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
	*Description This method allows to create a client with a pet.
	*pre: 
	*post: The client and his pet are added to the veterinary.
	*@return Client added.
	
	*/
	public Clients registerClientAndFirstPet(String name, String identification, String direction, String phoneNumber,
			String petName, String animalType, int age, double weight, double height) {

		Clients newClient = new Clients(name, identification, direction, phoneNumber);
		Pets pet = new Pets(petName, animalType, age, weight, height);

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

	public String registerPets(String petName, String animalType, int age, double weight, double height, Clients client) {
		String msg = "";
		Pets newPet = new Pets(petName, animalType, age, weight, height);
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
			/*
			else{
				foundClient = clientRegistrationOnDebut.get(i).
			}
			*/

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
	public String otherServiceRegistration(String name, Date date, String idPet,  String idClient){
		String msg = "";
				OtherService service = new OtherService(name, date, idPet, idClient);
				otherServices.add(service);
				msg = "Agregado exitosamente";
			
		return msg;
	}
	
	
	public double calculateIncomeByServices(){
		double value = 0;
		for(int i = 0; i<otherServices.size(); i++){
			value += otherServices.get(i).getCost();
		}
		return value;
	}
	
		public double averageIncomeByServices(){
		double value = 0;
		for(int i = 0; i<otherServices.size(); i++){
			value += otherServices.get(i).getCost();
			value = value/OtherService.MAXTYPESOFSERVICES;
		}
		return value;
	}
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
		public double totalAverageIncomeInAweek(int startingDay, int startingMonth, int startingYear, int finalDay, int finalMonth, int finalYear){
			long totalIncomeH = 0;
			long totalIncomeS = 0;
			long totalIncome = 0;
			//String msg = "";
			int week = 0;
			double averageIncome = 0;
			for (int i = 0; i < clinicHistoryOnDebut.size(); i++) {
				if((clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getDay() > startingDay && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getDay() < finalDay) && (clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getMonth() > startingMonth && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getMonth() < finalMonth) && (clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getYear() > startingYear && clinicHistoryOnDebut.get(i).getAdmissionDateOnDebut().getYear() < finalYear)){
					totalIncomeH += clinicHistoryOnDebut.get(i).getTotalHospitalizationPrice();
				}	
			}
			for(int i = 0; i<otherServices.size(); i++){
				if((otherServices.get(i).getDate().getDay() > startingDay && otherServices.get(i).getDate().getDay() < finalDay) && (otherServices.get(i).getDate().getMonth() > startingMonth && otherServices.get(i).getDate().getMonth() < finalMonth) && (otherServices.get(i).getDate().getYear() > startingYear && otherServices.get(i).getDate().getYear() < finalYear) ){
					totalIncomeS += otherServices.get(i).getCost();
				}
				
			}
			totalIncome = totalIncomeH + totalIncomeS;
			week = ((startingDay - finalDay)+((startingMonth-finalMonth)*30)+((startingYear-finalYear)*360));
			averageIncome = totalIncome/week;
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
		public String reportInAspecificWeek(int startingDay, int startingMonth, int startingYear, int finalDay, int finalMonth, int finalYear){
			String msg = "";
			for(int i = 0; i<otherServices.size(); i++){
				if((otherServices.get(i).getDate().getDay() > startingDay && otherServices.get(i).getDate().getDay() < finalDay) && (otherServices.get(i).getDate().getMonth() > startingMonth && otherServices.get(i).getDate().getMonth() < finalMonth) && (otherServices.get(i).getDate().getYear() > startingYear && otherServices.get(i).getDate().getYear() < finalYear) ){
					msg += otherServices.get(i).getName();
				}
			
			
			}
			return msg;
		}
		
		
		
		
		
		
		
		
		/*
		public double averageIncomeInASpecificWeek(){
			double averageIncome = 0;
			
			return averageIncome;
		}
		
		
		
		
		
		
		
		
	*/
	
	/*
	public String calculateIncomeByServices(){
		String value = "";
		for(int i = 0; i<otherServices.size(); i++){
			value += otherServices.get(i).getName();
		}
		return value;
	}
	*/
	
}
