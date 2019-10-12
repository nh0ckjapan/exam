package com.t1708e.examspring.repository;

import com.t1708e.examspring.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookDetail,Integer> {
    @Query("select n from BookDetail as n where n.name like %:name% or n.author like %:name% or n.genre like %:name%")
    List<BookDetail> findAllByName(@Param("name") String name);
}
