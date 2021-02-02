package com.digital.crud.saladereuniao.service;

import com.digital.crud.saladereuniao.exceptions.ResourceNotFoundException;
import com.digital.crud.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.repository.IRoomRepository;
import com.digital.crud.saladereuniao.utils.Mensagens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    @Autowired
    private IRoomRepository repository;

    @Transactional
    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    @Transactional
    public Room getRoomById(Long roomId) {
        Room room = getRoom(roomId, Mensagens.MSG_NOT_FOUND_ROOM);
        return room;
    }

    @Transactional
    public Room createRoom(Room room) {
        return repository.save(room);
    }

    @Transactional
    public Room updateRoom(Long roomId, Room roomDetails) {
        Room room = getRoom(roomId, Mensagens.MSG_NOT_FOUND_ROOM_ID);

        room.setNome(roomDetails.getNome());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room updateRoom = repository.save(room);
        return updateRoom;
    }

    @Transactional
    public Map<String, Boolean> deleteRoom(Long roomId, String opStr, Boolean opBol) {
        Room room = getRoom(roomId, Mensagens.MSG_NOT_FOUND_THIS_ID);

        repository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    private Room getRoom(Long roomId, String message) {
        return repository.findById(roomId)
                .orElseThrow(() -> new ResourceNotFoundException(message + roomId));
    }
}
