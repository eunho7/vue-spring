package com.aws.gallery.entity;

import com.aws.gallery.dto.ResponseItemDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name="img_path")
    private String imgPath;

    @Column
    private int price;

    @Column
    private int discountPer;

    @Builder
    public Item(int id, String name, String imgPath, int price, int discountPer) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
        this.price = price;
        this.discountPer = discountPer;
    }

    public static Item toEntity(ResponseItemDTO itemDTO) {
        return Item.builder()
                .id(itemDTO.getId())
                .name(itemDTO.getName())
                .imgPath(itemDTO.getImgPath())
                .price(itemDTO.getPrice())
                .discountPer(itemDTO.getDiscountPer())
                .build();
    }

}
