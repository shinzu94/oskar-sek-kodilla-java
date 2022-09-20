package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        int johnSmithId = johnSmith.getId();
        int stephanieClarcksonId = stephanieClarckson.getId();
        int lindaKovalskyId = lindaKovalsky.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);
        assertNotEquals(0, johnSmithId);
        assertNotEquals(0, stephanieClarcksonId);
        assertNotEquals(0, lindaKovalskyId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(stephanieClarcksonId);
            companyDao.deleteById(lindaKovalskyId);

            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaKovalskyId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testNamedQueries() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieSmith = new Employee("Stephanie", "Smith");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company dataMatter = new Company("Data Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieSmith);
        dataMaesters.getEmployees().add(lindaKovalsky);
        dataMatter.getEmployees().add(johnSmith);
        dataMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(dataMatter);
        stephanieSmith.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMatter);

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(dataMatter);
        int greyMatterId = dataMatter.getId();


        int johnSmithId = johnSmith.getId();
        int stephanieSmithId = stephanieSmith.getId();
        int lindaKovalskyId = lindaKovalsky.getId();

        //When
        List companies = companyDao.findByFirstThreeLetters("Dat");
        List employees = employeeDao.findEmployeesByLastname("Smith");

        //Then
        assertEquals(2, companies.size());
        assertEquals(2, employees.size());

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);

            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieSmithId);
            employeeDao.deleteById(lindaKovalskyId);
        } catch (Exception e) {
            //do nothing
        }
    }
}