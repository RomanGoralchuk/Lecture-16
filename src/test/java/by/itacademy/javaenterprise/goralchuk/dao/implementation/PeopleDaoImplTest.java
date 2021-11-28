package by.itacademy.javaenterprise.goralchuk.dao.implementation;

import by.itacademy.javaenterprise.goralchuk.entity.People;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PeopleDaoImplTest {
    private static final Logger logger = LoggerFactory.getLogger(PeopleDaoImplTest.class);

    private EntityManager entityManagerManager;
    private EntityTransaction entityTransactionTransaction;
    private PeopleDaoImpl peopleDao;

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
        peopleDao = new PeopleDaoImpl(entityManagerManager);
    }

    @Test
    public void whenFindPeopleById() {
        Long expectedId = 10L;
        People people = new People(expectedId);

        when(entityManagerManager.find(People.class, expectedId)).thenReturn(people);

        logger.info("FirstObject  {}", people);
        logger.info("SecondObject  {}", peopleDao.find(expectedId));

        assertEquals(people, peopleDao.find(expectedId));
    }

    @Test
    public void whenSavePeopleToDatabase() {
        Long expectedId = 10L;
        People people = new People(expectedId);

        when(entityManagerManager.getTransaction()).thenReturn(entityTransactionTransaction);

        assertNotNull(peopleDao.save(people));
        assertEquals(expectedId, peopleDao.save(people).getId());
    }
}