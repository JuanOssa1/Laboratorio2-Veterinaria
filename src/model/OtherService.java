package model;

public class OtherService 
{
	public static final int MAXTYPESOFSERVICES = 5;
	public static final String PETWASHVET = "Baño de mascotas en la veterinaria";
	public static final String PETWASHHOME = "Baño de mascotas a domicilio";
	public static final String NAILCUTTING = "Corte de uñas";
	public static final String VACCINEAPPLICATION = "Aplicacion de vacunas";
	public static final String DENTALPROPHYLAXIS = "Profilaxis dental";
	public static final int PETWASHVETCOST = 20000;
	public static final int PETWASHHOMECOST = 30000;
	public static final int NAILCUTTINGCOST = 8000;
	public static final int DENTALPROPHYLAXISCOST = 12000;
	public static final int VACCINEAPPLICATIONCOST = 45000;
	private String name;
	private double cost;
	private Date date;
	private String idPet;
	private String  idClient;
	public OtherService(String name, Date date, String idPet,  String idClient) {
		
		if(name.equals("1")) {
			this.name = PETWASHVET;
		}
		else if(name.equals("2")){
			this.name = PETWASHHOME;
		}
		else if(name.equals("3")){
			this.name = NAILCUTTING;
		}
		else if(name.equals("4")) {
			this.name = VACCINEAPPLICATION;
		}
		else if(name.equals("5")) {
			this.name = DENTALPROPHYLAXIS;
		}
		
		if(name.equals("1")){
			this.cost = PETWASHVETCOST;
		}
		else if(name.equals("2")){
			this.cost = PETWASHHOMECOST;
		}
		else if(name.equals("3")){
			this.cost = NAILCUTTINGCOST;
		}
		else if(name.equals("4")){
			this.cost = VACCINEAPPLICATIONCOST;
		}
		else if(name.equals("5")){
			this.cost = DENTALPROPHYLAXISCOST;
		}
		/*
		if(name == PETWASHVET){
			cost = PETWASHVETCOST;
		}
		else if(name == PETWASHHOME ){
			cost = PETWASHHOMECOST;
		}
		else if(name == NAILCUTTING){
			cost = NAILCUTTINGCOST;
		}
		else if(name == VACCINEAPPLICATION){
			cost = VACCINEAPPLICATIONCOST;
		}
		*/
		  this.date = date;
		  this.idPet = idPet;
		  this.idClient = idClient;

		}
		public String getName(){
			return name;
		}
		public void setName(String newName){
			name = newName;
		}
		public double getCost(){
			return cost; 
		}
		public void setCost(double newCost){
			cost = newCost;
		}
		public Date getDate(){
			return date;
		}
}
