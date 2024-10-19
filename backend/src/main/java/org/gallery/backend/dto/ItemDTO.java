package org.gallery.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gallery.backend.entity.Item;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private String imgPath;
    private int price;
    private int discountPer;

    public static ItemDTO toItemDTO(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .imgPath(item.getImgPath())
                .price(item.getPrice())
                .discountPer(item.getDiscountPer())
                .build();
    }
}
