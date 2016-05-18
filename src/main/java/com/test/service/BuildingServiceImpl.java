package com.test.service;

import com.test.dao.BuildingDao;
import com.test.dto.BuildingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Евгений on 18.05.2016.
 */
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingDao buildingDao;

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO building) {
        return buildingDao.save(building);
    }

    @Override
    @Transactional
    public void deleteAll() {
        buildingDao.deleteAll();
    }

    @Override
    public List<BuildingDTO> findAll() {
        return buildingDao.findAll();
    }

    @Override
    public BuildingDTO find(Integer id) {
        return buildingDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(BuildingDTO building) {
        buildingDao.delete(building);
    }
}
