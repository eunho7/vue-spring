package com.aws.gallery.dto;

import com.aws.gallery.entity.Item;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseItemDTO {
    private int id;
    private String name;
    private String imgPath;
    private int price;
    private int discountPer;

    public static ResponseItemDTO toResponseItemDTO(Item item) {
        return ResponseItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .imgPath(item.getImgPath())
                .price(item.getPrice())
                .discountPer(item.getDiscountPer())
                .build();
    }
}
