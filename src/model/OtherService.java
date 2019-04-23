package model;

public class OtherService 
{
	public static final String PETWASHVET = "Baño de mascotas en la veterinaria";
	public static final String PETWASHHOME = "Baño de mascotas a domicilio";
	public static final String NAILCUTTING = "Corte de uñas";
	public static final String VACCINEAPPLICATION = "Aplicacion de vacunas";
	public static final int PETWASHVETCOST = 20000;
	public static final int PETWASHHOMECOST = 30000;
	public static final int NAILCUTTINGCOST = 8000;
	public static final int VACCINEAPPLICATIONCOST = 45000;
	private String name;
	private double cost;
	
	public OtherService(String name, double cost) {
		this.cost = cost;
		switch (this.name) {
		case PETWASHVET:
			cost = PETWASHVETCOST;
			break;
		case PETWASHHOME:
			cost = PETWASHHOMECOST;
			break;
		case NAILCUTTING:
			cost = NAILCUTTINGCOST;
			break;
		case VACCINEAPPLICATION:
			cost = VACCINEAPPLICATIONCOST;
			break;
		}

	}
}
