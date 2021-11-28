package by.itacademy.javaenterprise.goralchuk.dao.implementation;

import by.itacademy.javaenterprise.goralchuk.entity.Pet;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PetDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PetDaoImplTest.class);

    private EntityManager entityManagerManager;
    private EntityTransaction entityTransactionTransaction;
    private PetDaoImpl petDao;

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.error("Test failed: {}", description, e);
        }

        @Override
        protected void succeeded(Description description) {
            logger.info("Test successes: {}", description);
        }
    };

    @Before
    public void setUp() {
        entityManagerManager = mock(EntityManager.class);
        entityTransactionTransaction = mock(EntityTransaction.class);
        petDao = new PetDaoImpl(entityManagerManager);
    }

    @Test
    public void whenFindPetById() {
        Long expectedId = 10L;
        Pet pet = new Pet(expectedId);

        when(entityManagerManager.find(Pet.class, expectedId)).thenReturn(pet);

        logger.info("FirstObject  {}", pet);
        logger.info("SecondObject  {}", petDao.find(expectedId));

        assertEquals(pet, petDao.find(expectedId));
    }

    @Test
    public void whenSavePetToDatabase() {
        Long expectedId = 10L;
        Pet pet = new Pet(expectedId);

        when(entityManagerManager.getTransaction()).thenReturn(entityTransactionTransaction);

        assertNotNull(petDao.save(pet));
        assertEquals(expectedId, petDao.save(pet).getId());
    }
}