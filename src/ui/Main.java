package ui;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private Scanner dataRead;
	private Veterinary happypet;

	public Main() {
		init();
	}

	public static void main(String args[]) {
		Main m = new Main();
		m.menu(0);
	}

	public void init() {
	
		//Date date = new Date()
		happypet = new Veterinary("happypet");
		happypet.registerClientAndFirstPet("Karen", "123456", "Calle siempre viva", "325461", "Horus",Pets.DOGTITO, 2, 38.5, 36.3);
		dataRead = new Scanner(System.in);
		//happypet.otherServiceRegistration(OtherService.PETWASHVET, date, idPet, idClient);

	}

	public void menu(int myOption) {

		int option = myOption;

		if (option == 0) {
			showMenuOptions();
			option = dataRead.nextInt();
			dataRead.nextLine();
		}

		if (option == 1) {
			System.out.println("Ingresa tu nombre");
			String name = dataRead.nextLine();
			System.out.println("Ingresa tu numero de identificacion");
			String identification = dataRead.nextLine();
			System.out.println("Ingresa tu direccion");
			String direction = dataRead.nextLine();
			System.out.println("Ingresa tu numero telefonico");
			String phoneNumber = dataRead.nextLine();
			System.out.println("Ingrese el nombre de su mascota");
			String petName = dataRead.nextLine();
			String animalType = "";
			int optionDataRead = 0;
			while (optionDataRead <= 0 || optionDataRead > 4) {
				System.out.println("Ingrese el tipo de animal de su mascota 1.Gato 2.Perro 3.Pajaro 4.Otro");
				optionDataRead = dataRead.nextInt();

				if (optionDataRead == 1) {
					animalType = Pets.CATITO;
				} else if (optionDataRead == 2) {
					animalType = Pets.DOGTITO;
				} else if (optionDataRead == 3) {
					animalType = Pets.BIRDTITO;
				} else if (optionDataRead == 4) {
					animalType = Pets.OTHERTITO;
				} else {
					System.out.println("INCORRECTO! sera retornado a registro de cliente");
				}
			}
			System.out.println("Ingrese la edad de su mascota");
			int age = dataRead.nextInt();
			dataRead.nextLine();
			System.out.println("Ingrese el peso de su mascota");
			double weight = dataRead.nextDouble();
			dataRead.nextLine();
			System.out.println("Ingrese la altura de su mascota");
			double height = dataRead.nextDouble();
			dataRead.nextLine();
			happypet.registerClientAndFirstPet(name, identification, direction, phoneNumber, petName, animalType, age,
					weight, height);

			addMorePets();
			menu(0);

			/*-----------------------------------------------------------------------------------------------------------*/

		} else if (option == 2) {
			addMorePets();
		} else if (option == 3) {
			System.out.println(happypet.findAvaibleRooms());
			menu(0);
		} else if (option == 5) {
			System.out.println("Historias Clinicas de los animales hospitalizados actualmente"
					+ happypet.showCurrentHospitalizedPets());
			menu(0);
		} else if (option == 4) {
			ClinicHistory createClinicHistory;
			boolean state = true;
			System.out.println("Seteo de fecha de ingreso a la miniRoom");
			System.out.println("Ingrese el dia de ingreso en numeros");
			String day = dataRead.nextLine();
			System.out.println("Ingrese el mes de ingreso en numeros");
			String month = dataRead.nextLine();
			System.out.println("Ingrese el año de ingreso en numeros");
			String year = dataRead.nextLine();
			Date date = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
			//System.out.println("Ingrese el numero de dias que el animal estara hospitalizado");
			//int hospitalizedDays = dataRead.nextInt();
			System.out.println("Escriba aqui el diagnostico que tiene las mascota");
			System.out.println("DIAGNOSTICO:");
			//dataRead.nextLine();
			String diagnose = dataRead.nextLine();
			System.out.println();
			System.out.println("Escriba los sintomas presentados en las mascota");
			System.out.println("SINTOMAS:");

			String symptom = dataRead.nextLine();
			System.out.println("Escriba aqui la identificacion del usuario");
			System.out.println("IDENTIFICACION");
			System.out.println("Ingrese el id del cliente");
			String idClient = dataRead.nextLine();
			Clients client = happypet.findClient(idClient);

			if (client == null) {
				System.out.println("El usuario ingresado no existe intente de nuevo");
				menu(4);
			} else {
				System.out.println("El nombre de usuario es: " + client.getName());
				System.out.println("Elige el numero de la mascota para la hospitalización: ");
				System.out.println(client.showPets());
				int numPet = Integer.parseInt(dataRead.nextLine());
				Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet - 1);

				if (selectedPet.getPetClinic() == null) {
					selectedPet.setClinicHistory(
							happypet.createClinicHistory(state, symptom, diagnose, date, selectedPet, client, 0, ""));
					System.out.println("No tiene historia clinica se procedera a crearla");
					int totalHospitalizationPrice = 0;
					if (selectedPet.getPetClinic().getMedicineRequiredOnDebut().size() == 0) {

						happypet.addPetToAnARoom(selectedPet);

					} else if (selectedPet.getPetClinic().getMedicineRequiredOnDebut().size() > 0) {

						System.out.println("Tengo medicina e historia clinica");

					}

					menu(0);
				} else {
					ClinicHistory clinic = selectedPet.getPetClinic();
					System.out.println("Tengo historia clinica agregare la nueva a data a la historia!");
					selectedPet.setClinicHistory(happypet.createClinicHistory(state, symptom, diagnose, date,
							selectedPet, client, 0, clinic.getAll()));
					happypet.addPetToAnARoom(selectedPet);
					menu(0);
				}
			}

		} else if (option == 6) {

			System.out.println("Ingresa el nombre de la medicina");
			String nameOfMedicine = dataRead.nextLine();
			System.out.println("Ingresa la cantidad de la dosis");
			double doseOfMedicine = dataRead.nextDouble();
			dataRead.nextLine();
			System.out.println("Ingresa el precio por dosis");
			double pricePerDoseOfMedicine = dataRead.nextDouble();
			dataRead.nextLine();
			System.out.println("Ingresa la frecuencia de administracion");
			int frecuencyOfAdministration = dataRead.nextInt();
			dataRead.nextLine();
			System.out.println(
					"Ingrese el id del cliente para seleccionar mascota con historia clinica y agregar medicina");
			String idClient = dataRead.nextLine();
			Clients client = happypet.findClient(idClient);
			if (client == null) {
				System.out.println("El usuario ingresado no existe intente de nuevo");
				menu(6);
			} else {
				System.out.println("El nombre de usuario es: " + client.getName());
				System.out.println("Elige el numero de la mascota para la asignacion de medicina: ");
				System.out.println(client.showPets());
				int numPet = Integer.parseInt(dataRead.nextLine());
				Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet - 1);
				if (selectedPet.getPetClinic().getMedicineRequiredOnDebut() == null) {
					System.out.println("No tiene medicina se procedera a agregarla");
					selectedPet.getPetClinic().saveMedicine(nameOfMedicine, doseOfMedicine, pricePerDoseOfMedicine,
							frecuencyOfAdministration);
				}
				addMoreMedicine(client, selectedPet);
			}

		} else if (option == 7) {
			System.out.println("Seleccione mascota que desea eliminar");
			System.out.println(happypet.showPetsAndMiniRooms());
			int roomNumber = dataRead.nextInt();

			// happypet.addClinicHistory(happypet.getMiniRoomsOnDebut()[roomNumber-1].getClinicHistoryOnRoomOnDebut());
			if (!happypet.getMiniRoomsOnDebut()[roomNumber - 1].getDisponibility()) {
				happypet.getMiniRoomsOnDebut()[roomNumber - 1].getClinicHistoryOnRoomOnDebut().setState(true);

				int totalDays = 0;
				System.out.println("Ingrese el dia actual (En numeros): ");
				int day = dataRead.nextInt(); // Activation of the scanner
				System.out.println("Ingrese el mes actual (En numeros): ");
				int month = dataRead.nextInt(); // Activation of the scanner
				System.out.println("Ingrese el año actual (En numeros): ");
				int year = dataRead.nextInt(); // Activation of the scanner
				System.out.println("Ingrese el dia de hospitalizacion (En numeros): ");
				int currentDay = dataRead.nextInt(); // Activation of the
														// scanner
				System.out.println("Ingrese el mes de hospitalizacion (En numeros): ");
				int currentMonth = dataRead.nextInt(); // Activation of the
														// scanner
				System.out.println("Ingrese el año de hospitalizacion (En numeros): ");
				int currentYear = dataRead.nextInt(); // Activation of the
														// scanner
				// Days Calculation
				Date hospitalizationDate = new Date(day, month, year);
				Date hurrentDate = new Date(currentDay, currentMonth, currentYear);

				System.out.println("Ingrese el numero de dias que el animal estara hospitalizado");
				int hospitalizedDays = happypet.calculateDate(hospitalizationDate, hurrentDate);
				int totalHospitalizationPrice = 0;

				System.out.println(
						"Ingrese el id del cliente para seleccionar mascota con historia clinica y agregar medicina");
				String idClient = dataRead.next();
				Clients client = happypet.findClient(idClient);
				System.out.println("El nombre de usuario es: " + client.getName());
				System.out.println("Elige el numero de la mascota para saber costo: ");
				System.out.println(client.showPets());
				int numPet = Integer.parseInt(dataRead.next());
				Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet - 1);
				totalHospitalizationPrice = (int) (((hospitalizedDays * selectedPet.getHospitalizationValue())));
				selectedPet.getPetClinic().setTotalHospitalizationPrice(totalHospitalizationPrice);
				System.out.println("Total costo de hospitalizacion: " + totalHospitalizationPrice);
				happypet.getMiniRoomsOnDebut()[roomNumber - 1].setDisponibility(true);
				happypet.getMiniRoomsOnDebut()[roomNumber - 1].setPetOnRoomDebut(null);
				happypet.getMiniRoomsOnDebut()[roomNumber - 1].setClinicHistoryOnRoomOnDebut(null);
				System.out.println("Se elimino exitosamente");

			} else {
				System.out.println("La sala esta vacia, no hay mascota que retirar");
			}

			menu(0);

		} else if (option == 8) {
			System.out.println("Los ingresos totales son" + happypet.calculateTotalIncomeofHospitalization());
			menu(0);
		} else if (option == 9) {
			System.out.println("Ingrese el id del cliente");
			String idClient = dataRead.nextLine();
			Clients client = happypet.findClient(idClient);
			// Hacer el metodo encontrar cliente
			if (idClient == null) {
				System.out.println("El usuario ingresado no existe intente de nuevo");
				menu(9);
			} else {
				System.out.println("El nombre de usuario es: " + client.getName());
				System.out.println("Elige el numero de la mascota para saber el cuarto en el cual se encuentra: ");
				System.out.println(client.showPets());
				int numPet = Integer.parseInt(dataRead.nextLine());
				Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet - 1);
				menu(0);
			}
		} else if (option == 10) {
			String save = "";
			System.out.println("Ingrese el numero de la macota");
			String petName = dataRead.nextLine();
			save = happypet.findClinicHistoryOfPetOnHistorialOfClinicHistory(petName);
			if (save.equals("")) {
				System.out.println("El usuario ingresado no existe intente de nuevo");
				menu(10);
			} else {
				System.out.println("Si ha tenido historia clinica");

			}

		} else if (option == 11) {
			System.out.println("Escriba: 1 si desea buscar los datos del cliente por su nombre 2 Si desea busacr lo datos por el nombre de la mascota");
			int optionDataRead = 0;
			String client = "";
			optionDataRead = dataRead.nextInt();
			dataRead.nextLine();
			if (optionDataRead == 1) {
				System.out.println("Ingrese el nombre del cliente");
				String clientName = dataRead.nextLine();
				client = happypet.findClientData(clientName);
				System.out.println(client);
			} else if (optionDataRead == 2) {
				System.out.println("Ingrese el nombre de la mascota del cliente");
				String petName = dataRead.nextLine();
				client = happypet.findClientDataWithPetName(petName);
				System.out.println(client);
			}
		}
		else if (option == 12)
		{
			System.out.println("Ingrese el id del cliente para seleccionar mascota con historia clinica y agregar medicina");
			String idClient = dataRead.nextLine();
			Clients client = happypet.findClient(idClient);
			if (client == null) 
			{
				System.out.println("El usuario ingresado no existe intente de nuevo");
				menu(12);
			} else 
			{
				System.out.println("El nombre de usuario es: " + client.getName());
				System.out.println("Elige el numero de la mascota para calcular el IMC: ");
				System.out.println(client.showPets());
				int numPet = Integer.parseInt(dataRead.nextLine());
				Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet - 1);
				System.out.println(selectedPet.calculateBMI());
			}
		}
		else if (option == 13) {
			//System.out.println("Escriba el nombre del cliente");
			//int optionDataRead = 0;
			String client = "";
			//optionDataRead = dataRead.nextInt();
			//dataRead.nextLine();
			
				System.out.println("Ingrese el nombre del cliente al cual le quiere actualizar la informacion");
				String clientName = dataRead.nextLine();
				client = happypet.findClientData(clientName);
				System.out.println(client);
				System.out.println("Ingrese el nuevo nombre del cliente");
				String newName = dataRead.nextLine();
				System.out.println("Ingrese la nueva identificacion del cliente");
				String newIdentification = dataRead.nextLine(); 
				System.out.println("Ingrese la nueva direccion del cliente");
				String newAddress = dataRead.nextLine();
				System.out.println("Ingrese el nuevo numero telefonico del cliente");
				String newPhone = dataRead.nextLine();
				client = happypet.updateClientData(clientName, newName, newIdentification, newAddress, newPhone);
				System.out.println(client);
		}
		else if (option == 14){
			System.out.println("REGISTAR REALIZACION DE UN SERVICIO");
			System.out.println("Porfavor seleccione el servicio que desea registrar");
			System.out.println("1." + OtherService.PETWASHVET + " 2." + OtherService.PETWASHHOME + " 3." + OtherService.NAILCUTTING + " 4." + OtherService.VACCINEAPPLICATION + " 5. " + OtherService.DENTALPROPHYLAXIS);
			String nameOfService = dataRead.nextLine();
			//happypet.otherServiceRegistration(OtherService.PETWASHVET, date, idPet, idClient);
			System.out.println("Ingrese el dia de la realizacion del servicio");
			int day = dataRead.nextInt(); dataRead.nextLine();
			System.out.println("Ingrese el mes de la realizacion del servicio");
			int month = dataRead.nextInt(); dataRead.nextLine();
			System.out.println("Ingrese el anio de la realizacion del servicio");
			int year = dataRead.nextInt(); dataRead.nextLine();
			System.out.println("Ingrese el id de la mascota");
			String idPet = dataRead.nextLine();
			System.out.println("Ingrese el id del cliente");
			String idClient = dataRead.nextLine();
			Date date = new Date(day, month, year); // <------------------------------------- CUIDADO PREGUNTAR DUDAS
			System.out.println(happypet.otherServiceRegistration(nameOfService, date, idPet, idClient));
			//System.out.println(happypet.otherServiceRegistration(nameOfService, date, idPet, idClient));
		}
		else if(option == 15){
			System.out.println("CALCULAR INGRESOS POR SERVICIOS");
			System.out.println("Los ingresos por servicios son " + happypet.calculateIncomeByServices());
		}
		else if(option == 16){
			System.out.println("Los ingresos totales son " + happypet.calculateTotalIncomeOfTheVet()); 
		}
		else if(option == 17){
			System.out.println("El promedio de ingresos por servicios " + happypet.averageIncomeByServices());
		}
		else if(option ==18){
			System.out.println("Por favor ingrese la fecha INICIAL a la cual quiere encontrar los ingresos promedio");
			System.out.println("Ingrese el dia en numeros");
			int dayI = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el mes en numeros");
			int monthI = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el anio en numeros");
			int yearI = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Por favor ingrese la fecha FINAL a la cual quiere encontrar los ingresos promedio");
			int dayF = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el mes en numeros");
			int monthF = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el anio en numeros");
			int yearF = dataRead.nextInt();dataRead.nextLine();
			happypet.totalAverageIncomeInAweek(dayI, monthI, yearI, dayF, monthF, yearF);
			/////////////////////////////////////////////////////////////////////////////////////////////////////
			//LOS DATOS QUE SE ENCUENTRAN COMENTADOS ACA ABAJO SIRVEN PARA EL METODO QUE RECIBE FECHAS Y NO DIAS INDIVIDUALMENTE
			////////////////////////////////////////////////////////////////////////////////////////////////////
			/*
			Date startingDate = new Date(dayI, monthI, yearI);
			Date finalDate = new Date(dayF, monthF, yearF);
			happypet.totalAverageIncomeInAweek(startingDate, finalDate);
			*/
		}
		else if(option == 19){
			System.out.println("Reporte de servicios prestados dada una fecha inicial y una fecha final");
			System.out.println("Por favor ingrese la fecha INICIAL a la cual quiere encontrar los servicios prestados");
			System.out.println("Ingrese el dia en numeros");
			int dayI = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el mes en numeros");
			int monthI = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el anio en numeros");
			int yearI = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Por favor ingrese la fecha FINAL a la cual quiere encontrar los los servicios prestados");
			int dayF = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el mes en numeros");
			int monthF = dataRead.nextInt();dataRead.nextLine();
			System.out.println("Ingrese el anio en numeros");
			int yearF = dataRead.nextInt();dataRead.nextLine();
			
		}
		menu(0);

	}

	public void addMorePets() {
		System.out.println("Desea agregar otra mascota?" + "1 Si / 2 No");
		int optionYesandNo = dataRead.nextInt();
		if (optionYesandNo == 1) {
			dataRead.nextLine();
			System.out.println("Ingrese el id del cliente");
			String idClient = dataRead.nextLine();
			Clients client = happypet.findClient(idClient);
			// Hacer el metodo encontrar cliente
			if (idClient == null) {
				System.out.println("El usuario ingresado no existe intente de nuevo");
				menu(2);
			} else {

				System.out.println("Ingrese el nombre de su mascota");
				String name = dataRead.nextLine();
				String animalType = "";
				int optionDataRead = 0;
				while (optionDataRead <= 0 && optionDataRead > 4) {
					System.out.println("Ingrese el tipo de animal de su mascota 1.Gato 2.Perro 3.Pajaro 4.Otro");
					optionDataRead = dataRead.nextInt();
					dataRead.nextLine();
					if (optionDataRead == 1) {
						animalType = Pets.CATITO;
					} else if (optionDataRead == 2) {
						animalType = Pets.DOGTITO;
					} else if (optionDataRead == 3) {
						animalType = Pets.BIRDTITO;
					} else if (optionDataRead == 4) {
						animalType = Pets.OTHERTITO;
					} else {
						System.out.println("INCORRECTO! sera retornado a registro de cliente");
					}
				}
				
				System.out.println("Ingrese la edad de su mascota");
				int age = dataRead.nextInt();
				System.out.println("Ingrese el peso de su mascota");
				double weight = dataRead.nextInt();
				System.out.println("Ingrese la altura de su mascota");
				double height = dataRead.nextInt();
				happypet.registerPets(name, animalType, age, weight, height, client);
				System.out.println("La mascota ha sido agregada exitosamente");
				menu(2);
			}
		} else {
			menu(0);
		}
	}

	public void showMenuOptions() {

		// User Interface this is what the user it's going to see
		System.out.println("Escriba el numero de la opcion que desea seleccionar");
		System.out.println("1.  Registro de clientes y mascotas"); // READY!
		System.out.println("2.  Agregar mascota a cliente ya existente"); // READY!
		System.out.println("3.  Saber disponibilidad de minicuartos"); // READY!
		System.out.println("4.  Hospitalizar mascota"); // READY!
		System.out.println("5.  Mostrar historias clinicas de los animales hospitalizados en el momento con su costo de hospitalizacion"); // READY!
		System.out.println("6.  Recetar medicamentos a una mascota");// READY!
		System.out.println("7.  Dar de alta una mascota hospitalizada y entregar informe liberar sala en la cual se encontraba Agregar historia eliminada a historial de historias clinicas");// READY!
		System.out.println("8.  Calcular ingresos por concepto de hospitalizaciones");// READY!
		System.out.println("9.  Identificar numero de cuarto que ocupa una mascota mediante su nombre");// READY!
		System.out.println("10. Consultar datos si un animal ya ha sido hospitalizado antes en historial de historias clinicas ");																												
		System.out.println("11. Consultar datos de contacto del dueño de un animal hospitalizado a partir del nombre de su dueño o el nombre del animal");// READY!
		System.out.println("12. Mostar IMC de una mascota ya creada");
		System.out.println("13. Actualizar informacion de un usuario");
		System.out.println("14. Registar realizacion de un servicio");
		System.out.println("15. Calcular ingresos por concepto de servicios");
		System.out.println("16. Calular todos los ingresos");
		System.out.println("17. Calcular promedio por servicios");


	}

	public void addMoreMedicine(Clients selectedClient, Pets selectedPet) {
		System.out.println("Desea agregar otra medicina?" + "1. Si / 2. No");
		int optionYesandNo = dataRead.nextInt();
		dataRead.nextLine();
		if (optionYesandNo == 1) {

			System.out.println("Ingresa el nombre de la medicina");
			String nameOfMedicine = dataRead.nextLine();
			System.out.println("Ingresa la cantidad de la dosis");
			double doseOfMedicine = dataRead.nextDouble();
			dataRead.nextLine();
			System.out.println("Ingresa el precio por dosis");
			double pricePerDoseOfMedicine = dataRead.nextDouble();
			dataRead.nextLine();
			System.out.println("Ingresa la frecuencia de administracion");
			int frecuencyOfAdministration = dataRead.nextInt();
			dataRead.nextLine();
			selectedPet.getPetClinic().saveMedicine(nameOfMedicine, doseOfMedicine, pricePerDoseOfMedicine,
					frecuencyOfAdministration);
			System.out.println("Se ha agregado la nueva medicina a " + selectedPet.getName());
			addMoreMedicine(selectedClient, selectedPet);
		} else {
			menu(0);
		}

	}
}