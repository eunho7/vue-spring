package org.gallery.backend.service;

import lombok.RequiredArgsConstructor;
import org.gallery.backend.dto.ItemDTO;
import org.gallery.backend.entity.Item;
import org.gallery.backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public List<ItemDTO> findAll() {
        List<Item> itemList = itemRepository.findAll();

        List<ItemDTO> itemDTOList = new ArrayList<>();
        for(Item item : itemList) itemDTOList.add(ItemDTO.toItemDTO(item));

        return itemDTOList;
    }
}
