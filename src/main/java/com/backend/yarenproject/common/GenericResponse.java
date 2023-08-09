package com.backend.yarenproject.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //--> argüman alan constructor oluşturup mesaj alma kısmını kolay yapabiliriz
public class GenericResponse
{
    private String message;
}
