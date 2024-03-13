package com.example.simpleapi.controller;

import com.example.simpleapi.exception.ItemNotFoundException;
import com.example.simpleapi.model.Item;
import com.example.simpleapi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable Long itemId) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);

        if (itemOptional.isPresent()) {
            return new ResponseEntity<>(itemOptional.get(), HttpStatus.OK);
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + itemId);
        }
    }
    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody Item item) {
        Item savedItem = itemRepository.save(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable Long itemId, @RequestBody Item updatedItem) {
        Optional<Item> existingItemOptional = itemRepository.findById(itemId);

        if (existingItemOptional.isPresent()) {
            Item existingItem = existingItemOptional.get();
            existingItem.setNome(updatedItem.getNome());
            Item savedItem = itemRepository.save(existingItem);
            return new ResponseEntity<>(savedItem, HttpStatus.NO_CONTENT);
        } else {
            throw new ItemNotFoundException("Item not found with ID: " + itemId);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}