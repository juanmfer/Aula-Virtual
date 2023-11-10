import java.util.Scanner;
import java.util.ArrayList;


public class AulaVirtual {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		ArrayList<ClasePersonas> listaTodos = new ArrayList<>(); // se crea el arreglo listaTodos para profesores y alumnos
		String dniStr, dniBusqueda, TipoProfesor,TipoAlumno,enEdicion,Tipo = null;
		TipoProfesor = "Profesor"; 
		TipoAlumno = "Alumno";
		listaTodos.add(new ClasePersonas("Juan", 1, "Ingeniería", "Facultad de Ciencias",Tipo="Alumno"));
        //listaTodos.add(new ClasePersonas("jose", 2, "Ciencias de la Computación", "Facultad de Tecnología", TipoProfesor));
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
            System.out.println("x. Salir");
            opcionIngresar = scanner.nextLine();
            if(opcionIngresar.equals("1")) { // si ingresa 1, la variable Tipo identifica al alumno
            	Tipo = TipoAlumno;
            } else if(opcionIngresar.equals("2")) { // si ingreasa 2, la variable Tipo identifica al profesor
            	Tipo = TipoProfesor;
            }
            if(opcionIngresar.equals("1") || opcionIngresar.equals("2")) {
            	System.out.println("Ingrese el Nombre del "+ Tipo+":");
            	String nombre = scanner.nextLine(); // se ingresa por consola, nombre de alumno o profesor
            	System.out.print("Ingrese el DNI del "+Tipo+" (Sin Puntos):");
            	dniStr = scanner.nextLine(); // ingresa el DNI como String
            	long dni = Long.parseLong(dniStr); // se convierte DNI a LONG 
            	System.out.print("Ingrese la carrera del "+Tipo+";");
            	String carrera = scanner.nextLine(); // se ingresa la carrera, alumno o profesor
            	System.out.print("Ingrese facultad del "+Tipo+":");
            	String facultad = scanner.nextLine(); // se ingresa la facultad, alumno o profesor
            	ArrayList<String> materiasA = new ArrayList<>(); // se crea el arreglo materiasA, para alumno o profesor
            	String materia; // 
            	do {
                    System.out.print("Ingrese materia para el "+Tipo+": "+nombre+" (o 'x' para continuar): ");
                    materia = scanner.nextLine(); // se ingresa materia para alumno o profesor
                    if (!materia.equalsIgnoreCase("x")) { // mientras no ingrerse "x" se ingresan materias, alumno o profesor 
                        materiasA.add(materia);
                    }
                } while (!materia.equalsIgnoreCase("x"));
            	ClasePersonas personas = new ClasePersonas(nombre,dni,carrera,facultad,Tipo);
            	personas.setMaterias(materiasA); // se setean las materias ingresadas, para alumno o profesor
            	listaTodos.add(personas); // se agrega alumno o profesor al arreglo
            } else if (opcionIngresar.equals("3") || opcionIngresar.equals("4")) { // si ingresa "3" o "4" se edita alumno o profesor
            	ClasePersonas personasEditar = null;
            	if(opcionIngresar.equals("3")){ 
            		enEdicion = TipoAlumno; // se asigna Alumno, para poder editarlo
            	} else {
            		enEdicion = TipoProfesor; // se asigna Profesor, para poder editarlo
            	}
            	System.out.print("\n");
            	System.out.print("Ingrese el DNI del "+enEdicion+" a editar: \n");
            	dniBusqueda = scanner.nextLine(); // se ingresa "DNI" para buscar profesor o alumno
            	long dniBuscar  = Long.parseLong(dniBusqueda); // DNI se convierte de String a Long
            	for(ClasePersonas persona : listaTodos) {
            		if(persona.getDni() == dniBuscar) { // si encuentra el dni, se asigna a personasEditar
            			personasEditar = persona;
            			//alumno.info();
                		break; // si lo encuentra sale 
            		}
            	}
            	if (personasEditar != null) {
            		System.out.print("Se Editara el Siguiente "+Tipo+" "+personasEditar.getNombre()+"\n"); // imprime por pantalla_ 
            		System.out.print("##############################################\n");  // que sera editado el siguiente alumno o profesor
            		personasEditar.info();
            		System.out.print("##############################################\n");
                    System.out.print("Ingrese el nuevo nombre del "+Tipo+": ");
                    String nombre = scanner.nextLine();  // nuevo nombre que se le asignara a profesor o alumno
                    System.out.print("Modifique el DNI del "+Tipo+ "(Sin Puntos)");
                    dniStr = scanner.nextLine(); // nuevo DNI
                    long dni  = Long.parseLong(dniStr); // convierte en Long a DNI
                    System.out.print("Ingrese la nueva carrera del "+Tipo+": ");
                    String carrera = scanner.nextLine(); // nueva carrera
                    System.out.print("Ingrese la nueva facultad del "+Tipo+": ");
                    String facultad = scanner.nextLine(); // nueva facultad
                    while (true) { // en while se da opciones de editar las materias que cursa el alumno o enseña el profesor
                    	System.out.println("Agregar o editar materias para el "+Tipo+" "+nombre);
                        System.out.println("1. Editar materias.");
                        System.out.println("2. Agregar Materia");
                        System.out.println("3. Eliminar Materia");
                        System.out.println("x. Volver");
                        opcionEditarProfesor = scanner.nextLine();
                        if (opcionEditarProfesor.equals("1")) { 
                        	if(personasEditar.getMateriasP() > 0) { // si hay al menos una materia, permite editar
                        		System.out.println("ingrese numero de materia: ");
                            	String materiaNum = scanner.nextLine(); // las materias se enumeran con un numero y nombre (1. POO)
                            	int materiaNum2 = Integer.parseInt(materiaNum); // se ingresa numero de materia a editar
                            	System.out.println("ingrese nuevo nombre de materia: ");
                            	String materiaNue = scanner.nextLine(); // se ingresa el nuevo nombre de la materia a editar
                            	personasEditar.setModMaterias(materiaNum2, materiaNue ); // se envia por parametros el numero de la materia y el nombre a editar
                        	}
                        	else { // sino hay materias para editar informa
                        		System.out.println("No hay Materias para eliminar.");	
                        	}
                        } else if (opcionEditarProfesor.equals("2")) { // agregar materia
                        	System.out.println("Ingrese materia a agregar:  ");
                        	String materiaNue = scanner.nextLine(); // nombre de materia
                        	personasEditar.agregarMateriaP(materiaNue); // se envia por parametro el nombre de materia a agregar
                        	
                        } else if (opcionEditarProfesor.equals("3")) { // eliminar materia
	                        if(personasEditar.getMateriasP() > 0) { // si hay al menos una materia, permite eliminar
	                        	System.out.println("ingrese numero de materia a eliminar: ");
		                        String materiaNum = scanner.nextLine(); 
		                        int materiaNum2 = Integer.parseInt(materiaNum);
	                        	personasEditar.delMaterias(materiaNum2);
	                        } else { // sino hay materias para eliminar informa
	                        	System.out.println("No hay Materias para eliminar.");
	                        }
                        } else if (opcionEditarProfesor.equals("x")) {
                            System.out.println("Saliendo del menu");
                            break; // Salir del bucle
                        } else {
                            System.out.println("Opción no válida. Por favor, elija una opción válida.");
                        }
                    } 
                    // Actualizar los datos del alumno o profesor
                    personasEditar.setNombre(nombre);
                    personasEditar.setDni(dni);
                    personasEditar.setCarrera(carrera);
                    personasEditar.setFacultad(facultad);
                    System.out.println("Datos del "+Tipo+" editados con éxito!"); // informa que el alumno o profesor se edito
                    personasEditar.info(); // metodo para mostrar los datos del alumno o profesor
                } else {
                    System.out.println(enEdicion+" no encontrado."); // si no encuentra profesor o alumno con ese dni, informa
                    System.out.print("\n");
                }
            } else if (opcionIngresar.equals("5")){  // 
            	if(listaTodos.size() == 0) { // si la cantidad de registros en el arreglo es igual a 0
					System.out.print("\n");  // informa que esta vacia
            		System.out.println("Lista de "+Tipo+" vacia.");
            	} else {
            		for(ClasePersonas listaInfo: listaTodos) { // si no, itera sobre el arreglo
            			if(listaInfo.getTipo() == TipoAlumno){ // e informa todos con el mismo tipo Alumno
            				System.out.print("-------------------------------------------------\n");
            				listaInfo.info();
            			}
            		}
            		System.out.print("-------------------------------------------------\n");
            	}
            } else if (opcionIngresar.equals("6")){  
            	if(listaTodos.size() == 0) { // si la cantidad de registros en el arreglo es igual a 0
					System.out.print("\n");  // informa que esta vacia
            		System.out.println("Lista de "+Tipo+" vacia.");
            	} else {
            		for(ClasePersonas listaInfo: listaTodos) {// si no, itera sobre el arreglo
            			if(listaInfo.getTipo() == TipoProfesor){ // e informa todos con el mismo tipo Profesor
            				System.out.print("-------------------------------------------------\n");
            				listaInfo.info();
            			}          			
            		}
            		System.out.print("-------------------------------------------------\n");
            	} 
            } else if (opcionIngresar.equals("x")) { // opcion "x" sale del programa
                System.out.println("Saliendo del programa...");
                break; // salir del bucle
            } else {
                System.out.println("Opción no válida. Por favor, elija una opción válida.");
                // si ingresa una opcion fuera de 1,2,3,4,5,6 y x informa que no es valida
            }
        }
        scanner.close();      
	}			
}
