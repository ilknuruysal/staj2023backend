package com.backend.yarenproject.error;

import lombok.Data;
import java.util.Date;
import java.util.Map;

@Data
public class ApiError
{
    private int errorStatusCode;
    private String errorMessage;
    private String errorPath;
    private long timestamp = new Date().getTime();
    private Map <String,String> validationErrors; // json obj. old. için getter setter lazım o yüzden @Data kullanılır

    public ApiError(int errorStatusCode, String errorMessage, String errorPath) // Özel bir constructor
    {
        this.errorStatusCode = errorStatusCode;
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
    }
}