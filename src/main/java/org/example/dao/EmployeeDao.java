package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.BuildingDto;
import org.example.dto.EmployeeDto;
import org.example.entity.Company;
import org.example.entity.Employee;
import org.example.entity.Building;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class EmployeeDao {
    public static void createCompany(Company company) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }

    public static Employee getEmployeeById(long id) {
        Employee employee;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employee = session.get(Employee.class, id);

            transaction.commit();
        }

        return employee;
    }


    public static List<Employee> getEmployees() {
        List<Employee> employees;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            employees = session.createQuery("Select e from Employee e", Employee.class)
                .getResultList();

            transaction.commit();
        }

        return employees;
    }

    public static void updateEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);

            transaction.commit();
        }
    }

    public static void deleteEmployee(Employee employee) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);

            transaction.commit();
        }
    }

    //============================================================
    //Не знам дали работи?????????????????????????????????????????
    public static List<Employee> EmployeesOrderByBuildingsAsc() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
            Root<Employee> root = cr.from(Employee.class);

            cr.select(root).orderBy(cb.asc(root.get("buildings")));

            Query<Employee> query = session.createQuery(cr);
            List<Employee> companies = query.getResultList();

            return companies;
        }
    }


    public static List<BuildingDto> getEmployeeBuildingsDTO(long id) {
        List <BuildingDto> buildings;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            buildings = session.createQuery(
                            "select new org.example.dto.BuildingDto(b.id, b.district, b.address) from Building b" +
                                    " join b.employee e " +
                                    "where e.id = :id",
                            BuildingDto.class)
                    .setParameter("id", id)
                    .getResultList();

            transaction.commit();
        }

        return buildings;
    }

}
