package com.corner.app.repository;

import com.corner.app.entity.Infos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<Infos, Long> {
    @Override
    List<Infos> findAll();
    @Transactional
    @Modifying
    @Query("delete from Infos i where i.id = ?1")
    void deleteById(int id);


}
