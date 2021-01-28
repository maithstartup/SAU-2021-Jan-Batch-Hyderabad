package ilear.hibernate;

import ilear.hibernate.entity.Address;
import ilear.hibernate.entity.Employee;

import ilear.hibernate.entity.EmployeeDetails;
import ilear.hibernate.entity.ILearnSessions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;


public class EmployeeDemo {

    public static void main(String[] args) {




        SessionFactory sessionFactory= new Configuration().configure("hibernate-cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(ILearnSessions.class).buildSessionFactory();

        Session session = sessionFactory.openSession();

        Employee employee1 = new Employee("Maithreyan","Kesavan");
        Employee employee2 = new Employee("Ashwin","Thanraj");

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployee(employee1);
        employeeDetails.setEmail("surya@gmail.com");
        employeeDetails.setPhone("9988776655");

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        employeeDetails2.setEmployee(employee2);
        employeeDetails2.setEmail("ash@gmail.com");
        employeeDetails2.setPhone("9897969594");

        Address address1 =new Address("PV kovil Street","Chennai",600013);
        Address address2 =new Address("Kumarn Street","Coimbatore",641014);
        Set<Address> addresses=new HashSet<>();
        addresses.add(address1);
        addresses.add(address2);
        employee1.setAddresses(addresses);

        Address empAddress = new Address();
        empAddress.setCity("Chennai");
        empAddress.setStreetName("Royapuram");
        empAddress.setPinCode(600013);
        empAddress.setEmployeeId(1);

        Address empAddress2 = new Address();
        empAddress2.setCity("Coimbatore");
        empAddress2.setStreetName("kumaran Nagar");
        empAddress2.setPinCode(641014);
        empAddress2.setEmployeeId(1);

        Address empAddress3 = new Address();
        empAddress3.setCity("Thirunelveli");
        empAddress3.setStreetName("chinna theru");
        empAddress3.setPinCode(674444);
        empAddress3.setEmployeeId(2);




//        employee1.getSkillSet().add("python");
//        employee1.getSkillSet().add("java");



        ILearnSessions iLearn1 = new ILearnSessions();
        ILearnSessions iLearn2 = new ILearnSessions();
        iLearn1.setSessionName("Advan java");
        iLearn2.setSessionName("javascript");

        employee1.getILearn().add(iLearn1);
        employee1.getILearn().add(iLearn2);
        employee2.getILearn().add(iLearn2);

        iLearn1.getEmployees().add(employee1);
        iLearn2.getEmployees().add(employee1);
        iLearn2.getEmployees().add(employee2);


        try{

            session.beginTransaction();
            //session.save(iLearn);
            session.save(employee1);
            session.save(employee2);
            session.save(address1);
            session.save(address2);
            session.save(employee1);
            session.save(employee2);
            session.save(empAddress);
            session.save(empAddress2);
            session.save(empAddress3);
            session.save(employeeDetails);
            session.save(employeeDetails2);


            session.getTransaction().commit();

            Employee empFromDB = session.get(Employee.class,1);
            System.out.println("Retrived from DB " + empFromDB.getFirstName());
//            System.out.println("Skiils from"+ empFromDB.getSkillSet());
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
