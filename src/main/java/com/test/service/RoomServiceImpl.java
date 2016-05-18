package com.test.service;

import com.test.dao.RoomDao;
import com.test.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Евгений on 18.05.2016.
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    @Transactional
    public RoomDTO save(RoomDTO room) {
        return roomDao.save(room);
    }

    @Override
    @Transactional
    public void deleteAll() {
        roomDao.deleteAll();
    }

    @Override
    public List<RoomDTO> findAll() {
        return roomDao.findAll();
    }

    @Override
    public RoomDTO find(Integer id) {
        return roomDao.findOne(id);
    }

    @Override
    @Transactional
    public void delete(RoomDTO room) {
        roomDao.delete(room);
    }
}
