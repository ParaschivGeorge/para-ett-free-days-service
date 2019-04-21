package com.paraett.freedaysservice.controller;

import com.paraett.freedaysservice.model.entities.FreeDay;
import com.paraett.freedaysservice.service.FreeDayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/free-days")
public class FreeDaysController {
    private FreeDayService freeDayService;

    public FreeDaysController(FreeDayService freeDayService) {
        this.freeDayService = freeDayService;
    }

    @GetMapping("")
    public ResponseEntity<List<FreeDay>> getAllFreeDays(@RequestParam(required = false) Long companyId) {
        List<FreeDay> freeDays = freeDayService.getAllFreeDays(companyId);

        return ResponseEntity.ok(freeDays);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreeDay> getFreeDay(@PathVariable Long id) {
        FreeDay freeDay = freeDayService.getFreeDay(id);

        return ResponseEntity.ok(freeDay);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFreeDay(@PathVariable Long id) {
        freeDayService.deleteFreeDay(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Object> createFreeDay(@RequestBody FreeDay freeDay) {
        FreeDay createdFreeDay = freeDayService.createFreeDay(freeDay);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdFreeDay.getId())
                .toUri();

        return ResponseEntity.created(location).body(freeDay);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreeDay> updateFreeDay(@PathVariable Long id, @RequestBody FreeDay freeDay) {
        FreeDay updatedFreeDay = freeDayService.updateFreeDay(id, freeDay);

        return ResponseEntity.accepted().body(updatedFreeDay);
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteFreeDays(@RequestParam(required = false) Long companyId) {
        freeDayService.deleteFreeDays(companyId);

        return ResponseEntity.noContent().build();
    }
}
