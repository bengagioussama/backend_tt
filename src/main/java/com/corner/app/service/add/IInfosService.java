package com.corner.app.service.add;

import com.corner.app.entity.Infos;

import java.util.List;
import java.util.Optional;

public interface IInfosService {
    Infos addInfos(Infos infos);
    List<Infos> getAllInfos();
    public Optional<Infos> getInfoById(Long id);
    public Infos updateInfo(Long id, Infos updatedInfo);
    public void deleteInfo(Long id);

}
