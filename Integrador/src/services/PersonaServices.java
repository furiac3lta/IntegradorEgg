package services;

import modelo.Persona;

import java.io.*;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonaServices {
    public PersonaServices() {
    }
    List<Persona> listaPersonas = new ArrayList<Persona>();
    /* PRIMER INTENTO SIN USAR STREAM
    ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    public void leer(){
        System.out.println("Ejercicio 01-02");
        try{
            FileReader entrada = new FileReader("/home/marce/Escritorio/datos.csv");
            BufferedReader bufer = new BufferedReader(entrada);
            String linea = "";
            try{
                while(linea != null) {
                    linea = bufer.readLine();
                    String[] vect = linea.split(",");
                    Persona persona = new Persona(vect[0], vect[1], vect[2], Double.parseDouble(vect[3]));
                    listaPersonas.add(persona);
                }
            }catch(NullPointerException e){
                System.out.println("Array List Personas!");
                for (Persona aux : listaPersonas
                ) {
                    System.out.println(aux);
                }

            }
            entrada.close();
        } catch (IOException e){
            System.out.println("No se ha encontrado el archivo");
        }
        System.out.println("");
    }*/
    public void leerArchivo() {
        System.out.println("Ejercicio 01-02");
        String ruta = "/home/marce/Escritorio/datos.csv";
        try (Stream<String> streamF = Files.lines(Paths.get(ruta))) {
            listaPersonas = streamF.map(linea -> linea.split(",")).map(arreglo -> {
                Persona persona = new Persona(arreglo[0], arreglo[1], arreglo[2], Double.parseDouble(arreglo[3]));
                return persona;
            }).collect(Collectors.toList());
            listaPersonas.forEach(System.out::println);

        }catch (IOException e){
            System.out.println("Error de lectura");
        }
        System.out.println("");
    }

    public void encontrarEmpleadoPorNombre(){
        System.out.println("Ejercicio 03");
        for (Persona aux : listaPersonas
        ) {
            if(aux.getNombre().equalsIgnoreCase("Giselle Marshall" )){
                System.out.println("Bucando datos de empleado por nombre");
                System.out.println(aux.toString());
                System.out.println("");
            }
        }
    }

    public void encontrarEmpleadoPorCorreo(){
        System.out.println("Ejercicio 04");
        for (Persona aux : listaPersonas
        ) {
            if(aux.getCorreo().equalsIgnoreCase("imperdiet.non@enim.org" )){
                System.out.println("Bucando datos de empleado por correo");
                System.out.println(aux.toString());
                System.out.println("");
            }
        }
    }

    public void imprimirCiudades() {
        System.out.println("Ejercicio 05");
        ArrayList ciudades = new ArrayList<>();
        HashSet c = new HashSet();
        for (Persona aux : listaPersonas
        ) {
            if (aux.getCiudad() != null) {
                ciudades.add(aux.getCiudad());
                c.addAll(ciudades);
            }
        }
        System.out.println("imprimiendo ciudades");
        ArrayList<String> listaCiudades = new ArrayList<>(c);
        System.out.println(listaCiudades);
        System.out.println("Cantidad de ciudades: " + listaCiudades.size());
        System.out.println("");

        File salida = new File("/home/marce/Escritorio/listaCiudades.csv");
        try (FileOutputStream salidaStream = new FileOutputStream(salida);
             BufferedWriter bufer = new BufferedWriter(new OutputStreamWriter(salidaStream));) {
            for (String s : listaCiudades) {
                bufer.write(s);
                bufer.newLine();
            }
        } catch (IOException e) {
            System.out.println("ups!!");
        }
    }

    public void contarCorreos(){
        System.out.println("Ejercicio 06");
        int i = 0;
        System.out.println("correos coincidentes:");
        System.out.println("");
        for (Persona aux : listaPersonas
        ) {
            String correo = aux.getCorreo();
            Pattern pattern = Pattern.compile(".*elit", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(correo);
            boolean resultado = matcher.matches();
            while(matcher.find()){
                System.out.println(correo);
                i++;
            }
        }
        System.out.println("la cantidad de veces que se encuentra elit es: " + i);
        System.out.println("");
    }

    public void multiplicarMonto(){
        System.out.println("Ejercicio 07");
        double acum = 0;
        System.out.println("los montos superiores a 29000 son:");
        for (Persona aux: listaPersonas
        ) {
            acum = aux.getMonto();
            aux.setMonto(3*acum);
            if (aux.getMonto() > 29000){
                System.out.println(aux.getMonto());
            }
        }
        System.out.println("");
    }

    public void calcularPromedio(){
        System.out.println("Ejercicio 08");
        double acumulador = 0;
        double promedio;
        for (Persona aux : listaPersonas
        ) {
            aux.setMonto(aux.getMonto()/3);
            acumulador += aux.getMonto();
        }
        promedio = acumulador / listaPersonas.size();
        System.out.println("el promedio de todos los montos es: " + promedio);
        System.out.println("");
    }

    public void ObtenerMontoMenor(){
        System.out.println("Ejercicio 09 -10");
        ArrayList montos = new ArrayList<>();
        HashSet c = new HashSet();
        for (Persona aux : listaPersonas
        ) {
            if (aux.getMonto() != 0) {
                montos.add(aux.getMonto());
                c.addAll(montos);
            }
        }
        ArrayList<Double> listaMontos = new ArrayList<>(c);
        double minimo = Collections.min(listaMontos);
        double maximo = Collections.max(listaMontos);
        for (Persona aux : listaPersonas
        ) {
            if (aux.getMonto() == minimo){
                System.out.println("Datos de la persona con el monto minimo");
                System.out.println(aux.toString());
            }
            if (aux.getMonto() == maximo){
                System.out.println("Datos de la persona con el monto maximo");
                System.out.println(aux.toString());
            }
        }
    }
}




