package EsbaAulaVirtual;

import java.util.ArrayList;

public class ClasePersonas {
	//variables
	private String nombre;
    private long dni;
    private String carrera;
    private int legajo;
    private String facultad;
    private ArrayList<String> materias;
    private String tipo; // alumno o profesor
    
    // variable LegajoSum, es unica para cada alumno y profesor, y se suma cada vez que se crea un alumno o profesor
    private static int legajoSum = 0;
    
    // constructor
	public ClasePersonas(String nombre,long dni,String carrera,String facultad,String tipo) {
		this.nombre = nombre;
		this.dni = dni;
		this.carrera = carrera;
		this.facultad = facultad;
		this.legajo = ++legajoSum; //al crear un alumno nuevo, se incrementa su legajo en 1.
		this.materias = new ArrayList<>(); // inicializamos el arraylist materias vacio
		this.tipo = tipo; // alumno o profesor
	}
	
	//getter y setter
	
	public String getNombre() { // retorna el nombre para el alumno o profesor
        return nombre;
    }
	public void setNombre(String nombre) { // setea el nombre para el alumno o profesor
        this.nombre = nombre;
    }
	
    public long getDni() { // retorna el DNI para el alumno o profesor
        return dni;
    }
    public void setDni(long dni) { // setea el DNI para el alumno o profesor
        this.dni = dni;
    }
    
    public String getCarrera() { // retorna la carrera para el alumno o profesor
        return carrera;
    }
    public void setCarrera(String carrera) { // setea la carrera para el alumno o profesor
        this.carrera = carrera;
    }

    public String getFacultad() { // retorna la facultad para el alumno o profesor
        return facultad;
    }
    public void setFacultad(String facultad) { // setea el nombre de la facultad para el alumno o profesor
        this.facultad = facultad;
    }
    
    // metodo get legajo
    public int getLegajo() { // retorna el legajo del profesor o alumno
    	return legajo;    
    }
    
    public ArrayList<String> getMaterias() { // retorna las materias para un alumno o profesor en particular
        return materias;
    }
    public void setModMaterias(int numM,String MateriaMod) { // modifica las materias dentro del arraylist
    	this.materias.set(numM, MateriaMod); // numM es el indice del arraylist a modificar y MateriaMod es el nuevo nombre
    }
    public void setMaterias(ArrayList<String> materias) { // setea materias para un alumno o profesor en particular
        this.materias = materias;
    }
    public void agregarMateriaP(String materia) { // agrega materia al arreglo materias
    	this.materias.add(materia);
    }
    public int getMateriasP() { // devuelve cantidad de elementos en un arreglo dinamico como arraylist
    	return this.materias.size();
    }
    public void delMaterias(int nuM) { // elimina materia
    	this.materias.remove(nuM);
    }

    public String getTipo() { // devuelve el tipo, si es alumno o profesor
    	return tipo;
    }
    // info para alumno o profesor
    public void info() {
        System.out.print(tipo+" Nombre: " + nombre + "\n");
        System.out.print("DNI: " + dni + "\n");
        System.out.print("Legajo n°: " +legajo+ "\n");
        if(tipo == "Alumno") {
        	System.out.print("Cursando la/s materia/s: \n");
        } else if(tipo == "Profesor") {
        	System.out.print("Enseñando la/s materia/s: \n");
        }
        for (int mates = 0; mates < materias.size(); ++mates) {
            System.out.println("   " + mates + ": " + materias.get(mates));
        }
    }
}
