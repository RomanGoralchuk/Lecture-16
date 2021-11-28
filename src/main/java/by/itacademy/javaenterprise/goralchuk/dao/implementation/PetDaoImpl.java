package by.itacademy.javaenterprise.goralchuk.dao.implementation;

import by.itacademy.javaenterprise.goralchuk.dao.PetDao;
import by.itacademy.javaenterprise.goralchuk.entity.Pet;
import by.itacademy.javaenterprise.goralchuk.entity.PetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class PetDaoImpl implements PetDao {
    private static final Logger logger = LoggerFactory.getLogger(PetDaoImpl.class);

    private EntityManager entityManager;

    public PetDaoImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Pet find(Long id) {
        Pet pet = entityManager.find(Pet.class, id);
        if (pet == null) {
            logger.debug("Object not found");
            return null;
        } else {
            logger.debug("Operation completed");
            return pet;
        }
    }

    @Override
    public Pet save(Pet pet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pet);
            entityManager.getTransaction().commit();
            logger.debug("The transaction was successful - {}", pet.getId());
            return pet;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.error("Transaction failed {}", e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public long delete(Long id) {
       return 0;
    }

    @Override
    public List<Pet> findAll() {
        return Collections.emptyList();
    }

    @Override
    public List<Pet> getAllPetByType(PetType petType) {
        return Collections.emptyList();
    }
}
