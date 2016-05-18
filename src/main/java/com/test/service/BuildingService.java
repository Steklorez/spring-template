package com.test.service;

import com.test.dto.BuildingDTO;

import java.util.List;

/**
 * Created by Евгений on 18.05.2016.
 */
public interface BuildingService {

    BuildingDTO save(BuildingDTO building);

    void deleteAll();

    List<BuildingDTO> findAll();

    BuildingDTO find(Integer id);

    void delete(BuildingDTO building);
}
