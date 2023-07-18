package com.java.Project.Repositories;

import com.java.Project.Entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address,Integer> {
}
