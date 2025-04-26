package org.example;


import jakarta.transaction.Transactional;
import org.example.relationship.manytoMany.entity.Programmer;
import org.example.relationship.manytoMany.entity.Project;
import org.example.relationship.oneToOne.entity.License;
import org.example.relationship.oneToOne.entity.Person;
import org.example.relationship.oneToOne.repository.LicenseRepository;
import org.example.relationship.oneTomany.entity.Customer;
import org.example.relationship.oneTomany.entity.PhoneNumber;
import org.example.relationship.manytoMany.repository.ProgrammerRepository;
import org.example.relationship.oneTomany.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
public class DemoApplicationTest {


    //One to Many
    @Autowired
    private CustomerRepository customerRepository;

    //Many to many
    @Autowired
    private ProgrammerRepository programmerRepository;

    //one To one
    @Autowired
    private LicenseRepository licenseRepository;

    @Test
    public void check(){
        System.out.println("hello");
    }


    @Test
    public void saveCustomer(){
        Customer customer = new Customer();
        customer.setName("Mukesh");
        PhoneNumber number = new PhoneNumber();
        number.setNumber("12345");
        number.setType("mobile");
        customer.addPhoneNumber(number);
        customerRepository.save(customer);
    }
    @Test
  //  @Transactional  /// this is required for lazy loading Fetch type otherwise you will get exception
    public void getCustomer(){
        Optional<Customer> customer = customerRepository.findById(3L);
        if(customer.isPresent()){
            Customer c = customer.get();
            System.out.println("customer " +c);
        }
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = customerRepository.findById(3L).get();
        customer.setName("John Bush");

        Set<PhoneNumber> numbers = customer.getPhoneNumbers();
        numbers.forEach(number -> number.setType("cell"));

        customerRepository.save(customer);

    }

    @Test
    public void testDelete() {
        customerRepository.deleteById(3l);
    }



    @Test
   @Transactional
    public void testmtomFindProgrammer() {
        Programmer programmer = programmerRepository.findById(1L).get();
        System.out.println(programmer);
    }


    @Test
    public void saveProgrammer(){
        Programmer p1 = new Programmer();
        p1.setName("Ajay");
        p1.setSalary(20000);

        HashSet<Project> projects = new HashSet<>();
        Project project = new Project();
        project.setName("xyz");

        projects.add(project);

        p1.setProjects(projects);
        programmerRepository.save(p1);
    }

    @Test
    public void saveLicense(){

        License l1 = new License();
        l1.setType("y");
        l1.setValidFrom(new Date());
        l1.setValidTo(new Date());

        Person person = new Person();
        person.setAge(20);
        person.setFirstName("John");
        person.setLastName("Millar");
        l1.setPerson(person);

        licenseRepository.save(l1);

    }
    @Test
    public void  getLicence(){
        Optional<License> license = licenseRepository.findById(2L);
        if(license.isPresent()){
            System.out.println(license.get());
        }
    }




}
