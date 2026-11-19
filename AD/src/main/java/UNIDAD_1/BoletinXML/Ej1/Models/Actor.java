package UNIDAD_1.BoletinXML.Ej1.Models;

public class Actor {
	private String actor;
	
	public Actor(String actor) {
		super();
		this.actor = actor;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Actor [actor=" + actor + "]";
	}
	
}
