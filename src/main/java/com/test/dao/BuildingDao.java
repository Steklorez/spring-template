package com.test.dao;

import com.test.dto.BuildingDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Евгений on 18.05.2016.
 */
public interface BuildingDao extends JpaRepository<BuildingDTO, Integer> {
}
