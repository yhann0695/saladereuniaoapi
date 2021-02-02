package com.digital.crud.saladereuniao.controller;

import com.digital.crud.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> allRooms = service.getAllRooms();
        return ResponseEntity.ok(allRooms);
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") Long roomId) {
        Room room = service.getRoomById(roomId);
        return ResponseEntity.ok(room);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> createRoom(@Valid @RequestBody Room room) {
        Room roomSave = service.createRoom(room);
        return ResponseEntity.ok(roomSave);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId,
                                           @Valid @RequestBody Room roomDetails) {

        Room room = service.updateRoom(roomId, roomDetails);
        return ResponseEntity.ok(room);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteRoom(@PathVariable(value = "id") Long roomId,
                                                           String opStr, Boolean opBol) {

        return ResponseEntity.ok(service.deleteRoom(roomId,opStr ,opBol));
    }

}
