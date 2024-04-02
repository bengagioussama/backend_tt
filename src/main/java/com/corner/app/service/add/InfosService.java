package com.corner.app.service.add;

import com.corner.app.entity.Infos;
import com.corner.app.repository.InfoRepository;
import com.corner.app.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfosService implements IInfosService{
    private final InfoRepository infoRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public InfosService(InfoRepository infoRepository, TypeRepository typeRepository) {
        this.infoRepository = infoRepository;
        this.typeRepository = typeRepository;
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
            existingInfo.setDebit(updatedInfo.getDebit());
            existingInfo.setVolume(updatedInfo.getVolume());
            existingInfo.setPH(updatedInfo.getPH());
            existingInfo.setTypeId(updatedInfo.getTypeId());
            return infoRepository.save(existingInfo);
        } else {
            return null;
        }

    }

    @Override
    public void deleteInfo(Long id) {
        infoRepository.deleteById(id);
    }

}
