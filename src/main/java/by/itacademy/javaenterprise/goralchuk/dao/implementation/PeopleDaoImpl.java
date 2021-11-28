package by.itacademy.javaenterprise.goralchuk.dao.implementation;

import by.itacademy.javaenterprise.goralchuk.dao.PeopleDao;
import by.itacademy.javaenterprise.goralchuk.entity.People;
import by.itacademy.javaenterprise.goralchuk.entity.PetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class PeopleDaoImpl implements PeopleDao {
    private static final Logger logger = LoggerFactory.getLogger(PeopleDaoImpl.class);

    private EntityManager entityManager;

    public PeopleDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public People find(Long id) {
        People people = entityManager.find(People.class, id);
        if (people == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return people;
        }
    }

    @Override
    public People save(People people) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(people);
            entityManager.getTransaction().commit();
            logger.debug("The transaction was successful - {}", people.getId());
            return people;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Transaction failed {}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public People update(People people) {
        return null;
    }


    @Override
    public long delete(Long id) {
        return 0;
    }

    @Override
    public List<People> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<People> getAllPeopleByPetType(PetType petType) {
        return Collections.emptyList();
    }
}
