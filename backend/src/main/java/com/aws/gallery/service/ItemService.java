package com.aws.gallery.service;

import com.aws.gallery.dto.ResponseItemDTO;
import com.aws.gallery.entity.Item;
import com.aws.gallery.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ResponseItemDTO> findAll() {
        List<Item> itemList = itemRepository.findAll();
        List<ResponseItemDTO> itemDTOList = new ArrayList<ResponseItemDTO>();
        for (Item item : itemList) {
            itemDTOList.add(ResponseItemDTO.toResponseItemDTO(item));
        }

        return itemDTOList;
    }
}
