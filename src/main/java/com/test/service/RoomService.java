package com.test.service;

import com.test.dto.RoomDTO;

import java.util.List;

/**
 * Created by Евгений on 18.05.2016.
 */
public interface RoomService {

    RoomDTO save(RoomDTO room);

    void deleteAll();

    List<RoomDTO> findAll();

    RoomDTO find(Integer id);

    void delete(RoomDTO room);
}
