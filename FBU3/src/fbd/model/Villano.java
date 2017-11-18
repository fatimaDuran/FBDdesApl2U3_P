package fbd.model;

public class Villano {
	private int id;
	private String colorBigote;
	private String  colorSombrero;
	private String  aspecto;
	
	
	public Villano(int id, String colorBigote, String colorSombrero, String aspecto) {
		super();
		this.id = id;
		this.colorBigote = colorBigote;
		this.colorSombrero = colorSombrero;
		this.aspecto = aspecto;
	}
	
	public Villano() {
		this(0,"","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColorBigote() {
		return colorBigote;
	}

	public void setColorBigote(String colorBigote) {
		this.colorBigote = colorBigote;
	}

	public String getColorSombrero() {
		return colorSombrero;
	}

	public void setColorSombrero(String colorSombrero) {
		this.colorSombrero = colorSombrero;
	}

	public String getAspecto() {
		return aspecto;
	}

	public void setAspecto(String aspecto) {
		this.aspecto = aspecto;
	}

	@Override
	public String toString() {
		return "Villano [id=" + id + ", colorBigote=" + colorBigote + ", colorSombrero=" + colorSombrero + ", aspecto="
				+ aspecto + "]";
	}
	
	
	

}
