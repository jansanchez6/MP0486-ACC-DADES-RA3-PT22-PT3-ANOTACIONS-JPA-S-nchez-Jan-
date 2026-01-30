package es.ilerna.M0486.ra3.pt22.pt3.anotacions.main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import es.ilerna.M0486.ra3.pt22.pt3.anotacions.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Fase 1: Omplir dades");
            System.out.println("2. Fase 2: Desassociar Vehicle 1 de Persona 1");
            System.out.println("3. Fase 3: Modificar dades Vehicle 1");
            System.out.println("0. Sortir");
            System.out.print("Selecciona una opció: ");
            
            try {
                option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 1:
                        fase1();
                        break;
                    case 2:
                        fase2();
                        break;
                    case 3:
                        fase3();
                        break;
                    case 0:
                        System.out.println("Sortint...");
                        break;
                    default:
                        System.out.println("Opció no vàlida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Si us plau, introdueix un número.");
            }
        }
        
        HibernateSession.getSessionFactory().close();
        sc.close();
    }

    private static void fase1() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Students
            Student s1 = new Student();
            s1.setName("Anna");
            s1.setSurname("Lopez");
            s1.setPhoneNumber(111111111);
            s1.setStudentCode("STU001");
            session.save(s1);

            Student s2 = new Student();
            s2.setName("Jordi");
            s2.setSurname("Martinez");
            s2.setPhoneNumber(222222222);
            s2.setStudentCode("STU002");
            session.save(s2);

            Student s3 = new Student();
            s3.setName("Clara");
            s3.setSurname("Sanchez");
            s3.setPhoneNumber(333333333);
            s3.setStudentCode("STU003");
            session.save(s3);

            // Teachers
            Teacher t1 = new Teacher();
            t1.setName("Joan");
            t1.setSurname("Perez");
            t1.setPhoneNumber(444444444);
            t1.setTeacherCode("TEA001");
            session.save(t1);

            Teacher t2 = new Teacher();
            t2.setName("Maria");
            t2.setSurname("Gomez");
            t2.setPhoneNumber(555555555);
            t2.setTeacherCode("TEA002");
            session.save(t2);

            Teacher t3 = new Teacher();
            t3.setName("Pere");
            t3.setSurname("Ruiz");
            t3.setPhoneNumber(666666666);
            t3.setTeacherCode("TEA003");
            session.save(t3);

            // 1. Toyota (Car)
            Car v1 = new Car();
            v1.setBrand("Toyota");
            v1.setPrice(18000.0f);
            v1.setYear(2020);
            v1.setDoors(5);
            v1.setSeats(5);
            s1.addVehicle(v1);
            session.save(v1);

            // 2. Ford (Car)
            Car v2 = new Car();
            v2.setBrand("Ford");
            v2.setPrice(15000.0f);
            v2.setYear(2019);
            v2.setDoors(3);
            v2.setSeats(4);
            t2.addVehicle(v2);
            session.save(v2);

            // 3. Cessna (Plane)
            Plane v3 = new Plane();
            v3.setBrand("Cessna");
            v3.setPrice(120000.0f);
            v3.setYear(2015);
            v3.setTailNumber(11111);
            v3.setAutopilot(true);
            t1.addVehicle(v3);
            session.save(v3);

            // 4. Boeing (Plane)
            Plane v4 = new Plane();
            v4.setBrand("Boeing");
            v4.setPrice(900000.0f);
            v4.setYear(2010);
            v4.setTailNumber(22222);
            v4.setAutopilot(false);
            s3.addVehicle(v4);
            session.save(v4);

            // 5. Yamaha (Motorcycle)
            Motorcycle v5 = new Motorcycle();
            v5.setBrand("Yamaha");
            v5.setPrice(9000.0f);
            v5.setYear(2021);
            v5.setHasSidecar(false);
            s2.addVehicle(v5);
            session.save(v5);

            // 6. Harley-Davidson (Motorcycle)
            Motorcycle v6 = new Motorcycle();
            v6.setBrand("Harley-Davidson");
            v6.setPrice(20000.0f);
            v6.setYear(2018);
            v6.setHasSidecar(true);
            t3.addVehicle(v6);
            session.save(v6);

            transaction.commit();
            System.out.println("Fase 1 completada: Persones i Vehicles inserits.");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    private static void fase2() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Obtenim la Persona 1 i el Vehicle 1
            Person p1 = (Person) session.get(Person.class, 1);
            Vehicle v1 = (Vehicle) session.get(Vehicle.class, 1);

            if (p1 != null && v1 != null) {
                // Desassociem el vehicle de la persona
                p1.removeVehicle(v1);
                
                // Guardem els canvis
                session.update(p1);
                session.update(v1);
                
                System.out.println("Fase 2 completada: Vehicle 1 desassociat de Persona 1.");
            } else {
                System.out.println("Error: No s'ha trobat la Persona 1 o el Vehicle 1.");
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    private static void fase3() {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSession.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            // Obtenim el Vehicle amb identificador 1
            Vehicle v1 = (Vehicle) session.get(Vehicle.class, 1);

            if (v1 != null) {
                // Modifiquem les dades segons la imatge
                v1.setBrand("Seat");
                v1.setPrice(19999.0f);
                v1.setYear(2022);
                
                session.update(v1);
                System.out.println("Fase 3 completada: Dades del Vehicle 1 modificades (Seat, 19.999, 2022).");
            } else {
                System.out.println("Error: No s'ha trobat el Vehicle 1.");
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }
}
