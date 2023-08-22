package com.backend.yarenproject.common;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor // Argüman alan constructor oluşturup mesaj alma kısmı kolay yapılabilir
public class GenericResponse
{
    private String message;
}