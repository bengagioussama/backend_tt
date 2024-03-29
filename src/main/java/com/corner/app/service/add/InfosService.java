package com.corner.app.service.add;

import com.corner.app.entity.Infos;
import com.corner.app.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfosService implements IInfosService{
    private final InfoRepository infoRepository;

    @Autowired
    public InfosService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    @Override
    public Infos addInfos(Infos infos) {
        return infoRepository.save(infos);
    }

    @Override
    public List<Infos> getAllInfos() {
        return infoRepository.findAll();
    }

    @Override
    public Optional<Infos> getInfoById(Long id) {
        return infoRepository.findById(id);
    }

    @Override
    public Infos updateInfo(Long id, Infos updatedInfo) {
        Optional<Infos> existingInfoOptional = infoRepository.findById(id);
        if (existingInfoOptional.isPresent()) {
            Infos existingInfo = existingInfoOptional.get();
            // Update the fields you want to allow modification for
            existingInfo.setDebit(updatedInfo.getDebit());
            existingInfo.setVolume(updatedInfo.getVolume());
            existingInfo.setPH(updatedInfo.getPH());
            existingInfo.setType(updatedInfo.getType());
            return infoRepository.save(existingInfo);
        } else {
            // Handle error if Info with given id is not found
            return null;
        }

    }

    @Override
    public void deleteInfo(Long id) {
        infoRepository.deleteById(id);
    }

}
