package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.PaidTaxesDto;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class PaidTaxesDao {
    public static void createPaidTaxes(PaidTaxes paidTaxes) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(paidTaxes);
            transaction.commit();
        }
    }

    public static PaidTaxes getPaidTaxesById(long id) {
        PaidTaxes paidTaxes;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            paidTaxes = session.get(PaidTaxes.class, id);
            transaction.commit();
        }
        return paidTaxes;
    }

    public static List<PaidTaxes> getPaidTaxes() {
        List<PaidTaxes> companies;
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("Select a From PaidTaxes a", PaidTaxes.class)
                    .getResultList();
            transaction.commit();
        }
        return companies;
    }

    public static void updatePaidTaxes(PaidTaxes paidTaxes) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(paidTaxes);
            transaction.commit();
        }
    }

    public static void deletePaidTaxes(PaidTaxes paidTaxes) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(paidTaxes);
            transaction.commit();
        }
    }

    public static List<PaidTaxes> findPaidTaxesByEmployeeId(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PaidTaxes> cr = cb.createQuery(PaidTaxes.class);
            Root<PaidTaxes> root = cr.from(PaidTaxes.class);

            cr.select(root).where(cb.equal(root.get("employee_tax"), id));

            Query<PaidTaxes> query = session.createQuery(cr);
            List<PaidTaxes> paidTaxes = query.getResultList();
            return paidTaxes;
        }
    }

    public static List<PaidTaxes> findPaidTaxesByApartmentId(long id) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<PaidTaxes> cr = cb.createQuery(PaidTaxes.class);
            Root<PaidTaxes> root = cr.from(PaidTaxes.class);

            cr.select(root).where(cb.equal(root.get("apartment_tax"), id));

            Query<PaidTaxes> query = session.createQuery(cr);
            List<PaidTaxes> paidTaxes = query.getResultList();
            return paidTaxes;
        }
    }


    public static PaidTaxesDto createPaidTaxesDTO(PaidTaxes paidTaxes) {
        //Company_name, Employee_name, Building_district+address, paidTaxes_sum, paidTaxes_date

        Company company = paidTaxes.getEmployee_tax().getCompany();
        String company_name = company.getName();

        Employee employee = paidTaxes.getEmployee_tax();
        String employee_name = employee.getName();

        Building building = paidTaxes.getApartment_tax().getBuilding();
        String buildingDistrict = building.getDistrict();
        String buildingAddress = building.getAddress();

        Apartment apartment = paidTaxes.getApartment_tax();
        int apartmentFloor = apartment.getFloor();
        int apartmentNumber = apartment.getNumber();

        double amount = paidTaxes.getAmount();
        LocalDate date = paidTaxes.getDate();


        PaidTaxesDto paidTaxesDto = new PaidTaxesDto(
                company_name, employee_name,
                buildingDistrict, buildingAddress,
                apartmentFloor, apartmentNumber,
                amount, date);

        return paidTaxesDto;
    }


}