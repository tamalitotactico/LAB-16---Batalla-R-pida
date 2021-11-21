
public class Soldado {
	
	private String nombre;
	private int nivelAtaque;
	private int nivelDefensa;
	private int nivelVida;
	private int vidaActual;
	private int velocidad;
	private String actitud;
	private Boolean vive;

	private int fila;
	private int columna;
		
	public Soldado() {
		nivelAtaque=0;
		nivelDefensa=0;
		nivelVida=0;
		vidaActual=0;
		velocidad=0;
		actitud="Desconocido";
		vive=true;
	}
	
	public Soldado(String nombre) {
		this.nombre = nombre;
		nivelAtaque = (int)(Math.random()*5+1);
		nivelDefensa = (int)(Math.random()*5+1);
		nivelVida = 0;
		this.vidaActual = (int)(Math.random()*5+1);
		velocidad=0;
		actitud="Desconocido";
		vive=true;
	}
	
	// SET ---------------------------
	public void setNombre(String str) {
		nombre = str;
	}
	public void setNivelAtaque(int atclevel) {
		nivelAtaque = atclevel;
	}	
	public void setNivelAtaque(int deflevel,String act) {
		nivelDefensa = deflevel;
		actitud = act;
	}
	public void setNivelDefensa(int deflevel) {
		nivelDefensa = deflevel;
	}	
	public void setNivelDefensa(int deflevel,String act) {
		nivelDefensa = deflevel;
		actitud = act;
	}	
	public void setNivelVida(int lifelevel) {
		nivelVida = lifelevel;
	}	
	public void setNivelVida(int lifelevel,int hp) {
		nivelVida = lifelevel;
		vidaActual = hp;
	}	
	public void setVidaActual(int hp) {
		vidaActual = hp;
	}
	public void setVelocidad(int speed) {
		velocidad = speed;
	}
	public void setActitud(String act) {
		actitud = act;
	}	
	public void setVive(Boolean vida) {
		vive = vida;
	}	
	public void setFila(int fil) {
		fila = fil;
	}
	public void setColumna(int col) {
		columna = col;
	}
	
	// GET -------------------------
	
	public String getNombre() {
		return nombre;
	}
	public int getNivelAtaque() {
		return nivelAtaque;
	}	
	public int getNivelDefensa() {
		return nivelDefensa;
	}	
	public int getNivelVida() {
		return nivelVida;
	}	
	public int getVidaActual() {
		return vidaActual;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public String getActitud() {
		return actitud;
	}	
	public Boolean getVive() {
		return vive;
	}	
	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}
	
	// MÉTODOS ESPECIALES 
	
	public void atacar() {
		avanzar();
		actitud="Ofensivo";
	}
	
	public void defender() {
		retroceder();
	}
	
	public void avanzar() {
		velocidad=1;
	}
	public void retroceder() {
		if (velocidad>0) {
			velocidad=0;
			actitud="Defensivo";
		}
		else {
			velocidad--;
		}
	}
	public void serAtacado() {
		vidaActual--;
		if (vidaActual<=0) {
			morir();
		}
	}
	public void huir() {
		velocidad=2;
		actitud="Fuga";
	}
	public void morir() {
		vive=false;
	}
	/*
	nombre="Anonimo";
	nivelAtaque=0;
	nivelDefensa=0;
	nivelVida=0;
	vidaActual=0;
	velocidad=0;
	actitud="Desconocido";
	vive=true;*/
	public String toString() {
		return nombre+": Vida = "+vidaActual+" - Nivel de Ataque = "+
		nivelAtaque+" - Actitud = "+actitud+" - Estado = "+vive+"\n";
	}
}