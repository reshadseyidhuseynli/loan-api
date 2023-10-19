package com.company.loanapi.repository;

import com.company.loanapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Query(value = "UPDATE customer SET contact_id = ?1, address_id = ?2 WHERE id = ?3", nativeQuery = true)
    void addContactAndAddressToCustomer(Integer contactId, Integer addressId, Integer id);

}
