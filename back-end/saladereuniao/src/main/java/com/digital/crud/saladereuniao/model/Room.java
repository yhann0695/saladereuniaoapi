package com.digital.crud.saladereuniao.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "MEETINGROOM")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Room implements Serializable {

    public Room() {}

    public Room(Long id, String nome, String date, String startHour, String endHour) {
        this.id = id;
        this.nome = nome;
        this.date = date;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "CO_ROOM")
    private Long id;

    @Column(name = "NO_ROOM")
    private String nome;

    @NotNull
    @Column(name = "DT_ROOM")
    private String date;

    @NotNull
    @Column(name = "HR_START_ROOM")
    private String startHour;

    @NotNull
    @Column(name = "HR_END_ROOM")
    private String endHour;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", date='" + date + '\'' +
                ", startHour='" + startHour + '\'' +
                ", endHour='" + endHour + '\'' +
                '}';
    }
}
