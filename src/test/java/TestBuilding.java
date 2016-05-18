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
public class TestBuilding {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private RoomService roomService;

    @Test
    public void test1Save() {
        Assert.assertNotNull(createNewBuilding(1).getId());
    }

    @Test
    public void test2FindAll() {
        createNewBuilding(1);
        Assert.assertEquals(1, buildingService.findAll().size());
    }

    @Test
    public void test3DeleteAll() {
        createNewBuilding(1);
        buildingService.deleteAll();
        Assert.assertEquals(0, buildingService.findAll().size());
    }

    @Test
    public void test4FindById() {
        Assert.assertNotNull(buildingService.find(createNewBuilding(1).getId()));
    }

    @Test
    public void test5Delete() {
        buildingService.delete(createNewBuilding(1));
        Assert.assertEquals(0, buildingService.findAll().size());
    }

    @Test
    public void test6ManyToOneMapping() {
        BuildingDTO newBuilding = buildingService.save(new BuildingDTO(1));
        Integer newBuildingId = newBuilding.getId();
        roomService.save(new RoomDTO(newBuilding, 1)).getId();

        List<RoomDTO> rooms = roomService.findAll();
        BuildingDTO building = rooms.get(0).getBuilding();
        Assert.assertEquals(newBuildingId, building.getId());
    }

    private BuildingDTO createNewBuilding(Integer number) {
        return buildingService.save(new BuildingDTO(number));
    }

    private RoomDTO createNewRoom(BuildingDTO building, Integer number) {
        RoomDTO room = new RoomDTO(building, number);
        return roomService.save(room);
    }
}
