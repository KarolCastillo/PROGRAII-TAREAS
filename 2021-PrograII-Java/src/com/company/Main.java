package com.company;

//Importacion de Libreria
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Declaramos las variables
        Scanner entradaDeTeclado = new Scanner(System.in);
        boolean key = true;
        int option = 0;

        //Ingreso de N cantidad de alumnos
        System.out.println(
                "Vectores multidimencionales, registro de alumnos" +
                "\n por favor ingresar cantidad de Alumnos a registrar");
        RegistroAlumno registros = new RegistroAlumno(Integer.parseInt(entradaDeTeclado.nextLine()));

        //Ciclo hasta que el usuario elija salir
        while(key) {
            //Mostramos el Menu
            System.out.println(
                    "\n Menu de opciones" +
                            "\n1.- Registrar Alumnos" +
                            "\n2.- Mostrar Alumnos" +
                            "\n3.- Modificar Datos de Alumnos" +
                            "\n4.- Cerrar Sistema\n");
            option = Integer.parseInt(entradaDeTeclado.nextLine()); //

            //depende de la opcion del usuario sobre el menu ejecutara el case.
            switch (option){
                //Registramos Alumnos
                case 1: {
                    String[][] vector = registros.getRegisteredStudent();
                    for (int i = 0; i < vector.length; i++) {
                        //ingreso de datos segun el usuario
                        System.out.println("\n Nombre del Alumno " +(i+1) + ": "); String nombreAlumno = entradaDeTeclado.nextLine();
                        System.out.println(" Apellidos del Alumno " +(i+1) + ": "); String apellidoAlumno = entradaDeTeclado.nextLine();
                        System.out.println("Correo Electronico del Alumno " +(i+1) + ": ");  String correoAlumno = entradaDeTeclado.nextLine();
                        System.out.println(" No. de Telefono o Celular del alumno " +(i+1) + ": "); String telefonoAlumno = entradaDeTeclado.nextLine();
                        System.out.println("No. del DPI del Alumno (si es mayor de edad, de lo contrario NO. de CUI) " +(i+1) + ": "); String dpiAlumno = entradaDeTeclado.nextLine();

                        Alumno student = new Alumno(nombreAlumno, apellidoAlumno, correoAlumno, telefonoAlumno, dpiAlumno, "");

                        //Generar el carne
                        student.generaCarne(registros);
                        System.out.println("\nEl numero de carne generado para el estudiante es: " + student.watchCarne()  );
                        if (registros.registerStudent(student)) {
                            System.out.println("\nAlumno registrado exitosamente");
                        } else {
                            System.out.println("\nEl alumno ingresado ya está registrado");
                            i--;
                        }
                    }
                    break;
                }
                //Mostramos Alumnos
                case 2: {
                    String[][] vector = registros.getRegisteredStudent();
                    System.out.println("\nLista de Alumnos Registrados ");
                    for (int i = 0; i < vector.length; i++) {
                        //if(vector[i]!=null) // otra forma de escribirlo
                        if (!(vector[i] == null)) {//se valida si el registro no es nulo
                            System.out.println("\nNombres y Apellidos: " + vector[i][0] +"  "+ vector[i][1]);
                            System.out.println("Correo Electronico: " + vector[i][3]);
                            System.out.println("Telefono o celular: " + vector[i][4]+"  Y No. de Carne: " + vector[i][2]);
                            System.out.println("Correo Electronico: " + vector[i][3]);
                            System.out.println(" NO.DPI: " + vector[i][5]);
                        }
                    }
                    break;
                }
                //Modificar Datos del Alumnos
                case 3:{
                    System.out.println("\n Por favor ingresar No. de carne del alumno a modificar datos "); String n_carne = entradaDeTeclado.nextLine();
                    registros.modifyStudent(n_carne);
                    break;
                }
                //Salimos del programa
                case 4:{
                    key = false;
                    break;
                }
                // Si se selecciona otro numerop de case difenrente del 1 al 4 da un mensaje en el que vuelva a intentar
                default: System.out.println("\n ERROR!!  " +
                        " \nSELECCIONE UNA OPCION DEL 1 AL 4.....");

            }
        }

    }
}