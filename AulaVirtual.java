
import java.util.Scanner;
import java.util.ArrayList;




public class AulaVirtual {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	ArrayList<ClasePersonas> listaTodos = new ArrayList<>();
	String dniStr, dniBusqueda, TipoProfesor,TipoAlumno,enEdicion,Tipo = null;
	TipoProfesor = "Profesor";
	TipoAlumno = "Alumno";
	//listaTodos.add(new ClasePersonas("Juan", 1, "Ingeniería", "Facultad de Ciencias", TipoAlumno));
        //listaTodos.add(new ClasePersonas("jose", 2, "Ciencias de la Computación", "Facultad de Tecnología", TipoProfesor));
	System.out.print("\u001b[H\u001b[2J");
        String opcionIngresar,opcionEditarProfesor;
        System.out.println("Aula Virtual - ESBA");
        System.out.println("Registro y modificacion de Alumnos y Profesores\n");
        while (true) { // menu 
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar un Alumno");
            System.out.println("2. Ingresar un Profesor");
            System.out.println("3. Editar un Alumno");
            System.out.println("4. Editar un Profesor");
            System.out.println("5. Ver todos los Alumnos");
            System.out.println("6. Ver todos los Profesores");
            //System.out.println("7. Limpiar pantalla");
            System.out.println("x. Salir");
            opcionIngresar = scanner.nextLine();
            if(opcionIngresar.equals("1")) {
            	Tipo = TipoAlumno;
            } else if(opcionIngresar.equals("2")) {
            	Tipo = TipoProfesor;
            }
            if(opcionIngresar.equals("1") || opcionIngresar.equals("2")) {
            	System.out.println("Ingrese el Nombre del "+ Tipo+":");
            	String nombre = scanner.nextLine();
            	System.out.print("Ingrese el DNI del "+Tipo+" (Sin Puntos):");
            	dniStr = scanner.nextLine();
            	long dni = Long.parseLong(dniStr);
            	System.out.print("Ingrese la carrera del "+Tipo+";");
            	String carrera = scanner.nextLine();
            	System.out.print("Ingrese facultad del "+Tipo+":");
            	String facultad = scanner.nextLine();
            	ArrayList<String> materiasA = new ArrayList<>();
            	String materia;
            	do {
                    System.out.print("Ingrese materia para el "+Tipo+": "+nombre+" (o 'x' para continuar): ");
                    materia = scanner.nextLine();
                    if (!materia.equalsIgnoreCase("x")) {
                        materiasA.add(materia);
                    }
                } while (!materia.equalsIgnoreCase("x"));
            	ClasePersonas personas = new ClasePersonas(nombre,dni,carrera,facultad,Tipo);
            	personas.setMaterias(materiasA);
            	listaTodos.add(personas);
            } else if (opcionIngresar.equals("3") || opcionIngresar.equals("4")) {
            	ClasePersonas personasEditar = null;
            	if(opcionIngresar.equals("3")){
            		enEdicion = TipoAlumno;
            	} else {
            		enEdicion = TipoProfesor;
            	}
            	System.out.print("\n");
            	System.out.print("Ingrese el DNI del "+enEdicion+" a editar: \n");
            	dniBusqueda = scanner.nextLine();
            	long dniBuscar  = Long.parseLong(dniBusqueda);
            	for(ClasePersonas persona : listaTodos) {
            		if(persona.getDni() == dniBuscar) {
            			personasEditar = persona;
            			//alumno.info();
                		break;
            		}
            	}
            	if (personasEditar != null) {
                    // Solicitar nuevos valores para editar el alumno
            		System.out.print("Se Editara el Siguiente "+Tipo+" "+personasEditar.getNombre()+"\n");
            		System.out.print("##############################################\n");
            		personasEditar.info();
            		System.out.print("##############################################\n");
                    System.out.print("Ingrese el nuevo nombre del "+Tipo+": ");
                    String nombre = scanner.nextLine();
                    System.out.print("Modifique el DNI del "+Tipo+ "(Sin Puntos)");
                    dniStr = scanner.nextLine();
                    long dni  = Long.parseLong(dniStr);
                    System.out.print("Ingrese la nueva carrera del "+Tipo+": ");
                    String carrera = scanner.nextLine();
                    System.out.print("Ingrese la nueva facultad del "+Tipo+": ");
                    String facultad = scanner.nextLine();
                    
                    while (true) {
                    	System.out.println("Agregar o editar materias para el "+Tipo+" "+nombre);
                        System.out.println("1. Editar materias.");
                        System.out.println("2. Agregar Materia");
                        System.out.println("3. Eliminar Materia");
                        System.out.println("x. Volver");
                        opcionEditarProfesor = scanner.nextLine();
                        if (opcionEditarProfesor.equals("1")) {
                        	System.out.println("ingrese numero de materia: ");
                        	String materiaNum = scanner.nextLine();
                        	int materiaNum2 = Integer.parseInt(materiaNum);
                        	System.out.println("ingrese nuevo nombre de materia: ");
                        	String materiaNue = scanner.nextLine();
                        	personasEditar.setModMaterias(materiaNum2, materiaNue );
                        } else if (opcionEditarProfesor.equals("2")) {
                        	System.out.println("Ingrese materia a agregar:  ");
                        	String materiaNue = scanner.nextLine();
                        	personasEditar.agregarMateriaP(materiaNue);
                        	
                        } else if (opcionEditarProfesor.equals("3")) {
                        	System.out.println("ingrese numero de materia a eliminar: ");
	                        String materiaNum = scanner.nextLine();
	                        int materiaNum2 = Integer.parseInt(materiaNum);
	                        if(personasEditar.getMateriasP() > 0) {
	                        	personasEditar.delMaterias(materiaNum2);
	                        } else {
	                        	System.out.println("No hay Materias para eliminar.");
	                        }
                        } else if (opcionEditarProfesor.equals("x")) {
                            System.out.println("Saliendo del menu");
                            break; // Salir del bucle
                        } else {
                            System.out.println("Opción no válida. Por favor, elija una opción válida.");
                        }
                    } 
                    // Actualizar los datos del alumno
                    personasEditar.setNombre(nombre);
                    personasEditar.setDni(dni);
                    personasEditar.setCarrera(carrera);
                    personasEditar.setFacultad(facultad);
                    personasEditar.setTipo(Tipo);
                    System.out.println("Datos del "+Tipo+" editados con éxito!");
                    personasEditar.info(); // Método para mostrar los datos del alumno
                } else {
                    System.out.println(Tipo+" no encontrado.");
                }
            } else if (opcionIngresar.equals("5")){  // 
            	if(listaTodos.size() == 0) {
					System.out.print("\n");
            		System.out.println("Lista de "+Tipo+" vacia.");
            	} else {
            		for(ClasePersonas listaInfo: listaTodos) {
            			if(listaInfo.getTipo() == TipoAlumno){
            				System.out.print("-------------------------------------------------\n");
            				listaInfo.info();
            			}          			
            		}
            		System.out.print("-------------------------------------------------\n");
            	}
            } else if (opcionIngresar.equals("6")){  // 
            	if(listaTodos.size() == 0) {
					System.out.print("\n");
            		System.out.println("Lista de "+Tipo+" vacia.");
            	} else {
            		for(ClasePersonas listaInfo: listaTodos) {
            			if(listaInfo.getTipo() == TipoProfesor){
            				System.out.print("-------------------------------------------------\n");
            				listaInfo.info2();
            			}          			
            		}
            		System.out.print("-------------------------------------------------\n");
            	} 
            } else if (opcionIngresar.equals("x")) {
                System.out.println("Saliendo del programa...");
                break; // Salir del bucle
            } else {
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        }
        scanner.close();      
	}			
}
