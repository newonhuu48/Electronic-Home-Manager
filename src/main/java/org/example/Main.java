package org.example;

import org.example.dao.*;
import org.example.dto.ApartmentDto;
import org.example.dto.PaidTaxesDto;
import org.example.entity.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.time.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println("Hello World");


        //1.
        /*
        CompanyDao.createCompany();
        CompanyDao.getCompanyById();
        CompanyDao.getCompanies();
        CompanyDao.updateCompany();
        CompanyDao.deleteCompany();
        */

        //2.
        /*
        Аналогично на 1.

        */


        //3.
        /*
        Собственици на апартаменти и живущи в тях те съм направил на отделни таблица
         */


        //4.
        /*
        Аналогично на 1. и 2.
         */



        //5.
        /*
        EmployeeDao.getEmployeeBuildingsDTO(2).stream().forEach(System.out::println);
        */


        //6.
        /*
        Не съм въвеждал конкретно такса
        Може да се преправи PaidTaxes, така че да му се подава апартамент
        вместо стойността на сметката и да я изчислява
         */


        //7.
        /*
        Определя се с обекта PaidTaxes, който отговаря на M:N таблицата
        Таксата е 2 * площ на апартамен плюс 30 на жител

        Има и ДТО за обекта Платена такса, използва се в 10.


        Apartment apartment = ApartmentDao.getApartmentById(5);

        PaidTaxes tax1 = new PaidTaxes(apartment, LocalDate.of(2024, 7, 6) );

        System.out.println(tax1);
         */


        //8.
        /*
            а)
            CompanyDao.companiesFindByIncomeGreaterThan(6000);
            CompanyDao.companiesOrderByIncomeAsc();

            б)
            Затрудних се да изчисля размера на множествата на служителите
            с обслужваните им сгради
            но мисля, че се ползва ДТО за това, а го имам готово
            просто частта със сортирането по този признак би била сложна

            в)
            В моята база няма таква таблица, пропуснато е

         */


        //9.


        /*
        List<Building> buildings = BuildingDao.getBuildings();

        for(Building building : buildings) {
            System.out.println("Building{ " + building.getDistrict() + " : "+ building.getAddress() + " }\n\n");

            List<ApartmentDto> apartments = BuildingDao.getBuildingApartmentsDTO(building.getId());

                for(ApartmentDto apartment : apartments) {
                    System.out.println(apartment + "\n");
                }

                System.out.println("\n\n\n");
        }
        */


        //CompanyDao.companiesOrderByIncomeAsc().stream().forEach(System.out::println);


        //10.
        /*
        PaidTaxes tax1 = PaidTaxesDao.getPaidTaxesById(1);

        PaidTaxesDto tax1dto = PaidTaxesDao.createPaidTaxesDTO(tax1);

        FileWriter fr = null;

        try {
            fr = new FileWriter("taxes.txt");

            fr.write(tax1dto.toString());

        } catch(IOException e) {
            System.out.println("An I/O error has occured.");
            e.printStackTrace();

        } finally {
            if(fr != null) {
                fr.close();
            }
        }
        */




        //PaidTaxes t1 = new PaidTaxes(160, LocalDate.of(2020, 5, 7) );



        //Company company = new Company("Rise and Glow", 5500);

        //CompanyDao.createCompany(company);

        /*

        Company company = new Company("nestle", LocalDate.of(1999, 3, 3), BigDecimal.valueOf(10000));

        //  Create company
        CompanyDao.createCompany(company);

        // Get company by id
        Company company5 = CompanyDao.getCompanyById(5);
        System.out.println(company5);

        // Get companies
        CompanyDao.getCompanies().stream().forEach(System.out::println);

        // Update company with id = 1
        // company.setId(1);
        // CompanyDao.updateCompany(company);

        // Delete Company with id 5
        // CompanyDao.deleteCompany(company5);

        // Get companies with initial capital between 4000 and 8000
        System.out.println("------------------ CompanyDao.companiesFindByInitialCapitalBetween ------------------");
        CompanyDao.companiesFindByInitialCapitalBetween(4000, 8000)
                .stream()
                .forEach(System.out::println);

        System.out.println();

        // Get companies with name starting with "Nes" and initial capital greater than 6500
        System.out.println("------------------ CompanyDao.findByNameStartingWithAndInitialCapitalGreaterThan ------------------");
        CompanyDao.findByNameStartingWithAndInitialCapitalGreaterThan("Nes", 6500)
                .stream()
                .forEach(System.out::println);


        System.out.println("Sum initialCapital = " + CompanyDao.sumInitialCapital());
        System.out.println();

        company = CompanyDao.getCompanyById(1);
        System.out.println(company);

        // Get company's employees using JOIN FETCH
        CompanyDao.getCompanyEmployees(1)
                .stream()
                .forEach(System.out::println);


        // Get company's employees using DTO Projection
        CompanyDao.getCompanyEmployeesDTO(1)
                .stream()
                .forEach(System.out::println);

        */
    }
}