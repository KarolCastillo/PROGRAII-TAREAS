package com.company;


import java.util.Scanner;

public class RegistroAlumno {
    //{ Area de declaraciones}
    Scanner entradaDeTeclado = new Scanner(System.in);
    // declara vector multidimencional para alumnos
    private String[][] registeredStudent; private int indiceVector;

    //{ Area de métodos de clase}
    public RegistroAlumno(int numberRecords) {
        //se inicializan los valores
        this.registeredStudent = new String[numberRecords][6];
        this.indiceVector = 0;
    }

    //Verificamos si esta inscrito o no el alumno
    public boolean registerStudent(Alumno alumno) {
        String[] studentData = alumno.mover();
        if (!(this.existenceRegisteredStudent(studentData[2]))) {
            this.registeredStudent[this.indiceVector][0] = studentData[0];
            this.registeredStudent[this.indiceVector][1] = studentData[1];
            this.registeredStudent[this.indiceVector][2] = studentData[2];
            this.registeredStudent[this.indiceVector][3] = studentData[3];
            this.registeredStudent[this.indiceVector][4] = studentData[4];
            this.registeredStudent[this.indiceVector][5] = studentData[5];
            this.incrementarIndice();
            return true;
        } else {
            return false;
        }
    }

    //Incrementamos el indice
    private void incrementarIndice() {
        this.indiceVector = this.indiceVector + 1;
    }

    //registro de alumno conseguido
    public String[][] getRegisteredStudent(){
        return this.registeredStudent;
    }


    public boolean existenceRegisteredStudent(String carneAlumno){
        for(int i=0; i<this.registeredStudent.length; i++){//length devuelve el tamaño del vector
            if(this.registeredStudent[i][2]!=null){
                if(carneAlumno.equals(this.registeredStudent[i][2])){
                    return true;
                }
            }
        }
        return false;
    }

    //Modificamos los datos del alumno segun carne
    public void modifyStudent(String carneAlumno){
        for(int i=0; i<this.registeredStudent.length; i++){//length devuelve el tamaño del vector
            if(this.registeredStudent[i][2]!=null){
                if(carneAlumno.equals(this.registeredStudent[i][2])){
                    System.out.println("\nDatos del Alumno: ");
                    for(int j=0; j<this.registeredStudent[0].length; j++){
                        //VALIDAMOS SI EL REGISTRO NO ES NULO
                        if(!(this.registeredStudent[i]==null)){
                            System.out.println("\nNombre del Alumno: " + this.registeredStudent[i][0]);
                            System.out.println("Apellidos del Alumno: " + this.registeredStudent[i][1]);
                            System.out.println("Carne: " + this.registeredStudent[i][2]);
                            System.out.println("Correo Electronico del Alumno: " + this.registeredStudent[i][3]);
                            System.out.println("No. de Telefono o Celular del alumno: " + this.registeredStudent[i][4]);
                            System.out.println("No. del DPI del Alumno (si es mayor de edad, de lo contrario NO. de CUI): " + this.registeredStudent[i][5]);
                            //Se modifican los datos
                            System.out.println("\n ActualizarNombre del Alumno: ");
                            this.registeredStudent[i][0] = entradaDeTeclado.nextLine();
                            System.out.println("Actualizar Apellidos del Alumno : ");
                            this.registeredStudent[i][1] = entradaDeTeclado.nextLine();
                            System.out.println("Actualizar Correo Electronico del Alumno: ");
                            this.registeredStudent[i][3] = entradaDeTeclado.nextLine();
                            System.out.println(" Actualizar No. de Telefono o Celular del alumno: ");
                            this.registeredStudent[i][4] = entradaDeTeclado.nextLine();
                            System.out.println(" Actualizar No. del DPI del Alumno (si es mayor de edad, de lo contrario NO. de CUI): ");
                            this.registeredStudent[i][5] = entradaDeTeclado.nextLine();
                            break;
                        }
                    }
                }
            }
        }
    }
}