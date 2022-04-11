package programa;

import services.PersonaServices;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Programa {
    public static void main(String[] args) {
        PersonaServices personaServices = new PersonaServices();
        //personaServices.leer();
        personaServices.leerArchivo();
        personaServices.encontrarEmpleadoPorNombre();
        personaServices.encontrarEmpleadoPorCorreo();
        personaServices.imprimirCiudades();
        personaServices.contarCorreos();
        personaServices.multiplicarMonto();
        personaServices.calcularPromedio();
        personaServices.ObtenerMontoMenor();
    }


}
