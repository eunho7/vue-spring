package com.aws.gallery.controller;

import com.aws.gallery.dto.ResponseItemDTO;
import com.aws.gallery.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemApiController {

    private final ItemService itemService;

    @GetMapping("/api/items")
    public ResponseEntity getItems() {
        List<ResponseItemDTO> items = itemService.findAll();

        return ResponseEntity.ok()
                .body(items);
    }
}
