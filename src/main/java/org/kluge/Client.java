package org.kluge;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by giko on 5/22/2016.
 */
@Entity
@Data
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    @Basic
    private String name;
}
