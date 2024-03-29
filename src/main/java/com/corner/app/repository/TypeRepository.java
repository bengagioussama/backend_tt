package com.corner.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.corner.app.entity.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByTypeName(String typeName);
}

