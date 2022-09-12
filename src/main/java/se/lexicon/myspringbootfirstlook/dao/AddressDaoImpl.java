package se.lexicon.myspringbootfirstlook.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.myspringbootfirstlook.model.Address;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class AddressDaoImpl implements AddressDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Address save(Address address) {
        if (address == null) throw new IllegalArgumentException("Address was null");
        entityManager.persist(address);
        return address;
    }

    @Transactional
    @Override
    public Optional<Address> findById(int id) {
        if (id <= 0) throw new IllegalArgumentException("Invalid ID");
        Address address = entityManager.find(Address.class, id);
        return Optional.ofNullable(address);
    }

    @Override
    public List<Address> findAll() {
        Query selectQuery = entityManager.createQuery("SELECT s FROM Address s");
        return selectQuery.getResultList();
    }

    @Transactional
    @Override
    public void remove(Address address) {
            findById(address.getUserId()).orElseThrow(() -> new IllegalArgumentException("Data not found"));
            entityManager.remove(address);
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Transactional
    @Override
    public List<Address> saveAddresses(List<Address> addresses) {
            addresses.forEach(this::save);
            return addresses;
    }
}
