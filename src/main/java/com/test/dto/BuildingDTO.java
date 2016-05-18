package com.test.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Евгений on 18.05.2016.
 */
@Data
@Entity
@Table(name = "building", schema = "public", catalog = "test")
public class BuildingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

//    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
//    private List<RoomDTO> rooms;

    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
    private List<RoomDTO> rooms;


//    @OneToMany(targetEntity = RoomDTO.class, mappedBy = "building")
//    private List rooms;

//    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
//    private List<RoomDTO> rooms;

//    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
//    private List<RoomDTO> rooms;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "building")
//    @JoinColumn(name="building_id")
//    private List<RoomDTO> rooms;

    public BuildingDTO(Integer number) {
        this.number = number;
    }
}
