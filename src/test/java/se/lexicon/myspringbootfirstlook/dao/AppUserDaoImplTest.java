package se.lexicon.myspringbootfirstlook.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import se.lexicon.myspringbootfirstlook.model.AppUser;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestEntityManager
@DirtiesContext
@Transactional
class AppUserDaoImplTest {

    @Autowired
    AppUserDao appUserDao;

    @Autowired
    TestEntityManager entityManager;


//    @Test
//    void save() {
//
//        AppUser appUser = new AppUser("Test", "Testsson", "test@mail.com", LocalDate.parse("2022-02-02"), true);
//        appUserDao.save(appUser);
//
//        Assertions.assertNotEquals(0, appUser.getUserId());
//
//    }
//
//    @Test
//    void findById() {
//
//        AppUser appUser = new AppUser("Test2", "Testsson2", "test2@mail.com", LocalDate.parse("2022-03-03"), false);
//
//        Integer id = entityManager.persistAndGetId(appUser, Integer.class);
//        entityManager.clear();
//
//        Optional<AppUser> studentDaoById = appUserDao.findById(id);
//
//        assertTrue(studentDaoById.isPresent());
//        Assertions.assertEquals(id, studentDaoById.get().getId());
//    }
//
//    @Test
//    void findByFirstName(){
//
//        List<AppUser> found = appUserDao.findByFirstName("Råger");
//        found.forEach(System.out::println);
//
//        assertFalse(found.isEmpty());
//    }
}