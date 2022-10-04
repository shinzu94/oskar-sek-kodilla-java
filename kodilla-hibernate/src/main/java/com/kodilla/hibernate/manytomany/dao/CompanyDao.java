package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> findByFirstThreeLetters(@Param("firstThreeLetters") String firstThreeLetters);

    @Query
    List<Company> findByName(@Param("name") String name);

}