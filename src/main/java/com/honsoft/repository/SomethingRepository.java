package com.honsoft.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SomethingRepository extends PagingAndSortingRepository<Something, Long> {
    @Query("Select s from  Something s "
            + "join s.somethingelse as se "
            + "where se.id = :somethingelseid ")
    Page<Something> findBySomethingElseId(@Param("somethingelseid") long somethingelseid,
                                                                        Pageable pageable);