package com.example.busreservation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Bus {
    @Id
    private Long bus_id;

    private String source;
    private String destination;
    private int seats;
    private double distance;
    private String type;
    private BigDecimal price;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date departureDate;
    private String duration;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date arrivalDate;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.REMOVE)
    private List<Tickets> tickets;
}
