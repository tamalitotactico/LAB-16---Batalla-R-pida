import java.util.ArrayList;

public class Ejercito {

	private String reyno;
	private ArrayList<Soldado> misSoldados = new ArrayList<Soldado>();
	int iteradorSoldados = 0;
	
	public Ejercito() {
		reyno = "Sin reyno";
	}
	
	public Ejercito(String reyno) {
		this.reyno = reyno;
	}
	
	//public Soldado(String nombre, int Ataque, int Defensa, int vidaActual)
	public void agregarSoldado(){
		String nombre = "SoldadoAutogenerado"+iteradorSoldados;
		Soldado soldadoAutogenerado = new Soldado(nombre);
		misSoldados.add(soldadoAutogenerado);
		iteradorSoldados++;
	}
	
	public void agregarSoldado(Soldado soldado) {
		misSoldados.add(soldado);
	}
	
	public Soldado SoldadoFuerte() {
		Soldado fuerte1 = new Soldado();
		fuerte1.setVidaActual(0);
		for (int i = 0; i<misSoldados.size(); i++) {
			if (misSoldados.get(i).getVidaActual()>fuerte1.getVidaActual()) {
				fuerte1.setVidaActual(misSoldados.get(i).getVidaActual());
				fuerte1.setNombre(misSoldados.get(i).getNombre());
			}
		}
		return fuerte1;
	}
	
	public String getNombre() {
		return reyno;
	}
	
	public ArrayList<Soldado>getArrayReyno(){
		return misSoldados;
	}
	
	public String toString() {
		return misSoldados.toString();
	}
}
