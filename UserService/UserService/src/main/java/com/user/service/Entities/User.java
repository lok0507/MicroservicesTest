package com.user.service.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userid;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
