package ui;
import model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	private Scanner dataRead;
	private Veterinary happypet;
	
	public Main()
	{
		init();	
	}
	
	
	public static void main(String args[])
	{
		Main m = new Main();
		m.menu(0);
	}
	public void init()
	{
		Pets pet1 = new Pets("Carlitos", Pets.DOGTITO, 23, 4.1);
		Clients client1 = new Clients("Karen", "100", "Carrera9", "1100545");
		Date date = new Date(1 , 8 , 2019); 
		happypet = new Veterinary("happypet");
		happypet.registerClientAndFirstPet("Karen Lara", "123456", "Calle siempre viva", "325461", "Horus", Pets.DOGTITO, 2, 38.5);
		happypet.registerClientAndFirstPet("Shrek", "12345678", "Calle siempre alegre", "551", "burro", Pets.DOGTITO, 2, 38.5);
		happypet.registerClientAndFirstPet("Shrek camilo", "123456789", "Calle siempre masomneos", "325452", "CamiloJoseMontoyaAbadia", Pets.DOGTITO, 2, 38.5);
		happypet.addClinicHistory(new ClinicHistory(false, "hhhhhhhhh", "hhhhhhhhhhhhh", date, pet1, client1, 0, "xdddd"));
		dataRead = new Scanner(System.in);
		
	}
	public void menu(int myOption)
	{
		
				int option = myOption;
			     
					if(option == 0)
					{
						showMenuOptions();
						option = dataRead.nextInt();
						dataRead.nextLine();
					}
					
				if (option == 1)
				{
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
						String animalType =  "";
						int optionDataRead = 0;
						while(optionDataRead <= 0 || optionDataRead >4)
						{
						System.out.println("Ingrese el tipo de animal de su mascota 1.Gato 2.Perro 3.Pajaro 4.Otro");
						optionDataRead = dataRead.nextInt();
						
							if(optionDataRead == 1)
							{
								 animalType = Pets.CATITO;
							}
							else if (optionDataRead == 2)
							{
								 animalType = Pets.DOGTITO;
							}
							else if (optionDataRead == 3)
							{
								 animalType = Pets.BIRDTITO;
							}
							else if (optionDataRead == 4)
							{
								 animalType = Pets.OTHERTITO;
							}
							else
							{
								System.out.println("INCORRECTO! sera retornado a registro de cliente");
							}
						}
						System.out.println("Ingrese la edad de su mascota");
						int age = dataRead.nextInt(); dataRead.nextLine();
						System.out.println("Ingrese el peso de su mascota");
						double weight = dataRead.nextInt(); dataRead.nextLine();
						happypet.registerClientAndFirstPet(name, identification, direction, phoneNumber,petName, animalType, age, weight);

						addMorePets();
						menu(0);
						
						/*-----------------------------------------------------------------------------------------------------------*/
						
				}
				else if (option == 2)
				{
					addMorePets();
				}
				else if (option == 3)
				{
					System.out.println(happypet.findAvaibleRooms());
					menu(0);
				}
				else if (option == 5)
				{
				 System.out.println("Historias Clinicas de los animales hospitalizados actualmente" + happypet.showCurrentHospitalizedPets());     
				 menu(0);
				}
				else if (option == 4)
				{
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
					System.out.println("Ingrese el numero de dias que el animal estara hospitalizado");
					int hospitalizedDays = dataRead.nextInt();
					System.out.println("Escriba aqui el diagnostico que tiene las mascota");
					System.out.println("DIAGNOSTICO:");dataRead.nextLine();
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
					
					if(client == null )
					{
						System.out.println("El usuario ingresado no existe intente de nuevo");
						menu(4);
					}
					else
					{
						System.out.println("El nombre de usuario es: " + client.getName());
						System.out.println("Elige el numero de la mascota para la hospitalización: ");
						System.out.println(client.showPets());
						int numPet = Integer.parseInt(dataRead.nextLine());
						Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet-1);
					
						
						if(selectedPet.getPetClinic() == null)
						{
							selectedPet.setClinicHistory(happypet.createClinicHistory(state, symptom, diagnose, date, selectedPet, client, 0,""));
							System.out.println("No tiene historia clinica se procedera a crearla");
							int totalHospitalizationPrice = 0;
							if(selectedPet.getPetClinic().getMedicineRequiredOnDebut().size() == 0)
							{
								
								happypet.addPetToAnARoom(selectedPet);
								
							
							}
							else if (selectedPet.getPetClinic().getMedicineRequiredOnDebut().size() > 0)
							{
							
								System.out.println("Tengo medicina e historia clinica");
								
								
							}
							
							menu(0);
						}
						else
						{
							ClinicHistory clinic = selectedPet.getPetClinic();
							System.out.println("Tengo historia clinica agregare la nueva a data a la historia!");
							selectedPet.setClinicHistory(happypet.createClinicHistory(state, symptom, diagnose, date, selectedPet, client, 0,clinic.getAll()));
							happypet.addPetToAnARoom(selectedPet);
							menu(0);
						}
					}
					
					
					
				}
				else if (option == 6)
				{
					
					System.out.println("Ingresa el nombre de la medicina");
					String nameOfMedicine = dataRead.nextLine();
					System.out.println("Ingresa la cantidad de la dosis");
					double doseOfMedicine = dataRead.nextDouble();dataRead.nextLine();
					System.out.println("Ingresa el precio por dosis");
					double pricePerDoseOfMedicine = dataRead.nextDouble();dataRead.nextLine();
					System.out.println("Ingresa la frecuencia de administracion");
					int frecuencyOfAdministration = dataRead.nextInt();dataRead.nextLine();
					System.out.println("Ingrese el id del cliente para seleccionar mascota con historia clinica y agregar medicina");
					String idClient = dataRead.nextLine();
					Clients client = happypet.findClient(idClient);
					if(client == null )
					{
						System.out.println("El usuario ingresado no existe intente de nuevo");
						menu(6);
					}
					else
					{
						System.out.println("El nombre de usuario es: " + client.getName());
						System.out.println("Elige el numero de la mascota para la asignacion de medicina: ");
						System.out.println(client.showPets());
						int numPet = Integer.parseInt(dataRead.nextLine());
						Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet-1);
						if(selectedPet.getPetClinic().getMedicineRequiredOnDebut() == null)
						{
							System.out.println("No tiene medicina se procedera a agregarla");
							selectedPet.getPetClinic().saveMedicine(nameOfMedicine, doseOfMedicine, pricePerDoseOfMedicine, frecuencyOfAdministration);
						}
						addMoreMedicine(client, selectedPet);
					}
					
					
					
				}
				else if (option == 7)
				{
					System.out.println("Seleccione mascota que desea eliminar");
					System.out.println(happypet.showPetsAndMiniRooms());
					int roomNumber = dataRead.nextInt();
					
					//happypet.addClinicHistory(happypet.getMiniRoomsOnDebut()[roomNumber-1].getClinicHistoryOnRoomOnDebut());
					if(!happypet.getMiniRoomsOnDebut()[roomNumber-1].getDisponibility())
					{
						happypet.getMiniRoomsOnDebut()[roomNumber-1].getClinicHistoryOnRoomOnDebut().setState(true);
						
						
						
						int totalDays = 0;
						System.out.println("Ingrese el dia actual (En numeros): ");
						int day = dataRead.nextInt(); //Activation of the scanner
						System.out.println("Ingrese el mes actual (En numeros): ");
						int month = dataRead.nextInt(); //Activation of the scanner
						System.out.println("Ingrese el año actual (En numeros): ");
						int year = dataRead.nextInt(); //Activation of the scanner
						System.out.println("Ingrese el dia de hospitalizacion (En numeros): ");
						int currentDay = dataRead.nextInt(); //Activation of the scanner
						System.out.println("Ingrese el mes de hospitalizacion (En numeros): ");
						int currentMonth = dataRead.nextInt(); //Activation of the scanner
						System.out.println("Ingrese el año de hospitalizacion (En numeros): ");
						int currentYear = dataRead.nextInt(); //Activation of the scanner
						//Days Calculation 
						Date hospitalizationDate = new Date(day, month, year);
						Date hurrentDate = new Date(currentDay, currentMonth, currentYear);
							
					
						
						
						System.out.println("Ingrese el numero de dias que el animal estara hospitalizado");
						int hospitalizedDays = happypet.calculateDate(hospitalizationDate,hurrentDate);
						int totalHospitalizationPrice = 0;
						
						System.out.println("Ingrese el id del cliente para seleccionar mascota con historia clinica y agregar medicina");
						String idClient = dataRead.next();
						Clients client = happypet.findClient(idClient);
						System.out.println("El nombre de usuario es: " + client.getName());
						System.out.println("Elige el numero de la mascota para saber costo: ");
						System.out.println(client.showPets());
						int numPet = Integer.parseInt(dataRead.next());
						Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet-1);
						totalHospitalizationPrice = (int)(((hospitalizedDays * selectedPet.getHospitalizationValue())));
						selectedPet.getPetClinic().setTotalHospitalizationPrice(totalHospitalizationPrice);
						System.out.println("Total costo de hospitalizacion: " + totalHospitalizationPrice);
						happypet.getMiniRoomsOnDebut()[roomNumber-1].setDisponibility(true);
						happypet.getMiniRoomsOnDebut()[roomNumber-1].setPetOnRoomDebut(null);
						happypet.getMiniRoomsOnDebut()[roomNumber-1].setClinicHistoryOnRoomOnDebut(null);
						System.out.println("Se elimino exitosamente");
							
					}
					else
					{
						System.out.println("La sala esta vacia, no hay mascota que retirar");
					}
					
					menu(0);
					
					
				}
				else if (option == 8)
				{
					System.out.println("Los ingresos totales son" + happypet.calculateTotalIncomeofHospitalization());
					menu(0);
				}
				else if (option == 9)
				{
					System.out.println("Ingrese el id del cliente");
					String idClient = dataRead.nextLine();
					Clients client = happypet.findClient(idClient);
					//Hacer el metodo encontrar cliente 
					if(idClient == null )
					{
						System.out.println("El usuario ingresado no existe intente de nuevo");
						menu(9);
					}
					else
					{
						System.out.println("El nombre de usuario es: " + client.getName());
						System.out.println("Elige el numero de la mascota para saber el cuarto en el cual se encuentra: ");
						System.out.println(client.showPets());
						int numPet = Integer.parseInt(dataRead.nextLine());
						Pets selectedPet = client.getPetsofClientsOnDebut().get(numPet-1);
						menu(0);
					}
				}
				else if (option == 10)
				{
					String save = "";
					System.out.println("Ingrese el numbre de la mascota");
					String petName = dataRead.nextLine();
					save = happypet.findClinicHistoryOfPetOnHistorialOfClinicHistory(petName);
					if( save.equals("") )
					{
						System.out.println("El usuario ingresado no existe intente de nuevo");
						menu(10);
					}
					else 
					{
						System.out.println("Si ha tenido historia clinica");
						
					}
				
				}
				else if (option == 11)
				{
					System.out.println("Escriba: 1 si desea buscar los datos del cliente por su nombre 2 Si desea busacr lo datos por el nombre de la mascota");
					int optionDataRead = 0;
					String client = "";
					optionDataRead = dataRead.nextInt();
					dataRead.nextLine();
					if(optionDataRead == 1)
					{
						System.out.println("Ingrese el nombre del cliente");
						String clientName = dataRead.nextLine();
						 client = happypet.findClientData(clientName);
						 System.out.println(client);
					}
					else if(optionDataRead == 2)
					{
						System.out.println("Ingrese el nombre de la mascota del cliente");
						String petName = dataRead.nextLine();
						 client = happypet.findClientDataWithPetName(petName);
						 System.out.println(client);
					}
				}
			
	}
	public void addMorePets()
	{
		System.out.println("Desea agregar otra mascota?" + "1 Si / 2 No");
						int optionYesandNo = dataRead.nextInt();
						if(optionYesandNo == 1)
						{
							dataRead.nextLine();
							System.out.println("Ingrese el id del cliente");
							String idClient = dataRead.nextLine();
							Clients client = happypet.findClient(idClient);
							//Hacer el metodo encontrar cliente 
							if(idClient == null )
							{
								System.out.println("El usuario ingresado no existe intente de nuevo");
								menu(2);
							}
							else
							{
							
							
								System.out.println("Ingrese el nombre de su mascota");
								String name = dataRead.nextLine();
								String animalType =  "";
								int optionDataRead = 0;
								while(optionDataRead <= 0 && optionDataRead >4) 
								{
									System.out.println("Ingrese el tipo de animal de su mascota 1.Gato 2.Perro 3.Pajaro 4.Otro");
									optionDataRead = dataRead.nextInt(); dataRead.nextLine();
									if(optionDataRead == 1)
									{
										 animalType = Pets.CATITO;
									}
									else if (optionDataRead == 2)
									{
										 animalType = Pets.DOGTITO;
									}
									else if (optionDataRead == 3)
									{
										 animalType = Pets.BIRDTITO;
									}
									else if (optionDataRead == 4)
									{
										 animalType = Pets.OTHERTITO;
									}
									else
									{
										System.out.println("INCORRECTO! sera retornado a registro de cliente");
									}
								}
								System.out.println("Ingrese la edad de su mascota");
								int age = dataRead.nextInt();
								System.out.println("Ingrese el peso de su mascota");
								double weight = dataRead.nextInt();
								happypet.registerPets(name, animalType, age, weight, client);
								System.out.println("La mascota ha sido agregada exitosamente");
								menu(2);
							}
						}
						else
						{
							menu(0);
						}	
	}
	
	public void showMenuOptions()
	{
		
			//User Interface this is what the user it's going to see
				System.out.println("Escriba el numero de la opcion que desea seleccionar");
				System.out.println("1.  Registro de clientes y mascotas"); //READY!
				System.out.println("2.  Agregar mascota a cliente ya existente"); //READY!
				System.out.println("3.  Saber disponibilidad de minicuartos"); //READY!
				System.out.println("4.  Hospitalizar mascota"); //READY!
				System.out.println("5.  Mostrar historias clinicas de los animales hospitalizados en el momento con su costo de hospitalizacion"); //READY!
				System.out.println("6.  Recetar medicamentos a una mascota");//READY!
				System.out.println("7.  Dar de alta una mascota hospitalizada y entregar informe liberar sala en la cual se encontraba Agregar historia eliminada a historial de historias clinicas");//READY! 
				System.out.println("8.  Calcular ingresos por concepto de hospitalizaciones");//READY!
				System.out.println("9.  Identificar numero de cuarto que ocupa una mascota mediante su nombre");//READY!
				System.out.println("10. Consultar datos si un animal ya ha sido hospitalizado antes en historial de historias clinicas ");//OPERATOR ERROR ¡MOLTEN CORE WARNIG! CHECK
				System.out.println("11. Consultar datos de contacto del dueño de un animal hospitalizado a partir del nombre de su dueño o el nombre del animal");//READY!
				
	}
	
	public void addMoreMedicine(Clients selectedClient, Pets selectedPet)
	{
		System.out.println("Desea agregar otra medicina?" + "1. Si / 2. No");
		int optionYesandNo = dataRead.nextInt();dataRead.nextLine();
		if(optionYesandNo == 1)
		{
			
			System.out.println("Ingresa el nombre de la medicina");
			String nameOfMedicine = dataRead.nextLine();
			System.out.println("Ingresa la cantidad de la dosis");
			double doseOfMedicine = dataRead.nextDouble();dataRead.nextLine();
			System.out.println("Ingresa el precio por dosis");
			double pricePerDoseOfMedicine = dataRead.nextDouble();dataRead.nextLine();
			System.out.println("Ingresa la frecuencia de administracion");
			int frecuencyOfAdministration = dataRead.nextInt();dataRead.nextLine();
			selectedPet.getPetClinic().saveMedicine(nameOfMedicine, doseOfMedicine, pricePerDoseOfMedicine, frecuencyOfAdministration);
			System.out.println("Se ha agregado la nueva medicina a " + selectedPet.getName());
			addMoreMedicine(selectedClient, selectedPet);
		}
		else
		{
			menu(0);
		}
			
			
			
		
	}
}