package org.gallery.backend.controller;

import lombok.RequiredArgsConstructor;
import org.gallery.backend.dto.ItemDTO;
import org.gallery.backend.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/items")
    public ResponseEntity<List<ItemDTO>> getItems() {
        List<ItemDTO> itemDTOList = itemService.findAll();

        return ResponseEntity.ok()
                .body(itemDTOList);
    }
}
