package com.test.dao;

import com.test.dto.RoomDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Евгений on 18.05.2016.
 */
public interface RoomDao extends JpaRepository<RoomDTO, Integer> {
}
