package org.gallery.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable = false)
    private String name;

    @Column(name="img_path")
    private String imgPath;

    @Column
    private int price;

    @Column
    private int discountPer;
}
