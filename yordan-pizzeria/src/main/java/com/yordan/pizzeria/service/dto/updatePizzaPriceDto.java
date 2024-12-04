package com.yordan.pizzeria.service.dto;

import lombok.Data;

@Data
public class updatePizzaPriceDto {
    private int idPizza;
    private double newPrice;
}
