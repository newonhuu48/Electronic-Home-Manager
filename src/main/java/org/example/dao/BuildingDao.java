package org.example.dao;

import org.example.configuration.SessionFactoryUtil;
import org.example.dto.ApartmentDto;
import org.example.dto.BuildingDto;
import org.example.dto.EmployeeDto;
import org.example.entity.Building;
import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class BuildingDao {
    public static void createBuilding(Building building) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(building);
            transaction.commit();
        }
    }

    public static Building getBuildingById(long id) {
        Building building;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            building = session.get(Building.class, id);
            transaction.commit();
        }
        return building;
    }

    public static List<Building> getBuildings() {
        List<Building> companies;
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            companies = session.createQuery("Select b From Building b", Building.class)
                    .getResultList();
            transaction.commit();
        }
        return companies;
    }

    public static void updateBuilding(Building building) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(building);
            transaction.commit();
        }
    }

    public static void deleteBuilding(Building building) {
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(building);
            transaction.commit();
        }
    }


    public static List<ApartmentDto> getBuildingApartmentsDTO(long id) {
        List <ApartmentDto> apartments;

        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();


            apartments = session.createQuery(
                            "select new org.example.dto.ApartmentDto(a.id, a.floor, a.number) from Apartment a" +
                                    " join a.building b " +
                                    "where b.id = :id",
                            ApartmentDto.class)
                    .setParameter("id", id)
                    .getResultList();

            transaction.commit();
        }

        return apartments;
    }
}
