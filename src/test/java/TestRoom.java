import com.test.configuration.SpringConfiguration;
import com.test.dto.BuildingDTO;
import com.test.dto.RoomDTO;
import com.test.service.BuildingService;
import com.test.service.RoomService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Евгений on 18.05.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRoom {

    @Autowired
    private RoomService roomService;
    @Autowired
    private BuildingService buildingService;

    @Test
    public void test1Save() {
        Assert.assertNotNull(createNewRoom(1).getId());
    }

    @Test
    public void test2FindAll() {
        createNewRoom(1);
        Assert.assertEquals(1, roomService.findAll().size());
    }

    @Test
    public void test3DeleteAll() {
        createNewRoom(1);
        roomService.deleteAll();
        Assert.assertEquals(0, roomService.findAll().size());
    }

    @Test
    public void test4FindById() {
        Assert.assertNotNull(roomService.find(createNewRoom(1).getId()));
    }

    @Test
    public void test5Delete() {
        roomService.delete(createNewRoom(1));
        Assert.assertEquals(0, roomService.findAll().size());
    }

    @Test
    public void test6OneToManyMapping() {
        BuildingDTO newBuilding = buildingService.save(new BuildingDTO(1));
        RoomDTO room = new RoomDTO();
        room.setNumber(1);
        room.setBuilding(newBuilding);
        roomService.save(room);

        Assert.assertNotNull(room.getId());
        Assert.assertNotNull(room.getBuilding());
        Assert.assertNotNull(roomService.find(room.getId()).getBuilding());




        List<RoomDTO> rooms = buildingService.findAll().get(0).getRooms();
        Assert.assertNotNull(rooms);
        Integer id = rooms.get(0).getId();
        Assert.assertNotNull(id);
    }

    private RoomDTO createNewRoom(Integer number) {
        BuildingDTO building = buildingService.save(new BuildingDTO(1));
        RoomDTO room = new RoomDTO(building, number);
        return roomService.save(room);
    }
}
