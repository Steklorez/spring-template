package com.test.dto;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Евгений on 18.05.2016.
 */
@Data
@Entity
@Table(name = "room", schema = "public", catalog = "test")
public class RoomDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")
    private BuildingDTO building;

    @Column(name = "number", nullable = false)
    private Integer number;

    public RoomDTO(BuildingDTO building, Integer number) {
        this.building = building;
        this.number = number;
    }

    public RoomDTO() {

    }
}
