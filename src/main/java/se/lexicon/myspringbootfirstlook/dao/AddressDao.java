package se.lexicon.myspringbootfirstlook.dao;

import se.lexicon.myspringbootfirstlook.model.Address;
import se.lexicon.myspringbootfirstlook.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AddressDao {

    Address save(Address address);
    Optional<Address> findById(int id);
    List<Address> findAll();
    void remove(Address address);
    Address update(Address address);
    List<Address> saveAddresses(List<Address> address);
}
