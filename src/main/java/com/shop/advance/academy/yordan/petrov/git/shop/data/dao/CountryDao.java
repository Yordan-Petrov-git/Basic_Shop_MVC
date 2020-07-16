package com.shop.advance.academy.yordan.petrov.git.shop.data.dao;


import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryDao extends JpaRepository<Country, Long> {

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);
}
