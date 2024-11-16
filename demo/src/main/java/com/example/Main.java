package com.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.Entidad.Empleado;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        // creataEmpleado("Camilo", 25);

        Empleado empleado = leerEmpleado(5L);
        if(empleado != null){
            System.out.println("Empleado encontrado: nombre "+ empleado.getNombre() +", edad "+ empleado.getEdad());
        }

        em.close();
        emf.close();
    }

    // public static void creataEmpleado(String nombre, int edad) {
    //     EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
    //     EntityManager em = emf.createEntityManager();

    //     em.getTransaction().begin();

    //     Empleado empleado = new Empleado();
    //     empleado.setNombre(nombre);
    //     empleado.setEdad(edad);

    //     em.persist(empleado);

    //     em.getTransaction().commit();
    //     em.close();
    //     emf.close();
    // }
    public static Empleado leerEmpleado (Long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        Empleado empleado = em.find(Empleado.class, id);

        em.close();

        return empleado;
    }
}