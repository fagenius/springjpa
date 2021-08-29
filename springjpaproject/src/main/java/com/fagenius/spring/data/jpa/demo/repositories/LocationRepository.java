package com.fagenius.spring.data.jpa.demo.repositories;

import com.fagenius.spring.data.jpa.demo.entities.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location,String> {
}
