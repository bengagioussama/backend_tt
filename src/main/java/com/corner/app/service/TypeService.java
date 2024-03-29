// TypeService.java
package com.corner.app.service;

import com.corner.app.entity.Type;
import com.corner.app.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type getTypeById(Long id) {
        Optional<Type> optionalType = typeRepository.findById(id);
        return optionalType.orElse(null);
    }

    public Type createType(Type type) {

        return typeRepository.save(type);
    }

    public Type updateType(Long id, Type type) {
        type.setId(id);
        return typeRepository.save(type);
    }

    public void deleteType(Long id) {
        if (typeRepository.existsById(id)) {
            typeRepository.deleteById(id);
        } else {
            throw new NotFoundException("Type not found with id: " + id);
        }
    }
}
