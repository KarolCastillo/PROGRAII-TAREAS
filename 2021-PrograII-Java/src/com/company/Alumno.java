package com.company;


import java.util.Random;

//declaracion clase alumno
public class Alumno {
    private String apellido, carne, nombre, correo, telefono, dpi;
    private int indice;

    //Constructor #1: Es un método especial de la clase, que se encarga de inicializar los valores de la clase
    public Alumno(){
        this.indice = 1;
    }
    //Constructor #2
    public Alumno(String nombre, String apellido, String correo, String telefono, String dpi, String carne){
        this.nombre = nombre;
        this.apellido = apellido;
        this.carne = carne;
        this.correo = correo;
        this.telefono = telefono;
        this.dpi = dpi;
    }

    //Lista publica para mover los datos de los alumnos
    public String[]mover(){
        String[] Registro = new String[6];
        Registro[0] = this.nombre;
        Registro[1] = this.apellido;
        Registro[2] = this.carne;
        Registro[3] = this.correo;
        Registro[4] = this.telefono;
        Registro[5] = this.dpi;
        return Registro;
    }

    //Se muestra el carne generado
    public String watchCarne(){
        return this.carne;
    }

    //Codigo para generar carnet como la UMG codigo de carrera de sistemas, año actual y el numero generado automaticamente
    public String generaCarne(RegistroAlumno registro){
        String Codigocarrera = "0909"; String AnioActual = "2021"; Random  Aleatorio = new Random();
        int n_random = Aleatorio.nextInt(6000);
        String random = Integer.toString(n_random);
        String carne = Codigocarrera + "-" + AnioActual + "-" + random;
        while(registro.existenceRegisteredStudent(carne)){
            n_random = Aleatorio.nextInt(6000);
            random = Integer.toString(n_random);
            carne = Codigocarrera + "-" + AnioActual + "-" + random;
            if (!(registro.existenceRegisteredStudent(carne))){
                break;
            }else{

            }
        }
        this.carne = carne;

        return "";
    }

}
