import java.util.ArrayList;
import java.util.Scanner;

public class Videojuego {
	public static void main (String [] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Ejercito> reynos = new ArrayList<Ejercito>();
				
		for (;;) {
			System.out.println("--- ¡Bienvenido al juego de Guerra! ---\n");
			System.out.println("¿Que desea hacer? (Crear ejercitos personalizados = 0 ; Batalla rápida = 1"
					+ " ; Cerrar juego = 2)");
			int desition = sc.nextInt();
			if (desition == 0) {
				menuDeEjercitos(reynos);
			}
			if (desition == 1) {
				batallaRapida();
			}
			else {
				System.out.println("El juego ha sido cerrado :(");
				break;
			}
		}
	}
	
	public static void menuDeEjercitos(ArrayList<Ejercito> reynos) {
		
		Scanner sc = new Scanner(System.in);
		
		for (boolean bool = true;bool;) {
			System.out.println("Crear ejercito = 0 ; Gestionar ejercitos = 1 ; Terminar = 2");
			int opciones1 = sc.nextInt();
			
			switch(opciones1) {
				case 0: {
					System.out.println("Ingrese el nombre del Reyno");
					Ejercito ejercitoNuevo = new Ejercito(sc.next());
					reynos.add(ejercitoNuevo);
				}
				break;
				case 1: {
					System.out.println("Ver todos los reynos = 0 ; Ver todos los reynos detallados = 1 "
							+ "; Expulsar jugador (Eliminar reyno) = 2");
					int opciones2 = sc.nextInt();
					switch(opciones2) {
						case 0: {
							for (Ejercito key : reynos) {
								System.out.println(key.getNombre()+"\n");
							}
						}
						break;
						case 1: {
							for (Ejercito key : reynos) {
								System.out.println(key.getNombre()+"\n");
								System.out.print(key.toString());
							}	
						}
						case 2: {
							for (Ejercito key : reynos) {
								System.out.println(key.getNombre()+"\t Código: "+reynos.indexOf(key) +"\n");
							}
							System.out.println("Ingrese el código del reyno a eliminar");
							reynos.remove(sc.nextInt());
						}
					}
				}
				break;
				case 2: {
					bool = false;
				}
				break;
			}
		}
	}
	
	public static void batallaRapida() {
		
		Soldado[][] tablero = new Soldado[10][10];
		Ejercito ejercitobr1 = new Ejercito("| BR - Ejercito 1 |");
		Ejercito ejercitobr2 = new Ejercito("| BR - Ejercito 1 |");
		
		for (int i=0;i<10;i++) {
			String nombre1 = "Soldado "+i+" - Ejercito 1";
			String nombre2 = "Soldado "+i+" - Ejercito 2";
			Soldado sold1 = new Soldado(nombre1);
			datosSoldados(sold1,tablero);
			Soldado sold2 = new Soldado(nombre2);
			datosSoldados(sold2,tablero);
			ejercitobr1.agregarSoldado(sold1);
			ejercitobr2.agregarSoldado(sold2);			
		}
		System.out.println(ejercitobr1.toString());
		System.out.println(ejercitobr2.toString());
		
		imprimirTablero(ejercitobr1,ejercitobr2);
	}
	
	public static void datosSoldados(Soldado soldado,Soldado[][]tablero) {
		
		int vida=0,fila=0,columna=0,ataque=0,defensa=0;
	
		for (;;) {
				
			vida = (int)(Math.random()*5+1);
			fila = (int)(Math.random()*10);
			columna = (int)(Math.random()*10);
			ataque = (int)(Math.random()*5+1);
			defensa = (int)(Math.random()*5+1);	
				
			soldado.setVidaActual(vida);
			soldado.setFila(fila);
			soldado.setColumna(columna);
			soldado.setNivelAtaque(ataque);
			soldado.setNivelDefensa(defensa);		
			soldado.setVive(true);		

			if (comprobarPosicionSoldado(tablero,fila,columna)) {
				break;
			}
		}	
		tablero[fila][columna]=soldado;
	}
	

	public static boolean comprobarPosicionSoldado(Soldado [][]campo,int fila,int columna) {
		if (campo[fila][columna]==null) {
			return true; //Esta vacío?
		}
		return false;
	}
	
	public static void imprimirTablero(Ejercito reyno1,Ejercito reyno2) {
		System.out.println("Campo de Batalla:");
		ArrayList<Soldado>ejercito1 = new ArrayList<Soldado>();
		ArrayList<Soldado>ejercito2 = new ArrayList<Soldado>();

		ejercito1 = reyno1.getArrayReyno();
		ejercito2 = reyno2.getArrayReyno();
		
		for (int i=0;i<ejercito1.size();i++) {
			for (int j=0;j<ejercito1.size();j++) {
				
				int aux=0;
				for (int k=0;k<ejercito1.size();k++) {
					if (ejercito1.get(k).getColumna()==j && ejercito1.get(k).getFila()==i) {
						if (ejercito1.get(k).getVive()==true) {
							System.out.print("(E1-"+ejercito1.get(k).getVidaActual()+")\t");
							aux++;
						}
					}
				}
				
				for (int k=0;k<ejercito2.size();k++) {
					if (ejercito2.get(k).getColumna()==j && ejercito2.get(k).getFila()==i) {
						if (ejercito2.get(k).getVive()==true) {
							System.out.print("(E2-"+ejercito2.get(k).getVidaActual()+")\t");
							aux++;
						}
					}
				}
				if (aux == 0) {
					System.out.print("(---)\t");
				}
			}
			System.out.println();
		}
		
		ejercitoGanador(ejercito1,ejercito2,reyno1,reyno2);
	}
	
	public static void ejercitoGanador(ArrayList<Soldado>ejercito1,ArrayList<Soldado>ejercito2,
			Ejercito reyno1, Ejercito reyno2) {
		
		int sume1=0,sume2=0,podertotal1=0,podertotal2=0;
		for (int i = 0;i<ejercito1.size();i++) {
			sume1 += ejercito1.get(i).getVidaActual();
			sume2 += ejercito2.get(i).getVidaActual();
			podertotal1 += ejercito1.get(i).getNivelAtaque();
			podertotal2 += ejercito2.get(i).getNivelAtaque();
		}
		
		imprimirGanador(sume1,sume2);
		System.out.println("Métrica usada: Vida total del ejercito (Suma de la vida total de los ejercitos)");

		int vidaSF1 = reyno1.SoldadoFuerte().getVidaActual()-reyno2.SoldadoFuerte().getNivelAtaque();
		int vidaSF2 = reyno2.SoldadoFuerte().getVidaActual()-reyno1.SoldadoFuerte().getNivelAtaque();
		
		imprimirGanador(vidaSF1,vidaSF2);
		System.out.println("Métrica usada: Soldados más fuertes se enfrentan (Vida de uno menos el daño del otro)");

		imprimirGanador(podertotal1,podertotal2);
		System.out.println("Métrica usada: Poder (Ejercito con la sumatoria de nivel de Ataque mayor)");
	}
	
	public static void imprimirGanador(int e1, int e2) {
		System.out.println("\n---------------------------------------------");
		if (e1>e2) {
			System.out.println("¡¡¡EL GANADOR ES EL EJERCITO 1!!!");
		}
		else {
			System.out.println("¡¡¡EL GANADOR ES EL EJERCITO 2!!!");
		}
	}
}
