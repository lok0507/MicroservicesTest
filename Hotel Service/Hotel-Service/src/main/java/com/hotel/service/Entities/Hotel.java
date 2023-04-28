package com.hotel.service.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Hotel {

    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
