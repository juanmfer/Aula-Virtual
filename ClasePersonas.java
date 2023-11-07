

import java.util.ArrayList;

public class ClasePersonas {
	private String nombre;
    private long dni;
    private String carrera;
    private int legajo;
    private String facultad;
    private ArrayList<String> materias;
    private String tipo; // alumno o profesor
    
    private static int legajoSum = 0;

	public ClasePersonas(String nombre,long dni,String carrera,String facultad,String tipo) {
		this.nombre = nombre;
		this.dni = dni;
		this.carrera = carrera;
		this.facultad = facultad;
		this.legajo = ++legajoSum; //al crear un alumno nuevo, se incrementa su legajo en 1.
		this.materias = new ArrayList<>(); // inicializamos el arreglo materias vacio
		this.tipo = tipo;
	}
	public String getNombre() {
        return nombre;
    }
	public void setNombre(String nombre) {
        this.nombre = nombre;
    }
	//  metodos get y set para el dni de la persona
    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }
    // metodos get y set para la carrera de la persona
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    // metodos get y set para la facultad de la persona
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
    // metodo get legajo
    public int getLegajo() {
    	return legajo;    
    }
    
    public ArrayList<String> getMaterias() {
        return materias;
    }
    public void setModMaterias(int numM,String MateriaMod) {
    	this.materias.set(numM, MateriaMod);
    }
    public void setMaterias(ArrayList<String> materias) {
        this.materias = materias;
    }
    public void agregarMateriaP(String materia) {
    	this.materias.add(materia);
    }
    public int getMateriasP() {
    	return this.materias.size();
    }
    public void delMaterias(int nuM) {
    	this.materias.remove(nuM);
    }
    // metodos get y set para el tipo de persona - alumno o profesor
    public void SetTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
    	return tipo;
    }
    public void info() {
        System.out.print(tipo+" Nombre: " + nombre + "\n");
        System.out.print("DNI: " + dni + "\n");
        System.out.print("Legajo n°: " +legajo+ "\n");
        System.out.print("Cursando la/s materia/s: \n");
        for (int mates = 0; mates < materias.size(); ++mates) {
            System.out.println("   " + mates + ": " + materias.get(mates));
        }
    }
    public void info2() {
        System.out.print(tipo+" Nombre: " + nombre + "\n");
        System.out.print("DNI: " + dni + "\n");
        System.out.print("Legajo n°: " +legajo+ "\n");
        System.out.print("Enseñando la/s materia/s \n");
        for (int mates = 0; mates < materias.size(); ++mates) {
            System.out.println("   " + mates + ": " + materias.get(mates));
        }
    } 
 // metodo para agregar una materia al profesor
    public void agregarMateriaA(String materia) {
        materias.add(materia);
    }
    
    
    
    
    
	
	
	
	
	

}
