package com.shop.advance.academy.yordan.petrov.git.shop.data.dao;

import com.shop.advance.academy.yordan.petrov.git.shop.data.models.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface dao for .
 *
 * @author Yordan Petrov
 * @version 1.0.0.0
 * @since Jul 8, 2020.
 */
@Repository
public interface OpinionDao extends JpaRepository<Opinion, Long> {

    /**
     * @param id
     * @return
     */
    Optional<Opinion> findById(Long id);

}
