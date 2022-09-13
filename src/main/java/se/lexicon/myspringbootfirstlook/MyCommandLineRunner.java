package se.lexicon.myspringbootfirstlook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import se.lexicon.myspringbootfirstlook.dao.AppUserDao;
import se.lexicon.myspringbootfirstlook.model.Address;
import se.lexicon.myspringbootfirstlook.model.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Profile(value = "dev")
@Transactional
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    public MyCommandLineRunner(AppUserDao appUserDao, EntityManager entityManager){
        this.appUserDao = appUserDao;
        this.entityManager = entityManager;
    }

    private final AppUserDao appUserDao;
    private final EntityManager entityManager;


    @Override
    public void run(String... args) throws Exception {

        AppUser appUserRager = new AppUser("rager@mail.com", "Råger Rågersson", "123456");
        entityManager.persist(appUserRager);
        System.out.println(appUserRager);

        appUserRager = appUserDao.save(appUserRager);

        Address addressRager = new Address("Götteborg","Gata 3","121 12");
        entityManager.persist(addressRager);
        appUserRager.setAddress(addressRager);

        entityManager.flush();

        System.out.println("Råger = " + appUserRager);




//        AppUser appUserStefan = new AppUser("stefan@mail.com", "Stefan Stefansson", "qwerty");
//        entityManager.persist(appUserStefan);
//        System.out.println(appUserStefan);
//
//        appUserStefan = appUserDao.save(appUserStefan);
//
//        Address addressStefan = new Address(0,"Stökholm", "Gata 2", "313 12");
//        entityManager.persist(addressStefan);
//        appUserStefan.setAddress(addressStefan);
//
//        entityManager.flush();
//
//        System.out.println("Stefan = " + appUserStefan);


    }
}
