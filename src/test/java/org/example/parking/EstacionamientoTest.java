package org.example.parking;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        Cliente client = new Cliente("23441221","pedro");
        Vehiculo vehiculo = new Vehiculo("ab123cd","2023", Vehiculo.Tipo.AUTO);

        Estacionamiento estaci= new Estacionamiento();
         Ticket ticket =new Ticket(client,vehiculo);
         estaci.ingresarVehiculo("23441221","pedro",vehiculo);


        Ticket ticket2 =estaci.retirarVehiculo("ab123cd");


        // No tiene que dar igual ya que el vehiculo a sido borrado de la base de datos
        Assert.assertNotEquals(ticket2.getCliente(),ticket.getCliente());

        Assert.assertEquals(ticket2.getVehiculo(),vehiculo);









    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Cliente client = new Cliente("23441221","pedro");
        Cliente client2 = new Cliente("123","juan");
        Cliente client3 = new Cliente("3212141","carlos");

        Vehiculo vehiculo = new Vehiculo("ab111cd","2023", Vehiculo.Tipo.AUTO);
        Vehiculo vehiculo2 = new Vehiculo("ab333cd","2023", Vehiculo.Tipo.PICKUP);
        Vehiculo vehiculo3 = new Vehiculo("ab222cd","2023", Vehiculo.Tipo.SUV);

        Estacionamiento estaci= new Estacionamiento();
        estaci.ingresarVehiculo("23441221","pedro",vehiculo);
        estaci.ingresarVehiculo("123","2023",vehiculo2);
        estaci.ingresarVehiculo("3212141","2023",vehiculo3);

        Ticket ticket =new Ticket(client,vehiculo);
        Ticket ticket2 =new Ticket(client2,vehiculo2);
        Ticket ticket3 =new Ticket(client3,vehiculo3);

        ticket.marcarSalida();
        ticket2.marcarSalida();
        ticket3.marcarSalida();

        ticket.calcularMinutos();
        ticket2.calcularMinutos();
        ticket3.calcularMinutos();



        double precio1 =ticket.calcularPrecio();
        double precio2 =ticket2.calcularPrecio();
        double precio3 =ticket3.calcularPrecio();

        Assert.assertNotEquals(precio1,precio2);
        Assert.assertNotEquals(precio2,precio3);
        Assert.assertNotEquals(precio1,precio3);
        //quise hacer un assert equal de 2 autos pero al ser el marcar salida un rango aleatorio nunca daba igual


    }

}